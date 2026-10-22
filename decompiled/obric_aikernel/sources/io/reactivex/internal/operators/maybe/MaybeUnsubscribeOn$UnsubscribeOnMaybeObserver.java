package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xb.j;
import xb.p;

/* JADX INFO: loaded from: classes2.dex */
final class MaybeUnsubscribeOn$UnsubscribeOnMaybeObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements j<T>, io.reactivex.disposables.b, Runnable {
    private static final long serialVersionUID = 3256698449646456986L;
    final j<? super T> downstream;
    io.reactivex.disposables.b ds;
    final p scheduler;

    MaybeUnsubscribeOn$UnsubscribeOnMaybeObserver(j<? super T> r10, p r11) {
        this.downstream = r10;
        this.scheduler = r11;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper r10 = DisposableHelper.DISPOSED;
        io.reactivex.disposables.b r11 = getAndSet(r10);
        if (r11 == r10) goto L6;
        this.ds = r11;
        this.scheduler.c(this);
        return;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // xb.j
    public void onComplete() {
        this.downstream.onComplete();
    }

    @Override // xb.j
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
    }

    @Override // xb.j
    public void onSubscribe(io.reactivex.disposables.b r10) {
        if (DisposableHelper.setOnce(this, r10) == false) goto L6;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // xb.j
    public void onSuccess(T r10) {
        this.downstream.onSuccess(r10);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ds.dispose();
    }
}
