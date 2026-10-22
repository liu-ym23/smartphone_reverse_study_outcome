package io.reactivex.internal.operators.flowable;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableSampleTimed$SampleTimedNoLast<T> extends FlowableSampleTimed$SampleTimedSubscriber<T> {
    private static final long serialVersionUID = -7139995637533111443L;

    FlowableSampleTimed$SampleTimedNoLast(tc.c<? super T> r10, long r11, TimeUnit r12, xb.p r13) {
        super(r10, r11, r12, r13);
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableSampleTimed$SampleTimedSubscriber
    void complete() {
        this.downstream.onComplete();
    }

    @Override // java.lang.Runnable
    public void run() {
        emit();
    }
}
