package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes3.dex */
public final class l1 extends ExecutorCoroutineDispatcher implements t0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Executor f10606c;

    public l1(Executor r10) {
        this.f10606c = r10;
        kotlinx.coroutines.internal.d.a(c0());
    }

    private final void d0(CoroutineContext r10, RejectedExecutionException r11) {
        y1.c(r10, k1.a("The task was rejected", r11));
    }

    private final ScheduledFuture<?> e0(ScheduledExecutorService r10, Runnable r11, CoroutineContext r12, long r13) {
        return r10.schedule(r11, r13, TimeUnit.MILLISECONDS);
    L4:
        e = move-exception;
        d0(r12, e);
        return null;
    }

    @Override // kotlinx.coroutines.t0
    public b1 B(long r10, Runnable r12, CoroutineContext r13) {
        Executor r11 = c0();
        ScheduledFuture<?> r14 = null;
        if ((r11 instanceof ScheduledExecutorService) == false) goto L5;
        ScheduledExecutorService r15 = (ScheduledExecutorService) r11;
    L6:
        if (r15 == null) goto L8;
        r14 = e0(r15, r12, r13, r10);
    L8:
        if (r14 == null) goto L11;
        return new a1(r14);
    L11:
        return p0.f10623l.B(r10, r12, r13);
    L5:
        r15 = null;
        goto L6
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    public Executor c0() {
        return this.f10606c;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor r10 = c0();
        if ((r10 instanceof ExecutorService) == false) goto L5;
        ExecutorService r11 = (ExecutorService) r10;
    L6:
        if (r11 == null) goto L9;
        r11.shutdown();
        return;
    L9:
        return;
    L5:
        r11 = null;
        goto L6
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext r10, Runnable r11) {
        Executor r12 = c0();     // Catch: RejectedExecutionException -> L4
        c.a();     // Catch: RejectedExecutionException -> L4
        r12.execute(r11);     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        c.a();
        d0(r10, e);
        z0.b().dispatch(r10, r11);
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof l1) == true) goto L5;
    L7:
        return false;
    L5:
        if (((l1) r10).c0() != c0()) goto L7;
        return true;
    }

    public int hashCode() {
        return System.identityHashCode(c0());
    }

    @Override // kotlinx.coroutines.t0
    public void k(long r10, n<? super Unit> r12) {
        Executor r11 = c0();
        ScheduledFuture<?> r13 = null;
        if ((r11 instanceof ScheduledExecutorService) == false) goto L5;
        ScheduledExecutorService r14 = (ScheduledExecutorService) r11;
    L6:
        if (r14 == null) goto L8;
        r13 = e0(r14, new n2(this, r12), r12.getContext(), r10);
    L8:
        if (r13 == null) goto L11;
        y1.e(r12, r13);
        return;
    L11:
        p0.f10623l.k(r10, r12);
        return;
    L5:
        r14 = null;
        goto L6
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return c0().toString();
    }
}
