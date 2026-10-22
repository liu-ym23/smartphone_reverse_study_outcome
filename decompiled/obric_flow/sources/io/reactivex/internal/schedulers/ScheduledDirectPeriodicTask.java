package io.reactivex.internal.schedulers;

/* JADX INFO: loaded from: classes3.dex */
public final class ScheduledDirectPeriodicTask extends AbstractDirectTask implements Runnable {
    private static final long serialVersionUID = 1811839108042568751L;

    public ScheduledDirectPeriodicTask(Runnable r5) {
        super(r5);
    }

    @Override // io.reactivex.internal.schedulers.AbstractDirectTask
    public /* bridge */ /* synthetic */ Runnable getWrappedRunnable() {
        return super.getWrappedRunnable();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.runner = Thread.currentThread();
        this.runnable.run();     // Catch: Throwable -> L5
        this.runner = null;     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        this.runner = null;
        lazySet(AbstractDirectTask.FINISHED);
        wn.f.k(th);
    }
}
