package io.reactivex.internal.operators.mixed;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.a;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import tc.b;
import tc.c;
import tc.d;
import xb.g;
import xb.j;
import zb.h;

/* JADX INFO: loaded from: classes2.dex */
final class MaybeFlatMapPublisher$FlatMapPublisherSubscriber<T, R> extends AtomicReference<d> implements g<R>, j<T>, d {
    private static final long serialVersionUID = -8948264376121066672L;
    final c<? super R> downstream;
    final h<? super T, ? extends b<? extends R>> mapper;
    final AtomicLong requested;
    io.reactivex.disposables.b upstream;

    MaybeFlatMapPublisher$FlatMapPublisherSubscriber(c<? super R> r10, h<? super T, ? extends b<? extends R>> r11) {
        this.downstream = r10;
        this.mapper = r11;
        this.requested = new AtomicLong();
    }

    @Override // tc.d
    public void cancel() {
        this.upstream.dispose();
        SubscriptionHelper.cancel(this);
    }

    @Override // tc.c
    public void onComplete() {
        this.downstream.onComplete();
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
    }

    @Override // tc.c
    public void onNext(R r10) {
        this.downstream.onNext(r10);
    }

    @Override // xb.j
    public void onSubscribe(io.reactivex.disposables.b r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // xb.g, tc.c
    public void onSubscribe(d r10) {
        SubscriptionHelper.deferredSetOnce(this, this.requested, r10);
    }

    @Override // xb.j
    public void onSuccess(T r10) {
        ((b) a.d(this.mapper.apply(r10), "The mapper returned a null Publisher")).subscribe(this);
        return;
    L5:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.downstream.onError(th);
    }

    @Override // tc.d
    public void request(long r10) {
        SubscriptionHelper.deferredRequest(this, this.requested, r10);
    }
}
