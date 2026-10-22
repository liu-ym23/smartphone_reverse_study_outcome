package io.reactivex.internal.operators.maybe;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import mt.h;
import mt.j;
import mt.k;
import wn.f;

/* JADX INFO: loaded from: classes3.dex */
final class MaybeTimeoutPublisher$TimeoutMainMaybeObserver<T, U> extends AtomicReference<Disposable> implements j, Disposable {
    private static final long serialVersionUID = -5955289211445418871L;
    final j downstream;
    final k fallback;
    final MaybeTimeoutPublisher$TimeoutOtherMaybeObserver<T, U> other;
    final MaybeTimeoutPublisher$TimeoutFallbackMaybeObserver<T> otherObserver;

    public MaybeTimeoutPublisher$TimeoutMainMaybeObserver(j r5, k r10) {
        this.downstream = r5;
        this.other = new MaybeTimeoutPublisher$TimeoutOtherMaybeObserver(this);
        this.fallback = r10;
        if (r10 == null) goto L5;
        MaybeTimeoutPublisher$TimeoutFallbackMaybeObserver<T> r11 = new MaybeTimeoutPublisher$TimeoutFallbackMaybeObserver(r5);
    L6:
        this.otherObserver = r11;
        return;
    L5:
        r11 = null;
        goto L6
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
        SubscriptionHelper.cancel(this.other);
        MaybeTimeoutPublisher$TimeoutFallbackMaybeObserver<T> r5 = this.otherObserver;
        if (r5 == null) goto L6;
        DisposableHelper.dispose(r5);
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // mt.j
    public void onComplete() {
        SubscriptionHelper.cancel(this.other);
        DisposableHelper r5 = DisposableHelper.DISPOSED;
        if (getAndSet(r5) == r5) goto L6;
        this.downstream.onComplete();
        return;
    }

    @Override // mt.j
    public void onError(Throwable r5) {
        SubscriptionHelper.cancel(this.other);
        DisposableHelper r10 = DisposableHelper.DISPOSED;
        if (getAndSet(r10) == r10) goto L5;
        this.downstream.onError(r5);
        return;
    L5:
        f.k(r5);
    }

    @Override // mt.j
    public void onSubscribe(Disposable r5) {
        DisposableHelper.setOnce(this, r5);
    }

    @Override // mt.j
    public void onSuccess(T r5) {
        SubscriptionHelper.cancel(this.other);
        DisposableHelper r10 = DisposableHelper.DISPOSED;
        if (getAndSet(r10) == r10) goto L6;
        this.downstream.onSuccess(r5);
        return;
    }

    public void otherComplete() {
        if (DisposableHelper.dispose(this) == false) goto L9;
        k r5 = this.fallback;
        if (r5 != null) goto L7;
        this.downstream.onError(new TimeoutException());
        return;
    L7:
        h r10 = (h) r5;
        r10.b(this.otherObserver);
        return;
    }

    public void otherError(Throwable r5) {
        if (DisposableHelper.dispose(this) == false) goto L5;
        this.downstream.onError(r5);
        return;
    L5:
        f.k(r5);
    }
}
