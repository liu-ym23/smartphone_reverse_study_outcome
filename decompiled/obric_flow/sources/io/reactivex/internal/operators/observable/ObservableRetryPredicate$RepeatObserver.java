package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableRetryPredicate$RepeatObserver<T> extends AtomicInteger implements mt.u {
    private static final long serialVersionUID = -7098360935104053232L;
    final mt.u downstream;
    final pt.p predicate;
    long remaining;
    final mt.s source;
    final SequentialDisposable upstream;

    public ObservableRetryPredicate$RepeatObserver(mt.u r5, long r10, pt.p r11, SequentialDisposable r12, mt.s r13) {
        this.downstream = r5;
        this.upstream = r12;
        this.source = r13;
        this.predicate = r11;
        this.remaining = r10;
    }

    @Override // mt.u
    public void onComplete() {
        this.downstream.onComplete();
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        long r10 = this.remaining;
        if (r10 == Long.MAX_VALUE) goto L6;
        this.remaining = r10 - 1;
    L6:
        if (r10 != 0) goto L17;
        this.downstream.onError(r5);
        return;
    L17:
        if (this.predicate.test(r5) == true) goto L12;
        this.downstream.onError(r5);
        return;
    L12:
        subscribeNext();
        return;
    L14:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.downstream.onError(new CompositeException(new Throwable[]{r5, th}));
    }

    @Override // mt.u
    public void onNext(T r5) {
        this.downstream.onNext(r5);
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        this.upstream.replace(r5);
    }

    public void subscribeNext() {
        if (getAndIncrement() != 0) goto L10;
        int r5 = 1;
    L6:
        if (this.upstream.isDisposed() == true) goto L7;
        this.source.subscribe(this);
        r5 = addAndGet(-r5);
        if (r5 != 0) goto L6;
        return;
    L7:
        return;
    }
}
