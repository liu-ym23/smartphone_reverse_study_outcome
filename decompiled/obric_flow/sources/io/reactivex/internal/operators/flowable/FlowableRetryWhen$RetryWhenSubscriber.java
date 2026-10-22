package io.reactivex.internal.operators.flowable;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableRetryWhen$RetryWhenSubscriber<T> extends FlowableRepeatWhen$WhenSourceSubscriber<T, Throwable> {
    private static final long serialVersionUID = -2680129890138081029L;

    public FlowableRetryWhen$RetryWhenSubscriber(zu.c r5, io.reactivex.processors.c r10, zu.d r11) {
        super(r5, r10, r11);
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableRepeatWhen$WhenSourceSubscriber, zu.c
    public void onComplete() {
        this.receiver.cancel();
        this.downstream.onComplete();
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableRepeatWhen$WhenSourceSubscriber, zu.c
    public void onError(Throwable r5) {
        again(r5);
    }
}
