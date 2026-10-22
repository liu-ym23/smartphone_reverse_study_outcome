package io.reactivex.internal.operators.single;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import mt.b0;

/* JADX INFO: loaded from: classes3.dex */
final class SingleCache$CacheDisposable<T> extends AtomicBoolean implements Disposable {
    private static final long serialVersionUID = 7514387411091976596L;
    final b0 downstream;
    final a parent;

    public SingleCache$CacheDisposable(b0 r5, a r10) {
        this.downstream = r5;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (compareAndSet(false, true) == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return get();
    }
}
