package io.reactivex.internal.operators.maybe;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import xb.j;
import xb.k;
import zb.h;

/* JADX INFO: loaded from: classes2.dex */
final class MaybeFlatMapNotification$FlatMapMaybeObserver<T, R> extends AtomicReference<io.reactivex.disposables.b> implements j<T>, io.reactivex.disposables.b {
    private static final long serialVersionUID = 4375739915521278546L;
    final j<? super R> downstream;
    final Callable<? extends k<? extends R>> onCompleteSupplier;
    final h<? super Throwable, ? extends k<? extends R>> onErrorMapper;
    final h<? super T, ? extends k<? extends R>> onSuccessMapper;
    io.reactivex.disposables.b upstream;

    final class a implements j<R> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ MaybeFlatMapNotification$FlatMapMaybeObserver f9531c;

        a(MaybeFlatMapNotification$FlatMapMaybeObserver r10) {
            this.f9531c = r10;
        }

        @Override // xb.j
        public void onComplete() {
            this.f9531c.downstream.onComplete();
        }

        @Override // xb.j
        public void onError(Throwable r10) {
            this.f9531c.downstream.onError(r10);
        }

        @Override // xb.j
        public void onSubscribe(io.reactivex.disposables.b r10) {
            DisposableHelper.setOnce(this.f9531c, r10);
        }

        @Override // xb.j
        public void onSuccess(R r10) {
            this.f9531c.downstream.onSuccess(r10);
        }
    }

    MaybeFlatMapNotification$FlatMapMaybeObserver(j<? super R> r10, h<? super T, ? extends k<? extends R>> r11, h<? super Throwable, ? extends k<? extends R>> r12, Callable<? extends k<? extends R>> r13) {
        this.downstream = r10;
        this.onSuccessMapper = r11;
        this.onErrorMapper = r12;
        this.onCompleteSupplier = r13;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this);
        this.upstream.dispose();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // xb.j
    public void onComplete() {
        k r10 = (k) io.reactivex.internal.functions.a.d(this.onCompleteSupplier.call(), "The onCompleteSupplier returned a null MaybeSource");     // Catch: Exception -> L5
        r10.a(new a(this));
        return;
    L5:
        e = move-exception;
        io.reactivex.exceptions.a.a(e);
        this.downstream.onError(e);
    }

    @Override // xb.j
    public void onError(Throwable r10) {
        ((k) io.reactivex.internal.functions.a.d(this.onErrorMapper.apply(r10), "The onErrorMapper returned a null MaybeSource")).a(new a(this));
        return;
    L5:
        e = move-exception;
        io.reactivex.exceptions.a.a(e);
        this.downstream.onError(new CompositeException(new Throwable[]{r10, e}));
    }

    @Override // xb.j
    public void onSubscribe(io.reactivex.disposables.b r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // xb.j
    public void onSuccess(T r10) {
        k r11 = (k) io.reactivex.internal.functions.a.d(this.onSuccessMapper.apply(r10), "The onSuccessMapper returned a null MaybeSource");     // Catch: Exception -> L5
        r11.a(new a(this));
        return;
    L5:
        e = move-exception;
        io.reactivex.exceptions.a.a(e);
        this.downstream.onError(e);
    }
}
