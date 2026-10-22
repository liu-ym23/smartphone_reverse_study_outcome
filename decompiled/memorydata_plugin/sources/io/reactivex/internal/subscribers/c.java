package io.reactivex.internal.subscribers;

/* JADX INFO: loaded from: classes6.dex */
public interface c<T> {
    void drain();

    void innerComplete(InnerQueuedSubscriber<T> r1);

    void innerError(InnerQueuedSubscriber<T> r1, Throwable r2);

    void innerNext(InnerQueuedSubscriber<T> r1, T r2);
}
