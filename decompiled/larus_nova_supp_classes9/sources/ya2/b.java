package ya2;

import com.bytedance.android.livesdk.log.u;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public static void a(String r2, String r3) {
        HashMap r0 = new HashMap();
        if (r2 == null) goto L5;
        r0.put("anchor_id", r2);
    L5:
        r0.put("request_page", r3);
        u.l().sendLog("livesdk_live_announcement_click", r0, new Object[0]);
    }

    public static void b(String r2, String r3) {
        HashMap r0 = new HashMap();
        if (r2 == null) goto L5;
        r0.put("anchor_id", r2);
    L5:
        r0.put("request_page", r3);
        u.l().sendLog("livesdk_live_announcement_submit", r0, new Object[0]);
    }
}
