package io.reactivex.internal.observers;

/* JADX INFO: loaded from: classes6.dex */
public interface b<T> {
    void drain();

    void innerComplete(InnerQueuedObserver<T> r1);

    void innerError(InnerQueuedObserver<T> r1, Throwable r2);

    void innerNext(InnerQueuedObserver<T> r1, T r2);
}
