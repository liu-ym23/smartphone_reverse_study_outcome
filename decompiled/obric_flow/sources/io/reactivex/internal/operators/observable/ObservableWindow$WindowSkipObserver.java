package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableWindow$WindowSkipObserver<T> extends AtomicBoolean implements mt.u, Disposable, Runnable {
    private static final long serialVersionUID = 3366976432059579510L;
    volatile boolean cancelled;
    final int capacityHint;
    final long count;
    final mt.u downstream;
    long firstEmission;
    long index;
    final long skip;
    Disposable upstream;
    final ArrayDeque<io.reactivex.subjects.i> windows;
    final AtomicInteger wip;

    public ObservableWindow$WindowSkipObserver(mt.u r5, long r10, long r11, int r12) {
        this.wip = new AtomicInteger();
        this.downstream = r5;
        this.count = r10;
        this.skip = r11;
        this.capacityHint = r12;
        this.windows = new ArrayDeque();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.cancelled = true;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // mt.u
    public void onComplete() {
        ArrayDeque<io.reactivex.subjects.i> r5 = this.windows;
    L4:
        if (r5.isEmpty() == true) goto L6;
        r5.poll().onComplete();
        goto L4
    L6:
        this.downstream.onComplete();
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        ArrayDeque<io.reactivex.subjects.i> r10 = this.windows;
    L4:
        if (r10.isEmpty() == true) goto L6;
        r10.poll().onError(r5);
        goto L4
    L6:
        this.downstream.onError(r5);
    }

    @Override // mt.u
    public void onNext(T r12) {
        ArrayDeque<io.reactivex.subjects.i> r5 = this.windows;
        long r10 = this.index;
        long r11 = this.skip;
        if ((r10 % r11) == 0) goto L5;
    L7:
        long r13 = this.firstEmission + 1;
        Iterator<io.reactivex.subjects.i> r14 = r5.iterator();
    L9:
        if (r14.hasNext() == false) goto L12;
        r14.next().onNext(r12);
        goto L9
    L12:
        if (r13 < this.count) goto L20;
        r5.poll().onComplete();
        if (r5.isEmpty() == true) goto L16;
    L19:
        this.firstEmission = r13 - r11;
    L21:
        this.index = r10 + 1;
        return;
    L16:
        if (this.cancelled == false) goto L19;
        this.upstream.dispose();
        return;
    L20:
        this.firstEmission = r13;
        goto L21
    L5:
        if (this.cancelled == true) goto L7;
        this.wip.getAndIncrement();
        io.reactivex.subjects.i r15 = new io.reactivex.subjects.i(this, this.capacityHint);
        r5.offer(r15);
        this.downstream.onNext(r15);
        goto L7
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.wip.decrementAndGet() == 0) goto L5;
        return;
    L5:
        if (this.cancelled == false) goto L9;
        this.upstream.dispose();
        return;
    }
}
