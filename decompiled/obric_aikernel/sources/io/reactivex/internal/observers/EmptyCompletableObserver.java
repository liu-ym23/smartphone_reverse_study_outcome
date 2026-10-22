package io.reactivex.internal.observers;

import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class EmptyCompletableObserver extends AtomicReference<io.reactivex.disposables.b> implements xb.b, io.reactivex.disposables.b {
    private static final long serialVersionUID = -7545121636549663526L;

    public EmptyCompletableObserver() {
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean hasCustomOnError() {
        return false;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        if (get() != DisposableHelper.DISPOSED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // xb.b
    public void onComplete() {
        lazySet(DisposableHelper.DISPOSED);
    }

    @Override // xb.b
    public void onError(Throwable r10) {
        lazySet(DisposableHelper.DISPOSED);
        dc.a.n(new OnErrorNotImplementedException(r10));
    }

    @Override // xb.b
    public void onSubscribe(io.reactivex.disposables.b r10) {
        DisposableHelper.setOnce(this, r10);
    }
}
