package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes3.dex */
public final class e1 extends d1 implements o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f18824a;

    public e1(Executor r5) {
        this.f18824a = r5;
        if ((r5 instanceof ScheduledThreadPoolExecutor) == false) goto L6;
        ((ScheduledThreadPoolExecutor) r5).setRemoveOnCancelPolicy(true);
        return;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Executor r5 = this.f18824a;
        if ((r5 instanceof ExecutorService) == false) goto L5;
        ExecutorService r10 = (ExecutorService) r5;
    L6:
        if (r10 == null) goto L9;
        r10.shutdown();
        return;
    L9:
        return;
    L5:
        r10 = null;
        goto L6
    }

    @Override // kotlinx.coroutines.z
    public final void dispatch(CoroutineContext r5, Runnable r10) {
        this.f18824a.execute(r10);     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        CancellationException r11 = new CancellationException("The task was rejected");
        r11.initCause(e);
        Job r12 = (Job) r5.get(Job.Key);
        if (r12 == null) goto L8;
        r12.cancel(r11);
    L8:
        Dispatchers.getIO().dispatch(r5, r10);
    }

    @Override // kotlinx.coroutines.o0
    public final t0 e(long r5, Runnable r10, CoroutineContext r11) {
        Executor r12 = this.f18824a;
        ScheduledFuture<?> r13 = null;
        if ((r12 instanceof ScheduledExecutorService) == false) goto L5;
        ScheduledExecutorService r14 = (ScheduledExecutorService) r12;
    L6:
        if (r14 != null) goto L17;
    L13:
        if (r13 == null) goto L16;
        return new s0(r13);
    L16:
        return k0.f18973h.e(r5, r10, r11);
    L17:
        r13 = r14.schedule(r10, r5, TimeUnit.MILLISECONDS);     // Catch: RejectedExecutionException -> L9
    L9:
        e = move-exception;
        CancellationException r15 = new CancellationException("The task was rejected");
        r15.initCause(e);
        Job r16 = (Job) r11.get(Job.Key);
        if (r16 == null) goto L13;
        r16.cancel(r15);
        goto L13
    L5:
        r14 = null;
        goto L6
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof e1) == true) goto L5;
    L7:
        return false;
    L5:
        if (((e1) r5).f18824a != this.f18824a) goto L7;
        return true;
    }

    @Override // kotlinx.coroutines.o0
    public final void f(long r10, l r11) {
        Executor r5 = this.f18824a;
        ScheduledFuture<?> r12 = null;
        if ((r5 instanceof ScheduledExecutorService) == false) goto L5;
        ScheduledExecutorService r13 = (ScheduledExecutorService) r5;
    L6:
        if (r13 != null) goto L19;
    L14:
        if (r12 == null) goto L17;
        r11.z(new h(r12, 0));
        return;
    L17:
        k0.f18973h.f(r10, r11);
        return;
    L19:
        r12 = r13.schedule(new com.lynx.tasm.ui.image.v(12, this, false, r11), r10, TimeUnit.MILLISECONDS);     // Catch: RejectedExecutionException -> L10
    L10:
        e = move-exception;
        CancellationException r14 = new CancellationException("The task was rejected");
        r14.initCause(e);
        Job r15 = (Job) r11.e.get(Job.Key);
        if (r15 == null) goto L14;
        r15.cancel(r14);
        goto L14
    L5:
        r13 = null;
        goto L6
    }

    public final int hashCode() {
        return System.identityHashCode(this.f18824a);
    }

    @Override // kotlinx.coroutines.z
    public final String toString() {
        return this.f18824a.toString();
    }
}
