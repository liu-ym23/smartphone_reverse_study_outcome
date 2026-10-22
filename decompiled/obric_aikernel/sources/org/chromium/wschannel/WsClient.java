package org.chromium.wschannel;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.reflect.Reflect;
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

/* JADX INFO: loaded from: classes3.dex */
public class WsClient implements IWsClient {
    private static final String TAG = "WsClient";
    private static final String TTNET_INIT_CLASS = "com.bytedance.ttnet.TTNetInit";
    private static CronetEngine mCronetEngine;
    private CallbackImpl mCallback;
    private IMessageReceiveListener mListener;
    private TTWebsocketConnection mWebsocketConnection;

    class CallbackImpl extends TTWebsocketConnection.Callback {
        final /* synthetic */ WsClient this$0;

        CallbackImpl(WsClient r10) {
            this.this$0 = r10;
        }

        @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Callback
        public void onConnectionError(TTWebsocketConnection r10, int r11, String r12, String r13) {
            JSONObject r14 = new JSONObject();     // Catch: Throwable -> L6
            r14.put("url", r12);     // Catch: Throwable -> L6
            r14.put("error", r13);     // Catch: Throwable -> L6
            if (WsClient.access$000(this.this$0) == null) goto L9;
            WsClient.access$000(this.this$0).onConnection(r11, r12, r14);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        }

        @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Callback
        public void onConnectionStateChanged(TTWebsocketConnection r10, int r11, String r12) {
            JSONObject r13 = new JSONObject();     // Catch: Throwable -> L6
            r13.put("state", WsClient.access$100(this.this$0, r11));     // Catch: Throwable -> L6
            r13.put("url", r12);     // Catch: Throwable -> L6
            if (WsClient.access$000(this.this$0) == null) goto L9;
            WsClient.access$000(this.this$0).onConnection(r11, r12, r13);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        }

        @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Callback
        public void onFeedbackLog(TTWebsocketConnection r10, String r11) {
            if (WsClient.access$000(this.this$0) == null) goto L6;
            WsClient.access$000(this.this$0).onFeedBackLog(r11);
            return;
        }

        @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Callback
        public void onMessageReceived(TTWebsocketConnection r10, ByteBuffer r11, int r12) {
            byte[] r13 = new byte[r11.capacity()];
            if (r12 != 1) goto L5;
        L12:
            r11.get(r13);     // Catch: Throwable -> L11
            if (WsClient.access$000(this.this$0) == null) goto L14;
            WsClient.access$000(this.this$0).onMessage(r13, r12);     // Catch: Throwable -> L11
            return;
        L14:
            return;
        L15:
            return;
        L5:
            if (r12 == 2) goto L12;
            r12 = 0;
            goto L12
        }

        @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Callback
        public void onTrafficChanged(TTWebsocketConnection r10, String r11, long r12, long r13, boolean r14) {
            TrafficChangedObservable.inst().onTrafficChanged(r11, r12, r13, r14);     // Catch: Throwable -> L4
            return;
        }
    }

    public WsClient(IMessageReceiveListener r10) {
        this.mCallback = new CallbackImpl(this);
        if (mCronetEngine != null) goto L5;
        mCronetEngine = getCronetEngine();
    L5:
        this.mListener = r10;
    }

    static /* synthetic */ IMessageReceiveListener access$000(WsClient r10) {
        return r10.mListener;
    }

    static /* synthetic */ int access$100(WsClient r10, int r11) {
        return r10.cronetToWsStateAdapter(r11);
    }

    private int cronetToWsStateAdapter(int r10) {
        if (r10 == (-1)) goto L9;
        if (r10 == 0) goto L12;
        if (r10 != 1) goto L13;
        return 5;
    L13:
        return r10;
    L12:
        return 1;
    L9:
        return 0;
    }

    private CronetEngine getCronetEngine() {
        if (Logger.debug() == false) goto L13;
        Logger.d(TAG, "Init cronet engine");
    L13:
        loadCronetKernel();     // Catch: Throwable -> L7
    L12:
        return CronetClient.getCronetEngine();
    L7:
        th = move-exception;
        th.printStackTrace();
        if (Logger.debug() == false) goto L12;
        Logger.d(TAG, "TTNet init failed, cronet engine is null.");
        goto L12
    }

    private static void loadCronetKernel() {
        String r10 = TTNetInit.DOMAIN_HTTPDNS_KEY;
        Object r11 = TTNetInit.class.newInstance();
        Reflect.on(r11).call("getInitCompletedLatch");
        Reflect.on(r11).call("preInitCronetKernel");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.websocket.IWsClient
    public boolean isConnected() {
        TTWebsocketConnection r10 = this.mWebsocketConnection;
        if (r10 != null) goto L7;
        return false;
    L7:
        return r10.isConnected();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.websocket.IWsClient
    public void onParameterChange(Map<String, String> r10, Map<String, String> r11, List<String> r12, boolean r13, boolean r14) {
        TTWebsocketConnection r15 = this.mWebsocketConnection;
        if (r15 == null) goto L5;
        r15.stopConnection();
        this.mWebsocketConnection.destroyConnection();
    L5:
        openConnection(r10, r11, r12, r13, r14);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.websocket.IWsClient
    public void openConnection(Map<String, String> r10, Map<String, String> r11, List<String> r12, boolean r13, boolean r14) {
        if (r12 == null) goto L20;
        if (r12.size() <= 0) goto L20;
        if (Logger.debug() == false) goto L8;
        Logger.d(TAG, "openConnection url:" + r12.get(0));
    L8:
        TTWebsocketConnection.Builder r15 = mCronetEngine.newWebsocketConnectionBuilder(this.mCallback, Executors.newSingleThreadExecutor());
        r15.setUrlList(r12);
        if (r10 != null) goto L11;
    L13:
        if (r11 != null) goto L15;
    L17:
        r15.setSharedConnection(r13);
        r15.useFrontierProtocol(r14);
        TTWebsocketConnection r16 = r15.build();
        this.mWebsocketConnection = r16;
        r16.startConnection();
        return;
    L15:
        if (r11.isEmpty() == true) goto L17;
        r15.setCustomizedHeaders(r11);
        goto L17
    L11:
        if (r10.isEmpty() == true) goto L13;
        r15.setCustomizedParams(r10);
    L20:
        throw new IllegalArgumentException("urls size <= 0 !!!");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.websocket.IWsClient
    public boolean sendMessage(byte[] r10, int r11) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "sendMessage data:" + r10);
    L6:
        if (this.mWebsocketConnection != null) goto L10;
        return false;
    L10:
        if (r11 != 2) goto L12;
        ByteBuffer r12 = ByteBuffer.allocateDirect(r10.length);
        r12.put(r10);
        this.mWebsocketConnection.asyncSendBinary(r12);
    L14:
        return true;
    L12:
        if (r11 != 1) goto L16;
        this.mWebsocketConnection.asyncSendText(new String(r10, "UTF-8"));
        goto L14
    L16:
        throw new IllegalArgumentException("Unsupported message type: " + r11);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.websocket.IWsClient
    public void stopConnection() {
        TTWebsocketConnection r10 = this.mWebsocketConnection;
        if (r10 == null) goto L6;
        r10.stopConnection();
        this.mWebsocketConnection.destroyConnection();
        return;
    }
}
