package ovc;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ttnet.org.chromium.net.TTWebsocketConnection;
import java.nio.ByteBuffer;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class e extends TTWebsocketConnection.Callback {
    public final IWsChannelClient a;

    public e(IWsChannelClient r1) {
        this.a = r1;
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Callback
    public final void onConnectionStateChanged(TTWebsocketConnection r3, int r4, String r5) {
        if (r4 == (-1)) goto L9;
        if (r4 == 0) goto L8;
        if (r4 != 1) goto L11;
        r4 = 6;
    L11:
        if (Logger.debug() == false) goto L16;
        Logger.d("CronetFrontierConnection", "WS onConnectionStateChanged state:" + r4 + " url:" + r5);
    L16:
        JSONObject r6 = new JSONObject();     // Catch: Throwable -> L15
        r6.put(EffectConfiguration.KEY_TYPE, 1);     // Catch: Throwable -> L15
        r6.put("state", r4);     // Catch: Throwable -> L15
        r6.put("url", r5);     // Catch: Throwable -> L15
        this.a.onConnection(r6);     // Catch: Throwable -> L15
        return;
    L18:
        return;
    L8:
        r4 = 1;
        goto L11
    L9:
        r4 = 0;
        goto L11
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Callback
    public final void onMessageReceived(TTWebsocketConnection r1, ByteBuffer r2, int r3) throws Exception {
        byte[] r4 = new byte[r2.capacity()];
        r2.get(r4);     // Catch: Throwable -> L5
        this.a.onMessage(r4);     // Catch: Throwable -> L5
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Callback
    public final void onConnectionError(TTWebsocketConnection r5, int r6, String r7, String r8) {
        if (r6 == (-1)) goto L9;
        if (r6 == 0) goto L8;
        if (r6 != 1) goto L11;
        r6 = 6;
    L11:
        if (Logger.debug() == false) goto L21;
        Logger.d("CronetFrontierConnection", "WS onConnectionError state:" + r6 + " url:" + r7 + " error:" + r8);
    L21:
        JSONObject r9 = new JSONObject();     // Catch: Throwable -> L20
        r9.put(EffectConfiguration.KEY_TYPE, 0);     // Catch: Throwable -> L20
        r9.put("state", r6);     // Catch: Throwable -> L20
        r9.put("url", r7);     // Catch: Throwable -> L20
        r9.put("error", r8);     // Catch: Throwable -> L20
        if (b.b(r8, true) == false) goto L18;
        r9.put("error_code", -192);     // Catch: Throwable -> L20
        if (Logger.debug() == false) goto L18;
        Logger.d("CronetFrontierConnection", "WS connection timeout.");     // Catch: Throwable -> L20
    L18:
        this.a.onConnection(r9);     // Catch: Throwable -> L20
        return;
    L23:
        return;
    L8:
        r6 = 1;
        goto L11
    L9:
        r6 = 0;
        goto L11
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Callback
    public final void onTrafficChanged(TTWebsocketConnection r8, String r9, long r10, long r12, boolean r14) {
        d.a().b(r9, r10, r12, r14);     // Catch: Throwable -> L4
        return;
    }
}
