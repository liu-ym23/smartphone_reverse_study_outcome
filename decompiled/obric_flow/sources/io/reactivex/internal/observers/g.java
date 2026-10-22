package io.reactivex.internal.observers;

/* JADX INFO: loaded from: classes3.dex */
public interface g {
    void drain();

    void innerComplete(InnerQueuedObserver r5);

    void innerError(InnerQueuedObserver r5, Throwable r10);

    void innerNext(InnerQueuedObserver r5, Object r10);
}
