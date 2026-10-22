package io.reactivex.internal.operators.mixed;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import tc.c;
import tc.d;
import xb.b;
import xb.g;

/* JADX INFO: loaded from: classes2.dex */
final class CompletableAndThenPublisher$AndThenPublisherSubscriber<R> extends AtomicReference<d> implements g<R>, b, d {
    private static final long serialVersionUID = -8948264376121066672L;
    final c<? super R> downstream;
    tc.b<? extends R> other;
    final AtomicLong requested;
    io.reactivex.disposables.b upstream;

    CompletableAndThenPublisher$AndThenPublisherSubscriber(c<? super R> r10, tc.b<? extends R> r11) {
        this.downstream = r10;
        this.other = r11;
        this.requested = new AtomicLong();
    }

    @Override // tc.d
    public void cancel() {
        this.upstream.dispose();
        SubscriptionHelper.cancel(this);
    }

    @Override // tc.c
    public void onComplete() {
        tc.b<? extends R> r10 = this.other;
        if (r10 != null) goto L5;
        this.downstream.onComplete();
        return;
    L5:
        this.other = null;
        r10.subscribe(this);
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
    }

    @Override // tc.c
    public void onNext(R r10) {
        this.downstream.onNext(r10);
    }

    @Override // xb.b
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

    @Override // tc.d
    public void request(long r10) {
        SubscriptionHelper.deferredRequest(this, this.requested, r10);
    }
}
