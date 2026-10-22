package io.reactivex.internal.operators.flowable;

/* JADX INFO: loaded from: classes2.dex */
interface f {
    void innerClose(boolean r10, FlowableGroupJoin$LeftRightEndSubscriber r11);

    void innerCloseError(Throwable r10);

    void innerComplete(FlowableGroupJoin$LeftRightSubscriber r10);

    void innerError(Throwable r10);

    void innerValue(boolean r10, Object r11);
}
