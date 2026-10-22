package io.reactivex.internal.operators.maybe;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import mt.j;
import mt.z;

/* JADX INFO: loaded from: classes3.dex */
final class MaybeObserveOn$ObserveOnMaybeObserver<T> extends AtomicReference<Disposable> implements j, Disposable, Runnable {
    private static final long serialVersionUID = 8571289934935992137L;
    final j downstream;
    Throwable error;
    final z scheduler;
    T value;

    public MaybeObserveOn$ObserveOnMaybeObserver(j r5, z r10) {
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

    @Override // mt.j
    public void onComplete() {
        DisposableHelper.replace(this, this.scheduler.c(this));
    }

    @Override // mt.j
    public void onError(Throwable r5) {
        this.error = r5;
        DisposableHelper.replace(this, this.scheduler.c(this));
    }

    @Override // mt.j
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.setOnce(this, r5) == false) goto L6;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // mt.j
    public void onSuccess(T r5) {
        this.value = r5;
        DisposableHelper.replace(this, this.scheduler.c(this));
    }

    @Override // java.lang.Runnable
    public void run() {
        Throwable r5 = this.error;
        if (r5 == null) goto L5;
        this.error = null;
        this.downstream.onError(r5);
        return;
    L5:
        T r10 = this.value;
        if (r10 == null) goto L8;
        this.value = null;
        this.downstream.onSuccess(r10);
        return;
    L8:
        this.downstream.onComplete();
    }
}
