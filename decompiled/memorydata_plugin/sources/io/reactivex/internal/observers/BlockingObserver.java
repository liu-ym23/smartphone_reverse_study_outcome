package io.reactivex.internal.observers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.t;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class BlockingObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, t<T> {
    public static final Object TERMINATED = null;
    private static final long serialVersionUID = -4875965440900746268L;
    final Queue<Object> queue;

    static {
        TERMINATED = new Object();
    }

    public BlockingObserver(Queue<Object> r3) {
        this.queue = (Queue) ZeusTransformUtils.wrapperContextForParams(r3, Queue.class, "com.obric.memorydata.plugin");
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

    @Override // io.reactivex.t
    public void onComplete() {
        this.queue.offer(NotificationLite.complete());
    }

    @Override // io.reactivex.t
    public void onError(Throwable r1) {
        this.queue.offer(NotificationLite.error(r1));
    }

    @Override // io.reactivex.t
    public void onNext(T r1) {
        this.queue.offer(NotificationLite.next(r1));
    }

    @Override // io.reactivex.t
    public void onSubscribe(io.reactivex.disposables.b r3) {
        DisposableHelper.setOnce(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
    }
}
