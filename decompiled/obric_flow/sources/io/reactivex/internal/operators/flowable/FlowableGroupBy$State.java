package io.reactivex.internal.operators.flowable;

import com.lynx.tasm.behavior.v0;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableGroupBy$State<T, K> extends BasicIntQueueSubscription<T> implements zu.b {
    private static final long serialVersionUID = -3852313036005250360L;
    final AtomicReference<zu.c> actual;
    final AtomicBoolean cancelled;
    final boolean delayError;
    volatile boolean done;
    Throwable error;
    final K key;
    final AtomicBoolean once;
    boolean outputFused;
    final FlowableGroupBy$GroupBySubscriber<?, K, T> parent;
    int produced;
    final io.reactivex.internal.queue.b queue;
    final AtomicLong requested;

    public FlowableGroupBy$State(int r5, FlowableGroupBy$GroupBySubscriber<?, K, T> r10, K r11, boolean r12) {
        this.requested = new AtomicLong();
        this.cancelled = new AtomicBoolean();
        this.actual = new AtomicReference();
        this.once = new AtomicBoolean();
        this.queue = new io.reactivex.internal.queue.b(r5);
        this.parent = r10;
        this.key = r11;
        this.delayError = r12;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, zu.d
    public void cancel() {
        if (this.cancelled.compareAndSet(false, true) == false) goto L6;
        this.parent.cancel(this.key);
        return;
    }

    public boolean checkTerminated(boolean r5, boolean r10, zu.c r11, boolean r12) {
        if (this.cancelled.get() == false) goto L6;
        this.queue.clear();
        return true;
    L6:
        if (r5 == false) goto L21;
        if (r12 == false) goto L14;
        if (r10 == false) goto L23;
        Throwable r13 = this.error;
        if (r13 == null) goto L12;
        r11.onError(r13);
    L13:
        return true;
    L12:
        r11.onComplete();
        goto L13
    L23:
        return false;
    L14:
        Throwable r14 = this.error;
        if (r14 == null) goto L18;
        this.queue.clear();
        r11.onError(r14);
        return true;
    L18:
        if (r10 == false) goto L24;
        r11.onComplete();
        return true;
    L24:
        return false;
    L21:
        return false;
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
        io.reactivex.internal.queue.b r5 = this.queue;
        zu.c r10 = this.actual.get();
        int r11 = 1;
    L3:
        if (r10 != null) goto L5;
    L23:
        r11 = addAndGet(-r11);
        if (r11 == 0) goto L25;
        if (r10 != null) goto L3;
        r10 = this.actual.get();
        goto L3
    L25:
        return;
    L5:
        if (this.cancelled.get() == true) goto L6;
        boolean r12 = this.done;
        if (r12 == true) goto L11;
    L16:
        r10.onNext(null);
        if (r12 == false) goto L23;
        Throwable r13 = this.error;
        if (r13 == null) goto L21;
        r10.onError(r13);
        return;
    L21:
        r10.onComplete();
        return;
    L11:
        if (this.delayError == true) goto L16;
        Throwable r14 = this.error;
        if (r14 == null) goto L16;
        r5.clear();
        r10.onError(r14);
        return;
    L6:
        r5.clear();
    }

    public void drainNormal() {
        io.reactivex.internal.queue.b r5 = this.queue;
        boolean r10 = this.delayError;
        zu.c r11 = this.actual.get();
        int r12 = 1;
    L3:
        if (r11 == null) goto L27;
        long r13 = this.requested.get();
        long r14 = 0;
    L6:
        if (r14 == r13) goto L17;
        boolean r15 = this.done;
        Object r16 = r5.poll();
        if (r16 != null) goto L10;
        boolean r17 = true;
    L12:
        if (checkTerminated(r15, r17, r11, r10) == true) goto L13;
        if (r17 == true) goto L17;
        r11.onNext(r16);
        r14 = r14 + 1;
        goto L6
    L13:
        return;
    L10:
        r17 = false;
    L17:
        if (r14 != r13) goto L22;
        if (checkTerminated(this.done, r5.isEmpty(), r11, r10) == false) goto L22;
        return;
    L22:
        if (r14 == 0) goto L27;
        if (r13 == Long.MAX_VALUE) goto L26;
        this.requested.addAndGet(-r14);
    L26:
        this.parent.upstream.request(r14);
    L27:
        r12 = addAndGet(-r12);
        if (r12 == 0) goto L29;
        if (r11 != null) goto L3;
        r11 = this.actual.get();
        goto L3
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, rt.h
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    public void onComplete() {
        this.done = true;
        drain();
    }

    public void onError(Throwable r5) {
        this.error = r5;
        this.done = true;
        drain();
    }

    public void onNext(T r5) {
        this.queue.offer(r5);
        drain();
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, rt.h
    public T poll() {
        T r5 = (T) this.queue.poll();
        if (r5 == null) goto L6;
        this.produced++;
        return r5;
    L6:
        int r10 = this.produced;
        if (r10 == 0) goto L11;
        this.produced = 0;
        this.parent.upstream.request(r10);
        return null;
    L11:
        return null;
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

    @Override // zu.b
    public void subscribe(zu.c r5) {
        if (this.once.compareAndSet(false, true) == false) goto L5;
        r5.onSubscribe(this);
        this.actual.lazySet(r5);
        drain();
        return;
    L5:
        EmptySubscription.error(new IllegalStateException("Only one Subscriber allowed!"), r5);
    }
}
