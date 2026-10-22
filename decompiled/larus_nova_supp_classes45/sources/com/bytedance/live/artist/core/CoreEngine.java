package com.bytedance.live.artist.core;

import com.bytedance.android.live.base.api.ActivityType;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.sync.SemaphoreImpl;
import lf6.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class CoreEngine {
    public static final /* synthetic */ int u = 0;
    public final Executor a;
    public final CompletableJob b;
    public final CoroutineContext c;
    public final CoroutineScope d;
    public final CoroutineScope e;
    public boolean f;
    public boolean g;
    public Channel<Runnable> h;
    public Job i;
    public final Channel<Float> j;
    public Job k;
    public final List<Runnable> l;
    public final List<Runnable> m;
    public final SemaphoreImpl n;
    public final Function0<Unit> o;
    public final com.bytedance.live.artist.core.b p;
    public final long q;
    public final d r;
    public final kf6.a s;
    public final com.bytedance.live.artist.render.c t;

    public static final class a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public final /* synthetic */ CoreEngine a;

        public a(CoroutineExceptionHandler.Key r1, CoreEngine r2) {
            this.a = r2;
            super(r1);
        }

        public final void handleException(CoroutineContext r2, Throwable r3) {
            this.a.s.error("core coroutine exception", r3);
        }
    }

    public static final class b extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public final /* synthetic */ CoreEngine a;

        public b(CoroutineExceptionHandler.Key r1, CoreEngine r2) {
            this.a = r2;
            super(r1);
        }

        public final void handleException(CoroutineContext r2, Throwable r3) {
            this.a.s.error("main coroutine exception", r3);
        }
    }

    public static final class c {
    }

    /* JADX INFO: renamed from: com.bytedance.live.artist.core.CoreEngine$update$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, ActivityType.LIVE_BROADCAST_BEFORE_ACTIVITY_CLASS})
    @DebugMetadata(c = "com.bytedance.live.artist.core.CoreEngine$update$1", f = "CoreEngine.kt", i = {0}, l = {107}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    public static final class C03301 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ float $deltaTimeInMs;
        Object L$0;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ CoreEngine this$0;

        public C03301(CoreEngine r1, float r2, Continuation r3) {
            this.this$0 = r1;
            this.$deltaTimeInMs = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            C03301 r0 = new C03301(this.this$0, this.$deltaTimeInMs, r5);
            r0.p$ = (CoroutineScope) r4;
            return r0;
        }

        public final Object invoke(Object r1, Object r2) {
            return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            CoroutineScope r2 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            CoroutineScope r6 = this.p$;
            Channel<Float> r3 = this.this$0.j;
            Float r4 = Boxing.boxFloat(this.$deltaTimeInMs);
            this.L$0 = r6;
            this.label = 1;
            if (r3.send(r4, this) != r0) goto L12;
            return r0;
        }
    }

    static {
    }

    public final void e() {
        BuildersKt.launch$default(this.e, null, null, new CoreEngine$release$1(this, null), 3, null);
    }

    public final void f() {
        BuildersKt.launch$default(this.e, null, null, new CoreEngine$start$1(this, null), 3, null);
    }

    public final void g() {
        BuildersKt.launch$default(this.e, null, null, new CoreEngine$stop$1(this, null), 3, null);
    }

    public static final void a(CoreEngine r4) {
        r4.f = false;
        r4.t.b();
        Job r0 = r4.k;
        if (r0 == null) goto L5;
        JobKt.cancel$default(r0, NewBroadcastMonitor.STAGE.STOP, null, 2, null);
    L5:
        r4.k = null;
        Job r1 = r4.i;
        if (r1 == null) goto L8;
        JobKt.cancel$default(r1, NewBroadcastMonitor.STAGE.STOP, null, 2, null);
    L8:
        r4.i = null;
        Channel<Runnable> r2 = r4.h;
        if (r2 == null) goto L11;
        r2.close(null);
    L11:
        r4.h = null;
    }

    private final void update(float r7) {
        if (this.f == true) goto L6;
        return;
    L6:
        if (r7 > 0) goto L9;
        r7 = 1000.0f / this.q;
    L9:
        BuildersKt.launch$default(this.d, null, null, new C03301(this, r7, null), 3, null);
    }

    public final void d(Runnable r7) {
        BuildersKt.launch$default(this.d, null, null, new CoreEngine$postRunnable$1(this, r7, null), 3, null);
    }

    public static final /* synthetic */ void b(CoreEngine r0, float r1) {
        r0.update(r1);
    }

    public final /* synthetic */ Object c(Runnable r5, Continuation<? super Unit> r6) {
        if ((r6 instanceof CoreEngine$post$1) == false) goto L7;
        CoreEngine$post$1 r0 = (CoreEngine$post$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        kotlinx.coroutines.sync.c r8 = (kotlinx.coroutines.sync.c) r0.L$2;
        Runnable r4 = (Runnable) r0.L$1;
        CoreEngine r9 = (CoreEngine) r0.L$0;
        ResultKt.throwOnFailure(r7);
        kotlinx.coroutines.sync.c r11 = r8;
        r5 = r4;
    L24:
        Boxing.boxBoolean(((ArrayList) r9.l).add(r5));     // Catch: Throwable -> L21
        r11.release();
        return Unit.INSTANCE;
    L21:
        th = move-exception;
        r11.release();
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        r11 = this.n;
        r0.L$0 = this;
        r0.L$1 = r5;
        r0.L$2 = r11;
        r0.label = 1;
        if (r11.c(r0) != r2) goto L17;
        return r2;
    L17:
        r9 = this;
    L7:
        r0 = new CoreEngine$post$1(this, r6);
        goto L8
    }

    public CoreEngine(kf6.a r4, com.bytedance.live.artist.render.c r5, d r6, Executor r7) {
        this.s = r4;
        this.t = r5;
        if (r7 != null) goto L6;
        r7 = PThreadExecutorsUtils.newScheduledThreadPool(2, new com.bytedance.live.artist.core.a());
    L6:
        this.a = r7;
        CoroutineDispatcher r8 = ExecutorsKt.from(r7);
        CompletableJob r0 = JobKt.Job$default(null, 1, null);
        this.b = r0;
        CoroutineExceptionHandler.Key r2 = CoroutineExceptionHandler.Key;
        a r1 = new a(r2, this);
        CoroutineContext r9 = r0.plus(r8).plus(r1);
        this.c = r9;
        this.d = CoroutineScopeKt.CoroutineScope(r9);
        b r11 = new b(r2, this);
        this.e = CoroutineScopeKt.CoroutineScope(JobKt.Job$default(null, 1, null).plus(Dispatchers.getMain()).plus(r11));
        this.j = ChannelKt.Channel(-1);
        this.l = new ArrayList();
        this.m = new ArrayList();
        int r12 = kotlinx.coroutines.sync.d.a;
        this.n = new SemaphoreImpl(1, 0);
        this.o = new CoreEngine$executePendingRunnablesAction$1(this);
        this.p = new com.bytedance.live.artist.core.b(this);
        this.q = 60;
        int r13 = d.b;
        d.a r14 = new d.a();
        lf6.b r15 = new lf6.b();
        ((ArrayList) r14.a).add(r15);
        List<lf6.c> r16 = r14.a;
        ArrayList r17 = (ArrayList) r16;
        r17.addAll(r6.a);
        lf6.a r18 = new lf6.a();
        ((ArrayList) r14.a).add(r18);
        d r19 = new d(r14.a);
        this.r = r19;
        r19.a(new AnonymousClass1(this));
    }
}
