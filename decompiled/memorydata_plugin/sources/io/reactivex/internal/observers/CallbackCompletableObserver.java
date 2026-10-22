package io.reactivex.internal.observers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.g;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class CallbackCompletableObserver extends AtomicReference<io.reactivex.disposables.b> implements g<Throwable>, io.reactivex.c, io.reactivex.disposables.b {
    private static final long serialVersionUID = -4361286194466301354L;
    final io.reactivex.b.a onComplete;
    final g<? super Throwable> onError;

    public CallbackCompletableObserver(io.reactivex.b.a r3) {
        io.reactivex.b.a r4 = (io.reactivex.b.a) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.b.a.class, "com.obric.memorydata.plugin");
        this.onError = this;
        this.onComplete = r4;
    }

    public CallbackCompletableObserver(g<? super Throwable> r3, io.reactivex.b.a r4) {
        g<? super Throwable> r5 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin");
        io.reactivex.b.a r6 = (io.reactivex.b.a) ZeusTransformUtils.wrapperContextForParams(r4, io.reactivex.b.a.class, "com.obric.memorydata.plugin");
        this.onError = r5;
        this.onComplete = r6;
    }

    @Override // io.reactivex.b.g
    public /* synthetic */ void accept(Throwable r3) {
        accept2((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
    public void accept2(Throwable r1) {
        io.reactivex.d.a.a(new OnErrorNotImplementedException(r1));
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean hasCustomOnError() {
        if (this.onError == this) goto L5;
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

    @Override // io.reactivex.c
    public void onComplete() {
        this.onComplete.a();     // Catch: Throwable -> L4
    L6:
        lazySet(DisposableHelper.DISPOSED);
        return;
    L4:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        io.reactivex.d.a.a(th);
        goto L6
    }

    @Override // io.reactivex.c
    public void onError(Throwable r2) {
        this.onError.accept(r2);     // Catch: Throwable -> L4
    L6:
        lazySet(DisposableHelper.DISPOSED);
        return;
    L4:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        io.reactivex.d.a.a(th);
        goto L6
    }

    @Override // io.reactivex.c
    public void onSubscribe(io.reactivex.disposables.b r3) {
        DisposableHelper.setOnce(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
    }
}
