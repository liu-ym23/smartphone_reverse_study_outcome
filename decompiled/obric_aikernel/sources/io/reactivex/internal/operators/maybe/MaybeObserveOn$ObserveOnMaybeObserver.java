package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xb.j;
import xb.p;

/* JADX INFO: loaded from: classes2.dex */
final class MaybeObserveOn$ObserveOnMaybeObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements j<T>, io.reactivex.disposables.b, Runnable {
    private static final long serialVersionUID = 8571289934935992137L;
    final j<? super T> downstream;
    Throwable error;
    final p scheduler;
    T value;

    MaybeObserveOn$ObserveOnMaybeObserver(j<? super T> r10, p r11) {
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

    @Override // xb.j
    public void onComplete() {
        DisposableHelper.replace(this, this.scheduler.c(this));
    }

    @Override // xb.j
    public void onError(Throwable r10) {
        this.error = r10;
        DisposableHelper.replace(this, this.scheduler.c(this));
    }

    @Override // xb.j
    public void onSubscribe(io.reactivex.disposables.b r10) {
        if (DisposableHelper.setOnce(this, r10) == false) goto L6;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // xb.j
    public void onSuccess(T r10) {
        this.value = r10;
        DisposableHelper.replace(this, this.scheduler.c(this));
    }

    @Override // java.lang.Runnable
    public void run() {
        Throwable r10 = this.error;
        if (r10 == null) goto L5;
        this.error = null;
        this.downstream.onError(r10);
        return;
    L5:
        T r11 = this.value;
        if (r11 == null) goto L8;
        this.value = null;
        this.downstream.onSuccess(r11);
        return;
    L8:
        this.downstream.onComplete();
    }
}
