package kotlinx.coroutines.internal;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.bc;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0001(B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0097A¢\u0006\u0002\u0010\u0014J\u001c\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\n\u0010\u0018\u001a\u00060\tj\u0002`\nH\u0016J-\u0010\u0019\u001a\u00020\u00112\n\u0010\u0018\u001a\u00060\tj\u0002`\n2\u0016\u0010\u001a\u001a\u0012\u0012\b\u0012\u00060\u001cR\u00020\u0000\u0012\u0004\u0012\u00020\u00110\u001bH\u0082\bJ\u001c\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\n\u0010\u0018\u001a\u00060\tj\u0002`\nH\u0017J%\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00132\n\u0010\u0018\u001a\u00060\tj\u0002`\n2\u0006\u0010\u0016\u001a\u00020\u0017H\u0096\u0001J\u0010\u0010!\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\u0010\u0010\"\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nH\u0002J\u001f\u0010#\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00132\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00110%H\u0096\u0001J\b\u0010&\u001a\u00020'H\u0002R\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\f\u0012\b\u0012\u00060\tj\u0002`\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\t\u0010\u000b\u001a\u00020\fX\u0082\u0004R\u0012\u0010\r\u001a\u00060\u000ej\u0002`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lkotlinx/coroutines/internal/LimitedDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "dispatcher", "parallelism", "", "(Lkotlinx/coroutines/CoroutineDispatcher;I)V", "queue", "Lkotlinx/coroutines/internal/LockFreeTaskQueue;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "runningWorkers", "Lkotlinx/atomicfu/AtomicInt;", "workerAllocationLock", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "delay", "", OaidModel.KEY_TIME, "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "dispatchInternal", "startWorker", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/LimitedDispatcher$Worker;", "dispatchYield", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "limitedParallelism", "obtainTaskOrDeallocateWorker", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "tryAllocateWorker", "", "Worker", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class r extends kotlinx.coroutines.ah implements kotlinx.coroutines.at {
    private static final /* synthetic */ AtomicIntegerFieldUpdater f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlinx.coroutines.ah f17592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f17593b;
    private final /* synthetic */ kotlinx.coroutines.at c;
    private final w<Runnable> d;
    private final Object e;
    private volatile /* synthetic */ int runningWorkers$volatile;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0011\u0012\n\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u0012\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/internal/LimitedDispatcher$Worker;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "currentTask", "(Lkotlinx/coroutines/internal/LimitedDispatcher;Ljava/lang/Runnable;)V", "run", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ r f17594a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Runnable f17595b;

        public a(r r3, Runnable r4) {
            Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
            this.f17594a = r3;
            this.f17595b = r5;
        }

        @Override // java.lang.Runnable
        public void run() {
            int r1 = 0;
        L16:
            this.f17595b.run();     // Catch: Throwable -> L5
        L7:
            Runnable r2 = r.a(this.f17594a);
            if (r2 == null) goto L9;
            this.f17595b = r2;
            r1 = r1 + 1;
            if (r1 < 16) goto L16;
            if (r.b(this.f17594a).isDispatchNeeded((CoroutineContext) ZeusTransformUtils.preCheckCast(this.f17594a, CoroutineContext.class, "com.obric.memorydata.plugin")) == false) goto L16;
            r.b(this.f17594a).dispatch((CoroutineContext) ZeusTransformUtils.preCheckCast(this.f17594a, CoroutineContext.class, "com.obric.memorydata.plugin"), (Runnable) ZeusTransformUtils.preCheckCast(this, Runnable.class, "com.obric.memorydata.plugin"));
            return;
        L9:
            return;
        L5:
            th = move-exception;
            kotlinx.coroutines.ai.a((CoroutineContext) ZeusTransformUtils.preCheckCast(EmptyCoroutineContext.INSTANCE, CoroutineContext.class, "com.obric.memorydata.plugin"), th);
            goto L7
        }
    }

    static {
        f = AtomicIntegerFieldUpdater.newUpdater(r.class, "runningWorkers$volatile");
    }

    public r(kotlinx.coroutines.ah r2, int r3) {
        this.f17592a = r2;
        this.f17593b = r3;
        if (ZeusTransformUtils.instanceOf(r2, kotlinx.coroutines.at.class) == false) goto L5;
        kotlinx.coroutines.at r4 = (kotlinx.coroutines.at) ZeusTransformUtils.preCheckCast(r2, kotlinx.coroutines.at.class, "com.obric.memorydata.plugin");
    L6:
        if (r4 != null) goto L8;
        r4 = kotlinx.coroutines.aq.a();
    L8:
        this.c = r4;
        this.d = new w(false);
        this.e = new Object();
        return;
    L5:
        r4 = null;
        goto L6
    }

    public static final /* synthetic */ Runnable a(r r0) {
        return r0.b();
    }

    private final boolean a() {
        Object r0 = this.e;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (c().get(this) < this.f17593b) goto L9;
        boolean r3 = false;
    L7:
        monitor-exit(r0);
        return r3;
    L9:
        c().incrementAndGet(this);     // Catch: Throwable -> L11
        r3 = true;
        goto L7
    }

    private final Runnable b() {
    L2:
        Runnable r0 = (Runnable) ZeusTransformUtils.preCheckCast(this.d.c(), Runnable.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L17;
        Object r1 = this.e;
        monitor-enter(r1);
        c().decrementAndGet(this);     // Catch: Throwable -> L14
        if (this.d.a() == 0) goto L9;
        c().incrementAndGet(this);     // Catch: Throwable -> L14
        monitor-exit(r1);
        goto L2
    L9:
        monitor-exit(r1);
        return null;
    L14:
        th = move-exception;
        throw th;
    L17:
        return r0;
    }

    public static final /* synthetic */ kotlinx.coroutines.ah b(r r0) {
        return r0.f17592a;
    }

    private static final /* synthetic */ AtomicIntegerFieldUpdater c() {
        return f;
    }

    @Override // kotlinx.coroutines.at
    public bc a(long r3, Runnable r5, CoroutineContext r6) {
        Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r5, Runnable.class, "com.obric.memorydata.plugin");
        CoroutineContext r8 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r6, CoroutineContext.class, "com.obric.memorydata.plugin");
        return this.c.a(r3, r7, r8);
    }

    @Override // kotlinx.coroutines.at
    public void a(long r3, kotlinx.coroutines.n<? super Unit> r5) {
        kotlinx.coroutines.n<? super Unit> r6 = (kotlinx.coroutines.n) ZeusTransformUtils.wrapperContextForParams(r5, kotlinx.coroutines.n.class, "com.obric.memorydata.plugin");
        this.c.a(r3, r6);
    }

    @Override // kotlinx.coroutines.ah
    public void dispatch(CoroutineContext r3, Runnable r4) {
        CoroutineContext r5 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin");
        Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
        this.d.a(r6);
        if (c().get(this) < this.f17593b) goto L5;
        return;
    L5:
        if (a() == false) goto L12;
        Runnable r7 = b();
        if (r7 == null) goto L13;
        a r8 = new a(this, r7);
        this.f17592a.dispatch((CoroutineContext) ZeusTransformUtils.preCheckCast(this, CoroutineContext.class, "com.obric.memorydata.plugin"), (Runnable) ZeusTransformUtils.preCheckCast(r8, Runnable.class, "com.obric.memorydata.plugin"));
        return;
    L13:
        return;
    }

    @Override // kotlinx.coroutines.ah
    public void dispatchYield(CoroutineContext r3, Runnable r4) {
        CoroutineContext r5 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin");
        Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
        this.d.a(r6);
        if (c().get(this) < this.f17593b) goto L5;
        return;
    L5:
        if (a() == false) goto L12;
        Runnable r7 = b();
        if (r7 == null) goto L13;
        a r8 = new a(this, r7);
        this.f17592a.dispatchYield((CoroutineContext) ZeusTransformUtils.preCheckCast(this, CoroutineContext.class, "com.obric.memorydata.plugin"), (Runnable) ZeusTransformUtils.preCheckCast(r8, Runnable.class, "com.obric.memorydata.plugin"));
        return;
    L13:
        return;
    }

    @Override // kotlinx.coroutines.ah
    public kotlinx.coroutines.ah limitedParallelism(int r2) {
        s.a(r2);
        if (r2 < this.f17593b) goto L7;
        return (kotlinx.coroutines.ah) ZeusTransformUtils.preCheckCast(this, kotlinx.coroutines.ah.class, "com.obric.memorydata.plugin");
    L7:
        return super.limitedParallelism(r2);
    }
}
