package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableSwitchMap$SwitchMapInnerObserver<T, R> extends AtomicReference<Disposable> implements mt.u {
    private static final long serialVersionUID = 3837284832786408377L;
    final int bufferSize;
    volatile boolean done;
    final long index;
    final ObservableSwitchMap$SwitchMapObserver<T, R> parent;
    volatile rt.h queue;

    public ObservableSwitchMap$SwitchMapInnerObserver(ObservableSwitchMap$SwitchMapObserver<T, R> r5, long r10, int r11) {
        this.parent = r5;
        this.index = r10;
        this.bufferSize = r11;
    }

    public void cancel() {
        DisposableHelper.dispose(this);
    }

    @Override // mt.u
    public void onComplete() {
        if (this.index != this.parent.unique) goto L6;
        this.done = true;
        this.parent.drain();
        return;
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        this.parent.innerError(this, r5);
    }

    @Override // mt.u
    public void onNext(R r5) {
        if (this.index != this.parent.unique) goto L8;
        if (r5 == null) goto L6;
        this.queue.offer(r5);
    L6:
        this.parent.drain();
        return;
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.setOnce(this, r5) == true) goto L5;
        return;
    L5:
        if ((r5 instanceof rt.c) == false) goto L14;
        rt.c r10 = (rt.c) r5;
        int r11 = r10.requestFusion(7);
        if (r11 != 1) goto L11;
        this.queue = r10;
        this.done = true;
        this.parent.drain();
        return;
    L11:
        if (r11 != 2) goto L14;
        this.queue = r10;
        return;
    L14:
        this.queue = new io.reactivex.internal.queue.b(this.bufferSize);
    }
}
