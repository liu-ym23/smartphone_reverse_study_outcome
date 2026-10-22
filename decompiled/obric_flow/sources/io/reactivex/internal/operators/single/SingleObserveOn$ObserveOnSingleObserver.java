package io.reactivex.internal.operators.single;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import mt.b0;
import mt.z;

/* JADX INFO: loaded from: classes3.dex */
final class SingleObserveOn$ObserveOnSingleObserver<T> extends AtomicReference<Disposable> implements b0, Disposable, Runnable {
    private static final long serialVersionUID = 3528003840217436037L;
    final b0 downstream;
    Throwable error;
    final z scheduler;
    T value;

    public SingleObserveOn$ObserveOnSingleObserver(b0 r5, z r10) {
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

    @Override // mt.b0, mt.j
    public void onError(Throwable r5) {
        this.error = r5;
        DisposableHelper.replace(this, this.scheduler.c(this));
    }

    @Override // mt.b0, mt.j
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.setOnce(this, r5) == false) goto L6;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // mt.b0, mt.j
    public void onSuccess(T r5) {
        this.value = r5;
        DisposableHelper.replace(this, this.scheduler.c(this));
    }

    @Override // java.lang.Runnable
    public void run() {
        Throwable r5 = this.error;
        if (r5 == null) goto L5;
        this.downstream.onError(r5);
        return;
    L5:
        this.downstream.onSuccess(this.value);
    }
}
