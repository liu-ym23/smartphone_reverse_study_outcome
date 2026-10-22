package io.reactivex.internal.observers;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class EmptyCompletableObserver extends AtomicReference<Disposable> implements mt.b, Disposable {
    private static final long serialVersionUID = -7545121636549663526L;

    public EmptyCompletableObserver() {
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean hasCustomOnError() {
        return false;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get() != DisposableHelper.DISPOSED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // mt.b
    public void onComplete() {
        lazySet(DisposableHelper.DISPOSED);
    }

    @Override // mt.b
    public void onError(Throwable r5) {
        lazySet(DisposableHelper.DISPOSED);
        wn.f.k(new OnErrorNotImplementedException(r5));
    }

    @Override // mt.b
    public void onSubscribe(Disposable r5) {
        DisposableHelper.setOnce(this, r5);
    }
}
