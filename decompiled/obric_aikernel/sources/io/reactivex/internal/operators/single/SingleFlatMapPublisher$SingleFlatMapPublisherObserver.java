package io.reactivex.internal.operators.single;

import io.reactivex.disposables.b;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import tc.c;
import tc.d;
import xb.g;
import xb.r;
import zb.h;

/* JADX INFO: loaded from: classes2.dex */
final class SingleFlatMapPublisher$SingleFlatMapPublisherObserver<S, T> extends AtomicLong implements r<S>, g<T>, d {
    private static final long serialVersionUID = 7759721921468635667L;
    b disposable;
    final c<? super T> downstream;
    final h<? super S, ? extends tc.b<? extends T>> mapper;
    final AtomicReference<d> parent;

    SingleFlatMapPublisher$SingleFlatMapPublisherObserver(c<? super T> r10, h<? super S, ? extends tc.b<? extends T>> r11) {
        this.downstream = r10;
        this.mapper = r11;
        this.parent = new AtomicReference();
    }

    @Override // tc.d
    public void cancel() {
        this.disposable.dispose();
        SubscriptionHelper.cancel(this.parent);
    }

    @Override // tc.c
    public void onComplete() {
        this.downstream.onComplete();
    }

    @Override // xb.r
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
    }

    @Override // tc.c
    public void onNext(T r10) {
        this.downstream.onNext(r10);
    }

    @Override // xb.r
    public void onSubscribe(b r10) {
        this.disposable = r10;
        this.downstream.onSubscribe(this);
    }

    @Override // xb.g, tc.c
    public void onSubscribe(d r10) {
        SubscriptionHelper.deferredSetOnce(this.parent, this, r10);
    }

    @Override // xb.r
    public void onSuccess(S r10) {
        ((tc.b) io.reactivex.internal.functions.a.d(this.mapper.apply(r10), "the mapper returned a null Publisher")).subscribe(this);
        return;
    L5:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.downstream.onError(th);
    }

    @Override // tc.d
    public void request(long r10) {
        SubscriptionHelper.deferredRequest(this.parent, this, r10);
    }
}
