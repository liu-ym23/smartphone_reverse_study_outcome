package io.reactivex.internal.subscribers;

/* JADX INFO: loaded from: classes2.dex */
public interface a<T> {
    void drain();

    void innerComplete(InnerQueuedSubscriber<T> r10);

    void innerError(InnerQueuedSubscriber<T> r10, Throwable r11);

    void innerNext(InnerQueuedSubscriber<T> r10, T r11);
}
