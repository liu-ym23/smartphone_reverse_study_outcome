package io.reactivex.internal.observers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.g;
import io.reactivex.b.j;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.t;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class ForEachWhileObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, t<T> {
    private static final long serialVersionUID = -4403180040475402120L;
    boolean done;
    final io.reactivex.b.a onComplete;
    final g<? super Throwable> onError;
    final j<? super T> onNext;

    public ForEachWhileObserver(j<? super T> r3, g<? super Throwable> r4, io.reactivex.b.a r5) {
        j<? super T> r6 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin");
        g<? super Throwable> r7 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.memorydata.plugin");
        io.reactivex.b.a r8 = (io.reactivex.b.a) ZeusTransformUtils.wrapperContextForParams(r5, io.reactivex.b.a.class, "com.obric.memorydata.plugin");
        this.onNext = r6;
        this.onError = r7;
        this.onComplete = r8;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
    }

    @Override // io.reactivex.t
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        this.onComplete.a();     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        io.reactivex.d.a.a(th);
    }

    @Override // io.reactivex.t
    public void onError(Throwable r5) {
        if (this.done == false) goto L6;
        io.reactivex.d.a.a(r5);
        return;
    L6:
        this.done = true;
        this.onError.accept(r5);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        io.reactivex.d.a.a(new CompositeException(new Throwable[]{r5, th}));
    }

    @Override // io.reactivex.t
    public void onNext(T r2) {
        if (this.done == false) goto L12;
        return;
    L12:
        if (this.onNext.test(r2) == true) goto L14;
        dispose();
        onComplete();
        return;
    L14:
        return;
    L9:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        dispose();
        onError(th);
    }

    @Override // io.reactivex.t
    public void onSubscribe(io.reactivex.disposables.b r3) {
        DisposableHelper.setOnce(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
    }
}
