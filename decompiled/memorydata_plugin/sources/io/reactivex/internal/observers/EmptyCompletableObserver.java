package io.reactivex.internal.observers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class EmptyCompletableObserver extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.c, io.reactivex.disposables.b {
    private static final long serialVersionUID = -7545121636549663526L;

    public EmptyCompletableObserver() {
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean hasCustomOnError() {
        return false;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        if (get() != DisposableHelper.DISPOSED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.c
    public void onComplete() {
        lazySet(DisposableHelper.DISPOSED);
    }

    @Override // io.reactivex.c
    public void onError(Throwable r2) {
        lazySet(DisposableHelper.DISPOSED);
        io.reactivex.d.a.a(new OnErrorNotImplementedException(r2));
    }

    @Override // io.reactivex.c
    public void onSubscribe(io.reactivex.disposables.b r3) {
        DisposableHelper.setOnce(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
    }
}
