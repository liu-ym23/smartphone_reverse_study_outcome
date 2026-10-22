package io.reactivex.internal.subscriptions;

import bc.d;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BasicIntQueueSubscription<T> extends AtomicInteger implements d<T> {
    private static final long serialVersionUID = -6671519529404341862L;

    public BasicIntQueueSubscription() {
    }

    public abstract /* synthetic */ void cancel();

    public abstract /* synthetic */ void clear();

    public abstract /* synthetic */ boolean isEmpty();

    @Override // bc.f
    public final boolean offer(T r10) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public final boolean offer(T r10, T r11) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public abstract /* synthetic */ T poll();

    public abstract /* synthetic */ void request(long r10);

    public abstract /* synthetic */ int requestFusion(int r10);
}
