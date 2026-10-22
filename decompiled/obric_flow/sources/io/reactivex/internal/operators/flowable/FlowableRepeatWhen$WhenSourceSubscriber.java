package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;

/* JADX INFO: loaded from: classes3.dex */
abstract class FlowableRepeatWhen$WhenSourceSubscriber<T, U> extends SubscriptionArbiter implements mt.g {
    private static final long serialVersionUID = -5604623027276966720L;
    protected final zu.c downstream;
    protected final io.reactivex.processors.c processor;
    private long produced;
    protected final zu.d receiver;

    public FlowableRepeatWhen$WhenSourceSubscriber(zu.c r5, io.reactivex.processors.c r10, zu.d r11) {
        super(false);
        this.downstream = r5;
        this.processor = r10;
        this.receiver = r11;
    }

    public final void again(U r10) {
        setSubscription(EmptySubscription.INSTANCE);
        long r5 = this.produced;
        if (r5 == 0) goto L5;
        this.produced = 0;
        produced(r5);
    L5:
        this.receiver.request(1);
        ((io.reactivex.processors.g) this.processor).onNext(r10);
    }

    @Override // io.reactivex.internal.subscriptions.SubscriptionArbiter, zu.d
    public final void cancel() {
        super.cancel();
        this.receiver.cancel();
    }

    public abstract /* synthetic */ void onComplete();

    public abstract /* synthetic */ void onError(Throwable r5);

    @Override // zu.c
    public final void onNext(T r5) {
        this.produced++;
        this.downstream.onNext(r5);
    }

    @Override // zu.c
    public final void onSubscribe(zu.d r5) {
        setSubscription(r5);
    }
}
