package org.chromium.wschannel;

import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.bytedance.frameworks.baselib.network.http.util.a;
import com.bytedance.frameworks.baselib.network.http.util.b;
import com.bytedance.frameworks.baselib.network.http.util.k;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.clientkey.ClientKeyManager;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.TTWebsocketConnection;
import com.ttnet.org.chromium.net.impl.CronetFrontierClient;
import com.ttnet.org.chromium.net.impl.TTServiceInfo;
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
import o2.f;
import org.chromium.CronetAppProviderManager;
import org.chromium.CronetClient;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
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

        public FallbackWebSocketTask(CronetFrontierConnection r10, long r11, Map<String, Object> r12, List<String> r13) {
            this.this$0 = r10;
            super(r11, CronetFrontierConnection.access$800());
            this.mConfigMap = r12;
            this.mUrls = r13;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CronetFrontierConnection.access$500(this.this$0) == false) goto L6;
            CronetFrontierConnection.access$900(this.this$0).set(0);
            CronetFrontierConnection.access$1000(this.this$0).set(false);
            return;
        L6:
            int r10 = CronetFrontierConnection.access$900(this.this$0).incrementAndGet();
            if (Logger.debug() == false) goto L9;
            Logger.d(CronetFrontierConnection.TAG, "Fallback to websocket connection, retry attempts:" + r10);
        L9:
            this.this$0.destroyConnection();
            CronetFrontierConnection.access$1100(this.this$0, this.mConfigMap, this.mUrls);
            JSONObject r11 = new JSONObject();     // Catch: JSONException -> L12
            r11.put(ICronetClient.KEY_RETRY_ATTEMPTS, r10);     // Catch: JSONException -> L12
            r11.put("reason", "connect timeout fallback");     // Catch: JSONException -> L12
            CronetFrontierConnection.access$1200(this.this$0, r11, 1);     // Catch: JSONException -> L12
            return;
        L12:
            e = move-exception;
            e.printStackTrace();
        }
    }

    class ServiceMessageReceiverImpl implements CronetFrontierClient.IServiceMessageReceiver {
        final /* synthetic */ CronetFrontierConnection this$0;

        ServiceMessageReceiverImpl(CronetFrontierConnection r10) {
            this.this$0 = r10;
        }

        @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.IServiceMessageReceiver
        public void onError(int r10, int r11, String r12) {
            if (Logger.debug() == false) goto L5;
            Logger.d(CronetFrontierConnection.TAG, "onError ServiceId:" + r10 + " error code:" + r11 + " info:" + r12);
        L5:
            CronetFrontierConnection.access$700(this.this$0).onServiceConnectEvent(r10, false, "");
        }

        @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.IServiceMessageReceiver
        public void onReceivedAck(int r10, long r11, String r12, Boolean r13) {
            if (Logger.debug() == false) goto L6;
            Logger.d(CronetFrontierConnection.TAG, "onReceivedAck serviceId:" + r10 + " messageId:" + r11 + " logInfo:" + r12);
            return;
        }

        @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.IServiceMessageReceiver
        public void onReceivedMessage(int r10, Map<String, String> r11, byte[] r12) {
            if (CronetFrontierConnection.access$400(this.this$0).get() == false) goto L10;
            if (Logger.debug() == false) goto L7;
            Logger.d(CronetFrontierConnection.TAG, "proxy onReceivedMessage service id:" + r10 + " data length:" + r12.length);
        L7:
            CronetFrontierConnection.access$700(this.this$0).onMessage(r12);
            return;
        L10:
            if (Logger.debug() == false) goto L12;
            Logger.d(CronetFrontierConnection.TAG, "onReceivedMessage service id:" + r10 + " data length:" + r12.length);
        L12:
            WsChannelMsg r13 = new WsChannelMsg();
            r13.setService(r10);
            ArrayList r14 = new ArrayList();
            Iterator<Map.Entry<String, String>> r15 = r11.entrySet().iterator();
        L14:
            if (r15.hasNext() == false) goto L39;
            Map.Entry<String, String> r16 = r15.next();
            if (TextUtils.isEmpty(r16.getKey()) == true) goto L14;
            if (TextUtils.isEmpty(r16.getValue()) == true) goto L14;
            if (r16.getKey().equals(CronetFrontierConnection.METHOD_ID_HEADER) == false) goto L27;
            r13.setMethod(Integer.valueOf(r16.getValue()).intValue());     // Catch: NumberFormatException -> L24
        L24:
            e = move-exception;
            Logger.e(CronetFrontierConnection.TAG, "method_id is not valid: " + r16.getValue());
            e.printStackTrace();
            goto L14
        L27:
            if (r16.getKey().equalsIgnoreCase(CronetFrontierConnection.PAYLOAD_ENCODING_HEADER) == true) goto L28;
            if (r16.getKey().equalsIgnoreCase(CronetFrontierConnection.PAYLOAD_TYPE_HEADER) == true) goto L31;
            if (r16.getKey().equalsIgnoreCase(CronetFrontierConnection.MSG_ID_HEADER) == true) goto L34;
            if (r16.getKey().equalsIgnoreCase(CronetFrontierConnection.MSG_SERVER_TIMING_HEADER) == true) goto L37;
            WsChannelMsg.MsgHeader r17 = new WsChannelMsg.MsgHeader();
            r17.setKey(r16.getKey());
            r17.setValue(r16.getValue());
            r14.add(r17);
            goto L14
        L37:
            r13.setServerTiming(r16.getValue());
            goto L14
        L34:
            r13.setMsgId(r16.getValue());
            goto L14
        L31:
            r13.setPayloadType(r16.getValue());
            goto L14
        L28:
            r13.setPayloadEncoding(r16.getValue());
            goto L14
        L39:
            r13.setMsgHeaders(r14);
            r13.setPayload(r12);
            if (r13.getPayloadEncoding() != null) goto L43;
            r13.setPayloadEncoding("");
        L43:
            if (r13.getPayloadType() != null) goto L46;
            r13.setPayloadType("");
        L46:
            if (Logger.debug() == false) goto L48;
            Logger.d(CronetFrontierConnection.TAG, "onReceivedMessage:" + r13);
        L48:
            CronetFrontierConnection.access$700(this.this$0).onMessage(r13);
        }

        @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.IServiceMessageReceiver
        public void onServiceReady(int r10, String r11) {
            if (Logger.debug() == false) goto L6;
            Logger.d(CronetFrontierConnection.TAG, "onServiceReady ServiceId:" + r10 + " log info:" + r11);
        L6:
            if (CronetFrontierConnection.access$000(this.this$0) == true) goto L16;
            CronetFrontierConnection.access$002(this.this$0, true);
            if (CronetFrontierConnection.access$100(this.this$0) == null) goto L16;
            if (CronetFrontierConnection.access$200(this.this$0) == (-1)) goto L16;
            CronetFrontierClient r12 = CronetFrontierConnection.access$100(this.this$0);
            if (CronetFrontierConnection.access$200(this.this$0) != 1) goto L14;
            boolean r13 = true;
        L15:
            r12.reportAppStateChange(r13);
            goto L16
        L14:
            r13 = false;
        L16:
            CronetFrontierConnection.access$300(this.this$0).put(Integer.valueOf(r10), Boolean.TRUE);
            if (this.this$0.isFallbackTaskRunning() == true) goto L19;
        L26:
            CronetFrontierConnection.access$700(this.this$0).onServiceConnectEvent(r10, true, "");
            return;
        L19:
            if (CronetFrontierConnection.access$400(this.this$0).get() == false) goto L26;
            if (CronetFrontierConnection.access$500(this.this$0) == false) goto L26;
            JSONObject r14 = new JSONObject();     // Catch: Throwable -> L28
            r14.put(WsConstants.KEY_CONNECTION_TYPE, 1);     // Catch: Throwable -> L28
            r14.put(WsConstants.KEY_PRIVATE_PROTOCOL_ENABLE, 1);     // Catch: Throwable -> L28
            r14.put("state", 4);     // Catch: Throwable -> L28
            r14.put("url", CronetFrontierConnection.access$600());     // Catch: Throwable -> L28
            if (Logger.debug() == false) goto L25;
            Logger.d(CronetFrontierConnection.TAG, "PP onConnectionStateChanged state: 4 url:" + CronetFrontierConnection.access$600());     // Catch: Throwable -> L28
        L25:
            CronetFrontierConnection.access$700(this.this$0).onConnection(r14);     // Catch: Throwable -> L28
            goto L26
        }
    }

    static {
        FALLBACK_WEBSOCKET_TASK_ID = UUID.randomUUID().toString();
        sDisableFallbackTask = false;
        sMode = CronetFrontierClient.TransportMode.QUIC;
        sFirstConnection = new AtomicInteger(0);
        sChannelID = -1;
    }

    public CronetFrontierConnection(IWsChannelClient r10) {
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
        this.mWsChannelClient = r10;
        this.mCallback = new WebSocketCallbackImpl(r10);
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

    static /* synthetic */ boolean access$000(CronetFrontierConnection r10) {
        return r10.mIsFirstStreamReady;
    }

    static /* synthetic */ boolean access$002(CronetFrontierConnection r10, boolean r11) {
        r10.mIsFirstStreamReady = r11;
        return r11;
    }

    static /* synthetic */ CronetFrontierClient access$100(CronetFrontierConnection r10) {
        return r10.mFrontierClient;
    }

    static /* synthetic */ AtomicBoolean access$1000(CronetFrontierConnection r10) {
        return r10.mIsFallbackTaskRunning;
    }

    static /* synthetic */ void access$1100(CronetFrontierConnection r10, Map r11, List r12) {
        r10.startConnectionWithWebSocket(r11, r12);
    }

    static /* synthetic */ void access$1200(CronetFrontierConnection r10, JSONObject r11, int r12) {
        r10.reportPrivateProtocolRelatedLog(r11, r12);
    }

    static /* synthetic */ int access$200(CronetFrontierConnection r10) {
        return r10.mAppState;
    }

    static /* synthetic */ Map access$300(CronetFrontierConnection r10) {
        return r10.mAllServiceBuildInfo;
    }

    static /* synthetic */ AtomicBoolean access$400(CronetFrontierConnection r10) {
        return r10.mUsePrivateProtocolProxy;
    }

    static /* synthetic */ boolean access$500(CronetFrontierConnection r10) {
        return r10.isAllServiceConnected();
    }

    static /* synthetic */ String access$600() {
        return sPrivateProtocolUrl;
    }

    static /* synthetic */ IWsChannelClient access$700(CronetFrontierConnection r10) {
        return r10.mWsChannelClient;
    }

    static /* synthetic */ String access$800() {
        return FALLBACK_WEBSOCKET_TASK_ID;
    }

    static /* synthetic */ AtomicInteger access$900(CronetFrontierConnection r10) {
        return r10.mRetryAttempts;
    }

    private boolean canUsePrivateProtocol(Map<String, Object> r10) {
        if (f.y() == false) goto L12;
        if (this.mRetryAttempts.get() >= 3) goto L12;
        Object r11 = r10.get(WsConstants.KEY_PRIVATE_PROTOCOL_ENABLE);
        if (r11 != null) goto L10;
        return false;
    L10:
        return ((Boolean) r11).booleanValue();
    L12:
        if (Logger.debug() == false) goto L14;
        Logger.d(TAG, "Retry attempts:" + this.mRetryAttempts.get() + ",tnc enabled:" + f.y());
    L14:
        return false;
    }

    private static String[] constructMessageMetaInfo(WsChannelMsg r10) {
        ArrayList r11 = new ArrayList();
        r11.add(METHOD_ID_HEADER);
        r11.add(String.valueOf(r10.getMethod()));
        if (TextUtils.isEmpty(r10.getPayloadType()) == true) goto L6;
        r11.add(PAYLOAD_TYPE_HEADER);
        r11.add(r10.getPayloadType());
    L6:
        if (TextUtils.isEmpty(r10.getPayloadEncoding()) == true) goto L9;
        r11.add(PAYLOAD_ENCODING_HEADER);
        r11.add(r10.getPayloadEncoding());
    L9:
        if (r10.getMsgHeaders() != null) goto L13;
        Object[] r12 = r11.toArray(new String[0]);
    L12:
        return (String[]) r12;
    L13:
        Iterator<WsChannelMsg.MsgHeader> r13 = r10.getMsgHeaders().iterator();
    L15:
        if (r13.hasNext() == false) goto L21;
        WsChannelMsg.MsgHeader r14 = r13.next();
        if (TextUtils.isEmpty(r14.getKey()) == true) goto L15;
        if (TextUtils.isEmpty(r14.getValue()) == true) goto L15;
        r11.add(r14.getKey());
        r11.add(r14.getValue());
        goto L15
    L21:
        r12 = r11.toArray(new String[0]);
        goto L12
    }

    private static String constructQueryForProxyMode(String r10, String r11, Object r12) {
        StringBuilder r13 = new StringBuilder();
        if (TextUtils.isEmpty(r10) == true) goto L6;
        r13.append(r10);
    L6:
        if (TextUtils.isEmpty(r11) == false) goto L8;
    L18:
        long r14 = Long.parseLong((String) r12);     // Catch: Exception -> L17
        if (r13.length() <= 0) goto L14;
        r13.append("&");     // Catch: Exception -> L17
    L14:
        r13.append("iid=" + r14);     // Catch: Exception -> L17
    L16:
        return r13.toString();
    L8:
        if (r13.length() <= 0) goto L10;
        r13.append("&");
    L10:
        r13.append(r11);
        goto L18
    }

    private CronetFrontierClient.TransportMode covertTransportMode(int r10) {
        if (r10 == 3) goto L5;
        if (r10 == 4) goto L5;
    L6:
        if (r10 == 1) goto L13;
        if (r10 == 2) goto L13;
        if (r10 == 4) goto L13;
        return CronetFrontierClient.TransportMode.QUIC;
    L13:
        return CronetFrontierClient.TransportMode.TLS;
    L5:
        this.mUsePrivateProtocolProxy.set(true);
        goto L6
    }

    public static void disableFallbackToWebSocket(boolean r10) {
        sDisableFallbackTask = r10;
    }

    private void disconnectConnection() {
        TTWebsocketConnection r10 = this.mWebsocketConnection;
        if (r10 == null) goto L5;
        r10.stopConnection();
        this.mWebsocketConnection.destroyConnection();
    L5:
        CronetFrontierClient r11 = this.mFrontierClient;
        if (r11 == null) goto L9;
        r11.destroy();
        a.d().f(FALLBACK_WEBSOCKET_TASK_ID);
        this.mIsFallbackTaskRunning.set(false);
        return;
    }

    private Map<String, String> getClientKeyHeaders() {
        int r10 = ClientKeyManager.f2796n;     // Catch: Throwable -> L5
        return (Map) ClientKeyManager.class.getMethod("getClientKeyHeaders", new Class[0]).invoke(null, new Object[0]);
    L5:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    private static String getCookieHeader(URI r10) {
        HashMap r11 = new HashMap();
        StringBuilder r12 = new StringBuilder();
        Map<String, List<String>> r13 = null;
        CookieHandler r14 = CookieHandler.getDefault();     // Catch: Exception -> L25
        if (r14 == null) goto L6;
        r13 = r14.get(r10, r11);     // Catch: Exception -> L25
    L6:
        if (r13 == null) goto L24;
        if (r13.size() <= 0) goto L24;
        Iterator<Map.Entry<String, List<String>>> r15 = r13.entrySet().iterator();
    L11:
        if (r15.hasNext() == false) goto L24;
        Map.Entry<String, List<String>> r16 = r15.next();
        if ("cookie".equalsIgnoreCase(r16.getKey()) == false) goto L11;
        if (r16.getValue().isEmpty() == true) goto L11;
        int r17 = 0;
        Iterator<String> r18 = r16.getValue().iterator();
    L18:
        if (r18.hasNext() == false) goto L11;
        String r19 = r18.next();
        if (r17 <= 0) goto L22;
        r12.append("; ");
    L22:
        r12.append(r19);
        r17 = r17 + 1;
    L24:
        return r12.toString();
    L25:
        return null;
    }

    private long getFallbackTimeoutSeconds(Map<String, Object> r10) {
        Map r11 = (Map) r10.get(WsConstants.KEY_HEADERS);
        if (r11 != null) goto L5;
        return WorkRequest.MIN_BACKOFF_MILLIS;
    L5:
        if (r11.isEmpty() == false) goto L8;
        return WorkRequest.MIN_BACKOFF_MILLIS;
    L8:
        if (r11.containsKey(FALLBACK_TIMEOUT_MILLS) == true) goto L10;
        return WorkRequest.MIN_BACKOFF_MILLIS;
    L10:
        String r12 = (String) r11.get(FALLBACK_TIMEOUT_MILLS);
        if (TextUtils.isEmpty(r12) == false) goto L18;
        return WorkRequest.MIN_BACKOFF_MILLIS;
    L18:
        int r13 = Integer.valueOf(r12).intValue();     // Catch: Exception -> L17
        if (r13 > 0) goto L16;
        return WorkRequest.MIN_BACKOFF_MILLIS;
    L16:
        return r13;
    L23:
        return WorkRequest.MIN_BACKOFF_MILLIS;
    }

    private boolean isAllServiceConnected() {
        if (this.mAllServiceBuildInfo.isEmpty() == false) goto L5;
        return false;
    L5:
        Iterator<Map.Entry<Integer, Boolean>> r10 = this.mAllServiceBuildInfo.entrySet().iterator();
    L7:
        if (r10.hasNext() == false) goto L11;
        if (r10.next().getValue().booleanValue() == true) goto L7;
        return false;
    L11:
        return true;
    }

    private static void loadCronetKernel() {
        String r10 = TTNetInit.DOMAIN_HTTPDNS_KEY;
        Object r11 = TTNetInit.class.newInstance();
        Reflect.on(r11).call("getInitCompletedLatch");
        Reflect.on(r11).call("preInitCronetKernel");
    }

    private static void mergeServiceId(Map<String, Object> r10, List<Integer> r11) {
        ArrayList r12 = (ArrayList) r10.get(WsConstants.KEY_SERVICE_ID_LIST);
        if (r12 != null) goto L5;
        return;
    L5:
        if (r12.size() == 0) goto L19;
        Iterator r13 = r12.iterator();
    L9:
        if (r13.hasNext() == false) goto L20;
        int r14 = ((Integer) r13.next()).intValue();
        if (r11.contains(Integer.valueOf(r14)) == true) goto L9;
        r11.add(Integer.valueOf(r14));
        goto L9
    L20:
        return;
    }

    private void parseExtraParamsForPrivateProtocol(String r10, HashMap<String, String> r11) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        String[] r12 = r10.split("&");
        int r13 = r12.length;
        int r14 = 0;
    L6:
        if (r14 >= r13) goto L28;
        String r15 = r12[r14];
        if (TextUtils.isEmpty(r15) == true) goto L27;
        String[] r16 = r15.split("=");
        if (r16.length != 2) goto L27;
        if (TextUtils.isEmpty(r16[0]) == true) goto L27;
        if (TextUtils.isEmpty(r16[1]) == true) goto L27;
        if (r16[0].equals(PING_INTERVAL_HEADER) == false) goto L21;
        this.mPingInterval = Integer.valueOf(r16[1]).intValue() * 1000;     // Catch: NumberFormatException -> L29
        goto L27
    L21:
        if (r16[0].equals(TIME_OUT_HEADER) == false) goto L25;
        this.mTimeOut = Integer.valueOf(r16[1]).intValue();     // Catch: NumberFormatException -> L29
        goto L27
    L25:
        if (this.mUsePrivateProtocolProxy.get() == true) goto L27;
        r11.put(r16[0], r16[1]);
    L27:
        r14 = r14 + 1;
        goto L6
    }

    private URI parsePrivateProtocolUrl(Map<String, Object> r10) {
        String r11 = (String) r10.get(WsConstants.KEY_PRIVATE_PROTOCOL_URL);
        if (TextUtils.isEmpty(r11) == false) goto L5;
        return null;
    L5:
        sPrivateProtocolUrl = r11;
        if (r11.startsWith("wss:") == false) goto L11;
        StringBuilder r12 = new StringBuilder();     // Catch: Throwable -> L15
        r12.append("https:");     // Catch: Throwable -> L15
        String r13 = r11.substring(4);     // Catch: Throwable -> L15
    L9:
        r12.append(r13);     // Catch: Throwable -> L15
        r11 = r12.toString();     // Catch: Throwable -> L15
    L13:
        return k.l(r11);
    L11:
        if (r11.startsWith("ws:") == false) goto L13;
        r12 = new StringBuilder();     // Catch: Throwable -> L15
        r12.append("http:");     // Catch: Throwable -> L15
        r13 = r11.substring(3);     // Catch: Throwable -> L15
    L18:
        return null;
    }

    private void registerServiceById(int r10, ByteBuffer r11, String[] r12) {
        if (this.mFrontierClient == null) goto L6;
        TTServiceInfo r13 = new TTServiceInfo(r10, new ServiceMessageReceiverImpl(this));
        this.mFrontierClient.registerService(r13, r11, r12);
        return;
    }

    private void reportAppStateChange(List<WsChannelMsg.MsgHeader> r10) {
        Iterator<WsChannelMsg.MsgHeader> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L32;
        WsChannelMsg.MsgHeader r12 = r11.next();
        if (r12 == null) goto L4;
        if (WsConstants.APP_STATE_BACKGROUND_KEY.equals(r12.getKey()) == false) goto L4;
        String r13 = r12.getValue();
        boolean r14 = false;
        if (r13.equals(NetConst.ENCRYPT_VERISON_CODE) == false) goto L13;
        this.mAppState = 1;
    L16:
        if (this.mIsFirstStreamReady == true) goto L18;
        return;
    L18:
        if (this.mAppState == (-1)) goto L31;
        CronetFrontierClient r15 = this.mFrontierClient;
        if (this.mAppState != 1) goto L22;
        r14 = true;
    L22:
        r15.reportAppStateChange(r14);
        return;
    L31:
        return;
    L13:
        if (r13.equals(NetConst.NOT_ENCRYPT_VERISON_CODE) == false) goto L16;
        this.mAppState = 0;
        goto L16
    }

    private void reportPrivateProtocolRelatedLog(JSONObject r10, int r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        r10.put("report_type", r11);
        r10.put("report_time", System.currentTimeMillis());
        if (Logger.debug() == false) goto L7;
        Logger.d(TAG, "report log:" + r10.toString());
    L7:
        CronetAppProviderManager.inst().sendAppMonitorEvent(r10.toString(), LOG_TYPE);
    }

    private void startConnectionWithPrivateProtocol(Map<String, Object> r20, URI r21) {
        int r10 = r21.getPort();
        String r11 = r21.getPath();
        String r12 = r21.getQuery();
        if (r10 > 0) goto L5;
        r10 = 443;
    L5:
        int r13 = r10;
        if (Logger.debug() == false) goto L8;
        Logger.d(TAG, "PP connection host:" + r21.getHost() + ":" + r13 + r11 + "?" + r12);
    L8:
        CronetFrontierClient.TransportMode r14 = covertTransportMode(((Integer) r20.get(WsConstants.KEY_TRANSPORT_MODE)).intValue());
        sMode = r14;
        ArrayList r15 = new ArrayList();
        if (this.mUsePrivateProtocolProxy.get() == false) goto L11;
        r15.add(1);
    L12:
        HashMap<String, String> r16 = new HashMap();
        String r17 = (String) r20.get(WsConstants.KEY_EXTRA);
        parseExtraParamsForPrivateProtocol(r17, r16);
        Map<String, String> r18 = getClientKeyHeaders();     // Catch: Throwable -> L34
        if (Logger.debug() == false) goto L16;
        Logger.d(TAG, "PP client key: " + r18);     // Catch: Throwable -> L34
    L16:
        if (r18 != null) goto L18;
    L20:
        Map<? extends String, ? extends String> r19 = (Map) r20.get(WsConstants.KEY_HEADERS);     // Catch: Throwable -> L34
        if (r19 == null) goto L26;
        if (r19.isEmpty() == true) goto L26;
        r16.putAll(r19);     // Catch: Throwable -> L34
    L26:
        if (privateProtocolProxyEnabled() == false) goto L36;
        String r22 = MySelfChannelImpl.getDefaultUserAgent();     // Catch: Throwable -> L34
        if (TextUtils.isEmpty(r22) == true) goto L30;
        r16.put("user-agent", r22);     // Catch: Throwable -> L34
    L30:
        String r23 = getCookieHeader(r21);     // Catch: Throwable -> L34
        if (TextUtils.isEmpty(r23) == true) goto L36;
        r16.put("cookie", r23);     // Catch: Throwable -> L34
    L36:
        this.mAllServiceBuildInfo.clear();
        DestroyTimeoutControl r24 = this.mDestroyTimeoutControl;
        if (r24 != null) goto L39;
    L44:
        CronetFrontierClient.Builder r25 = CronetFrontierClient.Builder.create(((Integer) r20.get("aid")).intValue(), ((Integer) r20.get(WsConstants.KEY_FPID)).intValue(), r21.getHost(), r13, Integer.toString(((Integer) r20.get("app_version")).intValue()), (String) r20.get("device_id"), (String) r20.get(WsConstants.KEY_APP_KEY)).pingInterval(this.mPingInterval).timeout(this.mTimeOut).transportMode(r14).headers(r16).callback(new PrivateProtocolCallbackImpl(this.mWsChannelClient, this));
        if (this.mUsePrivateProtocolProxy.get() == false) goto L51;
        r25.proxy(true);
        String r26 = constructQueryForProxyMode(r12, r17, r20.get("iid"));
        if (Logger.debug() == false) goto L49;
        String r27 = TAG;
        Logger.d(r27, "PP connection real query:" + r26 + " path:" + r11);
    L50:
        r25.query(r26);
        r25.path(r11);
    L52:
        r25.uniqueServiceIdList(r15);
        this.mFrontierClient = r25.build();
        if (Logger.debug() == false) goto L55;
        Logger.d(r27, "Register serviceIdList: " + r15 + " mode:" + r14);
    L55:
        Iterator r28 = r15.iterator();
    L57:
        if (r28.hasNext() == false) goto L59;
        Integer r29 = (Integer) r28.next();
        registerServiceById(r29.intValue(), null, null);
        this.mAllServiceBuildInfo.put(r29, Boolean.FALSE);
        goto L57
    L59:
        return;
    L49:
        r27 = TAG;
        goto L50
    L51:
        r27 = TAG;
        goto L52
    L39:
        if (r24.getPrivateProtocolTimeout() <= 0) goto L44;
        int r30 = (int) this.mDestroyTimeoutControl.getPrivateProtocolTimeout();
        if (Logger.debug() == false) goto L43;
        Logger.d(TAG, "PP destroy timeout:" + r30);
    L43:
        this.mTimeOut = r30;
        goto L44
    L18:
        if (r18.isEmpty() == true) goto L20;
        r16.putAll(r18);     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        th.printStackTrace();
        goto L36
    L11:
        r15.add(9000);
        mergeServiceId(r20, r15);
        goto L12
    }

    private void startConnectionWithWebSocket(Map<String, Object> r11, List<String> r12) {
        this.mUsePrivateProtocol.set(false);
        this.mUsePrivateProtocolProxy.set(false);
        if (sFirstConnection.incrementAndGet() <= 1) goto L5;
        this.mSharedConnection = false;
    L5:
        Object r10 = r11.get(WsConstants.KEY_CHANNEL_ID);
        if (r10 != null) goto L8;
        int r13 = -1;
    L10:
        if (sChannelID != (-1)) goto L15;
        if (r13 <= 0) goto L15;
        if (sFirstConnection.get() != 1) goto L15;
        sChannelID = r13;
    L15:
        TTWebsocketConnection.Builder r14 = sCronetEngine.newWebsocketConnectionBuilder(this.mCallback, Executors.newSingleThreadExecutor());
        r14.setUrlList(r12);     // Catch: Throwable -> L63
        r14.setAppKey(String.valueOf(r11.get(WsConstants.KEY_APP_KEY)));     // Catch: Throwable -> L63
        r14.setFpid(((Integer) r11.get(WsConstants.KEY_FPID)).intValue());     // Catch: Throwable -> L63
        r14.setAppVersion(((Integer) r11.get("app_version")).intValue());     // Catch: Throwable -> L63
        r14.setAppId(((Integer) r11.get("aid")).intValue());     // Catch: Throwable -> L63
        r14.setDeviceId(Long.parseLong((String) r11.get("device_id")));     // Catch: Throwable -> L63
        r14.setInstallId(Long.parseLong((String) r11.get("iid")));     // Catch: Throwable -> L63
        if (r13 > 0) goto L19;
    L21:
        r14.setSharedConnection(false);     // Catch: Throwable -> L63
        if (r11.containsKey("sid") == false) goto L24;
        r14.setSessionId((String) r11.get("sid"));     // Catch: Throwable -> L63
    L24:
        String r15 = (String) r11.get(WsConstants.KEY_EXTRA);     // Catch: Throwable -> L63
        HashMap r16 = new HashMap();     // Catch: Throwable -> L63
        if (TextUtils.isEmpty(r15) == true) goto L66;
        String[] r17 = r15.split("&");     // Catch: Throwable -> L63
        int r18 = r17.length;     // Catch: Throwable -> L63
        int r19 = 0;
    L27:
        if (r19 >= r18) goto L66;
        String r20 = r17[r19];     // Catch: Throwable -> L63
        if (TextUtils.isEmpty(r20) == true) goto L33;
        String[] r21 = r20.split("=");     // Catch: Throwable -> L63
        if (r21.length != 2) goto L33;
        r16.put(r21[0], r21[1]);     // Catch: Throwable -> L63
    L33:
        r19 = r19 + 1;
    L66:
        HashMap r110 = new HashMap();     // Catch: Throwable -> L50
        Map<String, String> r22 = getClientKeyHeaders();     // Catch: Throwable -> L50
        if (Logger.debug() == false) goto L37;
        Logger.d(TAG, "Client key: " + r22);     // Catch: Throwable -> L50
    L37:
        if (r22 != null) goto L39;
    L41:
        Map r111 = (Map) r11.get(WsConstants.KEY_HEADERS);     // Catch: Throwable -> L50
        if (r111 == null) goto L47;
        if (r111.isEmpty() == true) goto L47;
        r110.putAll(r111);     // Catch: Throwable -> L50
    L47:
        if (r110.isEmpty() == true) goto L52;
        r14.setCustomizedHeaders(r110);     // Catch: Throwable -> L50
    L52:
        DestroyTimeoutControl r112 = this.mDestroyTimeoutControl;     // Catch: Throwable -> L63
        if (r112 != null) goto L55;
    L60:
        r14.setCustomizedParams(r16);     // Catch: Throwable -> L63
        TTWebsocketConnection r113 = r14.build();
        this.mWebsocketConnection = r113;
        r113.startConnection();
        return;
    L55:
        if (r112.getWebsocketTimeout() <= 0) goto L60;
        long r114 = this.mDestroyTimeoutControl.getWebsocketTimeout();     // Catch: Throwable -> L63
        if (Logger.debug() == false) goto L59;
        Logger.d(TAG, "WS destroy timeout:" + r114);     // Catch: Throwable -> L63
    L59:
        r16.put(TIME_OUT_HEADER, String.valueOf(r114));     // Catch: Throwable -> L63
        goto L60
    L39:
        if (r22.isEmpty() == true) goto L41;
        r110.putAll(r22);     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L63
        goto L52
    L19:
        if (r13 != sChannelID) goto L21;
        this.mSharedConnection = true;     // Catch: Throwable -> L63
    L63:
        th = move-exception;
        th.printStackTrace();
        throw new IllegalArgumentException("configMap contain err params !!!");
    L8:
        r13 = ((Integer) r10).intValue();
        goto L10
    }

    public void destroyConnection() {
        disconnectConnection();
    }

    public boolean isConnected() {
        if (this.mUsePrivateProtocol.get() == false) goto L9;
        CronetFrontierClient r10 = this.mFrontierClient;
        if (r10 == null) goto L9;
        return r10.isConnected();
    L9:
        if (this.mUsePrivateProtocol.get() == true) goto L14;
        TTWebsocketConnection r11 = this.mWebsocketConnection;
        if (r11 != null) goto L13;
        return false;
    L13:
        return r11.isConnected();
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

    public void registerService(int r10) {
    }

    public boolean sendMessageWithPrivateProtocol(WsChannelMsg r10) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "PP sendMessage data:" + r10.toString());
    L6:
        if (this.mFrontierClient == null) goto L19;
        if (r10 == null) goto L21;
        int r11 = r10.getService();
        if (r11 == 9000) goto L12;
    L15:
        String[] r12 = constructMessageMetaInfo(r10);
        ByteBuffer r13 = ByteBuffer.allocateDirect(r10.getPayload().length);
        r13.put(r10.getPayload());
        this.mFrontierClient.sendMessage(r11, r12, r13);
        if (Logger.debug() == false) goto L18;
        Logger.d(TAG, "PP sendMessage serviceId:" + r11);
    L18:
        return true;
    L12:
        if (r10.getMethod() != 4) goto L15;
        reportAppStateChange(r10.getMsgHeaders());
        return true;
    L21:
        return false;
    L19:
        return false;
    }

    public boolean sendMessageWithPrivateProtocolProxy(byte[] r10) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "PP proxy sendMessage data:" + r10.toString());
    L5:
        CronetFrontierClient r11 = this.mFrontierClient;
        if (r11 == null) goto L14;
        if (r10 != null) goto L10;
        return false;
    L10:
        if (r11.isServiceExisted(1) == true) goto L12;
        registerServiceById(1, null, null);
    L12:
        ByteBuffer r12 = ByteBuffer.allocateDirect(r10.length);
        r12.put(r10);
        this.mFrontierClient.sendMessage(1, null, r12);
        return true;
    L14:
        return false;
    }

    public boolean sendMessageWithWebSocket(byte[] r10) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "WS sendMessage data:" + r10);
    L6:
        if (this.mWebsocketConnection != null) goto L9;
        return false;
    L9:
        ByteBuffer r11 = ByteBuffer.allocateDirect(r10.length);
        r11.put(r10);
        this.mWebsocketConnection.asyncSendBinary(r11);
        return true;
    }

    public void setFirstStreamReady(boolean r10) {
        this.mIsFirstStreamReady = r10;
    }

    public void startConnection(Map<String, Object> r11, List<String> r12) {
        if (r12 == null) goto L39;
        if (r12.size() <= 0) goto L39;
        boolean r10 = false;
        if (Logger.debug() == false) goto L8;
        Logger.d(TAG, "openConnection url:" + r12.get(0));
    L8:
        if (r11 == null) goto L37;
        if (r11.isEmpty() == true) goto L37;
        destroyConnection();
        if (canUsePrivateProtocol(r11) == true) goto L15;
        this.mDestroyTimeoutControl = new DestroyTimeoutControl(r11, true);
        startConnectionWithWebSocket(r11, r12);
        return;
    L15:
        URI r13 = parsePrivateProtocolUrl(r11);
        if (r13 != null) goto L19;
        this.mDestroyTimeoutControl = new DestroyTimeoutControl(r11, true);
        startConnectionWithWebSocket(r11, r12);
        return;
    L19:
        this.mDestroyTimeoutControl = new DestroyTimeoutControl(r11, false);
        Object r14 = r11.get(WsConstants.KEY_DISABLE_FALLBACK_WEBSOCKET);
        if (r14 == null) goto L23;
        r10 = ((Boolean) r14).booleanValue();
    L23:
        if (Logger.debug() == false) goto L26;
        Logger.d(TAG, "DisableFallbackTask:" + sDisableFallbackTask + " DisableFallbackWS:" + r10);
    L26:
        if (sDisableFallbackTask == true) goto L34;
        if (r10 == true) goto L34;
        if (this.mDestroyTimeoutControl.shouldFallbackToWebSocket() == false) goto L34;
        long r15 = getFallbackTimeoutSeconds(r11);
        if (Logger.debug() == false) goto L33;
        Logger.d(TAG, "Fallback to websocket timeout:" + r15);
    L33:
        a.d().e(new FallbackWebSocketTask(this, r15, r11, r12));
        this.mIsFallbackTaskRunning.set(true);
    L34:
        this.mUsePrivateProtocol.set(true);
        startConnectionWithPrivateProtocol(r11, r13);
        return;
    L37:
        throw new IllegalArgumentException("configMap is empty !!!");
    L39:
        throw new IllegalArgumentException("urls size <= 0 !!!");
    }

    public void stopConnection() {
        disconnectConnection();
    }

    public void unregisterService(int r10) {
    }
}
