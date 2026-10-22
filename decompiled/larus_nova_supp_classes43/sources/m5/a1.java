package m5;

import com.bytedance.ai.monitor.timeline.LoadingStage;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class a1 {
    public final Map<String, h1> a;
    public final Map<String, b1> b;
    public final Map<String, h1> c;
    public final Map<String, b1> d;
    public final Map<String, z0> e;
    public final String f;

    public a1() {
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.e = new LinkedHashMap();
        this.f = "CommonEventMonitor";
    }

    public final boolean b(String r10) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        z0 r11 = d1.a(this.e, r10);
        if (r11.c.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return true;
    L8:
        if (r11.a == true) goto L13;
        return false;
    L13:
        return true;
    L5:
        r0 = false;
        goto L6
    }

    public final void t(String r10) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        d1.a(this.e, r10).a = true;
    }

    public final boolean u(String r10) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Object r0 = ((LinkedHashMap) d1.a(this.e, r10).d).get("render_type");
        if ((r0 instanceof String) == false) goto L5;
        String r1 = (String) r0;
    L6:
        if (r1 != null) goto L9;
        return false;
    L9:
        return a(r10, r1);
    L5:
        r1 = null;
        goto L6
    }

    public final boolean a(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        if (r11 != null) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r11, "lynx") == false) goto L10;
        if (d1.d(this.a, r10).c("draw_end") <= 0) goto L16;
    L13:
        return true;
    L16:
        return false;
    L10:
        if (Intrinsics.areEqual(r11, "webview") == false) goto L13;
        if (d1.d(this.c, r10).c("page_finish") > 0) goto L13;
        return false;
    }

    public final void d(String r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter(r10, "traceId");
        com.bytedance.ai.utils.g.a.d(this.f, "onInitJSWorkerEnd: " + r10 + ", " + r11);
        h1 r0 = d1.d(this.c, r10);
        r0.d("applet_init_js_worker_end", Long.valueOf(r11));
        d1.b(this.d, r10).d("init_js_worker_duration", Long.valueOf(r11 - r0.c("applet_init_js_worker_start")));
    }

    public final void e(String r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter(r10, "traceId");
        com.bytedance.ai.utils.g.a.d(this.f, "onInitJSWorkerStart: " + r10 + ", " + r11);
        d1.d(this.c, r10).d("applet_init_js_worker_start", Long.valueOf(r11));
        d1.a(this.e, r10).a(LoadingStage.STAGE_RUN_MAIN_JS.getStageName());
    }

    public final void g(String r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter(r10, "traceId");
        com.bytedance.ai.utils.g.a.d(this.f, "onLoadAppletStart: " + r10 + ", " + r11);
        d1.d(this.c, r10).d("applet_load_applet_info_start", Long.valueOf(r11));
        d1.a(this.e, r10).a(LoadingStage.STAGE_LOAD_APPLET.getStageName());
    }

    public final void i(String r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter(r10, "traceId");
        com.bytedance.ai.utils.g.a.d(this.f, "onLoadMainJSStart: " + r10 + ", " + r11);
        d1.d(this.c, r10).d("applet_load_main_js_start", Long.valueOf(r11));
        d1.a(this.e, r10).a(LoadingStage.STAGE_LOAD_MAIN_JS.getStageName());
    }

    public final void j(String r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter(r10, "traceId");
        com.bytedance.ai.utils.g.a.d(this.f, "onPageFinished: " + r10 + ", " + r11);
        h1 r0 = d1.d(this.c, r10);
        r0.d("page_finish", Long.valueOf(r11));
        d1.b(this.d, r10).d("load_template_duration", Long.valueOf(r11 - r0.c("page_start")));
    }

    public final void k(String r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter(r10, "traceId");
        com.bytedance.ai.utils.g.a.d(this.f, "onPageStart: " + r10 + ", " + r11);
        d1.d(this.c, r10).d("page_start", Long.valueOf(r11));
    }

    public final void l(String r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter(r10, "traceId");
        com.bytedance.ai.utils.g.a.d(this.f, "onPrepareComponentEnd: " + r10 + ", " + r11);
        h1 r0 = d1.d(this.c, r10);
        r0.d("prepare_component_end", Long.valueOf(r11));
        d1.b(this.d, r10).d("prepare_component_duration", Long.valueOf(r11 - r0.c("prepare_component_start")));
    }

    public void m(String r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter(r10, "traceId");
        com.bytedance.ai.utils.g.a.d(this.f, "onPrepareComponentStart: " + r10 + ", " + r11);
        d1.d(this.c, r10).d("prepare_component_start", Long.valueOf(r11));
        d1.a(this.e, r10).a(LoadingStage.STAGE_PREPARE_COMPONENT.getStageName());
    }

    public final void n(String r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter(r10, "traceId");
        com.bytedance.ai.utils.g.a.d(this.f, "onRenderTemplateEnd: " + r10 + ", " + r11);
        h1 r0 = d1.d(this.c, r10);
        r0.d("render_template_end", Long.valueOf(r11));
        d1.b(this.d, r10).d("render_template_main", Long.valueOf(r11 - r0.c("render_template_start")));
    }

    public void q(String r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter(r10, "traceId");
        com.bytedance.ai.utils.g.a.d(this.f, "onRunAppletRuntimeStart: " + r10 + ", " + r11);
        d1.d(this.c, r10).d("applet_run_applet_start", Long.valueOf(r11));
        d1.a(this.e, r10).a(LoadingStage.STAGE_RUN_APPLET_RUNTIME.getStageName());
    }

    public final void c(String r10, String r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter(r11, "errorMessage");
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter(r11, "errorMessage");
        com.bytedance.ai.utils.g.a.d(this.f, "onError: " + r10 + ", " + r11 + ", " + r12);
        z0 r13 = d1.a(this.e, r10);
        r13.d.put(com.bytedance.android.ec.core.event.a.KEY_ERROR_MSG, r11);
        r13.d.put(com.bytedance.android.ec.core.event.a.KEY_ERROR_CODE, Integer.valueOf(r12));
    }

    public final void f(String r10, long r11, Map<String, ? extends Object> r12) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter(r12, "eventInfo");
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter(r12, "eventInfo");
        com.bytedance.ai.utils.g.a.d(this.f, "onLoadAppletEnd: " + r10 + ", " + r11);
        h1 r0 = d1.d(this.c, r10);
        r0.d("applet_load_applet_info_end", Long.valueOf(r11));
        d1.a(this.e, r10).d.putAll(r12);
        d1.b(this.d, r10).d("load_applet_duration", Long.valueOf(r11 - r0.c("applet_load_applet_info_start")));
    }

    public final void h(String r10, long r11, Map<String, ? extends Object> r12) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter(r12, "eventInfo");
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter(r12, "eventInfo");
        com.bytedance.ai.utils.g.a.d(this.f, "onLoadMainJSEnd: " + r10 + ", " + r11);
        h1 r0 = d1.d(this.c, r10);
        r0.d("applet_load_main_js_end", Long.valueOf(r11));
        d1.a(this.e, r10).d.putAll(r12);
        d1.b(this.d, r10).d("load_main_js_duration", Long.valueOf(r11 - r0.c("applet_load_main_js_start")));
        d1.a(this.e, r10).a(LoadingStage.STAGE_RUN_MAIN_JS.getStageName());
    }

    public final void o(String r10, long r11, Map<String, ? extends Object> r12) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter(r12, "eventInfo");
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter(r12, "eventInfo");
        com.bytedance.ai.utils.g.a.d(this.f, "onRenderTemplateStart: " + r10 + ", " + r11);
        h1 r0 = d1.d(this.c, r10);
        r0.d("render_template_start", Long.valueOf(r11));
        d1.b(this.d, r10).d("view_create_to_render", Long.valueOf(r11 - r0.c("prepare_component_end")));
        z0 r13 = d1.a(this.e, r10);
        r13.a(LoadingStage.STAGE_RENDER_TEMPLATE.getStageName());
        r13.d.putAll(r12);
    }

    public final void p(String r10, long r11, Map<String, ? extends Object> r12) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter(r12, "eventInfo");
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter(r12, "eventInfo");
        com.bytedance.ai.utils.g.a.d(this.f, "onRunAppletRuntimeEnd: " + r10 + ", " + r11);
        h1 r0 = d1.d(this.c, r10);
        r0.d("applet_run_applet_end", Long.valueOf(r11));
        d1.a(this.e, r10).d.putAll(r12);
        d1.b(this.d, r10).d("load_applet_runtime_duration", Long.valueOf(r11 - r0.c("applet_run_applet_start")));
    }

    public final void s(String r10, long r11, long r12) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter(r10, "traceId");
        com.bytedance.ai.utils.g.a.d(this.f, "onWebDrawEnd: " + r10 + ", " + r11 + ", " + r12);
        h1 r0 = d1.d(this.c, r10);
        r0.d("navigation_start", Long.valueOf(r11));
        r0.d("draw_end", Long.valueOf(r12));
        d1.b(this.d, r10).d("web_fmp", Long.valueOf(r12 - r11));
    }

    public final void r(String r10, Map<String, Object> r11, Map<String, Long> r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        h1 r0 = d1.d(this.a, r10);
        b1 r1 = d1.b(this.b, r10);
        e1.a(r11, r0, r1);
        Intrinsics.checkNotNullParameter(r0, "timeStampMap");
        Intrinsics.checkNotNullParameter(r1, "durationMap");
        Long r14 = null;
        if (r11 == null) goto L16;
        if (r11.get("metrics") == null) goto L16;
        Object r15 = r11.get("metrics");
        if ((r15 instanceof HashMap) == false) goto L9;
        HashMap r16 = (HashMap) r15;
    L10:
        if (r16 == null) goto L16;
        Object r17 = r11.get("metrics");
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>");
        HashMap r18 = (HashMap) r17;
        Iterator r19 = r18.keySet().iterator();
    L13:
        if (r19.hasNext() == false) goto L16;
        String r20 = (String) r19.next();
        Object r21 = r18.get(r20);
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type kotlin.Long");
        r1.d(r20, (Long) r21);
        goto L13
    L9:
        r16 = null;
    L16:
        if ((r12 instanceof HashMap) == false) goto L18;
        HashMap r110 = (HashMap) r12;
    L19:
        if (r110 == null) goto L29;
        Iterator r22 = r110.keySet().iterator();
    L22:
        if (r22.hasNext() == false) goto L24;
        String r23 = (String) r22.next();
        Object r24 = r110.get(r23);
        Intrinsics.checkNotNull(r24, "null cannot be cast to non-null type kotlin.Long");
        r0.d(r23, (Long) r24);
        goto L22
    L24:
        r1.d("create_vdom", Long.valueOf(e1.b(r110, "create_vdom_start", "create_vdom_end")));
        r1.d("dispatch", Long.valueOf(e1.b(r110, "dispatch_start", "dispatch_end")));
        r1.d("layout", Long.valueOf(e1.b(r110, "layout_start", "layout_end")));
        r1.d("ui_operation_flush", Long.valueOf(e1.b(r110, "ui_operation_flush_start", "ui_operation_flush_end")));
        r1.d("load_app_end", Long.valueOf(e1.b(r110, "api_request_start", "api_request_end")));
        Object r25 = r110.get("draw_end");
        if ((r25 instanceof Long) == false) goto L27;
        r14 = (Long) r25;
    L27:
        if (r14 == null) goto L29;
        r0.d("update_draw_end", Long.valueOf(r14.longValue()));
    L29:
        z0 r26 = d1.a(this.e, r10);
        if (r13 == null) goto L35;
        r26.d.put("lynx_update_flag", r13);
        return;
    L35:
        return;
    L18:
        r110 = null;
        goto L19
    }
}
