package io.reactivex.internal.operators.maybe;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import mt.j;
import pt.g;
import wn.f;

/* JADX INFO: loaded from: classes3.dex */
public final class MaybeCallbackObserver<T> extends AtomicReference<Disposable> implements j, Disposable {
    private static final long serialVersionUID = -6076952298809384986L;
    final pt.a onComplete;
    final g onError;
    final g onSuccess;

    public MaybeCallbackObserver(g r5, g r10, pt.a r11) {
        this.onSuccess = r5;
        this.onError = r10;
        this.onComplete = r11;
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
        return DisposableHelper.isDisposed(get());
    }

    @Override // mt.j
    public void onComplete() {
        lazySet(DisposableHelper.DISPOSED);
        this.onComplete.run();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        f.k(th);
    }

    @Override // mt.j
    public void onError(Throwable r5) {
        lazySet(DisposableHelper.DISPOSED);
        this.onError.accept(r5);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        f.k(new CompositeException(new Throwable[]{r5, th}));
    }

    @Override // mt.j
    public void onSubscribe(Disposable r5) {
        DisposableHelper.setOnce(this, r5);
    }

    @Override // mt.j
    public void onSuccess(T r5) {
        lazySet(DisposableHelper.DISPOSED);
        this.onSuccess.accept(r5);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        f.k(th);
    }
}
