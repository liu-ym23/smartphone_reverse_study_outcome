package io.reactivex.internal.operators.completable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;
import mt.b;
import mt.c;

/* JADX INFO: loaded from: classes3.dex */
final class CompletableConcatArray$ConcatInnerObserver extends AtomicInteger implements b {
    private static final long serialVersionUID = -7965400327305809232L;
    final b downstream;
    int index;

    /* JADX INFO: renamed from: sd, reason: collision with root package name */
    final SequentialDisposable f17641sd;
    final c[] sources;

    public CompletableConcatArray$ConcatInnerObserver(b r5, c[] r10) {
        this.downstream = r5;
        this.sources = r10;
        this.f17641sd = new SequentialDisposable();
    }

    public void next() {
        if (this.f17641sd.isDisposed() == false) goto L6;
        return;
    L6:
        if (getAndIncrement() == 0) goto L8;
        return;
    L8:
        c[] r5 = this.sources;
    L10:
        if (this.f17641sd.isDisposed() == true) goto L11;
        int r10 = this.index;
        this.index = r10 + 1;
        if (r10 == r5.length) goto L14;
        ((mt.a) r5[r10]).b(this);
        if (decrementAndGet() != 0) goto L10;
        return;
    L14:
        this.downstream.onComplete();
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
        this.f17641sd.replace(r5);
    }
}
