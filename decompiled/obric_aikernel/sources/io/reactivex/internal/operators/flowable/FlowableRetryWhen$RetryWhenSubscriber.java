package io.reactivex.internal.operators.flowable;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableRetryWhen$RetryWhenSubscriber<T> extends FlowableRepeatWhen$WhenSourceSubscriber<T, Throwable> {
    private static final long serialVersionUID = -2680129890138081029L;

    FlowableRetryWhen$RetryWhenSubscriber(tc.c<? super T> r10, io.reactivex.processors.a<Throwable> r11, tc.d r12) {
        super(r10, r11, r12);
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableRepeatWhen$WhenSourceSubscriber, tc.c
    public void onComplete() {
        this.receiver.cancel();
        this.downstream.onComplete();
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableRepeatWhen$WhenSourceSubscriber, tc.c
    public void onError(Throwable r10) {
        again(r10);
    }
}
