package com.larus.voicecall.impl.plugins;

import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.play.AVInnerPlayerAdapter;
import com.larus.audio.call.record.CaptureBackTraceReadScene;
import com.larus.im.bean.bot.SceneModel;
import com.larus.im.service.audio.AudioSessionType;
import com.larus.im.service.audio.AvAecType;
import com.larus.im.service.audio.cmd.TriggerMode;
import com.larus.platform.model.audio.RealtimeCallSceneModeHelloConfig;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.assistant.spi.audio.ObricAsrDelegate;
import com.obric.assistant.spi.audio.ObricBackTraceLogDelegate;
import com.obric.assistant.spi.wakeup.IWakeupLatencyTrackService;
import com.obric.assistant.spi.wakeup.ObricWakeupLatencyTrackService;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class RealtimeCallAudioPlugin extends com.larus.audio.call.plugins.u<r> {
    public final boolean I;
    public final boolean J;
    public final String K;
    public final Lazy L;
    public final Lazy M;
    public final Lazy N;
    public final Lazy O;
    public final Lazy P;
    public final Lazy Q;
    public boolean R;
    public final hga.b S;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[TriggerMode.values().length];
            r0[TriggerMode.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[TriggerMode.CLIM_IN_STARTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[TriggerMode.CLIM_IN_END.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final class b extends com.larus.audio.call.play.e {
        public final /* synthetic */ RealtimeCallAudioPlugin a;

        public final void a() {
            s.c((r) this.a.getContext()).x0().b();
        }

        public b(RealtimeCallAudioPlugin r1) {
            this.a = r1;
        }

        public final void d(com.larus.audio.call.play.h.a r3) {
            Intrinsics.checkNotNullParameter(r3, LynxResourceModule.DATA_KEY);
            Intrinsics.checkNotNullParameter(r3, LynxResourceModule.DATA_KEY);
            s.c((r) this.a.getContext()).x0().f(r3.b, r3.c);
        }

        public final void g(byte[] r2) {
            Intrinsics.checkNotNullParameter(r2, LynxResourceModule.AUDIO_TYPE);
            Intrinsics.checkNotNullParameter(r2, LynxResourceModule.AUDIO_TYPE);
            com.larus.voicecall.impl.q r0 = ((r) this.a.getContext()).h();
            if (r0 == null) goto L6;
            r0.g(r2);
            return;
        }
    }

    public final void F1(com.larus.audio.call.play.h.a r2) {
        Intrinsics.checkNotNullParameter(r2, LynxResourceModule.DATA_KEY);
    }

    public final void a4() {
        RealtimeCallUtil.a.getClass();
        if (((RealtimeCallSceneModeHelloConfig) RealtimeCallUtil.p.getValue()).getEnableSceneHello() == false) goto L16;
        com.larus.voicecall.impl.scene.o r0 = RealtimeCallUtil.l;
        if (r0 == null) goto L11;
        SceneModel r1 = r0.a;
        if (r1 == null) goto L11;
        boolean r2 = true;
        if (r1.getNotTriggerHello() != true) goto L11;
    L12:
        if (r2 == true) goto L16;
        if (RealtimeCallUtil.l == null) goto L16;
        s.c((r) getContext()).T1();
    L11:
        r2 = false;
    L16:
        super.a4();
    }

    public final boolean i4() {
        return ((Boolean) this.N.getValue()).booleanValue();
    }

    public final boolean j4() {
        return ((Boolean) this.M.getValue()).booleanValue();
    }

    /* JADX WARN: Type inference failed for: r3v9, types: [com.larus.voicecall.impl.plugins.s0] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.larus.voicecall.impl.plugins.t0] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.larus.voicecall.impl.plugins.u0] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.larus.voicecall.impl.plugins.v0] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.larus.voicecall.impl.plugins.i0] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.larus.voicecall.impl.plugins.j0] */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.larus.voicecall.impl.plugins.k0] */
    public final u68.c m3() {
        FLogger.a.i(this.K, "createAudioPlayer: useRTCInnerPlayer=" + ((Boolean) this.L.getValue()).booleanValue() + ", useAVMedia=" + i4() + ", asyncPlay=" + this.I);
        if (((Boolean) this.L.getValue()).booleanValue() == false) goto L5;
    L12:
        id9.d r1 = ((r) getContext()).j();
        Intrinsics.checkNotNull(r1);
        return new AVInnerPlayerAdapter(r1, new com.larus.audio.call.play.g(new s0(this), new t0(this), new u0(this), new v0(this), new i0(this), new j0(this), new k0(this)));
    L5:
        if (i4() == true) goto L12;
        if (this.I == false) goto L11;
        return new v3a.f(((r) getContext()).params(), J3(), ((Boolean) ((com.larus.audio.call.plugins.u) this).m.getValue()).booleanValue());
    L11:
        return new com.larus.audio.call.play.c(((r) getContext()).params(), J3(), ((Boolean) ((com.larus.audio.call.plugins.u) this).m.getValue()).booleanValue(), null, 0);
    }

    public final v68.a n3() {
        FLogger.a.i(this.K, "createAudioRecorder: useRTCInnerRecord=" + j4() + ", useAVMedia=" + i4() + ", asyncRecord=" + this.J);
        if (j4() == false) goto L5;
    L17:
        RealtimeCallUtil r0 = RealtimeCallUtil.a;
        AudioSessionType r1 = ((r) getContext()).params().s;
        boolean r2 = ((r) getContext()).params().z;
        boolean r3 = J3();
        r0.getClass();
        boolean r4 = RealtimeCallUtil.K(r1, r2, r3);
        if (((r) getContext()).params().s != AudioSessionType.MMT) goto L22;
        if (r4 == false) goto L22;
        AvAecType r5 = AvAecType.RTC_SPEECH;
    L24:
        AvAecType r6 = r5;
        id9.d r7 = ((r) getContext()).j();
        Intrinsics.checkNotNull(r7);
        Function0 r8 = new m0(this);
        if (j4() == false) goto L48;
        ObricAsrDelegate r9 = ObricAsrDelegate.b;
        if (r9.a() == false) goto L48;
        if (r9.k() == false) goto L48;
        int r10 = r9.f();
    L50:
        return new com.larus.audio.call.record.a(r7, r6, r8, r10, null, 16);
    L48:
        r10 = 1;
    L22:
        if (((r) getContext()).params().z == false) goto L26;
        r5 = AvAecType.NONE;
        goto L24
    L26:
        if (J3() == false) goto L33;
        if (((Boolean) this.O.getValue()).booleanValue() == false) goto L33;
        if (r4 == false) goto L31;
        r5 = AvAecType.RTC_SPEECH;
        goto L24
    L31:
        r5 = AvAecType.RTC;
    L33:
        if (J3() == false) goto L36;
        r5 = AvAecType.SAMI;
        goto L24
    L36:
        if (J3() == false) goto L38;
    L40:
        r5 = AvAecType.NONE;
        goto L24
    L38:
        if (((Boolean) RealtimeCallUtil.e0.getValue()).booleanValue() == false) goto L40;
        r5 = AvAecType.RTC;
        goto L24
    L5:
        if (i4() == true) goto L17;
        if (w3() == false) goto L13;
        com.larus.audio.call.record.k r11 = h4();
        if (r11 == null) goto L52;
        return r11;
    L52:
        return new com.larus.audio.call.record.g();
    L13:
        if (this.J == false) goto L16;
        return new com.larus.audio.call.record.e(J3());
    L16:
        return new com.larus.audio.call.record.f(null, 0, J3(), 2);
    }

    public final int u3() {
        return ((Number) this.Q.getValue()).intValue();
    }

    public final boolean w3() {
        ObricAsrDelegate r0 = ObricAsrDelegate.b;
        if (r0.m() == true) goto L5;
        return false;
    L5:
        if (r0.a() == false) goto L19;
        RealtimeCallParam r1 = ((r) getContext()).params();
        if (Intrinsics.areEqual(r1.k.t, "assistant_scene_mode_click_talk") == false) goto L9;
    L14:
        boolean r2 = true;
    L15:
        if (r2 == false) goto L20;
        return true;
    L20:
        return false;
    L9:
        if (r1.a == true) goto L14;
        if (r1.p.q == true) goto L14;
        r2 = false;
        goto L15
    L19:
        return false;
    }

    public final boolean x3() {
        return ((Boolean) this.P.getValue()).booleanValue();
    }

    public final Long D3() {
        RealtimeCallParam.g r0 = ((r) getContext()).params().N;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b;
    }

    public final Map<String, Object> I3() {
        Map<String, Object> r2 = null;
        t r0 = (t) getContext().c(Reflection.getOrCreateKotlinClass(t.class), null);
        if (r0 == null) goto L7;
        Function0<Map<String, Object>> r1 = r0.X1();
        if (r1 == null) goto L7;
        r2 = (Map) r1.invoke();
    L7:
        if (r2 == null) goto L9;
        return r2;
    L9:
        return MapsKt.emptyMap();
    }

    public final void M3() {
        if (w3() == false) goto L6;
        this.S.d();
        return;
    }

    public final void N3() {
        if (w3() == false) goto L6;
        this.S.f("realtime_call");
        return;
    }

    public final void S3() {
        if (J3() == true) goto L5;
        return;
    L5:
        if (s3().isPlaying() == false) goto L9;
        s.c((r) getContext()).x0().onInterrupt();
        return;
    }

    public final void V3() {
        if (((r) getContext()).params().l.h == 1) goto L5;
        return;
    L5:
        if (this.R == false) goto L12;
        FLogger.a.i(this.K, "onLLMReplyBegin stopRecorder");
        if (((com.larus.audio.call.plugins.u) this).s == null) goto L9;
        t3().stopRecord();
    L9:
        this.R = false;
        return;
    }

    public final boolean b1() {
        if (((r) getContext()).params().I >= 0) goto L5;
    L7:
        boolean r0 = false;
    L8:
        o1 r3 = s.e((r) getContext());
        if (r3 == null) goto L11;
        Boolean r4 = Boolean.valueOf(r3.y1());
    L12:
        com.larus.audio.call.plugins.y0 r5 = com.larus.audio.call.arch.b.d(getContext());
        if (r5 != null) goto L15;
    L17:
        boolean r6 = false;
    L18:
        if (r6 == false) goto L23;
        if (r0 == true) goto L21;
        return true;
    L21:
        if (Intrinsics.areEqual(r4, Boolean.TRUE) == false) goto L23;
        return true;
    L23:
        return false;
    L15:
        if (r5.b1() != true) goto L17;
        r6 = true;
        goto L18
    L11:
        r4 = null;
        goto L12
    L5:
        if (((r) getContext()).params().s == AudioSessionType.SAMI) goto L7;
        r0 = true;
        goto L8
    }

    public final void b3() {
        super.b3();
        this.S.h();
    }

    public final void c4() {
        s3().i(new b(this));
    }

    public final void d0() {
        com.larus.voicecall.impl.tracer.o r0 = d3a.a.b(getContext());
        if (r0 == null) goto L5;
        r0.d0();
    L5:
        id9.d r1 = ((r) getContext()).j();
        if (r1 == null) goto L9;
        r1.p(TriggerMode.END_ASR, null);
        return;
    }

    public final void e3() {
        super.e3();
        if (w3() == false) goto L17;
        hga.b r0 = this.S;
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

    public final void f4() {
        if (w3() == true) goto L5;
        return;
    L5:
        if (((r) getContext()).params().b == false) goto L7;
    L15:
        String r0 = "continuous_talk";
    L16:
        if (r0 == null) goto L18;
        t3().a(r0);
        t3().f(new RealtimeCallAudioPlugin$setRecordStartTrace$1$1(ObricBackTraceLogDelegate.b));
    L18:
        t3().g(new l0(this));
        return;
    L7:
        if (((r) getContext()).params().a == true) goto L15;
        if (((r) getContext()).params().p.q == true) goto L15;
        if (((r) getContext()).params().O == false) goto L14;
        r0 = "click_talk";
        goto L16
    L14:
        r0 = null;
        goto L16
    }

    public final v68.a g4() {
        if (w3() == false) goto L8;
        com.larus.audio.call.record.k r0 = h4();
        if (r0 == null) goto L10;
        return r0;
    L10:
        return n3();
    L8:
        return n3();
    }

    public final com.larus.audio.call.record.k h4() {
        Long r0 = D3();
        if (r0 == null) goto L5;
        long r3 = r0.longValue();
    L6:
        Long r1 = y3();
        if (r1 == null) goto L9;
        long r5 = r1.longValue();
    L11:
        if (r3 <= 0) goto L13;
        long r4 = r3 - r5;
    L14:
        int r2 = com.larus.audio.call.record.k.j;
        return com.larus.audio.call.record.k.a.a(CaptureBackTraceReadScene.REALTIME_CALL, r4, "realtime_call", ((r) getContext()).params().c0);
    L13:
        r4 = System.currentTimeMillis();
        goto L14
    L9:
        r5 = 0;
        goto L11
    L5:
        r3 = 0;
        goto L6
    }

    public final Long y3() {
        RealtimeCallParam.g r0 = ((r) getContext()).params().N;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a;
    }

    public final String T2() {
        return this.K;
    }

    public final void L3(r58.d r5) {
        Intrinsics.checkNotNullParameter(r5, "audioData");
        if (w3() == false) goto L7;
        this.S.g();
        com.larus.voicecall.impl.q r0 = ((r) getContext()).h();
        if (r0 == null) goto L7;
        byte[] r1 = r5.b;
        r0.a(new r58.d(r5.a, r1));
    L7:
        super.L3(r5);
    }

    public final void P3(String r2) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r2, "id");
        com.larus.voicecall.impl.q r0 = ((r) getContext()).h();
        if (r0 == null) goto L6;
        r0.f(r2);
        return;
    }

    public final void R3(pf9.r r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        TriggerMode r5 = r4.getType();
        int r6 = a.a[r5.ordinal()];
        if (r6 != 1) goto L5;
        FLogger.a.i(this.K, "[CALL] IMAGE");
        this.R = true;
        s3().d(true, true, "image_triggered");
        return;
    L5:
        if (r6 != 2) goto L7;
        FLogger.a.i(this.K, "[CALL] CLIM_IN_STARTED");
        R1("clim_in_started");
        return;
    L7:
        if (r6 != 3) goto L15;
        FLogger.a.i(this.K, "[CALL] CLIM_IN_END");
        return;
    }

    public final void U3(pf9.c0 r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (w3() == false) goto L6;
        this.S.e();
        return;
    }

    public final void i(byte[] r2) {
        Intrinsics.checkNotNullParameter(r2, LynxResourceModule.AUDIO_TYPE);
        com.larus.audio.call.plugins.v0 r0 = com.larus.audio.call.arch.b.b(getContext());
        if (r0 == null) goto L6;
        r0.i(r2);
        return;
    }

    public final void Y3(r58.d r5, byte[] r6) {
        Intrinsics.checkNotNullParameter(r5, "audioData");
        if (w3() == false) goto L8;
        this.S.i(r5.a);
        s58.a.a.getClass();
        Pair r7 = s58.a.a.b(r5);
        r58.d r0 = (r58.d) r7.component1();
        r58.d r8 = (r58.d) r7.component2();
        this.S.a(r5.a);
        if (x3() == true) goto L25;
        Z3(r5, r0, r8);
        return;
    L25:
        return;
    L8:
        com.larus.voicecall.impl.q r1 = ((r) getContext()).h();
        if (r1 == null) goto L12;
        byte[] r2 = r5.b;
        r1.a(new r58.d(r5.a, r2));
    L12:
        if (x3() == false) goto L15;
        return;
    L15:
        if (j4() == false) goto L17;
    L21:
        com.larus.audio.call.plugins.v0 r9 = com.larus.audio.call.arch.b.b(getContext());
        if (r9 == null) goto L26;
        r9.q2(r5.b, 0);
        return;
    L26:
        return;
    L17:
        if (i4() == true) goto L21;
        super.Y3(r5, r6);
    }

    public RealtimeCallAudioPlugin(final r r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.I = r3;
        this.J = r4;
        this.K = "RealtimeCallAudioPlugin";
        this.L = LazyKt.lazy(new h0(r2));
        this.M = LazyKt.lazy(new n0(r2));
        this.N = LazyKt.lazy(new o0(r2));
        this.O = LazyKt.lazy(new p0(r2));
        this.P = LazyKt.lazy(new q0(r2));
        this.Q = LazyKt.lazy(new r0(r2));
        this.S = ObricBackTraceLogDelegate.b.c();
    }
}
