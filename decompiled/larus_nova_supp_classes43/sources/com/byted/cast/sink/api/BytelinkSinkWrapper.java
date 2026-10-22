package com.byted.cast.sink.api;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.byted.cast.common.CastLogger;
import com.byted.cast.common.CastMonitor;
import com.byted.cast.common.ContextManager;
import com.byted.cast.common.MD5;
import com.byted.cast.common.MainThreadExecutor;
import com.byted.cast.common.NetworkUtil;
import com.byted.cast.common.api.CodecType;
import com.byted.cast.common.api.IActionListener;
import com.byted.cast.common.api.IAudioDataListener;
import com.byted.cast.common.api.IBrowseDataListener;
import com.byted.cast.common.api.ICastSink;
import com.byted.cast.common.api.IMediaServiceListener;
import com.byted.cast.common.api.IMonitor;
import com.byted.cast.common.api.IReverseControl;
import com.byted.cast.common.api.ISendResultListener;
import com.byted.cast.common.api.ISinkDataListener;
import com.byted.cast.common.api.cloud.ICastIdListener;
import com.byted.cast.common.api.multiple.IMultipleActiveControl;
import com.byted.cast.common.api.multiple.IMultipleLoader;
import com.byted.cast.common.bean.DeviceInfo;
import com.byted.cast.common.config.Config;
import com.byted.cast.common.config.IInitListener;
import com.byted.cast.common.network.NetworkMonitor;
import com.byted.cast.common.sink.IMessageListener;
import com.byted.cast.common.sink.IMirrorListener;
import com.byted.cast.common.sink.ISourceDeviceInfoListener;
import com.byted.cast.common.sink.ServiceInfo;
import com.byted.cast.common.sink.Statistics;
import com.byted.cast.sdk.RTCError;
import com.byted.cast.sdk.RTCStatistics;
import com.byted.cast.sink.api.multiple.IMultipleReverseControl;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class BytelinkSinkWrapper implements ICastSink, IOnLogMonitor {
    private static final long ONE_SECOND_US = 1000000;
    private static final int STATE_CASTING = 102;
    private static final int STATE_IDLE = 100;
    private static final int STATE_READY_TO_CAST = 101;
    private static final String TAG = "BytelinkSinkWrapper";
    private boolean bUseOldInterface;
    private int mAVSyncType;
    private Application mApplication;
    private IAudioDataListener mAudioDataListener;
    private Boolean mAutoPlayAudio;
    private String mBrowseId;
    private ByteLinkSink mByteLinkSink;
    private Boolean mCallbackDataToUser;
    private ContextManager.CastContext mCastContext;
    private com.byted.cast.common.sink.ClientInfo mClientInfo;
    private String mConnectId;
    private Context mContext;
    private Boolean mEnablePlaying;
    private Boolean mEnableVideoNativeDecode;
    private long mFirstVideoFrameTimeMs;
    private boolean mIsBinded;
    private IMultipleLoader mLoader;
    private CastLogger mLogger;
    private Boolean mMediaRenderExists;
    private IMediaServiceListener mMediaServiceListener;
    private IMessageListener mMessageListener;
    private IMirrorListener mMirrorListener;
    private CastMonitor mMonitor;
    private IMultipleActiveControl mMultiActiveControl;
    private NetworkMonitor mNetworkMonitor;
    private int mRenderMode;
    private com.byted.cast.common.api.IServerListener mServerListener;
    private String mServiceName;
    private ISinkDataListener mSinkDataListener;
    private String mSourceMirrorVersion;
    private int mState;
    private boolean mUseUdpPath;
    private long mVideoStartTimeMs;
    private WifiManager.WifiLock mWifiLock;
    private WifiManager mWifiManager;
    MainThreadExecutor mainThreadExecutor;
    private com.byted.cast.sink.api.multiple.IMultipleActiveControl multiactivecontrol;
    private com.byted.cast.sink.api.multiple.IMultipleLoader multipleLoader;
    private IMultipleReverseControl multipleReverseCtrl;
    private IServerListener serverListener;

    public class a implements IMirrorListener {
        final /* synthetic */ BytelinkSinkWrapper a;

        public a(BytelinkSinkWrapper r1) {
            this.a = r1;
        }

        public void onAudioOutput(String r13, CodecType.ACODEC_ID r14, byte[] r15, int r16, int r17, int r18, int r19, long r20) {
            if (r14 != CodecType.ACODEC_ID.AUTO) goto L8;
            if (BytelinkSinkWrapper.access$200(this.a) == null) goto L8;
            BytelinkSinkWrapper.access$200(this.a).onAudioOutput(r13, r15, r16, r17, r18, r19, r20);
            return;
        L8:
            if (BytelinkSinkWrapper.access$300(this.a) == null) goto L12;
            BytelinkSinkWrapper.access$300(this.a).onAudioOutput(r13, r14, r15, r16, r17, r18, r19, r20);
            return;
        }

        public void onCast(int r1, com.byted.cast.common.sink.CastInfo r10) {
        }

        public void onError(String r1, int r10, String r11) {
        }

        public void onInviteResult(boolean r1) {
        }

        public void onNotifyLatency(String r10, Long r11, HashMap<String, Long> r12) {
            if (BytelinkSinkWrapper.access$300(this.a) == null) goto L6;
            BytelinkSinkWrapper.access$300(this.a).onNotifyLatency(r10, r11, r12);
            return;
        }

        public void onSinkLatencyStat(int r1, String r10, String r11) {
        }

        public void onSinkStuckStat(int r1, String r10, String r11) {
        }

        public void onStatistics(Statistics r1) {
        }

        public void onVideoOutput(String r12, CodecType.VCODEC_ID r13, byte[] r14, int r15, int r16, long r17, int r19) {
            if (BytelinkSinkWrapper.access$300(this.a) == null) goto L6;
            BytelinkSinkWrapper.access$300(this.a).onVideoOutput(r12, r13, r14, r15, r16, r17, r19);
            return;
        }

        public void onVolume(String r10, int r11) {
            if (BytelinkSinkWrapper.access$000(this.a) == null) goto L5;
            BytelinkSinkWrapper.access$000(this.a).onVolume(r10, r11);
        L5:
            BytelinkSinkWrapper.access$100(this.a).d("onVolume:" + r10 + r11);
        }
    }

    public class b implements IAudioDataListener {
        final /* synthetic */ BytelinkSinkWrapper a;

        public b(BytelinkSinkWrapper r1) {
            this.a = r1;
        }

        public void onAudioOutput(String r13, byte[] r14, int r15, int r16, int r17, int r18, long r19) {
            if (BytelinkSinkWrapper.access$400(this.a) == false) goto L5;
            return;
        L5:
            if (BytelinkSinkWrapper.access$500(this.a) == null) goto L9;
            BytelinkSinkWrapper.access$500(this.a).onAudioOutput(r13, CodecType.ACODEC_ID.AUTO, r14, r15, r16, r17, r18, r19);
            return;
        }
    }

    public class c implements ISinkDataListener {
        final /* synthetic */ BytelinkSinkWrapper a;

        public c(BytelinkSinkWrapper r1) {
            this.a = r1;
        }

        public void onAudioOutput(String r13, CodecType.ACODEC_ID r14, byte[] r15, int r16, int r17, int r18, int r19, long r20) {
            if (BytelinkSinkWrapper.access$400(this.a) == false) goto L5;
            return;
        L5:
            if (BytelinkSinkWrapper.access$500(this.a) == null) goto L9;
            BytelinkSinkWrapper.access$500(this.a).onAudioOutput(r13, r14, r15, r16, r17, r18, r19, r20);
            return;
        }

        public void onNotifyLatency(String r10, Long r11, HashMap<String, Long> r12) {
            if (BytelinkSinkWrapper.access$400(this.a) == false) goto L5;
            return;
        L5:
            if (BytelinkSinkWrapper.access$500(this.a) == null) goto L9;
            BytelinkSinkWrapper.access$500(this.a).onNotifyLatency(r10, r11, r12);
            return;
        }

        public void onVideoOutput(String r12, CodecType.VCODEC_ID r13, byte[] r14, int r15, int r16, long r17, int r19) {
            if (BytelinkSinkWrapper.access$400(this.a) == false) goto L5;
            return;
        L5:
            if (BytelinkSinkWrapper.access$500(this.a) == null) goto L9;
            BytelinkSinkWrapper.access$500(this.a).onVideoOutput(r12, r13, r14, r15, r16, r17, r19);
            return;
        }

        public final /* synthetic */ void onVideoRenderTimeInfo(String r1, long r10, long r11) {
            ISinkDataListener.-CC.$default$onVideoRenderTimeInfo(this, r1, r10, r11);
        }
    }

    public class d implements NetworkMonitor.INetworkChangeListener {
        final /* synthetic */ BytelinkSinkWrapper a;

        public d(BytelinkSinkWrapper r1) {
            this.a = r1;
        }

        public void onAvailable(NetworkUtil.NetworkType r1, NetworkUtil.NetworkType r10) {
            BytelinkSinkWrapper.access$600(this.a);
        }

        public void onLost(NetworkUtil.NetworkType r1) {
        }
    }

    public class e implements IServerListener {
        final /* synthetic */ BytelinkSinkWrapper a;

        public class a implements Runnable {
            final /* synthetic */ ServerInfo a;
            final /* synthetic */ int b;
            final /* synthetic */ e c;

            public a(e r1, ServerInfo r10, int r11) {
                this.c = r1;
                this.a = r10;
                this.b = r11;
            }

            public void com_byted_cast_sink_api_BytelinkSinkWrapper$e$a__run$___twin___() {
                if (this.a != null) goto L10;
                JSONObject r0 = new JSONObject();
                r0.put("what", IServerListener.WHAT_BYTELINK_SINK_ERROR);     // Catch: JSONException -> L7
                r0.put("code", RTCError.ERROR_SERVER_SERVICEINFO_NULL);     // Catch: JSONException -> L7
                r0.put(MessageIndication.MESSAGE_TYPE_MSG, "serviceinfo is null");     // Catch: JSONException -> L7
                r0.put("serviceId", this.b);     // Catch: JSONException -> L7
                r0.put("protocol", "ByteLink");     // Catch: JSONException -> L7
                BytelinkSinkWrapper.access$700(this.c.a, "bytecast_start_server_failure", r0);     // Catch: JSONException -> L7
                return;
            L7:
                e = move-exception;
                e.printStackTrace();
                return;
            L10:
                com.byted.cast.common.sink.ServerInfo r1 = new com.byted.cast.common.sink.ServerInfo();
                ServerInfo r10 = this.a;
                r1.surfaceType = r10.surfaceType;
                r1.showFps = r10.showFps;
                r1.serviceStatus = r10.serviceStatus;
                r1.serverPort = r10.serverPort;
                r1.resolution = r10.resolution;
                r1.remotePort = r10.remotePort;
                r1.playerType = r10.playerType;
                r1.networkName = r10.networkName;
                r1.netDelay = r10.netDelay;
                r1.maxFps = r10.maxFps;
                r1.localPreemptModel = r10.localPreemptModel;
                r1.language = r10.language;
                r1.forceResetMirrorPlayer = r10.forceResetMirrorPlayer;
                r1.displayMode = r10.displayMode;
                r1.deviceName = r10.deviceName;
                r1.cloudPreemptModel = r10.cloudPreemptModel;
                r1.aliasName = "ByteLink";
                BytelinkSinkWrapper.access$800(this.c.a).onStart(this.b, r1);
                JSONObject r11 = new JSONObject();
                r11.put("serviceId", this.b);     // Catch: JSONException -> L15
                r11.put("serviceInfo", r1);     // Catch: JSONException -> L15
                r11.put("protocol", "ByteLink");     // Catch: JSONException -> L15
                r11.put("serverPort", r1.serverPort);     // Catch: JSONException -> L15
                BytelinkSinkWrapper.access$700(this.c.a, "bytecast_start_server_success", r11);     // Catch: JSONException -> L15
                return;
            L15:
                e = move-exception;
                e.printStackTrace();
            }

            @Override // java.lang.Runnable
            public void run() {
                com_byted_cast_sink_api_BytelinkSinkWrapper$e$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
            }

            @Skip({"com.ss.android.ugc.bytex.pthread+"})
            public static void com_byted_cast_sink_api_BytelinkSinkWrapper$e$a_com_larus_apm_impl_protector_RunnableLancet_run(a r1) {
                r1.com_byted_cast_sink_api_BytelinkSinkWrapper$e$a__run$___twin___();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public class b implements Runnable {
            final /* synthetic */ int a;
            final /* synthetic */ e b;

            public b(e r1, int r10) {
                this.b = r1;
                this.a = r10;
            }

            public void com_byted_cast_sink_api_BytelinkSinkWrapper$e$b__run$___twin___() {
                BytelinkSinkWrapper.access$800(this.b.a).onStop(this.a);
                JSONObject r0 = new JSONObject();
                r0.put("serviceId", this.a);     // Catch: JSONException -> L5
                BytelinkSinkWrapper.access$700(this.b.a, "bytelink_server_onStop", r0);     // Catch: JSONException -> L5
                return;
            L5:
                e = move-exception;
                e.printStackTrace();
            }

            @Override // java.lang.Runnable
            public void run() {
                com_byted_cast_sink_api_BytelinkSinkWrapper$e$b_com_larus_apm_impl_protector_RunnableLancet_run(this);
            }

            @Skip({"com.ss.android.ugc.bytex.pthread+"})
            public static void com_byted_cast_sink_api_BytelinkSinkWrapper$e$b_com_larus_apm_impl_protector_RunnableLancet_run(b r1) {
                r1.com_byted_cast_sink_api_BytelinkSinkWrapper$e$b__run$___twin___();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public class c implements Runnable {
            final /* synthetic */ int a;
            final /* synthetic */ int b;
            final /* synthetic */ int c;
            final /* synthetic */ String d;
            final /* synthetic */ e e;

            public c(e r1, int r10, int r11, int r12, String r13) {
                this.e = r1;
                this.a = r10;
                this.b = r11;
                this.c = r12;
                this.d = r13;
            }

            public void com_byted_cast_sink_api_BytelinkSinkWrapper$e$c__run$___twin___() {
                BytelinkSinkWrapper.access$800(this.e.a).onError(this.a, this.b, this.c);
                JSONObject r0 = new JSONObject();
                r0.put("what", this.b);     // Catch: JSONException -> L17
                r0.put("code", this.c);     // Catch: JSONException -> L17
                r0.put(MessageIndication.MESSAGE_TYPE_MSG, this.d);     // Catch: JSONException -> L17
                r0.put("serviceId", this.a);     // Catch: JSONException -> L17
                r0.put("protocol", "ByteLink");     // Catch: JSONException -> L17
                if (this.b == 1000) goto L12;
            L15:
                BytelinkSinkWrapper r1 = this.e.a;     // Catch: JSONException -> L17
                String r10 = "bytelink_onError";
            L14:
                BytelinkSinkWrapper.access$700(r1, r10, r0);     // Catch: JSONException -> L17
                return;
            L12:
                if (this.c != 10010001) goto L15;
                r1 = this.e.a;     // Catch: JSONException -> L17
                r10 = "bytecast_start_server_failure";
            L17:
                e = move-exception;
                e.printStackTrace();
            }

            @Override // java.lang.Runnable
            public void run() {
                com_byted_cast_sink_api_BytelinkSinkWrapper$e$c_com_larus_apm_impl_protector_RunnableLancet_run(this);
            }

            @Skip({"com.ss.android.ugc.bytex.pthread+"})
            public static void com_byted_cast_sink_api_BytelinkSinkWrapper$e$c_com_larus_apm_impl_protector_RunnableLancet_run(c r1) {
                r1.com_byted_cast_sink_api_BytelinkSinkWrapper$e$c__run$___twin___();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public class d implements Runnable {
            final /* synthetic */ CastInfo a;
            final /* synthetic */ int b;
            final /* synthetic */ e c;

            public d(e r1, CastInfo r10, int r11) {
                this.c = r1;
                this.a = r10;
                this.b = r11;
            }

            public void com_byted_cast_sink_api_BytelinkSinkWrapper$e$d__run$___twin___() {
                CastInfo r0 = this.a;
                r0.protocol = 3;
                com.byted.cast.common.sink.CastInfo r1 = BytelinkSinkWrapper.access$1100(this.c.a, r0);
                BytelinkSinkWrapper.access$100(this.c.a).d(BytelinkSinkWrapper.TAG, "onCast, castInfo: " + this.a + " infoType:" + this.a.infoType);
                BytelinkSinkWrapper.access$100(this.c.a).d(BytelinkSinkWrapper.TAG, "onCast, info: " + r1 + " hashcode:" + r1.hashCode());
                JSONObject r10 = new JSONObject();
                r10.put("castInfo", r1);     // Catch: JSONException -> L25
                r10.put("protocol", "ByteLink");     // Catch: JSONException -> L25
                r10.put("userId", MD5.hexdigest(this.a.clientID.split("_")[0].trim()));     // Catch: JSONException -> L25
                int r11 = this.a.infoType;     // Catch: JSONException -> L25
                long r12 = 0;
                if (r11 != 100) goto L14;
                BytelinkSinkWrapper.access$1202(this.c.a, 0);     // Catch: JSONException -> L25
                BytelinkSinkWrapper.access$1302(this.c.a, System.nanoTime() / BytelinkSinkWrapper.ONE_SECOND_US);     // Catch: JSONException -> L25
                com.byted.cast.common.sink.CastInfo.StartInfo r13 = r1.startInfo;     // Catch: JSONException -> L25
                if (r13 != null) goto L10;
                r1.startInfo = new com.byted.cast.common.sink.CastInfo.StartInfo(System.currentTimeMillis());     // Catch: JSONException -> L25
            L11:
                BytelinkSinkWrapper r14 = this.c.a;     // Catch: JSONException -> L25
                String r15 = "bytecast_on_cast_request";
            L12:
                BytelinkSinkWrapper.access$700(r14, r15, r10);     // Catch: JSONException -> L25
            L23:
                BytelinkSinkWrapper.access$700(this.c.a, "bytelink_onCast", r10);     // Catch: JSONException -> L25
            L27:
                BytelinkSinkWrapper.access$800(this.c.a).onCast(this.b, r1);
                return;
            L10:
                r13.startTime = System.currentTimeMillis();     // Catch: JSONException -> L25
                goto L11
            L14:
                if (r11 != 102) goto L23;
                long r16 = System.nanoTime() / BytelinkSinkWrapper.ONE_SECOND_US;     // Catch: JSONException -> L25
                if (BytelinkSinkWrapper.access$1200(this.c.a) == 0) goto L22;
                long r17 = r16 - BytelinkSinkWrapper.access$1200(this.c.a);     // Catch: JSONException -> L25
                if (r17 < 0) goto L22;
                r12 = r17;
            L22:
                r1.stopInfo.stopTime = System.currentTimeMillis();     // Catch: JSONException -> L25
                r10.put("total_duration", r12);     // Catch: JSONException -> L25
                r14 = this.c.a;     // Catch: JSONException -> L25
                r15 = "bytecast_oncast_stop";
            L25:
                e = move-exception;
                e.printStackTrace();
                goto L27
            }

            @Override // java.lang.Runnable
            public void run() {
                com_byted_cast_sink_api_BytelinkSinkWrapper$e$d_com_larus_apm_impl_protector_RunnableLancet_run(this);
            }

            @Skip({"com.ss.android.ugc.bytex.pthread+"})
            public static void com_byted_cast_sink_api_BytelinkSinkWrapper$e$d_com_larus_apm_impl_protector_RunnableLancet_run(d r1) {
                r1.com_byted_cast_sink_api_BytelinkSinkWrapper$e$d__run$___twin___();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        /* JADX INFO: renamed from: com.byted.cast.sink.api.BytelinkSinkWrapper$e$e, reason: collision with other inner class name */
        public class RunnableC0012e implements Runnable {
            final /* synthetic */ ClientInfo a;
            final /* synthetic */ int b;
            final /* synthetic */ e c;

            public RunnableC0012e(e r1, ClientInfo r10, int r11) {
                this.c = r1;
                this.a = r10;
                this.b = r11;
            }

            public void com_byted_cast_sink_api_BytelinkSinkWrapper$e$e__run$___twin___() {
                if (this.a == null) goto L5;
                com.byted.cast.common.sink.ClientInfo r0 = new com.byted.cast.common.sink.ClientInfo();
                ClientInfo r1 = this.a;
                r0.clientID = r1.clientID;
                r0.ip = r1.ip;
                r0.name = r1.name;
                r0.mirrorSourceType = r1.mirrorSourceType;
            L7:
                if (BytelinkSinkWrapper.access$800(this.c.a) == null) goto L9;
                BytelinkSinkWrapper.access$800(this.c.a).onConnect(this.b, r0);
            L9:
                BytelinkSinkWrapper.access$100(this.c.a).d("ServerListener", "on connect id:" + this.b + ",info:" + r0);
                BytelinkSinkWrapper.access$1402(this.c.a, r0);
                return;
            L5:
                r0 = null;
                goto L7
            }

            @Override // java.lang.Runnable
            public void run() {
                com_byted_cast_sink_api_BytelinkSinkWrapper$e$e_com_larus_apm_impl_protector_RunnableLancet_run(this);
            }

            @Skip({"com.ss.android.ugc.bytex.pthread+"})
            public static void com_byted_cast_sink_api_BytelinkSinkWrapper$e$e_com_larus_apm_impl_protector_RunnableLancet_run(RunnableC0012e r1) {
                r1.com_byted_cast_sink_api_BytelinkSinkWrapper$e$e__run$___twin___();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public class f implements Runnable {
            final /* synthetic */ ClientInfo a;
            final /* synthetic */ int b;
            final /* synthetic */ e c;

            public f(e r1, ClientInfo r10, int r11) {
                this.c = r1;
                this.a = r10;
                this.b = r11;
            }

            public void com_byted_cast_sink_api_BytelinkSinkWrapper$e$f__run$___twin___() {
                if (this.a == null) goto L5;
                com.byted.cast.common.sink.ClientInfo r0 = new com.byted.cast.common.sink.ClientInfo();
                ClientInfo r1 = this.a;
                r0.clientID = r1.clientID;
                r0.ip = r1.ip;
                r0.name = r1.name;
                r0.mirrorSourceType = r1.mirrorSourceType;
            L7:
                if (BytelinkSinkWrapper.access$800(this.c.a) == null) goto L9;
                BytelinkSinkWrapper.access$800(this.c.a).onDisconnect(this.b, r0);
            L9:
                BytelinkSinkWrapper.access$100(this.c.a).d("ServerListener", "on disconnect id:" + this.b + ",info:" + r0);
                JSONObject r10 = new JSONObject();
                r10.put("clientInfo", r0);     // Catch: JSONException -> L12
                BytelinkSinkWrapper.access$700(this.c.a, "bytelink_onDisConnect", r10);     // Catch: JSONException -> L12
                return;
            L12:
                e = move-exception;
                e.printStackTrace();
                return;
            L5:
                r0 = null;
                goto L7
            }

            @Override // java.lang.Runnable
            public void run() {
                com_byted_cast_sink_api_BytelinkSinkWrapper$e$f_com_larus_apm_impl_protector_RunnableLancet_run(this);
            }

            @Skip({"com.ss.android.ugc.bytex.pthread+"})
            public static void com_byted_cast_sink_api_BytelinkSinkWrapper$e$f_com_larus_apm_impl_protector_RunnableLancet_run(f r1) {
                r1.com_byted_cast_sink_api_BytelinkSinkWrapper$e$f__run$___twin___();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public class g implements Runnable {
            final /* synthetic */ ClientInfo a;
            final /* synthetic */ String b;
            final /* synthetic */ e c;

            public g(e r1, ClientInfo r10, String r11) {
                this.c = r1;
                this.a = r10;
                this.b = r11;
            }

            public void com_byted_cast_sink_api_BytelinkSinkWrapper$e$g__run$___twin___() {
                ServiceInfo r0 = new ServiceInfo();
                ClientInfo r1 = this.a;
                r0.ip = r1.ip;
                r0.name = r1.name;
                BytelinkSinkWrapper.access$1800(this.c.a).onMessage(r0, this.b);
            }

            @Override // java.lang.Runnable
            public void run() {
                com_byted_cast_sink_api_BytelinkSinkWrapper$e$g_com_larus_apm_impl_protector_RunnableLancet_run(this);
            }

            @Skip({"com.ss.android.ugc.bytex.pthread+"})
            public static void com_byted_cast_sink_api_BytelinkSinkWrapper$e$g_com_larus_apm_impl_protector_RunnableLancet_run(g r1) {
                r1.com_byted_cast_sink_api_BytelinkSinkWrapper$e$g__run$___twin___();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public e(BytelinkSinkWrapper r1) {
            this.a = r1;
        }

        private /* synthetic */ void a(int r10, String r11, String r12) {
            if (BytelinkSinkWrapper.access$800(this.a) == null) goto L17;
            BytelinkSinkWrapper.access$800(this.a).onSinkLatencyStat(r10, r11, r12);
            Config r13 = ContextManager.getConfigManager(BytelinkSinkWrapper.access$1900(this.a)).getInitConfig();
            if (r13 == null) goto L7;
            IMonitor r14 = r13.getMonitor();
        L8:
            if (r14 != null) goto L15;
            return;
        L15:
            r14.onAppLogEvent("p2p_rtc_transfer_stats", new JSONObject(r12));     // Catch: JSONException -> L12
            return;
        L12:
            e = move-exception;
            e.printStackTrace();
            return;
        L7:
            r14 = null;
            goto L8
        }

        public static /* synthetic */ void a(e r0, int r1, String r10, String r11) {
            r0.b(r1, r10, r11);
        }

        private /* synthetic */ void b(int r10, String r11, String r12) {
            if (BytelinkSinkWrapper.access$800(this.a) == null) goto L6;
            BytelinkSinkWrapper.access$800(this.a).onSinkStuckStat(r10, r11, r12);
            return;
        }

        public static /* synthetic */ void b(e r0, int r1, String r10, String r11) {
            r0.a(r1, r10, r11);
        }

        @Override // com.byted.cast.sink.api.IServerListener
        public void onCast(int r10, CastInfo r11) {
            BytelinkSinkWrapper.access$100(this.a).i(BytelinkSinkWrapper.TAG, "onCast, id:" + r10 + ", " + r11 + ", infoType:" + r11.infoType + ", data:" + r11.infoData);
            switch(r11.infoType) {
                case 100: goto L11;
                case 101: goto L10;
                case 102: goto L5;
                default: goto L18;
            };
        L5:
            BytelinkSinkWrapper.access$902(this.a, 100);
            if (BytelinkSinkWrapper.access$1000(this.a) == null) goto L21;
            BytelinkSinkWrapper.access$100(this.a).d(BytelinkSinkWrapper.TAG, "onCast, release WifiLock");     // Catch: Exception -> L16
            BytelinkSinkWrapper.access$1000(this.a).release();     // Catch: Exception -> L16
        L21:
            goto L18
        L10:
            BytelinkSinkWrapper.access$902(this.a, 102);
            goto L18
        L11:
            BytelinkSinkWrapper.access$902(this.a, 101);
            if (BytelinkSinkWrapper.access$1000(this.a) == null) goto L21;
            BytelinkSinkWrapper.access$100(this.a).d(BytelinkSinkWrapper.TAG, "onCast, acquire WifiLock");     // Catch: Exception -> L16
            BytelinkSinkWrapper.access$1000(this.a).acquire();     // Catch: Exception -> L16
        L18:
            if (BytelinkSinkWrapper.access$800(this.a) == null) goto L24;
            this.a.mainThreadExecutor.execute(new d(this, r11, r10));
            return;
        }

        @Override // com.byted.cast.sink.api.IServerListener
        public void onConnect(int r10, ClientInfo r11) {
            BytelinkSinkWrapper.access$100(this.a).d(BytelinkSinkWrapper.TAG, "onConnect, id:" + r10);
            this.a.mainThreadExecutor.execute(new RunnableC0012e(this, r11, r10));
        }

        @Override // com.byted.cast.sink.api.IServerListener
        public void onDisconnect(int r10, ClientInfo r11) {
            BytelinkSinkWrapper.access$100(this.a).d(BytelinkSinkWrapper.TAG, "onDisconnect, id:" + r10);
            this.a.mainThreadExecutor.execute(new f(this, r11, r10));
        }

        @Override // com.byted.cast.sink.api.IServerListener
        public void onError(int r10, int r11, int r12, String r13) {
            BytelinkSinkWrapper.access$100(this.a).d(BytelinkSinkWrapper.TAG, "onError, serviceId:" + r10 + ", what:" + r11 + ", extra:" + r12);
            if (BytelinkSinkWrapper.access$800(this.a) == null) goto L6;
            this.a.mainThreadExecutor.execute(new c(this, r10, r11, r12, r13));
            return;
        }

        @Override // com.byted.cast.sink.api.IServerListener
        public void onFirstVideoFrame(String r10) {
            BytelinkSinkWrapper.access$100(this.a).i(BytelinkSinkWrapper.TAG, "onFirstVideoFrame");
            BytelinkSinkWrapper.access$1202(this.a, System.nanoTime() / BytelinkSinkWrapper.ONE_SECOND_US);
            long r0 = BytelinkSinkWrapper.access$1200(this.a) - BytelinkSinkWrapper.access$1300(this.a);
            if (r0 <= 10000) goto L5;
            r0 = 1;
        L5:
            JSONObject r11 = new JSONObject();
            r11.put("total_delay", r0);     // Catch: JSONException -> L10
            r11.put("protocol", "ByteLink");     // Catch: JSONException -> L10
            r11.put("userId", MD5.hexdigest(r10));     // Catch: JSONException -> L10
            BytelinkSinkWrapper.access$700(this.a, "loadMirror", r11);     // Catch: JSONException -> L10
            return;
        L10:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // com.byted.cast.sink.api.IServerListener
        public void onMonitorEvent(String r10, String r11) {
            JSONObject r0 = new JSONObject(r11);     // Catch: JSONException -> L4
            BytelinkSinkWrapper.access$700(this.a, r10, r0);     // Catch: JSONException -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // com.byted.cast.sink.api.IServerListener
        public void onRecvMetaData(int r10, ClientInfo r11, String r12) {
            BytelinkSinkWrapper.access$100(this.a).i(BytelinkSinkWrapper.TAG, "onRecvMetaData, meta:" + r12);
            boolean r13 = true;
            JSONObject r14 = new JSONObject(r12);     // Catch: JSONException -> L29
            String r15 = JSONObjectProtectorUtils.getString(r14, "cmd");     // Catch: JSONException -> L29
            if (TextUtils.equals(r15, "setConnectId") == false) goto L15;
            BytelinkSinkWrapper.access$1502(this.a, JSONObjectProtectorUtils.getString(r14, "connectId"));     // Catch: JSONException -> L12
            BytelinkSinkWrapper.access$1602(this.a, JSONObjectProtectorUtils.getString(r14, "browseId"));     // Catch: JSONException -> L12
            BytelinkSinkWrapper.access$1702(this.a, JSONObjectProtectorUtils.getString(r14, "mirrorVersion"));     // Catch: JSONException -> L12
            JSONObject r16 = new JSONObject();     // Catch: JSONException -> L12
            r16.put("connectId", BytelinkSinkWrapper.access$1500(this.a));     // Catch: JSONException -> L12
            r16.put("browseId", BytelinkSinkWrapper.access$1600(this.a));     // Catch: JSONException -> L12
            if (BytelinkSinkWrapper.access$1400(this.a) != null) goto L9;
        L10:
            BytelinkSinkWrapper.access$100(this.a).i(BytelinkSinkWrapper.TAG, "send onConnect event:" + r16);     // Catch: JSONException -> L12
            BytelinkSinkWrapper.access$700(this.a, "bytelink_onConnect", r16);     // Catch: JSONException -> L12
        L28:
            r13 = false;
        L31:
            if (r13 == true) goto L33;
            return;
        L33:
            if (BytelinkSinkWrapper.access$1800(this.a) == null) goto L40;
            this.a.mainThreadExecutor.execute(new g(this, r11, r12));
            return;
        L40:
            return;
        L9:
            r16.put("clientInfo", BytelinkSinkWrapper.access$1400(this.a).toString());     // Catch: JSONException -> L12
        L12:
            e = e;
            r13 = false;
        L30:
            e.printStackTrace();
            goto L31
        L15:
            if (TextUtils.equals(r15, "inviteAccepted") == false) goto L22;
            BytelinkSinkWrapper.access$100(this.a).i(BytelinkSinkWrapper.TAG, "onRecvMetaData: Invite Cast Accepted");     // Catch: JSONException -> L29
            if (BytelinkSinkWrapper.access$400(this.a) == true) goto L31;
            if (BytelinkSinkWrapper.access$500(this.a) == null) goto L31;
            BytelinkSinkWrapper.access$500(this.a).onInviteResult(true);     // Catch: JSONException -> L29
            goto L28
        L22:
            if (TextUtils.equals(r15, "inviteDenied") == false) goto L31;
            BytelinkSinkWrapper.access$100(this.a).i(BytelinkSinkWrapper.TAG, "onRecvMetaData: Invite Cast Denied");     // Catch: JSONException -> L29
            if (BytelinkSinkWrapper.access$400(this.a) == true) goto L31;
            if (BytelinkSinkWrapper.access$500(this.a) == null) goto L31;
            BytelinkSinkWrapper.access$500(this.a).onInviteResult(false);     // Catch: JSONException -> L29
        L29:
            e = e;
            goto L30
        }

        @Override // com.byted.cast.sink.api.IServerListener
        public void onSinkLatencyStat(final int r10, final String r11, final String r12) {
            BytelinkSinkWrapper.access$100(this.a).d(BytelinkSinkWrapper.TAG, "onSinkLatencyStat:" + r12);
            this.a.mainThreadExecutor.execute(new com.byted.cast.sink.api.b(this, r10, r11, r12));
            BytelinkSinkWrapper.access$700(this.a, "bytelink_latency_stat", new JSONObject(r12));     // Catch: JSONException -> L5
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // com.byted.cast.sink.api.IServerListener
        public void onSinkStuckStat(final int r10, final String r11, final String r12) {
            BytelinkSinkWrapper.access$100(this.a).i(BytelinkSinkWrapper.TAG, "onSinkStuckStat:" + r12);
            this.a.mainThreadExecutor.execute(new com.byted.cast.sink.api.a(this, r10, r11, r12));
            BytelinkSinkWrapper.access$700(this.a, "bytelink_stuck_stat", new JSONObject(r12));     // Catch: JSONException -> L5
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // com.byted.cast.sink.api.IServerListener
        public void onStart(int r10, ServerInfo r11) {
            BytelinkSinkWrapper.access$100(this.a).d(BytelinkSinkWrapper.TAG, "server started, devicename:" + r11.deviceName + ", port:" + r11.serverPort);
            this.a.mainThreadExecutor.execute(new a(this, r11, r10));
        }

        @Override // com.byted.cast.sink.api.IServerListener
        public void onStop(int r10) {
            BytelinkSinkWrapper.access$100(this.a).d(BytelinkSinkWrapper.TAG, "server stopped.");
            if (BytelinkSinkWrapper.access$600(this.a) == true) goto L6;
            return;
        L6:
            if (BytelinkSinkWrapper.access$800(this.a) == null) goto L9;
            this.a.mainThreadExecutor.execute(new b(this, r10));
            return;
        }
    }

    public class f implements IMultipleReverseControl {
        final /* synthetic */ BytelinkSinkWrapper a;

        public class a implements Runnable {
            final /* synthetic */ String a;
            final /* synthetic */ int b;
            final /* synthetic */ f c;

            public a(f r1, String r10, int r11) {
                this.c = r1;
                this.a = r10;
                this.b = r11;
            }

            public void com_byted_cast_sink_api_BytelinkSinkWrapper$f$a__run$___twin___() {
                if (BytelinkSinkWrapper.access$500(this.c.a) == null) goto L14;
                BytelinkSinkWrapper.access$500(this.c.a).onVolume(this.a, this.b);
                JSONObject r0 = new JSONObject();
                r0.put("sessionId", this.a);     // Catch: JSONException -> L9
                r0.put("volume", this.b);     // Catch: JSONException -> L9
                BytelinkSinkWrapper.access$700(this.c.a, "bytelink_onVolume", r0);     // Catch: JSONException -> L9
                return;
            L9:
                e = move-exception;
                e.printStackTrace();
                return;
            }

            @Override // java.lang.Runnable
            public void run() {
                com_byted_cast_sink_api_BytelinkSinkWrapper$f$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
            }

            @Skip({"com.ss.android.ugc.bytex.pthread+"})
            public static void com_byted_cast_sink_api_BytelinkSinkWrapper$f$a_com_larus_apm_impl_protector_RunnableLancet_run(a r1) {
                r1.com_byted_cast_sink_api_BytelinkSinkWrapper$f$a__run$___twin___();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public f(BytelinkSinkWrapper r1) {
            this.a = r1;
        }

        @Override // com.byted.cast.sink.api.multiple.IMultipleReverseControl
        public int getCurrentPosition(String r1) {
            return 0;
        }

        @Override // com.byted.cast.sink.api.multiple.IMultipleReverseControl
        public int getDuration(String r1) {
            return 0;
        }

        @Override // com.byted.cast.sink.api.multiple.IMultipleReverseControl
        public void lowerVolume(String r1) {
        }

        @Override // com.byted.cast.sink.api.multiple.IMultipleReverseControl
        public boolean pause(String r1) {
            return false;
        }

        @Override // com.byted.cast.sink.api.multiple.IMultipleReverseControl
        public void raiseVolume(String r1) {
        }

        @Override // com.byted.cast.sink.api.multiple.IMultipleReverseControl
        public void seekTo(String r1, int r10) {
        }

        @Override // com.byted.cast.sink.api.multiple.IMultipleReverseControl
        public void sendMetaData(String r1) {
        }

        @Override // com.byted.cast.sink.api.multiple.IMultipleReverseControl
        public void setVolume(String r10, int r11) {
            BytelinkSinkWrapper.access$100(this.a).d(BytelinkSinkWrapper.TAG, "setVolume: " + r11);
            this.a.mainThreadExecutor.execute(new a(this, r10, r11));
        }

        @Override // com.byted.cast.sink.api.multiple.IMultipleReverseControl
        public boolean start(String r1) {
            return false;
        }

        @Override // com.byted.cast.sink.api.multiple.IMultipleReverseControl
        public boolean stop(String r1) {
            return false;
        }
    }

    public class g implements IMultipleLoader {
        final /* synthetic */ BytelinkSinkWrapper a;

        public g(BytelinkSinkWrapper r1) {
            this.a = r1;
        }

        public void loadAudio(String r10, Context r11, FrameLayout r12) {
            BytelinkSinkWrapper.access$2000(this.a).loadAudio(r10, r11, r12);
        }

        public void loadMirror(String r10, Context r11, FrameLayout r12) {
            BytelinkSinkWrapper.access$2000(this.a).loadMirror(r10, r11, r12);
        }

        public void loadPhoto(String r10, Context r11, FrameLayout r12) {
            BytelinkSinkWrapper.access$2000(this.a).loadPhoto(r10, r11, r12);
        }

        public void loadVideo(String r10, Context r11, FrameLayout r12) {
            BytelinkSinkWrapper.access$2000(this.a).loadVideo(r10, r11, r12);
        }
    }

    public class h implements IPreemptListener {
        final /* synthetic */ com.byted.cast.common.sink.IPreemptListener a;

        public h(BytelinkSinkWrapper r1, com.byted.cast.common.sink.IPreemptListener r10) {
            this.a = r10;
        }

        @Override // com.byted.cast.sink.api.IPreemptListener
        public void onPreempt(ClientInfo r10) {
            if (this.a == null) goto L6;
            com.byted.cast.common.sink.ClientInfo r0 = new com.byted.cast.common.sink.ClientInfo();
            r0.clientID = r10.clientID;
            r0.icon = r10.icon;
            r0.mirrorSourceType = r10.mirrorSourceType;
            r0.name = r10.name;
            r0.sourceType = r10.sourceType;
            r0.ip = r10.ip;
            this.a.onPreempt("ByteLink", r0);
            return;
        }
    }

    public class i implements IMultipleActiveControl {
        final /* synthetic */ BytelinkSinkWrapper a;

        public i(BytelinkSinkWrapper r1) {
            this.a = r1;
        }

        public float getPlayerVolume(String r10) {
            return BytelinkSinkWrapper.access$2100(this.a).getPlayerVolume(r10);
        }

        public void pause(String r1) {
        }

        public void seekComplete(String r1, int r10) {
        }

        public void seekStart(String r1, int r10) {
        }

        public void setPlayerVolume(String r10, float r11) {
            BytelinkSinkWrapper.access$2100(this.a).setPlayerVolume(r10, r11);
        }

        public void start(String r1) {
        }

        public void stop(String r10, boolean r11) {
            BytelinkSinkWrapper.access$2100(this.a).stop(r10, r11);
        }

        public final /* synthetic */ void updateDrama(String r1) {
            IMultipleActiveControl.-CC.$default$updateDrama(this, r1);
        }

        public void updateVolume(String r10) {
            BytelinkSinkWrapper.access$2100(this.a).updateVolume(r10);
        }
    }

    public BytelinkSinkWrapper() {
        this.bUseOldInterface = true;
        this.mServiceName = "BYTELINK";
        this.mMirrorListener = new a(this);
        this.mIsBinded = false;
        this.mUseUdpPath = true;
        this.mAVSyncType = 0;
        this.mRenderMode = 0;
        Boolean r1 = Boolean.TRUE;
        this.mAutoPlayAudio = r1;
        this.mAudioDataListener = new b(this);
        this.mSinkDataListener = new c(this);
        Boolean r10 = Boolean.FALSE;
        this.mCallbackDataToUser = r10;
        this.mEnablePlaying = r1;
        this.mEnableVideoNativeDecode = r10;
        this.mState = 100;
        this.mConnectId = "";
        this.mBrowseId = "";
        this.mSourceMirrorVersion = "";
        this.mVideoStartTimeMs = 0;
        this.mFirstVideoFrameTimeMs = 0;
        this.mClientInfo = null;
        this.mainThreadExecutor = new MainThreadExecutor();
        this.serverListener = new e(this);
        this.multipleReverseCtrl = new f(this);
        this.mLoader = new g(this);
        this.mMultiActiveControl = new i(this);
        this.mCastContext = null;
        this.mLogger = ContextManager.getLogger(null);
        this.mMonitor = ContextManager.getMonitor(this.mCastContext);
        ByteLinkSink r11 = ByteLinkSink.getInstance(this.mCastContext);
        this.mByteLinkSink = r11;
        r11.setOnLogMonitor(this);
        this.mByteLinkSink.setLogLevel(4);
        INVOKESTATIC_com_byted_cast_sink_api_BytelinkSinkWrapper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.byted.cast.render.MediaRender");     // Catch: Exception -> L5
        this.mMediaRenderExists = r1;     // Catch: Exception -> L5
    L6:
        this.mLogger.d(TAG, "mMediaRenderExists=" + this.mMediaRenderExists);
        this.mNetworkMonitor = new NetworkMonitor(null, 1, new d(this));
        return;
    L5:
        this.mMediaRenderExists = Boolean.FALSE;
        goto L6
    }

    public static /* synthetic */ IMediaServiceListener access$000(BytelinkSinkWrapper r0) {
        return r0.mMediaServiceListener;
    }

    public static /* synthetic */ Class access$001(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    public static /* synthetic */ CastLogger access$100(BytelinkSinkWrapper r0) {
        return r0.mLogger;
    }

    public static /* synthetic */ WifiManager.WifiLock access$1000(BytelinkSinkWrapper r0) {
        return r0.mWifiLock;
    }

    public static /* synthetic */ com.byted.cast.common.sink.CastInfo access$1100(BytelinkSinkWrapper r0, CastInfo r1) {
        return r0.conversionCastInfo(r1);
    }

    public static /* synthetic */ long access$1200(BytelinkSinkWrapper r10) {
        return r10.mFirstVideoFrameTimeMs;
    }

    public static /* synthetic */ long access$1202(BytelinkSinkWrapper r0, long r1) {
        r0.mFirstVideoFrameTimeMs = r1;
        return r1;
    }

    public static /* synthetic */ long access$1300(BytelinkSinkWrapper r10) {
        return r10.mVideoStartTimeMs;
    }

    public static /* synthetic */ long access$1302(BytelinkSinkWrapper r0, long r1) {
        r0.mVideoStartTimeMs = r1;
        return r1;
    }

    public static /* synthetic */ com.byted.cast.common.sink.ClientInfo access$1400(BytelinkSinkWrapper r0) {
        return r0.mClientInfo;
    }

    public static /* synthetic */ com.byted.cast.common.sink.ClientInfo access$1402(BytelinkSinkWrapper r0, com.byted.cast.common.sink.ClientInfo r1) {
        r0.mClientInfo = r1;
        return r1;
    }

    public static /* synthetic */ String access$1500(BytelinkSinkWrapper r0) {
        return r0.mConnectId;
    }

    public static /* synthetic */ String access$1502(BytelinkSinkWrapper r0, String r1) {
        r0.mConnectId = r1;
        return r1;
    }

    public static /* synthetic */ String access$1600(BytelinkSinkWrapper r0) {
        return r0.mBrowseId;
    }

    public static /* synthetic */ String access$1602(BytelinkSinkWrapper r0, String r1) {
        r0.mBrowseId = r1;
        return r1;
    }

    public static /* synthetic */ String access$1702(BytelinkSinkWrapper r0, String r1) {
        r0.mSourceMirrorVersion = r1;
        return r1;
    }

    public static /* synthetic */ IMessageListener access$1800(BytelinkSinkWrapper r0) {
        return r0.mMessageListener;
    }

    public static /* synthetic */ ContextManager.CastContext access$1900(BytelinkSinkWrapper r0) {
        return r0.mCastContext;
    }

    public static /* synthetic */ IAudioDataListener access$200(BytelinkSinkWrapper r0) {
        return r0.mAudioDataListener;
    }

    public static /* synthetic */ com.byted.cast.sink.api.multiple.IMultipleLoader access$2000(BytelinkSinkWrapper r0) {
        return r0.multipleLoader;
    }

    public static /* synthetic */ com.byted.cast.sink.api.multiple.IMultipleActiveControl access$2100(BytelinkSinkWrapper r0) {
        return r0.multiactivecontrol;
    }

    public static /* synthetic */ ISinkDataListener access$300(BytelinkSinkWrapper r0) {
        return r0.mSinkDataListener;
    }

    public static /* synthetic */ boolean access$400(BytelinkSinkWrapper r0) {
        return r0.bUseOldInterface;
    }

    public static /* synthetic */ IMirrorListener access$500(BytelinkSinkWrapper r0) {
        return r0.mMirrorListener;
    }

    public static /* synthetic */ boolean access$600(BytelinkSinkWrapper r0) {
        return r0.mIsBinded;
    }

    public static /* synthetic */ void access$700(BytelinkSinkWrapper r0, String r1, JSONObject r10) {
        r0.sendSinkEvent(r1, r10);
    }

    public static /* synthetic */ com.byted.cast.common.api.IServerListener access$800(BytelinkSinkWrapper r0) {
        return r0.mServerListener;
    }

    public static /* synthetic */ int access$902(BytelinkSinkWrapper r0, int r1) {
        r0.mState = r1;
        return r1;
    }

    private com.byted.cast.common.sink.CastInfo conversionCastInfo(CastInfo r10) {
        com.byted.cast.common.sink.CastInfo r0 = new com.byted.cast.common.sink.CastInfo();
        if (r10 == null) goto L16;
        r0 = new com.byted.cast.common.sink.CastInfo();
        r0.sourceDeviceType = r10.sourceDeviceType;
        r0.protocol = r10.protocol;
        r0.mediaArtist = r10.mediaArtist;
        r0.mediaAlbumUrl = r10.mediaAlbumUrl;
        r0.mediaAlbum = r10.mediaAlbum;
        r0.audioSessionId = r10.audioSessionId;
        r0.handleInside = r10.handleInside;
        r0.clientID = r10.clientID;
        r0.connectID = r10.token;
        r0.castType = 2;
        r0.infoType = r10.infoType;
        CastInfo.InfoData r1 = r10.infoData;
        if (r1 == null) goto L7;
        r0.extra = r1.toString();
    L7:
        r0.url = r10.url;
        r0.mediaTitle = r10.mediaTitle;
        r0.mimeType = r10.mimeType;
        if (r10.startInfo == null) goto L11;
        com.byted.cast.common.sink.CastInfo.StartInfo r11 = new com.byted.cast.common.sink.CastInfo.StartInfo();
        CastInfo.StartInfo r12 = r10.startInfo;
        r11.width = r12.width;
        r11.type = r12.type;
        r11.height = r12.height;
        r11.frameRate = r12.frameRate;
        r11.bitRate = r12.bitRate;
        r0.startInfo = r11;
    L11:
        if (r10.stopInfo == null) goto L14;
        com.byted.cast.common.sink.CastInfo.StopInfo r13 = new com.byted.cast.common.sink.CastInfo.StopInfo();
        CastInfo.StopInfo r14 = r10.stopInfo;
        r13.stopReason = r14.stopReason;
        r13.stopDetail = r14.stopDetail;
        r0.stopInfo = r13;
    L14:
        if (r10.sizeInfo == null) goto L16;
        com.byted.cast.common.sink.CastInfo.SizeInfo r15 = new com.byted.cast.common.sink.CastInfo.SizeInfo();
        CastInfo.SizeInfo r16 = r10.sizeInfo;
        r15.width = r16.width;
        r15.height = r16.height;
        r0.sizeInfo = r15;
    L16:
        return r0;
    }

    private void sendSinkEvent(String r10, JSONObject r11) {
        r11.put("sourceMirrorVersion", this.mSourceMirrorVersion);     // Catch: JSONException -> L5
        r11.put("sinkMirrorVersion", "7.30.1.12");     // Catch: JSONException -> L5
    L7:
        this.mLogger.v(TAG, "sendSinkEvent, event:" + r10 + ", content:" + r11);
        this.mMonitor.sendCustomEvent("sink", r10, r11.toString(), this.mConnectId, this.mBrowseId);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    private void setDebugMode(boolean r10) {
        if (r10 == false) goto L4;
        ByteLinkSink r11 = this.mByteLinkSink;
        int r0 = 3;
    L5:
        r11.setLogLevel(r0);
        return;
    L4:
        r11 = this.mByteLinkSink;
        r0 = 4;
        goto L5
    }

    public final /* synthetic */ void addCastIdListener(ICastIdListener r1) {
        ICastSink.-CC.$default$addCastIdListener(this, r1);
    }

    public final /* synthetic */ void deliverIntent(Intent r1) {
        ICastSink.-CC.$default$deliverIntent(this, r1);
    }

    public void destroy() {
        this.mLogger.i(TAG, "destroy");
        NetworkMonitor r0 = this.mNetworkMonitor;
        if (r0 == null) goto L5;
        r0.stop();
    L5:
        this.mByteLinkSink.destroy();
        this.mIsBinded = false;
    }

    public final /* synthetic */ DeviceInfo getDeviceInfo(String r1) {
        return ICastSink.-CC.$default$getDeviceInfo(this, r1);
    }

    public IMultipleActiveControl getMultipleActiveControl() {
        return this.mMultiActiveControl;
    }

    public IMultipleLoader getMultipleLoader() {
        return this.mLoader;
    }

    public Object getOption(int r1, Object... r10) {
        return null;
    }

    public final /* synthetic */ List getRegisterList() {
        return ICastSink.-CC.$default$getRegisterList(this);
    }

    public ServiceInfo getServiceInfo() {
        ServerInfo r0 = this.mByteLinkSink.getServerInfo();
        if (r0 != null) goto L6;
        return null;
    L6:
        ServiceInfo r1 = new ServiceInfo();
        r1.enableVideoNativeDecode = this.mEnableVideoNativeDecode.booleanValue();
        r1.ip = "";
        r1.name = r0.deviceName;
        r1.portMirror = r0.serverPort;
        r1.width = r0.width;
        r1.height = r0.height;
        r1.fps = r0.fps;
        r1.features = r0.features;
        r1.deviceID = r0.deviceID;
        r1.bytelinkVersion = (String) this.mByteLinkSink.getOption(32, new Object[]{""});
        return r1;
    }

    public Statistics getStatistics() {
        Statistics r0 = new Statistics();
        Iterator<RTCStatistics.NetworkStatistics> r1 = this.mByteLinkSink.getStatistics().nx.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        RTCStatistics.NetworkStatistics r10 = r1.next();
        Statistics.NetworkStatistics r11 = new Statistics.NetworkStatistics();
        r11.ClientId = r10.userId;
        r11.rtt = r10.videoRtt;
        r0.nx.add(r11);
        this.mLogger.d(TAG, "getStatistics client:" + r11.ClientId + " rtt=" + r11.rtt);
        goto L4
    L6:
        return r0;
    }

    public String getVersion() {
        Object r0 = this.mByteLinkSink.getOption(32, new Object[]{new Object()});
        if ((r0 instanceof String) == true) goto L5;
        return "";
    L5:
        return String.valueOf(r0);
    }

    public void init(Context r10, Config r11, IInitListener r12) {
        CastLogger r13 = this.mLogger;
        StringBuilder r0 = new StringBuilder("init, debug");
        if (r11 != null) goto L5;
    L7:
        boolean r14 = false;
    L8:
        r0.append(r14);
        r13.i(TAG, r0.toString());
        if (r11 != null) goto L11;
    L13:
        boolean r15 = false;
    L14:
        setDebugMode(r15);
        if (r11 == null) goto L20;
        String r16 = r11.getServiceName();
        if (TextUtils.isEmpty(r16) == true) goto L20;
        this.mServiceName = r16;
    L20:
        if (this.mIsBinded == false) goto L22;
        return;
    L22:
        this.mContext = r10;
        this.mByteLinkSink.setAVSyncType(this.mAVSyncType);
        this.mByteLinkSink.setRenderMode(this.mRenderMode);
        ByteLinkSink r17 = this.mByteLinkSink;
        Object[] r18 = new Object[1];
        if (r11 != null) goto L25;
    L27:
        boolean r1 = false;
    L28:
        r18[0] = Boolean.valueOf(r1);
        r17.setOption(IAPI.OPTION_SET_FILE_LOG_ENABLED, r18);
        if (this.bUseOldInterface == false) goto L34;
        this.mLogger.d(TAG, "init, bUseOldInterface=" + this.bUseOldInterface + " mEnableVideoNativeDecode=" + this.mEnableVideoNativeDecode + " mMediaRenderExists=" + this.mMediaRenderExists);
        if (this.mMediaRenderExists.booleanValue() == true) goto L33;
        this.mByteLinkSink.setOption(IAPI.OPTION_SET_ENABLE_VIDEO_NATIVE_DECODE, new Object[]{Boolean.TRUE});
    L40:
        if (r11.isStartUsbServer() == true) goto L42;
        this.mLogger.i(TAG, "Wi-Fi connected, skip load BwdlService.");
        this.mUseUdpPath = false;
    L43:
        Context r19 = this.mContext;
        if (r19 == null) goto L49;
        this.mByteLinkSink.init(r19, r11.getDeviceId(), this.mUseUdpPath);
        this.mWifiManager = (WifiManager) this.mContext.getSystemService("wifi");     // Catch: Exception -> L48
    L49:
        Application r20 = this.mApplication;
        if (r20 == null) goto L53;
        this.mByteLinkSink.setApplication(r20);
    L53:
        if (this.bUseOldInterface == false) goto L55;
        this.mByteLinkSink.setOption(IAPI.OPTION_SET_SINK_DATA_LISTENER, new Object[]{this.mCallbackDataToUser, this.mEnablePlaying, this.mSinkDataListener});
    L56:
        this.mByteLinkSink.setOption(IAPI.OPTION_SET_SINK_DATA_LISTENER, new Object[]{Boolean.valueOf(r11.isEnableCallbackData()), Boolean.valueOf(r11.isEnablePlaying()), r11.getSinkDataListener()});
        if (this.bUseOldInterface == false) goto L59;
        this.mByteLinkSink.setOption(IAPI.OPTION_SET_AUDIO_LISTENER, new Object[]{this.mAutoPlayAudio, this.mAudioDataListener});
    L60:
        this.mByteLinkSink.setServerListener(this.serverListener);
        this.mByteLinkSink.setMultipleReverseControl(this.multipleReverseCtrl);
        this.multipleLoader = this.mByteLinkSink.getMultipleLoader();
        this.multiactivecontrol = this.mByteLinkSink.getMultipleActiveControl();
        stopServer();
        startServer(this.mServiceName);
        NetworkMonitor r21 = this.mNetworkMonitor;
        if (r21 == null) goto L63;
        r21.start();
    L63:
        this.mIsBinded = true;
        return;
    L59:
        this.mByteLinkSink.setOption(IAPI.OPTION_SET_AUDIO_LISTENER, new Object[]{Boolean.valueOf(r11.isAutoPlayAudio()), this.mAudioDataListener});
        goto L60
    L55:
        this.mByteLinkSink.setOption(IAPI.OPTION_SET_SINK_DATA_LISTENER, new Object[]{Boolean.valueOf(r11.isEnableCallbackData()), Boolean.valueOf(r11.isEnablePlaying()), this.mSinkDataListener});
        goto L56
    L42:
        this.mUseUdpPath = true;
        goto L43
    L33:
        this.mByteLinkSink.setOption(IAPI.OPTION_SET_ENABLE_VIDEO_NATIVE_DECODE, new Object[]{this.mEnableVideoNativeDecode});
        goto L40
    L34:
        if (r11 == null) goto L40;
        this.mLogger.d(TAG, "init, bUseOldInterface=" + this.bUseOldInterface + " config.isEnableVideoNativeDecode()=" + r11.isEnableVideoNativeDecode() + " mMediaRenderExists=" + this.mMediaRenderExists);
        if (this.mMediaRenderExists.booleanValue() == true) goto L38;
        this.mByteLinkSink.setOption(IAPI.OPTION_SET_ENABLE_VIDEO_NATIVE_DECODE, new Object[]{Boolean.TRUE});
        goto L40
    L38:
        this.mByteLinkSink.setOption(IAPI.OPTION_SET_ENABLE_VIDEO_NATIVE_DECODE, new Object[]{Boolean.valueOf(r11.isEnableVideoNativeDecode())});
        goto L40
    L25:
        if (r11.isEnableFileLog() == false) goto L27;
        r1 = true;
        goto L28
    L11:
        if (r11.isEnableDebug() == false) goto L13;
        r15 = true;
        goto L14
    L5:
        if (r11.isEnableDebug() == false) goto L7;
        r14 = true;
        goto L8
    }

    public boolean notifyPreempt(boolean r10, com.byted.cast.common.sink.ClientInfo r11) {
        this.mLogger.d(TAG, "notifyPreempt:" + r10 + ", mState:" + this.mState + ", clientInfo:" + r11);
        if (this.mState != 100) goto L6;
        this.mLogger.d(TAG, "notifyPreempt, no need preempt");
        return false;
    L6:
        ClientInfo r0 = new ClientInfo();
        r0.clientID = r11.clientID;
        r0.name = r11.name;
        r0.icon = r11.icon;
        r0.sourceType = r11.sourceType;
        r0.mirrorSourceType = r11.mirrorSourceType;
        r0.ip = r11.ip;
        return this.mByteLinkSink.notifyPreempt(r10, r0);
    }

    @Override // com.byted.cast.sink.api.IOnLogMonitor
    public void onLogMonitor(String r10, String[][] r11) {
        this.mMonitor.sendCustomEvent("ByteLinkMonitor", r10, r11);
    }

    public void requestIdrFromSource(com.byted.cast.common.sink.CastInfo r10) {
        ByteLinkSink r0 = this.mByteLinkSink;
        if (r0 == null) goto L6;
        r0.requestIdrFromSource(r10.clientID);
        return;
    }

    public boolean reverseConnect(String r10, int r11) {
        this.mLogger.i(TAG, "reverseConnect: ip=" + r10 + ", port=" + r11);
        return this.mByteLinkSink.reverseConnect(r10, r11);
    }

    public boolean reverseDisconnect() {
        this.mLogger.i(TAG, "reverseDisconnect");
        return this.mByteLinkSink.reverseDisconnect();
    }

    public boolean reverseInvite(String r10) {
        this.mLogger.i(TAG, "reverseInvite");
        return this.mByteLinkSink.reverseInvite(r10);
    }

    public void send(com.byted.cast.common.sink.CastInfo r1, String r10, ISendResultListener r11) {
        ByteLinkSink r12 = this.mByteLinkSink;
        if (r12 == null) goto L6;
        r12.sendMetaData(r1.clientID, r10);
        return;
    }

    public final /* synthetic */ void send(ServiceInfo r1, String r10, com.byted.cast.common.sink.ISendResultListener r11) {
        ICastSink.-CC.$default$send(this, r1, r10, r11);
    }

    public final /* synthetic */ String sendSync(ServiceInfo r1, String r10) {
        return ICastSink.-CC.$default$sendSync(this, r1, r10);
    }

    public final /* synthetic */ void setActionListener(IActionListener r1) {
        ICastSink.-CC.$default$setActionListener(this, r1);
    }

    public final /* synthetic */ void setBrowseDataListener(IBrowseDataListener r1) {
        ICastSink.-CC.$default$setBrowseDataListener(this, r1);
    }

    public final /* synthetic */ void setLogEnabled(boolean r1) {
        ICastSink.-CC.$default$setLogEnabled(this, r1);
    }

    public void setMediaServiceEnable(boolean r10) {
        if (r10 == false) goto L5;
        this.mByteLinkSink.setOption(25, new Object[]{Boolean.TRUE});
        return;
    }

    public void setMediaServiceListener(IMediaServiceListener r1) {
        this.mMediaServiceListener = r1;
    }

    public void setMessageListener(IMessageListener r1) {
        this.mMessageListener = r1;
    }

    public void setMirrorListener(IMirrorListener r1) {
        this.mMirrorListener = r1;
        this.bUseOldInterface = false;
    }

    public Object setOption(int r10, Object... r11) {
        if (r10 == 33) goto L36;
        if (r10 != 10026) goto L7;
        Object r12 = r11[0];
        if ((r12 instanceof Boolean) == false) goto L50;
        Object r13 = r11[1];
        if ((r13 instanceof IAudioDataListener) == false) goto L51;
        this.mAutoPlayAudio = (Boolean) r12;
        ISinkDataListener r14 = (IAudioDataListener) r13;
        this.mAudioDataListener = r14;
    L34:
        this.bUseOldInterface = true;
        Objects.toString(r14);
        return null;
    L51:
        return null;
    L50:
        return null;
    L7:
        if (r10 != 10028) goto L9;
        Object r15 = r11[0];
        if ((r15 instanceof Boolean) == false) goto L47;
        Object r0 = r11[1];
        if ((r0 instanceof Boolean) == false) goto L48;
        Object r16 = r11[2];
        if ((r16 instanceof ISinkDataListener) == false) goto L49;
        this.mCallbackDataToUser = (Boolean) r15;
        this.mEnablePlaying = (Boolean) r0;
        r14 = (ISinkDataListener) r16;
        this.mSinkDataListener = r14;
        goto L34
    L49:
        return null;
    L48:
        return null;
    L47:
        return null;
    L9:
        if (r10 != 10032) goto L11;
        Object r17 = r11[0];
        if ((r17 instanceof Boolean) == false) goto L45;
        this.mEnableVideoNativeDecode = (Boolean) r17;
        this.bUseOldInterface = true;
    L46:
        return null;
    L45:
        return null;
    L11:
        if (r10 == 10079) goto L15;
        ByteLinkSink r1 = this.mByteLinkSink;
        if (r1 == null) goto L40;
        r1.setOption(r10, r11);
        return null;
    L40:
        return null;
    L15:
        Object r18 = r11[0];
        if ((r18 instanceof Application) == false) goto L43;
        this.mApplication = (Application) r18;
        this.mLogger.i(TAG, "OPTION_SET_APPLICATION:" + this.mApplication);
        return null;
    L43:
        return null;
    L36:
        if (r11.length <= 0) goto L53;
        Object r19 = r11[0];
        if ((r19 instanceof Boolean) == false) goto L54;
        this.mUseUdpPath = ((Boolean) r19).booleanValue();
        goto L46
    L54:
        return null;
    L53:
        return null;
    }

    public void setPreemptListener(com.byted.cast.common.sink.IPreemptListener r10) {
        this.mByteLinkSink.setPreemptListener(new h(this, r10));
    }

    public final /* synthetic */ void setPrivateChannel(String r1) {
        ICastSink.-CC.$default$setPrivateChannel(this, r1);
    }

    public final /* synthetic */ void setReverseControl(IReverseControl r1) {
        ICastSink.-CC.$default$setReverseControl(this, r1);
    }

    public void setServerListener(com.byted.cast.common.api.IServerListener r1) {
        this.mServerListener = r1;
    }

    public final /* synthetic */ void setServerListener(com.byted.cast.common.sink.IServerListener r1) {
        ICastSink.-CC.$default$setServerListener(this, r1);
    }

    public void setSourceDeviceInfoListener(ISourceDeviceInfoListener r10) {
        this.mByteLinkSink.setSourceDeviceInfoListener(r10);
    }

    public final /* synthetic */ void setSsdpPrivateChannel(String r1) {
        ICastSink.-CC.$default$setSsdpPrivateChannel(this, r1);
    }

    public void startServer(String r10) {
        this.mLogger.i(TAG, "startService:" + r10);
        this.mByteLinkSink.startServer(r10);
        JSONObject r0 = new JSONObject();
        r0.put("serviceName", r10);     // Catch: JSONException -> L5
        r0.put("protocol", "ByteLink");     // Catch: JSONException -> L5
        sendSinkEvent("bytecast_start_server", r0);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public final /* synthetic */ void startSsdpServer(String r1) {
        ICastSink.-CC.$default$startSsdpServer(this, r1);
    }

    public final /* synthetic */ boolean stopInvite(String r1) {
        return ICastSink.-CC.$default$stopInvite(this, r1);
    }

    public void stopServer() {
        this.mLogger.i(TAG, "stopServer");
        this.mByteLinkSink.stopServer();
        JSONObject r0 = new JSONObject();
        r0.put("protocol", "ByteLink");     // Catch: JSONException -> L5
        sendSinkEvent("bytecast_stop_server", r0);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public final /* synthetic */ void stopSsdpServer() {
        ICastSink.-CC.$default$stopSsdpServer(this);
    }

    public final /* synthetic */ void upDateServerName(String r1) {
        ICastSink.-CC.$default$upDateServerName(this, r1);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_byted_cast_sink_api_BytelinkSinkWrapper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r10) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r11 = access$001(r10);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r10);     // Catch: Throwable -> L8
    L7:
        return r11;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r10);
    L12:
        throw th;
    L34:
        Class r12 = access$001(r10);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r10);     // Catch: Throwable -> L17
    L16:
        return r12;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r10);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r10);
    }
}
