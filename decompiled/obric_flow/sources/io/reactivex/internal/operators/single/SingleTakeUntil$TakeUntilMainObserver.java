package io.reactivex.internal.operators.single;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import mt.b0;
import wn.f;

/* JADX INFO: loaded from: classes3.dex */
final class SingleTakeUntil$TakeUntilMainObserver<T> extends AtomicReference<Disposable> implements b0, Disposable {
    private static final long serialVersionUID = -622603812305745221L;
    final b0 downstream;
    final SingleTakeUntil$TakeUntilOtherSubscriber other;

    public SingleTakeUntil$TakeUntilMainObserver(b0 r5) {
        this.downstream = r5;
        this.other = new SingleTakeUntil$TakeUntilOtherSubscriber(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
        this.other.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // mt.b0, mt.j
    public void onError(Throwable r5) {
        this.other.dispose();
        Disposable r10 = get();
        DisposableHelper r11 = DisposableHelper.DISPOSED;
        if (r10 != r11) goto L5;
    L8:
        f.k(r5);
        return;
    L5:
        if (getAndSet(r11) == r11) goto L8;
        this.downstream.onError(r5);
    }

    @Override // mt.b0, mt.j
    public void onSubscribe(Disposable r5) {
        DisposableHelper.setOnce(this, r5);
    }

    @Override // mt.b0, mt.j
    public void onSuccess(T r5) {
        this.other.dispose();
        DisposableHelper r10 = DisposableHelper.DISPOSED;
        if (getAndSet(r10) == r10) goto L6;
        this.downstream.onSuccess(r5);
        return;
    }

    public void otherError(Throwable r5) {
        Disposable r10 = get();
        DisposableHelper r11 = DisposableHelper.DISPOSED;
        if (r10 == r11) goto L10;
        Disposable r12 = getAndSet(r11);
        if (r12 == r11) goto L10;
        if (r12 == null) goto L8;
        r12.dispose();
    L8:
        this.downstream.onError(r5);
        return;
    L10:
        f.k(r5);
    }
}
