package io.reactivex.internal.schedulers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.functions.Functions;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
abstract class AbstractDirectTask extends AtomicReference<Future<?>> implements io.reactivex.disposables.b {
    protected static final FutureTask<Void> DISPOSED = null;
    protected static final FutureTask<Void> FINISHED = null;
    private static final long serialVersionUID = 1811839108042568751L;
    protected final Runnable runnable;
    protected Thread runner;

    static {
        FINISHED = new FutureTask(Functions.f16717b, null);
        DISPOSED = new FutureTask(Functions.f16717b, null);
    }

    AbstractDirectTask(Runnable r3) {
        this.runnable = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
    }

    @Override // io.reactivex.disposables.b
    public final void dispose() {
        Future r0 = (Future) ZeusTransformUtils.preCheckCast(get(), Future.class, "com.obric.memorydata.plugin");
        if (r0 == FINISHED) goto L15;
        FutureTask<Void> r1 = DISPOSED;
        if (r0 != r1) goto L7;
        return;
    L7:
        if (compareAndSet(r0, r1) == false) goto L17;
        if (r0 != null) goto L10;
        return;
    L10:
        if (this.runner == Thread.currentThread()) goto L12;
        boolean r3 = true;
    L13:
        r0.cancel(r3);
        return;
    L12:
        r3 = false;
        goto L13
    L17:
        return;
    }

    public Runnable getWrappedRunnable() {
        return this.runnable;
    }

    @Override // io.reactivex.disposables.b
    public final boolean isDisposed() {
        Future r2 = (Future) ZeusTransformUtils.preCheckCast(get(), Future.class, "com.obric.memorydata.plugin");
        if (r2 != FINISHED) goto L5;
    L8:
        return true;
    L5:
        if (r2 == DISPOSED) goto L8;
        return false;
    }

    public final void setFuture(Future<?> r4) {
        Future r5 = (Future) ZeusTransformUtils.wrapperContextForParams(r4, Future.class, "com.obric.memorydata.plugin");
    L3:
        Future r0 = (Future) ZeusTransformUtils.preCheckCast(get(), Future.class, "com.obric.memorydata.plugin");
        if (r0 == FINISHED) goto L20;
        if (r0 == DISPOSED) goto L9;
        if (compareAndSet(r0, r5) == false) goto L3;
        return;
    L9:
        if (this.runner == Thread.currentThread()) goto L11;
        boolean r3 = true;
    L12:
        r5.cancel(r3);
        return;
    L11:
        r3 = false;
        goto L12
    }
}
