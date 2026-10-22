package io.reactivex.internal.operators.completable;

import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import xb.b;
import xb.c;

/* JADX INFO: loaded from: classes2.dex */
final class CompletableConcatIterable$ConcatInnerObserver extends AtomicInteger implements b {
    private static final long serialVersionUID = -7965400327305809232L;
    final b downstream;
    final SequentialDisposable sd;
    final Iterator<? extends c> sources;

    CompletableConcatIterable$ConcatInnerObserver(b r10, Iterator<? extends c> r11) {
        this.downstream = r10;
        this.sources = r11;
        this.sd = new SequentialDisposable();
    }

    void next() {
        if (this.sd.isDisposed() == false) goto L6;
        return;
    L6:
        if (getAndIncrement() == 0) goto L8;
        return;
    L8:
        Iterator<? extends c> r10 = this.sources;
    L10:
        if (this.sd.isDisposed() == true) goto L11;
        if (r10.hasNext() == false) goto L14;
        ((c) io.reactivex.internal.functions.a.d(r10.next(), "The CompletableSource returned is null")).a(this);
        if (decrementAndGet() != 0) goto L10;
        return;
    L20:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.downstream.onError(th);
        return;
    L14:
        this.downstream.onComplete();
        return;
    L23:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.downstream.onError(th);
        return;
    }

    @Override // xb.b
    public void onComplete() {
        next();
    }

    @Override // xb.b
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
    }

    @Override // xb.b
    public void onSubscribe(io.reactivex.disposables.b r10) {
        this.sd.replace(r10);
    }
}
