package io.reactivex.internal.operators.completable;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import xb.b;

/* JADX INFO: loaded from: classes2.dex */
final class CompletableMergeArray$InnerCompletableObserver extends AtomicInteger implements b {
    private static final long serialVersionUID = -8360547806504310570L;
    final b downstream;
    final AtomicBoolean once;
    final io.reactivex.disposables.a set;

    CompletableMergeArray$InnerCompletableObserver(b r10, AtomicBoolean r11, io.reactivex.disposables.a r12, int r13) {
        this.downstream = r10;
        this.once = r11;
        this.set = r12;
        lazySet(r13);
    }

    @Override // xb.b
    public void onComplete() {
        if (decrementAndGet() == 0) goto L5;
        return;
    L5:
        if (this.once.compareAndSet(false, true) == false) goto L9;
        this.downstream.onComplete();
        return;
    }

    @Override // xb.b
    public void onError(Throwable r10) {
        this.set.dispose();
        if (this.once.compareAndSet(false, true) == false) goto L5;
        this.downstream.onError(r10);
        return;
    L5:
        dc.a.n(r10);
    }

    @Override // xb.b
    public void onSubscribe(io.reactivex.disposables.b r10) {
        this.set.b(r10);
    }
}
