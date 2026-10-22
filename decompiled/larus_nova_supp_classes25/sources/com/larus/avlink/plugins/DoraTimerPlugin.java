package com.larus.avlink.plugins;

import com.larus.audio.call.mgr.MajorState;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.avlink.model.TimerScene;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.LightEffectBrightness;
import com.larus.dora.api.LightEffectStatus;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.serviceimpl.SessionService;
import com.larus.settings.value.e10;
import com.larus.settings.value.fv;
import com.larus.settings.value.n8;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class DoraTimerPlugin extends BaseDoraTimerPlugin {
    public final Lazy k;
    public final Lazy l;
    public volatile boolean m;
    public com.larus.audio.call.o n;
    public volatile int o;
    public final DoraTimerPlugin$lapseVoiceCallback$1 p;

    public static final class a {
    }

    public static final class b implements com.larus.audio.call.mgr.f.a {
        public final /* synthetic */ DoraTimerPlugin a;

        public b(DoraTimerPlugin r1) {
            this.a = r1;
        }

        public final void Q(MajorState r2, MajorState r3) {
            Intrinsics.checkNotNullParameter(r2, "prev");
            Intrinsics.checkNotNullParameter(r3, "current");
            if ((r3 instanceof MajorState.d) == false) goto L5;
        L6:
            DoraTimerPlugin.u3(this.a, r3.toString());
            return;
        L5:
            if ((r3 instanceof MajorState.h) == true) goto L6;
        }
    }

    static {
    }

    public static long w3() {
        e10 r0 = e10.a;
        int r1 = com.larus.utils.l0.a;
        return ((long) ((Number) com.larus.utils.l0.a(0, new n8())).intValue()) * 1000;
    }

    public final com.larus.audio.call.mgr.f.a P2() {
        return new b(this);
    }

    @Override // com.larus.avlink.plugins.BaseDoraTimerPlugin
    public final void b3() {
        v3("release");
        super.b3();
    }

    @Override // com.larus.avlink.plugins.BaseDoraTimerPlugin
    public final long j3() {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L9;
        DeviceService r1 = r0.device();
        if (r1 == null) goto L9;
        boolean r2 = true;
        if (r1.M() != true) goto L9;
    L10:
        if (r2 == false) goto L14;
        return 8000;
    L14:
        return super.j3();
    L9:
        r2 = false;
        goto L10
    }

    @Override // com.larus.avlink.plugins.BaseDoraTimerPlugin
    public final String k3() {
        return (String) this.k.getValue();
    }

    @Override // com.larus.avlink.plugins.BaseDoraTimerPlugin
    public final String m3() {
        return (String) this.l.getValue();
    }

    @Override // com.larus.avlink.plugins.BaseDoraTimerPlugin
    public final void o3() {
        Intrinsics.checkNotNullParameter("pre flash end", "reason");
        r4 r0 = (r4) getContext().c(Reflection.getOrCreateKotlinClass(r4.class), null);
        if (r0 == null) goto L5;
        r0.N2(LightEffectStatus.RAPID_FLASHING, LightEffectBrightness.LOW, "pre flash end");
    L5:
        IDoraService r1 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r1 == null) goto L11;
        SessionService r2 = r1.d();
        if (r2 == null) goto L12;
        r2.y(7, DoraCallStateCode.DOUBAO_RAPID_FLASHING_END, false);
        return;
    L12:
        return;
    }

    public final void e3() {
        super.e3();
        if (v88.a.f(Integer.valueOf(((n4) getContext()).q())) == false) goto L5;
        return;
    L5:
        if (((n4) getContext()).q() == 11) goto L9;
        TimerScene r0 = TimerScene.OnStart;
        q3(l3(r0), r0);
        return;
    }

    @Override // com.larus.avlink.plugins.BaseDoraTimerPlugin
    public final void g3() {
        v3("stop");
        super.g3();
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.larus.avlink.plugins.DoraTimerPlugin$lapseVoiceCallback$1] */
    public DoraTimerPlugin(final n4 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.k = LazyKt.lazy(new v3());
        this.l = LazyKt.lazy(new w3());
        this.o = 3;
        this.p = new DoraTimerPlugin$lapseVoiceCallback$1(r2, this);
    }

    @Override // com.larus.avlink.plugins.BaseDoraTimerPlugin, com.larus.avlink.plugins.o4
    public final void Q0(int r2) {
        v3("conversation end");
        super.Q0(r2);
    }

    @Override // com.larus.avlink.plugins.BaseDoraTimerPlugin, com.larus.avlink.plugins.o3
    public final void g1(final String r3) {
        Intrinsics.checkNotNullParameter(r3, "source");
        e10 r0 = e10.a;
        int r1 = com.larus.utils.l0.a;
        if (((Boolean) com.larus.utils.l0.a(Boolean.TRUE, new fv())).booleanValue() == false) goto L5;
        com.larus.utils.t0.e(new t3(this, r3));
        return;
    L5:
        super.g1(r3);
    }

    @Override // com.larus.avlink.plugins.BaseDoraTimerPlugin
    public final void p3(TimerScene r7) {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L9;
        DeviceService r1 = r0.device();
        if (r1 == null) goto L9;
        if (r1.M() != true) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L32;
        long r3 = w3();
        if (r3 > 0) goto L16;
        super.p3(r7);
        return;
    L16:
        if (this.m == false) goto L18;
        com.larus.avlink.n1.d("DoraTimerPlugin", "onTimeoutHangup ignored, already in lapse standby");
        return;
    L18:
        this.m = true;
        this.o = 3;
        StringBuilder r4 = new StringBuilder("enterLapseStandby scene: ");
        if (r7 == null) goto L21;
        String r5 = r7.name();
    L22:
        r4.append(r5);
        r4.append(", code: 3, maxDurationMs: ");
        r4.append(r3);
        com.larus.avlink.n1.d("DoraTimerPlugin", r4.toString());
        s4 r6 = (s4) getContext().c(Reflection.getOrCreateKotlinClass(s4.class), null);
        if (r6 == null) goto L25;
        r6.M1();
    L25:
        Map<Function1<Boolean, Unit>, k4> r8 = x2.a;
        x2.d(this.p);
        com.larus.audio.call.o r9 = this.n;
        if (r9 == null) goto L28;
        r9.a();
    L28:
        com.larus.audio.call.o r10 = new com.larus.audio.call.o(r3, new u3(this));
        this.n = r10;
        r10.d();
        if (s3(r7) == false) goto L35;
        r3(r3);
        return;
    L35:
        return;
    L21:
        r5 = null;
        goto L22
    L32:
        super.p3(r7);
        return;
    L9:
        r2 = false;
        goto L10
    }

    @Override // com.larus.avlink.plugins.BaseDoraTimerPlugin
    public final boolean s3(TimerScene r4) {
        r4 r0 = (r4) getContext().c(Reflection.getOrCreateKotlinClass(r4.class), null);
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L10;
        return false;
    L10:
        if (r4 == TimerScene.QueryEnd) goto L14;
        return true;
    L14:
        return false;
    L5:
        if (r0.k0() != true) goto L7;
        r1 = true;
        goto L8
    }

    public final void v3(String r3) {
        if (this.m == false) goto L5;
    L7:
        com.larus.avlink.n1.d("DoraTimerPlugin", "cleanupLapse source: " + r3);
        this.m = false;
        com.larus.audio.call.o r4 = this.n;
        if (r4 == null) goto L10;
        r4.a();
    L10:
        this.n = null;
        com.larus.audio.call.o r0 = this.i;
        if (r0 == null) goto L13;
        r0.a();
    L13:
        this.i = null;
        Map<Function1<Boolean, Unit>, k4> r5 = x2.a;
        x2.k(this.p);
        return;
    L5:
        if (this.n != null) goto L7;
    }

    public static void t3(DoraTimerPlugin r0, String r1) {
        super.g1(r1);
    }

    public static final void u3(DoraTimerPlugin r2, String r3) {
        if (r2.m == false) goto L10;
        com.larus.avlink.n1.d("DoraTimerPlugin", "reactivateFromLapse source: " + r3);
        r2.v3(r3);
        s4 r4 = (s4) r2.getContext().c(Reflection.getOrCreateKotlinClass(s4.class), null);
        if (r4 == null) goto L9;
        r4.z1();
        return;
    L9:
        return;
    }

    @Override // com.larus.avlink.plugins.BaseDoraTimerPlugin
    public final void n3(long r5, TimerScene r7) {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L9;
        DeviceService r1 = r0.device();
        if (r1 == null) goto L9;
        boolean r2 = true;
        if (r1.M() != true) goto L9;
    L10:
        if (r2 == true) goto L12;
        super.n3(r5, r7);
        return;
    L12:
        if (s3(r7) == true) goto L15;
        return;
    L15:
        if (w3() <= 0) goto L17;
        return;
    L17:
        r3(r5);
        return;
    L9:
        r2 = false;
        goto L10
    }
}
