package com.larus.voicecall.impl.plugins;

import android.os.SystemClock;
import android.view.View;
import com.larus.im.service.audio.AudioSessionType;
import com.larus.im.service.audio.ModalType;
import com.larus.im.service.audio.cmd.TargetVideoSourceType;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.bean.RealtimeVlmLimitStatus;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class n1 extends com.larus.audio.call.arch.a<r> implements o1 {
    public final String f;
    public boolean g;
    public com.larus.im.service.audio.z h;
    public View i;
    public boolean j;
    public Function0<Unit> k;
    public Function0<Unit> l;
    public Function1<? super RealtimeVlmLimitStatus, Unit> m;
    public long n;
    public RealtimeVlmLimitStatus o;
    public boolean p;

    public static final class a extends com.larus.im.service.audio.a1 {
        public final String a;
        public final /* synthetic */ n1 b;

        public final String g() {
            return this.a;
        }

        public a(n1 r1) {
            this.b = r1;
            this.a = r1.f;
        }

        public final void n(com.larus.im.service.audio.z0.a r3) {
            Intrinsics.checkNotNullParameter(r3, "event");
            if ((r3 instanceof pf9.o) == false) goto L11;
            pf9.o r4 = (pf9.o) r3;
            if (r4.d == true) goto L8;
            this.b.k3(RealtimeVlmLimitStatus.REACH_DAILY_LIMIT);
        L8:
            if (r4.b == false) goto L25;
            this.b.k3(RealtimeVlmLimitStatus.DOWNGRADE);
            return;
        L25:
            return;
        L11:
            if ((r3 instanceof pf9.m0) == false) goto L23;
            n1 r0 = this.b;
            int r5 = ((pf9.m0) r3).a;
            if (r5 != 1) goto L15;
            RealtimeVlmLimitStatus r6 = RealtimeVlmLimitStatus.REACH_SINGLE_TIME_LIMIT;
        L22:
            r0.k3(r6);
            return;
        L15:
            if (r5 != 2) goto L17;
            r6 = RealtimeVlmLimitStatus.REACH_DAILY_LIMIT;
            goto L22
        L17:
            if (r5 == 3) goto L19;
            r6 = RealtimeVlmLimitStatus.NOT_LIMIT;
            goto L22
        L19:
            r6 = RealtimeVlmLimitStatus.MUTE_TOO_LONG;
            goto L22
        L23:
            boolean r7 = r3 instanceof pf9.o0;
        }

        public final void q(String r5, Object r6) {
            Intrinsics.checkNotNullParameter(r5, "event");
            if (Intrinsics.areEqual(r5, "OTHER_EVENT_RTC_FIRST_LOCAL_VIDEO_FRAME_CAPTURED") == true) goto L5;
            Intrinsics.areEqual(r5, "OTHER_EVENT_RTC_VIDEO_STOPPED");
            return;
        L5:
            if (this.b.n <= 0) goto L7;
            long r7 = SystemClock.elapsedRealtime() - this.b.n;
        L8:
            FLogger.a.i(this.b.f, "onFirstLocalVideoFrameCaptured captureCost=" + r7);
            Function0<Unit> r8 = this.b.k;
            if (r8 == null) goto L13;
            r8.invoke();
            return;
        L13:
            return;
        L7:
            r7 = -1;
            goto L8
        }
    }

    @Override // com.larus.voicecall.impl.plugins.o1
    public final void N() {
        com.larus.im.service.audio.z r0 = this.h;
        if (r0 == null) goto L6;
        r0.v();
        return;
    }

    public final com.larus.im.service.audio.z0 S2() {
        return new a(this);
    }

    @Override // com.larus.voicecall.impl.plugins.o1
    public final void g() {
        com.larus.im.service.audio.z r0 = this.h;
        if (r0 == null) goto L6;
        r0.g();
        return;
    }

    @Override // com.larus.voicecall.impl.plugins.o1
    public final boolean isCameraTorchSupported() {
        com.larus.im.service.audio.z r0 = this.h;
        if (r0 != null) goto L8;
        id9.d r1 = ((r) getContext()).j();
        if (r1 == null) goto L7;
        r0 = r1.e();
        goto L8
    L7:
        r0 = null;
    L8:
        FLogger r2 = FLogger.a;
        String r3 = this.f;
        StringBuilder r4 = new StringBuilder("isCameraTorchSupported isVideoServiceAvailable=");
        if (r0 == null) goto L11;
        boolean r5 = true;
    L12:
        r4.append(r5);
        r2.i(r3, r4.toString());
        if (r0 != null) goto L15;
        return false;
    L15:
        return r0.isCameraTorchSupported();
    L11:
        r5 = false;
        goto L12
    }

    public final boolean j3() {
        if (this.o == RealtimeVlmLimitStatus.NOT_LIMIT) goto L7;
        FLogger.a.e(this.f, "video service is not available, because of limited.");
        return false;
    L7:
        if (this.h == null) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // com.larus.voicecall.impl.plugins.o1
    public final void k() {
        com.larus.im.service.audio.z r0 = this.h;
        if (r0 == null) goto L6;
        r0.k();
        return;
    }

    @Override // com.larus.voicecall.impl.plugins.o1
    public final void l() {
        com.larus.im.service.audio.z r0 = this.h;
        if (r0 == null) goto L6;
        r0.l();
        return;
    }

    @Override // com.larus.voicecall.impl.plugins.o1
    public final void o() {
        com.larus.im.service.audio.z r0 = this.h;
        if (r0 == null) goto L6;
        r0.o();
        return;
    }

    @Override // com.larus.voicecall.impl.plugins.o1
    public final void r0() {
        FLogger.a.i(this.f, "triggerVideoModal");
        id9.d r0 = ((r) getContext()).j();
        if (r0 == null) goto L6;
        r0.m(ModalType.VIDEO, TargetVideoSourceType.VIDEO_SOURCE_CAMERA);
        return;
    }

    @Override // com.larus.voicecall.impl.plugins.o1
    public final void v2() {
        FLogger.a.i(this.f, "triggerExitVideoModal");
        id9.d r0 = ((r) getContext()).j();
        if (r0 == null) goto L6;
        r0.m(ModalType.AUDIO, TargetVideoSourceType.VIDEO_SOURCE_DEFAULT);
        return;
    }

    public final void e3() {
        super.e3();
        RealtimeCallUtil.a.getClass();
        RealtimeCallUtil.S = false;
        id9.d r0 = ((r) getContext()).j();
        if (r0 == null) goto L10;
        com.larus.im.service.audio.z r1 = r0.e();
        if (r1 == null) goto L11;
        this.h = r1;
        Function0<Unit> r2 = this.l;
        if (r2 == null) goto L12;
        r2.invoke();
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.larus.voicecall.impl.plugins.o1
    public final boolean D5() {
        return this.j;
    }

    public final String T2() {
        return this.f;
    }

    @Override // com.larus.voicecall.impl.plugins.w
    public final RealtimeVlmLimitStatus W1() {
        return this.o;
    }

    @Override // com.larus.voicecall.impl.plugins.o1
    public final com.larus.im.service.audio.z e() {
        return this.h;
    }

    public final void g3() {
        super.g3();
    }

    @Override // com.larus.voicecall.impl.plugins.o1
    public final boolean y1() {
        return this.g;
    }

    public n1(r r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.f = "RealtimeCallVideoPlugin";
        this.n = -1;
        this.o = RealtimeVlmLimitStatus.NOT_LIMIT;
    }

    @Override // com.larus.voicecall.impl.plugins.w
    public final void A1(Function1<? super RealtimeVlmLimitStatus, Unit> r1) {
        this.m = r1;
    }

    @Override // com.larus.voicecall.impl.plugins.o1
    public final void V1(boolean r3) {
        com.larus.im.service.audio.z r0 = this.h;
        if (r0 == null) goto L6;
        r0.w(null, r3);
        return;
    }

    @Override // com.larus.voicecall.impl.plugins.o1
    public final void W0(com.larus.voicecall.impl.component.vlm.r1 r1) {
        this.k = r1;
    }

    @Override // com.larus.voicecall.impl.plugins.o1
    public final boolean b(boolean r3) {
        if (j3() == true) goto L5;
        return false;
    L5:
        com.larus.im.service.audio.z r0 = this.h;
        if (r0 != null) goto L8;
        return false;
    L8:
        if (r0.b(r3) != true) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // com.larus.voicecall.impl.plugins.o1
    public final boolean c(boolean r2) {
        com.larus.im.service.audio.z r0 = this.h;
        if (r0 != null) goto L8;
        id9.d r1 = ((r) getContext()).j();
        if (r1 == null) goto L7;
        r0 = r1.e();
        goto L8
    L7:
        r0 = null;
    L8:
        if (r0 != null) goto L12;
        return false;
    L12:
        return r0.c(r2);
    }

    @Override // com.larus.voicecall.impl.plugins.o1
    public final void h(tf9.b r4) {
        Intrinsics.checkNotNullParameter(r4, "param");
        if (this.p == false) goto L5;
        r4.h = true;
        this.p = false;
        FLogger.a.i(this.f, "pushVideoFrame first frame");
    L5:
        com.larus.im.service.audio.z r0 = this.h;
        if (r0 == null) goto L9;
        r0.h(r4);
        return;
    }

    public final void k3(final RealtimeVlmLimitStatus r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        if (r2 != RealtimeVlmLimitStatus.NOT_LIMIT) goto L5;
    L7:
        this.o = r2;
        return;
    L5:
        if (this.j == false) goto L7;
        com.larus.utils.t0.e(new m1(this, r2));
        goto L7
    }

    @Override // com.larus.voicecall.impl.plugins.o1
    public final void m0(boolean r5) {
        if (j3() == true) goto L5;
        return;
    L5:
        if (r5 == false) goto L9;
        id9.d r0 = ((r) getContext()).j();
        if (r0 == null) goto L9;
        r0.m(ModalType.AUDIO, TargetVideoSourceType.VIDEO_SOURCE_DEFAULT);
    L9:
        FLogger.a.i(this.f, "stopVideoCaptureInternal needSwitchModal=" + r5 + " videoCaptureStarted=" + this.j);
        RealtimeCallUtil r6 = RealtimeCallUtil.a;
        AudioSessionType r1 = ((r) getContext()).params().s;
        r6.getClass();
        if (RealtimeCallUtil.L(r1) == true) goto L15;
        com.larus.im.service.audio.z r2 = this.h;
        if (r2 == null) goto L19;
        r2.v();
    L19:
        ((r) getContext()).k().v(false);
        r6.getClass();
        RealtimeCallUtil.S = false;
        this.j = false;
        com.larus.audio.call.arch.c r7 = getContext();
        Intrinsics.checkNotNullParameter(r7, "<this>");
        com.larus.audio.call.plugins.x0 r8 = r7.c(Reflection.getOrCreateKotlinClass(com.larus.audio.call.plugins.x0.class), null);
        if (r8 == null) goto L22;
        r8.Q1();
    L22:
        a1 r9 = s.a((r) getContext());
        if (r9 == null) goto L26;
        r9.K1("voice_call");
        return;
    L26:
        return;
    L15:
        if (com.larus.platform.service.z2.a.applyMmtUnpublish() == false) goto L19;
        com.larus.im.service.audio.z r3 = this.h;
        if (r3 == null) goto L19;
        r3.u();
        goto L19
    }

    @Override // com.larus.voicecall.impl.plugins.o1
    public final void r2(com.larus.voicecall.impl.component.vlm.p1 r2) {
        this.l = r2;
        if (this.h == null) goto L6;
        r2.invoke();
        return;
    }

    @Override // com.larus.voicecall.impl.plugins.o1
    public final void x2(boolean r1) {
        this.g = r1;
    }

    @Override // com.larus.voicecall.impl.plugins.o1
    public final boolean L0(View r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        if (j3() == false) goto L9;
        this.i = r5;
        this.n = SystemClock.elapsedRealtime();
        com.larus.im.service.audio.z r0 = this.h;
        if (r0 == null) goto L7;
        r0.w(r5, r6);
    L7:
        FLogger.a.i(this.f, "preloadVideoCapture video service is available");
        return true;
    L9:
        id9.d r1 = ((r) getContext()).j();
        if (r1 == null) goto L12;
        com.larus.im.service.audio.z r2 = r1.e();
    L13:
        if (r2 == null) goto L16;
        this.i = r5;
        this.n = SystemClock.elapsedRealtime();
        r2.w(r5, r6);
        FLogger.a.i(this.f, "preloadVideoCapture video service is not available, but bind success");
        return true;
    L16:
        FLogger.a.w(this.f, "preloadVideoCapture video service is not available, and bind failed");
        return false;
    L12:
        r2 = null;
        goto L13
    }

    @Override // com.larus.voicecall.impl.plugins.o1
    public final void f(float r2, float r3) {
        com.larus.im.service.audio.z r0 = this.h;
        if (r0 == null) goto L6;
        r0.f(r2, r3);
        return;
    }

    @Override // com.larus.voicecall.impl.plugins.o1
    public final boolean M2(View r7, boolean r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r7, "canvas");
        FLogger r0 = FLogger.a;
        r0.d(this.f, "startVideoCapture() called with: canvas, needSwitchModal = " + r8);
        if (j3() == true) goto L5;
        return false;
    L5:
        this.i = r7;
        if (this.j == false) goto L9;
        r0.w(this.f, "video capture may has started");
        return false;
    L9:
        ((r) getContext()).k().v(true);
        RealtimeCallUtil r1 = RealtimeCallUtil.a;
        r1.getClass();
        RealtimeCallUtil.S = true;
        this.j = true;
        com.larus.audio.call.arch.c r3 = getContext();
        Intrinsics.checkNotNullParameter(r3, "<this>");
        com.larus.audio.call.plugins.x0 r4 = r3.c(Reflection.getOrCreateKotlinClass(com.larus.audio.call.plugins.x0.class), null);
        if (r4 == null) goto L12;
        r4.k2();
    L12:
        a1 r5 = s.a((r) getContext());
        if (r5 == null) goto L15;
        r5.K1("video_call");
    L15:
        if (r8 == false) goto L19;
        id9.d r10 = ((r) getContext()).j();
        if (r10 == null) goto L19;
        r10.m(ModalType.VIDEO, TargetVideoSourceType.VIDEO_SOURCE_CAMERA);
    L19:
        AudioSessionType r11 = ((r) getContext()).params().s;
        r1.getClass();
        if (RealtimeCallUtil.L(r11) == false) goto L24;
        this.p = true;
        com.larus.im.service.audio.z r12 = this.h;
        if (r12 == null) goto L27;
        r12.t(false);
    L27:
        return true;
    L24:
        com.larus.im.service.audio.z r13 = this.h;
        if (r13 == null) goto L27;
        r13.w(r7, r9);
        goto L27
    }
}
