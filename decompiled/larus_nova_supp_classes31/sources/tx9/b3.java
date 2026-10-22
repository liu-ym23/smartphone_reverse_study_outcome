package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.trace.RealTimeNavEndReason;
import com.larus.trace.RealTimeNavStartFailReason;
import com.larus.trace.RealTimeNavStartResult;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b3 {
    public static void a(String r2, Long r3, RealTimeNavEndReason r4, String r5, String r6) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r2 == null) goto L5;
        r0.put("navigate_unique_id", r2);
    L5:
        if (r3 == null) goto L8;
        r0.put("duration", r3.longValue());
    L8:
        if (r4 == null) goto L10;
        r0.put("end_reason", r4.getValue());
    L10:
        if (r5 == null) goto L12;
        r0.put("end_reason", r5);
    L12:
        if (r6 == null) goto L14;
        r0.put("extra_info", r6);
    L14:
        TrackParams r7 = new TrackParams().merge(r0);
        by7.a r8 = new by7.a("real_time_nav_end");
        r8.a.merge(r7);
        r8.b();
    }

    public static void b(String r2, RealTimeNavStartResult r3, Long r4, Long r5, Long r6, Long r7, Long r8, RealTimeNavStartFailReason r9, String r10, String r11) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r2 == null) goto L5;
        r0.put("navigate_unique_id", r2);
    L5:
        if (r3 == null) goto L7;
        r0.put("result", r3.getValue());
    L7:
        if (r4 == null) goto L9;
        r0.put("init_duration", r4.longValue());
    L9:
        if (r5 == null) goto L11;
        r0.put("auth_duration", r5.longValue());
    L11:
        if (r6 == null) goto L13;
        r0.put("get_origin_duration", r6.longValue());
    L13:
        if (r7 == null) goto L15;
        r0.put("route_duration", r7.longValue());
    L15:
        if (r8 == null) goto L18;
        r0.put("total_duration", r8.longValue());
    L18:
        if (r9 == null) goto L20;
        r0.put("fail_reason", r9.getValue());
    L20:
        if (r10 == null) goto L22;
        r0.put("fail_reason", r10);
    L22:
        if (r11 == null) goto L24;
        r0.put("extra_info", r11);
    L24:
        TrackParams r12 = new TrackParams().merge(r0);
        by7.a r13 = new by7.a("real_time_nav_start");
        r13.a.merge(r12);
        r13.b();
    }
}
