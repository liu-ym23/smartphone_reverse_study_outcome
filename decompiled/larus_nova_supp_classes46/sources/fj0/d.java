package fj0;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void b(long r3, long r5) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("time_remaining", Long.valueOf(r3));
        r0.put("expect_leave_time", Long.valueOf(r5));
        x.t0("paid_leave_from_timer", r0);
        ALogger.e("ttlive_link_paid", "leaveFromTimer, timeRemaining=" + r3 + " expectLeaveTime=" + r5 + ' ');
    }

    public static void a(long r3, long r5, Long r7) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("time_remaining", Long.valueOf(r3));
        r0.put("expect_leave_time", Long.valueOf(r5));
        r0.put("server_time", String.valueOf(r7));
        x.t0("paid_leave_from_list_change", r0);
        ALogger.e("ttlive_link_paid", "leaveFromListChange, timeRemaining=" + r3 + " expectLeaveTime=" + r5 + " serverCurrentTime= " + r7);
    }
}
