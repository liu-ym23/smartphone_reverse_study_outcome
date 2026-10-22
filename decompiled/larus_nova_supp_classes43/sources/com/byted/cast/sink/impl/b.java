package com.byted.cast.sink.impl;

import android.app.Application;
import android.content.Context;
import android.graphics.Point;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.byted.cast.common.CastLogger;
import com.byted.cast.common.ContextManager;
import com.byted.cast.common.DeviceInfoManager;
import com.byted.cast.common.Dispatcher;
import com.byted.cast.common.MD5;
import com.byted.cast.common.api.IAudioDataListener;
import com.byted.cast.common.api.ILibraryLoader;
import com.byted.cast.common.api.ILogger;
import com.byted.cast.common.api.ISinkDataListener;
import com.byted.cast.common.bean.SourceDeviceInfo;
import com.byted.cast.common.bean.chromecast.MessageBean;
import com.byted.cast.common.sink.ISourceDeviceInfoListener;
import com.byted.cast.common.utils.GsonUtils;
import com.byted.cast.sdk.IRTCEngineEventListener;
import com.byted.cast.sdk.RTCEngine;
import com.byted.cast.sdk.RTCSetting;
import com.byted.cast.sdk.RTCStatistics;
import com.byted.cast.sdk.utils.Utils;
import com.byted.cast.sdk.view.IRenderView;
import com.byted.cast.sdk.view.SurfaceRenderView;
import com.byted.cast.sdk.view.VideoGLSurfaceView;
import com.byted.cast.sink.api.ByteLinkSink;
import com.byted.cast.sink.api.CastInfo;
import com.byted.cast.sink.api.ClientInfo;
import com.byted.cast.sink.api.IOnLogMonitor;
import com.byted.cast.sink.api.IPreemptListener;
import com.byted.cast.sink.api.IServerListener;
import com.byted.cast.sink.api.ServerInfo;
import com.byted.cast.sink.api.multiple.IMultipleActiveControl;
import com.byted.cast.sink.api.multiple.IMultipleLoader;
import com.byted.cast.sink.api.multiple.IMultipleReverseControl;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentSkipListMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class b {
    private String A;
    private String B;
    private boolean C;
    private boolean D;
    private ContextManager.CastContext E;
    private CastLogger F;
    private String G;
    private ISourceDeviceInfoListener H;
    private IMultipleLoader I;
    private IMultipleActiveControl J;
    private IRTCEngineEventListener K;
    private IRenderView.IRenderCallback L;
    private Context a;
    private String b;
    private int c;
    private Point d;
    private RTCEngine e;
    private RTCSetting f;
    private IServerListener g;
    private IMultipleReverseControl h;
    private IOnLogMonitor i;
    private IPreemptListener j;
    private int k;
    private int l;
    private int m;
    private boolean n;
    private boolean o;
    private ConcurrentSkipListMap<String, ClientInfo> p;
    private Map<String, CastInfo> q;
    private Map<String, IRenderView> r;
    private Map<String, ViewGroup> s;
    private int t;
    private Handler u;
    private int v;
    private boolean w;
    private int x;
    private String y;
    private String z;

    public class a implements IMultipleLoader {
        final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        @Override // com.byted.cast.sink.api.multiple.IMultipleLoader
        public void loadAudio(String r1, Context r10, FrameLayout r11) {
        }

        @Override // com.byted.cast.sink.api.multiple.IMultipleLoader
        public void loadMirror(String r10, Context r11, FrameLayout r12) {
            b.a(this.a).i("ByteLinkSinkImpl", "loadMirror " + r10 + ", gitInfo:1.c8f9ae2");
            Iterator r0 = b.b(this.a).keySet().iterator();
        L4:
            if (r0.hasNext() == false) goto L8;
            String r1 = (String) r0.next();
            CastInfo r13 = (CastInfo) b.b(this.a).get(r1);
            b.a(this.a).i("ByteLinkSinkImpl", "mUserCastMap " + r13.clientID);
            if (r13.clientID != r10) goto L4;
            b.l(this.a).put(r10, r12);
            b.a(this.a, r11, r1, r12);
            goto L4
        }

        @Override // com.byted.cast.sink.api.multiple.IMultipleLoader
        public void loadPhoto(String r1, Context r10, FrameLayout r11) {
        }

        @Override // com.byted.cast.sink.api.multiple.IMultipleLoader
        public void loadVideo(String r1, Context r10, FrameLayout r11) {
        }
    }

    /* JADX INFO: renamed from: com.byted.cast.sink.impl.b$b, reason: collision with other inner class name */
    public class C0013b implements IMultipleActiveControl {
        final /* synthetic */ b a;

        public C0013b(b r1) {
            this.a = r1;
        }

        @Override // com.byted.cast.sink.api.multiple.IMultipleActiveControl
        public float getPlayerVolume(String r1) {
            return 0.0f;
        }

        @Override // com.byted.cast.sink.api.IActiveControl
        public void pause(String r1) {
        }

        @Override // com.byted.cast.sink.api.multiple.IMultipleActiveControl
        public void setPlayerVolume(String r10, float r11) {
            b.b(this.a).size();
            Iterator r0 = b.b(this.a).entrySet().iterator();
        L4:
            if (r0.hasNext() == false) goto L12;
            Map.Entry r1 = (Map.Entry) r0.next();
            String r12 = ((CastInfo) r1.getValue()).clientID;
            if (((CastInfo) r1.getValue()).clientID.equals(r10) == false) goto L4;
            String r13 = (String) r1.getKey();
            b.r(this.a).setPlayerVolume(r13, r11);
            return;
        }

        @Override // com.byted.cast.sink.api.IActiveControl
        public void start(String r1) {
        }

        @Override // com.byted.cast.sink.api.IActiveControl
        public void stop(String r10, boolean r11) {
            b.a(this.a).i("ByteLinkSinkImpl", "stop from user, clientId:" + r10 + ", paramBoolean:" + r11);
            Iterator r12 = b.q(this.a).keySet().iterator();
            ClientInfo r0 = null;
        L4:
            if (r12.hasNext() == false) goto L7;
            r0 = (ClientInfo) b.q(this.a).get((String) r12.next());
            if (r0.clientID != r10) goto L4;
        L7:
            if (r0 != null) goto L9;
            return;
        L9:
            if (r0.clientID != r10) goto L17;
            b.a(this.a, r0, true, RTCEngine.ExitReason.REASON_DISCONNECT, true);
            return;
        }

        @Override // com.byted.cast.sink.api.IActiveControl
        public void updateVolume(String r1) {
        }
    }

    public class c implements IRTCEngineEventListener {
        final /* synthetic */ b a;

        public c(b r1) {
            this.a = r1;
        }

        private /* synthetic */ void a() {
            b.k(this.a).onSuccess(DeviceInfoManager.getInstance().getSourceDeviceInfo());
        }

        private static /* synthetic */ void a(IRenderView r0, int r1, int r10) {
            r0.setVideoSize(r1, r10);
        }

        private /* synthetic */ void a(CastInfo r10) {
            if (b.s(this.a) == null) goto L6;
            b.a(this.a).i("ByteLinkSinkImpl", "onCast start, castInfo:" + r10);
            CastInfo r0 = new CastInfo(r10);
            r0.infoType = 100;
            b.s(this.a).onCast(3, r0);
            CastInfo r1 = new CastInfo(r10);
            r1.infoType = 101;
            b.s(this.a).onCast(3, r1);
            return;
        }

        private /* synthetic */ void a(ClientInfo r10, String r11) {
            ViewGroup r0 = (ViewGroup) b.l(this.a).get(r10.clientID);
            if (r0 == null) goto L6;
            ((IRenderView) b.n(this.a).get(r11)).removeRenderCallback(b.o(this.a));
            b.n(this.a).remove(r11);
            r0.removeAllViews();
            b.l(this.a).remove(r10.clientID);
            r0.setKeepScreenOn(false);
            b.a(this.a).i("ByteLinkSinkImpl", "onIntoBackground, container.removeAllViews");
            return;
        }

        public static /* synthetic */ void a(c r0) {
            r0.a();
        }

        private /* synthetic */ void b(CastInfo r10) {
            if (b.s(this.a) == null) goto L6;
            b.a(this.a).i("ByteLinkSinkImpl", "onCast pause, castInfo:" + r10);
            CastInfo r0 = new CastInfo(r10);
            r0.infoType = 104;
            b.s(this.a).onCast(3, r0);
            return;
        }

        public static /* synthetic */ void b(c r0, ClientInfo r1, String r10) {
            r0.a(r1, r10);
        }

        private /* synthetic */ void c(CastInfo r10) {
            if (b.s(this.a) == null) goto L6;
            b.a(this.a).i("ByteLinkSinkImpl", "onCast resume, castInfo:" + r10);
            CastInfo r0 = new CastInfo(r10);
            r0.infoType = CastInfo.TYPE_CAST_RESUME;
            b.s(this.a).onCast(3, r0);
            return;
        }

        public static /* synthetic */ void c(c r0, CastInfo r1) {
            r0.b(r1);
        }

        public static /* synthetic */ void d(c r0, CastInfo r1) {
            r0.c(r1);
        }

        public static /* synthetic */ void e(IRenderView r0, int r1, int r10) {
            a(r0, r1, r10);
        }

        public static /* synthetic */ void f(c r0, CastInfo r1) {
            r0.a(r1);
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void OnVideoSizeChanged(String r10, final int r11, final int r12, int r13) {
            b.a(this.a).i("ByteLinkSinkImpl", "OnVideoSizeChanged: userId=" + r10 + " width=" + r11 + " height" + r12 + " rotation=" + r13);
            final IRenderView r0 = (IRenderView) b.n(this.a).get(r10);
            if (r0 == null) goto L5;
            b.u(this.a).post(new f(r0, r11, r12));
        L7:
            if (b.s(this.a) == null) goto L13;
            CastInfo r14 = (CastInfo) b.b(this.a).get(r10);
            if (r14 == null) goto L11;
            r14.infoType = 103;
            CastInfo.SizeInfo r1 = new CastInfo.SizeInfo();
            r14.sizeInfo = r1;
            r1.width = r11;
            r1.height = r12;
            r14.rotation = r13;
            b.s(this.a).onCast(3, r14);
            return;
        L11:
            b.a(this.a).e("ByteLinkSinkImpl", "OnVideoSizeChanged");
            return;
        L13:
            return;
        L5:
            b.a(this.a).e("ByteLinkSinkImpl", "OnVideoSizeChanged: error");
            goto L7
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onAudioSetVolume(String r10, float r11, float r12) {
            if (b.m(this.a) == null) goto L6;
            ClientInfo r13 = (ClientInfo) b.q(this.a).get(r10);
            b.m(this.a).setVolume(r13.clientID, (int) (r11 * 100.0f));
            b.a(this.a).i("ByteLinkSinkImpl", "onAudioSetVolume");
            return;
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onCancelRequest(String r10) {
            b.a(this.a).i("ByteLinkSinkImpl", "onCancelRequest " + r10 + ", gitInfo:1.c8f9ae2");
            ClientInfo r0 = (ClientInfo) b.q(this.a).get(r10);
            if (r0 != null) goto L6;
            b.a(this.a).e("ByteLinkSinkImpl", "onCancelRequest " + r10 + " has been already disconnected?");
            return;
        L6:
            b.a(this.a, r0, false, RTCEngine.ExitReason.REASON_DISCONNECT, false);
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onCancelSuccess() {
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onCastControl(int r1, int r10) {
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onCastPortSet(int r10, int r11, int r12, int r13) {
            b.a(this.a).i("ByteLinkSinkImpl", "onCastPortSet: videoChan=" + r10 + " videoPort=" + r11 + " audioChan=" + r12 + " audioPort=" + r13);
            if (b.s(this.a) != null) goto L5;
            return;
        L5:
            b r0 = this.a;
            b.a(r0, CastInfo.INFO_CAST_PORT_SET, r11, b.a(r0, r10, r11, r12, r13));
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onCastPortUnSet(int r10, int r11, int r12, int r13) {
            b.a(this.a).i("ByteLinkSinkImpl", "onCastPortUnSet: videoChan=" + r10 + " videoPort=" + r11 + " audioChan=" + r12 + " audioPort=" + r13);
            if (b.s(this.a) != null) goto L5;
            return;
        L5:
            b r0 = this.a;
            b.a(r0, CastInfo.INFO_CAST_PORT_UNSET, r11, b.a(r0, r10, r11, r12, r13));
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public boolean onCastRequest(String r10, String r11) {
            b.a(this.a).i("ByteLinkSinkImpl", "onCastRequest " + r10 + ", gitInfo:1.c8f9ae2");
            ClientInfo r0 = (ClientInfo) b.q(this.a).get(r10);
            if (r0 != null) goto L8;
            CastLogger r12 = b.a(this.a);
            StringBuilder r1 = new StringBuilder();
            r1.append(r10);
            String r13 = " has not been connected?";
        L5:
            r1.append(r13);
            r12.e("ByteLinkSinkImpl", r1.toString());
            return false;
        L8:
            if (b.b(this.a).get(r10) == null) goto L10;
            r12 = b.a(this.a);
            r1 = new StringBuilder();
            r1.append(r10);
            r13 = " has already casted";
            goto L5
        L10:
            final CastInfo r14 = new CastInfo();
            r14.clientID = r0.clientID;
            r14.token = r11;
            r14.castType = 2;
            r14.audioSessionId = b.r(this.a).getAudioSessionId(r10);
            r14.rotation = 1;
            r14.mimeType = 102;
            b.b(this.a).put(r10, r14);
            b.u(this.a).postDelayed(new i(this, r14), 200);
            return true;
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onCastSuccess() {
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onConnect(String r10, String r11) {
            b.a(this.a).i("ByteLinkSinkImpl", "onConnect " + r10 + ", gitInfo:1.c8f9ae2");
            if (b.q(this.a).get(r10) == null) goto L6;
            b.a(this.a).e("ByteLinkSinkImpl", r10 + " has been already connected?");
            return;
        L6:
            ClientInfo r0 = new ClientInfo();
            r0.ip = r10;
            r0.name = r11;
            r0.clientID = b.a(this.a, r10);
            b.q(this.a).put(r10, r0);
            if (b.s(this.a) == null) goto L12;
            b.s(this.a).onConnect(3, r0);
            if (b.i(this.a) == null) goto L12;
            b.i(this.a).onPreempt(r0);
        L12:
            if (TextUtils.equals("bytelink-remote-mirror", r10) == false) goto L14;
            return;
        L14:
            if (b.d(this.a) == false) goto L18;
            b.a(this.a).i("ByteLinkSinkImpl", "onConnect: leave RTC room when bytelink connection established");
            b.j(this.a);
            return;
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onConnectStateChanged(RTCEngine.ConnectState r1) {
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onConnectSuccess(int r1, int r10, int r11) {
            if (b.s(this.a) == null) goto L6;
            ClientInfo r12 = new ClientInfo();
            r12.name = "ReverseConnection";
            r12.clientID = "ReverseConnection";
            r12.ip = "ReverseConnection";
            r12.sourceType = 101;
            b.s(this.a).onConnect(3, r12);
            return;
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onDisconnect(RTCEngine.ExitReason r10, String r11) {
            if (b.s(this.a) == null) goto L6;
            ClientInfo r12 = new ClientInfo();
            r12.name = "ReverseConnection";
            r12.clientID = "ReverseConnection";
            r12.ip = "ReverseConnection";
            r12.sourceType = 101;
            b.s(this.a).onDisconnect(3, r12);
            return;
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onDisconnect(String r10, RTCEngine.ExitReason r11, String r12) {
            b.a(this.a).i("ByteLinkSinkImpl", "onDisconnect " + r10 + ", reason:" + r11 + ", message:" + r12 + ", gitInfo:1.c8f9ae2");
            ClientInfo r13 = (ClientInfo) b.q(this.a).get(r10);
            if (r13 == null) goto L5;
            b.a(this.a, r13, false, r11, true);
            if (b.d(this.a) == true) goto L14;
            return;
        L14:
            if (r11 == RTCEngine.ExitReason.REASON_DISCONNECT) goto L20;
            b.a(this.a).i("ByteLinkSinkImpl", "onDisconnect: join RTC room when bytelink connection lost");
            b.r(this.a).sinkInitAndJoinRoom(b.e(this.a), b.f(this.a), b.g(this.a), b.h(this.a));
            return;
        L20:
            return;
        L5:
            if (TextUtils.equals("bytelink-remote-mirror", r10) == false) goto L9;
            b.a(this.a).i("ByteLinkSinkImpl", "onDisconnect: fail to join rtc room");
            ClientInfo r14 = new ClientInfo();
            r14.ip = r10;
            r14.name = r10;
            r14.clientID = b.a(this.a, r10);
            if (b.s(this.a) == null) goto L17;
            b.s(this.a).onDisconnect(3, r14);
            return;
        L17:
            return;
        L9:
            b.a(this.a).e("ByteLinkSinkImpl", r10 + " has been already disconnected?");
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onError(int r10, String r11) {
            b.a(this.a).e("ByteLinkSinkImpl", "onError: code=" + r10 + ", description=" + r11);
            if (b.s(this.a) == null) goto L6;
            b.s(this.a).onError(3, IServerListener.WHAT_BYTELINK_SINK_ERROR, r10, r11);
            return;
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onFirstVideoFrame(String r10) {
            if (b.s(this.a) == null) goto L5;
            b.s(this.a).onFirstVideoFrame(r10);
        L5:
            CastInfo r11 = (CastInfo) b.b(this.a).get(r10);
            if (r11 == null) goto L11;
            r11.infoType = CastInfo.TYPE_CAST_SUCCESS;
            if (b.s(this.a) == null) goto L12;
            b.a(this.a).i("ByteLinkSinkImpl", "onFirstVideoFrame, onCastSuccess:" + r11);
            b.s(this.a).onCast(3, r11);
            return;
        L12:
            return;
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onInfo(int r10, int r11, String r12) {
            b.a(this.a).i("ByteLinkSinkImpl", "onInfo: what=" + r10 + " arg1=" + r11 + " arg2=" + r12);
            if (b.s(this.a) != null) goto L6;
            return;
        L6:
            if (r10 != 400003) goto L10;
            b r13 = this.a;
            int r0 = CastInfo.INFO_SET_BITRATE_KPS;
            if (r12 == null) goto L12;
        L13:
            b.a(r13, r0, r11, r12);
            return;
        L12:
            r12 = "";
            goto L13
        L10:
            r0 = r10;
            r13 = this.a;
            if (r12 != null) goto L13;
            goto L12
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onIntoBackground(final String r10) {
            b.a(this.a).i("ByteLinkSinkImpl", "onIntoBackground, userId:" + r10);
            final ClientInfo r0 = (ClientInfo) b.q(this.a).get(r10);
            if (r0 != null) goto L6;
            b.a(this.a).e("ByteLinkSinkImpl", r10 + " has not been connected?");
            return;
        L6:
            CastInfo r1 = (CastInfo) b.b(this.a).get(r10);
            final CastInfo r11 = new CastInfo();
            r11.clientID = r0.clientID;
            if (r1 == null) goto L9;
            r11.token = r1.token;
        L9:
            r11.castType = 2;
            r11.audioSessionId = b.r(this.a).getAudioSessionId(r10);
            r11.rotation = 1;
            r11.mimeType = 102;
            b.u(this.a).post(new g(this, r11));
            b.u(this.a).post(new h(this, r0, r10));
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onIntoForeground(String r10) {
            b.a(this.a).i("ByteLinkSinkImpl", "onIntoForeground, userId:" + r10);
            ClientInfo r0 = (ClientInfo) b.q(this.a).get(r10);
            if (r0 != null) goto L6;
            b.a(this.a).e("ByteLinkSinkImpl", r10 + " has not been connected?");
            return;
        L6:
            CastInfo r1 = (CastInfo) b.b(this.a).get(r10);
            final CastInfo r11 = new CastInfo();
            r11.clientID = r0.clientID;
            if (r1 == null) goto L9;
            r11.token = r1.token;
        L9:
            r11.castType = 2;
            r11.audioSessionId = b.r(this.a).getAudioSessionId(r10);
            r11.rotation = 1;
            r11.mimeType = 102;
            b.u(this.a).post(new j(this, r11));
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onKilled() {
            b.a(this.a).w("ByteLinkSinkImpl", "sink mirror is killed");
            b.t(this.a);
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onLogMonitor(String r10, String[][] r11) {
            if (b.c(this.a) == null) goto L6;
            b.c(this.a).onLogMonitor(r10, r11);
            return;
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onMonitorEvent(String r10, String r11) {
            if (b.s(this.a) == null) goto L6;
            b.s(this.a).onMonitorEvent(r10, r11);
            return;
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onPaused() {
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onRecvMetaData(String r10) {
            b.a(this.a).i("ByteLinkSinkImpl", "onRecvMetaData, json:" + r10);
            if (b.s(this.a) == null) goto L6;
            ClientInfo r0 = new ClientInfo();
            r0.name = "ReverseConnection";
            r0.clientID = "ReverseConnection";
            r0.ip = "ReverseConnection";
            r0.sourceType = 102;
            b.s(this.a).onRecvMetaData(1, r0, r10);
            return;
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onRecvMetaData(String r10, String r11) {
            b.a(this.a).i("ByteLinkSinkImpl", "onRecvMetaData, userId:" + r10 + ", json:" + r11);
            MessageBean r0 = (MessageBean) GsonUtils.fromJsonIgnoreException(r11, MessageBean.class);
            if (r0 == null) goto L22;
            int r12 = r0.type;
            if (r12 == 1) goto L8;
            if (r12 != 2) goto L22;
        L8:
            SourceDeviceInfo r13 = (SourceDeviceInfo) GsonUtils.fromJsonIgnoreException(r0.content, SourceDeviceInfo.class);
            Iterator r14 = b.q(this.a).keySet().iterator();
        L10:
            if (r14.hasNext() == false) goto L16;
            String r15 = (String) r14.next();
            if (TextUtils.isEmpty(r15) == true) goto L10;
            if (r15.contains(r10) == false) goto L10;
            b.a(this.a).i("ByteLinkSinkImpl", "saveSourceDeviceInfo key:".concat(r15));
            DeviceInfoManager.getInstance().saveSourceDeviceInfo(r15, r13);
        L16:
            this.a.a(r10, GsonUtils.toJsonIgnoreException(new MessageBean(r0.type, r0.id, GsonUtils.toJsonIgnoreException(DeviceInfoManager.getInstance().getLocalDeviceInfo()))));
            if (r0.type != 2) goto L22;
            if (b.k(this.a) == null) goto L22;
            Dispatcher.getInstance().runOnMainThread(new e(this));
        L22:
            if (b.s(this.a) == null) goto L26;
            ClientInfo r16 = (ClientInfo) b.q(this.a).get(r10);
            b.a(this.a).i("ByteLinkSinkImpl", "onRecvMetaData: " + r16);
            if (r16 == null) goto L34;
            b.s(this.a).onRecvMetaData(1, r16, r11);
            return;
        L34:
            return;
        L26:
            b.a(this.a).i("ByteLinkSinkImpl", "onRecvMetaData: No mServerListener");
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onResumed() {
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onServerStart(int r10) {
            b.a(this.a).i("ByteLinkSinkImpl", "onServerStart: port=" + r10);
            if (b.s(this.a) == null) goto L6;
            b.a(this.a, CastInfo.INFO_SERVER_START, r10, "");
            return;
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onServerStop(int r10) {
            b.a(this.a).i("ByteLinkSinkImpl", "onServerStop: port=" + r10);
            if (b.s(this.a) == null) goto L6;
            b.a(this.a, CastInfo.INFO_SERVER_STOP, r10, "");
            return;
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onSinkLatencyStat(String r10, String r11) {
            if (b.s(this.a) == null) goto L6;
            b.s(this.a).onSinkLatencyStat(3, r10, r11);
            return;
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onSinkStuckStat(String r10, String r11) {
            if (b.s(this.a) == null) goto L6;
            b.s(this.a).onSinkStuckStat(3, r10, r11);
            return;
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onStat(String r1) {
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onStopped() {
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onStuckStat(String r1) {
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onVideoEncoder(String r1, int r10, int r11, int r12, int r13, boolean r14, int r15) {
        }
    }

    public class d implements IRenderView.IRenderCallback {
        final /* synthetic */ b a;

        public d(b r1) {
            this.a = r1;
        }

        @Override // com.byted.cast.sdk.view.IRenderView.IRenderCallback
        public void onSurfaceChanged(IRenderView.ISurfaceHolder r10, int r11, int r12, int r13) {
            b.a(this.a).i("ByteLinkSinkImpl", "onSurfaceChanged: w=" + r12 + " h=" + r13);
        }

        @Override // com.byted.cast.sdk.view.IRenderView.IRenderCallback
        public void onSurfaceCreated(IRenderView.ISurfaceHolder r10, int r11, int r12) {
            b.a(this.a).i("ByteLinkSinkImpl", "onSurfaceCreated");
            Iterator r13 = b.n(this.a).entrySet().iterator();
        L4:
            if (r13.hasNext() == false) goto L20;
            Map.Entry r14 = (Map.Entry) r13.next();
            IRenderView r0 = (IRenderView) r14.getValue();
            String r15 = (String) r14.getKey();
            if (r0 == null) goto L4;
            if (r10.getRenderView() != r0) goto L4;
            if (r10.getSurfaceHolder() == null) goto L19;
            Surface r16 = r10.getSurfaceHolder().getSurface();
            b.r(this.a).setVideoSurface(r15, r16);
            return;
        L19:
            return;
        }

        @Override // com.byted.cast.sdk.view.IRenderView.IRenderCallback
        public void onSurfaceDestroyed(IRenderView.ISurfaceHolder r10) {
            b.a(this.a).i("ByteLinkSinkImpl", "onSurfaceDestroyed");
        }

        @Override // com.byted.cast.sdk.view.IRenderView.IRenderCallback
        public void onSurfaceTextureCreated(IRenderView r10, Surface r11) {
            Iterator r0 = b.n(this.a).keySet().iterator();
        L4:
            if (r0.hasNext() == false) goto L20;
            String r1 = (String) r0.next();
            IRenderView r12 = (IRenderView) b.n(this.a).get(r1);
            if (r12 == null) goto L4;
            if (r10 != r12) goto L4;
            if (b.p(this.a).getAVSyncType() != RTCSetting.AVSYNC_TYPE.SYNC_NORMAL) goto L11;
            CastLogger r13 = b.a(this.a);
            String r14 = "setSurface: SYNC_NORMAL";
        L12:
            r13.i("ByteLinkSinkImpl", r14);
            b.r(this.a).setVideoSurface(r1, r11);
            return;
        L11:
            r13 = b.a(this.a);
            r14 = "setSurface: SYNC_LOW_LATENCY";
            goto L12
        }
    }

    public b(ContextManager.CastContext r10) {
        this.d = new Point();
        this.o = false;
        this.p = new ConcurrentSkipListMap();
        this.q = new HashMap();
        this.r = new HashMap();
        this.s = new HashMap();
        this.t = 0;
        this.v = ByteLinkSink.NSD_SERVER_PORT;
        this.w = false;
        this.x = 0;
        this.D = false;
        this.I = new a(this);
        this.J = new C0013b(this);
        this.K = new c(this);
        this.L = new d(this);
        this.E = r10;
        this.F = ContextManager.getLogger(r10);
        g();
    }

    public static /* synthetic */ CastLogger a(b r0) {
        return r0.F;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.byted.cast.sink.impl.b] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [android.view.View, com.byted.cast.sdk.view.IRenderView] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.widget.FrameLayout, java.lang.Object] */
    private IRenderView a(Context r10, String r11, FrameLayout r12) {
        this.F.i("ByteLinkSinkImpl", "createRenderView: userId=" + r11 + " container=" + r12);
        int r0 = this.t;
        if (r0 == 0) goto L7;
        if (r0 == 1) goto L6;
        ?? r13 = 0;
    L9:
        a(r11, r13);
        FrameLayout.LayoutParams r14 = new FrameLayout.LayoutParams(-1, -1);
        r14.gravity = 17;
        r12.addView(r13, r14);
        r12.setKeepScreenOn(true);
        return r13;
    L6:
        SurfaceView r1 = new VideoGLSurfaceView(r10);
    L8:
        r13 = r1;
        goto L9
    L7:
        this.F.i("ByteLinkSinkImpl", "new SurfaceRenderView:");
        r1 = new SurfaceRenderView(r10, this.E);
        goto L8
    }

    public static /* synthetic */ IRenderView a(b r0, Context r1, String r10, FrameLayout r11) {
        return r0.a(r1, r10, r11);
    }

    private String a(int r10, int r11, int r12, int r13) {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L4
        r0.put("videoChan", r10);     // Catch: JSONException -> L4
        r0.put("videoPort", r11);     // Catch: JSONException -> L4
        r0.put("audioChan", r12);     // Catch: JSONException -> L4
        r0.put("audioPort", r13);     // Catch: JSONException -> L4
        return r0.toString();
    L4:
        e = move-exception;
        this.F.w("ByteLinkSinkImpl", "buildPortJson, json error:" + e);
        return "";
    }

    public static /* synthetic */ String a(b r0, int r1, int r10, int r11, int r12) {
        return r0.a(r1, r10, r11, r12);
    }

    public static /* synthetic */ String a(b r0, String r1) {
        return r0.a(r1);
    }

    private String a(String r10) {
        return r10 + "_" + MD5.hexdigest(r10 + System.currentTimeMillis());
    }

    private void a(int r10, int r11, String r12) {
        CastInfo r0 = new CastInfo();
        r0.infoType = CastInfo.TYPE_INFO;
        r0.infoData = new CastInfo.InfoData(r10, r11, r12);
        CastInfo r13 = b();
        String r14 = "";
        if (r13 == null) goto L7;
        String r15 = r13.clientID;
        if (r15 == null) goto L7;
    L8:
        r0.clientID = r15;
        if (r13 == null) goto L13;
        String r16 = r13.token;
        if (r16 == null) goto L13;
        r14 = r16;
    L13:
        r0.token = r14;
        this.F.i("ByteLinkSinkImpl", "dispatchInfoCast: " + r0.infoData + " clientID=" + r0.clientID);
        this.g.onCast(3, r0);
        return;
    L7:
        r15 = "";
        goto L8
    }

    private /* synthetic */ void a(CastInfo r10, String r11) {
        ViewGroup r0 = this.s.get(r10.clientID);
        if (r0 == null) goto L6;
        this.r.get(r11).removeRenderCallback(this.L);
        this.r.remove(r11);
        r0.removeView((SurfaceView) this.r.get(r11));
        this.s.remove(r10.clientID);
        r0.setKeepScreenOn(false);
        this.F.i("ByteLinkSinkImpl", "kickOutSource, container.removeAllViews");
        return;
    }

    private /* synthetic */ void a(ClientInfo r10, String r11) {
        ViewGroup r0 = this.s.get(r10.clientID);
        if (r0 == null) goto L6;
        this.r.get(r11).removeRenderCallback(this.L);
        this.r.remove(r11);
        this.s.remove(r10.clientID);
        r0.setKeepScreenOn(false);
        return;
    }

    private void a(ClientInfo r10, boolean r11, RTCEngine.ExitReason r12, boolean r13) {
        this.F.i("ByteLinkSinkImpl", "kickOutSource, active:" + r11 + ", reason:" + r12 + ", disconnect:" + r13 + "," + r10);
        if (r10 == null) goto L34;
        String r0 = r10.ip;
        if (r0 == null) goto L37;
        final String r1 = r0.replace("/", "");
        final CastInfo r14 = this.q.get(r1);
        if (r14 == null) goto L27;
        r14.infoType = 102;
        if (r11 == false) goto L16;
        r14.stopInfo = new CastInfo.StopInfo(1, 101);
        if (this.g == null) goto L26;
        CastLogger r15 = this.F;
        StringBuilder r16 = new StringBuilder("kickOutSource, onCast stop:");
    L14:
        r16.append(r14);
        r15.i("ByteLinkSinkImpl", r16.toString());
        this.g.onCast(3, r14);
    L26:
        this.u.post(new com.byted.cast.sink.impl.c(this, r14, r1));
        this.q.remove(r1);
        goto L27
    L16:
        if (r12 != RTCEngine.ExitReason.REASON_DISCONNECT) goto L18;
    L22:
        if (r13 == true) goto L26;
        r14.stopInfo = new CastInfo.StopInfo(1, 102);
        if (this.g == null) goto L26;
        r15 = this.F;
        r16 = new StringBuilder("kickOutSource, onCast stop:");
        goto L14
    L18:
        if (r12 == RTCEngine.ExitReason.REASON_KICK_OUT) goto L22;
        r14.stopInfo = new CastInfo.StopInfo(3, 104);
        if (this.g == null) goto L26;
        r15 = this.F;
        r16 = new StringBuilder("kickOutSource, onCast stop:");
    L27:
        if (r11 == false) goto L29;
        this.e.kickOutSource(r1);
    L29:
        if (r13 == false) goto L35;
        this.p.remove(r1);
        IServerListener r17 = this.g;
        if (r17 == null) goto L36;
        r17.onDisconnect(3, r10);
        return;
    L36:
        return;
    L35:
        return;
    L37:
        return;
    }

    public static /* synthetic */ void a(b r0, int r1, int r10, String r11) {
        r0.a(r1, r10, r11);
    }

    public static /* synthetic */ void a(b r0, ClientInfo r1, String r10) {
        r0.a(r1, r10);
    }

    public static /* synthetic */ void a(b r0, ClientInfo r1, boolean r10, RTCEngine.ExitReason r11, boolean r12) {
        r0.a(r1, r10, r11, r12);
    }

    private void a(String r10, Surface r11) {
        Objects.toString(r11);
        this.q.size();
        Iterator<Map.Entry<String, CastInfo>> r0 = this.q.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        Map.Entry<String, CastInfo> r1 = r0.next();
        String r12 = r1.getValue().clientID;
        if (r1.getValue().clientID.equals(r10) == false) goto L4;
        String r13 = r1.getKey();
        this.e.setVideoSurface(r13, r11);
        return;
    }

    private void a(String r10, IRenderView r11) {
        this.F.i("ByteLinkSinkImpl", "setRenderView: userId=" + r10 + " renderView=" + r11);
        if (r11 != null) goto L6;
        return;
    L6:
        if (this.r.get(r10) == null) goto L8;
        this.r.get(r10).removeRenderCallback(this.L);
    L8:
        this.r.put(r10, r11);
        this.F.i("ByteLinkSinkImpl", "addRenderCallback:" + this.L);
        this.r.get(r10).addRenderCallback(this.L);
    }

    private CastInfo b() {
        if (this.q.isEmpty() == false) goto L5;
        return null;
    L5:
        Iterator<CastInfo> r0 = this.q.values().iterator();
    L7:
        if (r0.hasNext() == false) goto L11;
        CastInfo r10 = r0.next();
        if (r10 == null) goto L7;
        return r10;
    L11:
        return null;
    }

    public static /* synthetic */ Map b(b r0) {
        return r0.q;
    }

    public static /* synthetic */ void b(b r0, CastInfo r1, String r10) {
        r0.a(r1, r10);
    }

    public static /* synthetic */ IOnLogMonitor c(b r0) {
        return r0.i;
    }

    public static /* synthetic */ boolean d(b r0) {
        return r0.C;
    }

    public static /* synthetic */ String e(b r0) {
        return r0.A;
    }

    private boolean e(int r10) {
        RTCSetting r0 = this.f;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r10 == 7) goto L19;
        if (r10 == 0) goto L18;
        if (r10 != 1) goto L10;
        RTCSetting.TRANS_TYPE r11 = RTCSetting.TRANS_TYPE.TCP;
    L20:
        r0.setVideoTransType(r11);
        return true;
    L10:
        if (r10 != 2) goto L12;
        r11 = RTCSetting.TRANS_TYPE.DART;
        goto L20
    L12:
        if (r10 != 3) goto L14;
        r11 = RTCSetting.TRANS_TYPE.LLAMA;
        goto L20
    L14:
        return false;
    L18:
        r11 = RTCSetting.TRANS_TYPE.UDP;
        goto L20
    L19:
        r11 = RTCSetting.TRANS_TYPE.MOQ;
        goto L20
    }

    public static /* synthetic */ String f(b r0) {
        return r0.B;
    }

    public static /* synthetic */ String g(b r0) {
        return r0.y;
    }

    private void g() {
        RTCSetting r0 = new RTCSetting(this.E);
        this.f = r0;
        r0.setDecodeType(RTCSetting.DECODE_TYPE.DECODE_TYPE_HW);
        this.f.setAVSyncType(RTCSetting.AVSYNC_TYPE.SYNC_LOW_LATENCY);
        this.f.setPort(this.v);
        int r1 = Utils.getArch();
        float r10 = Utils.getOSVersionF();
        this.F.i("ByteLinkSinkImpl", "initConfig, cpuarch:" + r1 + ", osVersionF:" + r10);
        this.F.i("ByteLinkSinkImpl", "initConfig, disable native video decoder!");
        this.f.setEnableVideoNativeDecode(false);
    }

    public static /* synthetic */ String h(b r0) {
        return r0.z;
    }

    private void h() {
        Iterator<Map.Entry<String, ClientInfo>> r0 = this.p.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Map.Entry<String, ClientInfo> r1 = r0.next();
        if ("bytelink-remote-mirror".equals(r1.getKey()) == true) goto L4;
        a(r1.getValue(), true, RTCEngine.ExitReason.REASON_DISCONNECT, true);
        goto L4
    }

    public static /* synthetic */ IPreemptListener i(b r0) {
        return r0.j;
    }

    private void j() {
        Iterator<String> r0 = this.p.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L16;
        final String r1 = r0.next();
        this.F.i("ByteLinkSinkImpl", "stopRemoteMirror cur userId=" + r1);
        if ("bytelink-remote-mirror".equals(r1) == false) goto L4;
        final ClientInfo r10 = this.p.get(r1);
        CastInfo r11 = this.q.get(r1);
        if (r11 == null) goto L13;
        r11.infoType = 102;
        r11.stopInfo = new CastInfo.StopInfo(1, 101);
        if (this.g == null) goto L13;
        this.F.i("ByteLinkSinkImpl", "kickOutSources, onCast stop:" + r11);
        this.g.onCast(3, r11);
    L13:
        this.e.kickOutSource(r1);
        this.p.remove(r1);
        this.q.remove(r1);
        this.u.post(new com.byted.cast.sink.impl.d(this, r10, r1));
        IServerListener r12 = this.g;
        if (r12 == null) goto L4;
        r12.onDisconnect(3, r10);
        goto L4
    }

    public static /* synthetic */ void j(b r0) {
        r0.j();
    }

    public static /* synthetic */ ISourceDeviceInfoListener k(b r0) {
        return r0.H;
    }

    public static /* synthetic */ Map l(b r0) {
        return r0.s;
    }

    public static /* synthetic */ IMultipleReverseControl m(b r0) {
        return r0.h;
    }

    public static /* synthetic */ Map n(b r0) {
        return r0.r;
    }

    public static /* synthetic */ IRenderView.IRenderCallback o(b r0) {
        return r0.L;
    }

    public static /* synthetic */ RTCSetting p(b r0) {
        return r0.f;
    }

    public static /* synthetic */ ConcurrentSkipListMap q(b r0) {
        return r0.p;
    }

    public static /* synthetic */ RTCEngine r(b r0) {
        return r0.e;
    }

    public static /* synthetic */ IServerListener s(b r0) {
        return r0.g;
    }

    public static /* synthetic */ void t(b r0) {
        r0.h();
    }

    public static /* synthetic */ Handler u(b r0) {
        return r0.u;
    }

    public Object a(int r1, Object... r10) {
        if (r1 == 32) goto L6;
        return null;
    L6:
        return "7.30.1.12";
    }

    public void a() {
        k();
        h();
        RTCEngine r0 = this.e;
        if (r0 == null) goto L5;
        r0.destroy();
    L5:
        RTCEngine.deinit(this.E);
        Handler r1 = this.u;
        if (r1 == null) goto L8;
        r1.removeCallbacksAndMessages(null);
        this.u = null;
    L8:
        this.a = null;
    }

    public void a(int r10) {
        if (r10 != 0) goto L4;
        RTCSetting r11 = this.f;
        RTCSetting.AVSYNC_TYPE r0 = RTCSetting.AVSYNC_TYPE.SYNC_LOW_LATENCY;
    L8:
        r11.setAVSyncType(r0);
        return;
    L4:
        if (r10 != 1) goto L10;
        r11 = this.f;
        r0 = RTCSetting.AVSYNC_TYPE.SYNC_NORMAL;
        goto L8
    }

    public void a(int r10, int r11) {
        RTCEngine r0 = this.e;
        if (r0 == null) goto L6;
        r0.dumpMediaData(r10, r11);
        return;
    }

    public void a(Application r10) {
        RTCEngine r0 = this.e;
        if (r0 == null) goto L6;
        r0.setApplication(r10);
        return;
    }

    public void a(Context r10, String r11) {
        a(r10, r11, true);
    }

    public void a(Context r19, String r20, boolean r21) {
        this.a = r19;
        this.G = r20;
        Point r1 = Utils.getScreenSize(r19);
        this.u = new Handler(Looper.getMainLooper());
        this.F.i("ByteLinkSinkImpl", "initialize, orig display, x:" + r1.x + ", y:" + r1.y + " useUdpPath:" + r21);
        if (this.o == false) goto L5;
        this.m = 30;
    L6:
        String r10 = Utils.getProperty("ro.build.product", "", this.E);
        if (r10.equals("KKHi3751V900") == false) goto L9;
    L29:
        int r11 = r1.x;
        if (r11 <= 1920) goto L35;
        int r12 = r1.y;
        if (r12 <= 1080) goto L35;
    L33:
        int r13 = r11 / 2;
        int r14 = r12 / 2;
    L34:
        r1.set(r13, r14);
    L35:
        this.m = 30;
    L36:
        this.F.i("ByteLinkSinkImpl", "change display, x:" + r1.x + ", y:" + r1.y);
        this.k = r1.x;
        this.l = r1.y;
        if (this.w == false) goto L39;
        this.v = com.byted.cast.sink.a.a.a(this.E, this.a);
        this.F.i("ByteLinkSinkImpl", "init, enable random port:" + this.v);
    L39:
        this.f.setPort(this.v);
        this.F.i("ByteLinkSinkImpl", "init, mRandomPortEnabled=" + this.w);
        RTCEngine.init(this.a, this.E, RTCEngine.RuntimeEnv.ONLINE, "sink", this.v, this.k, this.l, this.m, false, r21, this.w);
        this.f.getScreenProfile().setResolution(this.k, this.l);
        this.f.getScreenProfile().setmFps(this.m);
        this.f.setbEnableAudioMixer(false);
        this.f.setbEnableAudioCallback(true);
        RTCEngine r15 = this.e;
        if (r15 != null) goto L42;
        this.e = RTCEngine.create(r19, this.E, this.f, this.K, false);
    L43:
        this.n = true;
        return;
    L42:
        r15.reinit(r19, this.f, null, this.K, false);
        goto L43
    L9:
        if (r10.equals("ab30a5") == true) goto L29;
        if (r10.equals("kkm7642") == false) goto L36;
        if (this.o == false) goto L24;
        r11 = r1.x;
        if (r11 <= 1920) goto L20;
        r12 = r1.y;
        if (r12 > 1080) goto L33;
    L20:
        if (r11 != 1920) goto L35;
        if (r1.y != 1080) goto L35;
        r13 = 1280;
        r14 = 720;
        goto L34
    L24:
        r11 = r1.x;
        if (r11 <= 1920) goto L35;
        r12 = r1.y;
        if (r12 <= 1080) goto L35;
    L5:
        this.m = 60;
        goto L6
    }

    public void a(ILibraryLoader r10) {
        RTCEngine.setLibraryLoader(this.E, r10);
    }

    public void a(ILogger r10) {
        RTCEngine.setLogger(this.E, r10);
    }

    public void a(ISourceDeviceInfoListener r1) {
        this.H = r1;
    }

    public void a(IOnLogMonitor r1) {
        this.i = r1;
    }

    public void a(IPreemptListener r1) {
        this.j = r1;
    }

    public void a(IServerListener r1) {
        this.g = r1;
    }

    public void a(IMultipleReverseControl r1) {
        this.h = r1;
    }

    public void a(String r10, String r11) {
        boolean r12 = false;
        if (this.e == null) goto L12;
        this.F.d("ByteLinkSinkImpl", "sendMetaData: id=" + r10 + " meta=" + r11);
        Iterator<String> r0 = this.p.keySet().iterator();
    L6:
        if (r0.hasNext() == false) goto L12;
        String r13 = r0.next();
        ClientInfo r14 = this.p.get(r13);
        if (r14 == null) goto L6;
        if (r14.clientID.startsWith(r10) == false) goto L6;
        this.e.sendMetaData(r13, r11);
        r12 = true;
    L12:
        if (r12 == true) goto L22;
        this.F.e("ByteLinkSinkImpl", "sendMetaData: id=" + r10 + " NOT found!!!");
        return;
    }

    public void a(boolean r10) {
        RTCEngine.setFileLogEnabled(this.E, r10);
    }

    public boolean a(String r10, int r11) {
        this.e.connect(r10, r11, "", "");
        return true;
    }

    public boolean a(boolean r10, ClientInfo r11) {
        this.F.i("ByteLinkSinkImpl", "notifyPreempt: allow=" + r10 + " clientInfo=" + r11);
        this.n = r10;
        if (r10 == true) goto L6;
    L4:
        a(r11, true, RTCEngine.ExitReason.REASON_DISCONNECT, true);
        return false;
    L6:
        if (this.p.size() <= 0) goto L37;
        int r12 = this.x;
        if (r12 != 1) goto L18;
        Map.Entry<String, ClientInfo> r13 = this.p.firstEntry();
        if (r13 == null) goto L26;
        ClientInfo r14 = r13.getValue();
        if (r14.ip.equals(r11.ip) == false) goto L16;
        Map.Entry<String, ClientInfo> r15 = this.p.higherEntry(r14.ip);
        if (r15 == null) goto L16;
    L25:
        r11 = r15.getValue();
    L33:
        if (r11 != null) goto L4;
        return false;
    L16:
        r11 = r14;
    L26:
        r11 = null;
        goto L33
    L18:
        if (r12 != 2) goto L28;
        Map.Entry<String, ClientInfo> r16 = this.p.lastEntry();
        if (r16 == null) goto L26;
        r14 = r16.getValue();
        if (r14.ip.equals(r11.ip) == false) goto L16;
        r15 = this.p.lowerEntry(r14.ip);
        if (r15 == null) goto L16;
    L28:
        if (r12 != 3) goto L26;
        if (this.p.size() == 1) goto L26;
        this.F.i("ByteLinkSinkImpl", "notifyPreempt: oneSessionMode toKickClient=" + r11);
        goto L33
    L37:
        return false;
    }

    public void b(int r10) {
        RTCEngine r0 = this.e;
        if (r0 == null) goto L6;
        r0.setAudioMaxDelayByMs(r10);
        return;
    }

    public void b(int r10, int r11) {
        RTCEngine r0 = this.e;
        if (r0 == null) goto L6;
        r0.setAudioDropPolicyByMs(r10, r11);
        return;
    }

    public void b(int r10, Object... r11) {
        if (r10 != 2) goto L5;
        Object r12 = r11[0];
        if ((r12 instanceof String) == false) goto L187;
        String[] r13 = ((String) r12).split("\\*");
        if (r13.length == 2) goto L123;
        return;
    L123:
        this.k = CastIntegerProtector.parseInt(r13[0]);
        this.l = CastIntegerProtector.parseInt(r13[1]);
        RTCSetting r14 = this.f;
        if (r14 != null) goto L126;
        return;
    L126:
        if (this.e == null) goto L189;
        r14.getScreenProfile().setResolution(this.k, this.l);
        this.e.setScreenProfile(this.f.getScreenProfile());
        return;
    L189:
        return;
    L187:
        return;
    L5:
        if (r10 != 25) goto L7;
        this.f.setbEnableAudioMixer(false);
        this.f.setbEnableAudioCallback(true);
        this.o = true;
        return;
    L7:
        if (r10 != 10066) goto L9;
        Object r15 = r11[0];
        if ((r15 instanceof Integer) == false) goto L184;
        this.f.setLatencyMs(((Integer) r15).intValue());
        return;
    L184:
        return;
    L9:
        if (r10 != 10091) goto L11;
        Object r16 = r11[0];
        if ((r16 instanceof Boolean) == false) goto L183;
        this.D = ((Boolean) r16).booleanValue();
        CastLogger r17 = this.F;
        StringBuilder r18 = new StringBuilder("OPTION_ENABLE_BYTELINK_BROWSE:");
        r18.append(this.D);
    L29:
        r17.i("ByteLinkSinkImpl", r18.toString());
        return;
    L183:
        return;
    L11:
        if (r10 != 10021) goto L13;
        Objects.toString(r11[0]);
        Object r19 = r11[0];
        if ((r19 instanceof String) == false) goto L180;
        Object r20 = r11[1];
        if ((r20 instanceof Surface) == false) goto L181;
        a((String) r19, (Surface) r20);
        return;
    L181:
        return;
    L180:
        return;
    L13:
        if (r10 == 10022) goto L103;
        switch(r10) {
            case 10026: goto L96;
            case 10027: goto L90;
            case 10028: goto L81;
            case 10029: goto L76;
            case 10030: goto L71;
            case 10031: goto L66;
            case 10032: goto L59;
            default: goto L16;
        };
    L59:
        Object r21 = r11[0];
        if ((r21 instanceof Boolean) == false) goto L152;
        this.f.setEnableVideoNativeDecode(((Boolean) r21).booleanValue());
        Boolean r22 = (Boolean) r11[0];
        int r23 = Utils.getArch();
        float r24 = Utils.getOSVersionF();
        if (r23 == 32) goto L64;
        return;
    L64:
        if (r24 >= 5.0f) goto L154;
        this.f.setEnableVideoNativeDecode(false);
        return;
    L154:
        return;
    L152:
        return;
    L66:
        Object r25 = r11[0];
        if ((r25 instanceof String) == false) goto L156;
        Object r26 = r11[1];
        if ((r26 instanceof Long) == false) goto L157;
        RTCEngine r0 = this.e;
        r0.render((String) r25, ((Long) r26).longValue());
        return;
    L157:
        return;
    L156:
        return;
    L71:
        Object r27 = r11[0];
        if ((r27 instanceof String) == false) goto L159;
        Object r28 = r11[1];
        if ((r28 instanceof Long) == false) goto L160;
        RTCEngine r1 = this.e;
        r1.decodeOutput((String) r27, ((Long) r28).longValue());
        return;
    L160:
        return;
    L159:
        return;
    L76:
        Object r29 = r11[0];
        if ((r29 instanceof String) == false) goto L162;
        Object r30 = r11[1];
        if ((r30 instanceof Long) == false) goto L163;
        RTCEngine r31 = this.e;
        r31.decodeInput((String) r29, ((Long) r30).longValue());
        return;
    L163:
        return;
    L162:
        return;
    L81:
        Object r32 = r11[0];
        if ((r32 instanceof Boolean) == false) goto L165;
        Object r33 = r11[1];
        if ((r33 instanceof Boolean) == false) goto L166;
        Object r34 = r11[2];
        if ((r34 instanceof ISinkDataListener) == false) goto L167;
        Boolean r35 = (Boolean) r32;
        Boolean r36 = (Boolean) r33;
        ISinkDataListener r37 = (ISinkDataListener) r34;
        if (this.e == null) goto L168;
        Objects.toString(r37);
        this.e.setSinkDataListener(r35, r36, r37);
        return;
    L168:
        return;
    L167:
        return;
    L166:
        return;
    L165:
        return;
    L90:
        if (r11 != null) goto L92;
        return;
    L92:
        if (r11.length <= 0) goto L171;
        Object r38 = r11[0];
        if ((r38 instanceof Integer) == false) goto L172;
        e(((Integer) r38).intValue());
        return;
    L172:
        return;
    L171:
        return;
    L96:
        Object r39 = r11[0];
        if ((r39 instanceof Boolean) == false) goto L174;
        Object r40 = r11[1];
        if ((r40 instanceof IAudioDataListener) == false) goto L175;
        Boolean r41 = (Boolean) r39;
        IAudioDataListener r42 = (IAudioDataListener) r40;
        if (this.e == null) goto L176;
        Objects.toString(r42);
        this.e.setAudioDataListener(r41, r42);
        return;
    L176:
        return;
    L175:
        return;
    L174:
        return;
    L16:
        switch(r10) {
            case 10069: goto L50;
            case 10070: goto L49;
            case 10071: goto L38;
            default: goto L17;
        };
    L17:
        switch(r10) {
            case 10075: goto L35;
            case 10076: goto L30;
            case 10077: goto L26;
            default: goto L18;
        };
    L18:
        switch(r10) {
            case 100041: goto L23;
            case 100042: goto L20;
            default: goto L190;
        };
    L20:
        Object r43 = r11[0];
        if ((r43 instanceof ILogger) == false) goto L129;
        ILogger r44 = (ILogger) r43;
        Objects.toString(r44);
        a(r44);
        return;
    L129:
        return;
    L23:
        Object r45 = r11[0];
        if ((r45 instanceof ILibraryLoader) == false) goto L131;
        ILibraryLoader r46 = (ILibraryLoader) r45;
        Objects.toString(r46);
        a(r46);
        return;
    L131:
        return;
    L190:
        return;
    L26:
        Object r47 = r11[0];
        if ((r47 instanceof Integer) == false) goto L133;
        this.x = ((Integer) r47).intValue();
        r17 = this.F;
        r18 = new StringBuilder("OPTION_SET_PREEMPT_POLICY:");
        r18.append(this.x);
        goto L29
    L133:
        return;
    L30:
        Object r48 = r11[0];
        if ((r48 instanceof Boolean) == false) goto L135;
        boolean r49 = ((Boolean) r48).booleanValue();
        this.w = r49;
        RTCEngine r50 = this.e;
        if (r50 == null) goto L136;
        r50.setRandomPortEnabled(r49);
        return;
    L136:
        return;
    L135:
        return;
    L35:
        Object r51 = r11[0];
        if ((r51 instanceof Boolean) == false) goto L138;
        this.f.setDecodedByUser(((Boolean) r51).booleanValue());
        return;
    L138:
        return;
    L38:
        Object r52 = r11[0];
        if ((r52 instanceof String) == false) goto L140;
        Object r53 = r11[1];
        if ((r53 instanceof String) == false) goto L141;
        Object r54 = r11[2];
        if ((r54 instanceof String) == false) goto L142;
        Object r55 = r11[3];
        if ((r55 instanceof String) == false) goto L143;
        Object r56 = r11[4];
        if ((r56 instanceof Boolean) == false) goto L144;
        String r57 = (String) r52;
        String r58 = (String) r53;
        String r59 = (String) r54;
        String r60 = (String) r55;
        Boolean r61 = (Boolean) r56;
        this.y = (String) r52;
        this.z = (String) r53;
        this.A = (String) r54;
        this.B = (String) r55;
        this.C = ((Boolean) r56).booleanValue();
        return;
    L144:
        return;
    L143:
        return;
    L142:
        return;
    L141:
        return;
    L140:
        return;
    L49:
        j();
        return;
    L50:
        Object r62 = r11[0];
        if ((r62 instanceof String) == false) goto L147;
        Object r63 = r11[1];
        if ((r63 instanceof String) == false) goto L148;
        Object r64 = r11[2];
        if ((r64 instanceof String) == false) goto L149;
        Object r65 = r11[3];
        if ((r65 instanceof String) == false) goto L150;
        String r66 = (String) r62;
        String r67 = (String) r63;
        String r68 = (String) r64;
        String r69 = (String) r65;
        String r70 = (String) r62;
        this.y = r70;
        String r71 = (String) r63;
        this.z = r71;
        String r72 = (String) r64;
        this.A = r72;
        String r73 = (String) r65;
        this.B = r73;
        this.e.sinkInitAndJoinRoom(r72, r73, r70, r71);
        return;
    L150:
        return;
    L149:
        return;
    L148:
        return;
    L147:
        return;
    L103:
        Object r74 = r11[0];
        if ((r74 instanceof Boolean) == false) goto L178;
        Objects.toString(r74);
        a(((Boolean) r11[0]).booleanValue());
        return;
    }

    public void b(String r10) {
        if (this.e == null) goto L10;
        this.F.i("ByteLinkSinkImpl", "requestIdrFromSource, sessionId:" + r10);
        Iterator<String> r0 = this.p.keySet().iterator();
    L6:
        if (r0.hasNext() == false) goto L16;
        String r1 = r0.next();
        ClientInfo r11 = this.p.get(r1);
        this.F.i("ByteLinkSinkImpl", "requestIdrFromSource, clientId:" + r11.clientID);
        if (r11.clientID != r10) goto L6;
        this.e.requestIdrFromSource(r1);
        goto L6
    L16:
        return;
    }

    public IMultipleActiveControl c() {
        return this.J;
    }

    public void c(int r10) {
        RTCEngine.setLogLevel(this.E, r10);
    }

    public boolean c(String r10) {
        JSONObject r0 = new JSONObject();
        r0.put("cmd", "invite");     // Catch: JSONException -> L7
        r0.put("port", this.v);     // Catch: JSONException -> L7
        r0.put(MessageIndication.MESSAGE_TYPE_MSG, r10);     // Catch: JSONException -> L7
        this.e.sendMetaData(r0.toString());     // Catch: JSONException -> L7
        return true;
    L7:
        e = move-exception;
        e.printStackTrace();
        return true;
    }

    public IMultipleLoader d() {
        return this.I;
    }

    public void d(int r1) {
        this.t = r1;
    }

    public void d(String r10) {
        this.F.i("ByteLinkSinkImpl", "startServer serviceName: " + r10 + ", gitInfo:1.c8f9ae2");
        Context r0 = this.a;
        if (r0 != null) goto L6;
        this.F.e("ByteLinkSinkImpl", "context is null, you should init with context first!");
        return;
    L6:
        this.b = r10;
        ((WindowManager) r0.getSystemService("window")).getDefaultDisplay().getRealSize(this.d);
        if (this.o == false) goto L9;
        int r1 = 30;
    L10:
        this.c = r1;
        if (this.g == null) goto L13;
        ServerInfo r11 = new ServerInfo();
        r11.deviceName = r10;
        r11.serverPort = this.v;
        this.g.onStart(3, r11);
    L13:
        this.F.i("ByteLinkSinkImpl", "startServer out");
        return;
    L9:
        r1 = 60;
        goto L10
    }

    public ServerInfo e() {
        this.F.i("ByteLinkSinkImpl", "getServerInfo, mServerPort:" + this.v);
        ServerInfo r0 = new ServerInfo();
        r0.deviceName = this.b;
        r0.serverPort = this.v;
        r0.width = this.k;
        r0.height = this.l;
        r0.fps = this.c;
        r0.features = 1;
        r0.deviceID = this.G;
        return r0;
    }

    public RTCStatistics f() {
        RTCStatistics r0 = this.e.getStatistics();
        Iterator<RTCStatistics.NetworkStatistics> r1 = r0.nx.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        RTCStatistics.NetworkStatistics r10 = r1.next();
        ClientInfo r11 = this.p.get(r10.userId);
        if (r11 == null) goto L4;
        r10.userId = r11.clientID;
        goto L4
    L8:
        return r0;
    }

    public boolean i() {
        this.e.disconnect();
        return true;
    }

    public void k() {
        this.F.i("ByteLinkSinkImpl", "stopServer, gitInfo:1.c8f9ae2");
        if (this.g == null) goto L6;
        this.F.w("ByteLinkSinkImpl", "stopServer, onStop, serviceId:3");
        this.g.onStop(3);
        return;
    }
}
