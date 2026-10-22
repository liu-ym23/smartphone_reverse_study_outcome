package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import xb.j;
import xb.k;

/* JADX INFO: loaded from: classes2.dex */
final class MaybeTimeoutMaybe$TimeoutMainMaybeObserver<T, U> extends AtomicReference<io.reactivex.disposables.b> implements j<T>, io.reactivex.disposables.b {
    private static final long serialVersionUID = -5955289211445418871L;
    final j<? super T> downstream;
    final k<? extends T> fallback;
    final MaybeTimeoutMaybe$TimeoutOtherMaybeObserver<T, U> other;
    final MaybeTimeoutMaybe$TimeoutFallbackMaybeObserver<T> otherObserver;

    MaybeTimeoutMaybe$TimeoutMainMaybeObserver(j<? super T> r10, k<? extends T> r11) {
        this.downstream = r10;
        this.other = new MaybeTimeoutMaybe$TimeoutOtherMaybeObserver(this);
        this.fallback = r11;
        if (r11 == null) goto L5;
        MaybeTimeoutMaybe$TimeoutFallbackMaybeObserver<T> r12 = new MaybeTimeoutMaybe$TimeoutFallbackMaybeObserver(r10);
    L6:
        this.otherObserver = r12;
        return;
    L5:
        r12 = null;
        goto L6
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this);
        DisposableHelper.dispose(this.other);
        MaybeTimeoutMaybe$TimeoutFallbackMaybeObserver<T> r10 = this.otherObserver;
        if (r10 == null) goto L6;
        DisposableHelper.dispose(r10);
        return;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // xb.j
    public void onComplete() {
        DisposableHelper.dispose(this.other);
        DisposableHelper r10 = DisposableHelper.DISPOSED;
        if (getAndSet(r10) == r10) goto L6;
        this.downstream.onComplete();
        return;
    }

    @Override // xb.j
    public void onError(Throwable r10) {
        DisposableHelper.dispose(this.other);
        DisposableHelper r11 = DisposableHelper.DISPOSED;
        if (getAndSet(r11) == r11) goto L5;
        this.downstream.onError(r10);
        return;
    L5:
        dc.a.n(r10);
    }

    @Override // xb.j
    public void onSubscribe(io.reactivex.disposables.b r10) {
        DisposableHelper.setOnce(this, r10);
    }

    @Override // xb.j
    public void onSuccess(T r10) {
        DisposableHelper.dispose(this.other);
        DisposableHelper r11 = DisposableHelper.DISPOSED;
        if (getAndSet(r11) == r11) goto L6;
        this.downstream.onSuccess(r10);
        return;
    }

    public void otherComplete() {
        if (DisposableHelper.dispose(this) == false) goto L9;
        k<? extends T> r10 = this.fallback;
        if (r10 != null) goto L7;
        this.downstream.onError(new TimeoutException());
        return;
    L7:
        r10.a(this.otherObserver);
        return;
    }

    public void otherError(Throwable r10) {
        if (DisposableHelper.dispose(this) == false) goto L5;
        this.downstream.onError(r10);
        return;
    L5:
        dc.a.n(r10);
    }
}
