package io.reactivex.internal.observers;

/* JADX INFO: loaded from: classes2.dex */
public interface a<T> {
    void drain();

    void innerComplete(InnerQueuedObserver<T> r10);

    void innerError(InnerQueuedObserver<T> r10, Throwable r11);

    void innerNext(InnerQueuedObserver<T> r10, T r11);
}
