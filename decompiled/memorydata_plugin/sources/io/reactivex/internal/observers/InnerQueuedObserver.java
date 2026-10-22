package io.reactivex.internal.observers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.a.f;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.h;
import io.reactivex.t;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class InnerQueuedObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, t<T> {
    private static final long serialVersionUID = -5417183359794346637L;
    volatile boolean done;
    int fusionMode;
    final b<T> parent;
    final int prefetch;
    f<T> queue;

    public InnerQueuedObserver(b<T> r3, int r4) {
        this.parent = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        this.prefetch = r4;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public int fusionMode() {
        return this.fusionMode;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
    }

    public boolean isDone() {
        return this.done;
    }

    @Override // io.reactivex.t
    public void onComplete() {
        this.parent.innerComplete(this);
    }

    @Override // io.reactivex.t
    public void onError(Throwable r2) {
        this.parent.innerError(this, r2);
    }

    @Override // io.reactivex.t
    public void onNext(T r2) {
        if (this.fusionMode != 0) goto L5;
        this.parent.innerNext(this, r2);
        return;
    L5:
        this.parent.drain();
    }

    @Override // io.reactivex.t
    public void onSubscribe(io.reactivex.disposables.b r3) {
        io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
        if (DisposableHelper.setOnce(this, r4) == true) goto L5;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r4, io.reactivex.internal.a.b.class) == false) goto L14;
        io.reactivex.internal.a.b r5 = (io.reactivex.internal.a.b) ZeusTransformUtils.preCheckCast(r4, io.reactivex.internal.a.b.class, "com.obric.memorydata.plugin");
        int r0 = r5.requestFusion(3);
        if (r0 != 1) goto L11;
        this.fusionMode = r0;
        this.queue = r5;
        this.done = true;
        this.parent.innerComplete(this);
        return;
    L11:
        if (r0 != 2) goto L14;
        this.fusionMode = r0;
        this.queue = r5;
        return;
    L14:
        this.queue = h.a(-this.prefetch);
    }

    public f<T> queue() {
        return this.queue;
    }

    public void setDone() {
        this.done = true;
    }
}
