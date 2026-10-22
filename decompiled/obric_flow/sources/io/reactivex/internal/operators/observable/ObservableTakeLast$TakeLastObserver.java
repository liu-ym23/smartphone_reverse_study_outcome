package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableTakeLast$TakeLastObserver<T> extends ArrayDeque<T> implements mt.u, Disposable {
    private static final long serialVersionUID = 7240042530241604978L;
    volatile boolean cancelled;
    final int count;
    final mt.u downstream;
    Disposable upstream;

    public ObservableTakeLast$TakeLastObserver(mt.u r5, int r10) {
        this.downstream = r5;
        this.count = r10;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (this.cancelled == true) goto L6;
        this.cancelled = true;
        this.upstream.dispose();
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // mt.u
    public void onComplete() {
        mt.u r5 = this.downstream;
    L4:
        if (this.cancelled == true) goto L5;
        T r10 = poll();
        if (r10 == null) goto L9;
        r5.onNext(r10);
        goto L4
    L9:
        if (this.cancelled == true) goto L15;
        r5.onComplete();
        return;
    L15:
        return;
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        this.downstream.onError(r5);
    }

    @Override // mt.u
    public void onNext(T r5) {
        if (this.count != size()) goto L5;
        poll();
    L5:
        offer(r5);
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        return;
    }
}
