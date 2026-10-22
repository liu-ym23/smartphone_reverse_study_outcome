package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableTimeout$TimeoutConsumer extends AtomicReference<io.reactivex.disposables.b> implements xb.o<Object>, io.reactivex.disposables.b {
    private static final long serialVersionUID = 8708641127342403073L;
    final long idx;
    final k parent;

    ObservableTimeout$TimeoutConsumer(long r10, k r11) {
        this.idx = r10;
        this.parent = r11;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // xb.o
    public void onComplete() {
        io.reactivex.disposables.b r10 = get();
        DisposableHelper r11 = DisposableHelper.DISPOSED;
        if (r10 == r11) goto L6;
        lazySet(r11);
        this.parent.onTimeout(this.idx);
        return;
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        io.reactivex.disposables.b r11 = get();
        DisposableHelper r12 = DisposableHelper.DISPOSED;
        if (r11 == r12) goto L5;
        lazySet(r12);
        this.parent.onTimeoutError(this.idx, r10);
        return;
    L5:
        dc.a.n(r10);
    }

    @Override // xb.o
    public void onNext(Object r10) {
        io.reactivex.disposables.b r11 = get();
        DisposableHelper r12 = DisposableHelper.DISPOSED;
        if (r11 == r12) goto L6;
        r11.dispose();
        lazySet(r12);
        this.parent.onTimeout(this.idx);
        return;
    }

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
        DisposableHelper.setOnce(this, r10);
    }
}
