package io.reactivex.internal.operators.maybe;

import ai.p;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import mt.h;
import mt.j;
import mt.k;
import pt.o;

/* JADX INFO: loaded from: classes3.dex */
final class MaybeOnErrorNext$OnErrorNextMaybeObserver<T> extends AtomicReference<Disposable> implements j, Disposable {
    private static final long serialVersionUID = 2026620218879969836L;
    final boolean allowFatal;
    final j downstream;
    final o resumeFunction;

    public MaybeOnErrorNext$OnErrorNextMaybeObserver(j r5, o r10, boolean r11) {
        this.downstream = r5;
        this.resumeFunction = r10;
        this.allowFatal = r11;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // mt.j
    public void onComplete() {
        this.downstream.onComplete();
    }

    @Override // mt.j
    public void onError(Throwable r5) {
        if (this.allowFatal == false) goto L5;
    L14:
        Object r10 = this.resumeFunction.apply(r5);     // Catch: Throwable -> L11
        io.reactivex.internal.functions.e.d(r10, "The resumeFunction returned a null MaybeSource");     // Catch: Throwable -> L11
        k r11 = (k) r10;     // Catch: Throwable -> L11
        DisposableHelper.replace(this, null);
        h r12 = (h) r11;
        r12.b(new p(11, this.downstream, this));
        return;
    L11:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.downstream.onError(new CompositeException(new Throwable[]{r5, th}));
        return;
    L5:
        if ((r5 instanceof Exception) == true) goto L14;
        this.downstream.onError(r5);
    }

    @Override // mt.j
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.setOnce(this, r5) == false) goto L6;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // mt.j
    public void onSuccess(T r5) {
        this.downstream.onSuccess(r5);
    }
}
