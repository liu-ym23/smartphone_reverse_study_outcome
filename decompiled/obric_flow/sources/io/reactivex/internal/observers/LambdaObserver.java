package io.reactivex.internal.observers;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import mt.u;

/* JADX INFO: loaded from: classes3.dex */
public final class LambdaObserver<T> extends AtomicReference<Disposable> implements u, Disposable {
    private static final long serialVersionUID = -7251123623727029452L;
    final pt.a onComplete;
    final pt.g onError;
    final pt.g onNext;
    final pt.g onSubscribe;

    public LambdaObserver(pt.g r5, pt.g r10, pt.a r11, pt.g r12) {
        this.onNext = r5;
        this.onError = r10;
        this.onComplete = r11;
        this.onSubscribe = r12;
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

    @Override // mt.u
    public void onComplete() {
        if (isDisposed() == true) goto L12;
        lazySet(DisposableHelper.DISPOSED);
        this.onComplete.run();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        wn.f.k(th);
        return;
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        if (isDisposed() == true) goto L9;
        lazySet(DisposableHelper.DISPOSED);
        this.onError.accept(r5);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        wn.f.k(new CompositeException(new Throwable[]{r5, th}));
        return;
    L9:
        wn.f.k(r5);
    }

    @Override // mt.u
    public void onNext(T r5) {
        if (isDisposed() == true) goto L11;
        this.onNext.accept(r5);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        get().dispose();
        onError(th);
        return;
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.setOnce(this, r5) == false) goto L11;
        this.onSubscribe.accept(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        r5.dispose();
        onError(th);
        return;
    }
}
