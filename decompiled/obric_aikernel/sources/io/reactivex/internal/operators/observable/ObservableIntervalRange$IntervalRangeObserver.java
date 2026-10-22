package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableIntervalRange$IntervalRangeObserver extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, Runnable {
    private static final long serialVersionUID = 1891866368734007884L;
    long count;
    final xb.o<? super Long> downstream;
    final long end;

    ObservableIntervalRange$IntervalRangeObserver(xb.o<? super Long> r10, long r11, long r12) {
        this.downstream = r10;
        this.count = r11;
        this.end = r12;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        if (get() != DisposableHelper.DISPOSED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (isDisposed() == true) goto L10;
        long r10 = this.count;
        this.downstream.onNext(Long.valueOf(r10));
        if (r10 != this.end) goto L8;
        DisposableHelper.dispose(this);
        this.downstream.onComplete();
        return;
    L8:
        this.count = r10 + 1;
        return;
    }

    public void setResource(io.reactivex.disposables.b r10) {
        DisposableHelper.setOnce(this, r10);
    }
}
