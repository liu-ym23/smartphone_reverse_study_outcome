package com.larus.voicecall.impl.autostop;

import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.aec.w;
import com.larus.audio.call.record.CaptureBackTraceReadScene;
import com.larus.im.service.audio.z0;
import com.obric.assistant.spi.audio.ObricAsrDelegate;
import com.obric.assistant.spi.audio.ObricBackTraceLogDelegate;
import com.obric.assistant.spi.wakeup.IWakeupLatencyTrackService;
import com.obric.assistant.spi.wakeup.ObricWakeupLatencyTrackService;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import pf9.a0;
import pf9.c0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class UplinkAudioPlugin extends com.larus.audio.call.plugins.u<com.larus.audio.call.arch.c> {
    public final Function1<r58.d, Unit> I;
    public final String J;
    public final boolean K;
    public final Lazy L;
    public final hga.b M;

    public static final class a extends z0 {
        public final String a;
        public final /* synthetic */ UplinkAudioPlugin b;

        public final String g() {
            return this.a;
        }

        public a(UplinkAudioPlugin r1) {
            this.b = r1;
            this.a = r1.J;
        }

        public final void n(z0.a r3) {
            Intrinsics.checkNotNullParameter(r3, "event");
            if ((r3 instanceof c0) == false) goto L6;
            c0 r4 = (c0) r3;
            this.b.U3(r4);
            this.b.F3(r4);
            return;
        L6:
            if ((r3 instanceof a0) == false) goto L10;
            a0 r5 = (a0) r3;
            this.b.E3(r5);
            this.b.getClass();
            Intrinsics.checkNotNullParameter(r5, "event");
            return;
        }
    }

    public final boolean v3() {
        return false;
    }

    public final void M3() {
        if (this.K == false) goto L6;
        this.M.d();
        return;
    }

    public final void N3() {
        if (this.K == false) goto L6;
        this.M.f("realtime_call");
        return;
    }

    public final z0 S2() {
        return new a(this);
    }

    public final void f4() {
        if (this.K == true) goto L5;
        return;
    L5:
        if (getContext().params().b == false) goto L7;
    L15:
        String r0 = "continuous_talk";
    L16:
        if (r0 == null) goto L18;
        t3().a(r0);
        t3().f(new UplinkAudioPlugin$setRecordStartTrace$1$1(ObricBackTraceLogDelegate.b));
    L18:
        t3().g(new v(this));
        return;
    L7:
        if (getContext().params().a == true) goto L15;
        if (getContext().params().p.q == true) goto L15;
        if (getContext().params().O == false) goto L14;
        r0 = "click_talk";
        goto L16
    L14:
        r0 = null;
        goto L16
    }

    public final v68.a g4() {
        if (this.K == false) goto L8;
        com.larus.audio.call.record.k r0 = h4();
        if (r0 == null) goto L10;
        return r0;
    L10:
        return n3();
    L8:
        return n3();
    }

    public final com.larus.audio.call.record.k h4() {
        int r0 = com.larus.audio.call.record.k.j;
        CaptureBackTraceReadScene r1 = CaptureBackTraceReadScene.REALTIME_CALL;
        Long r2 = D3();
        if (r2 == null) goto L5;
        long r4 = r2.longValue();
    L6:
        Long r3 = y3();
        if (r3 == null) goto L9;
        long r6 = r3.longValue();
    L11:
        if (r4 <= 0) goto L13;
        long r5 = r4 - r6;
    L15:
        return com.larus.audio.call.record.k.a.a(r1, r5, "realtime_call", getContext().params().c0);
    L13:
        r5 = System.currentTimeMillis();
        goto L15
    L9:
        r6 = 0;
        goto L11
    L5:
        r4 = 0;
        goto L6
    }

    public final v68.a n3() {
        if (this.K == false) goto L8;
        com.larus.audio.call.record.k r0 = h4();
        if (r0 == null) goto L10;
        return r0;
    L10:
        return new com.larus.audio.call.record.g();
    L8:
        return new com.larus.audio.call.record.f(null, 0, J3(), 2);
    }

    public final boolean x3() {
        return ((Boolean) this.L.getValue()).booleanValue();
    }

    public final Long D3() {
        RealtimeCallParam.g r0 = getContext().params().N;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b;
    }

    public final void Z2() {
        u();
        w r0 = q3();
        if (r0 == null) goto L6;
        r0.h("pause", true);
        return;
    }

    public final void b3() {
        super.b3();
        this.M.h();
    }

    public final void c0() {
        com.larus.audio.call.arch.b.c(getContext()).cancel("finishSession");
        u();
        w r0 = q3();
        if (r0 == null) goto L6;
        r0.i("finishSession", false);
        return;
    }

    public final void c3() {
        l1();
        w r0 = q3();
        if (r0 == null) goto L6;
        r0.f("resume");
        return;
    }

    public final void e3() {
        super.e3();
        if (this.K == false) goto L17;
        hga.b r0 = this.M;
        Long r1 = y3();
        if (r1 != null) goto L7;
    L15:
        long r2 = 50;
    L16:
        hga.b.a.a(r0, r2, "realtime_call");
        goto L17
    L7:
        if (r1.longValue() <= 0) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == true) goto L13;
        r1 = null;
    L13:
        if (r1 == null) goto L15;
        r2 = r1.longValue();
        goto L16
    L9:
        r3 = false;
    L17:
        IWakeupLatencyTrackService.a.b(ObricWakeupLatencyTrackService.b);
    }

    public final int u3() {
        return getContext().params().h;
    }

    public final Long y3() {
        RealtimeCallParam.g r0 = getContext().params().N;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a;
    }

    public final String T2() {
        return this.J;
    }

    public final void X2() {
        l1();
    }

    public final boolean w3() {
        return this.K;
    }

    public final void L3(r58.d r6) {
        Intrinsics.checkNotNullParameter(r6, "audioData");
        if (this.K == false) goto L5;
        this.M.g();
        Function1<r58.d, Unit> r0 = this.I;
        int r2 = r6.a;
        byte[] r3 = r6.b;
        r0.invoke(new r58.d(r2, Arrays.copyOf(r3, r3.length), r6.c));
    L5:
        super.L3(r6);
    }

    public final void U3(c0 r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r2, "event");
        if (this.K == false) goto L6;
        this.M.e();
        return;
    }

    public UplinkAudioPlugin(final com.larus.audio.call.arch.c r2, d r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "onAudioDataReceived");
        super(r2);
        this.I = r3;
        this.J = "UplinkAudioPlugin";
        ObricAsrDelegate r4 = ObricAsrDelegate.b;
        if (r4.m() == true) goto L5;
    L7:
        boolean r5 = false;
    L8:
        this.K = r5;
        this.L = LazyKt.lazy(new u(r2));
        this.M = ObricBackTraceLogDelegate.b.c();
        return;
    L5:
        if (r4.a() == false) goto L7;
        r5 = true;
        goto L8
    }

    public final void Y3(r58.d r6, byte[] r7) {
        Intrinsics.checkNotNullParameter(r6, "audioData");
        if (this.K == false) goto L7;
        this.M.i(r6.a);
        s58.a.a.getClass();
        Pair r8 = s58.a.a.b(r6);
        r58.d r0 = (r58.d) r8.component1();
        r58.d r9 = (r58.d) r8.component2();
        this.M.a(r6.a);
        if (x3() == true) goto L12;
        Z3(r6, r0, r9);
        return;
    L12:
        return;
    L7:
        Function1<r58.d, Unit> r1 = this.I;
        int r2 = r6.a;
        byte[] r3 = r6.b;
        r1.invoke(new r58.d(r2, Arrays.copyOf(r3, r3.length), r6.c));
        if (x3() == false) goto L10;
        return;
    L10:
        super.Y3(r6, r7);
    }
}
