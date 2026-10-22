package io.reactivex.internal.operators.single;

import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xb.j;
import xb.k;
import xb.r;
import zb.h;

/* JADX INFO: loaded from: classes2.dex */
final class SingleFlatMapMaybe$FlatMapSingleObserver<T, R> extends AtomicReference<b> implements r<T>, b {
    private static final long serialVersionUID = -5843758257109742742L;
    final j<? super R> downstream;
    final h<? super T, ? extends k<? extends R>> mapper;

    SingleFlatMapMaybe$FlatMapSingleObserver(j<? super R> r10, h<? super T, ? extends k<? extends R>> r11) {
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

    @Override // xb.r
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
    }

    @Override // xb.r
    public void onSubscribe(b r10) {
        if (DisposableHelper.setOnce(this, r10) == false) goto L6;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // xb.r
    public void onSuccess(T r10) {
        k r11 = (k) io.reactivex.internal.functions.a.d(this.mapper.apply(r10), "The mapper returned a null MaybeSource");     // Catch: Throwable -> L7
        if (isDisposed() == true) goto L12;
        r11.a(new a(this, this.downstream));
        return;
    L12:
        return;
    L7:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        onError(th);
    }
}
