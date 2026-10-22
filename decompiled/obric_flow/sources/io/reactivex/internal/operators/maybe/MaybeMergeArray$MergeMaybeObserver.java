package io.reactivex.internal.operators.maybe;

import com.lynx.tasm.behavior.v0;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicLong;
import mt.j;
import wn.f;

/* JADX INFO: loaded from: classes3.dex */
final class MaybeMergeArray$MergeMaybeObserver<T> extends BasicIntQueueSubscription<T> implements j {
    private static final long serialVersionUID = -660395290758764731L;
    volatile boolean cancelled;
    long consumed;
    final zu.c downstream;
    final AtomicThrowable error;
    boolean outputFused;
    final c queue;
    final AtomicLong requested;
    final io.reactivex.disposables.a set;
    final int sourceCount;

    public MaybeMergeArray$MergeMaybeObserver(zu.c r5, int r10, c r11) {
        this.downstream = r5;
        this.sourceCount = r10;
        this.set = new io.reactivex.disposables.a();
        this.requested = new AtomicLong();
        this.error = new AtomicThrowable();
        this.queue = r11;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, zu.d
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

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, rt.h
    public void clear() {
        this.queue.clear();
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L6;
        return;
    L6:
        if (this.outputFused == false) goto L8;
        drainFused();
        return;
    L8:
        drainNormal();
    }

    public void drainFused() {
        zu.c r5 = this.downstream;
        c r10 = this.queue;
        int r11 = 1;
    L4:
        if (this.cancelled == true) goto L5;
        Throwable r12 = this.error.get();
        if (r12 != null) goto L9;
        if (r10.producerIndex() != this.sourceCount) goto L14;
        boolean r13 = true;
    L16:
        if (r10.isEmpty() == true) goto L18;
        r5.onNext(null);
    L18:
        if (r13 == true) goto L19;
        r11 = addAndGet(-r11);
        if (r11 != 0) goto L4;
        return;
    L19:
        r5.onComplete();
        return;
    L14:
        r13 = false;
        goto L16
    L9:
        r10.clear();
        r5.onError(r12);
        return;
    L5:
        r10.clear();
    }

    public void drainNormal() {
        zu.c r5 = this.downstream;
        c r10 = this.queue;
        long r11 = this.consumed;
        int r12 = 1;
    L3:
        long r13 = this.requested.get();
    L5:
        if (r11 == r13) goto L24;
        if (this.cancelled == true) goto L8;
        if (this.error.get() != null) goto L12;
        if (r10.consumerIndex() == this.sourceCount) goto L16;
        Object r14 = r10.poll();
        if (r14 == null) goto L24;
        if (r14 == NotificationLite.COMPLETE) goto L5;
        r5.onNext(r14);
        r11 = r11 + 1;
        goto L5
    L16:
        r5.onComplete();
        return;
    L12:
        r10.clear();
        r5.onError(this.error.terminate());
        return;
    L8:
        r10.clear();
        return;
    L24:
        if (r11 == r13) goto L26;
    L36:
        this.consumed = r11;
        r12 = addAndGet(-r12);
        if (r12 != 0) goto L3;
        return;
    L26:
        if (this.error.get() != null) goto L27;
    L30:
        if (r10.peek() != NotificationLite.COMPLETE) goto L33;
        r10.drop();
        goto L30
    L33:
        if (r10.consumerIndex() != this.sourceCount) goto L36;
        r5.onComplete();
        return;
    L27:
        r10.clear();
        r5.onError(this.error.terminate());
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, rt.h
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override // mt.j
    public void onComplete() {
        this.queue.offer(NotificationLite.COMPLETE);
        drain();
    }

    @Override // mt.j
    public void onError(Throwable r5) {
        if (this.error.addThrowable(r5) == false) goto L5;
        this.set.dispose();
        this.queue.offer(NotificationLite.COMPLETE);
        drain();
        return;
    L5:
        f.k(r5);
    }

    @Override // mt.j
    public void onSubscribe(Disposable r5) {
        this.set.b(r5);
    }

    @Override // mt.j
    public void onSuccess(T r5) {
        this.queue.offer(r5);
        drain();
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, rt.h
    public T poll() throws Exception {
    L2:
        T r5 = (T) this.queue.poll();
        if (r5 == NotificationLite.COMPLETE) goto L2;
        return r5;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, zu.d
    public void request(long r5) {
        if (SubscriptionHelper.validate(r5) == false) goto L6;
        v0.r(this.requested, r5);
        drain();
        return;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, rt.d
    public int requestFusion(int r5) {
        if ((r5 & 2) == 0) goto L6;
        this.outputFused = true;
        return 2;
    L6:
        return 0;
    }
}
