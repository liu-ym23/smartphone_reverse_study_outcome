package io.reactivex.internal.operators.observable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableRetryPredicate$RepeatObserver<T> extends AtomicInteger implements xb.o<T> {
    private static final long serialVersionUID = -7098360935104053232L;
    final xb.o<? super T> downstream;
    final zb.i<? super Throwable> predicate;
    long remaining;
    final xb.n<? extends T> source;
    final SequentialDisposable upstream;

    ObservableRetryPredicate$RepeatObserver(xb.o<? super T> r10, long r11, zb.i<? super Throwable> r12, SequentialDisposable r13, xb.n<? extends T> r14) {
        this.downstream = r10;
        this.upstream = r13;
        this.source = r14;
        this.predicate = r12;
        this.remaining = r11;
    }

    @Override // xb.o
    public void onComplete() {
        this.downstream.onComplete();
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        long r11 = this.remaining;
        if (r11 == Long.MAX_VALUE) goto L6;
        this.remaining = r11 - 1;
    L6:
        if (r11 != 0) goto L17;
        this.downstream.onError(r10);
        return;
    L17:
        if (this.predicate.test(r10) == true) goto L12;
        this.downstream.onError(r10);
        return;
    L12:
        subscribeNext();
        return;
    L14:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.downstream.onError(new CompositeException(new Throwable[]{r10, th}));
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
        if (getAndIncrement() != 0) goto L10;
        int r10 = 1;
    L6:
        if (this.upstream.isDisposed() == true) goto L7;
        this.source.subscribe(this);
        r10 = addAndGet(-r10);
        if (r10 != 0) goto L6;
        return;
    L7:
        return;
    }
}
