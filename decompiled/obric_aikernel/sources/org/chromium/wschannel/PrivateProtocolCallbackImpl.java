package org.chromium.wschannel;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.ttnet.org.chromium.net.NetError;
import com.ttnet.org.chromium.net.impl.CronetFrontierClient;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
final class PrivateProtocolCallbackImpl implements CronetFrontierClient.IConnectionCallback {
    private static final String TAG = "CronetFrontierConnection";
    private IWsChannelClient mClient;
    private CronetFrontierConnection mConnection;

    public PrivateProtocolCallbackImpl(IWsChannelClient r10, CronetFrontierConnection r11) {
        this.mClient = r10;
        this.mConnection = r11;
    }

    public static String extractConnectionId(String r10) {
        return new JSONObject(r10).optString("connection_id");
    L4:
        return "";
    }

    private static int privateProtocolStateAdapter(int r10) {
        if (r10 == 2) goto L10;
        if (r10 == 3) goto L12;
        if (r10 == 4) goto L11;
        return r10;
    L11:
        return 3;
    L12:
        return 2;
    L10:
        return 4;
    }

    private boolean shouldIgnoreStateCallback(int r10) {
        if (this.mConnection.privateProtocolProxyEnabled() == true) goto L6;
        return false;
    L6:
        if (r10 == 2) goto L12;
        if (r10 == 3) goto L12;
        if (r10 == 4) goto L12;
    L18:
        return false;
    L12:
        if (this.mConnection.isFallbackTaskRunning() == false) goto L18;
        if (Logger.debug() == false) goto L19;
        Logger.d(TAG, "Wait fallback task running and ignore state:" + r10);
        return true;
    L19:
        return true;
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.IConnectionCallback
    public void onConnectionError(int r10, String r11, String r12) {
        int r13 = privateProtocolStateAdapter(r10);
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "PP onConnectionError state:" + r13 + " url:" + r11 + " error:" + r12);
    L6:
        if (shouldIgnoreStateCallback(r13) == false) goto L16;
        return;
    L16:
        JSONObject r14 = new JSONObject();     // Catch: Throwable -> L15
        r14.put(WsConstants.KEY_CONNECTION_TYPE, 0);     // Catch: Throwable -> L15
        r14.put(WsConstants.KEY_PRIVATE_PROTOCOL_ENABLE, 1);     // Catch: Throwable -> L15
        r14.put("state", r13);     // Catch: Throwable -> L15
        r14.put("url", r11);     // Catch: Throwable -> L15
        r14.put("error", r12);     // Catch: Throwable -> L15
        if (DestroyTimeoutControl.isConnectionTimeout(r12, false) == false) goto L13;
        r14.put(WsConstants.ERROR_CODE, NetError.ERR_TTNET_REQUEST_TIMED_OUT);     // Catch: Throwable -> L15
        if (Logger.debug() == false) goto L13;
        Logger.d(TAG, "PP connection timeout.");     // Catch: Throwable -> L15
    L13:
        this.mClient.onConnection(r14);     // Catch: Throwable -> L15
        return;
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.IConnectionCallback
    public void onConnectionStateChanged(int r10, String r11) {
        int r12 = privateProtocolStateAdapter(r10);
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "PP onConnectionStateChanged state:" + r12 + " url:" + r11);
    L6:
        if (r12 != 4) goto L9;
        this.mConnection.setFirstStreamReady(false);
    L9:
        if (shouldIgnoreStateCallback(r12) == false) goto L14;
        return;
    L14:
        JSONObject r13 = new JSONObject();     // Catch: Throwable -> L13
        r13.put(WsConstants.KEY_CONNECTION_TYPE, 1);     // Catch: Throwable -> L13
        r13.put(WsConstants.KEY_PRIVATE_PROTOCOL_ENABLE, 1);     // Catch: Throwable -> L13
        r13.put("state", r12);     // Catch: Throwable -> L13
        r13.put("url", r11);     // Catch: Throwable -> L13
        this.mClient.onConnection(r13);     // Catch: Throwable -> L13
        return;
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.IConnectionCallback
    public void onTrafficChanged(String r10, long r11, long r12, boolean r13) {
        TrafficChangedObservable.inst().onTrafficChanged(r10, r11, r12, r13);     // Catch: Throwable -> L4
        return;
    }
}
