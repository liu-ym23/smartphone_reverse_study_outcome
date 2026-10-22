package io.reactivex.internal.schedulers;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public final class ScheduledDirectTask extends AbstractDirectTask implements Callable<Void> {
    private static final long serialVersionUID = 1811839108042568751L;

    public ScheduledDirectTask(Runnable r10) {
        super(r10);
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Void call() {
        return call2();
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public Void call2() {
        this.runner = Thread.currentThread();
        this.runnable.run();     // Catch: Throwable -> L6
        lazySet(AbstractDirectTask.FINISHED);
        this.runner = null;
        return null;
    L6:
        th = move-exception;
        lazySet(AbstractDirectTask.FINISHED);
        this.runner = null;
        throw th;
    }

    @Override // io.reactivex.internal.schedulers.AbstractDirectTask
    public /* bridge */ /* synthetic */ Runnable getWrappedRunnable() {
        return super.getWrappedRunnable();
    }
}
