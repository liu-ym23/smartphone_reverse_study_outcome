package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class ObservableScalarXMap$ScalarDisposable<T> extends AtomicInteger implements bc.b<T>, Runnable {
    static final int FUSED = 1;
    static final int ON_COMPLETE = 3;
    static final int ON_NEXT = 2;
    static final int START = 0;
    private static final long serialVersionUID = 3880992722410194083L;
    final xb.o<? super T> observer;
    final T value;

    public ObservableScalarXMap$ScalarDisposable(xb.o<? super T> r10, T r11) {
        this.observer = r10;
        this.value = r11;
    }

    @Override // bc.f
    public void clear() {
        lazySet(3);
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        set(3);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        if (get() != 3) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // bc.f
    public boolean isEmpty() {
        if (get() != 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // bc.f
    public boolean offer(T r10) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public boolean offer(T r10, T r11) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // bc.f
    public T poll() {
        if (get() != 1) goto L6;
        lazySet(3);
        return this.value;
    L6:
        return null;
    }

    @Override // bc.c
    public int requestFusion(int r10) {
        if ((r10 & 1) == 0) goto L6;
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
}
