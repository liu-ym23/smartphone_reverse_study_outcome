package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableUsing$UsingSubscriber<T, D> extends AtomicBoolean implements xb.g<T>, tc.d {
    private static final long serialVersionUID = 5904473792286235046L;
    final zb.g<? super D> disposer;
    final tc.c<? super T> downstream;
    final boolean eager;
    final D resource;
    tc.d upstream;

    FlowableUsing$UsingSubscriber(tc.c<? super T> r10, D r11, zb.g<? super D> r12, boolean r13) {
        this.downstream = r10;
        this.resource = r11;
        this.disposer = r12;
        this.eager = r13;
    }

    @Override // tc.d
    public void cancel() {
        disposeAfter();
        this.upstream.cancel();
    }

    void disposeAfter() {
        if (compareAndSet(false, true) == false) goto L11;
        this.disposer.accept(this.resource);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        dc.a.n(th);
        return;
    }

    @Override // tc.c
    public void onComplete() {
        if (this.eager == true) goto L5;
        this.downstream.onComplete();
        this.upstream.cancel();
        disposeAfter();
        return;
    L5:
        if (compareAndSet(false, true) == true) goto L14;
    L11:
        this.upstream.cancel();
        this.downstream.onComplete();
        return;
    L14:
        this.disposer.accept(this.resource);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.downstream.onError(th);
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        if (this.eager == false) goto L14;
        Throwable th = null;
        if (compareAndSet(false, true) == true) goto L16;
    L10:
        this.upstream.cancel();
        tc.c<? super T> r11 = this.downstream;
        if (th == null) goto L13;
        r11.onError(new CompositeException(new Throwable[]{r10, th}));
        return;
    L13:
        r11.onError(r10);
        return;
    L16:
        this.disposer.accept(this.resource);     // Catch: Throwable -> L8
    L8:
        th = th;
        io.reactivex.exceptions.a.a(th);
        goto L10
    L14:
        this.downstream.onError(r10);
        this.upstream.cancel();
        disposeAfter();
    }

    @Override // tc.c
    public void onNext(T r10) {
        this.downstream.onNext(r10);
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // tc.d
    public void request(long r10) {
        this.upstream.request(r10);
    }
}
