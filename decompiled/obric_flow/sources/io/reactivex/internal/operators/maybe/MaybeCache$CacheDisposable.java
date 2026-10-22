package io.reactivex.internal.operators.maybe;

import ai.j0;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;
import mt.j;

/* JADX INFO: loaded from: classes3.dex */
final class MaybeCache$CacheDisposable<T> extends AtomicReference<a> implements Disposable {
    private static final long serialVersionUID = -5791853038359966195L;
    final j downstream;

    public MaybeCache$CacheDisposable(j r5, a r10) {
        super(r10);
        this.downstream = r5;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        j0.A(getAndSet(null));
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get() != null) goto L5;
        return true;
    L5:
        return false;
    }
}
