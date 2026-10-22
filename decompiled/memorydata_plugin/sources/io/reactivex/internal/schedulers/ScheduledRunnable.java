package io.reactivex.internal.schedulers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes6.dex */
public final class ScheduledRunnable extends AtomicReferenceArray<Object> implements io.reactivex.disposables.b, Runnable, Callable<Object> {
    static final Object ASYNC_DISPOSED = null;
    static final Object DONE = null;
    static final int FUTURE_INDEX = 1;
    static final Object PARENT_DISPOSED = null;
    static final int PARENT_INDEX = 0;
    static final Object SYNC_DISPOSED = null;
    static final int THREAD_INDEX = 2;
    private static final long serialVersionUID = -6120223772001106981L;
    final Runnable actual;

    static {
        PARENT_DISPOSED = new Object();
        SYNC_DISPOSED = new Object();
        ASYNC_DISPOSED = new Object();
        DONE = new Object();
    }

    public ScheduledRunnable(Runnable r3, io.reactivex.internal.disposables.a r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        io.reactivex.internal.disposables.a r6 = (io.reactivex.internal.disposables.a) ZeusTransformUtils.wrapperContextForParams(r4, io.reactivex.internal.disposables.a.class, "com.obric.memorydata.plugin");
        super(3);
        this.actual = r5;
        lazySet(0, r6);
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        run();
        return null;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
    L2:
        Object r1 = get(1);
        if (r1 == DONE) goto L19;
        Object r2 = SYNC_DISPOSED;
        if (r1 == r2) goto L19;
        Object r5 = ASYNC_DISPOSED;
        if (r1 == r5) goto L19;
        if (get(2) == Thread.currentThread()) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == false) goto L16;
        r2 = r5;
    L16:
        if (compareAndSet(1, r1, r2) == false) goto L2;
        if (r1 == null) goto L19;
        ((Future) ZeusTransformUtils.preCheckCast(r1, Future.class, "com.obric.memorydata.plugin")).cancel(r6);
        goto L19
    L12:
        r6 = false;
    L19:
        Object r0 = get(0);
        if (r0 == DONE) goto L40;
        Object r3 = PARENT_DISPOSED;
        if (r0 == r3) goto L41;
        if (r0 == null) goto L42;
        if (compareAndSet(0, r0, r3) == false) goto L19;
        ((io.reactivex.internal.disposables.a) ZeusTransformUtils.preCheckCast(r0, io.reactivex.internal.disposables.a.class, "com.obric.memorydata.plugin")).delete(this);
        return;
    L42:
        return;
    L41:
        return;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        Object r2 = get(0);
        if (r2 != PARENT_DISPOSED) goto L5;
    L6:
        return true;
    L5:
        if (r2 == DONE) goto L6;
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        lazySet(2, Thread.currentThread());
        this.actual.run();     // Catch: Throwable -> L5
    L7:
        lazySet(2, null);
        Object r1 = get(0);
        if (r1 == PARENT_DISPOSED) goto L13;
        if (compareAndSet(0, r1, DONE) == false) goto L13;
        if (r1 == null) goto L13;
        ((io.reactivex.internal.disposables.a) ZeusTransformUtils.preCheckCast(r1, io.reactivex.internal.disposables.a.class, "com.obric.memorydata.plugin")).delete(this);
    L13:
        Object r0 = get(1);
        if (r0 == SYNC_DISPOSED) goto L50;
        if (r0 == ASYNC_DISPOSED) goto L19;
        if (compareAndSet(1, r0, DONE) == false) goto L13;
        return;
    L19:
        return;
    L50:
        return;
    L5:
        th = move-exception;
        io.reactivex.d.a.a(th);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        lazySet(2, null);
        Object r2 = get(0);
        if (r2 == PARENT_DISPOSED) goto L27;
        if (compareAndSet(0, r2, DONE) == false) goto L27;
        if (r2 == null) goto L27;
        ((io.reactivex.internal.disposables.a) ZeusTransformUtils.preCheckCast(r2, io.reactivex.internal.disposables.a.class, "com.obric.memorydata.plugin")).delete(this);
    L27:
        Object r3 = get(1);
        if (r3 == SYNC_DISPOSED) goto L34;
        if (r3 == ASYNC_DISPOSED) goto L34;
        if (compareAndSet(1, r3, DONE) == false) goto L27;
    L34:
        throw th;
    }

    public void setFuture(Future<?> r4) {
        Future r5 = (Future) ZeusTransformUtils.wrapperContextForParams(r4, Future.class, "com.obric.memorydata.plugin");
    L3:
        Object r1 = get(1);
        if (r1 == DONE) goto L5;
        if (r1 == SYNC_DISPOSED) goto L8;
        if (r1 == ASYNC_DISPOSED) goto L12;
        if (compareAndSet(1, r1, r5) == false) goto L3;
        return;
    L12:
        r5.cancel(true);
        return;
    L8:
        r5.cancel(false);
        return;
    }
}
