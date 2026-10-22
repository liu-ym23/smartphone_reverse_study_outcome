package b3;

import com.bytedance.lynx.service.monitor.LynxMonitorService;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class n extends j {
    public final String g;

    public n() {
        this.g = "PageEventMonitor";
    }

    @Override // b3.j
    public final void l(long r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        String r11 = sj.g.j("onPrepareComponentStart: ", r5, r10, ", ");
        String r12 = this.g;
        Intrinsics.checkNotNullParameter(r12, "tag");
        t0.d r13 = com.bytedance.ai.utils.c.f2846a;
        if (r13 == null) goto L5;
        r13.d(r12, r11);
    L5:
        super.l(r5, r10);
        o r14 = com.lynx.tasm.base.a.l(r10, this.f849c);
        com.lynx.tasm.base.a.k(r10, this.d).a("page_to_view", Long.valueOf(r5 - r14.d("create_page")));
    }

    @Override // b3.j
    public final void n(long r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        String r11 = sj.g.j("onRunAppletRuntimeStart: ", r5, r10, ", ");
        String r12 = this.g;
        Intrinsics.checkNotNullParameter(r12, "tag");
        t0.d r13 = com.bytedance.ai.utils.c.f2846a;
        if (r13 == null) goto L5;
        r13.d(r12, r11);
    L5:
        super.n(r5, r10);
        o r14 = com.lynx.tasm.base.a.l(r10, this.f849c);
        com.lynx.tasm.base.a.k(r10, this.d).a("create_to_runtime", Long.valueOf(r5 - r14.d("open_time")));
    }

    public final JSONObject o(String r15) {
        Intrinsics.checkNotNullParameter(r15, "traceId");
        JSONObject r5 = new JSONObject();
        r5.put("eventName", "applet_page_timeline_full");
        i r10 = com.lynx.tasm.base.a.a(r15, this.e);
        o r11 = com.lynx.tasm.base.a.l(r15, this.f849c);
        k r12 = com.lynx.tasm.base.a.k(r15, this.d);
        o r13 = com.lynx.tasm.base.a.l(r15, this.f847a);
        k r14 = com.lynx.tasm.base.a.k(r15, this.f848b);
        LinkedHashMap r16 = r10.d;
        Object r17 = r16.get("render_type");
        if ((r17 instanceof String) == false) goto L5;
        String r18 = (String) r17;
    L6:
        JSONObject r19 = com.lynx.tasm.utils.d.k("trace_id", r15);
        if (r18 != null) goto L9;
        String r110 = "";
    L10:
        r19.put("render_type", r110);
        r19.put("scene", r10.f846c);
        Iterator r20 = r16.entrySet().iterator();
    L12:
        if (r20.hasNext() == false) goto L14;
        Map.Entry r111 = (Map.Entry) r20.next();
        r19.put((String) r111.getKey(), r111.getValue());
        goto L12
    L14:
        r5.put("category", r19);
        if (p(r15, r18) == false) goto L44;
        r19.put("success", 1);
        JSONObject r112 = new JSONObject();
        io.reactivex.exceptions.a.g(r112, r11.f852b);
        io.reactivex.exceptions.a.g(r112, r12.f852b);
        io.reactivex.exceptions.a.g(r112, r13.f852b);
        io.reactivex.exceptions.a.g(r112, r14.f852b);
        if (r11.d("draw_end") <= 0) goto L20;
        long r21 = r11.d("draw_end");
    L27:
        if (r13.d("update_draw_end") <= 0) goto L29;
        long r113 = r13.d("update_draw_end");
    L30:
        long r22 = r11.d("open_time");
        long r23 = RangesKt.coerceAtLeast(r13.d("draw_end"), r13.d("load_app_end"));
        if (r23 <= 0) goto L33;
        r112.put("full_tti", r23 - r22);
    L33:
        r112.put("fcp_time", r21 - r22);
        r112.put("full_time", r113 - r22);
        if (r112.opt("load_applet_duration") != null) goto L37;
        r112.put("load_applet_duration", 0);
    L37:
        if (r112.opt("init_js_worker_duration") != null) goto L40;
        r112.put("init_js_worker_duration", 0);
    L40:
        if (r112.opt("load_main_js_duration") != null) goto L42;
        r112.put("load_main_js_duration", 0);
    L42:
        r5.put(LynxMonitorService.KEY_METRIC, r112);
        return r5;
    L29:
        r113 = r21;
        goto L30
    L20:
        if (r13.d("draw_end") <= 0) goto L23;
        r21 = r13.d("draw_end");
        goto L27
    L23:
        if (r11.d("page_finish") <= 0) goto L25;
        r21 = r11.d("page_finish");
        goto L27
    L25:
        r21 = 0;
        goto L27
    L44:
        boolean r114 = r16.containsKey("error_msg");
        r19.put("success", 0);
        r19.put("error_stage", r10.f845b);
        if (r114 == false) goto L49;
        Map r115 = l.f850a;
        Integer r116 = (Integer) r115.get(r10.f845b);
        if (r116 != null) goto L50;
        r116 = (Integer) r115.get("unexpectedError");
    L50:
        r19.put("error_stage_code", r116);
        return r5;
    L49:
        r116 = (Integer) l.f850a.get("unknownError");
        goto L50
    L9:
        r110 = r18;
        goto L10
    L5:
        r18 = null;
        goto L6
    }

    public final boolean p(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "traceId");
        if (r10 != null) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r10, "webview") == true) goto L7;
        return true;
    L7:
        if (com.lynx.tasm.base.a.l(r5, this.f849c).d("page_finish") <= 0) goto L9;
        return true;
    L9:
        return false;
    }
}
