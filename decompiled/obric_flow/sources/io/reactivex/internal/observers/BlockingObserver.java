package io.reactivex.internal.observers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;
import mt.u;

/* JADX INFO: loaded from: classes3.dex */
public final class BlockingObserver<T> extends AtomicReference<Disposable> implements u, Disposable {
    public static final Object TERMINATED = null;
    private static final long serialVersionUID = -4875965440900746268L;
    final Queue<Object> queue;

    static {
        TERMINATED = new Object();
    }

    public BlockingObserver(Queue<Object> r5) {
        this.queue = r5;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (DisposableHelper.dispose(this) == false) goto L6;
        this.queue.offer(TERMINATED);
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get() != DisposableHelper.DISPOSED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // mt.u
    public void onComplete() {
        this.queue.offer(NotificationLite.complete());
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        this.queue.offer(NotificationLite.error(r5));
    }

    @Override // mt.u
    public void onNext(T r5) {
        this.queue.offer(NotificationLite.next(r5));
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        DisposableHelper.setOnce(this, r5);
    }
}
