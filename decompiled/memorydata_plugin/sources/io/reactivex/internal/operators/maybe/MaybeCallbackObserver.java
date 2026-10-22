package io.reactivex.internal.operators.maybe;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.g;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.Functions;
import io.reactivex.m;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class MaybeCallbackObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, m<T> {
    private static final long serialVersionUID = -6076952298809384986L;
    final io.reactivex.b.a onComplete;
    final g<? super Throwable> onError;
    final g<? super T> onSuccess;

    public MaybeCallbackObserver(g<? super T> r3, g<? super Throwable> r4, io.reactivex.b.a r5) {
        g<? super T> r6 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin");
        g<? super Throwable> r7 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.memorydata.plugin");
        io.reactivex.b.a r8 = (io.reactivex.b.a) ZeusTransformUtils.wrapperContextForParams(r5, io.reactivex.b.a.class, "com.obric.memorydata.plugin");
        this.onSuccess = r6;
        this.onError = r7;
        this.onComplete = r8;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean hasCustomOnError() {
        if (this.onError == Functions.f) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
    }

    @Override // io.reactivex.m
    public void onComplete() {
        lazySet(DisposableHelper.DISPOSED);
        this.onComplete.a();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        io.reactivex.d.a.a(th);
    }

    @Override // io.reactivex.m
    public void onError(Throwable r4) {
        lazySet(DisposableHelper.DISPOSED);
        this.onError.accept(r4);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        io.reactivex.d.a.a(new CompositeException(new Throwable[]{r4, th}));
    }

    @Override // io.reactivex.m
    public void onSubscribe(io.reactivex.disposables.b r3) {
        DisposableHelper.setOnce(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
    }

    @Override // io.reactivex.m
    public void onSuccess(T r2) {
        lazySet(DisposableHelper.DISPOSED);
        this.onSuccess.accept(r2);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        io.reactivex.d.a.a(th);
    }
}
