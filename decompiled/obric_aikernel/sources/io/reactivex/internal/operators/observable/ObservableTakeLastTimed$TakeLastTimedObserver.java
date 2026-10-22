package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableTakeLastTimed$TakeLastTimedObserver<T> extends AtomicBoolean implements xb.o<T>, io.reactivex.disposables.b {
    private static final long serialVersionUID = -5677354903406201275L;
    volatile boolean cancelled;
    final long count;
    final boolean delayError;
    final xb.o<? super T> downstream;
    Throwable error;
    final io.reactivex.internal.queue.a<Object> queue;
    final xb.p scheduler;
    final long time;
    final TimeUnit unit;
    io.reactivex.disposables.b upstream;

    ObservableTakeLastTimed$TakeLastTimedObserver(xb.o<? super T> r10, long r11, long r12, TimeUnit r13, xb.p r14, int r15, boolean r16) {
        this.downstream = r10;
        this.count = r11;
        this.time = r12;
        this.unit = r13;
        this.scheduler = r14;
        this.queue = new io.reactivex.internal.queue.a(r15);
        this.delayError = r16;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        if (this.cancelled == true) goto L8;
        this.cancelled = true;
        this.upstream.dispose();
        if (compareAndSet(false, true) == false) goto L9;
        this.queue.clear();
        return;
    L9:
        return;
    }

    void drain() {
        if (compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        xb.o<? super T> r10 = this.downstream;
        io.reactivex.internal.queue.a<Object> r11 = this.queue;
        boolean r12 = this.delayError;
    L7:
        if (this.cancelled == true) goto L8;
        if (r12 == true) goto L15;
        Throwable r13 = this.error;
        if (r13 == null) goto L15;
        r11.clear();
        r10.onError(r13);
        return;
    L15:
        Object r14 = r11.poll();
        if (r14 != null) goto L18;
        boolean r15 = true;
    L19:
        if (r15 == true) goto L20;
        Object r16 = r11.poll();
        if (((Long) r14).longValue() < (this.scheduler.b(this.unit) - this.time)) goto L7;
        r10.onNext(r16);
        goto L7
    L20:
        Throwable r17 = this.error;
        if (r17 == null) goto L23;
        r10.onError(r17);
        return;
    L23:
        r10.onComplete();
        return;
    L18:
        r15 = false;
        goto L19
    L8:
        r11.clear();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // xb.o
    public void onComplete() {
        drain();
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        this.error = r10;
        drain();
    }

    @Override // xb.o
    public void onNext(T r13) {
        io.reactivex.internal.queue.a<Object> r10 = this.queue;
        long r11 = this.scheduler.b(this.unit);
        long r12 = this.time;
        long r14 = this.count;
        if (r14 != Long.MAX_VALUE) goto L5;
        boolean r15 = true;
    L6:
        r10.l(Long.valueOf(r11), r13);
    L8:
        if (r10.isEmpty() == true) goto L15;
        if (((Long) r10.peek()).longValue() <= (r11 - r12)) goto L14;
        if (r15 == true) goto L21;
        if ((r10.n() >> 1) > r14) goto L14;
        return;
    L21:
        return;
    L14:
        r10.poll();
        r10.poll();
        goto L8
    L15:
        return;
    L5:
        r15 = false;
        goto L6
    }

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }
}
