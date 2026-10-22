package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableFlatMap$InnerObserver<T, U> extends AtomicReference<Disposable> implements mt.u {
    private static final long serialVersionUID = -4606175640614850599L;
    volatile boolean done;
    int fusionMode;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    final long f17697id;
    final ObservableFlatMap$MergeObserver<T, U> parent;
    volatile rt.h queue;

    public ObservableFlatMap$InnerObserver(ObservableFlatMap$MergeObserver<T, U> r5, long r10) {
        this.f17697id = r10;
        this.parent = r5;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // mt.u
    public void onComplete() {
        this.done = true;
        this.parent.drain();
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        if (this.parent.errors.addThrowable(r5) == false) goto L8;
        ObservableFlatMap$MergeObserver<T, U> r10 = this.parent;
        if (r10.delayErrors == true) goto L7;
        r10.disposeAll();
    L7:
        this.done = true;
        this.parent.drain();
        return;
    L8:
        wn.f.k(r5);
    }

    @Override // mt.u
    public void onNext(U r5) {
        if (this.fusionMode != 0) goto L5;
        this.parent.tryEmit(r5, this);
        return;
    L5:
        this.parent.drain();
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.setOnce(this, r5) == true) goto L5;
        return;
    L5:
        if ((r5 instanceof rt.c) == false) goto L15;
        rt.c r10 = (rt.c) r5;
        int r11 = r10.requestFusion(7);
        if (r11 != 1) goto L11;
        this.fusionMode = r11;
        this.queue = r10;
        this.done = true;
        this.parent.drain();
        return;
    L11:
        if (r11 != 2) goto L16;
        this.fusionMode = r11;
        this.queue = r10;
        return;
    L16:
        return;
    }
}
