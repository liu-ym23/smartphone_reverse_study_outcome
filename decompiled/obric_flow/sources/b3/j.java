package b3;

import com.bytedance.ai.monitor.timeline.LoadingStage;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f849c;
    public final LinkedHashMap d;
    public final LinkedHashMap e;
    public final String f;

    public j() {
        this.f847a = new LinkedHashMap();
        this.f848b = new LinkedHashMap();
        this.f849c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.e = new LinkedHashMap();
        this.f = "CommonEventMonitor";
    }

    public final void a(int r5, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter(r11, "errorMessage");
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter(r11, "errorMessage");
        StringBuilder r12 = com.lynx.tasm.base.a.e("onError: ", r10, ", ", r11, ", ");
        r12.append(r5);
        String r13 = r12.toString();
        String r14 = this.f;
        Intrinsics.checkNotNullParameter(r14, "tag");
        t0.d r15 = com.bytedance.ai.utils.c.f2846a;
        if (r15 == null) goto L5;
        r15.d(r14, r13);
    L5:
        LinkedHashMap r16 = com.lynx.tasm.base.a.a(r10, this.e).d;
        r16.put("error_msg", r11);
        r16.put(WsConstants.ERROR_CODE, Integer.valueOf(r5));
    }

    public final void b(String r5, long r10) {
        Intrinsics.checkNotNullParameter(r5, "traceId");
        Intrinsics.checkNotNullParameter(r5, "traceId");
        String r11 = sj.g.j("onInitJSWorkerEnd: ", r10, r5, ", ");
        String r12 = this.f;
        Intrinsics.checkNotNullParameter(r12, "tag");
        t0.d r13 = com.bytedance.ai.utils.c.f2846a;
        if (r13 == null) goto L5;
        r13.d(r12, r11);
    L5:
        o r14 = com.lynx.tasm.base.a.l(r5, this.f849c);
        r14.a("applet_init_js_worker_end", Long.valueOf(r10));
        com.lynx.tasm.base.a.k(r5, this.d).a("init_js_worker_duration", Long.valueOf(r10 - r14.d("applet_init_js_worker_start")));
    }

    public final void c(String r5, long r10, Map r11) {
        Intrinsics.checkNotNullParameter(r5, "traceId");
        Intrinsics.checkNotNullParameter(r11, "eventInfo");
        Intrinsics.checkNotNullParameter(r5, "traceId");
        Intrinsics.checkNotNullParameter(r11, "eventInfo");
        String r12 = sj.g.j("onLoadAppletEnd: ", r10, r5, ", ");
        String r13 = this.f;
        Intrinsics.checkNotNullParameter(r13, "tag");
        t0.d r14 = com.bytedance.ai.utils.c.f2846a;
        if (r14 == null) goto L5;
        r14.d(r13, r12);
    L5:
        o r15 = com.lynx.tasm.base.a.l(r5, this.f849c);
        r15.a("applet_load_applet_info_end", Long.valueOf(r10));
        com.lynx.tasm.base.a.a(r5, this.e).d.putAll(r11);
        com.lynx.tasm.base.a.k(r5, this.d).a("load_applet_duration", Long.valueOf(r10 - r15.d("applet_load_applet_info_start")));
    }

    public final void d(String r10, Map r11, Map r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        o r5 = com.lynx.tasm.base.a.l(r10, this.f847a);
        k r14 = com.lynx.tasm.base.a.k(r10, this.f848b);
        com.lynx.tasm.base.h.e(r11, r5, r14);
        Intrinsics.checkNotNullParameter(r5, "timeStampMap");
        Intrinsics.checkNotNullParameter(r14, "durationMap");
        Long r15 = null;
        if (r11 == null) goto L16;
        if (r11.get(LynxMonitorService.KEY_METRICS) == null) goto L16;
        Object r16 = r11.get(LynxMonitorService.KEY_METRICS);
        if ((r16 instanceof HashMap) == false) goto L9;
        HashMap r17 = (HashMap) r16;
    L10:
        if (r17 == null) goto L16;
        Object r18 = r11.get(LynxMonitorService.KEY_METRICS);
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>");
        HashMap r19 = (HashMap) r18;
        Iterator r20 = r19.keySet().iterator();
    L13:
        if (r20.hasNext() == false) goto L16;
        String r21 = (String) r20.next();
        Object r22 = r19.get(r21);
        Intrinsics.checkNotNull(r22, "null cannot be cast to non-null type kotlin.Long");
        r14.a(r21, (Long) r22);
        goto L13
    L9:
        r17 = null;
    L16:
        if ((r12 instanceof HashMap) == false) goto L18;
        HashMap r110 = (HashMap) r12;
    L19:
        if (r110 == null) goto L29;
        Iterator r23 = r110.keySet().iterator();
    L22:
        if (r23.hasNext() == false) goto L24;
        String r24 = (String) r23.next();
        Object r25 = r110.get(r24);
        Intrinsics.checkNotNull(r25, "null cannot be cast to non-null type kotlin.Long");
        r5.a(r24, (Long) r25);
        goto L22
    L24:
        r14.a("create_vdom", Long.valueOf(com.lynx.tasm.base.h.a("create_vdom_start", "create_vdom_end", r110)));
        r14.a("dispatch", Long.valueOf(com.lynx.tasm.base.h.a("dispatch_start", "dispatch_end", r110)));
        r14.a("layout", Long.valueOf(com.lynx.tasm.base.h.a("layout_start", "layout_end", r110)));
        r14.a("ui_operation_flush", Long.valueOf(com.lynx.tasm.base.h.a("ui_operation_flush_start", "ui_operation_flush_end", r110)));
        r14.a("load_app_end", Long.valueOf(com.lynx.tasm.base.h.a("api_request_start", "api_request_end", r110)));
        Object r26 = r110.get("draw_end");
        if ((r26 instanceof Long) == false) goto L27;
        r15 = (Long) r26;
    L27:
        if (r15 == null) goto L29;
        r5.a("update_draw_end", Long.valueOf(r15.longValue()));
    L29:
        i r27 = com.lynx.tasm.base.a.a(r10, this.e);
        if (r13 == null) goto L35;
        r27.d.put("lynx_update_flag", r13);
        return;
    L35:
        return;
    L18:
        r110 = null;
        goto L19
    }

    public final void e(long r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter(r10, "traceId");
        String r11 = sj.g.j("onInitJSWorkerStart: ", r5, r10, ", ");
        String r12 = this.f;
        Intrinsics.checkNotNullParameter(r12, "tag");
        t0.d r13 = com.bytedance.ai.utils.c.f2846a;
        if (r13 == null) goto L5;
        r13.d(r12, r11);
    L5:
        com.lynx.tasm.base.a.l(r10, this.f849c).a("applet_init_js_worker_start", Long.valueOf(r5));
        i r14 = com.lynx.tasm.base.a.a(r10, this.e);
        LoadingStage[] r15 = LoadingStage.f2393a;
        Intrinsics.checkNotNullParameter("runMainJS", "<set-?>");
        r14.f845b = "runMainJS";
    }

    public final void f(String r5, long r10, Map r11) {
        Intrinsics.checkNotNullParameter(r5, "traceId");
        Intrinsics.checkNotNullParameter(r11, "eventInfo");
        Intrinsics.checkNotNullParameter(r5, "traceId");
        Intrinsics.checkNotNullParameter(r11, "eventInfo");
        String r12 = sj.g.j("onLoadMainJSEnd: ", r10, r5, ", ");
        String r13 = this.f;
        Intrinsics.checkNotNullParameter(r13, "tag");
        t0.d r14 = com.bytedance.ai.utils.c.f2846a;
        if (r14 == null) goto L5;
        r14.d(r13, r12);
    L5:
        o r15 = com.lynx.tasm.base.a.l(r5, this.f849c);
        r15.a("applet_load_main_js_end", Long.valueOf(r10));
        LinkedHashMap r16 = this.e;
        com.lynx.tasm.base.a.a(r5, r16).d.putAll(r11);
        com.lynx.tasm.base.a.k(r5, this.d).a("load_main_js_duration", Long.valueOf(r10 - r15.d("applet_load_main_js_start")));
        i r17 = com.lynx.tasm.base.a.a(r5, r16);
        LoadingStage[] r18 = LoadingStage.f2393a;
        Intrinsics.checkNotNullParameter("runMainJS", "<set-?>");
        r17.f845b = "runMainJS";
    }

    public final void g(long r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter(r10, "traceId");
        String r11 = sj.g.j("onLoadAppletStart: ", r5, r10, ", ");
        String r12 = this.f;
        Intrinsics.checkNotNullParameter(r12, "tag");
        t0.d r13 = com.bytedance.ai.utils.c.f2846a;
        if (r13 == null) goto L5;
        r13.d(r12, r11);
    L5:
        com.lynx.tasm.base.a.l(r10, this.f849c).a("applet_load_applet_info_start", Long.valueOf(r5));
        i r14 = com.lynx.tasm.base.a.a(r10, this.e);
        LoadingStage[] r15 = LoadingStage.f2393a;
        Intrinsics.checkNotNullParameter("loadApplet", "<set-?>");
        r14.f845b = "loadApplet";
    }

    public final void h(String r5, long r10, Map r11) {
        Intrinsics.checkNotNullParameter(r5, "traceId");
        Intrinsics.checkNotNullParameter(r11, "eventInfo");
        Intrinsics.checkNotNullParameter(r5, "traceId");
        Intrinsics.checkNotNullParameter(r11, "eventInfo");
        String r12 = sj.g.j("onRenderTemplateStart: ", r10, r5, ", ");
        String r13 = this.f;
        Intrinsics.checkNotNullParameter(r13, "tag");
        t0.d r14 = com.bytedance.ai.utils.c.f2846a;
        if (r14 == null) goto L5;
        r14.d(r13, r12);
    L5:
        o r15 = com.lynx.tasm.base.a.l(r5, this.f849c);
        r15.a("render_template_start", Long.valueOf(r10));
        com.lynx.tasm.base.a.k(r5, this.d).a("view_create_to_render", Long.valueOf(r10 - r15.d("prepare_component_end")));
        i r16 = com.lynx.tasm.base.a.a(r5, this.e);
        LoadingStage[] r17 = LoadingStage.f2393a;
        Intrinsics.checkNotNullParameter("renderTemplate", "<set-?>");
        r16.f845b = "renderTemplate";
        r16.d.putAll(r11);
    }

    public final void i(long r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter(r10, "traceId");
        String r11 = sj.g.j("onLoadMainJSStart: ", r5, r10, ", ");
        String r12 = this.f;
        Intrinsics.checkNotNullParameter(r12, "tag");
        t0.d r13 = com.bytedance.ai.utils.c.f2846a;
        if (r13 == null) goto L5;
        r13.d(r12, r11);
    L5:
        com.lynx.tasm.base.a.l(r10, this.f849c).a("applet_load_main_js_start", Long.valueOf(r5));
        i r14 = com.lynx.tasm.base.a.a(r10, this.e);
        LoadingStage[] r15 = LoadingStage.f2393a;
        Intrinsics.checkNotNullParameter("loadMainJS", "<set-?>");
        r14.f845b = "loadMainJS";
    }

    public final void j(String r5, long r10, Map r11) {
        Intrinsics.checkNotNullParameter(r5, "traceId");
        Intrinsics.checkNotNullParameter(r11, "eventInfo");
        Intrinsics.checkNotNullParameter(r5, "traceId");
        Intrinsics.checkNotNullParameter(r11, "eventInfo");
        String r12 = sj.g.j("onRunAppletRuntimeEnd: ", r10, r5, ", ");
        String r13 = this.f;
        Intrinsics.checkNotNullParameter(r13, "tag");
        t0.d r14 = com.bytedance.ai.utils.c.f2846a;
        if (r14 == null) goto L5;
        r14.d(r13, r12);
    L5:
        o r15 = com.lynx.tasm.base.a.l(r5, this.f849c);
        r15.a("applet_run_applet_end", Long.valueOf(r10));
        com.lynx.tasm.base.a.a(r5, this.e).d.putAll(r11);
        com.lynx.tasm.base.a.k(r5, this.d).a("load_applet_runtime_duration", Long.valueOf(r10 - r15.d("applet_run_applet_start")));
    }

    public final void k(long r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter(r10, "traceId");
        String r11 = sj.g.j("onPrepareComponentEnd: ", r5, r10, ", ");
        String r12 = this.f;
        Intrinsics.checkNotNullParameter(r12, "tag");
        t0.d r13 = com.bytedance.ai.utils.c.f2846a;
        if (r13 == null) goto L5;
        r13.d(r12, r11);
    L5:
        o r14 = com.lynx.tasm.base.a.l(r10, this.f849c);
        r14.a("prepare_component_end", Long.valueOf(r5));
        com.lynx.tasm.base.a.k(r10, this.d).a("prepare_component_duration", Long.valueOf(r5 - r14.d("prepare_component_start")));
    }

    public void l(long r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter(r10, "traceId");
        String r11 = sj.g.j("onPrepareComponentStart: ", r5, r10, ", ");
        String r12 = this.f;
        Intrinsics.checkNotNullParameter(r12, "tag");
        t0.d r13 = com.bytedance.ai.utils.c.f2846a;
        if (r13 == null) goto L5;
        r13.d(r12, r11);
    L5:
        com.lynx.tasm.base.a.l(r10, this.f849c).a("prepare_component_start", Long.valueOf(r5));
        i r14 = com.lynx.tasm.base.a.a(r10, this.e);
        LoadingStage[] r15 = LoadingStage.f2393a;
        Intrinsics.checkNotNullParameter("prepareComponent", "<set-?>");
        r14.f845b = "prepareComponent";
    }

    public final void m(long r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter(r10, "traceId");
        String r11 = sj.g.j("onRenderTemplateEnd: ", r5, r10, ", ");
        String r12 = this.f;
        Intrinsics.checkNotNullParameter(r12, "tag");
        t0.d r13 = com.bytedance.ai.utils.c.f2846a;
        if (r13 == null) goto L5;
        r13.d(r12, r11);
    L5:
        o r14 = com.lynx.tasm.base.a.l(r10, this.f849c);
        r14.a("render_template_end", Long.valueOf(r5));
        com.lynx.tasm.base.a.k(r10, this.d).a("render_template_main", Long.valueOf(r5 - r14.d("render_template_start")));
    }

    public void n(long r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter(r10, "traceId");
        String r11 = sj.g.j("onRunAppletRuntimeStart: ", r5, r10, ", ");
        String r12 = this.f;
        Intrinsics.checkNotNullParameter(r12, "tag");
        t0.d r13 = com.bytedance.ai.utils.c.f2846a;
        if (r13 == null) goto L5;
        r13.d(r12, r11);
    L5:
        com.lynx.tasm.base.a.l(r10, this.f849c).a("applet_run_applet_start", Long.valueOf(r5));
        i r14 = com.lynx.tasm.base.a.a(r10, this.e);
        LoadingStage[] r15 = LoadingStage.f2393a;
        Intrinsics.checkNotNullParameter("runAppletRuntime", "<set-?>");
        r14.f845b = "runAppletRuntime";
    }
}
