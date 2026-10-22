package io.reactivex.internal.operators.completable;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mt.b;
import wn.f;

/* JADX INFO: loaded from: classes3.dex */
final class CompletableMergeIterable$MergeCompletableObserver extends AtomicBoolean implements b {
    private static final long serialVersionUID = -7730517613164279224L;
    final b downstream;
    final io.reactivex.disposables.a set;
    final AtomicInteger wip;

    public CompletableMergeIterable$MergeCompletableObserver(b r5, io.reactivex.disposables.a r10, AtomicInteger r11) {
        this.downstream = r5;
        this.set = r10;
        this.wip = r11;
    }

    @Override // mt.b
    public void onComplete() {
        if (this.wip.decrementAndGet() == 0) goto L5;
        return;
    L5:
        if (compareAndSet(false, true) == false) goto L9;
        this.downstream.onComplete();
        return;
    }

    @Override // mt.b
    public void onError(Throwable r5) {
        this.set.dispose();
        if (compareAndSet(false, true) == false) goto L5;
        this.downstream.onError(r5);
        return;
    L5:
        f.k(r5);
    }

    @Override // mt.b
    public void onSubscribe(Disposable r5) {
        this.set.b(r5);
    }
}
