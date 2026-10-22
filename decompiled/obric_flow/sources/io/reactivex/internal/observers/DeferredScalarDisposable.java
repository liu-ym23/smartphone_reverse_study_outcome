package io.reactivex.internal.observers;

import mt.u;

/* JADX INFO: loaded from: classes3.dex */
public class DeferredScalarDisposable<T> extends BasicIntQueueDisposable<T> {
    static final int DISPOSED = 4;
    static final int FUSED_CONSUMED = 32;
    static final int FUSED_EMPTY = 8;
    static final int FUSED_READY = 16;
    static final int TERMINATED = 2;
    private static final long serialVersionUID = -5502432239815349361L;
    protected final u downstream;
    protected T value;

    public DeferredScalarDisposable(u r5) {
        this.downstream = r5;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, rt.h
    public final void clear() {
        lazySet(32);
        this.value = null;
    }

    public final void complete(T r5) {
        int r10 = get();
        if ((r10 & 54) == 0) goto L5;
        return;
    L5:
        u r11 = this.downstream;
        if (r10 != 8) goto L8;
        this.value = r5;
        lazySet(16);
        r11.onNext(null);
    L10:
        if (get() == 4) goto L13;
        r11.onComplete();
        return;
    L13:
        return;
    L8:
        lazySet(2);
        r11.onNext(r5);
        goto L10
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        set(4);
        this.value = null;
    }

    public final void error(Throwable r5) {
        if ((get() & 54) == 0) goto L6;
        wn.f.k(r5);
        return;
    L6:
        lazySet(2);
        this.downstream.onError(r5);
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        if (get() != 4) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, rt.h
    public final boolean isEmpty() {
        if (get() == 16) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, rt.h
    public final T poll() throws Exception {
        if (get() != 16) goto L6;
        T r5 = this.value;
        this.value = null;
        lazySet(32);
        return r5;
    L6:
        return null;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, rt.d
    public final int requestFusion(int r5) {
        if ((r5 & 2) == 0) goto L6;
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

    public final void complete() {
        if ((get() & 54) == 0) goto L5;
        return;
    L5:
        lazySet(2);
        this.downstream.onComplete();
    }
}
