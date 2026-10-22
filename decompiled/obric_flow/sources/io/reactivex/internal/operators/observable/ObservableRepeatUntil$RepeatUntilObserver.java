package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableRepeatUntil$RepeatUntilObserver<T> extends AtomicInteger implements mt.u {
    private static final long serialVersionUID = -7098360935104053232L;
    final mt.u downstream;
    final mt.s source;
    final pt.e stop;
    final SequentialDisposable upstream;

    public ObservableRepeatUntil$RepeatUntilObserver(mt.u r5, pt.e r10, SequentialDisposable r11, mt.s r12) {
        this.downstream = r5;
        this.upstream = r11;
        this.source = r12;
        this.stop = r10;
    }

    @Override // mt.u
    public void onComplete() {
        if (this.stop.getAsBoolean() == false) goto L5;
        this.downstream.onComplete();
        return;
    L5:
        subscribeNext();
        return;
    L7:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.downstream.onError(th);
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
        this.upstream.replace(r5);
    }

    public void subscribeNext() {
        if (getAndIncrement() != 0) goto L7;
        int r5 = 1;
    L5:
        this.source.subscribe(this);
        r5 = addAndGet(-r5);
        if (r5 != 0) goto L5;
        return;
    }
}
