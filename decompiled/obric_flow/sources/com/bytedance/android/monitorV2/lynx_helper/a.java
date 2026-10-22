package com.bytedance.android.monitorV2.lynx_helper;

import android.os.Handler;
import com.bytedance.android.monitorV2.event.HybridEvent$TerminateType;
import com.bytedance.android.monitorV2.hybridSetting.Switches;
import com.bytedance.android.monitorV2.lynx.impl.c;
import com.bytedance.android.monitorV2.lynx.impl.d;
import com.bytedance.android.monitorV2.lynx.impl.e;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.o0;
import com.lynx.tasm.y;
import d5.b;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import oo.j;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f3712a;

    public a(WeakReference r5) {
        Intrinsics.checkNotNullParameter(r5, "lynxViewRef");
        this.f3712a = d.f3683k.a((LynxView) r5.get(), null);
    }

    @Override // com.lynx.tasm.o0
    public final void onCallJSBFinished(Map r5) {
        d r10 = this.f3712a;
        if (r10.H() == false) goto L17;
        e r11 = r10.e;
        if (r11 == null) goto L16;
        Intrinsics.checkNotNullParameter("jsbPerfV2", "eventType");
        com.bytedance.android.monitorV2.event.a r12 = new com.bytedance.android.monitorV2.event.a("jsbPerfV2");
        r12.e();
        if (r5 != null) goto L11;
        r12.b(HybridEvent$TerminateType.f3541b);
        return;
    L11:
        r12.f3550m = new com.bytedance.android.monitorV2.lynx.a("jsbPerfV2", new JSONObject(r5));
        boolean r13 = Switches.f3591j.f3600a;
        r12.d(!r13, HybridEvent$TerminateType.f3540a);
        if (r13 == false) goto L18;
        r11.G(r12);
        return;
    L18:
        return;
    L16:
        return;
    }

    @Override // com.lynx.tasm.o0
    public final void onDestroy() {
        d r5 = this.f3712a;
        if (r5.H() == false) goto L16;
        LynxView r10 = r5.F();
        if (r10 == null) goto L8;
        c.a(r10);
    L8:
        e r11 = r5.e;
        if (r11 == null) goto L11;
        r11.I();
    L11:
        LynxView r12 = r5.F();
        if (r12 == null) goto L15;
        r12.removeOnAttachStateChangeListener(r5);
        return;
    L15:
        return;
    }

    @Override // com.lynx.tasm.o0
    public final void onFirstLoadPerfReady(y r5) {
    }

    @Override // com.lynx.tasm.o0
    public final void onFirstScreen() {
        d r5 = this.f3712a;
        if (r5.H() == false) goto L10;
        e r10 = r5.e;
        if (r10 == null) goto L9;
        b.f("LynxViewMonitor", "onFirstScreen: " + r10.f3696k + ", view: " + r10.F());
        r10.f3706v = true;
        r10.f3694i.e = System.currentTimeMillis();
        r10.L();
        r10.K();
        return;
    L9:
        return;
    }

    @Override // com.lynx.tasm.o0
    public final void onJSBInvoked(Map r5) {
        d r10 = this.f3712a;
        if (r10.H() == false) goto L17;
        e r11 = r10.e;
        if (r11 == null) goto L16;
        Intrinsics.checkNotNullParameter("jsbPv", "eventType");
        com.bytedance.android.monitorV2.event.a r12 = new com.bytedance.android.monitorV2.event.a("jsbPv");
        r12.e();
        if (r5 != null) goto L11;
        r12.b(HybridEvent$TerminateType.f3541b);
        return;
    L11:
        r12.f3550m = new com.bytedance.android.monitorV2.lynx.a("jsbPv", new JSONObject(r5));
        boolean r13 = Switches.f3591j.f3600a;
        r12.d(!r13, HybridEvent$TerminateType.f3540a);
        if (r13 == false) goto L18;
        r11.G(r12);
        return;
    L18:
        return;
    L16:
        return;
    }

    @Override // com.lynx.tasm.o0
    public final void onLoadSuccess() {
        d r5 = this.f3712a;
        if (r5.H() == false) goto L16;
        Lazy r10 = c.f3680a;
        c.a(r5.F());
        g5.b r11 = (g5.b) r5.f3691j.getValue();
        LynxView r12 = r5.F();
        if (r12 == null) goto L8;
        String r13 = r12.getPageVersion();
    L9:
        if (r13 != null) goto L11;
        r13 = "";
    L11:
        r11.getClass();
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        r11.f17051k = r13;
        e r14 = r5.e;
        if (r14 == null) goto L15;
        b.f("LynxViewMonitor", "onLoadSuccess: " + r14.f3696k + ", view: " + r14.F());
        r14.f3694i.f17054b = System.currentTimeMillis();
        r14.f3699n.s(3);
        return;
    L15:
        return;
    L8:
        r13 = null;
        goto L9
    }

    @Override // com.lynx.tasm.o0
    public final void onPageStart(String r5) {
        this.f3712a.G(r5);
    }

    @Override // com.lynx.tasm.o0, com.lynx.tasm.j
    public final void onReceivedError(LynxError r10) {
        if (r10 == null) goto L32;
        g5.d r5 = new g5.d();
        r5.f17056b = "lynx_error";
        r5.f17057c = r10.a();
        r5.d = r10.e();
        d r11 = this.f3712a;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r5, "data");
        if (r11.H() == false) goto L35;
        Lazy r12 = r11.f3691j;
        String r13 = ((g5.b) r12.getValue()).f22973a;
        if (r13 != null) goto L9;
    L10:
        g5.b r14 = (g5.b) r12.getValue();
        r14.f22973a = qo.a.c(r5.d).optString("url", "");
    L11:
        LynxView r15 = r11.F();
        if (r15 == null) goto L14;
        com.bytedance.android.monitorV2.lynx.d r16 = com.bytedance.android.monitorV2.lynx.d.f3638a;
        Intrinsics.checkNotNullParameter("nativeError", "eventType");
        com.bytedance.android.monitorV2.event.a r17 = j.c("nativeError", r5, null);
        r16.getClass();
        com.bytedance.android.monitorV2.lynx.d.d(r15, r5, r17);
    L14:
        int r18 = r5.f17057c;
        if (r18 == 100) goto L19;
        if (r18 == 103) goto L19;
        return;
    L19:
        if (r11.e != null) goto L21;
        r11.e = new e(r11);
    L21:
        e r19 = r11.e;
        if (r19 == null) goto L34;
        Intrinsics.checkNotNullParameter(r5, "data");
        g5.e r20 = r19.f3695j;
        r20.getClass();
        b.f("LynxState", "set lynx_state = 1");
        r20.f17059c = 1;
        g5.c r21 = r19.f3694i;
        r20.f17058b = r21;
        if (r21 == null) goto L27;
        r21.g = 2;
    L27:
        if (r21 == null) goto L30;
        r21.d = System.currentTimeMillis();
    L30:
        ((com.bytedance.android.monitorV2.dataprocessor.b) r19.f3697l.f9376b).a();
        r19.L();
        r19.J();
        return;
    L34:
        return;
    L9:
        if (r13.length() != 0) goto L11;
    L35:
        return;
    }

    @Override // com.lynx.tasm.o0
    public final void onReportComponentInfo(Set r5) {
        this.f3712a.getClass();
    }

    @Override // com.lynx.tasm.o0
    public final void onRuntimeReady() {
        d r5 = this.f3712a;
        if (r5.H() == false) goto L10;
        e r10 = r5.e;
        if (r10 == null) goto L9;
        b.f("LynxViewMonitor", "onRuntimeReady: " + r10.f3696k + ", view: " + r10.F());
        r10.f3705u = true;
        r10.f3694i.f = System.currentTimeMillis();
        r10.L();
        r10.K();
        return;
    L9:
        return;
    }

    @Override // com.lynx.tasm.o0
    public final void onTimingSetup(final Map r5) {
        if (Switches.g.f3600a == false) goto L5;
        Handler r10 = com.bytedance.android.monitorV2.executor.b.f3573a;
        com.bytedance.android.monitorV2.executor.b.b(new MonitorLynxViewClient$onTimingSetup$1(this, r5));
    L5:
        d r11 = this.f3712a;
        if (r11.H() == false) goto L17;
        e r12 = r11.e;
        if (r12 == null) goto L16;
        b.f("LynxViewMonitor", "onTimingSetup: " + r12.f3696k + ", view: " + r12.F());
        r12.f3707w = true;
        Lazy r13 = c.f3680a;
        c.a((LynxView) ((WeakReference) r12.f22372b).get());
        g5.e r14 = r12.f3695j;
        r14.e = r5;
        g5.c r15 = r14.f17058b;
        if (r15 == null) goto L14;
        r15.g = 3;
    L14:
        b.f("LynxState", "set lynx_state = 0");
        r14.f17059c = 0;
        r12.s = true;
        r12.L();
        r12.K();
        return;
    L16:
        return;
    }

    @Override // com.lynx.tasm.o0
    public final void onTimingUpdate(Map r5, final Map r10, String r11) {
        if (Switches.g.f3600a == false) goto L5;
        Handler r12 = com.bytedance.android.monitorV2.executor.b.f3573a;
        com.bytedance.android.monitorV2.executor.b.b(new MonitorLynxViewClient$onTimingUpdate$1(this, r10));
    L5:
        d r13 = this.f3712a;
        if (r13.H() == false) goto L30;
        e r14 = r13.e;
        if (r14 == null) goto L29;
        r14.f3695j.e = r5;
        r14.L();
        if (r5 == null) goto L27;
        Object r15 = r5.get(LynxMonitorService.KEY_UPDATE_TIMING);
        if ((r15 instanceof Map) == false) goto L15;
        Map r16 = (Map) r15;
    L16:
        if (r16 == null) goto L18;
        boolean r17 = r16.containsKey("__lynx_timing_actual_fmp");
    L19:
        if (r17 == true) goto L22;
        r5 = null;
    L22:
        if (r5 == null) goto L27;
        if (Intrinsics.areEqual((String) r14.f3692c.f3688c.f, "perf_ready") == false) goto L26;
        r14.J();
        ((com.bytedance.android.monitorV2.dataprocessor.b) r14.f3697l.f9376b).a();
    L26:
        r14.f3699n.s(4);
        goto L27
    L18:
        r17 = false;
        goto L19
    L15:
        r16 = null;
    L27:
        r14.H();
        return;
    L29:
        return;
    }

    @Override // com.lynx.tasm.o0
    public final void onUpdatePerfReady(y r5) {
    }
}
