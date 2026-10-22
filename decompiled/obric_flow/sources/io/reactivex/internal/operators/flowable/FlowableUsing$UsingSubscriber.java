package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableUsing$UsingSubscriber<T, D> extends AtomicBoolean implements mt.g, zu.d {
    private static final long serialVersionUID = 5904473792286235046L;
    final pt.g disposer;
    final zu.c downstream;
    final boolean eager;
    final D resource;
    zu.d upstream;

    public FlowableUsing$UsingSubscriber(zu.c r5, D r10, pt.g r11, boolean r12) {
        this.downstream = r5;
        this.resource = r10;
        this.disposer = r11;
        this.eager = r12;
    }

    @Override // zu.d
    public void cancel() {
        disposeAfter();
        this.upstream.cancel();
    }

    public void disposeAfter() {
        if (compareAndSet(false, true) == false) goto L11;
        this.disposer.accept(this.resource);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        wn.f.k(th);
        return;
    }

    @Override // zu.c
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
        com.lynx.jsbridge.a.t(th);
        this.downstream.onError(th);
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        if (this.eager == true) goto L5;
        this.downstream.onError(r5);
        this.upstream.cancel();
        disposeAfter();
        return;
    L5:
        if (compareAndSet(false, true) == true) goto L17;
    L10:
        th = null;
    L11:
        this.upstream.cancel();
        if (th == null) goto L14;
        this.downstream.onError(new CompositeException(new Throwable[]{r5, th}));
        return;
    L14:
        this.downstream.onError(r5);
        return;
    L17:
        this.disposer.accept(this.resource);     // Catch: Throwable -> L8
    L8:
        th = th;
        com.lynx.jsbridge.a.t(th);
        goto L11
    }

    @Override // zu.c
    public void onNext(T r5) {
        this.downstream.onNext(r5);
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        if (SubscriptionHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // zu.d
    public void request(long r5) {
        this.upstream.request(r5);
    }
}
