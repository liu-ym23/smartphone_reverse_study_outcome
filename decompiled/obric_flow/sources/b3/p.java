package b3;

import android.util.LruCache;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class p extends j {
    public final LruCache g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f853h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LruCache f854i;

    public p() {
        this.g = new LruCache(10);
        this.f853h = "WidgetEventMonitor";
        this.f854i = new LruCache(10);
    }

    @Override // b3.j
    public final void l(long r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        String r11 = sj.g.j("onPrepareComponentStart: ", r5, r10, ", ");
        String r12 = this.f853h;
        Intrinsics.checkNotNullParameter(r12, "tag");
        t0.d r13 = com.bytedance.ai.utils.c.f2846a;
        if (r13 == null) goto L5;
        r13.d(r12, r11);
    L5:
        super.l(r5, r10);
        o r14 = com.lynx.tasm.base.a.l(r10, this.f849c);
        com.lynx.tasm.base.a.k(r10, this.d).a("widget_to_view", Long.valueOf(r5 - r14.d("applet_load_widget_info_end")));
    }

    @Override // b3.j
    public final void n(long r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        String r11 = sj.g.j("onRunAppletRuntimeStart: ", r5, r10, ", ");
        String r12 = this.f853h;
        Intrinsics.checkNotNullParameter(r12, "tag");
        t0.d r13 = com.bytedance.ai.utils.c.f2846a;
        if (r13 == null) goto L5;
        r13.d(r12, r11);
    L5:
        super.n(r5, r10);
        o r14 = com.lynx.tasm.base.a.l(r10, this.f849c);
        k r15 = com.lynx.tasm.base.a.k(r10, this.d);
        Intrinsics.checkNotNullParameter("applet_create_container", "start");
        Intrinsics.checkNotNullParameter("applet_run_applet_start", "end");
        long r16 = r14.d("applet_create_container");
        long r17 = r14.d("applet_run_applet_start");
        if (r16 != (-1)) goto L8;
    L11:
        long r18 = 0;
    L12:
        r15.a("create_to_runtime", Long.valueOf(r18));
        return;
    L8:
        if (r17 == (-1)) goto L11;
        r18 = r17 - r16;
        goto L12
    }

    public final JSONObject o(String r17) {
        Intrinsics.checkNotNullParameter(r17, "traceId");
        JSONObject r5 = new JSONObject();
        r5.put("eventName", "applet_widget_timeline_full");
        i r10 = com.lynx.tasm.base.a.a(r17, this.e);
        o r11 = com.lynx.tasm.base.a.l(r17, this.f849c);
        k r12 = com.lynx.tasm.base.a.k(r17, this.d);
        o r13 = com.lynx.tasm.base.a.l(r17, this.f847a);
        k r14 = com.lynx.tasm.base.a.k(r17, this.f848b);
        LinkedHashMap r15 = r10.d;
        Object r16 = r15.get("render_type");
        if ((r16 instanceof String) == false) goto L5;
        String r18 = (String) r16;
    L6:
        JSONObject r19 = com.lynx.tasm.utils.d.k("trace_id", r17);
        if (r18 != null) goto L9;
        String r110 = "";
    L10:
        r19.put("render_type", r110);
        r19.put("scene", r10.f846c);
        Iterator r20 = r15.entrySet().iterator();
    L12:
        if (r20.hasNext() == false) goto L14;
        Map.Entry r111 = (Map.Entry) r20.next();
        r19.put((String) r111.getKey(), r111.getValue());
        goto L12
    L14:
        r5.put("category", r19);
        if (p(r17, r18) == false) goto L51;
        r19.put("success", 1);
        JSONObject r21 = new JSONObject();
        io.reactivex.exceptions.a.g(r21, r11.f852b);
        io.reactivex.exceptions.a.g(r21, r12.f852b);
        io.reactivex.exceptions.a.g(r21, r13.f852b);
        io.reactivex.exceptions.a.g(r21, r14.f852b);
        if (r11.d("draw_end") <= 0) goto L20;
        long r22 = r11.d("draw_end");
    L27:
        if (r13.d("update_draw_end") <= 0) goto L29;
        long r112 = r13.d("update_draw_end");
    L30:
        long r113 = r11.d("applet_create_container");
        long r23 = RangesKt.coerceAtLeast(r13.d("draw_end"), r13.d("load_app_end"));
        if (r23 <= 0) goto L33;
        r21.put("full_tti", r23 - r113);
    L33:
        r21.put("fcp_time", r22 - r113);
        r21.put("full_time", r112 - r113);
        if (r21.opt("load_applet_duration") != null) goto L36;
        int r24 = 0;
        r21.put("load_applet_duration", 0);
    L38:
        if (r21.opt("init_js_worker_duration") != null) goto L41;
        r21.put("init_js_worker_duration", r24);
    L41:
        if (r21.opt("load_main_js_duration") != null) goto L44;
        r21.put("load_main_js_duration", r24);
    L44:
        if (r11.d("app_launch_time") <= 0) goto L47;
        r21.put("app_launch_to_draw_end", r112 - r11.d("app_launch_time"));
    L47:
        if (r11.d("host_page_enter_time") <= 0) goto L49;
        r21.put("host_enter_to_draw_end", r112 - r11.d("host_page_enter_time"));
    L49:
        r5.put(LynxMonitorService.KEY_METRIC, r21);
        return r5;
    L36:
        r24 = 0;
        goto L38
    L29:
        r112 = r22;
        goto L30
    L20:
        if (r13.d("draw_end") <= 0) goto L23;
        r22 = r13.d("draw_end");
        goto L27
    L23:
        if (r11.d("page_finish") <= 0) goto L25;
        r22 = r11.d("page_finish");
        goto L27
    L25:
        r22 = 0;
        goto L27
    L51:
        boolean r25 = r15.containsKey("error_msg");
        r19.put("success", 0);
        r19.put("error_stage", r10.f845b);
        if (r25 == false) goto L56;
        Map r26 = l.f850a;
        Integer r27 = (Integer) r26.get(r10.f845b);
        if (r27 != null) goto L57;
        r27 = (Integer) r26.get("unexpectedError");
    L57:
        r19.put("error_stage_code", r27);
        return r5;
    L56:
        r27 = (Integer) l.f850a.get("unknownError");
        goto L57
    L9:
        r110 = r18;
        goto L10
    L5:
        r18 = null;
        goto L6
    }

    public final boolean p(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        if (r11 != null) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r11, "lynx") == false) goto L11;
        if (com.lynx.tasm.base.a.l(r10, this.f847a).d("draw_end") <= 0) goto L9;
        return true;
    L9:
        return false;
    L11:
        if (Intrinsics.areEqual(r11, "webview") == true) goto L13;
        return true;
    L13:
        if (com.lynx.tasm.base.a.l(r10, this.f849c).d("page_finish") <= 0) goto L15;
        return true;
    L15:
        return false;
    }
}
