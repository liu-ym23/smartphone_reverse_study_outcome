package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableTakeLastTimed$TakeLastTimedObserver<T> extends AtomicBoolean implements mt.u, Disposable {
    private static final long serialVersionUID = -5677354903406201275L;
    volatile boolean cancelled;
    final long count;
    final boolean delayError;
    final mt.u downstream;
    Throwable error;
    final io.reactivex.internal.queue.b queue;
    final mt.z scheduler;
    final long time;
    final TimeUnit unit;
    Disposable upstream;

    public ObservableTakeLastTimed$TakeLastTimedObserver(mt.u r5, long r10, long r11, TimeUnit r12, mt.z r13, int r14, boolean r15) {
        this.downstream = r5;
        this.count = r10;
        this.time = r11;
        this.unit = r12;
        this.scheduler = r13;
        this.queue = new io.reactivex.internal.queue.b(r14);
        this.delayError = r15;
    }

    @Override // io.reactivex.disposables.Disposable
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

    public void drain() {
        if (compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        mt.u r5 = this.downstream;
        io.reactivex.internal.queue.b r10 = this.queue;
        boolean r11 = this.delayError;
    L7:
        if (this.cancelled == true) goto L8;
        if (r11 == true) goto L15;
        Throwable r12 = this.error;
        if (r12 == null) goto L15;
        r10.clear();
        r5.onError(r12);
        return;
    L15:
        Object r13 = r10.poll();
        if (r13 == null) goto L17;
        Object r14 = r10.poll();
        if (((Long) r13).longValue() < (this.scheduler.b(this.unit) - this.time)) goto L7;
        r5.onNext(r14);
        goto L7
    L17:
        Throwable r15 = this.error;
        if (r15 == null) goto L20;
        r5.onError(r15);
        return;
    L20:
        r5.onComplete();
        return;
    L8:
        r10.clear();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // mt.u
    public void onComplete() {
        drain();
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        this.error = r5;
        drain();
    }

    @Override // mt.u
    public void onNext(T r15) {
        io.reactivex.internal.queue.b r5 = this.queue;
        long r10 = this.scheduler.b(this.unit);
        long r11 = this.time;
        long r12 = this.count;
        if (r12 != Long.MAX_VALUE) goto L5;
        boolean r14 = true;
    L6:
        r5.a(Long.valueOf(r10), r15);
    L8:
        if (r5.isEmpty() == true) goto L27;
        if (((Long) r5.peek()).longValue() <= (r10 - r11)) goto L19;
        if (r14 == true) goto L28;
        AtomicLong r16 = r5.f18118h;
        long r13 = r16.get();
    L13:
        long r17 = r5.f18115a.get();
        long r18 = r16.get();
        if (r13 == r18) goto L16;
        r13 = r18;
        goto L13
    L16:
        if ((((int) (r17 - r18)) >> 1) > r12) goto L19;
        return;
    L28:
        return;
    L19:
        r5.poll();
        r5.poll();
        goto L8
    L27:
        return;
    L5:
        r14 = false;
        goto L6
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        return;
    }
}
