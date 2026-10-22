package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import xb.j;
import zb.h;

/* JADX INFO: loaded from: classes2.dex */
final class MaybeFlatMapIterableFlowable$FlatMapIterableObserver<T, R> extends BasicIntQueueSubscription<R> implements j<T> {
    private static final long serialVersionUID = -8938804753851907758L;
    volatile boolean cancelled;
    final tc.c<? super R> downstream;
    volatile Iterator<? extends R> it;
    final h<? super T, ? extends Iterable<? extends R>> mapper;
    boolean outputFused;
    final AtomicLong requested;
    io.reactivex.disposables.b upstream;

    MaybeFlatMapIterableFlowable$FlatMapIterableObserver(tc.c<? super R> r10, h<? super T, ? extends Iterable<? extends R>> r11) {
        this.downstream = r10;
        this.mapper = r11;
        this.requested = new AtomicLong();
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, tc.d
    public void cancel() {
        this.cancelled = true;
        this.upstream.dispose();
        this.upstream = DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, bc.f
    public void clear() {
        this.it = null;
    }

    void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        tc.c<? super R> r10 = this.downstream;
        Iterator<? extends R> r11 = this.it;
        if (this.outputFused == false) goto L10;
        if (r11 == null) goto L10;
        r10.onNext(null);
        r10.onComplete();
        return;
    L10:
        int r12 = 1;
    L11:
        if (r11 == null) goto L40;
        long r13 = this.requested.get();
        if (r13 == Long.MAX_VALUE) goto L14;
        long r14 = 0;
    L18:
        if (r14 == r13) goto L38;
        if (this.cancelled == true) goto L21;
        r10.onNext((Object) io.reactivex.internal.functions.a.d(r11.next(), "The iterator returned a null value"));
        if (this.cancelled == true) goto L25;
        r14 = r14 + 1;
        if (r11.hasNext() == true) goto L18;
        r10.onComplete();
        return;
    L31:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        r10.onError(th);
        return;
    L25:
        return;
    L34:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        r10.onError(th);
        return;
    L21:
        return;
    L38:
        if (r14 == 0) goto L40;
        io.reactivex.internal.util.b.e(this.requested, r14);
        goto L40
    L14:
        fastPath(r10, r11);
        return;
    L40:
        r12 = addAndGet(-r12);
        if (r12 == 0) goto L42;
        if (r11 != null) goto L11;
        r11 = this.it;
        goto L11
    }

    void fastPath(tc.c<? super R> r10, Iterator<? extends R> r11) {
    L3:
        if (this.cancelled == true) goto L4;
    L13:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        r10.onError(th);
        return;
    L6:
        r10.onNext(r11.next());
        if (this.cancelled == true) goto L8;
        if (r11.hasNext() == true) goto L3;
        r10.onComplete();
        return;
    L8:
        return;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, bc.f
    public boolean isEmpty() {
        if (this.it != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // xb.j
    public void onComplete() {
        this.downstream.onComplete();
    }

    @Override // xb.j
    public void onError(Throwable r10) {
        this.upstream = DisposableHelper.DISPOSED;
        this.downstream.onError(r10);
    }

    @Override // xb.j
    public void onSubscribe(io.reactivex.disposables.b r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // xb.j
    public void onSuccess(T r10) {
        Iterator<? extends R> r11 = this.mapper.apply(r10).iterator();     // Catch: Throwable -> L8
        if (r11.hasNext() == true) goto L6;
        this.downstream.onComplete();
        return;
    L6:
        this.it = r11;
        drain();
        return;
    L8:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.downstream.onError(th);
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, bc.f
    public R poll() {
        Iterator<? extends R> r10 = this.it;
        if (r10 == null) goto L8;
        R r11 = (R) io.reactivex.internal.functions.a.d(r10.next(), "The iterator returned a null value");
        if (r10.hasNext() == true) goto L7;
        this.it = null;
    L7:
        return r11;
    L8:
        return null;
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
        if ((r10 & 2) == 0) goto L6;
        this.outputFused = true;
        return 2;
    L6:
        return 0;
    }
}
