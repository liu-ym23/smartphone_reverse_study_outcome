package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableRefCount$RefCountObserver<T> extends AtomicBoolean implements mt.u, Disposable {
    private static final long serialVersionUID = -7419642935409022375L;
    final ObservableRefCount$RefConnection connection;
    final mt.u downstream;
    final a3 parent;
    Disposable upstream;

    public ObservableRefCount$RefCountObserver(mt.u r5, a3 r10, ObservableRefCount$RefConnection r11) {
        this.downstream = r5;
        this.parent = r10;
        this.connection = r11;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.upstream.dispose();
        if (compareAndSet(false, true) == false) goto L30;
        a3 r5 = this.parent;
        ObservableRefCount$RefConnection r10 = this.connection;
        monitor-enter(r5);
        ObservableRefCount$RefConnection r11 = r5.f17711c;     // Catch: Throwable -> L18
        if (r11 == null) goto L22;
        if (r11 != r10) goto L22;
        long r12 = r10.subscriberCount - 1;     // Catch: Throwable -> L18
        r10.subscriberCount = r12;     // Catch: Throwable -> L18
        if (r12 == 0) goto L13;
    L20:
        monitor-exit(r5);     // Catch: Throwable -> L18
    L27:
        return;
    L13:
        if (r10.connected == false) goto L20;
        r5.e(r10);     // Catch: Throwable -> L18
        monitor-exit(r5);     // Catch: Throwable -> L18
    L22:
        monitor-exit(r5);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    @Override // mt.u
    public void onComplete() {
        if (compareAndSet(false, true) == false) goto L6;
        this.parent.d(this.connection);
        this.downstream.onComplete();
        return;
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        if (compareAndSet(false, true) == false) goto L5;
        this.parent.d(this.connection);
        this.downstream.onError(r5);
        return;
    L5:
        wn.f.k(r5);
    }

    @Override // mt.u
    public void onNext(T r5) {
        this.downstream.onNext(r5);
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        return;
    }
}
