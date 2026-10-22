package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicLong;
import xb.j;

/* JADX INFO: loaded from: classes2.dex */
final class MaybeMergeArray$MergeMaybeObserver<T> extends BasicIntQueueSubscription<T> implements j<T> {
    private static final long serialVersionUID = -660395290758764731L;
    volatile boolean cancelled;
    long consumed;
    final tc.c<? super T> downstream;
    final AtomicThrowable error;
    boolean outputFused;
    final d<Object> queue;
    final AtomicLong requested;
    final io.reactivex.disposables.a set;
    final int sourceCount;

    MaybeMergeArray$MergeMaybeObserver(tc.c<? super T> r10, int r11, d<Object> r12) {
        this.downstream = r10;
        this.sourceCount = r11;
        this.set = new io.reactivex.disposables.a();
        this.requested = new AtomicLong();
        this.error = new AtomicThrowable();
        this.queue = r12;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, tc.d
    public void cancel() {
        if (this.cancelled == true) goto L8;
        this.cancelled = true;
        this.set.dispose();
        if (getAndIncrement() != 0) goto L9;
        this.queue.clear();
        return;
    L9:
        return;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, bc.f
    public void clear() {
        this.queue.clear();
    }

    void drain() {
        if (getAndIncrement() == 0) goto L6;
        return;
    L6:
        if (this.outputFused == false) goto L8;
        drainFused();
        return;
    L8:
        drainNormal();
    }

    void drainFused() {
        tc.c<? super T> r10 = this.downstream;
        d<Object> r11 = this.queue;
        int r12 = 1;
    L4:
        if (this.cancelled == true) goto L5;
        Throwable r13 = this.error.get();
        if (r13 != null) goto L9;
        if (r11.producerIndex() != this.sourceCount) goto L14;
        boolean r14 = true;
    L16:
        if (r11.isEmpty() == true) goto L18;
        r10.onNext(null);
    L18:
        if (r14 == true) goto L19;
        r12 = addAndGet(-r12);
        if (r12 != 0) goto L4;
        return;
    L19:
        r10.onComplete();
        return;
    L14:
        r14 = false;
        goto L16
    L9:
        r11.clear();
        r10.onError(r13);
        return;
    L5:
        r11.clear();
    }

    void drainNormal() {
        tc.c<? super T> r10 = this.downstream;
        d<Object> r11 = this.queue;
        long r12 = this.consumed;
        int r13 = 1;
    L3:
        long r14 = this.requested.get();
    L5:
        if (r12 == r14) goto L24;
        if (this.cancelled == true) goto L8;
        if (this.error.get() != null) goto L12;
        if (r11.consumerIndex() == this.sourceCount) goto L16;
        Object r15 = r11.poll();
        if (r15 == null) goto L24;
        if (r15 == NotificationLite.COMPLETE) goto L5;
        r10.onNext(r15);
        r12 = r12 + 1;
        goto L5
    L16:
        r10.onComplete();
        return;
    L12:
        r11.clear();
        r10.onError(this.error.terminate());
        return;
    L8:
        r11.clear();
        return;
    L24:
        if (r12 == r14) goto L26;
    L35:
        this.consumed = r12;
        r13 = addAndGet(-r13);
        if (r13 != 0) goto L3;
        return;
    L26:
        if (this.error.get() != null) goto L12;
    L29:
        if (r11.peek() != NotificationLite.COMPLETE) goto L32;
        r11.drop();
        goto L29
    L32:
        if (r11.consumerIndex() != this.sourceCount) goto L35;
        r10.onComplete();
    }

    boolean isCancelled() {
        return this.cancelled;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, bc.f
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override // xb.j
    public void onComplete() {
        this.queue.offer(NotificationLite.COMPLETE);
        drain();
    }

    @Override // xb.j
    public void onError(Throwable r10) {
        if (this.error.addThrowable(r10) == false) goto L5;
        this.set.dispose();
        this.queue.offer(NotificationLite.COMPLETE);
        drain();
        return;
    L5:
        dc.a.n(r10);
    }

    @Override // xb.j
    public void onSubscribe(io.reactivex.disposables.b r10) {
        this.set.b(r10);
    }

    @Override // xb.j
    public void onSuccess(T r10) {
        this.queue.offer(r10);
        drain();
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, bc.f
    public T poll() {
    L2:
        T r10 = (T) this.queue.poll();
        if (r10 == NotificationLite.COMPLETE) goto L2;
        return r10;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, tc.d
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L6;
        io.reactivex.internal.util.b.a(this.requested, r10);
        drain();
        return;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, bc.c
    public int requestFusion(int r10) {
        if ((r10 & 2) == 0) goto L6;
        this.outputFused = true;
        return 2;
    L6:
        return 0;
    }
}
