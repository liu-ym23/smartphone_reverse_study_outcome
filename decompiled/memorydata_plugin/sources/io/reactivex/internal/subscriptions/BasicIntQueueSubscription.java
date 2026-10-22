package io.reactivex.internal.subscriptions;

import io.reactivex.internal.a.d;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public abstract class BasicIntQueueSubscription<T> extends AtomicInteger implements d<T> {
    private static final long serialVersionUID = -6671519529404341862L;

    public BasicIntQueueSubscription() {
    }

    @Override // io.reactivex.internal.a.f
    public final boolean offer(T r1) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public final boolean offer(T r1, T r2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
