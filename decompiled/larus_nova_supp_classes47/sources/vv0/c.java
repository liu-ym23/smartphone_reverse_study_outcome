package vv0;

import com.bytedance.android.livehostapi.platform.IHostMonitor;
import com.bytedance.android.livesdk.chatroom.utils.n3;
import com.bytedance.android.livesdk.config.iz0;
import com.bytedance.common.utility.Logger;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements sv0.a {
    public c() {
    }

    @Override // sv0.a
    public final void a(String r5, JSONObject r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        String r0 = r6.optString("mode", "");
        if (Intrinsics.areEqual(r0, "push") == false) goto L7;
        return;
    L7:
        int r3 = 1;
        if ((!Intrinsics.areEqual("live_client_monitor_log", r5)) == false) goto L27;
        k.n(IHostMonitor.class).monitorCommonLog(r5, r6);
        return;
    L27:
    L24:
        e = move-exception;
        Logger.e("uploadLog", e.getMessage());
        return;
    L12:
        if (Intrinsics.areEqual("live_client_monitor_log", r5) == true) goto L14;
        return;
    L14:
        if (Intrinsics.areEqual("rtc", r0) == false) goto L30;
        boolean r1 = n3.h();     // Catch: Exception -> L24
        if (((Boolean) iz0.a.getValue()).booleanValue() == true) goto L19;
        if (r1 == true) goto L22;
        r3 = 0;
    L22:
        r6.put("live_message_fetch_type", r3);     // Catch: Exception -> L24
        k.n(IHostMonitor.class).monitorCommonLog(r5, r6);     // Catch: Exception -> L24
        return;
    L19:
        if (r1 == true) goto L21;
        r3 = 2;
        goto L22
    L21:
        r3 = 3;
        goto L22
    }
}
