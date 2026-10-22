package io.reactivex.internal.operators.maybe;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import mt.h;
import mt.j;
import mt.k;
import pt.o;

/* JADX INFO: loaded from: classes3.dex */
final class MaybeFlatten$FlatMapMaybeObserver<T, R> extends AtomicReference<Disposable> implements j, Disposable {
    private static final long serialVersionUID = 4375739915521278546L;
    final j downstream;
    final o mapper;
    Disposable upstream;

    public MaybeFlatten$FlatMapMaybeObserver(j r5, o r10) {
        this.downstream = r5;
        this.mapper = r10;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
        this.upstream.dispose();
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
        this.downstream.onError(r5);
    }

    @Override // mt.j
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // mt.j
    public void onSuccess(T r5) {
        Object r10 = this.mapper.apply(r5);     // Catch: Exception -> L7
        io.reactivex.internal.functions.e.d(r10, "The mapper returned a null MaybeSource");     // Catch: Exception -> L7
        k r11 = (k) r10;     // Catch: Exception -> L7
        if (isDisposed() == true) goto L12;
        h r12 = (h) r11;
        r12.b(new b(this, 1));
        return;
    L12:
        return;
    L7:
        e = move-exception;
        com.lynx.jsbridge.a.t(e);
        this.downstream.onError(e);
    }
}
