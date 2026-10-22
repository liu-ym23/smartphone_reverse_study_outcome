package io.reactivex.internal.operators.completable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import mt.b;
import mt.z;

/* JADX INFO: loaded from: classes3.dex */
final class CompletableObserveOn$ObserveOnCompletableObserver extends AtomicReference<Disposable> implements b, Disposable, Runnable {
    private static final long serialVersionUID = 8571289934935992137L;
    final b downstream;
    Throwable error;
    final z scheduler;

    public CompletableObserveOn$ObserveOnCompletableObserver(b r5, z r10) {
        this.downstream = r5;
        this.scheduler = r10;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // mt.b
    public void onComplete() {
        DisposableHelper.replace(this, this.scheduler.c(this));
    }

    @Override // mt.b
    public void onError(Throwable r5) {
        this.error = r5;
        DisposableHelper.replace(this, this.scheduler.c(this));
    }

    @Override // mt.b
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.setOnce(this, r5) == false) goto L6;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
        Throwable r5 = this.error;
        if (r5 == null) goto L5;
        this.error = null;
        this.downstream.onError(r5);
        return;
    L5:
        this.downstream.onComplete();
    }
}
