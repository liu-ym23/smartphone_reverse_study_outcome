package org.chromium.wschannel;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.ttnet.org.chromium.net.NetError;
import com.ttnet.org.chromium.net.impl.CronetFrontierClient;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
final class PrivateProtocolCallbackImpl implements CronetFrontierClient.IConnectionCallback {
    private static final String TAG = "CronetFrontierConnection";
    private IWsChannelClient mClient;
    private CronetFrontierConnection mConnection;

    public PrivateProtocolCallbackImpl(IWsChannelClient r3, CronetFrontierConnection r4) {
        this.mClient = (IWsChannelClient) ZeusTransformUtils.wrapperContextForParams(r3, IWsChannelClient.class, "com.obric.memorydata.plugin");
        this.mConnection = r4;
    }

    public static String extractConnectionId(String r1) {
        return new JSONObject(r1).optString("connection_id");
    L4:
        return "";
    }

    private static int privateProtocolStateAdapter(int r3) {
        if (r3 == 2) goto L10;
        if (r3 == 3) goto L12;
        if (r3 == 4) goto L11;
        return r3;
    L11:
        return 3;
    L12:
        return 2;
    L10:
        return 4;
    }

    private boolean shouldIgnoreStateCallback(int r2) {
        if (r2 == 2) goto L9;
        if (r2 == 3) goto L9;
        if (r2 == 4) goto L9;
        return false;
    L9:
        if (this.mConnection.isFallbackTaskRunning() == true) goto L11;
        return false;
    L11:
        if (Logger.debug() == false) goto L17;
        Logger.d(TAG, "Wait fallback task running and ignore state:" + r2);
        return true;
    L17:
        return true;
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.IConnectionCallback
    public void onConnectionError(int r6, String r7, String r8) {
        int r9 = privateProtocolStateAdapter(r6);
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "PP onConnectionError state:" + r9 + " url:" + r7 + " error:" + r8);
    L6:
        if (shouldIgnoreStateCallback(r9) == false) goto L16;
        return;
    L16:
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L15
        r0.put("type", 0);     // Catch: Throwable -> L15
        r0.put(WsConstants.KEY_PRIVATE_PROTOCOL_ENABLE, 1);     // Catch: Throwable -> L15
        r0.put("state", r9);     // Catch: Throwable -> L15
        r0.put("url", r7);     // Catch: Throwable -> L15
        r0.put("error", r8);     // Catch: Throwable -> L15
        if (DestroyTimeoutControl.isConnectionTimeout(r8, false) == false) goto L13;
        r0.put("error_code", NetError.ERR_TTNET_REQUEST_TIMED_OUT);     // Catch: Throwable -> L15
        if (Logger.debug() == false) goto L13;
        Logger.d(TAG, "PP connection timeout.");     // Catch: Throwable -> L15
    L13:
        this.mClient.onConnection(r0);     // Catch: Throwable -> L15
        return;
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.IConnectionCallback
    public void onConnectionStateChanged(int r4, String r5) {
        int r6 = privateProtocolStateAdapter(r4);
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "PP onConnectionStateChanged state:" + r6 + " url:" + r5);
    L6:
        if (r6 != 4) goto L9;
        this.mConnection.setFirstStreamReady(false);
    L9:
        if (shouldIgnoreStateCallback(r6) == false) goto L14;
        return;
    L14:
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L13
        r0.put("type", 1);     // Catch: Throwable -> L13
        r0.put(WsConstants.KEY_PRIVATE_PROTOCOL_ENABLE, 1);     // Catch: Throwable -> L13
        r0.put("state", r6);     // Catch: Throwable -> L13
        r0.put("url", r5);     // Catch: Throwable -> L13
        this.mClient.onConnection(r0);     // Catch: Throwable -> L13
        return;
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.IConnectionCallback
    public void onTrafficChanged(String r8, long r9, long r11, boolean r13) {
        TrafficChangedObservable.inst().onTrafficChanged(r8, r9, r11, r13);     // Catch: Throwable -> L4
        return;
    }
}
