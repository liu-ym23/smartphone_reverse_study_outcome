package w1;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.crash.event.EnsureReportData;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class e implements c.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IWsChannelClient f13298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f13299b;

    e(Context r10, c r11, IWsChannelClient r12) {
        this.f13298a = r12;
        this.f13299b = r10;
    }

    @Override // w1.c.k
    public void a(String r10) {
        if (this.f13298a == null) goto L12;
        JSONObject r11 = new JSONObject();
        r11.put(WsConstants.KEY_CONNECTION_TYPE, 1);     // Catch: Exception -> L7
        r11.put("state", 1);     // Catch: Exception -> L7
        r11.put("url", r10);     // Catch: Exception -> L7
        r11.put(WsConstants.KEY_CHANNEL_TYPE, 2);     // Catch: Exception -> L7
        this.f13298a.onConnection(r11);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @Override // w1.c.k
    public void b(String r10, int r11, String r12) {
        Logger.d("WsChannelSdk_ok", "onFailure() : " + r12);
        Bundle r13 = new Bundle();
        r13.putString("url", r10);
        r13.putInt(WsConstants.ERROR_CODE, r11);
        r13.putString("error_msg", r12);
        r13.putString(EnsureReportData.METHOD, "onFailure");
        f2.a.a(this.f13299b, "WsChannelSdk_ok", r13);
        if (this.f13298a == null) goto L12;
        JSONObject r14 = new JSONObject();
        r14.put(WsConstants.KEY_CONNECTION_TYPE, 0);     // Catch: Exception -> L7
        r14.put("state", 2);     // Catch: Exception -> L7
        r14.put("url", r10);     // Catch: Exception -> L7
        r14.put(WsConstants.KEY_CHANNEL_TYPE, 2);     // Catch: Exception -> L7
        r14.put("error", r12);     // Catch: Exception -> L7
        r14.put(WsConstants.ERROR_CODE, r11);     // Catch: Exception -> L7
        this.f13298a.onConnection(r14);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}
