package io.reactivex.internal.operators.single;

import com.lynx.tasm.behavior.v0;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.e;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import mt.b0;
import pt.o;

/* JADX INFO: loaded from: classes3.dex */
final class SingleFlatMapIterableFlowable$FlatMapIterableObserver<T, R> extends BasicIntQueueSubscription<R> implements b0 {
    private static final long serialVersionUID = -8938804753851907758L;
    volatile boolean cancelled;
    final zu.c downstream;
    volatile Iterator<? extends R> it;
    final o mapper;
    boolean outputFused;
    final AtomicLong requested;
    Disposable upstream;

    public SingleFlatMapIterableFlowable$FlatMapIterableObserver(zu.c r5, o r10) {
        this.downstream = r5;
        this.mapper = r10;
        this.requested = new AtomicLong();
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, zu.d
    public void cancel() {
        this.cancelled = true;
        this.upstream.dispose();
        this.upstream = DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, rt.h
    public void clear() {
        this.it = null;
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        zu.c r5 = this.downstream;
        Iterator<? extends R> r10 = this.it;
        if (this.outputFused == false) goto L10;
        if (r10 == null) goto L10;
        r5.onNext(null);
        r5.onComplete();
        return;
    L10:
        int r11 = 1;
    L11:
        if (r10 == null) goto L40;
        long r12 = this.requested.get();
        if (r12 == Long.MAX_VALUE) goto L14;
        long r13 = 0;
    L18:
        if (r13 == r12) goto L38;
        if (this.cancelled == true) goto L21;
        R r14 = r10.next();     // Catch: Throwable -> L34
        e.d(r14, "The iterator returned a null value");     // Catch: Throwable -> L34
        r5.onNext(r14);
        if (this.cancelled == true) goto L25;
        r13 = r13 + 1;
        if (r10.hasNext() == true) goto L18;
        r5.onComplete();
        return;
    L31:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        r5.onError(th);
        return;
    L25:
        return;
    L34:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        r5.onError(th);
        return;
    L21:
        return;
    L38:
        if (r13 == 0) goto L40;
        v0.y(this.requested, r13);
        goto L40
    L14:
        slowPath(r5, r10);
        return;
    L40:
        r11 = addAndGet(-r11);
        if (r11 == 0) goto L42;
        if (r10 != null) goto L11;
        r10 = this.it;
        goto L11
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, rt.h
    public boolean isEmpty() {
        if (this.it != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // mt.b0, mt.j
    public void onError(Throwable r5) {
        this.upstream = DisposableHelper.DISPOSED;
        this.downstream.onError(r5);
    }

    @Override // mt.b0, mt.j
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // mt.b0, mt.j
    public void onSuccess(T r5) {
        Iterator<? extends R> r10 = ((Iterable) this.mapper.apply(r5)).iterator();     // Catch: Throwable -> L8
        if (r10.hasNext() == true) goto L6;
        this.downstream.onComplete();
        return;
    L6:
        this.it = r10;
        drain();
        return;
    L8:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.downstream.onError(th);
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, rt.h
    public R poll() throws Exception {
        Iterator<? extends R> r5 = this.it;
        if (r5 == null) goto L8;
        R r10 = r5.next();
        e.d(r10, "The iterator returned a null value");
        if (r5.hasNext() == true) goto L7;
        this.it = null;
    L7:
        return r10;
    L8:
        return null;
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
        if ((r5 & 2) == 0) goto L6;
        this.outputFused = true;
        return 2;
    L6:
        return 0;
    }

    public void slowPath(zu.c r5, Iterator<? extends R> r10) {
    L3:
        if (this.cancelled == true) goto L4;
        r5.onNext(r10.next());
        if (this.cancelled == true) goto L8;
        if (r10.hasNext() == true) goto L3;
        r5.onComplete();
        return;
    L13:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        r5.onError(th);
        return;
    L8:
        return;
    L16:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        r5.onError(th);
        return;
    }
}
