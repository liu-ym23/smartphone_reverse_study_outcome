package io.reactivex.internal.operators.completable;

import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;
import xb.b;
import xb.c;

/* JADX INFO: loaded from: classes2.dex */
final class CompletableConcatArray$ConcatInnerObserver extends AtomicInteger implements b {
    private static final long serialVersionUID = -7965400327305809232L;
    final b downstream;
    int index;
    final SequentialDisposable sd;
    final c[] sources;

    CompletableConcatArray$ConcatInnerObserver(b r10, c[] r11) {
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
        c[] r10 = this.sources;
    L10:
        if (this.sd.isDisposed() == true) goto L11;
        int r11 = this.index;
        this.index = r11 + 1;
        if (r11 == r10.length) goto L14;
        r10[r11].a(this);
        if (decrementAndGet() != 0) goto L10;
        return;
    L14:
        this.downstream.onComplete();
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
