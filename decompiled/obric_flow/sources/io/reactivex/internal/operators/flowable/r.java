package io.reactivex.internal.operators.flowable;

/* JADX INFO: loaded from: classes3.dex */
public interface r {
    void complete();

    void error(Throwable r5);

    void next(Object r5);

    void replay(FlowableReplay$InnerSubscription r5);
}
