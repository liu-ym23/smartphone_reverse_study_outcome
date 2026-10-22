package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableCreate$CreateEmitter<T> extends AtomicReference<io.reactivex.disposables.b> implements xb.m<T>, io.reactivex.disposables.b {
    private static final long serialVersionUID = -3434801548987643227L;
    final xb.o<? super T> observer;

    ObservableCreate$CreateEmitter(xb.o<? super T> r10) {
        this.observer = r10;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // xb.m, io.reactivex.disposables.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // xb.d
    public void onComplete() {
        if (isDisposed() == false) goto L10;
        return;
    L10:
        this.observer.onComplete();     // Catch: Throwable -> L6
        dispose();
        return;
    L6:
        th = move-exception;
        dispose();
        throw th;
    }

    @Override // xb.d
    public void onError(Throwable r10) {
        if (tryOnError(r10) == true) goto L6;
        dc.a.n(r10);
        return;
    }

    @Override // xb.d
    public void onNext(T r10) {
        if (r10 != null) goto L6;
        onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
        return;
    L6:
        if (isDisposed() == true) goto L9;
        this.observer.onNext(r10);
        return;
    }

    public xb.m<T> serialize() {
        return new ObservableCreate$SerializedEmitter(this);
    }

    @Override // xb.m
    public void setCancellable(zb.f r10) {
        setDisposable(new CancellableDisposable(r10));
    }

    @Override // xb.m
    public void setDisposable(io.reactivex.disposables.b r10) {
        DisposableHelper.set(this, r10);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public String toString() {
        return String.format("%s{%s}", new Object[]{ObservableCreate$CreateEmitter.class.getSimpleName(), super.toString()});
    }

    public boolean tryOnError(Throwable r10) {
        if (r10 != null) goto L5;
        r10 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
    L5:
        if (isDisposed() == false) goto L14;
        return false;
    L14:
        this.observer.onError(r10);     // Catch: Throwable -> L9
        dispose();
        return true;
    L9:
        th = move-exception;
        dispose();
        throw th;
    }
}
