package io.reactivex.internal.operators.flowable;

import com.lynx.tasm.behavior.v0;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableCombineLatest$CombineLatestCoordinator<T, R> extends BasicIntQueueSubscription<R> {
    private static final long serialVersionUID = -5082275438355852221L;
    volatile boolean cancelled;
    final pt.o combiner;
    int completedSources;
    final boolean delayErrors;
    volatile boolean done;
    final zu.c downstream;
    final AtomicReference<Throwable> error;
    final Object[] latest;
    int nonEmptySources;
    boolean outputFused;
    final io.reactivex.internal.queue.b queue;
    final AtomicLong requested;
    final FlowableCombineLatest$CombineLatestInnerSubscriber<T>[] subscribers;

    public FlowableCombineLatest$CombineLatestCoordinator(zu.c r5, pt.o r10, int r11, int r12, boolean r13) {
        this.downstream = r5;
        this.combiner = r10;
        FlowableCombineLatest$CombineLatestInnerSubscriber<T>[] r14 = new FlowableCombineLatest$CombineLatestInnerSubscriber[r11];
        int r15 = 0;
    L3:
        if (r15 >= r11) goto L5;
        r14[r15] = new FlowableCombineLatest$CombineLatestInnerSubscriber(this, r15, r12);
        r15 = r15 + 1;
        goto L3
    L5:
        this.subscribers = r14;
        this.latest = new Object[r11];
        this.queue = new io.reactivex.internal.queue.b(r12);
        this.requested = new AtomicLong();
        this.error = new AtomicReference();
        this.delayErrors = r13;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, zu.d
    public void cancel() {
        this.cancelled = true;
        cancelAll();
    }

    public void cancelAll() {
        FlowableCombineLatest$CombineLatestInnerSubscriber<T>[] r5 = this.subscribers;
        int r10 = r5.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        r5[r11].cancel();
        r11 = r11 + 1;
        goto L3
    }

    public boolean checkTerminated(boolean r5, boolean r10, zu.c r11, io.reactivex.internal.queue.b r12) {
        if (this.cancelled == false) goto L6;
        cancelAll();
        r12.clear();
        return true;
    L6:
        if (r5 == true) goto L8;
        return false;
    L8:
        if (this.delayErrors == false) goto L17;
        if (r10 == false) goto L28;
        cancelAll();
        Throwable r13 = io.reactivex.internal.util.d.b(this.error);
        if (r13 != null) goto L13;
    L15:
        r11.onComplete();
    L16:
        return true;
    L13:
        if (r13 == io.reactivex.internal.util.d.f18173a) goto L15;
        r11.onError(r13);
        goto L16
    L28:
        return false;
    L17:
        Throwable r14 = io.reactivex.internal.util.d.b(this.error);
        if (r14 != null) goto L20;
    L23:
        if (r10 == false) goto L29;
        cancelAll();
        r11.onComplete();
        return true;
    L29:
        return false;
    L20:
        if (r14 == io.reactivex.internal.util.d.f18173a) goto L23;
        cancelAll();
        r12.clear();
        r11.onError(r14);
        return true;
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
        drainOutput();
        return;
    L8:
        drainAsync();
    }

    public void drainAsync() {
        zu.c r5 = this.downstream;
        io.reactivex.internal.queue.b r10 = this.queue;
        int r11 = 1;
    L3:
        long r12 = this.requested.get();
        long r13 = 0;
    L5:
        if (r13 == r12) goto L21;
        boolean r14 = this.done;
        Object r15 = r10.poll();
        if (r15 != null) goto L9;
        boolean r16 = true;
    L11:
        if (checkTerminated(r14, r16, r5, r10) == true) goto L12;
        if (r16 == true) goto L21;
        Object r17 = this.combiner.apply((Object[]) r10.poll());     // Catch: Throwable -> L18
        io.reactivex.internal.functions.e.d(r17, "The combiner returned a null value");     // Catch: Throwable -> L18
        r5.onNext(r17);
        ((FlowableCombineLatest$CombineLatestInnerSubscriber) r15).requestOne();
        r13 = r13 + 1;
    L18:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        cancelAll();
        io.reactivex.internal.util.d.a(this.error, th);
        r5.onError(io.reactivex.internal.util.d.b(this.error));
        return;
    L12:
        return;
    L9:
        r16 = false;
    L21:
        if (r13 != r12) goto L26;
        if (checkTerminated(this.done, r10.isEmpty(), r5, r10) == false) goto L26;
        return;
    L26:
        if (r13 != 0) goto L28;
    L30:
        r11 = addAndGet(-r11);
        if (r11 != 0) goto L3;
        return;
    L28:
        if (r12 == Long.MAX_VALUE) goto L30;
        this.requested.addAndGet(-r13);
        goto L30
    }

    public void drainOutput() {
        zu.c r5 = this.downstream;
        io.reactivex.internal.queue.b r10 = this.queue;
        int r11 = 1;
    L4:
        if (this.cancelled == true) goto L5;
        Throwable r12 = this.error.get();
        if (r12 != null) goto L9;
        boolean r13 = this.done;
        boolean r14 = r10.isEmpty();
        if (r14 == true) goto L14;
        r5.onNext(null);
    L14:
        if (r13 == false) goto L18;
        if (r14 == false) goto L18;
        r5.onComplete();
        return;
    L18:
        r11 = addAndGet(-r11);
        if (r11 != 0) goto L4;
        return;
    L9:
        r10.clear();
        r5.onError(r12);
        return;
    L5:
        r10.clear();
    }

    public void innerComplete(int r5) {
        monitor-enter(this);
        Object[] r10 = this.latest;     // Catch: Throwable -> L8
        if (r10[r5] == null) goto L13;
        int r11 = this.completedSources + 1;     // Catch: Throwable -> L8
        if (r11 != r10.length) goto L10;
        this.done = true;     // Catch: Throwable -> L8
    L14:
        monitor-exit(this);     // Catch: Throwable -> L8
        drain();
        return;
    L10:
        this.completedSources = r11;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L13:
        this.done = true;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    public void innerError(int r5, Throwable r10) {
        if (io.reactivex.internal.util.d.a(this.error, r10) == true) goto L5;
        wn.f.k(r10);
        return;
    L5:
        if (this.delayErrors == true) goto L7;
        cancelAll();
        this.done = true;
        drain();
        return;
    L7:
        innerComplete(r5);
    }

    public void innerValue(int r5, T r10) {
        monitor-enter(this);
        Object[] r11 = this.latest;     // Catch: Throwable -> L6
        int r12 = this.nonEmptySources;     // Catch: Throwable -> L6
        if (r11[r5] != null) goto L8;
        r12 = r12 + 1;     // Catch: Throwable -> L6
        this.nonEmptySources = r12;     // Catch: Throwable -> L6
    L8:
        r11[r5] = r10;     // Catch: Throwable -> L6
        if (r11.length != r12) goto L11;
        this.queue.a(this.subscribers[r5], r11.clone());     // Catch: Throwable -> L6
        boolean r13 = false;
    L12:
        monitor-exit(this);     // Catch: Throwable -> L6
        if (r13 == false) goto L15;
        this.subscribers[r5].requestOne();
        return;
    L15:
        drain();
        return;
    L11:
        r13 = true;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, rt.h
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, rt.h
    public R poll() throws Exception {
        Object r5 = this.queue.poll();
        if (r5 != null) goto L6;
        return null;
    L6:
        Object[] r10 = (Object[]) this.queue.poll();
        R r11 = (R) this.combiner.apply(r10);
        io.reactivex.internal.functions.e.d(r11, "The combiner returned a null value");
        ((FlowableCombineLatest$CombineLatestInnerSubscriber) r5).requestOne();
        return r11;
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
        boolean r10 = false;
        if ((r5 & 4) == 0) goto L5;
        return 0;
    L5:
        int r11 = r5 & 2;
        if (r11 == 0) goto L8;
        r10 = true;
    L8:
        this.outputFused = r10;
        return r11;
    }

    public void subscribe(zu.b[] r5, int r10) {
        FlowableCombineLatest$CombineLatestInnerSubscriber<T>[] r11 = this.subscribers;
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L10;
        if (this.done == true) goto L14;
        if (this.cancelled == true) goto L15;
        r5[r12].subscribe(r11[r12]);
        r12 = r12 + 1;
        goto L3
    L15:
        return;
    L14:
        return;
    }
}
