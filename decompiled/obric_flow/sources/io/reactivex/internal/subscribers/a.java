package io.reactivex.internal.subscribers;

/* JADX INFO: loaded from: classes3.dex */
public interface a {
    void drain();

    void innerComplete(InnerQueuedSubscriber r5);

    void innerError(InnerQueuedSubscriber r5, Throwable r10);

    void innerNext(InnerQueuedSubscriber r5, Object r10);
}
