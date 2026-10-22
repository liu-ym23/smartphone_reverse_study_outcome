package io.reactivex.internal.observers;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class CallbackCompletableObserver extends AtomicReference<Disposable> implements mt.b, Disposable, pt.g {
    private static final long serialVersionUID = -4361286194466301354L;
    final pt.a onComplete;
    final pt.g onError;

    public CallbackCompletableObserver(pt.a r5) {
        this.onError = this;
        this.onComplete = r5;
    }

    @Override // pt.g
    public /* bridge */ /* synthetic */ void accept(Object r5) throws Exception {
        accept((Throwable) r5);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean hasCustomOnError() {
        if (this.onError == this) goto L5;
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

    @Override // mt.b
    public void onComplete() {
        this.onComplete.run();     // Catch: Throwable -> L4
    L6:
        lazySet(DisposableHelper.DISPOSED);
        return;
    L4:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        wn.f.k(th);
        goto L6
    }

    @Override // mt.b
    public void onError(Throwable r5) {
        this.onError.accept(r5);     // Catch: Throwable -> L4
    L6:
        lazySet(DisposableHelper.DISPOSED);
        return;
    L4:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        wn.f.k(th);
        goto L6
    }

    @Override // mt.b
    public void onSubscribe(Disposable r5) {
        DisposableHelper.setOnce(this, r5);
    }

    public void accept(Throwable r5) {
        wn.f.k(new OnErrorNotImplementedException(r5));
    }

    public CallbackCompletableObserver(pt.g r5, pt.a r10) {
        this.onError = r5;
        this.onComplete = r10;
    }
}
