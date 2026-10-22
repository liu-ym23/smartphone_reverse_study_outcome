package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableCreate$CreateEmitter<T> extends AtomicReference<Disposable> implements mt.p, Disposable {
    private static final long serialVersionUID = -3434801548987643227L;
    final mt.u observer;

    public ObservableCreate$CreateEmitter(mt.u r5) {
        this.observer = r5;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // mt.p, io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // mt.d
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

    @Override // mt.d
    public void onError(Throwable r5) {
        if (tryOnError(r5) == true) goto L6;
        wn.f.k(r5);
        return;
    }

    @Override // mt.d
    public void onNext(T r5) {
        if (r5 != null) goto L6;
        onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
        return;
    L6:
        if (isDisposed() == true) goto L9;
        this.observer.onNext(r5);
        return;
    }

    public mt.p serialize() {
        return new ObservableCreate$SerializedEmitter(this);
    }

    @Override // mt.p
    public void setCancellable(pt.f r5) {
        setDisposable(new CancellableDisposable(r5));
    }

    @Override // mt.p
    public void setDisposable(Disposable r5) {
        DisposableHelper.set(this, r5);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public String toString() {
        return androidx.room.jarjarred.org.antlr.runtime.a.q(ObservableCreate$CreateEmitter.class.getSimpleName(), "{", super.toString(), "}");
    }

    public boolean tryOnError(Throwable r5) {
        if (r5 != null) goto L5;
        r5 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
    L5:
        if (isDisposed() == false) goto L14;
        return false;
    L14:
        this.observer.onError(r5);     // Catch: Throwable -> L9
        dispose();
        return true;
    L9:
        th = move-exception;
        dispose();
        throw th;
    }
}
