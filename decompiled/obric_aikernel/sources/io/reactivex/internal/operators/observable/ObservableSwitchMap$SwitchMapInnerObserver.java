package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableSwitchMap$SwitchMapInnerObserver<T, R> extends AtomicReference<io.reactivex.disposables.b> implements xb.o<R> {
    private static final long serialVersionUID = 3837284832786408377L;
    final int bufferSize;
    volatile boolean done;
    final long index;
    final ObservableSwitchMap$SwitchMapObserver<T, R> parent;
    volatile bc.f<R> queue;

    ObservableSwitchMap$SwitchMapInnerObserver(ObservableSwitchMap$SwitchMapObserver<T, R> r10, long r11, int r12) {
        this.parent = r10;
        this.index = r11;
        this.bufferSize = r12;
    }

    public void cancel() {
        DisposableHelper.dispose(this);
    }

    @Override // xb.o
    public void onComplete() {
        if (this.index != this.parent.unique) goto L6;
        this.done = true;
        this.parent.drain();
        return;
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        this.parent.innerError(this, r10);
    }

    @Override // xb.o
    public void onNext(R r10) {
        if (this.index != this.parent.unique) goto L8;
        if (r10 == null) goto L6;
        this.queue.offer(r10);
    L6:
        this.parent.drain();
        return;
    }

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
        if (DisposableHelper.setOnce(this, r10) == true) goto L5;
        return;
    L5:
        if ((r10 instanceof bc.b) == false) goto L14;
        bc.b r11 = (bc.b) r10;
        int r12 = r11.requestFusion(7);
        if (r12 != 1) goto L11;
        this.queue = r11;
        this.done = true;
        this.parent.drain();
        return;
    L11:
        if (r12 != 2) goto L14;
        this.queue = r11;
        return;
    L14:
        this.queue = new io.reactivex.internal.queue.a(this.bufferSize);
    }
}
