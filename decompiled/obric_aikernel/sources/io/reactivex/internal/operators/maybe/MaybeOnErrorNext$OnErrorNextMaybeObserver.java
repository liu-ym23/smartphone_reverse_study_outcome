package io.reactivex.internal.operators.maybe;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xb.j;
import xb.k;
import zb.h;

/* JADX INFO: loaded from: classes2.dex */
final class MaybeOnErrorNext$OnErrorNextMaybeObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements j<T>, io.reactivex.disposables.b {
    private static final long serialVersionUID = 2026620218879969836L;
    final boolean allowFatal;
    final j<? super T> downstream;
    final h<? super Throwable, ? extends k<? extends T>> resumeFunction;

    static final class a<T> implements j<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final j<? super T> f9533c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final AtomicReference<io.reactivex.disposables.b> f9534g;

        a(j<? super T> r10, AtomicReference<io.reactivex.disposables.b> r11) {
            this.f9533c = r10;
            this.f9534g = r11;
        }

        @Override // xb.j
        public void onComplete() {
            this.f9533c.onComplete();
        }

        @Override // xb.j
        public void onError(Throwable r10) {
            this.f9533c.onError(r10);
        }

        @Override // xb.j
        public void onSubscribe(io.reactivex.disposables.b r10) {
            DisposableHelper.setOnce(this.f9534g, r10);
        }

        @Override // xb.j
        public void onSuccess(T r10) {
            this.f9533c.onSuccess(r10);
        }
    }

    MaybeOnErrorNext$OnErrorNextMaybeObserver(j<? super T> r10, h<? super Throwable, ? extends k<? extends T>> r11, boolean r12) {
        this.downstream = r10;
        this.resumeFunction = r11;
        this.allowFatal = r12;
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
        if (this.allowFatal == false) goto L5;
    L14:
        k r11 = (k) io.reactivex.internal.functions.a.d(this.resumeFunction.apply(r10), "The resumeFunction returned a null MaybeSource");     // Catch: Throwable -> L11
        DisposableHelper.replace(this, null);
        r11.a(new a(this.downstream, this));
        return;
    L11:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.downstream.onError(new CompositeException(new Throwable[]{r10, th}));
        return;
    L5:
        if ((r10 instanceof Exception) == true) goto L14;
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
        this.downstream.onSuccess(r10);
    }
}
