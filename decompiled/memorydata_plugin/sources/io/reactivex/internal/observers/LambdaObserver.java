package io.reactivex.internal.observers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.g;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.Functions;
import io.reactivex.t;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class LambdaObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, t<T> {
    private static final long serialVersionUID = -7251123623727029452L;
    final io.reactivex.b.a onComplete;
    final g<? super Throwable> onError;
    final g<? super T> onNext;
    final g<? super io.reactivex.disposables.b> onSubscribe;

    public LambdaObserver(g<? super T> r3, g<? super Throwable> r4, io.reactivex.b.a r5, g<? super io.reactivex.disposables.b> r6) {
        g<? super T> r7 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin");
        g<? super Throwable> r8 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.memorydata.plugin");
        io.reactivex.b.a r9 = (io.reactivex.b.a) ZeusTransformUtils.wrapperContextForParams(r5, io.reactivex.b.a.class, "com.obric.memorydata.plugin");
        g<? super io.reactivex.disposables.b> r10 = (g) ZeusTransformUtils.wrapperContextForParams(r6, g.class, "com.obric.memorydata.plugin");
        this.onNext = r7;
        this.onError = r8;
        this.onComplete = r9;
        this.onSubscribe = r10;
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
        if (get() != DisposableHelper.DISPOSED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.t
    public void onComplete() {
        if (isDisposed() == true) goto L12;
        lazySet(DisposableHelper.DISPOSED);
        this.onComplete.a();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        io.reactivex.d.a.a(th);
        return;
    }

    @Override // io.reactivex.t
    public void onError(Throwable r4) {
        if (isDisposed() == true) goto L9;
        lazySet(DisposableHelper.DISPOSED);
        this.onError.accept(r4);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        io.reactivex.d.a.a(new CompositeException(new Throwable[]{r4, th}));
        return;
    L9:
        io.reactivex.d.a.a(r4);
    }

    @Override // io.reactivex.t
    public void onNext(T r4) {
        if (isDisposed() == true) goto L11;
        this.onNext.accept(r4);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        ((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin")).dispose();
        onError(th);
        return;
    }

    @Override // io.reactivex.t
    public void onSubscribe(io.reactivex.disposables.b r3) {
        io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
        if (DisposableHelper.setOnce(this, r4) == false) goto L11;
        this.onSubscribe.accept(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        r4.dispose();
        onError(th);
        return;
    }
}
