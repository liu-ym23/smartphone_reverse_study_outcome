package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes2.dex */
interface e {
    void innerClose(boolean r10, ObservableGroupJoin$LeftRightEndObserver r11);

    void innerCloseError(Throwable r10);

    void innerComplete(ObservableGroupJoin$LeftRightObserver r10);

    void innerError(Throwable r10);

    void innerValue(boolean r10, Object r11);
}
