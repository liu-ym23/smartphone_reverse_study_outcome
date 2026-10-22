package m5;

import android.util.LruCache;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class i1 extends a1 {
    public final LruCache<String, h1> g;
    public final String h;
    public final LruCache<String, Map<String, Object>> i;

    public i1() {
        this.g = new LruCache(10);
        this.h = "WidgetEventMonitor";
        this.i = new LruCache(10);
    }

    public final JSONObject v(String r20) {
        Intrinsics.checkNotNullParameter(r20, "traceId");
        JSONObject r10 = new JSONObject();
        r10.put("eventName", "applet_widget_timeline_full");
        z0 r11 = d1.a(this.e, r20);
        h1 r12 = d1.d(this.c, r20);
        b1 r13 = d1.b(this.d, r20);
        h1 r14 = d1.d(this.a, r20);
        b1 r15 = d1.b(this.b, r20);
        Object r16 = ((LinkedHashMap) r11.d).get("render_type");
        if ((r16 instanceof String) == false) goto L5;
        String r17 = (String) r16;
    L6:
        JSONObject r18 = new JSONObject();
        r18.put("trace_id", r20);
        if (r17 != null) goto L9;
        String r19 = "";
    L10:
        r18.put("render_type", r19);
        r18.put("scene", r11.c);
        Iterator r21 = ((LinkedHashMap) r11.d).entrySet().iterator();
    L12:
        if (r21.hasNext() == false) goto L14;
        Map.Entry r110 = (Map.Entry) r21.next();
        r18.put((String) r110.getKey(), r110.getValue());
        goto L12
    L14:
        r10.put(com.bytedance.android.ec.core.event.a.KEY_LUBAN_CATEGORY, r18);
        if (a(r20, r17) == false) goto L50;
        r18.put("success", 1);
        JSONObject r1 = new JSONObject();
        l5.z.a(r1, r12.a);
        l5.z.a(r1, r13.a);
        l5.z.a(r1, r14.a);
        l5.z.a(r1, r15.a);
        if (r12.c("draw_end") <= 0) goto L20;
        long r22 = r12.c("draw_end");
    L27:
        if (r14.c("update_draw_end") <= 0) goto L29;
        long r111 = r14.c("update_draw_end");
    L30:
        long r112 = r12.c("applet_create_container");
        long r113 = r22;
        long r23 = RangesKt.coerceAtLeast(r14.c("draw_end"), r14.c("load_app_end"));
        if (r23 <= 0) goto L33;
        r1.put("full_tti", r23 - r112);
    L33:
        r1.put("fcp_time", r113 - r112);
        r1.put("full_time", r111 - r112);
        if (r1.opt("load_applet_duration") != null) goto L36;
        int r24 = 0;
        r1.put("load_applet_duration", 0);
    L38:
        if (r1.opt("init_js_worker_duration") != null) goto L41;
        r1.put("init_js_worker_duration", r24);
    L41:
        if (r1.opt("load_main_js_duration") != null) goto L44;
        r1.put("load_main_js_duration", r24);
    L44:
        if (r12.c("app_launch_time") <= 0) goto L47;
        r1.put("app_launch_to_draw_end", r111 - r12.c("app_launch_time"));
    L47:
        if (r12.c("host_page_enter_time") <= 0) goto L49;
        r1.put("host_enter_to_draw_end", r111 - r12.c("host_page_enter_time"));
    L49:
        r10.put("metric", r1);
    L57:
        return r10;
    L36:
        r24 = 0;
        goto L38
    L29:
        r111 = r22;
        goto L30
    L20:
        if (r14.c("draw_end") <= 0) goto L23;
        r22 = r14.c("draw_end");
        goto L27
    L23:
        if (r12.c("page_finish") <= 0) goto L25;
        r22 = r12.c("page_finish");
        goto L27
    L25:
        r22 = 0;
        goto L27
    L50:
        boolean r25 = r11.d.containsKey(com.bytedance.android.ec.core.event.a.KEY_ERROR_MSG);
        r18.put("success", 0);
        r18.put("error_stage", r11.b);
        if (r25 == false) goto L55;
        Map<String, Integer> r26 = c1.a;
        Integer r27 = r26.get(r11.b);
        if (r27 != null) goto L56;
        r27 = r26.get("unexpectedError");
    L56:
        r18.put("error_stage_code", r27);
        goto L57
    L55:
        r27 = c1.a.get("unknownError");
        goto L56
    L9:
        r19 = r17;
        goto L10
    L5:
        r17 = null;
        goto L6
    }

    public final void w(String r10) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter(r10, "traceId");
        this.c.remove(r10);
        this.d.remove(r10);
        this.e.remove(r10);
        this.a.remove(r10);
        this.b.remove(r10);
        this.g.remove(r10);
    }

    @Override // m5.a1
    public final void m(String r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        com.bytedance.ai.utils.g.a.d(this.h, "onPrepareComponentStart: " + r10 + ", " + r11);
        super.m(r10, r11);
        d1.b(this.d, r10).d("widget_to_view", Long.valueOf(r11 - d1.d(this.c, r10).c("applet_load_widget_info_end")));
    }

    @Override // m5.a1
    public final void q(String r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        com.bytedance.ai.utils.g.a.d(this.h, "onRunAppletRuntimeStart: " + r10 + ", " + r11);
        super.q(r10, r11);
        h1 r12 = d1.d(this.c, r10);
        b1 r13 = d1.b(this.d, r10);
        Intrinsics.checkNotNullParameter("applet_create_container", "start");
        Intrinsics.checkNotNullParameter("applet_run_applet_start", "end");
        long r1 = r12.c("applet_create_container");
        long r14 = r12.c("applet_run_applet_start");
        if (r1 != (-1)) goto L5;
    L8:
        long r15 = 0;
    L9:
        r13.d("create_to_runtime", Long.valueOf(r15));
        return;
    L5:
        if (r14 == (-1)) goto L8;
        r15 = r14 - r1;
        goto L9
    }
}
