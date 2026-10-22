package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableRepeat$RepeatObserver<T> extends AtomicInteger implements mt.u {
    private static final long serialVersionUID = -7098360935104053232L;
    final mt.u downstream;
    long remaining;

    /* JADX INFO: renamed from: sd, reason: collision with root package name */
    final SequentialDisposable f17699sd;
    final mt.s source;

    public ObservableRepeat$RepeatObserver(mt.u r5, long r10, SequentialDisposable r11, mt.s r12) {
        this.downstream = r5;
        this.f17699sd = r11;
        this.source = r12;
        this.remaining = r10;
    }

    @Override // mt.u
    public void onComplete() {
        long r5 = this.remaining;
        if (r5 == Long.MAX_VALUE) goto L6;
        this.remaining = r5 - 1;
    L6:
        if (r5 == 0) goto L8;
        subscribeNext();
        return;
    L8:
        this.downstream.onComplete();
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        this.downstream.onError(r5);
    }

    @Override // mt.u
    public void onNext(T r5) {
        this.downstream.onNext(r5);
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        this.f17699sd.replace(r5);
    }

    public void subscribeNext() {
        if (getAndIncrement() != 0) goto L10;
        int r5 = 1;
    L6:
        if (this.f17699sd.isDisposed() == true) goto L7;
        this.source.subscribe(this);
        r5 = addAndGet(-r5);
        if (r5 != 0) goto L6;
        return;
    L7:
        return;
    }
}
