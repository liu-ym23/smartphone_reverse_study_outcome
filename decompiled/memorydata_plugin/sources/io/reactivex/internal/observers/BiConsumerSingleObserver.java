package io.reactivex.internal.observers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.x;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class BiConsumerSingleObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, x<T> {
    private static final long serialVersionUID = 4943102778943297569L;
    final io.reactivex.b.b<? super T, ? super Throwable> onCallback;

    public BiConsumerSingleObserver(io.reactivex.b.b<? super T, ? super Throwable> r3) {
        this.onCallback = (io.reactivex.b.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.b.b.class, "com.obric.memorydata.plugin");
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        if (get() != DisposableHelper.DISPOSED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.x
    public void onError(Throwable r4) {
        lazySet(DisposableHelper.DISPOSED);     // Catch: Throwable -> L4
        this.onCallback.a(null, r4);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        io.reactivex.d.a.a(new CompositeException(new Throwable[]{r4, th}));
    }

    @Override // io.reactivex.x
    public void onSubscribe(io.reactivex.disposables.b r3) {
        DisposableHelper.setOnce(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
    }

    @Override // io.reactivex.x
    public void onSuccess(T r2) {
        lazySet(DisposableHelper.DISPOSED);     // Catch: Throwable -> L4
        this.onCallback.a(r2, null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        io.reactivex.d.a.a(th);
    }
}
