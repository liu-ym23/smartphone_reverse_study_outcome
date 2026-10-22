package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableTimeout$TimeoutConsumer extends AtomicReference<Disposable> implements mt.u, Disposable {
    private static final long serialVersionUID = 8708641127342403073L;
    final long idx;
    final g4 parent;

    public ObservableTimeout$TimeoutConsumer(long r5, g4 r10) {
        this.idx = r5;
        this.parent = r10;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // mt.u
    public void onComplete() {
        Disposable r5 = get();
        DisposableHelper r10 = DisposableHelper.DISPOSED;
        if (r5 == r10) goto L6;
        lazySet(r10);
        this.parent.onTimeout(this.idx);
        return;
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        Disposable r10 = get();
        DisposableHelper r11 = DisposableHelper.DISPOSED;
        if (r10 == r11) goto L5;
        lazySet(r11);
        this.parent.onTimeoutError(this.idx, r5);
        return;
    L5:
        wn.f.k(r5);
    }

    @Override // mt.u
    public void onNext(Object r5) {
        Disposable r10 = get();
        DisposableHelper r11 = DisposableHelper.DISPOSED;
        if (r10 == r11) goto L6;
        r10.dispose();
        lazySet(r11);
        this.parent.onTimeout(this.idx);
        return;
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        DisposableHelper.setOnce(this, r5);
    }
}
