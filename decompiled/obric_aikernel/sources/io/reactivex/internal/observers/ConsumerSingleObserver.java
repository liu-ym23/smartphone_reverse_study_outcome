package io.reactivex.internal.observers;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.Functions;
import java.util.concurrent.atomic.AtomicReference;
import xb.r;
import zb.g;

/* JADX INFO: loaded from: classes2.dex */
public final class ConsumerSingleObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements r<T>, io.reactivex.disposables.b {
    private static final long serialVersionUID = -7012088219455310787L;
    final g<? super Throwable> onError;
    final g<? super T> onSuccess;

    public ConsumerSingleObserver(g<? super T> r10, g<? super Throwable> r11) {
        this.onSuccess = r10;
        this.onError = r11;
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
        if (get() != DisposableHelper.DISPOSED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // xb.r
    public void onError(Throwable r10) {
        lazySet(DisposableHelper.DISPOSED);
        this.onError.accept(r10);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        dc.a.n(new CompositeException(new Throwable[]{r10, th}));
    }

    @Override // xb.r
    public void onSubscribe(io.reactivex.disposables.b r10) {
        DisposableHelper.setOnce(this, r10);
    }

    @Override // xb.r
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
