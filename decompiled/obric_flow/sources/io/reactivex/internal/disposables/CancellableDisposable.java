package io.reactivex.internal.disposables;

import ai.j0;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;
import pt.f;

/* JADX INFO: loaded from: classes3.dex */
public final class CancellableDisposable extends AtomicReference<f> implements Disposable {
    private static final long serialVersionUID = 5718521705281392066L;

    public CancellableDisposable(f r5) {
        super(r5);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (get() == null) goto L6;
        j0.A(getAndSet(null));
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get() != null) goto L5;
        return true;
    L5:
        return false;
    }
}
