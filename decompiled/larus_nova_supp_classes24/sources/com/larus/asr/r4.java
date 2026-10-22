package com.larus.asr;

import com.bytedance.flow_audio.api.business.asr.error.FlowAsrErrorType;
import com.bytedance.flow_audio.api.business.asr.session.FlowAsrCancelReason;
import com.bytedance.flow_audio.api.business.asr.session.FlowAsrSessionState;
import com.bytedance.flow_audio.api.business.asr.source.FlowAsrAudioRecordException;
import com.larus.utils.logger.FLogger;
import gw5.i;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class r4 implements jw5.a {
    public final qw5.a b;
    public final sw5.a c;
    public final String d;
    public volatile FlowAsrSessionState e;
    public volatile jw5.b f;
    public volatile boolean g;
    public volatile boolean h;
    public volatile hw5.a i;
    public final b j;

    public static final class a {
    }

    public static final class b implements sw5.b {
        public final /* synthetic */ r4 b;

        public final void A1() {
        }

        public final void a2() {
        }

        public b(r4 r1) {
            this.b = r1;
        }

        public final void i1(final hw5.a r3) {
            Intrinsics.checkNotNullParameter(r3, "error");
            final r4 r0 = this.b;
            com.larus.utils.t0.e(new s4(r0, r3));
        }

        public final void o2(rw5.d r2) {
            Intrinsics.checkNotNullParameter(r2, "voiceData");
        }
    }

    static {
    }

    public final void h() {
        h3("clear listener state=" + this.e);
        this.f = null;
    }

    public final hw5.a l3() {
        hw5.a r1 = null;
        if (this.g == true) goto L6;
        h3("stop recorder skipped: not started");
        return null;
    L6:
        h3("stop recorder begin");
        this.g = false;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        this.c.stopRecorder();     // Catch: Throwable -> L9
        Object r2 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r3 = Result.exceptionOrNull-impl(r2);
        if (r3 == null) goto L26;
        r1 = n3(r3, FlowAsrErrorType.SOURCE_STOP_FAILED, -2002);
    L26:
        this.c.M0(this.j);     // Catch: Throwable -> L16
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L21;
        H2("remove audio record listener failed: " + r5);
    L21:
        if (r1 != null) goto L23;
        h3("stop recorder success");
    L23:
        return r1;
    L16:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
    L9:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public final void release() {
        FlowAsrSessionState r0 = this.e;
        FlowAsrSessionState r1 = FlowAsrSessionState.RELEASED;
        if (r0 != r1) goto L6;
        h3("release ignored: already released");
        return;
    L6:
        h3("release begin state=" + this.e);
        m3();
        u(r1);
        this.f = null;
        h3("release finished");
    }

    public final void start() {
        h3("start begin state=" + this.e);
        FlowAsrSessionState r0 = this.e;
        FlowAsrSessionState r1 = FlowAsrSessionState.IDLE;
        if (r0 != r1) goto L15;
        if (this.e == r1) goto L7;
        h3("prepare ignored state=" + this.e);
        goto L15
    L7:
        h3("prepare begin");
        jw5.b r2 = this.f;
        if (r2 == null) goto L10;
        r2.d2(this);
    L10:
        u(FlowAsrSessionState.PREPARING);
        jw5.b r3 = this.f;
        if (r3 == null) goto L13;
        r3.Y1(this);
    L13:
        h3("prepare success");
    L15:
        if (this.e == FlowAsrSessionState.PREPARING) goto L18;
        h3("start ignored state=" + this.e);
        return;
    L18:
        jw5.b r4 = this.f;
        if (r4 == null) goto L21;
        r4.C0(this);
    L21:
        u(FlowAsrSessionState.RECORDING);
        this.i = null;
        this.h = true;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L24
        this.c.C1(this.j);     // Catch: Throwable -> L24
        this.c.startRecorder();     // Catch: Throwable -> L24
        this.g = true;     // Catch: Throwable -> L24
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L24
    L26:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        this.h = false;
        if (r7 == null) goto L29;
        hw5.a r8 = n3(r7, FlowAsrErrorType.SOURCE_START_FAILED, -2004);
    L30:
        if (r8 == null) goto L38;
        H2("start failed type=" + r8.getType() + " code=" + r8.c);
        m3();
        this.c.M0(this.j);     // Catch: Throwable -> L34
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L34
    L36:
        k0(r8);
        return;
    L34:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L36
    L38:
        jw5.b r10 = this.f;
        if (r10 == null) goto L41;
        r10.E2(this);
    L41:
        jw5.b r11 = this.f;
        if (r11 == null) goto L44;
        r11.g0(this);
    L44:
        h3("start success");
        return;
    L29:
        r8 = this.i;
    L24:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    }

    public final void stop() {
        if (this.e == FlowAsrSessionState.RECORDING) goto L6;
        h3("stop ignored state=" + this.e);
        return;
    L6:
        h3("stop begin");
        u(FlowAsrSessionState.STOPPING);
        hw5.a r0 = l3();
        if (r0 == null) goto L10;
        H2("stop failed type=" + r0.getType() + " code=" + r0.c);
        k0(r0);
        return;
    L10:
        u(FlowAsrSessionState.WAITING_ASR_COMPLETION);
        h3("stop success; notify delegate that recording lifecycle finished");
        jw5.b r1 = this.f;
        if (r1 == null) goto L20;
        i r2 = this.b.j;
        if (r2 == null) goto L17;
        gw5.g r3 = r2.f;
        if (r3 == null) goto L17;
        String r4 = r3.a;
    L18:
        r1.S(this, r4);
        return;
    L17:
        r4 = null;
        goto L18
    }

    public final void m3() {
        hw5.a r0 = l3();
        if (r0 == null) goto L6;
        H2("stop recorder failed type=" + r0.getType() + " code=" + r0.c);
        return;
    }

    public final qw5.a getConfig() {
        return this.b;
    }

    public final String getTaskId() {
        return this.d;
    }

    public static boolean z0(FlowAsrSessionState r1) {
        if (r1 != FlowAsrSessionState.FINISHED) goto L5;
    L12:
        return true;
    L5:
        if (r1 == FlowAsrSessionState.FAILED) goto L12;
        if (r1 == FlowAsrSessionState.CANCELED) goto L12;
        if (r1 == FlowAsrSessionState.RELEASED) goto L12;
        return false;
    }

    public final void H2(String r4) {
        FLogger.a.e("SamiNotReadyRecordingSession", "[" + this.d + "] " + r4);
    }

    public final void Q1(FlowAsrCancelReason r4) {
        Intrinsics.checkNotNullParameter(r4, "reason");
        if (z0(this.e) == false) goto L6;
        h3("cancel ignored state=" + this.e + " reason=" + r4);
        return;
    L6:
        h3("cancel begin state=" + this.e + " reason=" + r4);
        u(FlowAsrSessionState.CANCELING);
        m3();
        u(FlowAsrSessionState.CANCELED);
        jw5.b r0 = this.f;
        if (r0 == null) goto L9;
        r0.A0(this, r4);
    L9:
        h3("cancel finished reason=" + r4);
    }

    public final void h3(String r4) {
        FLogger.a.i("SamiNotReadyRecordingSession", "[" + this.d + "] " + r4);
    }

    public final void k0(hw5.a r5) {
        Intrinsics.checkNotNullParameter(r5, "error");
        if (z0(this.e) == false) goto L6;
        h3("complete failure ignored state=" + this.e + " type=" + r5.getType() + " code=" + r5.c);
        return;
    L6:
        H2("session failed state=" + this.e + " type=" + r5.getType() + " code=" + r5.c + " retryCount=" + r5.f);
        u(FlowAsrSessionState.FAILED);
        jw5.b r0 = this.f;
        if (r0 == null) goto L10;
        r0.f1(this, r5);
        return;
    }

    public final void u(FlowAsrSessionState r4) {
        if (this.e != r4) goto L5;
        return;
    L5:
        FlowAsrSessionState r0 = this.e;
        this.e = r4;
        h3("state changed: " + r0 + " -> " + r4);
        jw5.b r1 = this.f;
        if (r1 == null) goto L9;
        r1.b0(this, r4);
        return;
    }

    public final void v2(jw5.b r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        h3("set listener state=" + this.e);
        this.f = r3;
    }

    public r4(qw5.a r2, sw5.a r3) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "audioRecord");
        this.b = r2;
        this.c = r3;
        this.d = r2.a;
        this.e = FlowAsrSessionState.IDLE;
        StringBuilder r4 = new StringBuilder("created state=");
        r4.append(this.e);
        r4.append(" hasAudioFile=");
        i r5 = r2.j;
        if (r5 == null) goto L7;
        gw5.g r6 = r5.f;
        if (r6 == null) goto L7;
        String r7 = r6.a;
    L9:
        if (r7 != null) goto L11;
    L14:
        boolean r8 = true;
    L15:
        r4.append(!r8);
        h3(r4.toString());
        this.j = new b(this);
        return;
    L11:
        if (r7.length() == 0) goto L14;
        r8 = false;
    L7:
        r7 = null;
        goto L9
    }

    public static hw5.a n3(Throwable r2, FlowAsrErrorType r3, int r4) {
        if ((r2 instanceof FlowAsrAudioRecordException) == false) goto L5;
        FlowAsrAudioRecordException r0 = (FlowAsrAudioRecordException) r2;
    L6:
        if (r0 == null) goto L9;
        hw5.a r1 = r0.getError();
        if (r1 == null) goto L9;
    L13:
        return r1;
    L9:
        String r5 = r2.getMessage();
        if (r5 != null) goto L12;
        r5 = "";
    L12:
        r1 = new hw5.a(r3, r5, r4, r2.toString());
        goto L13
    L5:
        r0 = null;
        goto L6
    }
}
