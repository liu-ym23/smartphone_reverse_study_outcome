package io.reactivex.internal.operators.mixed;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import mt.g;
import mt.j;
import pt.o;

/* JADX INFO: loaded from: classes3.dex */
final class MaybeFlatMapPublisher$FlatMapPublisherSubscriber<T, R> extends AtomicReference<zu.d> implements g, j, zu.d {
    private static final long serialVersionUID = -8948264376121066672L;
    final zu.c downstream;
    final o mapper;
    final AtomicLong requested;
    Disposable upstream;

    public MaybeFlatMapPublisher$FlatMapPublisherSubscriber(zu.c r5, o r10) {
        this.downstream = r5;
        this.mapper = r10;
        this.requested = new AtomicLong();
    }

    @Override // zu.d
    public void cancel() {
        this.upstream.dispose();
        SubscriptionHelper.cancel(this);
    }

    @Override // zu.c
    public void onComplete() {
        this.downstream.onComplete();
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        this.downstream.onError(r5);
    }

    @Override // zu.c
    public void onNext(R r5) {
        this.downstream.onNext(r5);
    }

    @Override // mt.j
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // mt.j
    public void onSuccess(T r5) {
        Object r10 = this.mapper.apply(r5);     // Catch: Throwable -> L5
        io.reactivex.internal.functions.e.d(r10, "The mapper returned a null Publisher");     // Catch: Throwable -> L5
        ((zu.b) r10).subscribe(this);
        return;
    L5:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.downstream.onError(th);
    }

    @Override // zu.d
    public void request(long r5) {
        SubscriptionHelper.deferredRequest(this, this.requested, r5);
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        SubscriptionHelper.deferredSetOnce(this, this.requested, r5);
    }
}
