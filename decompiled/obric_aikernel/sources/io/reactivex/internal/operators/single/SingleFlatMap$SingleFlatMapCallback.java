package io.reactivex.internal.operators.single;

import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xb.r;
import xb.s;
import zb.h;

/* JADX INFO: loaded from: classes2.dex */
final class SingleFlatMap$SingleFlatMapCallback<T, R> extends AtomicReference<b> implements r<T>, b {
    private static final long serialVersionUID = 3258103020495908596L;
    final r<? super R> downstream;
    final h<? super T, ? extends s<? extends R>> mapper;

    static final class a<R> implements r<R> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicReference<b> f9592c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final r<? super R> f9593g;

        a(AtomicReference<b> r10, r<? super R> r11) {
            this.f9592c = r10;
            this.f9593g = r11;
        }

        @Override // xb.r
        public void onError(Throwable r10) {
            this.f9593g.onError(r10);
        }

        @Override // xb.r
        public void onSubscribe(b r10) {
            DisposableHelper.replace(this.f9592c, r10);
        }

        @Override // xb.r
        public void onSuccess(R r10) {
            this.f9593g.onSuccess(r10);
        }
    }

    SingleFlatMap$SingleFlatMapCallback(r<? super R> r10, h<? super T, ? extends s<? extends R>> r11) {
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
        s r11 = (s) io.reactivex.internal.functions.a.d(this.mapper.apply(r10), "The single returned by the mapper is null");     // Catch: Throwable -> L7
        if (isDisposed() == true) goto L12;
        r11.a(new a(this, this.downstream));
        return;
    L12:
        return;
    L7:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.downstream.onError(th);
    }
}
