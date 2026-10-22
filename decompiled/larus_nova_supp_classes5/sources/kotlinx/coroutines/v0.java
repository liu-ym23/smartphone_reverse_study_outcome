package kotlinx.coroutines;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class v0 extends ExecutorCoroutineDispatcher implements f0 {
    public final Executor a;

    public final void close() {
        Executor r0 = this.a;
        if ((r0 instanceof ExecutorService) == false) goto L5;
        ExecutorService r1 = (ExecutorService) r0;
    L6:
        if (r1 == null) goto L9;
        r1.shutdown();
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final int hashCode() {
        return System.identityHashCode(this.a);
    }

    public final String toString() {
        return this.a.toString();
    }

    public final Executor d() {
        return this.a;
    }

    public v0(Executor r5) {
        this.a = r5;
        Method r0 = c.a;
        if ((r5 instanceof ScheduledThreadPoolExecutor) == false) goto L6;
        ScheduledThreadPoolExecutor r6 = (ScheduledThreadPoolExecutor) r5;     // Catch: Throwable -> L14
    L7:
        if (r6 == null) goto L17;
        Method r1 = c.a;     // Catch: Throwable -> L14
        if (r1 == null) goto L18;
        r1.invoke(r6, new Object[]{Boolean.TRUE});     // Catch: Throwable -> L14
        return;
    L18:
        return;
    L17:
        return;
    L6:
        r6 = null;
    }

    public final boolean equals(Object r2) {
        if ((r2 instanceof v0) == true) goto L5;
    L7:
        return false;
    L5:
        if (((v0) r2).a != this.a) goto L7;
        return true;
    }

    public final void dispatch(CoroutineContext r3, Runnable r4) {
        this.a.execute(r4);     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        JobKt.cancel(r3, u0.a("The task was rejected", e));
        Dispatchers.getIO().dispatch(r3, r4);
    }

    public final void scheduleResumeAfterDelay(long r6, i<? super Unit> r8) {
        Executor r0 = this.a;
        ScheduledFuture<?> r2 = null;
        if ((r0 instanceof ScheduledExecutorService) == false) goto L5;
        ScheduledExecutorService r1 = (ScheduledExecutorService) r0;
    L6:
        if (r1 == null) goto L12;
        q1 r3 = new q1(this, (j) r8);
        CoroutineContext r4 = r8.getContext();
        r2 = r1.schedule(r3, r6, TimeUnit.MILLISECONDS);     // Catch: RejectedExecutionException -> L10
    L10:
        e = move-exception;
        JobKt.cancel(r4, u0.a("The task was rejected", e));
    L12:
        if (r2 == null) goto L15;
        JobKt.cancelFutureOnCancellation(r8, r2);
        return;
    L15:
        c0.h.scheduleResumeAfterDelay(r6, r8);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final m0 invokeOnTimeout(long r4, Runnable r6, CoroutineContext r7) {
        Executor r0 = this.a;
        ScheduledFuture<?> r2 = null;
        if ((r0 instanceof ScheduledExecutorService) == false) goto L5;
        ScheduledExecutorService r1 = (ScheduledExecutorService) r0;
    L6:
        if (r1 != null) goto L15;
    L11:
        if (r2 == null) goto L14;
        return new l0(r2);
    L14:
        return c0.h.invokeOnTimeout(r4, r6, r7);
    L15:
        r2 = r1.schedule(r6, r4, TimeUnit.MILLISECONDS);     // Catch: RejectedExecutionException -> L9
    L9:
        e = move-exception;
        JobKt.cancel(r7, u0.a("The task was rejected", e));
        goto L11
    L5:
        r1 = null;
        goto L6
    }
}
