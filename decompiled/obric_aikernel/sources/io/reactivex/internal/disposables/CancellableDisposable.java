package io.reactivex.internal.disposables;

import io.reactivex.disposables.b;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicReference;
import zb.f;

/* JADX INFO: loaded from: classes2.dex */
public final class CancellableDisposable extends AtomicReference<f> implements b {
    private static final long serialVersionUID = 5718521705281392066L;

    public CancellableDisposable(f r10) {
        super(r10);
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        if (get() == null) goto L13;
        f r10 = getAndSet(null);
        if (r10 == null) goto L14;
        r10.cancel();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        a.a(e);
        dc.a.n(e);
        return;
    L14:
        return;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        if (get() != null) goto L5;
        return true;
    L5:
        return false;
    }
}
