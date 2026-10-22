package io.reactivex.internal.operators.maybe;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.Functions;
import java.util.concurrent.atomic.AtomicReference;
import xb.j;
import zb.g;

/* JADX INFO: loaded from: classes2.dex */
public final class MaybeCallbackObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements j<T>, io.reactivex.disposables.b {
    private static final long serialVersionUID = -6076952298809384986L;
    final zb.a onComplete;
    final g<? super Throwable> onError;
    final g<? super T> onSuccess;

    public MaybeCallbackObserver(g<? super T> r10, g<? super Throwable> r11, zb.a r12) {
        this.onSuccess = r10;
        this.onError = r11;
        this.onComplete = r12;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean hasCustomOnError() {
        if (this.onError == Functions.f9489d) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // xb.j
    public void onComplete() {
        lazySet(DisposableHelper.DISPOSED);
        this.onComplete.run();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        dc.a.n(th);
    }

    @Override // xb.j
    public void onError(Throwable r10) {
        lazySet(DisposableHelper.DISPOSED);
        this.onError.accept(r10);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        dc.a.n(new CompositeException(new Throwable[]{r10, th}));
    }

    @Override // xb.j
    public void onSubscribe(io.reactivex.disposables.b r10) {
        DisposableHelper.setOnce(this, r10);
    }

    @Override // xb.j
    public void onSuccess(T r10) {
        lazySet(DisposableHelper.DISPOSED);
        this.onSuccess.accept(r10);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        dc.a.n(th);
    }
}
