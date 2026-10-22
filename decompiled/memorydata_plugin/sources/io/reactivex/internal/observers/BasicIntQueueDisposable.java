package io.reactivex.internal.observers;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public abstract class BasicIntQueueDisposable<T> extends AtomicInteger implements io.reactivex.internal.a.b<T> {
    private static final long serialVersionUID = -1001730202384742097L;

    public BasicIntQueueDisposable() {
    }

    @Override // io.reactivex.internal.a.f
    public final boolean offer(T r1) {
        throw new UnsupportedOperationException("Should not be called");
    }

    public final boolean offer(T r1, T r2) {
        throw new UnsupportedOperationException("Should not be called");
    }
}
