package b3;

import com.bytedance.ai.monitor.timeline.LoadingStage;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f825c;
    public final /* synthetic */ Map d;

    public /* synthetic */ a(String r5, long r10, Map r11, int r12) {
        this.f823a = r12;
        this.f824b = r5;
        this.f825c = r10;
        this.d = r11;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Map r10 = this.d;
        long r11 = this.f825c;
        String r12 = this.f824b;
        switch(this.f823a) {
            case 0: goto L42;
            case 1: goto L40;
            case 2: goto L32;
            case 3: goto L24;
            case 4: goto L22;
            case 5: goto L20;
            case 6: goto L12;
            case 7: goto L10;
            case 8: goto L8;
            case 9: goto L6;
            default: goto L4;
        };
    L4:
        h.f842b.f(r12, r11, r10);
        return Unit.INSTANCE;
    L6:
        h.f841a.f(r12, r11, r10);
        return Unit.INSTANCE;
    L8:
        h.f842b.j(r12, r11, r10);
        return Unit.INSTANCE;
    L10:
        h.f841a.j(r12, r11, r10);
        return Unit.INSTANCE;
    L12:
        String r13 = com.lynx.tasm.behavior.utils.d.c("onLoadWidgetStart: ", r12, "AppletEventMonitorManager");
        t0.d r14 = com.bytedance.ai.utils.c.f2846a;
        if (r14 == null) goto L15;
        r14.d("AppletEventMonitorManager", r13);
    L15:
        p r5 = h.f841a;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r12, "traceId");
        Intrinsics.checkNotNullParameter(r10, "eventInfo");
        String r15 = sj.g.j("onLoadWidgetStart: ", r11, r12, ", ");
        String r16 = r5.f853h;
        Intrinsics.checkNotNullParameter(r16, "tag");
        t0.d r17 = com.bytedance.ai.utils.c.f2846a;
        if (r17 == null) goto L18;
        r17.d(r16, r15);
    L18:
        o r18 = com.lynx.tasm.base.a.l(r12, r5.f849c);
        r18.a("applet_load_widget_info_start", Long.valueOf(r11));
        LinkedHashMap r19 = r5.e;
        com.lynx.tasm.base.a.a(r12, r19).d.putAll(r10);
        com.lynx.tasm.base.a.k(r12, r5.d).a("runtime_to_widget", Long.valueOf(r11 - r18.d("applet_run_applet_end")));
        i r110 = com.lynx.tasm.base.a.a(r12, r19);
        LoadingStage[] r20 = LoadingStage.f2393a;
        Intrinsics.checkNotNullParameter("loadWidget", "<set-?>");
        r110.f845b = "loadWidget";
        return Unit.INSTANCE;
    L20:
        h.f842b.h(r12, r11, r10);
        return Unit.INSTANCE;
    L22:
        h.f841a.h(r12, r11, r10);
        return Unit.INSTANCE;
    L24:
        String r111 = com.lynx.tasm.behavior.utils.d.c("onLoadWidgetEnd: ", r12, "AppletEventMonitorManager");
        t0.d r112 = com.bytedance.ai.utils.c.f2846a;
        if (r112 == null) goto L27;
        r112.d("AppletEventMonitorManager", r111);
    L27:
        p r21 = h.f841a;
        r21.getClass();
        Intrinsics.checkNotNullParameter(r12, "traceId");
        Intrinsics.checkNotNullParameter(r10, "eventInfo");
        String r113 = sj.g.j("onLoadWidgetEnd: ", r11, r12, ", ");
        String r22 = r21.f853h;
        Intrinsics.checkNotNullParameter(r22, "tag");
        t0.d r23 = com.bytedance.ai.utils.c.f2846a;
        if (r23 == null) goto L30;
        r23.d(r22, r113);
    L30:
        o r114 = com.lynx.tasm.base.a.l(r12, r21.f849c);
        r114.a("applet_load_widget_info_end", Long.valueOf(r11));
        com.lynx.tasm.base.a.a(r12, r21.e).d.putAll(r10);
        com.lynx.tasm.base.a.k(r12, r21.d).a("load_widget_duration", Long.valueOf(r11 - r114.d("applet_load_widget_info_start")));
        return Unit.INSTANCE;
    L32:
        String r24 = com.lynx.tasm.behavior.utils.d.c("onLoadTemplateEnd: ", r12, "AppletEventMonitorManager");
        t0.d r115 = com.bytedance.ai.utils.c.f2846a;
        if (r115 == null) goto L35;
        r115.d("AppletEventMonitorManager", r24);
    L35:
        p r25 = h.f841a;
        r25.getClass();
        Intrinsics.checkNotNullParameter(r12, "traceId");
        Intrinsics.checkNotNullParameter(r10, "eventInfo");
        String r116 = sj.g.j("onLoadTemplateEnd: ", r11, r12, ", ");
        String r26 = r25.f853h;
        Intrinsics.checkNotNullParameter(r26, "tag");
        t0.d r27 = com.bytedance.ai.utils.c.f2846a;
        if (r27 == null) goto L38;
        r27.d(r26, r116);
    L38:
        o r117 = com.lynx.tasm.base.a.l(r12, r25.f849c);
        r117.a("applet_load_widget_template_end", Long.valueOf(r11));
        com.lynx.tasm.base.a.a(r12, r25.e).d.putAll(r10);
        com.lynx.tasm.base.a.k(r12, r25.d).a("load_template_duration", Long.valueOf(r11 - r117.d("applet_load_widget_template_start")));
        return Unit.INSTANCE;
    L40:
        h.f842b.c(r12, r11, r10);
        return Unit.INSTANCE;
    L42:
        h.f841a.c(r12, r11, r10);
        return Unit.INSTANCE;
    }
}
