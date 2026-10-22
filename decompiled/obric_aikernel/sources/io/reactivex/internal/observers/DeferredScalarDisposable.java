package io.reactivex.internal.observers;

import xb.o;

/* JADX INFO: loaded from: classes2.dex */
public class DeferredScalarDisposable<T> extends BasicIntQueueDisposable<T> {
    static final int DISPOSED = 4;
    static final int FUSED_CONSUMED = 32;
    static final int FUSED_EMPTY = 8;
    static final int FUSED_READY = 16;
    static final int TERMINATED = 2;
    private static final long serialVersionUID = -5502432239815349361L;
    protected final o<? super T> downstream;
    protected T value;

    public DeferredScalarDisposable(o<? super T> r10) {
        this.downstream = r10;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, bc.f
    public final void clear() {
        lazySet(32);
        this.value = null;
    }

    public final void complete() {
        if ((get() & 54) == 0) goto L5;
        return;
    L5:
        lazySet(2);
        this.downstream.onComplete();
    }

    public final void complete(T r10) {
        int r11 = get();
        if ((r11 & 54) == 0) goto L5;
        return;
    L5:
        o<? super T> r12 = this.downstream;
        if (r11 != 8) goto L8;
        this.value = r10;
        lazySet(16);
        r10 = null;
    L9:
        r12.onNext(r10);
        if (get() == 4) goto L13;
        r12.onComplete();
        return;
    L13:
        return;
    L8:
        lazySet(2);
        goto L9
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, io.reactivex.disposables.b
    public void dispose() {
        set(4);
        this.value = null;
    }

    public final void error(Throwable r10) {
        if ((get() & 54) == 0) goto L6;
        dc.a.n(r10);
        return;
    L6:
        lazySet(2);
        this.downstream.onError(r10);
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, io.reactivex.disposables.b
    public final boolean isDisposed() {
        if (get() != 4) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, bc.f
    public final boolean isEmpty() {
        if (get() == 16) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, bc.f
    public final T poll() {
        if (get() != 16) goto L6;
        T r10 = this.value;
        this.value = null;
        lazySet(32);
        return r10;
    L6:
        return null;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, bc.c
    public final int requestFusion(int r10) {
        if ((r10 & 2) == 0) goto L6;
        lazySet(8);
        return 2;
    L6:
        return 0;
    }

    public final boolean tryDispose() {
        if (getAndSet(4) == 4) goto L5;
        return true;
    L5:
        return false;
    }
}
