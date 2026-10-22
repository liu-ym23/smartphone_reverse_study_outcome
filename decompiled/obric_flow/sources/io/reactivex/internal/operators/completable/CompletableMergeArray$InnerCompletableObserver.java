package io.reactivex.internal.operators.completable;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mt.b;
import wn.f;

/* JADX INFO: loaded from: classes3.dex */
final class CompletableMergeArray$InnerCompletableObserver extends AtomicInteger implements b {
    private static final long serialVersionUID = -8360547806504310570L;
    final b downstream;
    final AtomicBoolean once;
    final io.reactivex.disposables.a set;

    public CompletableMergeArray$InnerCompletableObserver(b r5, AtomicBoolean r10, io.reactivex.disposables.a r11, int r12) {
        this.downstream = r5;
        this.once = r10;
        this.set = r11;
        lazySet(r12);
    }

    @Override // mt.b
    public void onComplete() {
        if (decrementAndGet() == 0) goto L5;
        return;
    L5:
        if (this.once.compareAndSet(false, true) == false) goto L9;
        this.downstream.onComplete();
        return;
    }

    @Override // mt.b
    public void onError(Throwable r5) {
        this.set.dispose();
        if (this.once.compareAndSet(false, true) == false) goto L5;
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
