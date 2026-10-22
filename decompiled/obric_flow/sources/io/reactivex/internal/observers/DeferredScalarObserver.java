package io.reactivex.internal.observers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import mt.u;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DeferredScalarObserver<T, R> extends DeferredScalarDisposable<R> implements u {
    private static final long serialVersionUID = -266195175408988651L;
    protected Disposable upstream;

    public DeferredScalarObserver(u r5) {
        super(r5);
    }

    @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.disposables.Disposable
    public void dispose() {
        super.dispose();
        this.upstream.dispose();
    }

    @Override // mt.u
    public void onComplete() {
        T r5 = this.value;
        if (r5 == null) goto L5;
        this.value = null;
        complete(r5);
        return;
    L5:
        complete();
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        this.value = null;
        error(r5);
    }

    @Override // mt.u
    public abstract /* synthetic */ void onNext(Object r5);

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        return;
    }
}
