package io.reactivex.internal.operators.single;

import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xb.p;
import xb.r;

/* JADX INFO: loaded from: classes2.dex */
final class SingleObserveOn$ObserveOnSingleObserver<T> extends AtomicReference<b> implements r<T>, b, Runnable {
    private static final long serialVersionUID = 3528003840217436037L;
    final r<? super T> downstream;
    Throwable error;
    final p scheduler;
    T value;

    SingleObserveOn$ObserveOnSingleObserver(r<? super T> r10, p r11) {
        this.downstream = r10;
        this.scheduler = r11;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // xb.r
    public void onError(Throwable r10) {
        this.error = r10;
        DisposableHelper.replace(this, this.scheduler.c(this));
    }

    @Override // xb.r
    public void onSubscribe(b r10) {
        if (DisposableHelper.setOnce(this, r10) == false) goto L6;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // xb.r
    public void onSuccess(T r10) {
        this.value = r10;
        DisposableHelper.replace(this, this.scheduler.c(this));
    }

    @Override // java.lang.Runnable
    public void run() {
        Throwable r10 = this.error;
        if (r10 == null) goto L5;
        this.downstream.onError(r10);
        return;
    L5:
        this.downstream.onSuccess(this.value);
    }
}
