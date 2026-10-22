package io.reactivex.internal.operators.completable;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import xb.b;

/* JADX INFO: loaded from: classes2.dex */
final class CompletableMergeIterable$MergeCompletableObserver extends AtomicBoolean implements b {
    private static final long serialVersionUID = -7730517613164279224L;
    final b downstream;
    final io.reactivex.disposables.a set;
    final AtomicInteger wip;

    CompletableMergeIterable$MergeCompletableObserver(b r10, io.reactivex.disposables.a r11, AtomicInteger r12) {
        this.downstream = r10;
        this.set = r11;
        this.wip = r12;
    }

    @Override // xb.b
    public void onComplete() {
        if (this.wip.decrementAndGet() == 0) goto L5;
        return;
    L5:
        if (compareAndSet(false, true) == false) goto L9;
        this.downstream.onComplete();
        return;
    }

    @Override // xb.b
    public void onError(Throwable r10) {
        this.set.dispose();
        if (compareAndSet(false, true) == false) goto L5;
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
