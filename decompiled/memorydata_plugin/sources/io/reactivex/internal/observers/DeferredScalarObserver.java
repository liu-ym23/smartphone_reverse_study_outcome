package io.reactivex.internal.observers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.t;

/* JADX INFO: loaded from: classes6.dex */
public abstract class DeferredScalarObserver<T, R> extends DeferredScalarDisposable<R> implements t<T> {
    private static final long serialVersionUID = -266195175408988651L;
    protected io.reactivex.disposables.b upstream;

    public DeferredScalarObserver(t<? super R> r3) {
        super((t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin"));
    }

    @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.disposables.b
    public void dispose() {
        super.dispose();
        this.upstream.dispose();
    }

    @Override // io.reactivex.t
    public void onComplete() {
        T r0 = this.value;
        if (r0 == null) goto L5;
        this.value = null;
        complete(r0);
        return;
    L5:
        complete();
    }

    @Override // io.reactivex.t
    public void onError(Throwable r2) {
        this.value = null;
        error(r2);
    }

    @Override // io.reactivex.t
    public void onSubscribe(io.reactivex.disposables.b r3) {
        io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
        if (DisposableHelper.validate(this.upstream, r4) == false) goto L6;
        this.upstream = r4;
        this.downstream.onSubscribe(this);
        return;
    }
}
