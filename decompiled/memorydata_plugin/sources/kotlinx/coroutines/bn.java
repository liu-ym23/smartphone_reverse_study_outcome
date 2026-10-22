package kotlinx.coroutines;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0016J\u001c\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\u0010\u0010\u001a\u00060\u0011j\u0002`\u0012H\u0016J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J$\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\n\u0010\u0010\u001a\u00060\u0011j\u0002`\u00122\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001e\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016J.\u0010\"\u001a\b\u0012\u0002\b\u0003\u0018\u00010#*\u00020$2\n\u0010\u0010\u001a\u00060\u0011j\u0002`\u00122\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006%"}, d2 = {"Lkotlinx/coroutines/ExecutorCoroutineDispatcherImpl;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "executor", "Ljava/util/concurrent/Executor;", "(Ljava/util/concurrent/Executor;)V", "getExecutor", "()Ljava/util/concurrent/Executor;", "cancelJobOnRejection", "", "context", "Lkotlin/coroutines/CoroutineContext;", CommonConsts.LOG_REPORT_TYPE_EXCEPTION, "Ljava/util/concurrent/RejectedExecutionException;", IslandSession.REOPEN_VALUE_CLOSE, "dispatch", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "equals", "", "other", "", "hashCode", "", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "toString", "", "scheduleBlock", "Ljava/util/concurrent/ScheduledFuture;", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class bn extends bm implements at {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f17244b;

    public bn(Executor r3) {
        this.f17244b = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.internal.d.a(a());
    }

    private final ScheduledFuture<?> a(ScheduledExecutorService r3, Runnable r4, CoroutineContext r5, long r6) {
        ScheduledExecutorService r7 = (ScheduledExecutorService) ZeusTransformUtils.wrapperContextForParams(r3, ScheduledExecutorService.class, "com.obric.memorydata.plugin");
        Runnable r8 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
        CoroutineContext r9 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r5, CoroutineContext.class, "com.obric.memorydata.plugin");
        return r7.schedule(r8, r6, TimeUnit.MILLISECONDS);
    L5:
        e = move-exception;
        a(r9, e);
        return null;
    }

    private final void a(CoroutineContext r2, RejectedExecutionException r3) {
        ca.a((CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r2, CoroutineContext.class, "com.obric.memorydata.plugin"), bl.a("The task was rejected", (Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.memorydata.plugin")));
    }

    @Override // kotlinx.coroutines.bm
    public Executor a() {
        return this.f17244b;
    }

    @Override // kotlinx.coroutines.at
    public bc a(long r9, Runnable r11, CoroutineContext r12) {
        Runnable r13 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r11, Runnable.class, "com.obric.memorydata.plugin");
        CoroutineContext r14 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r12, CoroutineContext.class, "com.obric.memorydata.plugin");
        Executor r0 = a();
        ScheduledFuture<?> r3 = null;
        if (ZeusTransformUtils.instanceOf(r0, ScheduledExecutorService.class) == false) goto L5;
        ScheduledExecutorService r1 = (ScheduledExecutorService) ZeusTransformUtils.preCheckCast(r0, ScheduledExecutorService.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 == null) goto L8;
        r3 = a(r1, r13, r14, r9);
    L8:
        if (r3 == null) goto L11;
        return (bc) ZeusTransformUtils.preCheckCast(new bb((Future) ZeusTransformUtils.preCheckCast(r3, Future.class, "com.obric.memorydata.plugin")), bc.class, "com.obric.memorydata.plugin");
    L11:
        return ap.f17219a.a(r9, r13, r14);
    L5:
        r1 = null;
        goto L6
    }

    @Override // kotlinx.coroutines.at
    public void a(long r11, n<? super Unit> r13) {
        n<? super Unit> r14 = (n) ZeusTransformUtils.wrapperContextForParams(r13, n.class, "com.obric.memorydata.plugin");
        Executor r0 = a();
        ScheduledFuture<?> r3 = null;
        if (ZeusTransformUtils.instanceOf(r0, ScheduledExecutorService.class) == false) goto L5;
        ScheduledExecutorService r5 = (ScheduledExecutorService) ZeusTransformUtils.preCheckCast(r0, ScheduledExecutorService.class, "com.obric.memorydata.plugin");
    L6:
        if (r5 == null) goto L8;
        r3 = a(r5, (Runnable) ZeusTransformUtils.preCheckCast(new cq((ah) ZeusTransformUtils.preCheckCast(this, ah.class, "com.obric.memorydata.plugin"), r14), Runnable.class, "com.obric.memorydata.plugin"), r14.getContext(), r11);
    L8:
        if (r3 == null) goto L11;
        ca.a(r14, (Future) ZeusTransformUtils.preCheckCast(r3, Future.class, "com.obric.memorydata.plugin"));
        return;
    L11:
        ap.f17219a.a(r11, r14);
        return;
    L5:
        r5 = null;
        goto L6
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor r2 = a();
        if (ZeusTransformUtils.instanceOf(r2, ExecutorService.class) == false) goto L5;
        ExecutorService r3 = (ExecutorService) ZeusTransformUtils.preCheckCast(r2, ExecutorService.class, "com.obric.memorydata.plugin");
    L6:
        if (r3 == null) goto L9;
        r3.shutdown();
        return;
    L9:
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // kotlinx.coroutines.ah
    public void dispatch(CoroutineContext r3, Runnable r4) {
        CoroutineContext r5 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin");
        Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
        Executor r0 = a();     // Catch: RejectedExecutionException -> L10
        b r1 = c.a();     // Catch: RejectedExecutionException -> L10
        if (r1 == null) goto L7;
        Runnable r2 = r1.a(r6);     // Catch: RejectedExecutionException -> L10
        if (r2 == null) goto L7;
    L8:
        r0.execute(r2);     // Catch: RejectedExecutionException -> L10
        return;
    L7:
        r2 = r6;
    L10:
        e = move-exception;
        b r7 = c.a();
        if (r7 == null) goto L14;
        r7.c();
    L14:
        a(r5, e);
        ba.c().dispatch(r5, r6);
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, bn.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (((bn) ZeusTransformUtils.preCheckCast(r3, bn.class, "com.obric.memorydata.plugin")).a() != a()) goto L7;
        return true;
    }

    public int hashCode() {
        return System.identityHashCode(a());
    }

    @Override // kotlinx.coroutines.ah
    public String toString() {
        return a().toString();
    }
}
