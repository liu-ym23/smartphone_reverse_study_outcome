package io.reactivex.internal.operators.single;

import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xb.p;
import xb.r;

/* JADX INFO: loaded from: classes2.dex */
final class SingleUnsubscribeOn$UnsubscribeOnSingleObserver<T> extends AtomicReference<b> implements r<T>, b, Runnable {
    private static final long serialVersionUID = 3256698449646456986L;
    final r<? super T> downstream;
    b ds;
    final p scheduler;

    SingleUnsubscribeOn$UnsubscribeOnSingleObserver(r<? super T> r10, p r11) {
        this.downstream = r10;
        this.scheduler = r11;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper r10 = DisposableHelper.DISPOSED;
        b r11 = getAndSet(r10);
        if (r11 == r10) goto L6;
        this.ds = r11;
        this.scheduler.c(this);
        return;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // xb.r
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
    }

    @Override // xb.r
    public void onSubscribe(b r10) {
        if (DisposableHelper.setOnce(this, r10) == false) goto L6;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // xb.r
    public void onSuccess(T r10) {
        this.downstream.onSuccess(r10);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ds.dispose();
    }
}
