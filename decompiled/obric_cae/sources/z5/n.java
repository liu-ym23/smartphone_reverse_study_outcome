package z5;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import org.json.JSONObject;
import we.a0;

/* JADX INFO: loaded from: classes.dex */
public final class n implements b.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IWsChannelClient f14277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f14278b;

    public n(Context r8, IWsChannelClient r10) {
        this.f14277a = r10;
        this.f14278b = r8;
    }

    public final void a(String r8, String r10) {
        Logger.d("WsChannelSdk_ok", "onClosed() : " + r10);
        IWsChannelClient r11 = this.f14277a;
        if (r11 == null) goto L12;
        JSONObject r12 = new JSONObject();
        r12.put("type", 0);     // Catch: Exception -> L7
        r12.put("state", 3);     // Catch: Exception -> L7
        r12.put(WsConstants.KEY_CONNECTION_URL, r8);     // Catch: Exception -> L7
        r12.put(WsConstants.KEY_CHANNEL_TYPE, 2);     // Catch: Exception -> L7
        r11.onConnection(r12);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public final void b(int r8, String r10, String r11) {
        Logger.d("WsChannelSdk_ok", "onFailure() : " + r11);
        Bundle r12 = new Bundle();
        r12.putString(WsConstants.KEY_CONNECTION_URL, r10);
        r12.putInt("error_code", r8);
        r12.putString("error_msg", r11);
        r12.putString(BdimCategoryConstants.INTENT_KEY_METHOD, "onFailure");
        l6.a.t0(this.f14278b, "WsChannelSdk_ok", r12);
        IWsChannelClient r13 = this.f14277a;
        if (r13 == null) goto L12;
        JSONObject r14 = new JSONObject();
        r14.put("type", 0);     // Catch: Exception -> L7
        r14.put("state", 2);     // Catch: Exception -> L7
        r14.put(WsConstants.KEY_CONNECTION_URL, r10);     // Catch: Exception -> L7
        r14.put(WsConstants.KEY_CHANNEL_TYPE, 2);     // Catch: Exception -> L7
        r14.put(WsConstants.KEY_CONNECTION_ERROR, r11);     // Catch: Exception -> L7
        r14.put("error_code", r8);     // Catch: Exception -> L7
        r13.onConnection(r14);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public final void c(a0 r8) {
        Logger.d("WsChannelSdk_ok", "onOpen(): " + r8.toString());
        IWsChannelClient r10 = this.f14277a;
        if (r10 == null) goto L12;
        JSONObject r11 = new JSONObject();
        r11.put("type", 1);     // Catch: Exception -> L7
        r11.put("state", 4);     // Catch: Exception -> L7
        r11.put(WsConstants.KEY_CONNECTION_URL, r8.f13114a.f13337a.f13249i);     // Catch: Exception -> L7
        r11.put(WsConstants.KEY_CHANNEL_TYPE, 2);     // Catch: Exception -> L7
        r10.onConnection(r11);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}
