package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableDoFinally$DoFinallyObserver<T> extends BasicIntQueueDisposable<T> implements mt.u {
    private static final long serialVersionUID = 4109457741734051389L;
    final mt.u downstream;
    final pt.a onFinally;
    rt.c qd;
    boolean syncFused;
    Disposable upstream;

    public ObservableDoFinally$DoFinallyObserver(mt.u r5, pt.a r10) {
        this.downstream = r5;
        this.onFinally = r10;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, rt.h
    public void clear() {
        this.qd.clear();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.upstream.dispose();
        runFinally();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, rt.h
    public boolean isEmpty() {
        return this.qd.isEmpty();
    }

    @Override // mt.u
    public void onComplete() {
        this.downstream.onComplete();
        runFinally();
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        this.downstream.onError(r5);
        runFinally();
    }

    @Override // mt.u
    public void onNext(T r5) {
        this.downstream.onNext(r5);
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.upstream, r5) == false) goto L9;
        this.upstream = r5;
        if ((r5 instanceof rt.c) == false) goto L7;
        this.qd = (rt.c) r5;
    L7:
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, rt.h
    public T poll() throws Exception {
        T r5 = (T) this.qd.poll();
        if (r5 == null) goto L5;
    L7:
        return r5;
    L5:
        if (this.syncFused == false) goto L7;
        runFinally();
        goto L7
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, rt.d
    public int requestFusion(int r5) {
        rt.c r10 = this.qd;
        boolean r11 = false;
        if (r10 != null) goto L5;
    L13:
        return 0;
    L5:
        if ((r5 & 4) != 0) goto L13;
        int r12 = r10.requestFusion(r5);
        if (r12 != 0) goto L9;
    L12:
        return r12;
    L9:
        if (r12 != 1) goto L11;
        r11 = true;
    L11:
        this.syncFused = r11;
        goto L12
    }

    public void runFinally() {
        if (compareAndSet(0, 1) == false) goto L11;
        this.onFinally.run();     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        wn.f.k(th);
        return;
    }
}
