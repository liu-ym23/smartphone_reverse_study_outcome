package io.reactivex.disposables;

/* JADX INFO: loaded from: classes2.dex */
final class RunnableDisposable extends ReferenceDisposable<Runnable> {
    private static final long serialVersionUID = -8219729196779211169L;

    RunnableDisposable(Runnable r10) {
        super(r10);
    }

    @Override // io.reactivex.disposables.ReferenceDisposable
    protected /* bridge */ /* synthetic */ void onDisposed(Runnable r10) {
        onDisposed2(r10);
    }

    /* JADX INFO: renamed from: onDisposed, reason: avoid collision after fix types in other method */
    protected void onDisposed2(Runnable r10) {
        r10.run();
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public String toString() {
        return "RunnableDisposable(disposed=" + isDisposed() + ", " + get() + ")";
    }
}
