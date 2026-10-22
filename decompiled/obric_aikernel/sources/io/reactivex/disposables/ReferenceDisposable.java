package io.reactivex.disposables;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
abstract class ReferenceDisposable<T> extends AtomicReference<T> implements b {
    private static final long serialVersionUID = 6537757548749041217L;

    ReferenceDisposable(T r10) {
        super(io.reactivex.internal.functions.a.d(r10, "value is null"));
    }

    @Override // io.reactivex.disposables.b
    public final void dispose() {
        if (get() == null) goto L8;
        T r10 = getAndSet(null);
        if (r10 == null) goto L9;
        onDisposed(r10);
        return;
    L9:
        return;
    }

    @Override // io.reactivex.disposables.b
    public final boolean isDisposed() {
        if (get() != null) goto L5;
        return true;
    L5:
        return false;
    }

    protected abstract void onDisposed(T r10);
}
