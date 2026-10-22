package com.bytedance.android.monitorV2.lynx.impl;

import com.bytedance.android.monitorV2.dataprocessor.TypedDataDispatcher$DataType;
import com.bytedance.android.monitorV2.event.HybridEvent$TerminateType;
import com.bytedance.android.monitorV2.hybridSetting.Switches;
import com.bytedance.android.monitorV2.hybridSetting.entity.BidInfo$BidConfig;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.google.common.reflect.w;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.base.TraceEvent;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import k5.g;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mn.h;
import org.json.JSONObject;
import x4.i;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends um.a implements j5.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f3692c;
    public final long d;
    public final Lazy e;
    public String f;
    public String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public JSONObject f3693h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final g5.c f3694i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final g5.e f3695j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f3696k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final w f3697l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public a f3698m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final x4.d f3699n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final i f3700o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final i4.a f3701p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f3702q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f3703r;
    public boolean s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f3704t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f3705u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f3706v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f3707w;

    public e(d r5) {
        Intrinsics.checkNotNullParameter(r5, "lynxViewDataManager");
        super((LynxView) ((WeakReference) r5.f22372b).get());
        this.f3692c = r5;
        this.d = System.currentTimeMillis();
        this.e = LazyKt.lazy(LynxViewNavigationDataManager$blankConfig$2.f3648a);
        this.f = "";
        this.g = "";
        this.f3693h = new JSONObject();
        g5.c r10 = new g5.c();
        r10.g = -1;
        this.f3694i = r10;
        this.f3695j = new g5.e();
        LynxView r11 = F();
        if (r11 == null) goto L5;
        String r12 = r11.getTemplateUrl();
    L6:
        this.f3696k = r12;
        this.f3697l = new w(this);
        new BidInfo$BidConfig("__hybrid_default");
        new LynxViewNavigationDataManager$dataHandlerPostProcessor$1(this);
        this.f3698m = new a(this.g);
        this.f3699n = new x4.d((g5.b) r5.f3691j.getValue());
        this.f3700o = new i();
        this.f3701p = new i4.a(CollectionsKt.listOf(new String[]{"res_loader_perf_template", "res_loader_perf", "jsbPerfV2"}), 20);
        this.f3702q = LazyKt.lazy(new LynxViewNavigationDataManager$performanceEvent$2(this));
        return;
    L5:
        r12 = null;
        goto L6
    }

    public final LynxView F() {
        LynxView r5 = this.f3692c.F();
        if (r5 != null) goto L6;
        d5.b.d("HybridMonitorSDK_V2", "Host view seem to be destroyed, investigation terminated.", new Throwable());
        return null;
    L6:
        return r5;
    }

    public final void G(com.bytedance.android.monitorV2.event.d r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        w r10 = this.f3697l;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r5, "event");
        TypedDataDispatcher$DataType r11 = (TypedDataDispatcher$DataType) r10.d;
        ((com.bytedance.android.monitorV2.dataprocessor.b) r10.f9376b).c(r11, r5, true);
        this.f3699n.u(r5);
        if ((r5 instanceof com.bytedance.android.monitorV2.event.a) == false) goto L6;
        this.f3701p.o((com.bytedance.android.monitorV2.event.a) r5);
        return;
    }

    public final void H() {
        t4.a r5 = ((com.bytedance.android.monitorV2.event.a) this.f3702q.getValue()).f3550m;
        Map r10 = null;
        if ((r5 instanceof i) == false) goto L5;
        i r11 = (i) r5;
    L6:
        if (r11 == null) goto L8;
        t4.a r12 = r11.f22978b;
    L10:
        if ((r12 instanceof g5.e) == false) goto L12;
        g5.e r13 = (g5.e) r12;
    L13:
        if (r13 == null) goto L15;
        Map r14 = r13.e;
    L16:
        if (r14 == null) goto L18;
        Object r15 = r14.get(LynxMonitorService.KEY_SETUP_TIMING);
    L20:
        if ((r15 instanceof Map) == false) goto L22;
        Map r16 = (Map) r15;
    L24:
        if (r16 == null) goto L30;
        Object r17 = r16.get("draw_end");
        if (r17 == null) goto L30;
        String r18 = r17.toString();
        if (r18 == null) goto L30;
        long r19 = Long.parseLong(r18);
    L31:
        if (r14 == null) goto L33;
        Object r20 = r14.get(LynxMonitorService.KEY_UPDATE_TIMING);
    L35:
        if ((r20 instanceof Map) == false) goto L37;
        Map r21 = (Map) r20;
    L38:
        if (r21 == null) goto L40;
        Object r22 = r21.get("__lynx_timing_actual_fmp");
    L42:
        if ((r22 instanceof Map) == false) goto L44;
        r10 = (Map) r22;
    L44:
        if (r10 == null) goto L50;
        Object r23 = r10.get("draw_end");
        if (r23 == null) goto L50;
        String r24 = r23.toString();
        if (r24 == null) goto L50;
        long r25 = Long.parseLong(r24);
    L51:
        long r26 = Math.max(r19, r25);
        if (r26 <= 0) goto L55;
        this.f3701p.q("lynx", r26, this.f3700o.f22979c);
        return;
    L55:
        return;
    L50:
        r25 = 0;
        goto L51
    L40:
        r22 = null;
        goto L42
    L37:
        r21 = null;
        goto L38
    L33:
        r20 = null;
    L30:
        r19 = 0;
        goto L31
    L22:
        r16 = null;
        goto L24
    L18:
        r15 = null;
        goto L20
    L15:
        r14 = null;
        goto L16
    L12:
        r13 = null;
        goto L13
    L8:
        r12 = null;
        goto L10
    L5:
        r11 = null;
        goto L6
    }

    public final void I() {
        d5.b.f("LynxViewMonitor", "onDestroy: " + this.f3696k + ", view: " + F());
        long r5 = System.currentTimeMillis();
        g5.c r10 = this.f3694i;
        r10.d = r5;
        boolean r11 = this.f3703r;
        d r12 = this.f3692c;
        if (r11 == true) goto L13;
        boolean r13 = this.s;
        g5.e r14 = this.f3695j;
        if (r13 == false) goto L7;
    L12:
        r14.f17058b = r10;
        L();
        J();
        ((com.bytedance.android.monitorV2.dataprocessor.b) this.f3697l.f9376b).a();
        goto L13
    L7:
        if (r12.g == true) goto L9;
    L11:
        r14.getClass();
        d5.b.f("LynxState", "set lynx_state = 3");
        r14.f17059c = 3;
        goto L12
    L9:
        if (r12.f3689h == false) goto L11;
        r14.getClass();
        d5.b.f("LynxState", "set lynx_state = 2");
        r14.f17059c = 2;
    L13:
        Map r15 = com.bytedance.android.monitorV2.i.f3604a;
        com.bytedance.android.monitorV2.i.a(((g5.b) r12.f3691j.getValue()).f22974b, "blank_check", null, null, 12);
        Intrinsics.checkNotNullParameter("monitor", "detectFrom");
        if (this.f3704t == false) goto L17;
        F();
        return;
    L17:
        this.f3704t = true;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L20
        new com.bytedance.android.monitorV2.lynx.impl.blank.d(this).a();     // Catch: Throwable -> L20
        Object r17 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L20
    L22:
        Throwable r18 = Result.m127exceptionOrNullimpl(r17);
        if (r18 == null) goto L28;
        h.g("default_handle", r18);
        return;
    L28:
        return;
    L20:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r17 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L22
    }

    public final void J() {
        d5.b.f("LynxViewMonitor", "reportPerf: " + this.f3696k + ", view: " + F());
        boolean r5 = Switches.f3589h.f3600a;
        Lazy r10 = this.f3702q;
        if (r5 == true) goto L7;
        ((com.bytedance.android.monitorV2.event.a) r10.getValue()).b(HybridEvent$TerminateType.f3540a);
        return;
    L7:
        if (this.f3703r == false) goto L9;
        ((com.bytedance.android.monitorV2.event.a) r10.getValue()).b(HybridEvent$TerminateType.d);
    L10:
        LynxView r11 = F();
        if (r11 == null) goto L18;
        Iterator r12 = j5.b.d(r11).s().entrySet().iterator();
    L14:
        if (r12.hasNext() == false) goto L24;
        Map.Entry r13 = (Map.Entry) r12.next();
        if ((r13.getValue() instanceof Long) == false) goto L14;
        String r14 = (String) r13.getKey();
        Object r15 = r13.getValue();
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type kotlin.Long");
        long r16 = 1000;
        TraceEvent.d(TraceEvent.f10113a[(int) 0], ((((Long) r15).longValue() * r16) * r16) - com.bytedance.android.monitorV2.lynx.d.f3639b, r14, TraceEvent.j());
        goto L14
    L24:
        return;
    L18:
        return;
    L9:
        this.f3703r = true;
        H();
        com.bytedance.android.monitorV2.event.a r17 = (com.bytedance.android.monitorV2.event.a) r10.getValue();
        w r18 = this.f3697l;
        r18.getClass();
        Intrinsics.checkNotNullParameter(r17, "event");
        ((com.bytedance.android.monitorV2.dataprocessor.b) r18.f9376b).c((TypedDataDispatcher$DataType) r18.d, r17, true);
        goto L10
    }

    public final void K() {
        if (this.f3705u == true) goto L5;
    L7:
        boolean r5 = false;
    L9:
        if (((g) c.f3681b.getValue()).a() == null) goto L15;
        if (r5 == true) goto L12;
        return;
    L12:
        if (this.f3707w == false) goto L17;
        ((com.bytedance.android.monitorV2.dataprocessor.b) this.f3697l.f9376b).a();
        return;
    L17:
        return;
    L15:
        return;
    L5:
        if (this.f3706v == false) goto L7;
        r5 = true;
        goto L9
    }

    public final void L() {
        g5.c r5 = this.f3694i;
        g5.e r10 = this.f3695j;
        r10.f17058b = r5;
        i r11 = this.f3700o;
        r11.f22978b = r10;
        Lazy r12 = this.f3702q;
        ((com.bytedance.android.monitorV2.event.a) r12.getValue()).f3550m = r11;
        com.bytedance.android.monitorV2.event.a r13 = (com.bytedance.android.monitorV2.event.a) r12.getValue();
        g5.b r14 = (g5.b) this.f3692c.f3691j.getValue();
        r13.getClass();
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        r13.f = r14;
        com.bytedance.android.monitorV2.event.a r15 = (com.bytedance.android.monitorV2.event.a) r12.getValue();
        r15.f3551n = new x4.a(1, this.f3698m.f3653b);
        com.bytedance.android.monitorV2.event.a r16 = (com.bytedance.android.monitorV2.event.a) r12.getValue();
        r16.f3560h = new x4.a(0, this.f3698m.f3652a);
        ((com.bytedance.android.monitorV2.event.a) r12.getValue()).g();
    }

    @Override // j5.a
    public final void a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "monitorId");
        this.g = r5;
        this.f3698m = new a(r5);
    }
}
