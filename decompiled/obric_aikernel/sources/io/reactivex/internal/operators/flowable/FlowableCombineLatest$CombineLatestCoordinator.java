package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableCombineLatest$CombineLatestCoordinator<T, R> extends BasicIntQueueSubscription<R> {
    private static final long serialVersionUID = -5082275438355852221L;
    volatile boolean cancelled;
    final zb.h<? super Object[], ? extends R> combiner;
    int completedSources;
    final boolean delayErrors;
    volatile boolean done;
    final tc.c<? super R> downstream;
    final AtomicReference<Throwable> error;
    final Object[] latest;
    int nonEmptySources;
    boolean outputFused;
    final io.reactivex.internal.queue.a<Object> queue;
    final AtomicLong requested;
    final FlowableCombineLatest$CombineLatestInnerSubscriber<T>[] subscribers;

    FlowableCombineLatest$CombineLatestCoordinator(tc.c<? super R> r10, zb.h<? super Object[], ? extends R> r11, int r12, int r13, boolean r14) {
        this.downstream = r10;
        this.combiner = r11;
        FlowableCombineLatest$CombineLatestInnerSubscriber<T>[] r15 = new FlowableCombineLatest$CombineLatestInnerSubscriber[r12];
        int r16 = 0;
    L3:
        if (r16 >= r12) goto L5;
        r15[r16] = new FlowableCombineLatest$CombineLatestInnerSubscriber(this, r16, r13);
        r16 = r16 + 1;
        goto L3
    L5:
        this.subscribers = r15;
        this.latest = new Object[r12];
        this.queue = new io.reactivex.internal.queue.a(r13);
        this.requested = new AtomicLong();
        this.error = new AtomicReference();
        this.delayErrors = r14;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, tc.d
    public void cancel() {
        this.cancelled = true;
        cancelAll();
    }

    void cancelAll() {
        FlowableCombineLatest$CombineLatestInnerSubscriber<T>[] r10 = this.subscribers;
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10[r12].cancel();
        r12 = r12 + 1;
        goto L3
    }

    boolean checkTerminated(boolean r10, boolean r11, tc.c<?> r12, io.reactivex.internal.queue.a<?> r13) {
        if (this.cancelled == false) goto L6;
        cancelAll();
        r13.clear();
        return true;
    L6:
        if (r10 == true) goto L8;
        return false;
    L8:
        if (this.delayErrors == false) goto L17;
        if (r11 == false) goto L28;
        cancelAll();
        Throwable r14 = ExceptionHelper.b(this.error);
        if (r14 != null) goto L13;
    L15:
        r12.onComplete();
    L16:
        return true;
    L13:
        if (r14 == ExceptionHelper.f9683a) goto L15;
        r12.onError(r14);
        goto L16
    L28:
        return false;
    L17:
        Throwable r15 = ExceptionHelper.b(this.error);
        if (r15 != null) goto L20;
    L23:
        if (r11 == false) goto L29;
        cancelAll();
        r12.onComplete();
        return true;
    L29:
        return false;
    L20:
        if (r15 == ExceptionHelper.f9683a) goto L23;
        cancelAll();
        r13.clear();
        r12.onError(r15);
        return true;
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
        drainOutput();
        return;
    L8:
        drainAsync();
    }

    void drainAsync() {
        tc.c<? super R> r10 = this.downstream;
        io.reactivex.internal.queue.a<?> r11 = this.queue;
        int r12 = 1;
    L3:
        long r13 = this.requested.get();
        long r14 = 0;
    L5:
        if (r14 == r13) goto L21;
        boolean r15 = this.done;
        Object r16 = r11.poll();
        if (r16 != null) goto L9;
        boolean r17 = true;
    L11:
        if (checkTerminated(r15, r17, r10, r11) == true) goto L12;
        if (r17 == true) goto L21;
        r10.onNext((Object) io.reactivex.internal.functions.a.d(this.combiner.apply((Object[]) r11.poll()), "The combiner returned a null value"));
        ((FlowableCombineLatest$CombineLatestInnerSubscriber) r16).requestOne();
        r14 = r14 + 1;
    L18:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        cancelAll();
        ExceptionHelper.a(this.error, th);
        r10.onError(ExceptionHelper.b(this.error));
        return;
    L12:
        return;
    L9:
        r17 = false;
    L21:
        if (r14 != r13) goto L26;
        if (checkTerminated(this.done, r11.isEmpty(), r10, r11) == false) goto L26;
        return;
    L26:
        if (r14 != 0) goto L28;
    L30:
        r12 = addAndGet(-r12);
        if (r12 != 0) goto L3;
        return;
    L28:
        if (r13 == Long.MAX_VALUE) goto L30;
        this.requested.addAndGet(-r14);
        goto L30
    }

    void drainOutput() {
        tc.c<? super R> r10 = this.downstream;
        io.reactivex.internal.queue.a<Object> r11 = this.queue;
        int r12 = 1;
    L4:
        if (this.cancelled == true) goto L5;
        Throwable r13 = this.error.get();
        if (r13 != null) goto L9;
        boolean r14 = this.done;
        boolean r15 = r11.isEmpty();
        if (r15 == true) goto L14;
        r10.onNext(null);
    L14:
        if (r14 == false) goto L18;
        if (r15 == false) goto L18;
        r10.onComplete();
        return;
    L18:
        r12 = addAndGet(-r12);
        if (r12 != 0) goto L4;
        return;
    L9:
        r11.clear();
        r10.onError(r13);
        return;
    L5:
        r11.clear();
    }

    void innerComplete(int r10) {
        monitor-enter(this);
        Object[] r11 = this.latest;     // Catch: Throwable -> L14
        if (r11[r10] == null) goto L7;
        int r12 = this.completedSources + 1;     // Catch: Throwable -> L14
        if (r12 == r11.length) goto L7;
        this.completedSources = r12;     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L7:
        this.done = true;     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        drain();
        return;
    L14:
        th = move-exception;
        throw th;
    }

    void innerError(int r10, Throwable r11) {
        if (ExceptionHelper.a(this.error, r11) == true) goto L5;
        dc.a.n(r11);
        return;
    L5:
        if (this.delayErrors == true) goto L7;
        cancelAll();
        this.done = true;
        drain();
        return;
    L7:
        innerComplete(r10);
    }

    void innerValue(int r10, T r11) {
        monitor-enter(this);
        Object[] r12 = this.latest;     // Catch: Throwable -> L15
        int r13 = this.nonEmptySources;     // Catch: Throwable -> L15
        if (r12[r10] != null) goto L6;
        r13 = r13 + 1;     // Catch: Throwable -> L15
        this.nonEmptySources = r13;     // Catch: Throwable -> L15
    L6:
        r12[r10] = r11;     // Catch: Throwable -> L15
        if (r12.length != r13) goto L9;
        this.queue.l(this.subscribers[r10], r12.clone());     // Catch: Throwable -> L15
        boolean r14 = false;
    L10:
        monitor-exit(this);     // Catch: Throwable -> L15
        if (r14 == false) goto L13;
        this.subscribers[r10].requestOne();
        return;
    L13:
        drain();
        return;
    L9:
        r14 = true;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, bc.f
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, bc.f
    public R poll() {
        Object r10 = this.queue.poll();
        if (r10 != null) goto L6;
        return null;
    L6:
        Object[] r11 = (Object[]) this.queue.poll();
        R r12 = (R) io.reactivex.internal.functions.a.d(this.combiner.apply(r11), "The combiner returned a null value");
        ((FlowableCombineLatest$CombineLatestInnerSubscriber) r10).requestOne();
        return r12;
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
        boolean r11 = false;
        if ((r10 & 4) == 0) goto L5;
        return 0;
    L5:
        int r12 = r10 & 2;
        if (r12 == 0) goto L8;
        r11 = true;
    L8:
        this.outputFused = r11;
        return r12;
    }

    void subscribe(Publisher<? extends T>[] r10, int r11) {
        FlowableCombineLatest$CombineLatestInnerSubscriber<T>[] r12 = this.subscribers;
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L10;
        if (this.done == true) goto L14;
        if (this.cancelled == true) goto L15;
        r10[r13].subscribe(r12[r13]);
        r13 = r13 + 1;
        goto L3
    L15:
        return;
    L14:
        return;
    }
}
