package com.larus.voicecall.impl;

import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.arch.LLMCallController;
import com.larus.audio.call.f;
import com.larus.audio.call.mgr.AVKitDuplexState;
import com.larus.audio.call.mgr.MajorState;
import com.larus.audio.call.plugins.t0;
import com.larus.bmhome.actionbar.model.l0;
import com.larus.call_plugins_doubao_common.i;
import com.larus.im.service.audio.a1;
import com.larus.im.service.audio.z0;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.plugins.i1;
import com.larus.voicecall.impl.plugins.o1;
import com.larus.voicecall.impl.plugins.r;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.v0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class RealtimeCallService extends com.larus.audio.call.a implements t1a.c {
    public static final /* synthetic */ int C = 0;
    public Job A;
    public com.larus.audio.call.k B;
    public Function0<? extends CoroutineScope> s;
    public RealtimeCallParam t;
    public final x u;
    public Job v;
    public final Lazy w;
    public final Lazy x;
    public final d y;
    public Job z;

    public final class a extends com.larus.audio.call.arch.a<r> {
        public final String f;
        public final /* synthetic */ RealtimeCallService g;

        /* JADX INFO: renamed from: com.larus.voicecall.impl.RealtimeCallService$a$a, reason: collision with other inner class name */
        public static final class C0012a implements com.larus.im.service.audio.v {
            public final String a;
            public final /* synthetic */ RealtimeCallService b;

            public final String getName() {
                return this.a;
            }

            public C0012a(a r1, RealtimeCallService r2) {
                this.b = r2;
                this.a = r1.f;
            }

            public final void O1(jd9.c r2, jd9.c r3) {
                Intrinsics.checkNotNullParameter(r2, "oldState");
                Intrinsics.checkNotNullParameter(r3, "newState");
                com.larus.audio.call.k r4 = this.b.B;
                if (r4 == null) goto L6;
                r4.I6(r3);
                return;
            }
        }

        public static final class b extends a1 {
            public final String a;
            public final /* synthetic */ a b;
            public final /* synthetic */ RealtimeCallService c;

            public final String g() {
                return this.a;
            }

            public final void n(z0.a r2) {
                Intrinsics.checkNotNullParameter(r2, "event");
                com.larus.audio.call.k r0 = this.c.B;
                if (r0 == null) goto L6;
                r0.D9(r2);
                return;
            }

            public b(a r1, RealtimeCallService r2) {
                this.b = r1;
                this.c = r2;
                this.a = r1.f;
            }

            public final void q(String r5, Object r6) {
                Intrinsics.checkNotNullParameter(r5, "event");
                Intrinsics.checkNotNullParameter(r5, "event");
                FLogger.a.i(this.b.f, "otherEvent happen event=" + r5 + " linkCallback=" + this.c.B);
                com.larus.audio.call.k r0 = this.c.B;
                if (r0 == null) goto L6;
                r0.z2(r5, r6);
                return;
            }
        }

        public final com.larus.im.service.audio.v R2() {
            return new C0012a(this, this.g);
        }

        public final z0 S2() {
            return new b(this, this.g);
        }

        public final String T2() {
            return this.f;
        }

        public a(RealtimeCallService r2, r r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            this.g = r2;
            super(r3);
            this.f = "BridgePlugin";
        }
    }

    public static final class b {
    }

    public final class c implements q {
        public final /* synthetic */ RealtimeCallService a;

        @Override // com.larus.voicecall.impl.q
        public final void e() {
            Function0 r0 = ((com.larus.audio.call.a) this.a).q;
            if (r0 == null) goto L6;
            r0.invoke();
            return;
        }

        @Override // com.larus.voicecall.impl.q
        public final void h() {
            Function0 r0 = ((com.larus.audio.call.a) this.a).b;
            if (r0 == null) goto L6;
            r0.invoke();
            return;
        }

        @Override // com.larus.voicecall.impl.q
        public final void onReconnect() {
            Function0 r0 = ((com.larus.audio.call.a) this.a).f;
            if (r0 == null) goto L6;
            r0.invoke();
            return;
        }

        @Override // com.larus.voicecall.impl.q
        public final void onReconnected() {
            Function0 r0 = ((com.larus.audio.call.a) this.a).e;
            if (r0 == null) goto L6;
            r0.invoke();
            return;
        }

        public c(RealtimeCallService r1) {
            this.a = r1;
        }

        @Override // com.larus.voicecall.impl.q
        public final void a(r58.d r2) {
            Intrinsics.checkNotNullParameter(r2, LynxResourceModule.DATA_KEY);
            Function1 r0 = ((com.larus.audio.call.a) this.a).h;
            if (r0 == null) goto L6;
            r0.invoke(r2);
            return;
        }

        @Override // com.larus.voicecall.impl.q
        public final void b(c0 r5) {
            Intrinsics.checkNotNullParameter(r5, "request");
            if (f.f() == true) goto L5;
            return;
        L5:
            AVKitDuplexState r0 = this.a.i();
            String r1 = this.a.t.e;
            if (r1 != null) goto L9;
            r1 = NameKeys.UnloadStrategy_No_Strategy;
        L9:
            if (f0.b(r5, r1, r0) == true) goto L13;
            FLogger.a.w("RealtimeCallService", "onRetryRequested ignored stale request, callId=" + r5.a);
            return;
        L13:
            if (((com.larus.voicecall.impl.d) this.a.x.getValue()).a(r0) == null) goto L15;
            RealtimeCallService r2 = this.a;
            r2.u.T(r2.t);
        L15:
            Object r3 = ((d0) this.a.w.getValue()).a.trySend-JP2dKIU(r5);
            kotlinx.coroutines.channels.g.c r4 = kotlinx.coroutines.channels.g.b;
            if ((!(r3 instanceof kotlinx.coroutines.channels.g.c)) == true) goto L19;
            FLogger.a.e("RealtimeCallService", "onRetryRequested failed, callId=" + r5.a);
            return;
        }

        @Override // com.larus.voicecall.impl.q
        public final void c(long r2) {
            Function1 r0 = ((com.larus.audio.call.a) this.a).p;
            if (r0 == null) goto L6;
            r0.invoke(Long.valueOf(r2));
            return;
        }

        @Override // com.larus.voicecall.impl.q
        public final void d(String r2) {
            Intrinsics.checkNotNullParameter(r2, "endMethod");
            Function1 r0 = ((com.larus.audio.call.a) this.a).g;
            if (r0 == null) goto L6;
            r0.invoke(r2);
            return;
        }

        @Override // com.larus.voicecall.impl.q
        public final void f(String r2) {
            Intrinsics.checkNotNullParameter(r2, "id");
            Function1 r0 = ((com.larus.audio.call.a) this.a).a;
            if (r0 == null) goto L6;
            r0.invoke(r2);
            return;
        }

        @Override // com.larus.voicecall.impl.q
        public final void g(byte[] r2) {
            Intrinsics.checkNotNullParameter(r2, LynxResourceModule.DATA_KEY);
            Function1 r0 = ((com.larus.audio.call.a) this.a).i;
            if (r0 == null) goto L6;
            r0.invoke(r2);
            return;
        }
    }

    public static final class d implements com.larus.audio.call.mgr.f.a {
        public final /* synthetic */ RealtimeCallService a;

        public d(RealtimeCallService r1) {
            this.a = r1;
        }

        public final void Q(MajorState r2, MajorState r3) {
            Intrinsics.checkNotNullParameter(r2, "prev");
            Intrinsics.checkNotNullParameter(r3, "current");
            if ((r3 instanceof MajorState.f) == false) goto L6;
            RealtimeCallService r4 = this.a;
            r4.u.T(r4.t);
            return;
        }
    }

    static {
    }

    public final void b() {
        this.u.L();
        Job r0 = this.v;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.v = null;
        this.B = null;
    }

    public final void c() {
        FLogger.a.i("RealtimeCallService", "releaseMediaFocusSync");
        com.larus.voicecall.impl.plugins.q r0 = (com.larus.voicecall.impl.plugins.q) LLMCallController.y(this.u, Reflection.getOrCreateKotlinClass(com.larus.voicecall.impl.plugins.q.class));
        if (r0 == null) goto L6;
        r0.p();
        return;
    }

    public final i j() {
        return LLMCallController.w(this.u, Reflection.getOrCreateKotlinClass(i.class));
    }

    public final t0 k() {
        return LLMCallController.w(this.u, Reflection.getOrCreateKotlinClass(t0.class));
    }

    public final com.larus.call_plugins_doubao_common.j l() {
        return LLMCallController.w(this.u, Reflection.getOrCreateKotlinClass(com.larus.call_plugins_doubao_common.j.class));
    }

    public final com.larus.audio.call.plugins.z0 n() {
        return LLMCallController.w(this.u, Reflection.getOrCreateKotlinClass(com.larus.audio.call.plugins.z0.class));
    }

    public final com.larus.audio.call.mgr.f o() {
        return LLMCallController.w(this.u, Reflection.getOrCreateKotlinClass(com.larus.audio.call.mgr.f.class));
    }

    public final com.larus.voicecall.impl.plugins.u p() {
        return (com.larus.voicecall.impl.plugins.u) LLMCallController.w(this.u, Reflection.getOrCreateKotlinClass(com.larus.voicecall.impl.plugins.u.class));
    }

    public final com.larus.voicecall.impl.plugins.n q() {
        return (com.larus.voicecall.impl.plugins.n) LLMCallController.w(this.u, Reflection.getOrCreateKotlinClass(com.larus.voicecall.impl.plugins.n.class));
    }

    public final com.larus.audio.call.mgr.f r() {
        return LLMCallController.w(this.u, Reflection.getOrCreateKotlinClass(com.larus.audio.call.mgr.f.class));
    }

    public final com.larus.audio.call.plugins.a1 w() {
        return LLMCallController.y(this.u, Reflection.getOrCreateKotlinClass(com.larus.audio.call.plugins.a1.class));
    }

    public final i1 x() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        return (i1) LLMCallController.y(this.u, Reflection.getOrCreateKotlinClass(i1.class));
    L4:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Throwable r2 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
        if (r2 == null) goto L13;
        FLogger.a.e("RealtimeCallService", "traceApi get plugin failed", r2);
        return null;
    L13:
        return null;
    }

    public final o1 z() {
        return (o1) LLMCallController.y(this.u, Reflection.getOrCreateKotlinClass(o1.class));
    }

    public final MajorState h() {
        return r().s1();
    }

    public final AVKitDuplexState i() {
        return (AVKitDuplexState) r().y().getValue();
    }

    public final Flow<com.larus.voicecall.impl.c> m() {
        kotlinx.coroutines.flow.i1 r0 = r().y();
        b1 r1 = k().t0();
        Intrinsics.checkNotNullParameter(r0, "duplex");
        Intrinsics.checkNotNullParameter(r1, "muted");
        return e.n(new v0(r0, r1, new DuplexControlStateKt$duplexControlStates$1(null)));
    }

    public static void s(RealtimeCallParam r7) {
        if (z2.a.getRealtimeCallTranslatorConfig().c() == false) goto L6;
        ouc.d0 r0 = r7.q;
        ouc.e0 r1 = new ouc.e0();
        ouc.j.c(r1, "interpret_asr_signal", "1");
        Unit r2 = Unit.INSTANCE;
        ouc.d0 r3 = com.larus.audio.call.util.l.a(r0, r1.a());
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r7.q = r3;
    L6:
        if (u3a.f.e() == false) goto L63;
        FLogger.a.d("RealtimeCallService", "retry call with ast config in interpret scene");
        String r4 = u3a.f.c();
        String r5 = u3a.f.d();
        Object r6 = u3a.f.b();
        Object r8 = null;
        if (Result.isFailure-impl(r6) == false) goto L10;
        r6 = null;
    L10:
        l0 r9 = (l0) r6;
        if (r9 == null) goto L16;
        com.larus.bmhome.actionbar.model.h r10 = r9.b;
        if (r10 == null) goto L16;
        List r11 = r10.e;
        if (r11 == null) goto L16;
    L17:
        List r12 = r11;
        Object r13 = u3a.f.b();
        if (Result.isFailure-impl(r13) == false) goto L20;
        r13 = null;
    L20:
        l0 r14 = (l0) r13;
        if (r14 == null) goto L27;
        com.larus.bmhome.actionbar.model.h r15 = r14.a;
        if (r15 == null) goto L27;
        List r16 = r15.e;
        if (r16 == null) goto L27;
        List r17 = r16;
    L28:
        List r18 = CollectionsKt.plus(r12, r17);
        Iterator r19 = r18.iterator();
    L30:
        if (r19.hasNext() == false) goto L34;
        Object r20 = r19.next();
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.w) r20).k, r4) == false) goto L30;
    L35:
        com.larus.bmhome.actionbar.model.w r21 = (com.larus.bmhome.actionbar.model.w) r20;
        Iterator r22 = r18.iterator();
    L37:
        if (r22.hasNext() == false) goto L41;
        Object r23 = r22.next();
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.w) r23).k, r5) == false) goto L37;
        r8 = r23;
    L41:
        com.larus.bmhome.actionbar.model.w r24 = (com.larus.bmhome.actionbar.model.w) r8;
        boolean r25 = false;
        if (r21 == null) goto L44;
        boolean r26 = Intrinsics.areEqual(r21.n, Boolean.TRUE);
    L45:
        if (r26 == false) goto L55;
        if (r24 == null) goto L48;
        r25 = Intrinsics.areEqual(r24.n, Boolean.TRUE);
    L48:
        if (r25 == false) goto L55;
        Boolean r27 = r21.p;
        Boolean r28 = Boolean.TRUE;
        if (Intrinsics.areEqual(r27, r28) == false) goto L53;
        r4 = r21.k + r24.k;
        r5 = r21.k + r24.k;
        goto L55
    L53:
        if (Intrinsics.areEqual(r24.p, r28) == false) goto L55;
        r4 = r24.k + r21.k;
        r5 = r24.k + r21.k;
    L55:
        r7.j.a = CollectionsKt.listOf(new RealtimeCallParam.a("0", r4, r5, 1));
        return;
    L44:
        r26 = false;
        goto L45
    L34:
        r20 = null;
    L27:
        r17 = CollectionsKt.emptyList();
    L16:
        r11 = CollectionsKt.emptyList();
        goto L17
    }

    public final void a(RealtimeCallParam r3) {
        Intrinsics.checkNotNullParameter(r3, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r3, LynxResourceModule.PARAMS_KEY);
        FLogger.a.i("RealtimeCallService", "interruptAsr");
        k().d0();
    }

    public final void d(RealtimeCallParam r8) {
        Intrinsics.checkNotNullParameter(r8, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r8, LynxResourceModule.PARAMS_KEY);
        this.t = r8;
        s(r8);
        LLMCallController.S(this.u, r8);
        FLogger.a.j("Realtime call", "startCall");
        com.larus.platform.service.g.a.e("REALTIME_CALL");
        Job r0 = null;
        if (this.v != null) goto L12;
        Function0<? extends CoroutineScope> r9 = this.s;
        if (r9 == null) goto L9;
        CoroutineScope r1 = (CoroutineScope) r9.invoke();
        if (r1 == null) goto L9;
        Job r10 = BuildersKt.launch$default(r1, null, null, new RealtimeCallService$start$1(this, null), 3, null);
    L10:
        this.v = r10;
    L9:
        r10 = null;
    L12:
        if (this.A != null) goto L21;
        Function0<? extends CoroutineScope> r11 = this.s;
        if (r11 == null) goto L18;
        CoroutineScope r2 = (CoroutineScope) r11.invoke();
        if (r2 == null) goto L18;
        Job r12 = BuildersKt.launch$default(r2, null, null, new RealtimeCallService$start$2(this, null), 3, null);
    L19:
        this.A = r12;
    L18:
        r12 = null;
    L21:
        if (f.f() == false) goto L32;
        Job r13 = this.z;
        if (r13 != null) goto L25;
    L26:
        Function0<? extends CoroutineScope> r14 = this.s;
        if (r14 == null) goto L31;
        CoroutineScope r3 = (CoroutineScope) r14.invoke();
        if (r3 == null) goto L31;
        r0 = BuildersKt.launch$default(r3, null, null, new RealtimeCallService$start$3(this, null), 3, null);
    L31:
        this.z = r0;
        return;
    L25:
        if (r13.isActive() == false) goto L26;
        return;
    L32:
        o().M0(this.y);
    }

    public final void e(RealtimeCallParam r3) {
        Intrinsics.checkNotNullParameter(r3, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r3, LynxResourceModule.PARAMS_KEY);
        this.u.T(r3);
        Job r4 = this.A;
        if (r4 == null) goto L5;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);
    L5:
        this.A = null;
        if (f.f() == true) goto L8;
        o().V(this.y);
    L8:
        com.larus.platform.service.g.a.g("REALTIME_CALL");
        FLogger.a.j("Realtime call", "Realtime call stop");
    }

    public final void g(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tosKey");
        j().updateScreenshotForAsr(r2);
    }

    public final void u(RealtimeCallParam r4) {
        Intrinsics.checkNotNullParameter(r4, "param");
        Intrinsics.checkNotNullParameter(r4, "param");
        FLogger.a.d("RealtimeCallService", "resume");
        MajorState.g r0 = h();
        if ((r0 instanceof MajorState.g) == false) goto L5;
        MajorState r1 = r0.c;
    L6:
        f(r1, 8);
        this.u.M(r4);
        return;
    L5:
        r1 = new MajorState.d(MajorState.From.RESUME, MajorState.InterruptType.NOTHING);
        goto L6
    }

    public final void v(RealtimeCallParam r2) {
        Intrinsics.checkNotNullParameter(r2, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r2, LynxResourceModule.PARAMS_KEY);
        s(r2);
        this.u.N(r2);
    }

    public final void y(String r3) {
        Intrinsics.checkNotNullParameter(r3, "source");
        j().r1("RealtimeCallService_".concat(r3), MapsKt.emptyMap());
    }

    public final void t(RealtimeCallParam r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "callParam");
        Intrinsics.checkNotNullParameter(r3, "callParam");
        LLMCallController.D(this.u, r3, r4, 4);
        FLogger.a.j("Realtime call", "Realtime call onInterrupt isInterruptForStreamFinished=" + r4);
    }

    public /* synthetic */ RealtimeCallService(b78.c r8, com.larus.voicecall.impl.tracer.q r9, Function0 r10, Function2 r11) {
        this(r8, r9, r10, false, false, r11);
    }

    public RealtimeCallService(b78.c r8, com.larus.voicecall.impl.tracer.q r9, Function0<? extends CoroutineScope> r10, boolean r11, boolean r12, Function2<? super r, ? super com.larus.audio.call.arch.d<r>, Unit> r13) {
        Intrinsics.checkNotNullParameter(r8, "sessionCreator");
        Intrinsics.checkNotNullParameter(r9, "traceSpan");
        Intrinsics.checkNotNullParameter(r10, "lifecycleScope");
        this.s = r10;
        this.t = new RealtimeCallParam();
        x r14 = new x(r8, r9, this.s, r11, r12, new y(r13, this));
        r14.z = new c(this);
        this.u = r14;
        this.w = LazyKt.lazy(new z());
        this.x = LazyKt.lazy(new a0());
        this.y = new d(this);
    }
}
