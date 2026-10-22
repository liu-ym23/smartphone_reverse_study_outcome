package io.reactivex.internal.observers;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;
import xb.o;

/* JADX INFO: loaded from: classes2.dex */
public final class BlockingObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements o<T>, io.reactivex.disposables.b {
    public static final Object TERMINATED = null;
    private static final long serialVersionUID = -4875965440900746268L;
    final Queue<Object> queue;

    static {
        TERMINATED = new Object();
    }

    public BlockingObserver(Queue<Object> r10) {
        this.queue = r10;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        if (DisposableHelper.dispose(this) == false) goto L6;
        this.queue.offer(TERMINATED);
        return;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        if (get() != DisposableHelper.DISPOSED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // xb.o
    public void onComplete() {
        this.queue.offer(NotificationLite.complete());
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        this.queue.offer(NotificationLite.error(r10));
    }

    @Override // xb.o
    public void onNext(T r10) {
        this.queue.offer(NotificationLite.next(r10));
    }

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
        DisposableHelper.setOnce(this, r10);
    }
}
