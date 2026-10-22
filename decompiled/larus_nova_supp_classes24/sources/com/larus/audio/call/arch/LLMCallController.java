package com.larus.audio.call.arch;

import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.arch.c;
import com.larus.audio.call.mgr.MajorState;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.im.internal.audio.ability.SessionReleaseReason;
import com.larus.im.service.audio.cmd.TriggerMode;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.CharsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class LLMCallController<C extends c> {
    public final b78.c b;
    public final com.larus.audio.call.tracer.b c;
    public final Function0<CoroutineScope> d;
    public final Lazy e;
    public RealtimeCallParam f;
    public id9.d g;
    public boolean h;
    public final m i;
    public final n j;
    public final Lazy k;
    public volatile boolean l;
    public final ExecutorCoroutineDispatcher m;
    public Job n;
    public volatile boolean o;
    public final buc.a p;
    public final CompletableJob q;
    public final CoroutineScope r;
    public final Lazy s;
    public final buc.d t;
    public boolean u;

    public class a implements c {
        public final /* synthetic */ LLMCallController<C> a;

        @Override // com.larus.audio.call.arch.c
        public final com.larus.audio.call.mgr.f a() {
            return this.a.z();
        }

        @Override // com.larus.audio.call.arch.c
        public final com.larus.audio.call.tracer.b i() {
            return this.a.c;
        }

        @Override // com.larus.audio.call.arch.c
        public final id9.d j() {
            return this.a.g;
        }

        @Override // com.larus.audio.call.arch.c
        public final IRealtimeCallTracer k() {
            return this.a.B();
        }

        @Override // com.larus.audio.call.arch.c
        public final RealtimeCallParam params() {
            return this.a.f;
        }

        @Override // com.larus.audio.call.arch.c
        public final CoroutineScope r() {
            Function0<CoroutineScope> r0 = this.a.d;
            if (r0 != null) goto L7;
            return null;
        L7:
            return (CoroutineScope) r0.invoke();
        }

        @Override // com.larus.audio.call.arch.c
        public final LLMCallController<C> n() {
            return this.a;
        }

        public a(LLMCallController r1) {
            this.a = r1;
        }

        @Override // com.larus.audio.call.arch.c
        public final <T extends e> T b(KClass<T> r1, com.larus.audio.call.arch.a<?> r2) {
            Intrinsics.checkNotNullParameter(r1, "clazz");
            return (T) this.a.x().d(r1);
        }

        @Override // com.larus.audio.call.arch.c
        public final <T extends e> T c(KClass<T> r1, com.larus.audio.call.arch.a<?> r2) {
            Intrinsics.checkNotNullParameter(r1, "clazz");
            return (T) this.a.x().e(r1);
        }
    }

    public static abstract class b {

        public static final class a extends b {
            public final LifecycleStage a;
            public final String b;
            public final Throwable c;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof a) == true) goto L8;
                return false;
            L8:
                a r6 = (a) r5;
                if (this.a == r6.a) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
                return false;
            L17:
                return true;
            }

            public final int hashCode() {
                return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
            }

            public final String toString() {
                return "Fail(stage=" + this.a + ", reason=" + this.b + ", throwable=" + this.c + ')';
            }

            public a(LifecycleStage r2, String r3, Throwable r4) {
                Intrinsics.checkNotNullParameter(r2, "stage");
                Intrinsics.checkNotNullParameter(r3, "reason");
                Intrinsics.checkNotNullParameter(r4, "throwable");
                this.a = r2;
                this.b = r3;
                this.c = r4;
            }
        }

        /* JADX INFO: renamed from: com.larus.audio.call.arch.LLMCallController$b$b, reason: collision with other inner class name */
        public static final class C0079b extends b {
            public final LifecycleStage a;
            public final String b;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof C0079b) == true) goto L8;
                return false;
            L8:
                C0079b r6 = (C0079b) r5;
                if (this.a == r6.a) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                return (this.a.hashCode() * 31) + this.b.hashCode();
            }

            public final String toString() {
                return "Skip(stage=" + this.a + ", reason=" + this.b + ')';
            }

            public C0079b(LifecycleStage r2, String r3) {
                Intrinsics.checkNotNullParameter(r2, "stage");
                Intrinsics.checkNotNullParameter(r3, "reason");
                this.a = r2;
                this.b = r3;
            }
        }

        public static final class c extends b {
            public final LifecycleStage a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof c) == true) goto L9;
                return false;
            L9:
                if (this.a == ((c) r4).a) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "Success(stage=" + this.a + ')';
            }

            public c(LifecycleStage r2) {
                Intrinsics.checkNotNullParameter(r2, "stage");
                this.a = r2;
            }
        }

        public b() {
        }
    }

    public abstract String A();

    public abstract IRealtimeCallTracer B();

    public abstract C K();

    public abstract void p(c r1, k0 r2);

    public final u u() {
        return (u) this.s.getValue();
    }

    public final String v() {
        return (String) this.e.getValue();
    }

    public final k0<C> x() {
        return (k0) this.k.getValue();
    }

    public final CompletableDeferred I() {
        if (O() == false) goto L6;
        H("before_stop_async");
        return u().a(LifecycleStage.BEFORE_STOP, new LLMCallController$onBeforeStop$1(this, null));
    L6:
        k0<C> r0 = x();
        r0.getClass();
        r0.b("onBeforeStop", new z());
        return CompletableDeferredKt.CompletableDeferred(new b.c(LifecycleStage.BEFORE_STOP));
    }

    public Deferred<b> L() {
        if (O() == true) goto L5;
        k0<C> r0 = x();
        r0.getClass();
        r0.b("onRelease", new d0());
        this.o = true;
        Job.DefaultImpls.cancel$default(this.q, null, 1, null);
        return CompletableDeferredKt.CompletableDeferred(new b.c(LifecycleStage.RELEASE));
    L5:
        if (this.p.a(false, true) == false) goto L7;
        H("release_async");
        CompletableDeferred r1 = u().a(LifecycleStage.RELEASE, new LLMCallController$release$releaseResult$1(this, null));
        r1.invokeOnCompletion(new j(this));
        return r1;
    L7:
        return CompletableDeferredKt.CompletableDeferred(new b.C0079b(LifecycleStage.RELEASE, "TERMINATED"));
    }

    public boolean O() {
        return com.larus.audio.call.f.d().E;
    }

    public boolean P() {
        return com.larus.audio.call.f.d().D;
    }

    public final com.larus.audio.call.mgr.f z() {
        k0<C> r0 = x();
        KClass r1 = Reflection.getOrCreateKotlinClass(com.larus.audio.call.mgr.f.class);
        int r2 = k0.d;
        return (com.larus.audio.call.mgr.f) r0.d(r1);
    }

    public final boolean E(long r6) {
        if (this.p.c() == false) goto L5;
        return true;
    L5:
        if (this.t.c() == r6) goto L7;
        boolean r7 = true;
    L8:
        if (r7 == true) goto L13;
        return false;
    L13:
        return true;
    L7:
        r7 = false;
        goto L8
    }

    public final void G(RealtimeCallParam r4) {
        Intrinsics.checkNotNullParameter(r4, "param");
        this.u = true;
        k0<C> r0 = x();
        r0.getClass();
        r0.b("onMute", new c0());
        if (Intrinsics.areEqual(r4.k.t, "assistant_scene_mode_click_talk") == true) goto L8;
        id9.d r5 = this.g;
        if (r5 == null) goto L9;
        r5.p(TriggerMode.MUTE, null);
        return;
    L9:
        return;
    }

    public final long H(String r7) {
        long r0 = this.t.d();
        com.larus.audio.call.util.e.a.i(v(), "next lifecycle version=" + r0 + ", reason=" + r7);
        return r0;
    }

    public final void J(RealtimeCallParam r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        if (O() == false) goto L7;
        u().a(LifecycleStage.PAUSE, new LLMCallController$pause$1(this, null));
        return;
    L7:
        if ((z().s1() instanceof MajorState.g) == true) goto L11;
        k0<C> r5 = x();
        r5.getClass();
        r5.b("onPause", new y());
        id9.d r6 = this.g;
        if (r6 == null) goto L11;
        r6.p(TriggerMode.PAUSE, null);
    L11:
        CompletableDeferredKt.CompletableDeferred(new b.c(LifecycleStage.PAUSE));
    }

    public final void M(RealtimeCallParam r4) {
        Intrinsics.checkNotNullParameter(r4, "param");
        if (O() == false) goto L6;
        u().a(LifecycleStage.RESUME, new LLMCallController$resume$1(this, null));
        return;
    L6:
        k0<C> r5 = x();
        r5.getClass();
        r5.b("onResume", new x());
        id9.d r6 = this.g;
        if (r6 == null) goto L9;
        r6.p(TriggerMode.CONTINUE, null);
    L9:
        CompletableDeferredKt.CompletableDeferred(new b.c(LifecycleStage.RESUME));
    }

    public final void N(RealtimeCallParam r14) {
        Intrinsics.checkNotNullParameter(r14, "params");
        if (O() == true) goto L5;
        Function0<CoroutineScope> r0 = this.d;
        if (r0 == null) goto L13;
        CoroutineScope r1 = (CoroutineScope) r0.invoke();
    L14:
        CoroutineScope r2 = r1;
        if (P() == false) goto L18;
        if (r2 == null) goto L18;
        com.larus.audio.call.util.e.a.i(v(), "retry dispatch to lifecycle dispatcher");
        long r8 = H("retry");
        o("retry", r8);
        Job r15 = BuildersKt.launch$default(r2, this.m, null, new LLMCallController$retry$job$1(this, r14, r8, null), 2, null);
        this.n = r15;
        F("retry", r8, r15);
    L19:
        CompletableDeferredKt.CompletableDeferred(new b.c(LifecycleStage.RETRY));
        return;
    L18:
        long r3 = H("retry_sync");
        r(r14);
        k0<C> r4 = x();
        r4.getClass();
        r4.b("onRetry", new i0());
        q(r14, true, r3);
        goto L19
    L13:
        r1 = null;
        goto L14
    L5:
        if (this.p.c() == false) goto L8;
        CompletableDeferredKt.CompletableDeferred(new b.C0079b(LifecycleStage.RETRY, "TERMINATED"));
        return;
    L8:
        long r5 = H("retry_async");
        u().a(LifecycleStage.RETRY, new LLMCallController$retry$1(this, r14, r5, null));
    }

    public final CompletableDeferred T(RealtimeCallParam r12) {
        Intrinsics.checkNotNullParameter(r12, "params");
        if (O() == false) goto L6;
        com.larus.audio.call.util.e.a.i(v(), "on trigger stop. isAutoUplinkHangUp=" + r12.W + ". room_id=" + r12.d + " call_id=" + r12.e);
        H("stop_async");
        return u().a(LifecycleStage.STOP, new LLMCallController$stop$1(this, r12, null));
    L6:
        com.larus.audio.call.util.e.a.i(v(), "on trigger stop. isAutoUplinkHangUp=" + r12.W + ". room_id=" + r12.d + " call_id=" + r12.e);
        Function0<CoroutineScope> r0 = this.d;
        if (r0 == null) goto L9;
        CoroutineScope r5 = (CoroutineScope) r0.invoke();
    L11:
        if (P() == false) goto L14;
        if (r5 == null) goto L14;
        this.l = true;
        long r1 = H("stop");
        o("stop", r1);
        Job r13 = BuildersKt.launch$default(r5, this.m, null, new LLMCallController$stop$job$1(this, r12, null), 2, null);
        this.n = r13;
        F("stop", r1, r13);
    L16:
        return CompletableDeferredKt.CompletableDeferred(new b.c(LifecycleStage.STOP));
    L14:
        H("stop_sync");
        r(r12);
        goto L16
    L9:
        r5 = null;
        goto L11
    }

    public final void U(RealtimeCallParam r4) {
        Intrinsics.checkNotNullParameter(r4, "param");
        this.u = false;
        k0<C> r0 = x();
        r0.getClass();
        r0.b("onUnMute", new a0());
        if (Intrinsics.areEqual(r4.k.t, "assistant_scene_mode_click_talk") == true) goto L8;
        id9.d r5 = this.g;
        if (r5 == null) goto L9;
        r5.p(TriggerMode.UNMUTE, null);
        return;
    L9:
        return;
    }

    public final void r(RealtimeCallParam r4) {
        this.l = true;
        k0<C> r0 = x();
        r0.getClass();
        r0.b("onStop", new g0());
        if (r4.W == false) goto L5;
        SessionReleaseReason r5 = SessionReleaseReason.InterviewHangup;
    L6:
        id9.d r1 = this.g;
        if (r1 == null) goto L10;
        r1.C(r5);
        return;
    L10:
        return;
    L5:
        r5 = SessionReleaseReason.Normal;
        goto L6
    }

    public final void t(RealtimeCallParam r4) {
        this.l = true;
        k0<C> r0 = x();
        List r1 = CollectionsKt.toList(r0.c);
        ((ArrayList) r0.c).clear();
        k0.c("onStop", r1, new v());
        if (r4.W == false) goto L5;
        SessionReleaseReason r5 = SessionReleaseReason.InterviewHangup;
    L6:
        id9.d r2 = this.g;
        if (r2 == null) goto L9;
        r2.C(r5);
    L9:
        this.g = null;
        this.h = false;
        return;
    L5:
        r5 = SessionReleaseReason.Normal;
        goto L6
    }

    public static /* synthetic */ Deferred S(LLMCallController r1, RealtimeCallParam r2) {
        return r1.R(r2, false);
    }

    public static e w(LLMCallController r1, KClass r2) {
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "clazz");
        return r1.x().d(r2);
    }

    public static e y(LLMCallController r1, KClass r2) {
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "clazz");
        return r1.x().e(r2);
    }

    public final b.C0079b Q(LifecycleStage r2, boolean r3) {
        if (r3 == false) goto L5;
        x().f();
    L5:
        return new b.C0079b(r2, "STALE_START");
    }

    public CompletableDeferred R(RealtimeCallParam r17, boolean r19) {
        Intrinsics.checkNotNullParameter(r17, "params");
        if (O() == true) goto L5;
        Function0<CoroutineScope> r0 = this.d;
        if (r0 == null) goto L13;
        CoroutineScope r1 = (CoroutineScope) r0.invoke();
    L14:
        CoroutineScope r8 = r1;
        if (P() == false) goto L18;
        if (r8 == null) goto L18;
        com.larus.audio.call.util.e.a.i(v(), "start dispatch to lifecycle dispatcher, fromRetry=" + r19 + ", call_id: " + r17.e);
        long r10 = H("start");
        o("start", r10);
        Job r2 = BuildersKt.launch$default(r8, this.m, null, new LLMCallController$start$job$1(this, r17, r19, r10, null), 2, null);
        this.n = r2;
        F("start", r10, r2);
    L20:
        return CompletableDeferredKt.CompletableDeferred(new b.c(LifecycleStage.START));
    L18:
        q(r17, r19, H("start_sync"));
        goto L20
    L13:
        r1 = null;
        goto L14
    L5:
        if (this.p.c() == false) goto L9;
        return CompletableDeferredKt.CompletableDeferred(new b.C0079b(LifecycleStage.START, "TERMINATED"));
    L9:
        return u().a(LifecycleStage.START, new LLMCallController$start$1(this, r17, r19, H("start_async"), null));
    }

    public final void o(final String r10, final long r11) {
        Job r0 = this.n;
        if (r0 != null) goto L6;
        com.larus.audio.call.util.e.a.i(v(), "startJob cancel skipped, caller=" + r10 + ", version=" + r11 + ", reason=no_job");
        return;
    L6:
        final int r6 = r0.hashCode();
        com.larus.audio.call.util.e.a.i(v(), "startJob cancel request, caller=" + r10 + ", jobHash=" + r6 + ", version=" + r11 + ", current=" + this.t.c() + ", isActive=" + r0.isActive() + ", isCancelled=" + r0.isCancelled() + ", isCompleted=" + r0.isCompleted());
        r0.invokeOnCompletion(new f(this, r10, r6, r11));
        StringBuilder r3 = new StringBuilder("cancel by ");
        r3.append(r10);
        r3.append(", version=");
        r3.append(r11);
        r0.cancel(new CancellationException(r3.toString()));
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.larus.audio.call.arch.m] */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.larus.audio.call.arch.n] */
    public LLMCallController(b78.c r2, com.larus.audio.call.tracer.b r3, Function0<? extends CoroutineScope> r4) {
        Intrinsics.checkNotNullParameter(r2, "sessionCreator");
        Intrinsics.checkNotNullParameter(r3, "traceSpan");
        Intrinsics.checkNotNullParameter(r4, "lifecycleScope");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = LazyKt.lazy(new l(this));
        this.f = new RealtimeCallParam();
        this.i = new m(this);
        this.j = new n(this);
        this.k = LazyKt.lazy(new o(this));
        this.l = true;
        if (t68.a.a.c() == false) goto L5;
        String r5 = "LLMCallLifecycle";
    L6:
        Intrinsics.checkNotNullParameter(r5, "name");
        this.m = ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new q68.e(r5)));
        this.p = buc.b.a(false);
        CompletableJob r6 = SupervisorKt.SupervisorJob$default(null, 1, null);
        this.q = r6;
        this.r = CoroutineScopeKt.CoroutineScope(r6);
        this.s = LazyKt.lazy(new p(this));
        this.t = buc.b.c(0);
        return;
    L5:
        r5 = "avkit#lifecycle";
        goto L6
    }

    public final void F(String r5, long r6, Job r8) {
        com.larus.audio.call.util.e.a.i(v(), "startJob created, caller=" + r5 + ", jobHash=" + r8.hashCode() + ", version=" + r6 + ", current=" + this.t.c());
    }

    public final boolean n(long r7, String r9, boolean r10) {
        if (this.t.c() == r7) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return false;
    L8:
        com.larus.audio.call.util.e r1 = com.larus.audio.call.util.e.a;
        String r2 = v();
        StringBuilder r4 = new StringBuilder("cancel stale start, stage=");
        r4.append(r9);
        r4.append(", version=");
        r4.append(r7);
        r4.append(", current=");
        r4.append(this.t.c());
        r4.append(", hasSession=");
        if (this.g == null) goto L11;
        boolean r8 = true;
    L12:
        r4.append(r8);
        r4.append(", sessionHash=");
        id9.d r11 = this.g;
        if (r11 == null) goto L15;
        String r12 = Integer.toString(r11.hashCode(), CharsKt.checkRadix(16));
    L16:
        r4.append(r12);
        r4.append(", releaseSession=");
        r4.append(r10);
        r1.w(r2, r4.toString());
        if (r10 == false) goto L19;
        id9.d r13 = this.g;
    L20:
        if (r10 == false) goto L22;
        this.g = null;
    L22:
        this.h = false;
        this.l = true;
        if (r13 == null) goto L25;
        r13.C(SessionReleaseReason.ForceRelease);
    L25:
        return true;
    L19:
        r13 = null;
        goto L20
    L15:
        r12 = null;
        goto L16
    L11:
        r8 = false;
        goto L12
    L5:
        r0 = false;
        goto L6
    }

    public final void q(RealtimeCallParam r6, boolean r7, long r8) {
        if (this.t.c() == r8) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        com.larus.audio.call.util.e.a.i(v(), "doStart ignored before begin, version=" + r8 + ", current=" + this.t.c());
        return;
    L10:
        if (this.l == true) goto L12;
        com.larus.audio.call.util.e.a.e(v(), "controller not call stop, and invoke start !!!!!!");
    L12:
        this.l = false;
        this.f = r6;
        k0<C> r1 = x();
        r1.getClass();
        r1.b("onPreStart", new j0());
        if (n(r8, "after_onPreStart", false) == false) goto L16;
        return;
    L16:
        if (this.h == true) goto L18;
        C(r6, r7, "doStart", Long.valueOf(r8));
    L20:
        if (n(r8, "after_initMediaSession", true) == false) goto L22;
        return;
    L22:
        k0<C> r9 = x();
        r9.getClass();
        r9.b("onStart", new f0());
        if (n(r8, "after_plugin_onStart", true) == false) goto L25;
        return;
    L25:
        id9.d r10 = this.g;
        if (r10 == null) goto L29;
        r10.start();
    L29:
        if (n(r8, "after_mediaSession_start", true) == false) goto L31;
        return;
    L31:
        k0<C> r11 = x();
        r11.getClass();
        r11.b("onAfterStart", new b0());
        return;
    L18:
        this.h = false;
        com.larus.audio.call.util.e.a.i(v(), "has preload media session");
        goto L20
    L5:
        r0 = false;
        goto L6
    }

    public static void D(LLMCallController r2, RealtimeCallParam r3, boolean r4, int r5) {
        boolean r1 = false;
        if ((r5 & 2) == 0) goto L6;
        r4 = false;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r1 = true;
    L8:
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "callParam");
        k0<C> r6 = r2.x();
        r6.getClass();
        r6.b("onInterrupt", new h0());
        if (r1 == false) goto L14;
        id9.d r7 = r2.g;
        if (r7 == null) goto L15;
        r7.h(r4);
        return;
    L15:
        return;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.audio.call.arch.k, java.lang.Object] */
    public static final b m(LLMCallController r1, LifecycleStage r2, final TriggerMode r3, final Function0 r4) {
        id9.d r5 = r1.g;
        ?? r0 = new k(r4, r3);
        Intrinsics.checkNotNullParameter(r2, "stage");
        Intrinsics.checkNotNullParameter(r0, "block");
        if (r5 == null) goto L7;
        r0.invoke(r5);
        return new b.c(r2);
    L7:
        return new b.C0079b(r2, "MISSING_MEDIA_SESSION");
    }

    public final void C(RealtimeCallParam r6, boolean r7, String r8, Long r9) {
        this.b.e(r7, B(), r6, this.c);
        Unit r0 = Unit.INSTANCE;
        this.g = this.b.b();
        String r1 = null;
        if (r9 == null) goto L5;
        String r10 = ", version=" + r9.longValue() + ", current=" + this.t.c();
    L6:
        if (r10 != null) goto L8;
        r10 = "";
    L8:
        com.larus.audio.call.util.e r2 = com.larus.audio.call.util.e.a;
        String r3 = v();
        StringBuilder r4 = new StringBuilder("[initMediaSession] success:");
        if (this.g == null) goto L11;
        boolean r5 = true;
    L12:
        r4.append(r5);
        r4.append(", caller=");
        r4.append(r8);
        r4.append(", sessionHash=");
        id9.d r11 = this.g;
        if (r11 == null) goto L15;
        r1 = Integer.toString(r11.hashCode(), CharsKt.checkRadix(16));
    L15:
        r4.append(r1);
        r4.append(r10);
        r4.append(", fromRetry=");
        r4.append(r7);
        r4.append(", call_id=");
        r4.append(r6.e);
        r2.i(r3, r4.toString());
        return;
    L11:
        r5 = false;
        goto L12
    L5:
        r10 = null;
        goto L6
    }

    public static final b l(LLMCallController r6, RealtimeCallParam r7, boolean r8, LifecycleStage r9, long r10) {
        if (r6.E(r10) == true) goto L38;
        boolean r0 = r6.l;
        RealtimeCallParam r2 = r6.f;
        if (r0 == true) goto L8;
        com.larus.audio.call.util.e.a.e(r6.v(), "controller not call stop, and invoke start !!!!!!");
    L8:
        r6.l = false;
        r6.f = r7;
        k0<C> r3 = r6.x();
        ((ArrayList) r3.c).clear();
        r3.b("onPreStart", new j0());
        if (r6.E(r10) == true) goto L39;
    L32:
        th = move-exception;
        r6.x().f();
        r6.l = r0;
        r6.f = r2;
        throw th;
    L12:
        if (r6.h == true) goto L14;
        r6.C(r7, r8, "doStartAsync", Long.valueOf(r10));     // Catch: Throwable -> L32
    L16:
        if (r6.E(r10) == true) goto L40;
        id9.d r11 = r6.g;
        if (r11 != null) goto L36;
        r6.x().f();
        r6.l = r0;
        r6.f = r2;
        return new b.C0079b(r9, "MISSING_MEDIA_SESSION");
    L36:
        if (r6.x().g(new i(r6, r10)) == false) goto L42;
        r11.start();
        if (r6.E(r10) == true) goto L43;
        k0<C> r12 = r6.x();
        r12.getClass();
        r12.b("onAfterStart", new b0());
        return new b.c(r9);
    L43:
        return r6.Q(r9, true);
    L42:
        return r6.Q(r9, true);
    L29:
        th = move-exception;
        r6.x().f();
        r6.t(r7);
        throw th;
    L40:
        return r6.Q(r9, true);
    L14:
        r6.h = false;     // Catch: Throwable -> L32
        goto L16
    L39:
        return r6.Q(r9, true);
    L38:
        return r6.Q(r9, false);
    }
}
