package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
abstract class ObservableSampleWithObservable$SampleMainObserver<T> extends AtomicReference<T> implements mt.u, Disposable {
    private static final long serialVersionUID = -3517602651313910099L;
    final mt.u downstream;
    final AtomicReference<Disposable> other;
    final mt.s sampler;
    Disposable upstream;

    public ObservableSampleWithObservable$SampleMainObserver(mt.u r5, mt.s r10) {
        this.other = new AtomicReference();
        this.downstream = r5;
        this.sampler = r10;
    }

    public void complete() {
        this.upstream.dispose();
        completion();
    }

    public abstract void completion();

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this.other);
        this.upstream.dispose();
    }

    public void emit() {
        T r5 = getAndSet(null);
        if (r5 == null) goto L6;
        this.downstream.onNext(r5);
        return;
    }

    public void error(Throwable r5) {
        this.upstream.dispose();
        this.downstream.onError(r5);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (this.other.get() != DisposableHelper.DISPOSED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // mt.u
    public void onComplete() {
        DisposableHelper.dispose(this.other);
        completion();
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        DisposableHelper.dispose(this.other);
        this.downstream.onError(r5);
    }

    @Override // mt.u
    public void onNext(T r5) {
        lazySet(r5);
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.upstream, r5) == false) goto L8;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        if (this.other.get() != null) goto L9;
        this.sampler.subscribe(new o3(this, 0));
        return;
    L9:
        return;
    }

    public abstract void run();

    public boolean setOther(Disposable r5) {
        return DisposableHelper.setOnce(this.other, r5);
    }
}
