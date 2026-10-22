package io.reactivex.internal.operators.flowable;

/* JADX INFO: loaded from: classes3.dex */
public interface k {
    void innerClose(boolean r5, FlowableGroupJoin$LeftRightEndSubscriber r10);

    void innerCloseError(Throwable r5);

    void innerComplete(FlowableGroupJoin$LeftRightSubscriber r5);

    void innerError(Throwable r5);

    void innerValue(boolean r5, Object r10);
}
