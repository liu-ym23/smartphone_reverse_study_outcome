package io.reactivex.internal.observers;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BasicIntQueueDisposable<T> extends AtomicInteger implements rt.c {
    private static final long serialVersionUID = -1001730202384742097L;

    public BasicIntQueueDisposable() {
    }

    @Override // rt.h
    public abstract /* synthetic */ void clear();

    @Override // rt.h
    public abstract /* synthetic */ boolean isEmpty();

    @Override // rt.h
    public final boolean offer(T r5) {
        throw new UnsupportedOperationException("Should not be called");
    }

    @Override // rt.h
    public abstract /* synthetic */ Object poll() throws Exception;

    @Override // rt.d
    public abstract /* synthetic */ int requestFusion(int r5);

    public final boolean offer(T r5, T r10) {
        throw new UnsupportedOperationException("Should not be called");
    }
}
