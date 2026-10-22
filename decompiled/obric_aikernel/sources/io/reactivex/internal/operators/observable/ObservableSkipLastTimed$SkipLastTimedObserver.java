package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableSkipLastTimed$SkipLastTimedObserver<T> extends AtomicInteger implements xb.o<T>, io.reactivex.disposables.b {
    private static final long serialVersionUID = -5677354903406201275L;
    volatile boolean cancelled;
    final boolean delayError;
    volatile boolean done;
    final xb.o<? super T> downstream;
    Throwable error;
    final io.reactivex.internal.queue.a<Object> queue;
    final xb.p scheduler;
    final long time;
    final TimeUnit unit;
    io.reactivex.disposables.b upstream;

    ObservableSkipLastTimed$SkipLastTimedObserver(xb.o<? super T> r10, long r11, TimeUnit r12, xb.p r13, int r14, boolean r15) {
        this.downstream = r10;
        this.time = r11;
        this.unit = r12;
        this.scheduler = r13;
        this.queue = new io.reactivex.internal.queue.a(r14);
        this.delayError = r15;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        if (this.cancelled == true) goto L8;
        this.cancelled = true;
        this.upstream.dispose();
        if (getAndIncrement() != 0) goto L9;
        this.queue.clear();
        return;
    L9:
        return;
    }

    void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        xb.o<? super T> r10 = this.downstream;
        io.reactivex.internal.queue.a<Object> r11 = this.queue;
        boolean r12 = this.delayError;
        TimeUnit r13 = this.unit;
        xb.p r14 = this.scheduler;
        long r15 = this.time;
        int r16 = 1;
    L7:
        if (this.cancelled == true) goto L8;
        boolean r17 = this.done;
        Long r18 = (Long) r11.peek();
        if (r18 != null) goto L13;
        boolean r19 = true;
    L14:
        long r110 = r14.b(r13);
        if (r19 == false) goto L17;
    L19:
        if (r17 == false) goto L34;
        if (r12 == false) goto L27;
        if (r19 == false) goto L34;
        Throwable r20 = this.error;
        if (r20 == null) goto L25;
        r10.onError(r20);
        return;
    L25:
        r10.onComplete();
        return;
    L27:
        Throwable r111 = this.error;
        if (r111 != null) goto L29;
        if (r19 == false) goto L34;
        r10.onComplete();
        return;
    L29:
        this.queue.clear();
        r10.onError(r111);
        return;
    L34:
        if (r19 == true) goto L35;
        r11.poll();
        r10.onNext(r11.poll());
        goto L7
    L35:
        r16 = addAndGet(-r16);
        if (r16 != 0) goto L7;
        return;
    L17:
        if (r18.longValue() <= (r110 - r15)) goto L19;
        r19 = true;
        goto L19
    L13:
        r19 = false;
        goto L14
    L8:
        this.queue.clear();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // xb.o
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        this.error = r10;
        this.done = true;
        drain();
    }

    @Override // xb.o
    public void onNext(T r10) {
        this.queue.l(Long.valueOf(this.scheduler.b(this.unit)), r10);
        drain();
    }

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }
}
