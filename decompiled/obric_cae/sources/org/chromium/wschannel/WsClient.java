package org.chromium.wschannel;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.frameworks.baselib.network.http.cronet.websocket.IMessageReceiveListener;
import com.bytedance.frameworks.baselib.network.http.cronet.websocket.IWsClient;
import com.bytedance.ttnet.TTNetInit;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.TTWebsocketConnection;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import org.chromium.CronetClient;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class WsClient implements IWsClient {
    private static final String TAG = "WsClient";
    private static final String TTNET_INIT_CLASS = "com.bytedance.ttnet.TTNetInit";
    private static CronetEngine mCronetEngine;
    private a mCallback;
    private IMessageReceiveListener mListener;
    private TTWebsocketConnection mWebsocketConnection;

    public class a extends TTWebsocketConnection.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WsClient f9805a;

        public a(WsClient r8) {
            this.f9805a = r8;
        }

        @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Callback
        public final void onConnectionError(TTWebsocketConnection r8, int r10, String r11, String r12) {
            WsClient r13 = this.f9805a;
            JSONObject r14 = new JSONObject();     // Catch: Throwable -> L7
            r14.put(WsConstants.KEY_CONNECTION_URL, r11);     // Catch: Throwable -> L7
            r14.put(WsConstants.KEY_CONNECTION_ERROR, r12);     // Catch: Throwable -> L7
            if (WsClient.access$000(r13) == null) goto L10;
            WsClient.access$000(r13).onConnection(r10, r11, r14);     // Catch: Throwable -> L7
            return;
        L10:
            return;
        }

        @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Callback
        public final void onConnectionStateChanged(TTWebsocketConnection r8, int r10, String r11) {
            WsClient r12 = this.f9805a;
            JSONObject r13 = new JSONObject();     // Catch: Throwable -> L7
            r13.put("state", WsClient.access$100(r12, r10));     // Catch: Throwable -> L7
            r13.put(WsConstants.KEY_CONNECTION_URL, r11);     // Catch: Throwable -> L7
            if (WsClient.access$000(r12) == null) goto L10;
            WsClient.access$000(r12).onConnection(r10, r11, r13);     // Catch: Throwable -> L7
            return;
        L10:
            return;
        }

        @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Callback
        public final void onFeedbackLog(TTWebsocketConnection r8, String r10) {
            WsClient r11 = this.f9805a;
            if (WsClient.access$000(r11) == null) goto L6;
            WsClient.access$000(r11).onFeedBackLog(r10);
            return;
        }

        @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Callback
        public final void onMessageReceived(TTWebsocketConnection r8, ByteBuffer r10, int r11) {
            WsClient r12 = this.f9805a;
            byte[] r13 = new byte[r10.capacity()];
            if (r11 != 1) goto L5;
        L12:
            r10.get(r13);     // Catch: Throwable -> L11
            if (WsClient.access$000(r12) == null) goto L14;
            WsClient.access$000(r12).onMessage(r13, r11);     // Catch: Throwable -> L11
            return;
        L14:
            return;
        L15:
            return;
        L5:
            if (r11 == 2) goto L12;
            r11 = 0;
            goto L12
        }

        @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Callback
        public final void onTrafficChanged(TTWebsocketConnection r8, String r10, long r11, long r12, boolean r14) {
            if (kf.a.f9124a == null) goto L5;
        L14:
            kf.a.f9124a.a(r10, r11, r12, r14);     // Catch: Throwable -> L16
            return;
        L5:
            monitor-enter(kf.a.class);     // Catch: Throwable -> L16
        L11:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L7:
            if (kf.a.f9124a != null) goto L9;
            kf.a.f9124a = new kf.a();     // Catch: Throwable -> L11
        L9:
            monitor-exit(kf.a.class);     // Catch: Throwable -> L11
        }
    }

    public WsClient(IMessageReceiveListener r8) {
        this.mCallback = new a(this);
        if (mCronetEngine != null) goto L5;
        mCronetEngine = getCronetEngine();
    L5:
        this.mListener = r8;
    }

    public static /* synthetic */ IMessageReceiveListener access$000(WsClient r8) {
        return r8.mListener;
    }

    public static /* synthetic */ int access$100(WsClient r8, int r10) {
        return r8.cronetToWsStateAdapter(r10);
    }

    private int cronetToWsStateAdapter(int r8) {
        if (r8 != (-1)) goto L5;
        return 0;
    L5:
        if (r8 == 0) goto L13;
        if (r8 != 1) goto L14;
        return 5;
    L14:
        return r8;
    L13:
        return 1;
    }

    private CronetEngine getCronetEngine() {
        Logger.d(TAG, "Init cronet engine");
        loadCronetKernel();     // Catch: Throwable -> L5
    L8:
        return CronetClient.getCronetEngine();
    L5:
        th = move-exception;
        th.printStackTrace();
        Logger.d(TAG, "TTNet init failed, cronet engine is null.");
        goto L8
    }

    private static void loadCronetKernel() {
        String r8 = TTNetInit.DOMAIN_HTTPDNS_KEY;
        Object r10 = TTNetInit.class.newInstance();
        Reflect.on(r10).call("getInitCompletedLatch");
        Reflect.on(r10).call("preInitCronetKernel");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.websocket.IWsClient
    public boolean isConnected() {
        TTWebsocketConnection r8 = this.mWebsocketConnection;
        if (r8 != null) goto L7;
        return false;
    L7:
        return r8.isConnected();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.websocket.IWsClient
    public void onParameterChange(Map<String, String> r8, Map<String, String> r10, List<String> r11, boolean r12, boolean r13) {
        TTWebsocketConnection r14 = this.mWebsocketConnection;
        if (r14 == null) goto L5;
        r14.stopConnection();
        this.mWebsocketConnection.destroyConnection();
    L5:
        openConnection(r8, r10, r11, r12, r13);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.websocket.IWsClient
    public void openConnection(Map<String, String> r8, Map<String, String> r10, List<String> r11, boolean r12, boolean r13) {
        if (r11 == null) goto L17;
        if (r11.size() <= 0) goto L17;
        Logger.d(TAG, "openConnection url:" + r11.get(0));
        TTWebsocketConnection.Builder r14 = mCronetEngine.newWebsocketConnectionBuilder(this.mCallback, Executors.newSingleThreadExecutor());
        r14.setUrlList(r11);
        if (r8 != null) goto L8;
    L10:
        if (r10 != null) goto L12;
    L14:
        r14.setSharedConnection(r12);
        r14.useFrontierProtocol(r13);
        TTWebsocketConnection r15 = r14.build();
        this.mWebsocketConnection = r15;
        r15.startConnection();
        return;
    L12:
        if (r10.isEmpty() == true) goto L14;
        r14.setCustomizedHeaders(r10);
        goto L14
    L8:
        if (r8.isEmpty() == true) goto L10;
        r14.setCustomizedParams(r8);
    L17:
        throw new IllegalArgumentException("urls size <= 0 !!!");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.websocket.IWsClient
    public boolean sendMessage(byte[] r8, int r10) {
        Logger.d(TAG, "sendMessage data:" + r8);
        if (this.mWebsocketConnection != null) goto L7;
        return false;
    L7:
        if (r10 != 2) goto L9;
        ByteBuffer r11 = ByteBuffer.allocateDirect(r8.length);
        r11.put(r8);
        this.mWebsocketConnection.asyncSendBinary(r11);
    L11:
        return true;
    L9:
        if (r10 != 1) goto L13;
        this.mWebsocketConnection.asyncSendText(new String(r8, "UTF-8"));
        goto L11
    L13:
        throw new IllegalArgumentException(defpackage.a.d("Unsupported message type: ", r10));
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.websocket.IWsClient
    public void stopConnection() {
        TTWebsocketConnection r8 = this.mWebsocketConnection;
        if (r8 == null) goto L6;
        r8.stopConnection();
        this.mWebsocketConnection.destroyConnection();
        return;
    }
}
