package io.reactivex.internal.operators.single;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import mt.a0;
import mt.b0;
import mt.c0;
import mt.g;
import wn.f;
import zu.d;

/* JADX INFO: loaded from: classes3.dex */
final class SingleDelayWithPublisher$OtherSubscriber<T, U> extends AtomicReference<Disposable> implements g, Disposable {
    private static final long serialVersionUID = -8565274649390031272L;
    boolean done;
    final b0 downstream;
    final c0 source;
    d upstream;

    public SingleDelayWithPublisher$OtherSubscriber(b0 r5, c0 r10) {
        this.downstream = r5;
        this.source = r10;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.upstream.cancel();
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // zu.c
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        c0 r5 = this.source;
        a0 r10 = (a0) r5;
        r10.b(new com.lynx.animax.player.b(9, this, this.downstream));
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        if (this.done == false) goto L6;
        f.k(r5);
        return;
    L6:
        this.done = true;
        this.downstream.onError(r5);
    }

    @Override // zu.c
    public void onNext(U r5) {
        this.upstream.cancel();
        onComplete();
    }

    @Override // zu.c
    public void onSubscribe(d r5) {
        if (SubscriptionHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        r5.request(Long.MAX_VALUE);
        return;
    }
}
