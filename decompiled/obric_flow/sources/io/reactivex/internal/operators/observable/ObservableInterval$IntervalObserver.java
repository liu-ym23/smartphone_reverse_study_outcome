package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableInterval$IntervalObserver extends AtomicReference<Disposable> implements Disposable, Runnable {
    private static final long serialVersionUID = 346773832286157679L;
    long count;
    final mt.u downstream;

    public ObservableInterval$IntervalObserver(mt.u r5) {
        this.downstream = r5;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get() != DisposableHelper.DISPOSED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (get() == DisposableHelper.DISPOSED) goto L6;
        mt.u r5 = this.downstream;
        long r10 = this.count;
        this.count = 1 + r10;
        r5.onNext(Long.valueOf(r10));
        return;
    }

    public void setResource(Disposable r5) {
        DisposableHelper.setOnce(this, r5);
    }
}
