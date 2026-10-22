package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import xb.r;
import xb.s;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableConcatWithSingle$ConcatWithSubscriber<T> extends SinglePostCompleteSubscriber<T, T> implements r<T> {
    private static final long serialVersionUID = -7346385463600070225L;
    s<? extends T> other;
    final AtomicReference<io.reactivex.disposables.b> otherDisposable;

    FlowableConcatWithSingle$ConcatWithSubscriber(tc.c<? super T> r10, s<? extends T> r11) {
        super(r10);
        this.other = r11;
        this.otherDisposable = new AtomicReference();
    }

    @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber, tc.d
    public void cancel() {
        super.cancel();
        DisposableHelper.dispose(this.otherDisposable);
    }

    @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber, tc.c
    public void onComplete() {
        this.upstream = SubscriptionHelper.CANCELLED;
        s<? extends T> r10 = this.other;
        this.other = null;
        r10.a(this);
    }

    @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber, tc.c
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber, tc.c
    public void onNext(T r10) {
        this.produced++;
        this.downstream.onNext((Object) r10);
    }

    @Override // xb.r
    public void onSubscribe(io.reactivex.disposables.b r10) {
        DisposableHelper.setOnce(this.otherDisposable, r10);
    }

    @Override // xb.r
    public void onSuccess(T r10) {
        complete(r10);
    }
}
