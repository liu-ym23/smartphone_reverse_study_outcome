package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes3.dex */
public interface r1 {
    void innerClose(boolean r5, ObservableGroupJoin$LeftRightEndObserver r10);

    void innerCloseError(Throwable r5);

    void innerComplete(ObservableGroupJoin$LeftRightObserver r5);

    void innerError(Throwable r5);

    void innerValue(boolean r5, Object r10);
}
