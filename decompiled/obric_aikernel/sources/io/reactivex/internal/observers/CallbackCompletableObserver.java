package io.reactivex.internal.observers;

import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import zb.g;

/* JADX INFO: loaded from: classes2.dex */
public final class CallbackCompletableObserver extends AtomicReference<io.reactivex.disposables.b> implements xb.b, io.reactivex.disposables.b, g<Throwable> {
    private static final long serialVersionUID = -4361286194466301354L;
    final zb.a onComplete;
    final g<? super Throwable> onError;

    public CallbackCompletableObserver(zb.a r10) {
        this.onError = this;
        this.onComplete = r10;
    }

    public CallbackCompletableObserver(g<? super Throwable> r10, zb.a r11) {
        this.onError = r10;
        this.onComplete = r11;
    }

    @Override // zb.g
    public /* bridge */ /* synthetic */ void accept(Throwable r10) {
        accept2(r10);
    }

    /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
    public void accept2(Throwable r10) {
        dc.a.n(new OnErrorNotImplementedException(r10));
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean hasCustomOnError() {
        if (this.onError == this) goto L5;
        return true;
    L5:
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
        this.onComplete.run();     // Catch: Throwable -> L4
    L6:
        lazySet(DisposableHelper.DISPOSED);
        return;
    L4:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        dc.a.n(th);
        goto L6
    }

    @Override // xb.b
    public void onError(Throwable r10) {
        this.onError.accept(r10);     // Catch: Throwable -> L4
    L6:
        lazySet(DisposableHelper.DISPOSED);
        return;
    L4:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        dc.a.n(th);
        goto L6
    }

    @Override // xb.b
    public void onSubscribe(io.reactivex.disposables.b r10) {
        DisposableHelper.setOnce(this, r10);
    }
}
