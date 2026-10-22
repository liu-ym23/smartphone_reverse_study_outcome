package io.reactivex.internal.operators.completable;

import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xb.p;

/* JADX INFO: loaded from: classes2.dex */
final class CompletableObserveOn$ObserveOnCompletableObserver extends AtomicReference<b> implements xb.b, b, Runnable {
    private static final long serialVersionUID = 8571289934935992137L;
    final xb.b downstream;
    Throwable error;
    final p scheduler;

    CompletableObserveOn$ObserveOnCompletableObserver(xb.b r10, p r11) {
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

    @Override // xb.b
    public void onComplete() {
        DisposableHelper.replace(this, this.scheduler.c(this));
    }

    @Override // xb.b
    public void onError(Throwable r10) {
        this.error = r10;
        DisposableHelper.replace(this, this.scheduler.c(this));
    }

    @Override // xb.b
    public void onSubscribe(b r10) {
        if (DisposableHelper.setOnce(this, r10) == false) goto L6;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
        Throwable r10 = this.error;
        if (r10 == null) goto L5;
        this.error = null;
        this.downstream.onError(r10);
        return;
    L5:
        this.downstream.onComplete();
    }
}
