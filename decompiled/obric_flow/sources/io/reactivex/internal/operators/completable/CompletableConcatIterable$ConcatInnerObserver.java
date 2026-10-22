package io.reactivex.internal.operators.completable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.e;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import mt.b;
import mt.c;

/* JADX INFO: loaded from: classes3.dex */
final class CompletableConcatIterable$ConcatInnerObserver extends AtomicInteger implements b {
    private static final long serialVersionUID = -7965400327305809232L;
    final b downstream;

    /* JADX INFO: renamed from: sd, reason: collision with root package name */
    final SequentialDisposable f17642sd;
    final Iterator<? extends c> sources;

    public CompletableConcatIterable$ConcatInnerObserver(b r5, Iterator<? extends c> r10) {
        this.downstream = r5;
        this.sources = r10;
        this.f17642sd = new SequentialDisposable();
    }

    public void next() {
        if (this.f17642sd.isDisposed() == false) goto L6;
        return;
    L6:
        if (getAndIncrement() == 0) goto L8;
        return;
    L8:
        Iterator<? extends c> r5 = this.sources;
    L10:
        if (this.f17642sd.isDisposed() == true) goto L11;
        if (r5.hasNext() == false) goto L14;
        c r10 = r5.next();     // Catch: Throwable -> L20
        e.d(r10, "The CompletableSource returned is null");     // Catch: Throwable -> L20
        ((mt.a) r10).b(this);
        if (decrementAndGet() != 0) goto L10;
        return;
    L20:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.downstream.onError(th);
        return;
    L14:
        this.downstream.onComplete();
        return;
    L23:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.downstream.onError(th);
        return;
    }

    @Override // mt.b
    public void onComplete() {
        next();
    }

    @Override // mt.b
    public void onError(Throwable r5) {
        this.downstream.onError(r5);
    }

    @Override // mt.b
    public void onSubscribe(Disposable r5) {
        this.f17642sd.replace(r5);
    }
}
