package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableRepeatUntil$RepeatUntilObserver<T> extends AtomicInteger implements xb.o<T> {
    private static final long serialVersionUID = -7098360935104053232L;
    final xb.o<? super T> downstream;
    final xb.n<? extends T> source;
    final zb.e stop;
    final SequentialDisposable upstream;

    ObservableRepeatUntil$RepeatUntilObserver(xb.o<? super T> r10, zb.e r11, SequentialDisposable r12, xb.n<? extends T> r13) {
        this.downstream = r10;
        this.upstream = r12;
        this.source = r13;
        this.stop = r11;
    }

    @Override // xb.o
    public void onComplete() {
        if (this.stop.getAsBoolean() == false) goto L5;
        this.downstream.onComplete();
        return;
    L5:
        subscribeNext();
        return;
    L7:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.downstream.onError(th);
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
        this.upstream.replace(r10);
    }

    void subscribeNext() {
        if (getAndIncrement() != 0) goto L7;
        int r10 = 1;
    L5:
        this.source.subscribe(this);
        r10 = addAndGet(-r10);
        if (r10 != 0) goto L5;
        return;
    }
}
