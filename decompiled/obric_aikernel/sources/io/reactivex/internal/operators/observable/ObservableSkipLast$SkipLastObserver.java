package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableSkipLast$SkipLastObserver<T> extends ArrayDeque<T> implements xb.o<T>, io.reactivex.disposables.b {
    private static final long serialVersionUID = -3807491841935125653L;
    final xb.o<? super T> downstream;
    final int skip;
    io.reactivex.disposables.b upstream;

    ObservableSkipLast$SkipLastObserver(xb.o<? super T> r10, int r11) {
        super(r11);
        this.downstream = r10;
        this.skip = r11;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.upstream.dispose();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    @Override // xb.o
    public void onComplete() {
        this.downstream.onComplete();
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
    }

    @Override // xb.o
    public void onNext(T r10) {
        if (this.skip != size()) goto L5;
        this.downstream.onNext(poll());
    L5:
        offer(r10);
    }

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }
}
