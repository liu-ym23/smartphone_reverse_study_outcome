package com.larus.avlink.plugins;

import com.larus.audio.bean.AppeaseType;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.mgr.MajorState;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.avlink.dora.DoraType;
import com.larus.call_plugins_doubao_common.CommonFeedbackVoicePluginV2;
import com.larus.call_plugins_doubao_common.manager.AudioSoundAppeaseManager;
import com.larus.im.service.audio.DataType;
import com.larus.im.service.audio.l;
import com.larus.platform.api.IVideoController;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.api.IVoiceCallService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class r0 extends CommonFeedbackVoicePluginV2<n4> {
    public final String n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;

    public static final class a {
    }

    public static final class b implements com.larus.im.service.audio.x {
        public final String a;
        public final DataType b;
        public final /* synthetic */ r0 c;

        public final String getName() {
            return this.a;
        }

        public DataType getType() {
            return this.b;
        }

        public b(r0 r1) {
            this.c = r1;
            this.a = r1.n;
            this.b = DataType.PLAYER;
        }

        public final void a(l r3) {
            Intrinsics.checkNotNullParameter(r3, "frame");
            t4 r0 = (t4) this.c.q.getValue();
            if (r0 == null) goto L7;
            boolean r4 = r0.L1(r3);
            boolean r1 = true;
            if (r4 != true) goto L7;
        L8:
            if (r1 == false) goto L10;
            return;
        L10:
            this.c.c1(false, null);
            return;
        L7:
            r1 = false;
            goto L8
        }
    }

    static {
    }

    public final void m3(pf9.e0 r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    public final void n3(pf9.f0 r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    public final void O0() {
        com.larus.avlink.n1.d(this.n, "onComfortVoiceStart duck appease volume");
        com.larus.audio.call.arch.b.e(getContext(), new p0(this));
    }

    public final com.larus.im.service.audio.x Q2() {
        return new b(this);
    }

    public final AudioSoundAppeaseManager j3() {
        return (AudioSoundAppeaseManager) this.o.getValue();
    }

    public final void o0() {
        com.larus.avlink.n1.d(this.n, "onComfortVoiceEnd restore appease volume");
        com.larus.audio.call.arch.b.e(getContext(), new l0(this));
    }

    public final void k3() {
        com.larus.voicecall.impl.tracer.o r0 = d3a.a.b(getContext());
        if (r0 == null) goto L5;
        r0.v();
    L5:
        u4 r1 = (u4) getContext().c(Reflection.getOrCreateKotlinClass(u4.class), null);
        if (r1 == null) goto L9;
        r1.v();
        return;
    }

    public final void o3() {
        super.o3();
        IRealtimeCallTracer r0 = ((n4) getContext()).k();
        RealtimeCallParam r1 = ((n4) getContext()).params();
        if (v88.a.f(Integer.valueOf(((n4) getContext()).q())) == false) goto L5;
        DoraType r2 = DoraType.DORA_RADIO;
    L6:
        r0.N(r1, r2.getValue(), AppeaseType.VOICE.getScene());
        return;
    L5:
        r2 = DoraType.DORA;
        goto L6
    }

    public final r2 t3() {
        return (r2) getContext().b(Reflection.getOrCreateKotlinClass(r2.class), null);
    }

    public final String T2() {
        return this.n;
    }

    public r0(final n4 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.n = "DoraFeedbackVoicePluginV2";
        this.o = LazyKt.lazy(new m0(this));
        this.p = LazyKt.lazy(new n0(r2));
        this.q = LazyKt.lazy(new o0(r2));
    }

    public final void m1(Function1<? super MajorState, Boolean> r3) {
        Intrinsics.checkNotNullParameter(r3, "stateChecker");
        if (t3().j0() == false) goto L5;
        return;
    L5:
        if (ia8.e.b().d() == true) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(((n4) getContext()).params().k.o, "dora_si") == true) goto L12;
        p3(2000, r3);
        return;
    }

    public final void s3(pf9.a0 r9) {
        Intrinsics.checkNotNullParameter(r9, "event");
        if (t3().j0() == false) goto L5;
    L19:
        t3().J0();
        return;
    L5:
        if (ia8.e.b().d() == false) goto L19;
        if (((com.larus.audio.call.plugins.t0) this.p.getValue()).a0() == true) goto L19;
        if (r9.c == true) goto L19;
        if (Intrinsics.areEqual(((n4) getContext()).params().k.o, "dora_si") == true) goto L19;
        if (ia8.e.b().b() == false) goto L19;
        long r0 = ia8.e.b().e().e;
        Long r10 = r9.b;
        if (r10 == null) goto L17;
        long r4 = r10.longValue();
    L18:
        long r2 = RangesKt.coerceAtLeast(r0 - r4, 0);
        com.larus.avlink.n1.d(this.n, "tryTriggerAppeaseTask, waitTime=" + r2 + ", configWaitTime=" + r0 + ", lastRespCostTime=" + r4);
        p3(r2, new com.larus.call_plugins_doubao_common.d());
        goto L19
    L17:
        r4 = 0;
        goto L18
    }

    public final void c1(boolean r7, Function1<? super Boolean, Unit> r8) {
        if (r7 == false) goto L4;
    L6:
        ((CommonFeedbackVoicePluginV2) this).i = true;
        com.larus.avlink.n1.d(this.n, "stopAudio immediately = " + r7 + "，onStopCallback = " + r8);
        if (r7 == false) goto L9;
        r3(r8);
        return;
    L9:
        FLogger.a.i(this.n, "stopVoiceAppease called");
        ((CommonFeedbackVoicePluginV2) this).i = true;
        com.larus.audio.call.p r9 = ((CommonFeedbackVoicePluginV2) this).j;
        if (r9 == null) goto L12;
        r9.a();
    L12:
        String r10 = null;
        ((CommonFeedbackVoicePluginV2) this).j = null;
        com.larus.audio.call.arch.b.e(getContext(), new com.larus.call_plugins_doubao_common.f(this, r8));
        if (((CommonFeedbackVoicePluginV2) this).h == false) goto L26;
        ((CommonFeedbackVoicePluginV2) this).h = false;
        IRealtimeCallTracer r0 = getContext().k();
        String r1 = getContext().params().e;
        String r2 = getContext().params().o.h;
        IVoiceCallService r11 = (IVoiceCallService) ServiceManager.get().getService(IVoiceCallService.class);
        if (r11 == null) goto L17;
        r10 = r11.s();
    L17:
        String r3 = r10;
        String r5 = ((CommonFeedbackVoicePluginV2) this).k;
        AudioSoundAppeaseManager r12 = j3();
        if (r12.f == false) goto L22;
        IVideoController r13 = r12.d();
        if (r13 == null) goto L22;
        long r14 = r13.getWatchedDuration();
    L23:
        r0.M(r1, r2, r3, Long.valueOf(r14), r5);
        return;
    L22:
        r14 = 0;
        goto L23
    L26:
        return;
    L4:
        if (((CommonFeedbackVoicePluginV2) this).i == false) goto L6;
    }

    public final void l3(MajorState r2, MajorState r3) {
        Intrinsics.checkNotNullParameter(r2, "prev");
        Intrinsics.checkNotNullParameter(r3, "current");
        super.l3(r2, r3);
        if ((r3 instanceof MajorState.d) == true) goto L5;
        return;
    L5:
        if (((CommonFeedbackVoicePluginV2) this).i == true) goto L9;
        com.larus.avlink.n1.d(this.n, "state change to Listening, stopVoiceAppeaseImmediately");
        r3(null);
        return;
    }
}
