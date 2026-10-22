package org.chromium.wschannel;

import android.text.TextUtils;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.frameworks.baselib.network.http.f;
import com.bytedance.frameworks.baselib.network.http.util.a;
import com.bytedance.frameworks.baselib.network.http.util.b;
import com.bytedance.frameworks.baselib.network.http.util.k;
import com.ss.bduploader.UploadKeys;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.TTWebsocketConnection;
import com.ttnet.org.chromium.net.impl.CronetFrontierClient;
import com.ttnet.org.chromium.net.impl.TTServiceInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.CookieHandler;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.chromium.CronetAppProviderManager;
import org.chromium.CronetClient;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class CronetFrontierConnection {
    private static final String CLIENT_KEY_MANAGER_CLASS = "com.bytedance.ttnet.clientkey.ClientKeyManager";
    private static final String FALLBACK_TIMEOUT_MILLS = "fallback_timeout_mills";
    private static final String FALLBACK_WEBSOCKET_TASK_ID = null;
    private static final int FALL_BACK_SECONDS = 10;
    private static final int FALL_BACK_WEBSOCKET = 1;
    private static final String LOG_TYPE = "private_protocol";
    private static final int MAX_RETRY_COUNT = 3;
    private static final String METHOD_ID_HEADER = "method_id";
    private static final String MSG_ID_HEADER = "msg_id";
    private static final String MSG_SERVER_TIMING_HEADER = "server_timing";
    private static final String PAYLOAD_ENCODING_HEADER = "payload_encoding";
    private static final String PAYLOAD_TYPE_HEADER = "payload_type";
    private static final String PING_INTERVAL_HEADER = "ttnet_heartbeat_interval";
    private static final int PRIVATE_PROTOCOL_PROXY_DEFAULT_SERVICE_ID = 1;
    private static final int SHARED_STREAM_SERVICE_ID = 9000;
    private static final String TAG = "CronetFrontierConnection";
    private static final String TIME_OUT_HEADER = "ttnet_timeout_millis";
    private static final String TTNET_INIT_CLASS = "com.bytedance.ttnet.TTNetInit";
    private static volatile int sChannelID = 0;
    private static CronetEngine sCronetEngine = null;
    private static boolean sDisableFallbackTask = false;
    private static volatile AtomicInteger sFirstConnection = null;
    public static CronetFrontierClient.TransportMode sMode = null;
    private static volatile String sPrivateProtocolUrl = "";
    private Map<Integer, Boolean> mAllServiceBuildInfo;
    private volatile int mAppState;
    private WebSocketCallbackImpl mCallback;
    private DestroyTimeoutControl mDestroyTimeoutControl;
    private CronetFrontierClient mFrontierClient;
    private AtomicBoolean mIsFallbackTaskRunning;
    private volatile boolean mIsFirstStreamReady;
    private int mPingInterval;
    private final AtomicInteger mRetryAttempts;
    private boolean mSharedConnection;
    private int mTimeOut;
    private final AtomicBoolean mUsePrivateProtocol;
    private final AtomicBoolean mUsePrivateProtocolProxy;
    private TTWebsocketConnection mWebsocketConnection;
    private IWsChannelClient mWsChannelClient;

    final class FallbackWebSocketTask extends b {
        private final Map<String, Object> mConfigMap;
        private final List<String> mUrls;
        final /* synthetic */ CronetFrontierConnection this$0;

        public FallbackWebSocketTask(CronetFrontierConnection r3, long r4, Map<String, Object> r6, List<String> r7) {
            Map<String, Object> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
            List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r4, CronetFrontierConnection.access$800());
            this.mConfigMap = r8;
            this.mUrls = r9;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CronetFrontierConnection.access$400(this.this$0) == false) goto L6;
            CronetFrontierConnection.access$900(this.this$0).set(0);
            CronetFrontierConnection.access$1000(this.this$0).set(false);
            return;
        L6:
            int r0 = CronetFrontierConnection.access$900(this.this$0).incrementAndGet();
            if (Logger.debug() == false) goto L9;
            Logger.d(CronetFrontierConnection.TAG, "Fallback to websocket connection, retry attempts:" + r0);
        L9:
            this.this$0.destroyConnection();
            CronetFrontierConnection.access$1100(this.this$0, this.mConfigMap, this.mUrls);
            JSONObject r1 = new JSONObject();     // Catch: JSONException -> L12
            r1.put("retry_attempts", r0);     // Catch: JSONException -> L12
            r1.put(InfoRequestQPSOptTraceLogger.REASON, "connect timeout fallback");     // Catch: JSONException -> L12
            CronetFrontierConnection.access$1200(this.this$0, r1, 1);     // Catch: JSONException -> L12
            return;
        L12:
            e = move-exception;
            e.printStackTrace();
        }
    }

    class ServiceMessageReceiverImpl implements CronetFrontierClient.IServiceMessageReceiver {
        final /* synthetic */ CronetFrontierConnection this$0;

        ServiceMessageReceiverImpl(CronetFrontierConnection r1) {
            this.this$0 = r1;
        }

        @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.IServiceMessageReceiver
        public void onError(int r3, int r4, String r5) {
            if (Logger.debug() == false) goto L5;
            Logger.d(CronetFrontierConnection.TAG, "onError ServiceId:" + r3 + " error code:" + r4 + " info:" + r5);
        L5:
            CronetFrontierConnection.access$600(this.this$0).onServiceConnectEvent(r3, false, "");
        }

        @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.IServiceMessageReceiver
        public void onReceivedAck(int r1, long r2, String r4, Boolean r5) {
            if (Logger.debug() == false) goto L6;
            Logger.d(CronetFrontierConnection.TAG, "onReceivedAck serviceId:" + r1 + " messageId:" + r2 + " logInfo:" + r4);
            return;
        }

        @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.IServiceMessageReceiver
        public void onReceivedMessage(int r8, Map<String, String> r9, byte[] r10) {
            Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
            if (CronetFrontierConnection.access$700(this.this$0).get() == false) goto L10;
            if (Logger.debug() == false) goto L7;
            Logger.d(CronetFrontierConnection.TAG, "proxy onReceivedMessage service id:" + r8 + " data length:" + r10.length);
        L7:
            CronetFrontierConnection.access$600(this.this$0).onMessage(r10);
            return;
        L10:
            if (Logger.debug() == false) goto L12;
            Logger.d(CronetFrontierConnection.TAG, "onReceivedMessage service id:" + r8 + " data length:" + r10.length);
        L12:
            WsChannelMsg r0 = new WsChannelMsg();
            r0.setService(r8);
            ArrayList r12 = new ArrayList();
            Iterator r13 = r11.entrySet().iterator();
        L14:
            if (r13.hasNext() == false) goto L39;
            Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r2.getKey(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L14;
            if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r2.getValue(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L14;
            if (((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin")).equals(CronetFrontierConnection.METHOD_ID_HEADER) == false) goto L27;
            r0.setMethod(Integer.valueOf((String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.memorydata.plugin")).intValue());     // Catch: NumberFormatException -> L24
        L24:
            e = move-exception;
            Logger.e(CronetFrontierConnection.TAG, "method_id is not valid: " + ((String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.memorydata.plugin")));
            e.printStackTrace();
            goto L14
        L27:
            if (((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin")).equalsIgnoreCase(CronetFrontierConnection.PAYLOAD_ENCODING_HEADER) == true) goto L28;
            if (((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin")).equalsIgnoreCase(CronetFrontierConnection.PAYLOAD_TYPE_HEADER) == true) goto L31;
            if (((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin")).equalsIgnoreCase(CronetFrontierConnection.MSG_ID_HEADER) == true) goto L34;
            if (((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin")).equalsIgnoreCase(CronetFrontierConnection.MSG_SERVER_TIMING_HEADER) == true) goto L37;
            WsChannelMsg.MsgHeader r4 = new WsChannelMsg.MsgHeader();
            r4.setKey((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin"));
            r4.setValue((String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.memorydata.plugin"));
            r12.add(r4);
            goto L14
        L37:
            r0.setServerTiming((String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.memorydata.plugin"));
            goto L14
        L34:
            r0.setMsgId((String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.memorydata.plugin"));
            goto L14
        L31:
            r0.setPayloadType((String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.memorydata.plugin"));
            goto L14
        L28:
            r0.setPayloadEncoding((String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.memorydata.plugin"));
            goto L14
        L39:
            r0.setMsgHeaders(r12);
            r0.setPayload(r10);
            if (r0.getPayloadEncoding() != null) goto L43;
            r0.setPayloadEncoding("");
        L43:
            if (r0.getPayloadType() != null) goto L46;
            r0.setPayloadType("");
        L46:
            if (Logger.debug() == false) goto L48;
            Logger.d(CronetFrontierConnection.TAG, "onReceivedMessage:" + r0);
        L48:
            CronetFrontierConnection.access$600(this.this$0).onMessage(r0);
        }

        @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.IServiceMessageReceiver
        public void onServiceReady(int r5, String r6) {
            if (Logger.debug() == false) goto L6;
            Logger.d(CronetFrontierConnection.TAG, "onServiceReady ServiceId:" + r5 + " log info:" + r6);
        L6:
            if (CronetFrontierConnection.access$000(this.this$0) == true) goto L16;
            CronetFrontierConnection.access$002(this.this$0, true);
            if (CronetFrontierConnection.access$100(this.this$0) == null) goto L16;
            if (CronetFrontierConnection.access$200(this.this$0) == (-1)) goto L16;
            CronetFrontierClient r7 = CronetFrontierConnection.access$100(this.this$0);
            if (CronetFrontierConnection.access$200(this.this$0) != 1) goto L14;
            boolean r2 = true;
        L15:
            r7.reportAppStateChange(r2);
            goto L16
        L14:
            r2 = false;
        L16:
            CronetFrontierConnection.access$300(this.this$0).put(Integer.valueOf(r5), true);
            if (this.this$0.isFallbackTaskRunning() == true) goto L19;
        L24:
            CronetFrontierConnection.access$600(this.this$0).onServiceConnectEvent(r5, true, "");
            return;
        L19:
            if (CronetFrontierConnection.access$400(this.this$0) == false) goto L24;
            JSONObject r8 = new JSONObject();     // Catch: Throwable -> L26
            r8.put("type", 1);     // Catch: Throwable -> L26
            r8.put(WsConstants.KEY_PRIVATE_PROTOCOL_ENABLE, 1);     // Catch: Throwable -> L26
            r8.put("state", 4);     // Catch: Throwable -> L26
            r8.put("url", CronetFrontierConnection.access$500());     // Catch: Throwable -> L26
            if (Logger.debug() == false) goto L23;
            Logger.d(CronetFrontierConnection.TAG, "PP onConnectionStateChanged state: 4 url:" + CronetFrontierConnection.access$500());     // Catch: Throwable -> L26
        L23:
            CronetFrontierConnection.access$600(this.this$0).onConnection(r8);     // Catch: Throwable -> L26
            goto L24
        }
    }

    static {
        FALLBACK_WEBSOCKET_TASK_ID = UUID.randomUUID().toString();
        sDisableFallbackTask = false;
        sMode = CronetFrontierClient.TransportMode.QUIC;
        sFirstConnection = new AtomicInteger(0);
        sChannelID = -1;
    }

    public CronetFrontierConnection(IWsChannelClient r3) {
        IWsChannelClient r4 = (IWsChannelClient) ZeusTransformUtils.wrapperContextForParams(r3, IWsChannelClient.class, "com.obric.memorydata.plugin");
        this.mUsePrivateProtocol = new AtomicBoolean(false);
        this.mUsePrivateProtocolProxy = new AtomicBoolean(false);
        this.mRetryAttempts = new AtomicInteger(0);
        this.mPingInterval = 10000;
        this.mTimeOut = 10000;
        this.mAllServiceBuildInfo = new ConcurrentHashMap();
        this.mIsFallbackTaskRunning = new AtomicBoolean(false);
        this.mAppState = -1;
        this.mIsFirstStreamReady = false;
        this.mSharedConnection = true;
        this.mWsChannelClient = r4;
        this.mCallback = new WebSocketCallbackImpl(this.mWsChannelClient);
        loadCronetKernel();     // Catch: Throwable -> L5
    L9:
        sCronetEngine = CronetClient.getCronetEngine();
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        if (Logger.debug() == false) goto L9;
        Logger.d(TAG, "TTNet init failed, cronet engine is null.");
        goto L9
    }

    static /* synthetic */ boolean access$000(CronetFrontierConnection r0) {
        return r0.mIsFirstStreamReady;
    }

    static /* synthetic */ boolean access$002(CronetFrontierConnection r0, boolean r1) {
        r0.mIsFirstStreamReady = r1;
        return r1;
    }

    static /* synthetic */ CronetFrontierClient access$100(CronetFrontierConnection r0) {
        return r0.mFrontierClient;
    }

    static /* synthetic */ AtomicBoolean access$1000(CronetFrontierConnection r0) {
        return r0.mIsFallbackTaskRunning;
    }

    static /* synthetic */ void access$1100(CronetFrontierConnection r2, Map r3, List r4) {
        r2.startConnectionWithWebSocket((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ void access$1200(CronetFrontierConnection r0, JSONObject r1, int r2) {
        r0.reportPrivateProtocolRelatedLog(r1, r2);
    }

    static /* synthetic */ int access$200(CronetFrontierConnection r0) {
        return r0.mAppState;
    }

    static /* synthetic */ Map access$300(CronetFrontierConnection r0) {
        return r0.mAllServiceBuildInfo;
    }

    static /* synthetic */ boolean access$400(CronetFrontierConnection r0) {
        return r0.isAllServiceConnected();
    }

    static /* synthetic */ String access$500() {
        return sPrivateProtocolUrl;
    }

    static /* synthetic */ IWsChannelClient access$600(CronetFrontierConnection r0) {
        return r0.mWsChannelClient;
    }

    static /* synthetic */ AtomicBoolean access$700(CronetFrontierConnection r0) {
        return r0.mUsePrivateProtocolProxy;
    }

    static /* synthetic */ String access$800() {
        return FALLBACK_WEBSOCKET_TASK_ID;
    }

    static /* synthetic */ AtomicInteger access$900(CronetFrontierConnection r0) {
        return r0.mRetryAttempts;
    }

    private boolean canUsePrivateProtocol(Map<String, Object> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        if (f.n() == false) goto L12;
        if (this.mRetryAttempts.get() >= 3) goto L12;
        Object r4 = r6.get(WsConstants.KEY_PRIVATE_PROTOCOL_ENABLE);
        if (r4 != null) goto L10;
        return false;
    L10:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L12:
        if (Logger.debug() == false) goto L14;
        Logger.d(TAG, "Retry attempts:" + this.mRetryAttempts.get() + ",tnc enabled:" + f.n());
    L14:
        return false;
    }

    private static String[] constructMessageMetaInfo(WsChannelMsg r5) {
        ArrayList r0 = new ArrayList();
        r0.add(METHOD_ID_HEADER);
        r0.add(String.valueOf(r5.getMethod()));
        if (TextUtils.isEmpty(r5.getPayloadType()) == true) goto L6;
        r0.add(PAYLOAD_TYPE_HEADER);
        r0.add(r5.getPayloadType());
    L6:
        if (TextUtils.isEmpty(r5.getPayloadEncoding()) == true) goto L9;
        r0.add(PAYLOAD_ENCODING_HEADER);
        r0.add(r5.getPayloadEncoding());
    L9:
        if (r5.getMsgHeaders() != null) goto L13;
        Object r6 = ZeusTransformUtils.preCheckCast(r0.toArray(new String[0]), String[].class, "com.obric.memorydata.plugin");
    L12:
        return (String[]) r6;
    L13:
        Iterator<WsChannelMsg.MsgHeader> r7 = r5.getMsgHeaders().iterator();
    L15:
        if (r7.hasNext() == false) goto L21;
        WsChannelMsg.MsgHeader r1 = (WsChannelMsg.MsgHeader) ZeusTransformUtils.preCheckCast(r7.next(), WsChannelMsg.MsgHeader.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r1.getKey()) == true) goto L15;
        if (TextUtils.isEmpty(r1.getValue()) == true) goto L15;
        r0.add(r1.getKey());
        r0.add(r1.getValue());
        goto L15
    L21:
        r6 = ZeusTransformUtils.preCheckCast(r0.toArray(new String[0]), String[].class, "com.obric.memorydata.plugin");
        goto L12
    }

    private static String constructQueryForProxyMode(String r2, String r3, Object r4) {
        StringBuilder r0 = new StringBuilder();
        if (TextUtils.isEmpty(r2) == true) goto L6;
        r0.append(r2);
    L6:
        if (TextUtils.isEmpty(r3) == false) goto L8;
    L18:
        long r5 = Long.parseLong((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L17
        if (r0.length() <= 0) goto L14;
        r0.append("&");     // Catch: Exception -> L17
    L14:
        r0.append("iid=" + r5);     // Catch: Exception -> L17
    L16:
        return r0.toString();
    L8:
        if (r0.length() <= 0) goto L10;
        r0.append("&");
    L10:
        r0.append(r3);
        goto L18
    }

    private CronetFrontierClient.TransportMode covertTransportMode(int r4) {
        if (r4 == 3) goto L5;
        if (r4 == 4) goto L5;
    L6:
        if (r4 == 1) goto L13;
        if (r4 == 2) goto L13;
        if (r4 == 4) goto L13;
        return CronetFrontierClient.TransportMode.QUIC;
    L13:
        return CronetFrontierClient.TransportMode.TLS;
    L5:
        this.mUsePrivateProtocolProxy.set(true);
        goto L6
    }

    public static void disableFallbackToWebSocket(boolean r0) {
        sDisableFallbackTask = r0;
    }

    private void disconnectConnection() {
        TTWebsocketConnection r0 = this.mWebsocketConnection;
        if (r0 == null) goto L5;
        r0.stopConnection();
        this.mWebsocketConnection.destroyConnection();
    L5:
        CronetFrontierClient r1 = this.mFrontierClient;
        if (r1 == null) goto L9;
        r1.destroy();
        a.a().a(FALLBACK_WEBSOCKET_TASK_ID);
        this.mIsFallbackTaskRunning.set(false);
        return;
    }

    private Map<String, String> getClientKeyHeaders() {
        return (Map) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName(CLIENT_KEY_MANAGER_CLASS, "com.obric.memorydata.plugin").getMethod("getClientKeyHeaders", new Class[0]).invoke(null, new Object[0]), Map.class, "com.obric.memorydata.plugin");
    L5:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    private static String getCookieHeader(URI r6) {
        HashMap r0 = new HashMap();
        StringBuilder r1 = new StringBuilder();
        Map<String, List<String>> r2 = null;
        CookieHandler r3 = CookieHandler.getDefault();     // Catch: Exception -> L25
        if (r3 == null) goto L6;
        r2 = r3.get(r6, r0);     // Catch: Exception -> L25
    L6:
        if (r2 == null) goto L24;
        if (r2.size() <= 0) goto L24;
        Iterator<Map.Entry<String, List<String>>> r7 = r2.entrySet().iterator();
    L11:
        if (r7.hasNext() == false) goto L24;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if ("cookie".equalsIgnoreCase((String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.memorydata.plugin")) == false) goto L11;
        if (((List) ZeusTransformUtils.preCheckCast(r4.getValue(), List.class, "com.obric.memorydata.plugin")).isEmpty() == true) goto L11;
        int r5 = 0;
        Iterator r8 = ((List) ZeusTransformUtils.preCheckCast(r4.getValue(), List.class, "com.obric.memorydata.plugin")).iterator();
    L18:
        if (r8.hasNext() == false) goto L11;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin");
        if (r5 <= 0) goto L22;
        r1.append("; ");
    L22:
        r1.append(r9);
        r5 = r5 + 1;
    L24:
        return r1.toString();
    L25:
        return null;
    }

    private long getFallbackTimeoutSeconds(Map<String, Object> r5) {
        Map r4 = (Map) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin")).get(WsConstants.KEY_HEADERS), Map.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return 10000;
    L5:
        if (r4.isEmpty() == false) goto L8;
        return 10000;
    L8:
        if (r4.containsKey(FALLBACK_TIMEOUT_MILLS) == true) goto L10;
        return 10000;
    L10:
        String r6 = (String) ZeusTransformUtils.preCheckCast(r4.get(FALLBACK_TIMEOUT_MILLS), String.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r6) == false) goto L18;
        return 10000;
    L18:
        int r7 = Integer.valueOf(r6).intValue();     // Catch: Exception -> L17
        if (r7 > 0) goto L16;
        return 10000;
    L16:
        return r7;
    L23:
        return 10000;
    }

    private boolean isAllServiceConnected() {
        if (this.mAllServiceBuildInfo.isEmpty() == false) goto L5;
        return false;
    L5:
        Iterator<Map.Entry<Integer, Boolean>> r4 = this.mAllServiceBuildInfo.entrySet().iterator();
    L7:
        if (r4.hasNext() == false) goto L11;
        if (((Boolean) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L7;
        return false;
    L11:
        return true;
    }

    private static void loadCronetKernel() {
        Object r0 = ZeusTransformUtils.forName(TTNET_INIT_CLASS, "com.obric.memorydata.plugin").newInstance();
        Reflect.on(r0).call("getInitCompletedLatch");
        Reflect.on(r0).call("preInitCronetKernel");
    }

    private static void mergeServiceId(Map<String, Object> r3, List<Integer> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        ArrayList r7 = (ArrayList) ZeusTransformUtils.preCheckCast(r5.get(WsConstants.KEY_SERVICE_ID_LIST), ArrayList.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L5;
        return;
    L5:
        if (r7.size() == 0) goto L19;
        Iterator r8 = r7.iterator();
    L9:
        if (r8.hasNext() == false) goto L20;
        int r0 = ((Integer) ZeusTransformUtils.preCheckCast(r8.next(), Integer.class, "com.obric.memorydata.plugin")).intValue();
        if (r6.contains(Integer.valueOf(r0)) == true) goto L9;
        r6.add(Integer.valueOf(r0));
        goto L9
    L20:
        return;
    }

    private void parseExtraParamsForPrivateProtocol(String r8, HashMap<String, String> r9) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return;
    L5:
        String[] r10 = r8.split("&");
        int r0 = r10.length;
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L28;
        String r3 = r10[r2];
        if (TextUtils.isEmpty(r3) == true) goto L27;
        String[] r4 = r3.split("=");
        if (r4.length != 2) goto L27;
        if (TextUtils.isEmpty(r4[0]) == true) goto L27;
        if (TextUtils.isEmpty(r4[1]) == true) goto L27;
        if (r4[0].equals(PING_INTERVAL_HEADER) == false) goto L21;
        this.mPingInterval = Integer.valueOf(r4[1]).intValue() * 1000;     // Catch: NumberFormatException -> L29
        goto L27
    L21:
        if (r4[0].equals(TIME_OUT_HEADER) == false) goto L25;
        this.mTimeOut = Integer.valueOf(r4[1]).intValue();     // Catch: NumberFormatException -> L29
        goto L27
    L25:
        if (this.mUsePrivateProtocolProxy.get() == true) goto L27;
        r9.put(r4[0], r4[1]);
    L27:
        r2 = r2 + 1;
        goto L6
    }

    private URI parsePrivateProtocolUrl(Map<String, Object> r3) {
        String r2 = (String) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin")).get(WsConstants.KEY_PRIVATE_PROTOCOL_URL), String.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return null;
    L5:
        sPrivateProtocolUrl = r2;
        if (r2.startsWith("wss:") == false) goto L11;
        StringBuilder r4 = new StringBuilder().append("https:");     // Catch: Throwable -> L15
        String r5 = r2.substring(4);     // Catch: Throwable -> L15
    L9:
        r2 = r4.append(r5).toString();     // Catch: Throwable -> L15
    L13:
        return k.a(r2);
    L11:
        if (r2.startsWith("ws:") == false) goto L13;
        r4 = new StringBuilder().append("http:");     // Catch: Throwable -> L15
        r5 = r2.substring(3);     // Catch: Throwable -> L15
    L18:
        return null;
    }

    private void registerServiceById(int r3, ByteBuffer r4, String[] r5) {
        if (this.mFrontierClient == null) goto L6;
        TTServiceInfo r0 = new TTServiceInfo(r3, new ServiceMessageReceiverImpl(this));
        this.mFrontierClient.registerService(r0, r4, r5);
        return;
    }

    private void reportAppStateChange(List<WsChannelMsg.MsgHeader> r5) {
        Iterator r6 = ((List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r6.hasNext() == false) goto L32;
        WsChannelMsg.MsgHeader r0 = (WsChannelMsg.MsgHeader) ZeusTransformUtils.preCheckCast(r6.next(), WsChannelMsg.MsgHeader.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L4;
        if (WsConstants.APP_STATE_BACKGROUND_KEY.equals(r0.getKey()) == false) goto L4;
        String r7 = r0.getValue();
        boolean r1 = false;
        if (r7.equals("1") == false) goto L13;
        this.mAppState = 1;
    L16:
        if (this.mIsFirstStreamReady == true) goto L18;
        return;
    L18:
        if (this.mAppState == (-1)) goto L31;
        CronetFrontierClient r8 = this.mFrontierClient;
        if (this.mAppState != 1) goto L22;
        r1 = true;
    L22:
        r8.reportAppStateChange(r1);
        return;
    L31:
        return;
    L13:
        if (r7.equals("0") == false) goto L16;
        this.mAppState = 0;
        goto L16
    }

    private void reportPrivateProtocolRelatedLog(JSONObject r3, int r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        r3.put("report_type", r4);
        r3.put("report_time", System.currentTimeMillis());
        if (Logger.debug() == false) goto L7;
        Logger.d(TAG, "report log:" + r3.toString());
    L7:
        CronetAppProviderManager.inst().sendAppMonitorEvent(r3.toString(), LOG_TYPE);
    }

    private void startConnectionWithPrivateProtocol(Map<String, Object> r21, URI r22) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r21, Map.class, "com.obric.memorydata.plugin");
        int r0 = r22.getPort();
        String r4 = r22.getPath();
        String r5 = r22.getQuery();
        if (r0 > 0) goto L5;
        r0 = UploadKeys.KeyIsGetVideoMeta;
    L5:
        int r9 = r0;
        if (Logger.debug() == false) goto L8;
        Logger.d(TAG, "PP connection host:" + r22.getHost() + ParameterizedMessage.ERROR_MSG_SEPARATOR + r9 + r4 + "?" + r5);
    L8:
        CronetFrontierClient.TransportMode r14 = covertTransportMode(((Integer) ZeusTransformUtils.preCheckCast(r3.get(WsConstants.KEY_TRANSPORT_MODE), Integer.class, "com.obric.memorydata.plugin")).intValue());
        sMode = r14;
        ArrayList r15 = new ArrayList();
        if (this.mUsePrivateProtocolProxy.get() == false) goto L11;
        r15.add(1);
    L14:
        HashMap<String, String> r11 = new HashMap();
        String r10 = (String) ZeusTransformUtils.preCheckCast(r3.get(WsConstants.KEY_EXTRA), String.class, "com.obric.memorydata.plugin");
        parseExtraParamsForPrivateProtocol(r10, r11);
        Map<String, String> r1 = getClientKeyHeaders();     // Catch: Throwable -> L36
        if (Logger.debug() == false) goto L18;
        Logger.d(TAG, "PP client key: " + r1);     // Catch: Throwable -> L36
    L18:
        if (r1 != null) goto L20;
    L22:
        Map<? extends String, ? extends String> r2 = (Map) ZeusTransformUtils.preCheckCast(r3.get(WsConstants.KEY_HEADERS), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L36
        if (r2 == null) goto L28;
        if (r2.isEmpty() == true) goto L28;
        r11.putAll(r2);     // Catch: Throwable -> L36
    L28:
        if (privateProtocolProxyEnabled() == false) goto L38;
        String r6 = MySelfChannelImpl.getDefaultUserAgent();     // Catch: Throwable -> L36
        if (TextUtils.isEmpty(r6) == true) goto L32;
        r11.put("user-agent", r6);     // Catch: Throwable -> L36
    L32:
        String r7 = getCookieHeader(r22);     // Catch: Throwable -> L36
        if (TextUtils.isEmpty(r7) == true) goto L38;
        r11.put("cookie", r7);     // Catch: Throwable -> L36
    L38:
        this.mAllServiceBuildInfo.clear();
        DestroyTimeoutControl r8 = this.mDestroyTimeoutControl;
        if (r8 != null) goto L41;
    L46:
        CronetFrontierClient.Builder r12 = CronetFrontierClient.Builder.create(((Integer) ZeusTransformUtils.preCheckCast(r3.get("aid"), Integer.class, "com.obric.memorydata.plugin")).intValue(), ((Integer) ZeusTransformUtils.preCheckCast(r3.get(WsConstants.KEY_FPID), Integer.class, "com.obric.memorydata.plugin")).intValue(), r22.getHost(), r9, Integer.toString(((Integer) ZeusTransformUtils.preCheckCast(r3.get("app_version"), Integer.class, "com.obric.memorydata.plugin")).intValue()), (String) ZeusTransformUtils.preCheckCast(r3.get("device_id"), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r3.get(WsConstants.KEY_APP_KEY), String.class, "com.obric.memorydata.plugin")).pingInterval(this.mPingInterval).timeout(this.mTimeOut).transportMode(r14).headers(r11).callback(new PrivateProtocolCallbackImpl(this.mWsChannelClient, this));
        if (this.mUsePrivateProtocolProxy.get() == false) goto L53;
        r12.proxy(true);
        String r13 = constructQueryForProxyMode(r5, r10, r3.get("iid"));
        if (Logger.debug() == false) goto L51;
        String r16 = TAG;
        Logger.d(r16, "PP connection real query:" + r13 + " path:" + r4);
    L52:
        r12.query(r13);
        r12.path(r4);
    L54:
        r12.uniqueServiceIdList(r15);
        this.mFrontierClient = r12.build();
        if (Logger.debug() == false) goto L57;
        Logger.d(r16, "Register serviceIdList: " + r15 + " mode:" + r14);
    L57:
        Iterator r17 = r15.iterator();
    L59:
        if (r17.hasNext() == false) goto L61;
        Integer r18 = (Integer) ZeusTransformUtils.preCheckCast(r17.next(), Integer.class, "com.obric.memorydata.plugin");
        registerServiceById(r18.intValue(), null, null);
        this.mAllServiceBuildInfo.put(r18, false);
        goto L59
    L61:
        return;
    L51:
        r16 = TAG;
        goto L52
    L53:
        r16 = TAG;
        goto L54
    L41:
        if (r8.getPrivateProtocolTimeout() <= 0) goto L46;
        int r19 = (int) this.mDestroyTimeoutControl.getPrivateProtocolTimeout();
        if (Logger.debug() == false) goto L45;
        Logger.d(TAG, "PP destroy timeout:" + r19);
    L45:
        this.mTimeOut = r19;
        goto L46
    L20:
        if (r1.isEmpty() == true) goto L22;
        r11.putAll(r1);     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        th.printStackTrace();
        goto L38
    L11:
        r15.add(9000);
        if (f.p() == true) goto L14;
        mergeServiceId(r3, r15);
        goto L14
    }

    private void startConnectionWithWebSocket(Map<String, Object> r12, List<String> r13) {
        Map r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        List<String> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        this.mUsePrivateProtocol.set(false);
        this.mUsePrivateProtocolProxy.set(false);
        if (sFirstConnection.incrementAndGet() <= 1) goto L5;
        this.mSharedConnection = false;
    L5:
        Object r2 = r14.get(WsConstants.KEY_CHANNEL_ID);
        if (r2 != null) goto L8;
        int r3 = -1;
    L10:
        if (sChannelID != (-1)) goto L15;
        if (r3 <= 0) goto L15;
        if (sFirstConnection.get() != 1) goto L15;
        sChannelID = r3;
    L15:
        TTWebsocketConnection.Builder r6 = sCronetEngine.newWebsocketConnectionBuilder(this.mCallback, Executors.newSingleThreadExecutor());
        r6.setUrlList(r15);     // Catch: Throwable -> L63
        r6.setAppKey(String.valueOf(r14.get(WsConstants.KEY_APP_KEY)));     // Catch: Throwable -> L63
        r6.setFpid(((Integer) ZeusTransformUtils.preCheckCast(r14.get(WsConstants.KEY_FPID), Integer.class, "com.obric.memorydata.plugin")).intValue());     // Catch: Throwable -> L63
        r6.setAppVersion(((Integer) ZeusTransformUtils.preCheckCast(r14.get("app_version"), Integer.class, "com.obric.memorydata.plugin")).intValue());     // Catch: Throwable -> L63
        r6.setAppId(((Integer) ZeusTransformUtils.preCheckCast(r14.get("aid"), Integer.class, "com.obric.memorydata.plugin")).intValue());     // Catch: Throwable -> L63
        r6.setDeviceId(Long.parseLong((String) ZeusTransformUtils.preCheckCast(r14.get("device_id"), String.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L63
        r6.setInstallId(Long.parseLong((String) ZeusTransformUtils.preCheckCast(r14.get("iid"), String.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L63
        if (r3 > 0) goto L19;
    L21:
        r6.setSharedConnection(false);     // Catch: Throwable -> L63
        if (r14.containsKey("sid") == false) goto L24;
        r6.setSessionId((String) ZeusTransformUtils.preCheckCast(r14.get("sid"), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L63
    L24:
        String r16 = (String) ZeusTransformUtils.preCheckCast(r14.get(WsConstants.KEY_EXTRA), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L63
        HashMap r1 = new HashMap();     // Catch: Throwable -> L63
        if (TextUtils.isEmpty(r16) == true) goto L68;
        String[] r17 = r16.split("&");     // Catch: Throwable -> L63
        int r4 = r17.length;     // Catch: Throwable -> L63
        int r7 = 0;
    L27:
        if (r7 >= r4) goto L68;
        String r8 = r17[r7];     // Catch: Throwable -> L63
        if (TextUtils.isEmpty(r8) == true) goto L33;
        String[] r9 = r8.split("=");     // Catch: Throwable -> L63
        if (r9.length != 2) goto L33;
        r1.put(r9[0], r9[1]);     // Catch: Throwable -> L63
    L33:
        r7 = r7 + 1;
    L68:
        HashMap r18 = new HashMap();     // Catch: Throwable -> L50
        Map<String, String> r5 = getClientKeyHeaders();     // Catch: Throwable -> L50
        if (Logger.debug() == false) goto L37;
        Logger.d(TAG, "Client key: " + r5);     // Catch: Throwable -> L50
    L37:
        if (r5 != null) goto L39;
    L41:
        Map r19 = (Map) ZeusTransformUtils.preCheckCast(r14.get(WsConstants.KEY_HEADERS), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L50
        if (r19 == null) goto L47;
        if (r19.isEmpty() == true) goto L47;
        r18.putAll(r19);     // Catch: Throwable -> L50
    L47:
        if (r18.isEmpty() == true) goto L52;
        r6.setCustomizedHeaders(r18);     // Catch: Throwable -> L50
    L52:
        DestroyTimeoutControl r110 = this.mDestroyTimeoutControl;     // Catch: Throwable -> L63
        if (r110 != null) goto L55;
    L60:
        r6.setCustomizedParams(r1);     // Catch: Throwable -> L63
        TTWebsocketConnection r111 = r6.build();
        this.mWebsocketConnection = r111;
        r111.startConnection();
        return;
    L55:
        if (r110.getWebsocketTimeout() <= 0) goto L60;
        long r112 = this.mDestroyTimeoutControl.getWebsocketTimeout();     // Catch: Throwable -> L63
        if (Logger.debug() == false) goto L59;
        Logger.d(TAG, "WS destroy timeout:" + r112);     // Catch: Throwable -> L63
    L59:
        r1.put(TIME_OUT_HEADER, String.valueOf(r112));     // Catch: Throwable -> L63
        goto L60
    L39:
        if (r5.isEmpty() == true) goto L41;
        r18.putAll(r5);     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L63
        goto L52
    L19:
        if (r3 != sChannelID) goto L21;
        this.mSharedConnection = true;     // Catch: Throwable -> L63
    L63:
        th = move-exception;
        th.printStackTrace();
        throw new IllegalArgumentException("configMap contain err params !!!");
    L8:
        r3 = ((Integer) ZeusTransformUtils.preCheckCast(r2, Integer.class, "com.obric.memorydata.plugin")).intValue();
        goto L10
    }

    public void destroyConnection() {
        disconnectConnection();
    }

    public boolean isConnected() {
        if (this.mUsePrivateProtocol.get() == false) goto L9;
        CronetFrontierClient r0 = this.mFrontierClient;
        if (r0 == null) goto L9;
        return r0.isConnected();
    L9:
        if (this.mUsePrivateProtocol.get() == true) goto L14;
        TTWebsocketConnection r1 = this.mWebsocketConnection;
        if (r1 != null) goto L13;
        return false;
    L13:
        return r1.isConnected();
    L14:
        return false;
    }

    public boolean isFallbackTaskRunning() {
        return this.mIsFallbackTaskRunning.get();
    }

    public boolean privateProtocolEnabled() {
        return this.mUsePrivateProtocol.get();
    }

    public boolean privateProtocolProxyEnabled() {
        return this.mUsePrivateProtocolProxy.get();
    }

    public void registerService(int r1) {
    }

    public boolean sendMessageWithPrivateProtocol(WsChannelMsg r6) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "PP sendMessage data:" + r6.toString());
    L6:
        if (this.mFrontierClient == null) goto L19;
        if (r6 == null) goto L21;
        int r0 = r6.getService();
        if (r0 == 9000) goto L12;
    L15:
        String[] r2 = constructMessageMetaInfo(r6);
        ByteBuffer r4 = ByteBuffer.allocateDirect(r6.getPayload().length);
        r4.put(r6.getPayload());
        this.mFrontierClient.sendMessage(r0, r2, r4);
        if (Logger.debug() == false) goto L18;
        Logger.d(TAG, "PP sendMessage serviceId:" + r0);
    L18:
        return true;
    L12:
        if (r6.getMethod() != 4) goto L15;
        reportAppStateChange(r6.getMsgHeaders());
        return true;
    L21:
        return false;
    L19:
        return false;
    }

    public boolean sendMessageWithPrivateProtocolProxy(byte[] r4) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "PP proxy sendMessage data:" + r4.toString());
    L5:
        CronetFrontierClient r0 = this.mFrontierClient;
        if (r0 == null) goto L14;
        if (r4 != null) goto L10;
        return false;
    L10:
        if (r0.isServiceExisted(1) == true) goto L12;
        registerServiceById(1, null, null);
    L12:
        ByteBuffer r1 = ByteBuffer.allocateDirect(r4.length);
        r1.put(r4);
        this.mFrontierClient.sendMessage(1, null, r1);
        return true;
    L14:
        return false;
    }

    public boolean sendMessageWithWebSocket(byte[] r3) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "WS sendMessage data:" + r3);
    L6:
        if (this.mWebsocketConnection != null) goto L9;
        return false;
    L9:
        ByteBuffer r0 = ByteBuffer.allocateDirect(r3.length);
        r0.put(r3);
        this.mWebsocketConnection.asyncSendBinary(r0);
        return true;
    }

    public void setFirstStreamReady(boolean r1) {
        this.mIsFirstStreamReady = r1;
    }

    public void startConnection(Map<String, Object> r10, List<String> r11) {
        Map<String, Object> r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.memorydata.plugin");
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L40;
        if (r7.size() <= 0) goto L40;
        boolean r0 = false;
        if (Logger.debug() == false) goto L9;
        Logger.d(TAG, "openConnection url:" + ((String) ZeusTransformUtils.preCheckCast(r7.get(0), String.class, "com.obric.memorydata.plugin")));
    L9:
        if (r12 == null) goto L38;
        if (r12.isEmpty() == true) goto L38;
        destroyConnection();
        if (canUsePrivateProtocol(r12) == true) goto L16;
        this.mDestroyTimeoutControl = new DestroyTimeoutControl(r12, true);
        startConnectionWithWebSocket(r12, r7);
        return;
    L16:
        URI r13 = parsePrivateProtocolUrl(r12);
        if (r13 != null) goto L20;
        this.mDestroyTimeoutControl = new DestroyTimeoutControl(r12, true);
        startConnectionWithWebSocket(r12, r7);
        return;
    L20:
        this.mDestroyTimeoutControl = new DestroyTimeoutControl(r12, false);
        Object r3 = r12.get(WsConstants.KEY_DISABLE_FALLBACK_WEBSOCKET);
        if (r3 == null) goto L24;
        r0 = ((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L24:
        if (Logger.debug() == false) goto L27;
        Logger.d(TAG, "DisableFallbackTask:" + sDisableFallbackTask + " DisableFallbackWS:" + r0);
    L27:
        if (sDisableFallbackTask == true) goto L35;
        if (r0 == true) goto L35;
        if (this.mDestroyTimeoutControl.shouldFallbackToWebSocket() == false) goto L35;
        long r4 = getFallbackTimeoutSeconds(r12);
        if (Logger.debug() == false) goto L34;
        Logger.d(TAG, "Fallback to websocket timeout:" + r4);
    L34:
        a.a().a(new FallbackWebSocketTask(this, r4, r12, r7));
        this.mIsFallbackTaskRunning.set(true);
    L35:
        this.mUsePrivateProtocol.set(true);
        startConnectionWithPrivateProtocol(r12, r13);
        return;
    L38:
        throw new IllegalArgumentException("configMap is empty !!!");
    L40:
        throw new IllegalArgumentException("urls size <= 0 !!!");
    }

    public void stopConnection() {
        disconnectConnection();
    }

    public void unregisterService(int r1) {
    }
}
