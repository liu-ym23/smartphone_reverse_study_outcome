package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.t;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class ObserverResourceWrapper<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, t<T> {
    private static final long serialVersionUID = -8612022020200669122L;
    final t<? super T> downstream;
    final AtomicReference<io.reactivex.disposables.b> upstream;

    public ObserverResourceWrapper(t<? super T> r3) {
        t<? super T> r4 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
        this.upstream = new AtomicReference();
        this.downstream = r4;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        if (this.upstream.get() != DisposableHelper.DISPOSED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.t
    public void onComplete() {
        dispose();
        this.downstream.onComplete();
    }

    @Override // io.reactivex.t
    public void onError(Throwable r1) {
        dispose();
        this.downstream.onError(r1);
    }

    @Override // io.reactivex.t
    public void onNext(T r1) {
        this.downstream.onNext(r1);
    }

    @Override // io.reactivex.t
    public void onSubscribe(io.reactivex.disposables.b r3) {
        io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
        if (DisposableHelper.setOnce(this.upstream, r4) == false) goto L6;
        this.downstream.onSubscribe(this);
        return;
    }

    public void setResource(io.reactivex.disposables.b r3) {
        DisposableHelper.set(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
    }
}
