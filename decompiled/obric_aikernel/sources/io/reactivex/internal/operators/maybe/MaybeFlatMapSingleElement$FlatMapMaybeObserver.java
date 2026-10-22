package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xb.j;
import xb.s;
import zb.h;

/* JADX INFO: loaded from: classes2.dex */
final class MaybeFlatMapSingleElement$FlatMapMaybeObserver<T, R> extends AtomicReference<io.reactivex.disposables.b> implements j<T>, io.reactivex.disposables.b {
    private static final long serialVersionUID = 4827726964688405508L;
    final j<? super R> downstream;
    final h<? super T, ? extends s<? extends R>> mapper;

    MaybeFlatMapSingleElement$FlatMapMaybeObserver(j<? super R> r10, h<? super T, ? extends s<? extends R>> r11) {
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

    @Override // xb.j
    public void onComplete() {
        this.downstream.onComplete();
    }

    @Override // xb.j
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
    }

    @Override // xb.j
    public void onSubscribe(io.reactivex.disposables.b r10) {
        if (DisposableHelper.setOnce(this, r10) == false) goto L6;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // xb.j
    public void onSuccess(T r10) {
        s r11 = (s) io.reactivex.internal.functions.a.d(this.mapper.apply(r10), "The mapper returned a null SingleSource");     // Catch: Throwable -> L5
        r11.a(new c(this, this.downstream));
        return;
    L5:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        onError(th);
    }
}
