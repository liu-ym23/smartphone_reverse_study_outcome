package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public final class ObservableScalarXMap$ScalarDisposable<T> extends AtomicInteger implements rt.c, Runnable {
    static final int FUSED = 1;
    static final int ON_COMPLETE = 3;
    static final int ON_NEXT = 2;
    static final int START = 0;
    private static final long serialVersionUID = 3880992722410194083L;
    final mt.u observer;
    final T value;

    public ObservableScalarXMap$ScalarDisposable(mt.u r5, T r10) {
        this.observer = r5;
        this.value = r10;
    }

    @Override // rt.h
    public void clear() {
        lazySet(3);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        set(3);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get() != 3) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // rt.h
    public boolean isEmpty() {
        if (get() != 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // rt.h
    public boolean offer(T r5) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // rt.h
    public T poll() throws Exception {
        if (get() != 1) goto L6;
        lazySet(3);
        return this.value;
    L6:
        return null;
    }

    @Override // rt.d
    public int requestFusion(int r5) {
        if ((r5 & 1) == 0) goto L6;
        lazySet(1);
        return 1;
    L6:
        return 0;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (get() == 0) goto L5;
        return;
    L5:
        if (compareAndSet(0, 2) == false) goto L11;
        this.observer.onNext(this.value);
        if (get() != 2) goto L12;
        lazySet(3);
        this.observer.onComplete();
        return;
    L12:
        return;
    }

    public boolean offer(T r5, T r10) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
