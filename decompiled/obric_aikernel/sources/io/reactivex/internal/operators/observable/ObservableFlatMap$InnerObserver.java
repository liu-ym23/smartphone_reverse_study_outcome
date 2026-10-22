package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableFlatMap$InnerObserver<T, U> extends AtomicReference<io.reactivex.disposables.b> implements xb.o<U> {
    private static final long serialVersionUID = -4606175640614850599L;
    volatile boolean done;
    int fusionMode;
    final long id;
    final ObservableFlatMap$MergeObserver<T, U> parent;
    volatile bc.f<U> queue;

    ObservableFlatMap$InnerObserver(ObservableFlatMap$MergeObserver<T, U> r10, long r11) {
        this.id = r11;
        this.parent = r10;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // xb.o
    public void onComplete() {
        this.done = true;
        this.parent.drain();
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        if (this.parent.errors.addThrowable(r10) == false) goto L8;
        ObservableFlatMap$MergeObserver<T, U> r11 = this.parent;
        if (r11.delayErrors == true) goto L7;
        r11.disposeAll();
    L7:
        this.done = true;
        this.parent.drain();
        return;
    L8:
        dc.a.n(r10);
    }

    @Override // xb.o
    public void onNext(U r10) {
        if (this.fusionMode != 0) goto L5;
        this.parent.tryEmit(r10, this);
        return;
    L5:
        this.parent.drain();
    }

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
        if (DisposableHelper.setOnce(this, r10) == true) goto L5;
        return;
    L5:
        if ((r10 instanceof bc.b) == false) goto L15;
        bc.b r11 = (bc.b) r10;
        int r12 = r11.requestFusion(7);
        if (r12 != 1) goto L11;
        this.fusionMode = r12;
        this.queue = r11;
        this.done = true;
        this.parent.drain();
        return;
    L11:
        if (r12 != 2) goto L16;
        this.fusionMode = r12;
        this.queue = r11;
        return;
    L16:
        return;
    }
}
