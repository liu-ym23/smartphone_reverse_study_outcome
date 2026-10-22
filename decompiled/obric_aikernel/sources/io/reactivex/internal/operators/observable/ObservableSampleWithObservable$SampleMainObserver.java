package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
abstract class ObservableSampleWithObservable$SampleMainObserver<T> extends AtomicReference<T> implements xb.o<T>, io.reactivex.disposables.b {
    private static final long serialVersionUID = -3517602651313910099L;
    final xb.o<? super T> downstream;
    final AtomicReference<io.reactivex.disposables.b> other;
    final xb.n<?> sampler;
    io.reactivex.disposables.b upstream;

    ObservableSampleWithObservable$SampleMainObserver(xb.o<? super T> r10, xb.n<?> r11) {
        this.other = new AtomicReference();
        this.downstream = r10;
        this.sampler = r11;
    }

    public void complete() {
        this.upstream.dispose();
        completeOther();
    }

    abstract void completeMain();

    abstract void completeOther();

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this.other);
        this.upstream.dispose();
    }

    void emit() {
        T r10 = getAndSet(null);
        if (r10 == null) goto L6;
        this.downstream.onNext(r10);
        return;
    }

    public void error(Throwable r10) {
        this.upstream.dispose();
        this.downstream.onError(r10);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        if (this.other.get() != DisposableHelper.DISPOSED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // xb.o
    public void onComplete() {
        DisposableHelper.dispose(this.other);
        completeMain();
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        DisposableHelper.dispose(this.other);
        this.downstream.onError(r10);
    }

    @Override // xb.o
    public void onNext(T r10) {
        lazySet(r10);
    }

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L8;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        if (this.other.get() != null) goto L9;
        this.sampler.subscribe(new h(this));
        return;
    L9:
        return;
    }

    abstract void run();

    boolean setOther(io.reactivex.disposables.b r10) {
        return DisposableHelper.setOnce(this.other, r10);
    }
}
