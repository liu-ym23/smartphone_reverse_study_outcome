package m5;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g1 extends a1 {
    public final String g;

    public g1() {
        this.g = "PageEventMonitor";
    }

    public final JSONObject v(String r18) {
        Intrinsics.checkNotNullParameter(r18, "traceId");
        JSONObject r10 = new JSONObject();
        r10.put("eventName", "applet_page_timeline_full");
        z0 r11 = d1.a(this.e, r18);
        h1 r12 = d1.d(this.c, r18);
        b1 r13 = d1.b(this.d, r18);
        h1 r14 = d1.d(this.a, r18);
        b1 r15 = d1.b(this.b, r18);
        Object r16 = ((LinkedHashMap) r11.d).get("render_type");
        if ((r16 instanceof String) == false) goto L5;
        String r17 = (String) r16;
    L6:
        JSONObject r19 = new JSONObject();
        r19.put("trace_id", r18);
        if (r17 != null) goto L9;
        String r110 = "";
    L10:
        r19.put("render_type", r110);
        r19.put("scene", r11.c);
        Iterator r20 = ((LinkedHashMap) r11.d).entrySet().iterator();
    L12:
        if (r20.hasNext() == false) goto L14;
        Map.Entry r111 = (Map.Entry) r20.next();
        r19.put((String) r111.getKey(), r111.getValue());
        goto L12
    L14:
        r10.put(com.bytedance.android.ec.core.event.a.KEY_LUBAN_CATEGORY, r19);
        if (a(r18, r17) == false) goto L43;
        r19.put("success", 1);
        JSONObject r1 = new JSONObject();
        l5.z.a(r1, r12.a);
        l5.z.a(r1, r13.a);
        l5.z.a(r1, r14.a);
        l5.z.a(r1, r15.a);
        if (r12.c("draw_end") <= 0) goto L20;
        long r21 = r12.c("draw_end");
    L27:
        if (r14.c("update_draw_end") <= 0) goto L29;
        long r112 = r14.c("update_draw_end");
    L30:
        long r22 = r12.c("open_time");
        long r23 = RangesKt.coerceAtLeast(r14.c("draw_end"), r14.c("load_app_end"));
        if (r23 <= 0) goto L33;
        r1.put("full_tti", r23 - r22);
    L33:
        r1.put("fcp_time", r21 - r22);
        r1.put("full_time", r112 - r22);
        if (r1.opt("load_applet_duration") != null) goto L37;
        r1.put("load_applet_duration", 0);
    L37:
        if (r1.opt("init_js_worker_duration") != null) goto L40;
        r1.put("init_js_worker_duration", 0);
    L40:
        if (r1.opt("load_main_js_duration") != null) goto L42;
        r1.put("load_main_js_duration", 0);
    L42:
        r10.put("metric", r1);
        return r10;
    L29:
        r112 = r21;
        goto L30
    L20:
        if (r14.c("draw_end") <= 0) goto L23;
        r21 = r14.c("draw_end");
        goto L27
    L23:
        if (r12.c("page_finish") <= 0) goto L25;
        r21 = r12.c("page_finish");
        goto L27
    L25:
        r21 = 0;
        goto L27
    L43:
        boolean r24 = r11.d.containsKey(com.bytedance.android.ec.core.event.a.KEY_ERROR_MSG);
        r19.put("success", 0);
        r19.put("error_stage", r11.b);
        if (r24 == false) goto L48;
        Map<String, Integer> r25 = c1.a;
        Integer r26 = r25.get(r11.b);
        if (r26 != null) goto L49;
        r26 = r25.get("unexpectedError");
    L49:
        r19.put("error_stage_code", r26);
        return r10;
    L48:
        r26 = c1.a.get("unknownError");
        goto L49
    L9:
        r110 = r17;
        goto L10
    L5:
        r17 = null;
        goto L6
    }

    @Override // m5.a1
    public final void m(String r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        com.bytedance.ai.utils.g.a.d(this.g, "onPrepareComponentStart: " + r10 + ", " + r11);
        super.m(r10, r11);
        d1.b(this.d, r10).d("page_to_view", Long.valueOf(r11 - d1.d(this.c, r10).c("create_page")));
    }

    @Override // m5.a1
    public final void q(String r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        com.bytedance.ai.utils.g.a.d(this.g, "onRunAppletRuntimeStart: " + r10 + ", " + r11);
        super.q(r10, r11);
        d1.b(this.d, r10).d("create_to_runtime", Long.valueOf(r11 - d1.d(this.c, r10).c("open_time")));
    }
}
