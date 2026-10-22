package io.reactivex.internal.operators.single;

import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xb.r;

/* JADX INFO: loaded from: classes2.dex */
final class SingleTakeUntil$TakeUntilMainObserver<T> extends AtomicReference<b> implements r<T>, b {
    private static final long serialVersionUID = -622603812305745221L;
    final r<? super T> downstream;
    final SingleTakeUntil$TakeUntilOtherSubscriber other;

    SingleTakeUntil$TakeUntilMainObserver(r<? super T> r10) {
        this.downstream = r10;
        this.other = new SingleTakeUntil$TakeUntilOtherSubscriber(this);
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this);
        this.other.dispose();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // xb.r
    public void onError(Throwable r10) {
        this.other.dispose();
        b r11 = get();
        DisposableHelper r12 = DisposableHelper.DISPOSED;
        if (r11 != r12) goto L5;
    L8:
        dc.a.n(r10);
        return;
    L5:
        if (getAndSet(r12) == r12) goto L8;
        this.downstream.onError(r10);
    }

    @Override // xb.r
    public void onSubscribe(b r10) {
        DisposableHelper.setOnce(this, r10);
    }

    @Override // xb.r
    public void onSuccess(T r10) {
        this.other.dispose();
        DisposableHelper r11 = DisposableHelper.DISPOSED;
        if (getAndSet(r11) == r11) goto L6;
        this.downstream.onSuccess(r10);
        return;
    }

    void otherError(Throwable r10) {
        b r11 = get();
        DisposableHelper r12 = DisposableHelper.DISPOSED;
        if (r11 == r12) goto L10;
        b r13 = getAndSet(r12);
        if (r13 == r12) goto L10;
        if (r13 == null) goto L8;
        r13.dispose();
    L8:
        this.downstream.onError(r10);
        return;
    L10:
        dc.a.n(r10);
    }
}
