package io.reactivex.internal.observers;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import mt.b0;

/* JADX INFO: loaded from: classes3.dex */
public final class ConsumerSingleObserver<T> extends AtomicReference<Disposable> implements b0, Disposable {
    private static final long serialVersionUID = -7012088219455310787L;
    final pt.g onError;
    final pt.g onSuccess;

    public ConsumerSingleObserver(pt.g r5, pt.g r10) {
        this.onSuccess = r5;
        this.onError = r10;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean hasCustomOnError() {
        if (this.onError == io.reactivex.internal.functions.e.e) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get() != DisposableHelper.DISPOSED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // mt.b0, mt.j
    public void onError(Throwable r5) {
        lazySet(DisposableHelper.DISPOSED);
        this.onError.accept(r5);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        wn.f.k(new CompositeException(new Throwable[]{r5, th}));
    }

    @Override // mt.b0, mt.j
    public void onSubscribe(Disposable r5) {
        DisposableHelper.setOnce(this, r5);
    }

    @Override // mt.b0, mt.j
    public void onSuccess(T r5) {
        lazySet(DisposableHelper.DISPOSED);
        this.onSuccess.accept(r5);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        wn.f.k(th);
    }
}
