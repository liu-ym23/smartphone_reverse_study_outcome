package io.reactivex.internal.subscribers;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;
import mt.g;
import zu.d;

/* JADX INFO: loaded from: classes3.dex */
public final class BlockingSubscriber<T> extends AtomicReference<d> implements g, d {
    public static final Object TERMINATED = null;
    private static final long serialVersionUID = -4875965440900746268L;
    final Queue<Object> queue;

    static {
        TERMINATED = new Object();
    }

    public BlockingSubscriber(Queue<Object> r5) {
        this.queue = r5;
    }

    @Override // zu.d
    public void cancel() {
        if (SubscriptionHelper.cancel(this) == false) goto L6;
        this.queue.offer(TERMINATED);
        return;
    }

    public boolean isCancelled() {
        if (get() != SubscriptionHelper.CANCELLED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // zu.c
    public void onComplete() {
        this.queue.offer(NotificationLite.complete());
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        this.queue.offer(NotificationLite.error(r5));
    }

    @Override // zu.c
    public void onNext(T r5) {
        this.queue.offer(NotificationLite.next(r5));
    }

    @Override // zu.c
    public void onSubscribe(d r5) {
        if (SubscriptionHelper.setOnce(this, r5) == false) goto L6;
        this.queue.offer(NotificationLite.subscription(this));
        return;
    }

    @Override // zu.d
    public void request(long r5) {
        get().request(r5);
    }
}
