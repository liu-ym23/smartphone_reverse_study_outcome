package io.reactivex.internal.observers;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BasicIntQueueDisposable<T> extends AtomicInteger implements bc.b<T> {
    private static final long serialVersionUID = -1001730202384742097L;

    public BasicIntQueueDisposable() {
    }

    @Override // bc.f
    public abstract /* synthetic */ void clear();

    @Override // io.reactivex.disposables.b
    public abstract /* synthetic */ void dispose();

    @Override // io.reactivex.disposables.b
    public abstract /* synthetic */ boolean isDisposed();

    @Override // bc.f
    public abstract /* synthetic */ boolean isEmpty();

    @Override // bc.f
    public final boolean offer(T r10) {
        throw new UnsupportedOperationException("Should not be called");
    }

    public final boolean offer(T r10, T r11) {
        throw new UnsupportedOperationException("Should not be called");
    }

    @Override // bc.f
    public abstract /* synthetic */ T poll();

    @Override // bc.c
    public abstract /* synthetic */ int requestFusion(int r10);
}
