package io.reactivex.internal.subscribers;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;
import tc.d;
import xb.g;

/* JADX INFO: loaded from: classes2.dex */
public final class BlockingSubscriber<T> extends AtomicReference<d> implements g<T>, d {
    public static final Object TERMINATED = null;
    private static final long serialVersionUID = -4875965440900746268L;
    final Queue<Object> queue;

    static {
        TERMINATED = new Object();
    }

    public BlockingSubscriber(Queue<Object> r10) {
        this.queue = r10;
    }

    @Override // tc.d
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

    @Override // tc.c
    public void onComplete() {
        this.queue.offer(NotificationLite.complete());
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        this.queue.offer(NotificationLite.error(r10));
    }

    @Override // tc.c
    public void onNext(T r10) {
        this.queue.offer(NotificationLite.next(r10));
    }

    @Override // xb.g, tc.c
    public void onSubscribe(d r10) {
        if (SubscriptionHelper.setOnce(this, r10) == false) goto L6;
        this.queue.offer(NotificationLite.subscription(this));
        return;
    }

    @Override // tc.d
    public void request(long r10) {
        get().request(r10);
    }
}
