package io.reactivex.internal.operators.maybe;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import mt.h;
import mt.j;
import mt.k;
import pt.o;

/* JADX INFO: loaded from: classes3.dex */
final class MaybeFlatMapNotification$FlatMapMaybeObserver<T, R> extends AtomicReference<Disposable> implements j, Disposable {
    private static final long serialVersionUID = 4375739915521278546L;
    final j downstream;
    final Callable<? extends k> onCompleteSupplier;
    final o onErrorMapper;
    final o onSuccessMapper;
    Disposable upstream;

    public MaybeFlatMapNotification$FlatMapMaybeObserver(j r5, o r10, o r11, Callable<? extends k> r12) {
        this.downstream = r5;
        this.onSuccessMapper = r10;
        this.onErrorMapper = r11;
        this.onCompleteSupplier = r12;
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
        k r5 = this.onCompleteSupplier.call();     // Catch: Exception -> L5
        io.reactivex.internal.functions.e.d(r5, "The onCompleteSupplier returned a null MaybeSource");     // Catch: Exception -> L5
        k r10 = r5;     // Catch: Exception -> L5
        h r11 = (h) r10;
        r11.b(new b(this, 0));
        return;
    L5:
        e = move-exception;
        com.lynx.jsbridge.a.t(e);
        this.downstream.onError(e);
    }

    @Override // mt.j
    public void onError(Throwable r5) {
        Object r10 = this.onErrorMapper.apply(r5);     // Catch: Exception -> L6
        io.reactivex.internal.functions.e.d(r10, "The onErrorMapper returned a null MaybeSource");     // Catch: Exception -> L6
        ((h) ((k) r10)).b(new b(this, 0));
        return;
    L6:
        e = move-exception;
        com.lynx.jsbridge.a.t(e);
        this.downstream.onError(new CompositeException(new Throwable[]{r5, e}));
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
        Object r10 = this.onSuccessMapper.apply(r5);     // Catch: Exception -> L5
        io.reactivex.internal.functions.e.d(r10, "The onSuccessMapper returned a null MaybeSource");     // Catch: Exception -> L5
        k r11 = (k) r10;     // Catch: Exception -> L5
        h r12 = (h) r11;
        r12.b(new b(this, 0));
        return;
    L5:
        e = move-exception;
        com.lynx.jsbridge.a.t(e);
        this.downstream.onError(e);
    }
}
