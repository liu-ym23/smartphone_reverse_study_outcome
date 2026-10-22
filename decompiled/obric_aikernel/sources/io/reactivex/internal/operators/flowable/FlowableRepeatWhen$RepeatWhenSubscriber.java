package io.reactivex.internal.operators.flowable;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableRepeatWhen$RepeatWhenSubscriber<T> extends FlowableRepeatWhen$WhenSourceSubscriber<T, Object> {
    private static final long serialVersionUID = -2680129890138081029L;

    FlowableRepeatWhen$RepeatWhenSubscriber(tc.c<? super T> r10, io.reactivex.processors.a<Object> r11, tc.d r12) {
        super(r10, r11, r12);
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableRepeatWhen$WhenSourceSubscriber, tc.c
    public void onComplete() {
        again(0);
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableRepeatWhen$WhenSourceSubscriber, tc.c
    public void onError(Throwable r10) {
        this.receiver.cancel();
        this.downstream.onError(r10);
    }
}
