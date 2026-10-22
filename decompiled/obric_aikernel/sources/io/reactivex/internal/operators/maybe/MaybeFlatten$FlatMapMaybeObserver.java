package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xb.j;
import xb.k;
import zb.h;

/* JADX INFO: loaded from: classes2.dex */
final class MaybeFlatten$FlatMapMaybeObserver<T, R> extends AtomicReference<io.reactivex.disposables.b> implements j<T>, io.reactivex.disposables.b {
    private static final long serialVersionUID = 4375739915521278546L;
    final j<? super R> downstream;
    final h<? super T, ? extends k<? extends R>> mapper;
    io.reactivex.disposables.b upstream;

    final class a implements j<R> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ MaybeFlatten$FlatMapMaybeObserver f9532c;

        a(MaybeFlatten$FlatMapMaybeObserver r10) {
            this.f9532c = r10;
        }

        @Override // xb.j
        public void onComplete() {
            this.f9532c.downstream.onComplete();
        }

        @Override // xb.j
        public void onError(Throwable r10) {
            this.f9532c.downstream.onError(r10);
        }

        @Override // xb.j
        public void onSubscribe(io.reactivex.disposables.b r10) {
            DisposableHelper.setOnce(this.f9532c, r10);
        }

        @Override // xb.j
        public void onSuccess(R r10) {
            this.f9532c.downstream.onSuccess(r10);
        }
    }

    MaybeFlatten$FlatMapMaybeObserver(j<? super R> r10, h<? super T, ? extends k<? extends R>> r11) {
        this.downstream = r10;
        this.mapper = r11;
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
        this.downstream.onComplete();
    }

    @Override // xb.j
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
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
        k r11 = (k) io.reactivex.internal.functions.a.d(this.mapper.apply(r10), "The mapper returned a null MaybeSource");     // Catch: Exception -> L7
        if (isDisposed() == true) goto L12;
        r11.a(new a(this));
        return;
    L12:
        return;
    L7:
        e = move-exception;
        io.reactivex.exceptions.a.a(e);
        this.downstream.onError(e);
    }
}
