package io.reactivex.disposables;

import io.reactivex.internal.functions.e;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
abstract class ReferenceDisposable<T> extends AtomicReference<T> implements Disposable {
    private static final long serialVersionUID = 6537757548749041217L;

    public ReferenceDisposable(T r5) {
        e.d(r5, "value is null");
        super(r5);
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        if (get() == null) goto L8;
        T r5 = getAndSet(null);
        if (r5 == null) goto L9;
        onDisposed(r5);
        return;
    L9:
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        if (get() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public abstract void onDisposed(T r5);
}
