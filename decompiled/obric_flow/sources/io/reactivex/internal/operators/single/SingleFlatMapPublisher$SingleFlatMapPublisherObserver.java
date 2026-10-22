package io.reactivex.internal.operators.single;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import mt.b0;
import mt.g;
import pt.o;
import zu.d;

/* JADX INFO: loaded from: classes3.dex */
final class SingleFlatMapPublisher$SingleFlatMapPublisherObserver<S, T> extends AtomicLong implements b0, g, d {
    private static final long serialVersionUID = 7759721921468635667L;
    Disposable disposable;
    final zu.c downstream;
    final o mapper;
    final AtomicReference<d> parent;

    public SingleFlatMapPublisher$SingleFlatMapPublisherObserver(zu.c r5, o r10) {
        this.downstream = r5;
        this.mapper = r10;
        this.parent = new AtomicReference();
    }

    @Override // zu.d
    public void cancel() {
        this.disposable.dispose();
        SubscriptionHelper.cancel(this.parent);
    }

    @Override // zu.c
    public void onComplete() {
        this.downstream.onComplete();
    }

    @Override // mt.b0, mt.j
    public void onError(Throwable r5) {
        this.downstream.onError(r5);
    }

    @Override // zu.c
    public void onNext(T r5) {
        this.downstream.onNext(r5);
    }

    @Override // mt.b0, mt.j
    public void onSubscribe(Disposable r5) {
        this.disposable = r5;
        this.downstream.onSubscribe(this);
    }

    @Override // mt.b0, mt.j
    public void onSuccess(S r5) {
        Object r10 = this.mapper.apply(r5);     // Catch: Throwable -> L5
        e.d(r10, "the mapper returned a null Publisher");     // Catch: Throwable -> L5
        ((zu.b) r10).subscribe(this);
        return;
    L5:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.downstream.onError(th);
    }

    @Override // zu.d
    public void request(long r5) {
        SubscriptionHelper.deferredRequest(this.parent, this, r5);
    }

    @Override // zu.c
    public void onSubscribe(d r5) {
        SubscriptionHelper.deferredSetOnce(this.parent, this, r5);
    }
}
