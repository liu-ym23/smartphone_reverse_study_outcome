package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;

/* JADX INFO: loaded from: classes2.dex */
abstract class FlowableRepeatWhen$WhenSourceSubscriber<T, U> extends SubscriptionArbiter implements xb.g<T> {
    private static final long serialVersionUID = -5604623027276966720L;
    protected final tc.c<? super T> downstream;
    protected final io.reactivex.processors.a<U> processor;
    private long produced;
    protected final tc.d receiver;

    FlowableRepeatWhen$WhenSourceSubscriber(tc.c<? super T> r10, io.reactivex.processors.a<U> r11, tc.d r12) {
        super(false);
        this.downstream = r10;
        this.processor = r11;
        this.receiver = r12;
    }

    protected final void again(U r10) {
        setSubscription(EmptySubscription.INSTANCE);
        long r11 = this.produced;
        if (r11 == 0) goto L5;
        this.produced = 0;
        produced(r11);
    L5:
        this.receiver.request(1);
        this.processor.onNext(r10);
    }

    @Override // io.reactivex.internal.subscriptions.SubscriptionArbiter, tc.d
    public final void cancel() {
        super.cancel();
        this.receiver.cancel();
    }

    public abstract /* synthetic */ void onComplete();

    public abstract /* synthetic */ void onError(Throwable r10);

    @Override // tc.c
    public final void onNext(T r10) {
        this.produced++;
        this.downstream.onNext(r10);
    }

    @Override // xb.g, tc.c
    public final void onSubscribe(tc.d r10) {
        setSubscription(r10);
    }
}
