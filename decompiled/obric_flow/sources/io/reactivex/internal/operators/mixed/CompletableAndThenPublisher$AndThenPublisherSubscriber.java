package io.reactivex.internal.operators.mixed;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import mt.g;

/* JADX INFO: loaded from: classes3.dex */
final class CompletableAndThenPublisher$AndThenPublisherSubscriber<R> extends AtomicReference<zu.d> implements g, mt.b, zu.d {
    private static final long serialVersionUID = -8948264376121066672L;
    final zu.c downstream;
    zu.b other;
    final AtomicLong requested;
    Disposable upstream;

    public CompletableAndThenPublisher$AndThenPublisherSubscriber(zu.c r5, zu.b r10) {
        this.downstream = r5;
        this.other = r10;
        this.requested = new AtomicLong();
    }

    @Override // zu.d
    public void cancel() {
        this.upstream.dispose();
        SubscriptionHelper.cancel(this);
    }

    @Override // zu.c
    public void onComplete() {
        zu.b r5 = this.other;
        if (r5 != null) goto L5;
        this.downstream.onComplete();
        return;
    L5:
        this.other = null;
        r5.subscribe(this);
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        this.downstream.onError(r5);
    }

    @Override // zu.c
    public void onNext(R r5) {
        this.downstream.onNext(r5);
    }

    @Override // mt.b
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        return;
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
