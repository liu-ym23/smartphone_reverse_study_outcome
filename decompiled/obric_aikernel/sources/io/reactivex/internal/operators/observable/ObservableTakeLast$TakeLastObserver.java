package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableTakeLast$TakeLastObserver<T> extends ArrayDeque<T> implements xb.o<T>, io.reactivex.disposables.b {
    private static final long serialVersionUID = 7240042530241604978L;
    volatile boolean cancelled;
    final int count;
    final xb.o<? super T> downstream;
    io.reactivex.disposables.b upstream;

    ObservableTakeLast$TakeLastObserver(xb.o<? super T> r10, int r11) {
        this.downstream = r10;
        this.count = r11;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        if (this.cancelled == true) goto L6;
        this.cancelled = true;
        this.upstream.dispose();
        return;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // xb.o
    public void onComplete() {
        xb.o<? super T> r10 = this.downstream;
    L4:
        if (this.cancelled == true) goto L5;
        T r11 = poll();
        if (r11 == null) goto L9;
        r10.onNext(r11);
        goto L4
    L9:
        if (this.cancelled == true) goto L15;
        r10.onComplete();
        return;
    L15:
        return;
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
    }

    @Override // xb.o
    public void onNext(T r10) {
        if (this.count != size()) goto L5;
        poll();
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
