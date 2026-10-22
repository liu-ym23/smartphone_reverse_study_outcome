package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.subjects.UnicastSubject;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableWindow$WindowSkipObserver<T> extends AtomicBoolean implements xb.o<T>, io.reactivex.disposables.b, Runnable {
    private static final long serialVersionUID = 3366976432059579510L;
    volatile boolean cancelled;
    final int capacityHint;
    final long count;
    final xb.o<? super Observable<T>> downstream;
    long firstEmission;
    long index;
    final long skip;
    io.reactivex.disposables.b upstream;
    final ArrayDeque<UnicastSubject<T>> windows;
    final AtomicInteger wip;

    ObservableWindow$WindowSkipObserver(xb.o<? super Observable<T>> r10, long r11, long r12, int r13) {
        this.wip = new AtomicInteger();
        this.downstream = r10;
        this.count = r11;
        this.skip = r12;
        this.capacityHint = r13;
        this.windows = new ArrayDeque();
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.cancelled = true;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // xb.o
    public void onComplete() {
        ArrayDeque<UnicastSubject<T>> r10 = this.windows;
    L4:
        if (r10.isEmpty() == true) goto L6;
        r10.poll().onComplete();
        goto L4
    L6:
        this.downstream.onComplete();
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        ArrayDeque<UnicastSubject<T>> r11 = this.windows;
    L4:
        if (r11.isEmpty() == true) goto L6;
        r11.poll().onError(r10);
        goto L4
    L6:
        this.downstream.onError(r10);
    }

    @Override // xb.o
    public void onNext(T r12) {
        ArrayDeque<UnicastSubject<T>> r10 = this.windows;
        long r11 = this.index;
        long r13 = this.skip;
        if ((r11 % r13) == 0) goto L5;
    L7:
        long r14 = this.firstEmission + 1;
        Iterator<UnicastSubject<T>> r15 = r10.iterator();
    L9:
        if (r15.hasNext() == false) goto L12;
        r15.next().onNext(r12);
        goto L9
    L12:
        if (r14 < this.count) goto L20;
        r10.poll().onComplete();
        if (r10.isEmpty() == true) goto L16;
    L19:
        r14 = r14 - r13;
        goto L20
    L16:
        if (this.cancelled == false) goto L19;
        this.upstream.dispose();
        return;
    L20:
        this.firstEmission = r14;
        this.index = r11 + 1;
        return;
    L5:
        if (this.cancelled == true) goto L7;
        this.wip.getAndIncrement();
        UnicastSubject<T> r16 = UnicastSubject.i(this.capacityHint, this);
        r10.offer(r16);
        this.downstream.onNext(r16);
        goto L7
    }

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
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
