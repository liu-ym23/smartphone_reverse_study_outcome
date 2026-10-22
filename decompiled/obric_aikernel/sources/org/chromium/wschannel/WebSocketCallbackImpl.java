package org.chromium.wschannel;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.ttnet.org.chromium.net.NetError;
import com.ttnet.org.chromium.net.TTWebsocketConnection;
import java.nio.ByteBuffer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
final class WebSocketCallbackImpl extends TTWebsocketConnection.Callback {
    private static final String TAG = "CronetFrontierConnection";
    private IWsChannelClient mClient;

    public WebSocketCallbackImpl(IWsChannelClient r10) {
        this.mClient = r10;
    }

    private static int cronetToWsStateAdapter(int r10) {
        if (r10 == (-1)) goto L9;
        if (r10 == 0) goto L12;
        if (r10 != 1) goto L13;
        return 6;
    L13:
        return r10;
    L12:
        return 1;
    L9:
        return 0;
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Callback
    public void onConnectionError(TTWebsocketConnection r10, int r11, String r12, String r13) {
        int r14 = cronetToWsStateAdapter(r11);
        if (Logger.debug() == false) goto L13;
        Logger.d(TAG, "WS onConnectionError state:" + r14 + " url:" + r12 + " error:" + r13);
    L13:
        JSONObject r15 = new JSONObject();     // Catch: Throwable -> L12
        r15.put(WsConstants.KEY_CONNECTION_TYPE, 0);     // Catch: Throwable -> L12
        r15.put("state", r14);     // Catch: Throwable -> L12
        r15.put("url", r12);     // Catch: Throwable -> L12
        r15.put("error", r13);     // Catch: Throwable -> L12
        if (DestroyTimeoutControl.isConnectionTimeout(r13, true) == false) goto L10;
        r15.put(WsConstants.ERROR_CODE, NetError.ERR_TTNET_REQUEST_TIMED_OUT);     // Catch: Throwable -> L12
        if (Logger.debug() == false) goto L10;
        Logger.d(TAG, "WS connection timeout.");     // Catch: Throwable -> L12
    L10:
        this.mClient.onConnection(r15);     // Catch: Throwable -> L12
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Callback
    public void onConnectionStateChanged(TTWebsocketConnection r10, int r11, String r12) {
        int r13 = cronetToWsStateAdapter(r11);
        if (Logger.debug() == false) goto L8;
        Logger.d(TAG, "WS onConnectionStateChanged state:" + r13 + " url:" + r12);
    L8:
        JSONObject r14 = new JSONObject();     // Catch: Throwable -> L7
        r14.put(WsConstants.KEY_CONNECTION_TYPE, 1);     // Catch: Throwable -> L7
        r14.put("state", r13);     // Catch: Throwable -> L7
        r14.put("url", r12);     // Catch: Throwable -> L7
        this.mClient.onConnection(r14);     // Catch: Throwable -> L7
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Callback
    public void onMessageReceived(TTWebsocketConnection r10, ByteBuffer r11, int r12) {
        byte[] r13 = new byte[r11.capacity()];
        r11.get(r13);     // Catch: Throwable -> L5
        this.mClient.onMessage(r13);     // Catch: Throwable -> L5
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Callback
    public void onTrafficChanged(TTWebsocketConnection r10, String r11, long r12, long r13, boolean r14) {
        TrafficChangedObservable.inst().onTrafficChanged(r11, r12, r13, r14);     // Catch: Throwable -> L4
        return;
    }
}
