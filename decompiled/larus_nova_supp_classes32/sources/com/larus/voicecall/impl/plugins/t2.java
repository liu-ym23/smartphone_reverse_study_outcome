package com.larus.voicecall.impl.plugins;

import android.content.Intent;
import android.os.SystemClock;
import com.larus.common.apphost.AppHost;
import com.larus.flow.capture.model.StopReason;
import com.larus.im.service.audio.ModalType;
import com.larus.im.service.audio.cmd.TargetVideoSourceType;
import com.larus.media.MediaResourceManager;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.bean.RealtimeVlmLimitStatus;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.assistant.AutoEndConversationTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class t2 extends com.larus.audio.call.arch.a<r> implements u2 {
    public final AtomicBoolean f;
    public final String g;
    public x68.u h;
    public final f2a.d i;
    public RealtimeVlmLimitStatus j;
    public Function1<? super RealtimeVlmLimitStatus, Unit> k;
    public Function0<Unit> l;
    public Function1<? super String, Unit> m;
    public boolean n;

    public static final class a extends com.larus.im.service.audio.a1 {
        public final String a;
        public final /* synthetic */ t2 b;

        public final String g() {
            return this.a;
        }

        public a(t2 r1) {
            this.b = r1;
            this.a = r1.g;
        }

        public final void n(com.larus.im.service.audio.z0.a r3) {
            Intrinsics.checkNotNullParameter(r3, "event");
            if ((r3 instanceof pf9.o) == false) goto L11;
            pf9.o r4 = (pf9.o) r3;
            if (r4.c == true) goto L8;
            this.b.j3(RealtimeVlmLimitStatus.REACH_DAILY_LIMIT);
        L8:
            if (r4.a == false) goto L24;
            this.b.j3(RealtimeVlmLimitStatus.DOWNGRADE);
            return;
        L24:
            return;
        L11:
            if ((r3 instanceof pf9.m0) == false) goto L26;
            t2 r0 = this.b;
            int r5 = ((pf9.m0) r3).a;
            if (r5 != 1) goto L15;
            RealtimeVlmLimitStatus r6 = RealtimeVlmLimitStatus.REACH_SINGLE_TIME_LIMIT;
        L22:
            r0.j3(r6);
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
        }

        public final void q(String r6, final Object r7) {
            Intrinsics.checkNotNullParameter(r6, "event");
            if (Intrinsics.areEqual(r6, "OTHER_EVENT_RTC_START_SCREEN_SHARE") == false) goto L6;
            FLogger.a.i(this.b.g, "screen share started callback!");
            f2a.c r8 = this.b.i.b("ScreenShareStartResult");
            r8.c.d = "RealtimeScreenSharePlugin.MediaSessionListener.otherEvent";
            f2a.c.c(r8, null, 15);
            return;
        L6:
            if (Intrinsics.areEqual(r6, "OTHER_EVENT_RTC_END_SCREEN_SHARE") == false) goto L10;
            FLogger.a.i(this.b.g, "screen share end callback!");
            f2a.c r9 = this.b.i.b("ScreenShareStop");
            r9.c.d = "RealtimeScreenSharePlugin.MediaSessionListener.otherEvent";
            r9.f(new s2(r7));
            f2a.c.c(r9, null, 15);
            return;
        }
    }

    public final void b3() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        x68.u r2 = this.h;     // Catch: Throwable -> L9
        if (r2 == null) goto L6;
        r2.e();     // Catch: Throwable -> L9
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Result.constructor-impl(r3);     // Catch: Throwable -> L9
    L11:
        this.k = null;
        this.l = null;
        this.m = null;
        this.f.set(true);
        if (this.n == true) goto L17;
        this.h = null;
        return;
    L17:
        return;
    L6:
        r3 = null;
    L9:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public final com.larus.im.service.audio.z0 S2() {
        return new a(this);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.larus.voicecall.impl.plugins.o2] */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.larus.voicecall.impl.plugins.p2] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.larus.voicecall.impl.plugins.q2] */
    public final void e3() {
        super.e3();
        if (this.h != null) goto L6;
        this.h = new x68.u(AppHost.a.getApplication(), new o2(this), new p2(), new q2(this));
        return;
    }

    @Override // com.larus.voicecall.impl.plugins.u2
    public final boolean J() {
        return this.n;
    }

    public final String T2() {
        return this.g;
    }

    @Override // com.larus.voicecall.impl.plugins.w
    public final RealtimeVlmLimitStatus W1() {
        return this.j;
    }

    public t2(r r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.f = new AtomicBoolean(false);
        this.g = "RealtimeCallVideoPlugin";
        this.i = new f2a.d("ScreenShare", "FlowCall");
        this.j = RealtimeVlmLimitStatus.NOT_LIMIT;
    }

    @Override // com.larus.voicecall.impl.plugins.w
    public final void A1(Function1<? super RealtimeVlmLimitStatus, Unit> r1) {
        this.k = r1;
    }

    @Override // com.larus.voicecall.impl.plugins.u2
    public final void Y0(com.larus.voicecall.impl.component.vlm.q r1) {
        this.m = r1;
    }

    public final void j3(RealtimeVlmLimitStatus r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        if (r2 != RealtimeVlmLimitStatus.NOT_LIMIT) goto L5;
    L9:
        this.j = r2;
        return;
    L5:
        if (this.n == false) goto L9;
        Function1<? super RealtimeVlmLimitStatus, Unit> r0 = this.k;
        if (r0 == null) goto L9;
        r0.invoke(r2);
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r22v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v17, types: [int] */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v21, types: [kotlin.Unit] */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v30, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v34 */
    /* JADX WARN: Type inference failed for: r3v46 */
    @Override // com.larus.voicecall.impl.plugins.u2
    public final void n(final com.larus.im.service.audio.f1 r30) {
        t2 r1 = this;
        Intrinsics.checkNotNullParameter(r30, "config");
        FLogger.a.i(r1.g, "startScreenShare ");
        f2a.c r3 = r1.i.b("ScreenShareStartRequest");
        r3.c.d = "RealtimeScreenSharePlugin.startScreenShare";
        r3.f(new m2(r30));
        f2a.c.c(r3, null, 15);
        boolean r4 = true;
        r1.n = true;
        com.larus.audio.call.arch.c r8 = getContext();
        Intrinsics.checkNotNullParameter(r8, "<this>");
        com.larus.audio.call.plugins.w0 r9 = r8.c(Reflection.getOrCreateKotlinClass(com.larus.audio.call.plugins.w0.class), null);
        if (r9 == null) goto L5;
        r9.J2();
    L5:
        a1 r10 = s.a((r) getContext());
        if (r10 == null) goto L8;
        r10.K1("video_call");
    L8:
        id9.d r11 = ((r) getContext()).j();
        if (r11 == null) goto L11;
        r11.m(ModalType.VIDEO, TargetVideoSourceType.VIDEO_SOURCE_SCREEN);
    L11:
        x68.u r12 = r1.h;
        if (r12 == null) goto L112;
        Function0<Unit> r13 = r1.l;
        Intrinsics.checkNotNullParameter(r30, "config");
        r12.u = new da9.e(0);
        r12.v = r30.f;
        f2a.c r0 = r12.D.b("ScreenShareStartRequest");
        r0.c.d = "AVKitScreenManager.startScreenShare";
        r0.f(new x68.a(r12, r30));
        f2a.c.c(r0, null, 15);
        com.larus.im.service.audio.y r5 = (com.larus.im.service.audio.y) r12.b.invoke();
        if (r5 != null) goto L19;
        z68.c r2 = z68.c.a;
        int r14 = r30.g;
        int r15 = r30.h;
        int r6 = r30.f;
        da9.e r7 = r12.u;
        r2.getClass();
        z68.c.j(false, r14, r15, r6, r7, "runtime_error", "screen_share_service_null");
        f2a.c r16 = r12.D.c("ScreenShareStartResult");
        r16.c.d = "AVKitScreenManager.startScreenShare";
        f2a.c.c(r16, null, 15);
        if (r13 == null) goto L27;
        r13.invoke();
    L27:
        String r18 = "RealtimeScreenSharePlugin.startScreenShare";
    L115:
        final ?? r17 = 0;
    L116:
        r1.n = r17;
        f2a.c r19 = r1.i.b("ScreenShareStartResult");
        r19.c.d = r18;
        r19.f(new n2(r17));
        f2a.c.c(r19, null, 15);
        return;
    L19:
        if (((Boolean) r12.c.invoke()).booleanValue() == true) goto L123;
        r18 = "RealtimeScreenSharePlugin.startScreenShare";
        String r20 = "screen_share_rtc_" + System.currentTimeMillis();
        r12.E = r20;
        z68.c r21 = z68.c.a;
        int r22 = r30.g;
        int r23 = r30.h;
        int r24 = r30.f;
        da9.e r25 = r12.u;
        r21.getClass();
        z68.c.a(r20, r22, r23, r24, r25);
        boolean r26 = r5.n(r30);
        int r27 = r30.g;
        int r28 = r30.h;
        int r29 = r30.f;
        da9.e r31 = r12.u;
        if (r26 == false) goto L95;
        String r210 = null;
    L96:
        if (r26 == false) goto L98;
        String r211 = null;
    L99:
        z68.c.j(r26, r27, r28, r29, r31, r210, r211);
        f2a.c r32 = r12.D.b("ScreenShareStartResult");
        r32.c.d = "AVKitScreenManager.startScreenShare";
        String r33 = r12.E;
        if (r33 == null) goto L102;
        List r34 = CollectionsKt.listOf(r33);
    L103:
        r32.c.b = r34;
        r32.f(new x68.n(r26));
        f2a.c.c(r32, null, 15);
        if (r26 == false) goto L106;
        r12.i = true;
        z68.c.h(r12.E, r30.g, r30.h, RangesKt.coerceAtLeast(r12.v, 1));
        r12.g();
    L107:
        if (r26 == true) goto L110;
        if (r13 == null) goto L110;
        r13.invoke();
    L110:
        ?? r110 = r26;
    L111:
        r1 = this;
        r17 = r110;
        goto L116
    L106:
        r12.E = null;
        goto L107
    L102:
        r34 = null;
        goto L103
    L98:
        r211 = "rtc_screen_share_start_failed";
        goto L99
    L95:
        r210 = "runtime_error";
        goto L96
    L123:
        f2a.c r35 = r12.D.b("ScreenShareExternalCapturePrepare");     // Catch: Exception -> L22
        r35.c.d = "AVKitScreenManager.startScreenShare";     // Catch: Exception -> L22
        f2a.c.c(r35, null, 15);     // Catch: Exception -> L22
        r5.r();     // Catch: Exception -> L22
        f2a.c r36 = r12.D.b("ScreenShareExternalCapturePrepared");     // Catch: Exception -> L22
        r36.c.d = "AVKitScreenManager.startScreenShare";     // Catch: Exception -> L22
        f2a.c.c(r36, null, 15);     // Catch: Exception -> L22
    L24:
        if (r4 == true) goto L28;
        if (r13 == null) goto L27;
        r13.invoke();
        goto L27
    L28:
        Intent r37 = r30.e;
        int r38 = r30.g;
        int r39 = r30.h;
        int r40 = r30.f;
        if (r12.f == false) goto L119;
        f2a.c r41 = r12.D.c("ScreenShareStartResult");
        r41.c.d = "AVKitScreenManager.innerStartScreenShare";
        r41.f(new x68.e(r12));
        f2a.c.c(r41, null, 15);
        r18 = "RealtimeScreenSharePlugin.startScreenShare";
        Function0<Unit> r111 = r13;
        String r112 = "runtime_error";
        ?? r42 = 0;
    L72:
        r12.h = r42;
        z68.c r43 = z68.c.a;
        int r44 = r30.g;
        int r45 = r30.h;
        int r46 = r30.f;
        da9.e r47 = r12.u;
        if (r42 == 0) goto L75;
        String r212 = null;
    L76:
        if (r42 == 0) goto L78;
        String r213 = null;
    L79:
        r43.getClass();
        z68.c.j(r42, r44, r45, r46, r47, r212, r213);
        f2a.c r48 = r12.D.b("ScreenShareStartResult");
        r48.c.d = "AVKitScreenManager.startScreenShare";
        String r49 = r12.E;
        if (r49 == null) goto L82;
        List r50 = CollectionsKt.listOf(r49);
    L83:
        r48.c.b = r50;
        r48.f(new x68.m(r42));
        f2a.c.c(r48, null, 15);
        if (r42 == 0) goto L127;
    L91:
        r110 = r42;
        goto L111
    L127:
        Result.Companion r51 = Result.Companion;     // Catch: Throwable -> L87
        r5.o(new com.larus.im.service.audio.e1(r30.i));     // Catch: Throwable -> L87
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L87
    L89:
        if (r111 == null) goto L91;
        r111.invoke();
    L87:
        th = move-exception;
        Result.Companion r52 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L89
    L82:
        r50 = null;
        goto L83
    L78:
        r213 = "external_capture_start_failed";
        goto L79
    L75:
        r212 = r112;
        goto L76
    L119:
        r112 = "runtime_error";
        StringBuilder r113 = new StringBuilder("screen_share_");     // Catch: Exception -> L63
        r111 = r13;
        r113.append(System.currentTimeMillis());     // Catch: Exception -> L61
        r18 = "RealtimeScreenSharePlugin.startScreenShare";
        da9.d r114 = new da9.d(r113.toString(), r12.u, new da9.f(r40, new da9.c(CloudControlInf.TEMPLATE, r38, r39)));     // Catch: Exception -> L51
        String r53 = r114.a;     // Catch: Exception -> L51
        r12.E = r53;     // Catch: Exception -> L51
        z68.c r54 = z68.c.a;     // Catch: Exception -> L51
        da9.e r115 = r114.b;     // Catch: Exception -> L51
        r54.getClass();     // Catch: Exception -> L51
        z68.c.a(r53, r38, r39, r40, r115);     // Catch: Exception -> L51
        da9.e r55 = r114.b;     // Catch: Exception -> L51
        ?? r56 = RangesKt.coerceAtLeast(r114.c.a, 1);     // Catch: Exception -> L51
        r12.j = RangesKt.coerceAtLeast(1000 / ((long) RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r55.b, 1), r56)), 1);     // Catch: Exception -> L51
        Object r57 = r12.w;     // Catch: Exception -> L51
        monitor-enter(r57);     // Catch: Exception -> L51
        r12.k = 0;     // Catch: Throwable -> L55
        r12.l = 0;     // Catch: Throwable -> L55
        r12.m = null;     // Catch: Throwable -> L55
        r12.n = null;     // Catch: Throwable -> L55
        r56 = Unit.INSTANCE;     // Catch: Throwable -> L55
        monitor-exit(r57);     // Catch: Exception -> L51
        long r116 = SystemClock.elapsedRealtime();     // Catch: Exception -> L51
        r12.o = r116;     // Catch: Exception -> L51
        r12.p = r116;     // Catch: Exception -> L51
        ((LinkedHashMap) r12.q).clear();     // Catch: Exception -> L51
        r12.r = false;     // Catch: Exception -> L53
        x68.u.c r58 = r12.s;     // Catch: Exception -> L51
        r58.a = 0;     // Catch: Exception -> L51
        r58.b = 0;     // Catch: Exception -> L51
        r58.c = 0;     // Catch: Exception -> L51
        r58.d = 0;     // Catch: Exception -> L51
        r58.e = 0;     // Catch: Exception -> L51
        r58.f = 0;     // Catch: Exception -> L51
        r58.g = 0;     // Catch: Exception -> L51
        r58.h = 0;     // Catch: Exception -> L51
        r12.p = r116;     // Catch: Exception -> L51
        x68.u.c r59 = r12.t;     // Catch: Exception -> L51
        r59.a = 0;     // Catch: Exception -> L51
        r59.b = 0;     // Catch: Exception -> L51
        r59.c = 0;     // Catch: Exception -> L51
        r59.d = 0;     // Catch: Exception -> L51
        r59.e = 0;     // Catch: Exception -> L51
        r59.f = 0;     // Catch: Exception -> L51
        r59.g = 0;     // Catch: Exception -> L51
        r59.h = 0;     // Catch: Exception -> L51
        r12.x.set(true);     // Catch: Exception -> L51
        f2a.c r60 = r12.D.b("ScreenShareStartResult");     // Catch: Exception -> L51
        r60.c.d = "AVKitScreenManager.innerStartScreenShare";     // Catch: Exception -> L51
        r60.c.b = CollectionsKt.listOf(r114.a);     // Catch: Exception -> L51
        r60.f(new x68.f(r114, r40, r12));     // Catch: Exception -> L51
        f2a.c.c(r60, null, 15);     // Catch: Exception -> L51
        r12.F = false;     // Catch: Exception -> L59
        ((ba9.a) r12.e.getValue()).d(r37, r114);     // Catch: Exception -> L59
        r12.f = true;     // Catch: Exception -> L59
        r12.h();     // Catch: Exception -> L59
        r12.a().removeCallbacks(r12.B);     // Catch: Exception -> L59
        if (r12.x.get() == false) goto L50;
        r12.a().postDelayed(r12.B, AutoEndConversationTime.AFTER_10_SECONDS);     // Catch: Exception -> L59
    L50:
        r42 = 1;
    L53:
        e = e;
    L52:
        r56 = 0;
    L67:
        r12.b(true);
        r12.j();
        f2a.c r61 = r12.D.a("ScreenShareCaptureException");
        r61.c.d = "AVKitScreenManager.innerStartScreenShare";
        String r62 = r12.E;
        if (r62 == null) goto L70;
        List r63 = CollectionsKt.listOf(r62);
    L71:
        r61.c.b = r63;
        r61.f(new x68.g(e));
        f2a.c.c(r61, null, 15);
        r42 = r56;
        goto L72
    L70:
        r63 = null;
        goto L71
    L59:
        e = e;
    L55:
        th = move-exception;
        throw th;     // Catch: Exception -> L59
    L51:
        e = e;
    L61:
        e = e;
        r18 = "RealtimeScreenSharePlugin.startScreenShare";
    L63:
        e = e;
        r18 = "RealtimeScreenSharePlugin.startScreenShare";
        r111 = r13;
    L65:
        e = e;
        r18 = "RealtimeScreenSharePlugin.startScreenShare";
        r111 = r13;
        r112 = "runtime_error";
    L22:
        e = move-exception;
        z68.c r117 = z68.c.a;
        int r118 = r30.g;
        int r64 = r30.h;
        int r65 = r30.f;
        da9.e r66 = r12.u;
        r117.getClass();
        z68.c.j(false, r118, r64, r65, r66, "runtime_error", "external_capture_prepare_failed");
        f2a.c r67 = r12.D.a("ScreenShareStartResult");
        r67.c.d = "AVKitScreenManager.startScreenShare";
        r67.f(new x68.l(e));
        f2a.c.c(r67, null, 15);
        r4 = false;
        goto L24
    L112:
        r18 = "RealtimeScreenSharePlugin.startScreenShare";
        Function0<Unit> r68 = r1.l;
        if (r68 == null) goto L115;
        r68.invoke();
        goto L115
    }

    @Override // com.larus.voicecall.impl.plugins.u2
    public final void z0(com.larus.voicecall.impl.component.vlm.p r1) {
        this.l = r1;
    }

    @Override // com.larus.voicecall.impl.plugins.u2
    public final void n0(final boolean r10, final com.larus.im.service.audio.e1 r11) {
        Intrinsics.checkNotNullParameter(r11, "config");
        FLogger.a.i(this.g, "stopScreenShare ");
        f2a.c r1 = this.i.b("ScreenShareStop");
        r1.c.d = "RealtimeScreenSharePlugin.stopScreenShare";
        r1.f(new l2(r10, r11));
        f2a.c.c(r1, null, 15);
        this.n = false;
        com.larus.audio.call.arch.c r5 = getContext();
        Intrinsics.checkNotNullParameter(r5, "<this>");
        com.larus.audio.call.plugins.w0 r6 = r5.c(Reflection.getOrCreateKotlinClass(com.larus.audio.call.plugins.w0.class), null);
        if (r6 == null) goto L5;
        r6.S();
    L5:
        if (r10 == false) goto L9;
        id9.d r12 = ((r) getContext()).j();
        if (r12 == null) goto L9;
        r12.m(ModalType.AUDIO, TargetVideoSourceType.VIDEO_SOURCE_DEFAULT);
    L9:
        x68.u r13 = this.h;
        if (r13 == null) goto L57;
        Intrinsics.checkNotNullParameter(r11, "config");
        f2a.c r0 = r13.D.b("ScreenShareStop");
        r0.c.d = "AVKitScreenManager.stopScreenShare(config)";
        String r7 = r13.E;
        if (r7 == null) goto L14;
        List r8 = CollectionsKt.listOf(r7);
    L15:
        r0.c.b = r8;
        r0.f(new x68.d(r11, r13));
        f2a.c.c(r0, null, 15);
        if (r13.h == false) goto L51;
        if (r13.g == false) goto L20;
    L70:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L47
        com.larus.im.service.audio.y r3 = (com.larus.im.service.audio.y) r13.b.invoke();     // Catch: Throwable -> L47
        if (r3 == null) goto L44;
        r3.s(false);     // Catch: Throwable -> L47
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L47
    L45:
        Result.constructor-impl(r4);     // Catch: Throwable -> L47
    L49:
        r13.h = false;
        goto L51
    L44:
        r4 = null;
    L47:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L49
    L20:
        if (r13.f == false) goto L70;
        f2a.c r14 = r13.D.b("ScreenShareStop");
        r14.c.d = "AVKitScreenManager.stopScreenShare";
        String r15 = r13.E;
        if (r15 == null) goto L25;
        List r16 = CollectionsKt.listOf(r15);
    L26:
        r14.c.b = r16;
        r14.f(new x68.j(r13));
        f2a.c.c(r14, null, 15);
        r13.g = true;
        ((ba9.a) r13.e.getValue()).b(StopReason.USER_STOP);     // Catch: Throwable -> L30 Exception -> L32
        r13.F = false;
        r13.i();
        r13.j();
        r13.a().removeCallbacks(r13.C);
        r13.f = false;
        r13.i = false;
        r13.g = false;
        r13.E = null;
        r13.v = r13.u.b;
        z68.c.a.getClass();
    L29:
        z68.c.b();
        goto L70
    L30:
        th = move-exception;
        r13.F = false;
        r13.i();
        r13.j();
        r13.a().removeCallbacks(r13.C);
        r13.f = false;
        r13.i = false;
        r13.g = false;
        r13.E = null;
        r13.v = r13.u.b;
        z68.c.a.getClass();
        z68.c.b();
        throw th;
    L32:
        e = move-exception;
        z68.c.a.getClass();     // Catch: Throwable -> L30
        z68.c.f("system_error", "runtime_error", "stop_capture_failed", false);     // Catch: Throwable -> L30
        f2a.c r17 = r13.D.a("ScreenShareCaptureException");     // Catch: Throwable -> L30
        r17.c.d = "AVKitScreenManager.stopScreenShare";     // Catch: Throwable -> L30
        String r18 = r13.E;     // Catch: Throwable -> L30
        if (r18 == null) goto L36;
        List r19 = CollectionsKt.listOf(r18);     // Catch: Throwable -> L30
    L37:
        r17.c.b = r19;     // Catch: Throwable -> L30
        r17.f(new x68.k(e));     // Catch: Throwable -> L30
        f2a.c.c(r17, null, 15);     // Catch: Throwable -> L30
        r13.F = false;
        r13.i();
        r13.j();
        r13.a().removeCallbacks(r13.C);
        r13.f = false;
        r13.i = false;
        r13.g = false;
        r13.E = null;
        r13.v = r13.u.b;
        goto L29
    L36:
        r19 = null;
        goto L37
    L25:
        r16 = null;
    L51:
        if (r13.i == false) goto L53;
        r13.a().removeCallbacks(r13.C);
        r13.i = false;
        r13.E = null;
        r13.v = r13.u.b;
        z68.c.a.getClass();
        z68.c.b();
    L53:
        com.larus.im.service.audio.y r110 = (com.larus.im.service.audio.y) r13.b.invoke();
        if (r110 == null) goto L57;
        r110.o(r11);
        goto L57
    L14:
        r8 = null;
    L57:
        if (this.f.get() == false) goto L59;
        this.h = null;
    L59:
        a1 r111 = s.a((r) getContext());
        if (r111 == null) goto L62;
        r111.K1("voice_call");
    L62:
        Lazy r112 = MediaResourceManager.a;
        if (MediaResourceManager.i("SYSTEM") == false) goto L72;
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.h() == false) goto L73;
        ((r) getContext()).n().J(((r) getContext()).params());
        return;
    L73:
        return;
    }
}
