package io.reactivex.internal.observers;

import io.reactivex.internal.disposables.DisposableHelper;
import xb.o;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DeferredScalarObserver<T, R> extends DeferredScalarDisposable<R> implements o<T> {
    private static final long serialVersionUID = -266195175408988651L;
    protected io.reactivex.disposables.b upstream;

    public DeferredScalarObserver(o<? super R> r10) {
        super(r10);
    }

    @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.internal.observers.BasicIntQueueDisposable, io.reactivex.disposables.b
    public void dispose() {
        super.dispose();
        this.upstream.dispose();
    }

    @Override // xb.o
    public void onComplete() {
        T r10 = this.value;
        if (r10 == null) goto L5;
        this.value = null;
        complete(r10);
        return;
    L5:
        complete();
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        this.value = null;
        error(r10);
    }

    @Override // xb.o
    public abstract /* synthetic */ void onNext(T r10);

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }
}
