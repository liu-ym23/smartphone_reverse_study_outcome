package io.reactivex.internal.operators.mixed;

import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.a;
import java.util.concurrent.atomic.AtomicReference;
import xb.n;
import xb.o;
import xb.r;
import zb.h;

/* JADX INFO: loaded from: classes2.dex */
final class SingleFlatMapObservable$FlatMapObserver<T, R> extends AtomicReference<b> implements o<R>, r<T>, b {
    private static final long serialVersionUID = -8948264376121066672L;
    final o<? super R> downstream;
    final h<? super T, ? extends n<? extends R>> mapper;

    SingleFlatMapObservable$FlatMapObserver(o<? super R> r10, h<? super T, ? extends n<? extends R>> r11) {
        this.downstream = r10;
        this.mapper = r11;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // xb.o
    public void onComplete() {
        this.downstream.onComplete();
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
    }

    @Override // xb.o
    public void onNext(R r10) {
        this.downstream.onNext(r10);
    }

    @Override // xb.o
    public void onSubscribe(b r10) {
        DisposableHelper.replace(this, r10);
    }

    @Override // xb.r
    public void onSuccess(T r10) {
        ((n) a.d(this.mapper.apply(r10), "The mapper returned a null Publisher")).subscribe(this);
        return;
    L5:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.downstream.onError(th);
    }
}
