package io.reactivex.internal.observers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscArrayQueue;
import java.util.concurrent.atomic.AtomicReference;
import mt.u;

/* JADX INFO: loaded from: classes3.dex */
public final class InnerQueuedObserver<T> extends AtomicReference<Disposable> implements u, Disposable {
    private static final long serialVersionUID = -5417183359794346637L;
    volatile boolean done;
    int fusionMode;
    final g parent;
    final int prefetch;
    rt.h queue;

    public InnerQueuedObserver(g r5, int r10) {
        this.parent = r5;
        this.prefetch = r10;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public int fusionMode() {
        return this.fusionMode;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    public boolean isDone() {
        return this.done;
    }

    @Override // mt.u
    public void onComplete() {
        this.parent.innerComplete(this);
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        this.parent.innerError(this, r5);
    }

    @Override // mt.u
    public void onNext(T r5) {
        if (this.fusionMode != 0) goto L5;
        this.parent.innerNext(this, r5);
        return;
    L5:
        this.parent.drain();
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.setOnce(this, r5) == true) goto L5;
        return;
    L5:
        if ((r5 instanceof rt.c) == false) goto L14;
        rt.c r10 = (rt.c) r5;
        int r11 = r10.requestFusion(3);
        if (r11 != 1) goto L11;
        this.fusionMode = r11;
        this.queue = r10;
        this.done = true;
        this.parent.innerComplete(this);
        return;
    L11:
        if (r11 != 2) goto L14;
        this.fusionMode = r11;
        this.queue = r10;
        return;
    L14:
        int r12 = -this.prefetch;
        if (r12 >= 0) goto L17;
        rt.h r13 = new io.reactivex.internal.queue.b(-r12);
    L18:
        this.queue = r13;
        return;
    L17:
        r13 = new SpscArrayQueue(r12);
        goto L18
    }

    public rt.h queue() {
        return this.queue;
    }

    public void setDone() {
        this.done = true;
    }
}
