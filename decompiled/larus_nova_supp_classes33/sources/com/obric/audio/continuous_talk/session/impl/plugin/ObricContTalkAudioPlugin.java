package com.obric.audio.continuous_talk.session.impl.plugin;

import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.aec.x;
import com.larus.audio.call.extension.WakeupAudioAuthSessionController;
import com.larus.audio.call.plugins.u;
import com.larus.audio.call.plugins.v0;
import com.larus.audio.call.record.CaptureBackTraceReadScene;
import com.larus.im.service.audio.AvAecType;
import com.larus.im.service.audio.cmd.TriggerMode;
import com.larus.im.service.audio.z0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.audio.ObricBackTraceLogDelegate;
import com.obric.assistant.spi.audio.ObricVadDelegate;
import com.obric.assistant.spi.wakeup.IWakeupLatencyTrackService;
import com.obric.assistant.spi.wakeup.ObricOneshotDelegate;
import com.obric.assistant.spi.wakeup.ObricWakeupLatencyTrackService;
import com.obric.audio.enroll.sidauth.SidAuthSessionService;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.json.JSONObject;
import pf9.a0;
import pf9.b0;
import pf9.c0;
import pf9.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ObricContTalkAudioPlugin extends u<com.obric.audio.continuous_talk.session.impl.a> implements com.obric.audio.continuous_talk.session.impl.plugin.a {
    public static final /* synthetic */ int b0 = 0;
    public final String I;
    public final ue9.g.a J;
    public final boolean K;
    public final boolean L;
    public final Lazy M;
    public long N;
    public int O;
    public boolean P;
    public String Q;
    public final boolean R;
    public final hga.b S;
    public boolean T;
    public boolean U;
    public float V;
    public float W;
    public float X;
    public final MutableSharedFlow<r58.d> Y;
    public boolean Z;
    public final i a0;

    public static final class a {
    }

    public static final class b extends z0 {
        public final /* synthetic */ z0 a;
        public final /* synthetic */ ObricContTalkAudioPlugin b;

        public final String g() {
            return "ObricCont";
        }

        public final void n(z0.a r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            this.a.n(r2);
            if ((r2 instanceof y) == false) goto L6;
            ObricContTalkAudioPlugin r3 = this.b;
            r3.Z = true;
            r3.T = true;
            r3.U = false;
            return;
        L6:
            if ((r2 instanceof b0) == false) goto L9;
            this.b.i4("query_rejected");
            return;
        L9:
            if ((r2 instanceof a0) == true) goto L11;
            return;
        L11:
            if (((a0) r2).c == false) goto L17;
            this.b.i4("query_end_no_content");
            return;
        }

        public b(u.c r1, ObricContTalkAudioPlugin r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c extends com.larus.audio.call.play.e {
        public final /* synthetic */ ObricContTalkAudioPlugin a;

        public final void c() {
            id9.d r0 = ((com.obric.audio.continuous_talk.session.impl.a) this.a.getContext()).j();
            if (r0 == null) goto L5;
            r0.p(TriggerMode.TTS_PLAYBACK_START, new JSONObject().toString());
        L5:
            ObricContTalkAudioPlugin r1 = this.a;
            r1.Z = false;
            if (r1.U == false) goto L9;
            r1.i4("play_first_frame");
            return;
        }

        public final void onPlayComplete() {
            ObricContTalkAudioPlugin r0 = this.a;
            if (r0.Z == true) goto L7;
            id9.d r1 = ((com.obric.audio.continuous_talk.session.impl.a) r0.getContext()).j();
            if (r1 == null) goto L7;
            r1.p(TriggerMode.TTS_PLAYBACK_END, new JSONObject().toString());
        L7:
            this.a.i4("play_complete");
        }

        public c(ObricContTalkAudioPlugin r1) {
            this.a = r1;
        }

        public final void e(boolean r2) {
            ObricContTalkAudioPlugin r3 = this.a;
            if (r3.T == true) goto L6;
            r3.i4("play_interrupt");
            return;
        }
    }

    static {
    }

    public final void F1(com.larus.audio.call.play.h.a r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
    }

    public final Long D3() {
        return Long.valueOf(ObricOneshotDelegate.b.d());
    }

    public final void M3() {
        this.S.d();
    }

    public final void N3() {
        this.S.f("obric_continuous_talk");
    }

    public final z0 S2() {
        return new b(new u.c(this), this);
    }

    public final void S3() {
        this.O++;
        this.Q = null;
        FLogger.a.i(this.I, "onLLMQueryBegin wakeupAuthQueryRound=" + this.O + " fallbackUsed=" + this.P);
    }

    public final void b3() {
        this.N = 0;
        this.O = 0;
        this.P = false;
        this.Q = null;
        i4("release");
        O2(1.0f);
        super.b3();
        ObricVadDelegate.b.release();
        this.S.h();
    }

    public final v68.a g4() {
        if (AudioServiceDelegate.a.e0() == true) goto L9;
        com.larus.audio.call.record.k r0 = j4();
        if (r0 == null) goto L8;
        return r0;
    L8:
        return n3();
    L9:
        return n3();
    }

    public final u68.c m3() {
        return new com.obric.audio.continuous_talk.session.impl.b(((com.obric.audio.continuous_talk.session.impl.a) getContext()).params(), this.K, this.L);
    }

    public final int u3() {
        return ((Number) this.M.getValue()).intValue();
    }

    public final Long y3() {
        return Long.valueOf(ObricOneshotDelegate.b.h());
    }

    public final void c4() {
        s3().i(new c(this));
    }

    public final void d0() {
        id9.d r0 = ((com.obric.audio.continuous_talk.session.impl.a) getContext()).j();
        if (r0 == null) goto L6;
        r0.p(TriggerMode.END_ASR, null);
        return;
    }

    public final void e3() {
        super.e3();
        this.O = 0;
        this.P = false;
        this.Q = null;
        long r2 = RangesKt.coerceAtLeast(y3().longValue(), 0);
        this.N = ((((long) ((this.J.b * 1) * 2)) * r2) / 1000) + 1000;
        FLogger.a.i(this.I, "resetVadSkipWindow skipMs=" + r2 + ", remainingVadSkipBytesForBackTrace=" + this.N);
        hga.b r6 = this.S;
        long r7 = k4();
        ue9.g.a r3 = this.J;
        r6.c(r7, r3.b, r3.c, 2, "obric_continuous_talk");
        IWakeupLatencyTrackService.a.b(ObricWakeupLatencyTrackService.b);
        ObricVadDelegate.b.preload();
        this.T = false;
        this.U = false;
        this.W = 1.0f;
        this.X = Float.NaN;
        h4("start_reset");
        CoroutineScope r4 = ((com.obric.audio.continuous_talk.session.impl.a) getContext()).r();
        if (r4 == null) goto L6;
        BuildersKt.launch$default(r4, null, null, new ObricContTalkAudioPlugin$onStart$1(this, null), 3, null);
        return;
    }

    public final void f4() {
        t3().a("continuous_talk");
        t3().f(new ObricContTalkAudioPlugin$setRecordStartTrace$1(ObricBackTraceLogDelegate.b));
        t3().g(new e(this));
    }

    public final com.larus.audio.call.record.k j4() {
        if (D3().longValue() <= 0) goto L5;
        long r0 = D3().longValue() - k4();
    L6:
        int r2 = com.larus.audio.call.record.k.j;
        return com.larus.audio.call.record.k.a.a(CaptureBackTraceReadScene.CONTINUOUS_TALK, r0, "obric_continuous_talk", ((com.obric.audio.continuous_talk.session.impl.a) getContext()).params().c0);
    L5:
        r0 = System.currentTimeMillis();
        goto L6
    }

    public final long k4() {
        Long r0 = y3();
        if (r0.longValue() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L9;
        r0 = null;
    L9:
        if (r0 != null) goto L13;
        return 50;
    L13:
        return r0.longValue();
    L5:
        r1 = false;
        goto L6
    }

    public final v68.a n3() {
        RealtimeCallParam r0 = ((com.obric.audio.continuous_talk.session.impl.a) getContext()).params();
        Lazy r1 = com.obric.audio.continuous_talk.session.impl.p.a;
        boolean r2 = com.obric.audio.continuous_talk.session.impl.p.b(Integer.valueOf(r0.g), Integer.valueOf(r0.c0));
        AudioServiceDelegate r3 = AudioServiceDelegate.a;
        if (r3.e0() == false) goto L7;
        if (r2 == false) goto L7;
        FLogger.a.i(this.I, "createAudioRecorder , isDoraWakeUp and isDoraVuiWakeup use AVInnerRecordAdapter");
        id9.d r4 = ((com.obric.audio.continuous_talk.session.impl.a) getContext()).j();
        Intrinsics.checkNotNull(r4);
        return new com.larus.audio.call.record.a(r4, AvAecType.NONE, new f(this), 0, new com.larus.audio.call.record.m(new g(this)), 8);
    L7:
        FLogger.a.i(this.I, "createAudioRecorder , use BackTraceAudioRecorderWrapper, isDoraWakeUp=" + r3.e0() + ", isDoraVuiWakeup=" + r2);
        com.larus.audio.call.record.k r5 = j4();
        if (r5 == null) goto L10;
        return r5;
    L10:
        return new com.larus.audio.call.record.g();
    }

    public final ue9.g.a B3() {
        return this.J;
    }

    public final boolean J3() {
        return this.K;
    }

    public final String T2() {
        return this.I;
    }

    @Override // com.obric.audio.continuous_talk.session.impl.plugin.a
    public final MutableSharedFlow j1() {
        return this.Y;
    }

    public final boolean w3() {
        return this.R;
    }

    public final com.larus.audio.call.plugins.a z3() {
        return this.a0;
    }

    public ObricContTalkAudioPlugin(final com.obric.audio.continuous_talk.session.impl.a r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4);
        this.I = "ObricContTalkAudioPlugin";
        this.J = new ue9.g.a(r4.params().l.e, r4.params().l.f);
        this.K = true;
        this.L = true;
        this.M = LazyKt.lazy(new h(r4));
        this.R = true;
        this.S = ObricBackTraceLogDelegate.b.c();
        this.V = 1.0f;
        this.W = 1.0f;
        this.X = 1.0f;
        this.Y = SharedFlowKt.MutableSharedFlow$default(0, 1, BufferOverflow.DROP_OLDEST, 1, null);
        this.a0 = new i(((u) this).E);
    }

    public final void L3(r58.d r6) {
        Intrinsics.checkNotNullParameter(r6, "audioData");
        this.S.g();
        int r0 = RangesKt.coerceAtMost(r6.a, r6.b.length);
        int r1 = x.a;
        byte[] r2 = x.a(r6.b, r0);
        if (this.Y.tryEmit(new r58.d(r2.length, r2, r6.c)) == true) goto L5;
        FLogger.a.e(this.I, "onAecAudioDataReceived emit failed");
    L5:
        super.L3(r6);
    }

    @Override // com.obric.audio.continuous_talk.session.impl.plugin.a
    public final void O2(float r3) {
        this.V = RangesKt.coerceIn(r3, 0.0f, 1.0f);
        h4("media_focus");
    }

    public final void T3(a0 r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        if (r3.c == false) goto L5;
        return;
    L5:
        if (this.T == false) goto L7;
        this.U = true;
    L7:
        ((u) this).E.e0().d(true, true, "query_end");
    }

    public final void U3(c0 r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        this.S.e();
        pf9.a r3 = r2.a;
        if (r3 == null) goto L16;
        String r4 = r3.a;
        if (r4 != null) goto L7;
        return;
    L7:
        if (r4.length() <= 0) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == true) goto L13;
        r4 = null;
    L13:
        if (r4 == null) goto L18;
        this.Q = r4;
        return;
    L18:
        return;
    L9:
        r0 = false;
        goto L10
    }

    public final void X3(r58.d r13) {
        Intrinsics.checkNotNullParameter(r13, "audioData");
        int r0 = RangesKt.coerceAtMost(r13.a, r13.b.length);
        if (r0 > 0) goto L6;
        FLogger.a.w(this.I, "[vad] skip empty aec frame, readSize=" + r13.a + ", dataSize=" + r13.b.length + ", timeNs=" + r13.c);
        return;
    L6:
        int r1 = x.a;
        byte[] r2 = x.a(r13.b, r0);
        int r3 = r2.length;
        if (r3 > 0) goto L10;
        FLogger.a.w(this.I, "[vad] skip empty ch0 aec frame, readSize=" + r13.a + ", dataSize=" + r13.b.length + ", timeNs=" + r13.c);
        return;
    L10:
        long r4 = this.N;
        if (r4 <= 0) goto L14;
        this.N = RangesKt.coerceAtLeast(r4 - ((long) r3), 0);
        FLogger.a.i(this.I, "[aec] obricVadActive=false, size=" + r3 + ", skipHistory=true, remainingSkipBytes=" + this.N);
        return;
    L14:
        ObricVadDelegate r14 = ObricVadDelegate.b;
        boolean r5 = r14.b(r2, r3);
        if (r5 == false) goto L17;
        float[] r15 = r14.a();
    L18:
        SidAuthSessionService.a.getClass();
        Intrinsics.checkNotNullParameter(r2, "pcm");
        if (SidAuthSessionService.f == true) goto L49;
        boolean r8 = false;
        int r7 = RangesKt.coerceIn(0, 0, r2.length);
        int r9 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(r3, r2.length - r7), 0);
        if (r9 <= 0) goto L49;
        Object r10 = SidAuthSessionService.g;
        monitor-enter(r10);
    L54:
        th = move-exception;
        throw th;
    L27:
        if (SidAuthSessionService.e == true) goto L29;
    L48:
        monitor-exit(r10);
        goto L49
    L29:
        if (SidAuthSessionService.j == false) goto L48;
        ByteArrayOutputStream r11 = SidAuthSessionService.h;     // Catch: Throwable -> L54
        if (r11 != null) goto L35;
        monitor-exit(r10);
        goto L49
    L35:
        r11.write(r2, r7, r9);     // Catch: Throwable -> L54
        if (r15 != null) goto L38;
    L43:
        long r12 = SidAuthSessionService.e("feedContinuousVadPcm");     // Catch: Throwable -> L54
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L54
        monitor-exit(r10);
        if (r12 == 0) goto L49;
        SidAuthSessionService.l(r12, "cache duration exceeds 60000ms");
        goto L49
    L38:
        if (r15.length != 0) goto L41;
        r8 = true;
    L41:
        if ((!r8) == false) goto L43;
        SidAuthSessionService.k = Arrays.copyOf(r15, r15.length);     // Catch: Throwable -> L54
    L49:
        FLogger.a.i(this.I, "[aec] obricVadActive=" + r5 + ", size=" + r3 + ", stereoSize=" + r0);
        if (r5 == false) goto L59;
        if (r15 == null) goto L60;
        ((com.obric.audio.continuous_talk.session.impl.plugin.b) getContext().b(Reflection.getOrCreateKotlinClass(com.obric.audio.continuous_talk.session.impl.plugin.b.class), null)).H1(r15);
        return;
    L60:
        return;
    L59:
        return;
    L17:
        r15 = null;
        goto L18
    }

    public final WakeupAudioAuthSessionController.QueryEndAction d4(a0 r9) {
        Intrinsics.checkNotNullParameter(r9, "event");
        if (this.R == false) goto L22;
        if (((com.obric.audio.continuous_talk.session.impl.a) getContext()).params().c0 == 0) goto L22;
        String r0 = this.Q;
        if (this.O == 1) goto L10;
    L14:
        boolean r1 = false;
    L16:
        if (r1 == true) goto L19;
        FLogger.a.i(this.I, "resolveWakeupAudioAuthQueryEndAction endSession queryRound=" + this.O + " fallbackUsed=" + this.P + " noContent=" + r9.c + " asrText=" + r0);
        return WakeupAudioAuthSessionController.QueryEndAction.END_SESSION;
    L19:
        this.P = true;
        this.Q = null;
        FLogger.a.i(this.I, "resolveWakeupAudioAuthQueryEndAction resetForNextQuery queryRound=" + this.O + " fallbackUsed=" + this.P + " noContent=" + r9.c + " asrText=" + r0);
        return WakeupAudioAuthSessionController.QueryEndAction.RESET_FOR_NEXT_QUERY;
    L10:
        if (this.P == true) goto L14;
        int r2 = com.obric.audio.enroll.sidauth.p.a;
        if (com.obric.audio.enroll.sidauth.p.a(r0, this.I) == true) goto L14;
        r1 = true;
    L22:
        return WakeupAudioAuthSessionController.QueryEndAction.END_SESSION;
    }

    public final void h4(String r8) {
        float r0 = RangesKt.coerceIn(Math.min(this.V, this.W), 0.0f, 1.0f);
        boolean r2 = false;
        if (this.X != r0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        return;
    L8:
        FLogger r3 = FLogger.a;
        r3.i(this.I, "applyCombinedTtsVolume, reason=" + r8 + ", mediaFocusVolumeFactor=" + this.V + ", ttsDuckVolumeFactor=" + this.W + ", strategy=min, targetVolumeFactor=" + r0);
        if (((u) this).r == null) goto L11;
        r2 = true;
    L11:
        if (r2 == true) goto L14;
        r3.w(this.I, "applyCombinedTtsVolume skipped, audioPlayer is not initialized, reason=".concat(r8));
        return;
    L14:
        s3().setVolume(r0);
        this.X = r0;
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final void i(byte[] r2) {
        Intrinsics.checkNotNullParameter(r2, "audio");
        v0 r0 = com.larus.audio.call.arch.b.b(getContext());
        if (r0 == null) goto L6;
        r0.i(r2);
        return;
    }

    public final void i4(String r4) {
        this.T = false;
        this.U = false;
        FLogger.a.i(this.I, "clearTtsDuckedState, reason=".concat(r4));
        this.W = RangesKt.coerceIn(1.0f, 0.0f, 1.0f);
        h4(r4);
    }

    public final void Y3(r58.d r2, byte[] r3) {
        Intrinsics.checkNotNullParameter(r2, "audioData");
        this.S.i(r2.a);
        s58.a.a.getClass();
        Pair r4 = s58.a.a.b(r2);
        Z3(r2, (r58.d) r4.component1(), (r58.d) r4.component2());
        this.S.a(r2.a);
    }
}
