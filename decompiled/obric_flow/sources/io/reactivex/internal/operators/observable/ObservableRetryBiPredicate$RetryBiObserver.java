package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableRetryBiPredicate$RetryBiObserver<T> extends AtomicInteger implements mt.u {
    private static final long serialVersionUID = -7098360935104053232L;
    final mt.u downstream;
    final pt.d predicate;
    int retries;
    final mt.s source;
    final SequentialDisposable upstream;

    public ObservableRetryBiPredicate$RetryBiObserver(mt.u r5, pt.d r10, SequentialDisposable r11, mt.s r12) {
        this.downstream = r5;
        this.upstream = r11;
        this.source = r12;
        this.predicate = r10;
    }

    @Override // mt.u
    public void onComplete() {
        this.downstream.onComplete();
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        pt.d r10 = this.predicate;     // Catch: Throwable -> L8
        int r11 = this.retries + 1;     // Catch: Throwable -> L8
        this.retries = r11;     // Catch: Throwable -> L8
        Integer r12 = Integer.valueOf(r11);     // Catch: Throwable -> L8
        ((com.lynx.tasm.utils.c) r10).getClass();     // Catch: Throwable -> L8
        if (io.reactivex.internal.functions.e.b(r12, r5) == true) goto L6;
        this.downstream.onError(r5);
        return;
    L6:
        subscribeNext();
        return;
    L8:
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
