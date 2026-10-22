package io.reactivex.internal.observers;

import bc.f;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.h;
import java.util.concurrent.atomic.AtomicReference;
import xb.o;

/* JADX INFO: loaded from: classes2.dex */
public final class InnerQueuedObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements o<T>, io.reactivex.disposables.b {
    private static final long serialVersionUID = -5417183359794346637L;
    volatile boolean done;
    int fusionMode;
    final a<T> parent;
    final int prefetch;
    f<T> queue;

    public InnerQueuedObserver(a<T> r10, int r11) {
        this.parent = r10;
        this.prefetch = r11;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public int fusionMode() {
        return this.fusionMode;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    public boolean isDone() {
        return this.done;
    }

    @Override // xb.o
    public void onComplete() {
        this.parent.innerComplete(this);
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        this.parent.innerError(this, r10);
    }

    @Override // xb.o
    public void onNext(T r10) {
        if (this.fusionMode != 0) goto L5;
        this.parent.innerNext(this, r10);
        return;
    L5:
        this.parent.drain();
    }

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
        if (DisposableHelper.setOnce(this, r10) == true) goto L5;
        return;
    L5:
        if ((r10 instanceof bc.b) == false) goto L14;
        bc.b r11 = (bc.b) r10;
        int r12 = r11.requestFusion(3);
        if (r12 != 1) goto L11;
        this.fusionMode = r12;
        this.queue = r11;
        this.done = true;
        this.parent.innerComplete(this);
        return;
    L11:
        if (r12 != 2) goto L14;
        this.fusionMode = r12;
        this.queue = r11;
        return;
    L14:
        this.queue = h.a(-this.prefetch);
    }

    public f<T> queue() {
        return this.queue;
    }

    public void setDone() {
        this.done = true;
    }
}
