package io.reactivex.internal.subscriptions;

import java.util.concurrent.atomic.AtomicLong;
import rt.e;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BasicQueueSubscription<T> extends AtomicLong implements e {
    private static final long serialVersionUID = -6671519529404341862L;

    public BasicQueueSubscription() {
    }

    public abstract /* synthetic */ void cancel();

    public abstract /* synthetic */ void clear();

    public abstract /* synthetic */ boolean isEmpty();

    @Override // rt.h
    public final boolean offer(T r5) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public abstract /* synthetic */ Object poll() throws Exception;

    public abstract /* synthetic */ void request(long r5);

    public abstract /* synthetic */ int requestFusion(int r5);

    public final boolean offer(T r5, T r10) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
