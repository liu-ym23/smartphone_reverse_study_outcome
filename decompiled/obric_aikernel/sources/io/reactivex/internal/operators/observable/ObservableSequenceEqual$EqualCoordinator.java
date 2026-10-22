package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableSequenceEqual$EqualCoordinator<T> extends AtomicInteger implements io.reactivex.disposables.b {
    private static final long serialVersionUID = -6178010334400373240L;
    volatile boolean cancelled;
    final zb.d<? super T, ? super T> comparer;
    final xb.o<? super Boolean> downstream;
    final xb.n<? extends T> first;
    final i<T>[] observers;
    final ArrayCompositeDisposable resources;
    final xb.n<? extends T> second;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    T f9550v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    T f9551v2;

    ObservableSequenceEqual$EqualCoordinator(xb.o<? super Boolean> r10, int r11, xb.n<? extends T> r12, xb.n<? extends T> r13, zb.d<? super T, ? super T> r14) {
        this.downstream = r10;
        this.first = r12;
        this.second = r13;
        this.comparer = r14;
        this.observers = new i[]{new i(this, 0, r11), new i(this, 1, r11)};
        this.resources = new ArrayCompositeDisposable(2);
    }

    void cancel(io.reactivex.internal.queue.a<T> r10, io.reactivex.internal.queue.a<T> r11) {
        this.cancelled = true;
        r10.clear();
        r11.clear();
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        if (this.cancelled == true) goto L8;
        this.cancelled = true;
        this.resources.dispose();
        if (getAndIncrement() != 0) goto L9;
        i<T>[] r10 = this.observers;
        r10[0].f9567g.clear();
        r10[1].f9567g.clear();
        return;
    L9:
        return;
    }

    void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        i<T>[] r10 = this.observers;
        i<T> r11 = r10[0];
        io.reactivex.internal.queue.a<T> r12 = r11.f9567g;
        i<T> r13 = r10[1];
        io.reactivex.internal.queue.a<T> r14 = r13.f9567g;
        int r15 = 1;
    L7:
        if (this.cancelled == true) goto L8;
        boolean r16 = r11.f9569i;
        if (r16 == false) goto L16;
        Throwable r17 = r11.f9570j;
        if (r17 == null) goto L16;
        cancel(r12, r14);
        this.downstream.onError(r17);
        return;
    L16:
        boolean r18 = r13.f9569i;
        if (r18 == false) goto L23;
        Throwable r19 = r13.f9570j;
        if (r19 == null) goto L23;
        cancel(r12, r14);
        this.downstream.onError(r19);
        return;
    L23:
        if (this.f9550v1 != null) goto L26;
        this.f9550v1 = r12.poll();
    L26:
        if (this.f9550v1 != null) goto L28;
        boolean r20 = true;
    L30:
        if (this.f9551v2 != null) goto L32;
        this.f9551v2 = r14.poll();
    L32:
        T r110 = this.f9551v2;
        if (r110 != null) goto L35;
        boolean r111 = true;
    L36:
        if (r16 == false) goto L42;
        if (r18 == false) goto L42;
        if (r20 == false) goto L42;
        if (r111 == false) goto L42;
        this.downstream.onNext(Boolean.TRUE);
        this.downstream.onComplete();
        return;
    L42:
        if (r16 == false) goto L47;
        if (r18 == false) goto L47;
        if (r20 == r111) goto L47;
        cancel(r12, r14);
        this.downstream.onNext(Boolean.FALSE);
        this.downstream.onComplete();
        return;
    L47:
        if (r20 == true) goto L57;
        if (r111 == true) goto L57;
        if (this.comparer.a(this.f9550v1, r110) == false) goto L51;
        this.f9550v1 = null;
        this.f9551v2 = null;
        goto L57
    L51:
        cancel(r12, r14);
        this.downstream.onNext(Boolean.FALSE);
        this.downstream.onComplete();
        return;
    L54:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        cancel(r12, r14);
        this.downstream.onError(th);
        return;
    L57:
        if (r20 == true) goto L59;
        if (r111 == false) goto L7;
    L59:
        r15 = addAndGet(-r15);
        if (r15 != 0) goto L7;
        return;
    L35:
        r111 = false;
        goto L36
    L28:
        r20 = false;
        goto L30
    L8:
        r12.clear();
        r14.clear();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.cancelled;
    }

    boolean setDisposable(io.reactivex.disposables.b r10, int r11) {
        return this.resources.setResource(r11, r10);
    }

    void subscribe() {
        i<T>[] r10 = this.observers;
        this.first.subscribe(r10[0]);
        this.second.subscribe(r10[1]);
    }
}
