package io.reactivex.internal.subscribers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.j;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;
import org.a.d;

/* JADX INFO: loaded from: classes6.dex */
public final class BlockingSubscriber<T> extends AtomicReference<d> implements j<T>, d {
    public static final Object TERMINATED = null;
    private static final long serialVersionUID = -4875965440900746268L;
    final Queue<Object> queue;

    static {
        TERMINATED = new Object();
    }

    public BlockingSubscriber(Queue<Object> r3) {
        this.queue = (Queue) ZeusTransformUtils.wrapperContextForParams(r3, Queue.class, "com.obric.memorydata.plugin");
    }

    @Override // org.a.d
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

    @Override // org.a.c
    public void onComplete() {
        this.queue.offer(NotificationLite.complete());
    }

    @Override // org.a.c
    public void onError(Throwable r1) {
        this.queue.offer(NotificationLite.error(r1));
    }

    @Override // org.a.c
    public void onNext(T r1) {
        this.queue.offer(NotificationLite.next(r1));
    }

    @Override // io.reactivex.j, org.a.c
    public void onSubscribe(d r3) {
        if (SubscriptionHelper.setOnce(this, (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin")) == false) goto L6;
        this.queue.offer(NotificationLite.subscription(this));
        return;
    }

    @Override // org.a.d
    public void request(long r3) {
        ((d) ZeusTransformUtils.preCheckCast(get(), d.class, "com.obric.memorydata.plugin")).request(r3);
    }
}
