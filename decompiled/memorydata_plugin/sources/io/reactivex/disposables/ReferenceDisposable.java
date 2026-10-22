package io.reactivex.disposables;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
abstract class ReferenceDisposable<T> extends AtomicReference<T> implements b {
    private static final long serialVersionUID = 6537757548749041217L;

    ReferenceDisposable(T r2) {
        super(io.reactivex.internal.functions.a.a(r2, "value is null"));
    }

    @Override // io.reactivex.disposables.b
    public final void dispose() {
        if (get() == null) goto L8;
        T r0 = getAndSet(null);
        if (r0 == null) goto L9;
        onDisposed(r0);
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

    public abstract void onDisposed(T r1);
}
