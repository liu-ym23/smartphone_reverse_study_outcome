package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableRepeat$RepeatObserver<T> extends AtomicInteger implements xb.o<T> {
    private static final long serialVersionUID = -7098360935104053232L;
    final xb.o<? super T> downstream;
    long remaining;
    final SequentialDisposable sd;
    final xb.n<? extends T> source;

    ObservableRepeat$RepeatObserver(xb.o<? super T> r10, long r11, SequentialDisposable r12, xb.n<? extends T> r13) {
        this.downstream = r10;
        this.sd = r12;
        this.source = r13;
        this.remaining = r11;
    }

    @Override // xb.o
    public void onComplete() {
        long r10 = this.remaining;
        if (r10 == Long.MAX_VALUE) goto L6;
        this.remaining = r10 - 1;
    L6:
        if (r10 == 0) goto L8;
        subscribeNext();
        return;
    L8:
        this.downstream.onComplete();
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
    }

    @Override // xb.o
    public void onNext(T r10) {
        this.downstream.onNext(r10);
    }

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
        this.sd.replace(r10);
    }

    void subscribeNext() {
        if (getAndIncrement() != 0) goto L10;
        int r10 = 1;
    L6:
        if (this.sd.isDisposed() == true) goto L7;
        this.source.subscribe(this);
        r10 = addAndGet(-r10);
        if (r10 != 0) goto L6;
        return;
    L7:
        return;
    }
}
