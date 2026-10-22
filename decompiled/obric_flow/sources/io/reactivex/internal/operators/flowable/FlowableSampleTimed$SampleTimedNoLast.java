package io.reactivex.internal.operators.flowable;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableSampleTimed$SampleTimedNoLast<T> extends FlowableSampleTimed$SampleTimedSubscriber<T> {
    private static final long serialVersionUID = -7139995637533111443L;

    public FlowableSampleTimed$SampleTimedNoLast(zu.c r5, long r10, TimeUnit r11, mt.z r12) {
        super(r5, r10, r11, r12);
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableSampleTimed$SampleTimedSubscriber
    public void complete() {
        this.downstream.onComplete();
    }

    @Override // java.lang.Runnable
    public void run() {
        emit();
    }
}
