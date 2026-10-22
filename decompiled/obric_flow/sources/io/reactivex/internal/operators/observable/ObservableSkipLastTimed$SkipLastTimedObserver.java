package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableSkipLastTimed$SkipLastTimedObserver<T> extends AtomicInteger implements mt.u, Disposable {
    private static final long serialVersionUID = -5677354903406201275L;
    volatile boolean cancelled;
    final boolean delayError;
    volatile boolean done;
    final mt.u downstream;
    Throwable error;
    final io.reactivex.internal.queue.b queue;
    final mt.z scheduler;
    final long time;
    final TimeUnit unit;
    Disposable upstream;

    public ObservableSkipLastTimed$SkipLastTimedObserver(mt.u r5, long r10, TimeUnit r11, mt.z r12, int r13, boolean r14) {
        this.downstream = r5;
        this.time = r10;
        this.unit = r11;
        this.scheduler = r12;
        this.queue = new io.reactivex.internal.queue.b(r13);
        this.delayError = r14;
    }

    @Override // io.reactivex.disposables.Disposable
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

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        mt.u r5 = this.downstream;
        io.reactivex.internal.queue.b r10 = this.queue;
        boolean r11 = this.delayError;
        TimeUnit r12 = this.unit;
        mt.z r13 = this.scheduler;
        long r14 = this.time;
        int r15 = 1;
    L7:
        if (this.cancelled == true) goto L8;
        boolean r16 = this.done;
        Long r17 = (Long) r10.peek();
        if (r17 != null) goto L13;
        boolean r18 = true;
    L14:
        long r19 = r13.b(r12);
        if (r18 == false) goto L17;
    L19:
        if (r16 == false) goto L34;
        if (r11 == false) goto L27;
        if (r18 == false) goto L34;
        Throwable r20 = this.error;
        if (r20 == null) goto L25;
        r5.onError(r20);
        return;
    L25:
        r5.onComplete();
        return;
    L27:
        Throwable r110 = this.error;
        if (r110 != null) goto L29;
        if (r18 == false) goto L34;
        r5.onComplete();
        return;
    L29:
        this.queue.clear();
        r5.onError(r110);
        return;
    L34:
        if (r18 == true) goto L35;
        r10.poll();
        r5.onNext(r10.poll());
        goto L7
    L35:
        r15 = addAndGet(-r15);
        if (r15 != 0) goto L7;
        return;
    L17:
        if (r17.longValue() <= (r19 - r14)) goto L19;
        r18 = true;
        goto L19
    L13:
        r18 = false;
        goto L14
    L8:
        this.queue.clear();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // mt.u
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        this.error = r5;
        this.done = true;
        drain();
    }

    @Override // mt.u
    public void onNext(T r5) {
        this.queue.a(Long.valueOf(this.scheduler.b(this.unit)), r5);
        drain();
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        return;
    }
}
