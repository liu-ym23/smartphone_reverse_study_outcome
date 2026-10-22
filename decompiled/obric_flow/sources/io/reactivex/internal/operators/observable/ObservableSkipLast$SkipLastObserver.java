package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableSkipLast$SkipLastObserver<T> extends ArrayDeque<T> implements mt.u, Disposable {
    private static final long serialVersionUID = -3807491841935125653L;
    final mt.u downstream;
    final int skip;
    Disposable upstream;

    public ObservableSkipLast$SkipLastObserver(mt.u r5, int r10) {
        super(r10);
        this.downstream = r5;
        this.skip = r10;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.upstream.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    @Override // mt.u
    public void onComplete() {
        this.downstream.onComplete();
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        this.downstream.onError(r5);
    }

    @Override // mt.u
    public void onNext(T r5) {
        if (this.skip != size()) goto L5;
        this.downstream.onNext(poll());
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
