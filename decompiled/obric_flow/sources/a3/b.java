package a3;

import b3.n;
import b3.o;
import b3.p;
import com.bytedance.ai.monitor.bridge.TraceType;
import com.bytedance.ai.monitor.timeline.LoadingStage;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f65a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f66b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f67c;

    public /* synthetic */ b(long r5, String r10, int r11) {
        this.f65a = r11;
        this.f67c = r5;
        this.f66b = r10;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        long r10 = this.f67c;
        String r12 = this.f66b;
        switch(this.f65a) {
            case 0: goto L83;
            case 1: goto L81;
            case 2: goto L79;
            case 3: goto L77;
            case 4: goto L75;
            case 5: goto L73;
            case 6: goto L67;
            case 7: goto L61;
            case 8: goto L55;
            case 9: goto L49;
            case 10: goto L47;
            case 11: goto L45;
            case 12: goto L43;
            case 13: goto L41;
            case 14: goto L39;
            case 15: goto L37;
            case 16: goto L35;
            case 17: goto L33;
            case 18: goto L31;
            case 19: goto L29;
            case 20: goto L27;
            case 21: goto L25;
            case 22: goto L20;
            case 23: goto L18;
            case 24: goto L16;
            case 25: goto L8;
            case 26: goto L6;
            default: goto L4;
        };
    L4:
        b3.h.f842b.l(r10, r12);
        return Unit.INSTANCE;
    L6:
        b3.h.f841a.l(r10, r12);
        return Unit.INSTANCE;
    L8:
        String r5 = com.lynx.tasm.behavior.utils.d.c("onLoadTemplateStart: ", r12, "AppletEventMonitorManager");
        t0.d r11 = com.bytedance.ai.utils.c.f2846a;
        if (r11 == null) goto L11;
        r11.d("AppletEventMonitorManager", r5);
    L11:
        p r13 = b3.h.f841a;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r12, "traceId");
        String r14 = sj.g.j("onLoadTemplateStart: ", r10, r12, ", ");
        String r15 = r13.f853h;
        Intrinsics.checkNotNullParameter(r15, "tag");
        t0.d r16 = com.bytedance.ai.utils.c.f2846a;
        if (r16 == null) goto L14;
        r16.d(r15, r14);
    L14:
        com.lynx.tasm.base.a.l(r12, r13.f849c).a("applet_load_widget_template_start", Long.valueOf(r10));
        b3.i r17 = com.lynx.tasm.base.a.a(r12, r13.e);
        LoadingStage[] r18 = LoadingStage.f2393a;
        Intrinsics.checkNotNullParameter("loadWidgetTemplate", "<set-?>");
        r17.f845b = "loadWidgetTemplate";
        return Unit.INSTANCE;
    L16:
        b3.h.f842b.i(r10, r12);
        return Unit.INSTANCE;
    L18:
        b3.h.f841a.i(r10, r12);
        return Unit.INSTANCE;
    L20:
        n r19 = b3.h.f842b;
        r19.getClass();
        Intrinsics.checkNotNullParameter(r12, "traceId");
        String r20 = sj.g.j("onCreateWebPageStart: ", r10, r12, ", ");
        String r21 = r19.g;
        Intrinsics.checkNotNullParameter(r21, "tag");
        t0.d r22 = com.bytedance.ai.utils.c.f2846a;
        if (r22 == null) goto L23;
        r22.d(r21, r20);
    L23:
        o r23 = com.lynx.tasm.base.a.l(r12, r19.f849c);
        r23.a("create_page", Long.valueOf(r10));
        com.lynx.tasm.base.a.k(r12, r19.d).a("runtime_to_page", Long.valueOf(r10 - r23.d("applet_run_applet_end")));
        b3.i r110 = com.lynx.tasm.base.a.a(r12, r19.e);
        LoadingStage[] r24 = LoadingStage.f2393a;
        Intrinsics.checkNotNullParameter("createContainer", "<set-?>");
        r110.f845b = "createContainer";
        return Unit.INSTANCE;
    L25:
        b3.h.f842b.e(r10, r12);
        return Unit.INSTANCE;
    L27:
        b3.h.f841a.e(r10, r12);
        return Unit.INSTANCE;
    L29:
        b3.h.f842b.n(r10, r12);
        return Unit.INSTANCE;
    L31:
        b3.h.f842b.b(r12, r10);
        return Unit.INSTANCE;
    L33:
        b3.h.f841a.b(r12, r10);
        return Unit.INSTANCE;
    L35:
        b3.h.f842b.m(r10, r12);
        return Unit.INSTANCE;
    L37:
        b3.h.f841a.m(r10, r12);
        return Unit.INSTANCE;
    L39:
        b3.h.f842b.g(r10, r12);
        return Unit.INSTANCE;
    L41:
        b3.h.f841a.g(r10, r12);
        return Unit.INSTANCE;
    L43:
        b3.h.f841a.n(r10, r12);
        return Unit.INSTANCE;
    L45:
        b3.h.f842b.k(r10, r12);
        return Unit.INSTANCE;
    L47:
        b3.h.f841a.k(r10, r12);
        return Unit.INSTANCE;
    L49:
        j r111 = cl.a.b(r12, i.f84b);
        i.d.getClass();
        Intrinsics.checkNotNullParameter(r111, "traceEvent");
        o r25 = r111.f86a;
        if (r25.c("fe_receive_callback") == true) goto L54;
        r25.a("fe_receive_callback", Long.valueOf(r10));
        r111.f87b.a("callback_native_to_fe_duration", Long.valueOf(r10 - r25.d("native_send_callback")));
        r111.f88c++;
    L54:
        return Unit.INSTANCE;
    L55:
        j r112 = cl.a.b(r12, i.f84b);
        i.g.getClass();
        Intrinsics.checkNotNullParameter(r112, "traceEvent");
        o r26 = r112.f86a;
        if (r26.c("fe_receive_event") == true) goto L60;
        r26.a("fe_receive_event", Long.valueOf(r10));
        r112.f87b.a("event_native_to_fe_duration", Long.valueOf(r10 - r26.d("native_send_event")));
        r112.f88c++;
    L60:
        return Unit.INSTANCE;
    L61:
        j r113 = cl.a.b(r12, i.f84b);
        i.e.getClass();
        Intrinsics.checkNotNullParameter(r113, "traceEvent");
        o r27 = r113.f86a;
        if (r27.c("fe_send_callback") == true) goto L66;
        r27.a("fe_send_callback", Long.valueOf(r10));
        r113.f87b.a("fe_handle_call_duration", Long.valueOf(r10 - r27.d("fe_receive_call")));
        r113.f88c++;
    L66:
        return Unit.INSTANCE;
    L67:
        j r114 = cl.a.b(r12, i.f84b);
        i.d.getClass();
        Intrinsics.checkNotNullParameter(r114, "traceEvent");
        o r28 = r114.f86a;
        if (r28.c("fe_send_call") == true) goto L72;
        r28.a("fe_send_call", Long.valueOf(r10));
        r114.f88c++;
    L72:
        return Unit.INSTANCE;
    L73:
        j r115 = cl.a.b(r12, i.f84b);
        i.f.getClass();
        Intrinsics.checkNotNullParameter(r115, "traceEvent");
        Long r29 = Long.valueOf(r10);
        o r30 = r115.f86a;
        r30.a("start_handle_call", r29);
        r115.f87b.a("before_handle_call_duration", Long.valueOf(r10 - r30.d("before_handle_call")));
        return Unit.INSTANCE;
    L75:
        j r116 = cl.a.b(r12, i.f84b);
        i.f.getClass();
        Intrinsics.checkNotNullParameter(r116, "traceEvent");
        Long r31 = Long.valueOf(r10);
        o r32 = r116.f86a;
        r32.a("before_handle_call", r31);
        r116.f87b.a("preprocess_call_duration", Long.valueOf(r10 - r32.d("native_receive_call")));
        TraceType r33 = TraceType.f2391b;
        Intrinsics.checkNotNullParameter(r33, "<set-?>");
        r116.f = r33;
        return Unit.INSTANCE;
    L77:
        j r117 = cl.a.b(r12, i.f84b);
        i.e.getClass();
        Intrinsics.checkNotNullParameter(r117, "traceEvent");
        r117.f86a.a("native_receive_callback", Long.valueOf(r10));
        return Unit.INSTANCE;
    L79:
        j r118 = cl.a.b(r12, i.f84b);
        i.e.getClass();
        Intrinsics.checkNotNullParameter(r118, "traceEvent");
        Long r34 = Long.valueOf(r10);
        o r35 = r118.f86a;
        r35.a("before_forward_call", r34);
        r118.f87b.a("preprocess_call_duration", Long.valueOf(r10 - r35.d("native_receive_call")));
        TraceType r36 = TraceType.f2390a;
        Intrinsics.checkNotNullParameter(r36, "<set-?>");
        r118.f = r36;
        return Unit.INSTANCE;
    L81:
        j r119 = cl.a.b(r12, i.f84b);
        i.d.getClass();
        Intrinsics.checkNotNullParameter(r119, "traceEvent");
        Long r37 = Long.valueOf(r10);
        o r38 = r119.f86a;
        r38.a("native_send_callback", r37);
        r119.f87b.a("process_callback_duration", Long.valueOf(r10 - r38.d("native_process_callback")));
        return Unit.INSTANCE;
    L83:
        j r120 = cl.a.b(r12, i.f84b);
        i.e.getClass();
        Intrinsics.checkNotNullParameter(r120, "traceEvent");
        o r39 = r120.f86a;
        if (r39.c("fe_receive_call") == true) goto L88;
        r39.a("fe_receive_call", Long.valueOf(r10));
        r120.f87b.a("call_native_to_fe_duration", Long.valueOf(r10 - r39.d("native_send_call")));
        r120.f88c++;
    L88:
        return Unit.INSTANCE;
    }

    public /* synthetic */ b(String r5, long r10, int r11) {
        this.f65a = r11;
        this.f66b = r5;
        this.f67c = r10;
    }
}
