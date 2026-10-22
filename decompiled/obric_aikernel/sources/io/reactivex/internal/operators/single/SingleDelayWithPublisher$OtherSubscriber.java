package io.reactivex.internal.operators.single;

import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import tc.d;
import xb.g;
import xb.r;
import xb.s;

/* JADX INFO: loaded from: classes2.dex */
final class SingleDelayWithPublisher$OtherSubscriber<T, U> extends AtomicReference<b> implements g<U>, b {
    private static final long serialVersionUID = -8565274649390031272L;
    boolean done;
    final r<? super T> downstream;
    final s<T> source;
    d upstream;

    SingleDelayWithPublisher$OtherSubscriber(r<? super T> r10, s<T> r11) {
        this.downstream = r10;
        this.source = r11;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.upstream.cancel();
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // tc.c
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        this.source.a(new io.reactivex.internal.observers.b(this, this.downstream));
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        if (this.done == false) goto L6;
        dc.a.n(r10);
        return;
    L6:
        this.done = true;
        this.downstream.onError(r10);
    }

    @Override // tc.c
    public void onNext(U r10) {
        this.upstream.cancel();
        onComplete();
    }

    @Override // xb.g, tc.c
    public void onSubscribe(d r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        r10.request(Long.MAX_VALUE);
        return;
    }
}
