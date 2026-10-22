package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableDoFinally$DoFinallyObserver<T> extends BasicIntQueueDisposable<T> implements xb.o<T> {
    private static final long serialVersionUID = 4109457741734051389L;
    final xb.o<? super T> downstream;
    final zb.a onFinally;
    bc.b<T> qd;
    boolean syncFused;
    io.reactivex.disposables.b upstream;

    ObservableDoFinally$DoFinallyObserver(xb.o<? super T> r10, zb.a r11) {
        this.downstream = r10;
        this.onFinally = r11;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, bc.f
    public void clear() {
        this.qd.clear();
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, io.reactivex.disposables.b
    public void dispose() {
        this.upstream.dispose();
        runFinally();
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, bc.f
    public boolean isEmpty() {
        return this.qd.isEmpty();
    }

    @Override // xb.o
    public void onComplete() {
        this.downstream.onComplete();
        runFinally();
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
        runFinally();
    }

    @Override // xb.o
    public void onNext(T r10) {
        this.downstream.onNext(r10);
    }

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L9;
        this.upstream = r10;
        if ((r10 instanceof bc.b) == false) goto L7;
        this.qd = (bc.b) r10;
    L7:
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, bc.f
    public T poll() {
        T r10 = this.qd.poll();
        if (r10 == null) goto L5;
    L7:
        return r10;
    L5:
        if (this.syncFused == false) goto L7;
        runFinally();
        goto L7
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, bc.c
    public int requestFusion(int r10) {
        bc.b<T> r11 = this.qd;
        boolean r12 = false;
        if (r11 != null) goto L5;
    L13:
        return 0;
    L5:
        if ((r10 & 4) != 0) goto L13;
        int r13 = r11.requestFusion(r10);
        if (r13 != 0) goto L9;
    L12:
        return r13;
    L9:
        if (r13 != 1) goto L11;
        r12 = true;
    L11:
        this.syncFused = r12;
        goto L12
    }

    void runFinally() {
        if (compareAndSet(0, 1) == false) goto L11;
        this.onFinally.run();     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        dc.a.n(th);
        return;
    }
}
