package qr1;

import com.bytedance.android.live.livepullstream.api.apm.APMEvent;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e implements Observer<Map<String, String>> {
    public final /* synthetic */ i a;

    public e(i r1) {
        this.a = r1;
    }

    public final void onChanged(Object r6) {
        Map r7 = (Map) r6;
        if (r7 != null) goto L5;
        this.a.c(com.bytedance.android.live.livepullstream.api.apm.a.a(APMEvent.Level.E, "enter failed"));
        this.a.a("network_status", "-1");
    L6:
        i r8 = this.a;
        r8.f.b = true;
        r8.h(4, "enter failed cause of room/enter error");
        return;
    L5:
        this.a.d("enter_room_log_id", (String) r7.get("log_id"));
        this.a.c(com.bytedance.android.live.livepullstream.api.apm.a.c(APMEvent.Level.E, "enter failed", String.valueOf(r7)));
        this.a.a("network_status", String.valueOf(r7.get("error_code")));
        goto L6
    }
}
