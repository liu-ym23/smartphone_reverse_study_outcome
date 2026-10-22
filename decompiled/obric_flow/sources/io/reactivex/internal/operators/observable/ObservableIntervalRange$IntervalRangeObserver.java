package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableIntervalRange$IntervalRangeObserver extends AtomicReference<Disposable> implements Disposable, Runnable {
    private static final long serialVersionUID = 1891866368734007884L;
    long count;
    final mt.u downstream;
    final long end;

    public ObservableIntervalRange$IntervalRangeObserver(mt.u r5, long r10, long r11) {
        this.downstream = r5;
        this.count = r10;
        this.end = r11;
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
        if (isDisposed() == true) goto L10;
        long r5 = this.count;
        this.downstream.onNext(Long.valueOf(r5));
        if (r5 != this.end) goto L8;
        DisposableHelper.dispose(this);
        this.downstream.onComplete();
        return;
    L8:
        this.count = r5 + 1;
        return;
    }

    public void setResource(Disposable r5) {
        DisposableHelper.setOnce(this, r5);
    }
}
