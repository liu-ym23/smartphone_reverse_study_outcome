package io.reactivex.internal.operators.single;

import io.reactivex.Observable;
import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import xb.o;
import xb.r;
import xb.s;

/* JADX INFO: loaded from: classes2.dex */
public final class SingleToObservable<T> extends Observable<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final s<? extends T> f9595c;

    static final class SingleToObservableObserver<T> extends DeferredScalarDisposable<T> implements r<T> {
        private static final long serialVersionUID = 3786543492451018833L;
        b upstream;

        SingleToObservableObserver(o<? super T> r10) {
            super(r10);
        }

        @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.internal.observers.BasicIntQueueDisposable, io.reactivex.disposables.b
        public void dispose() {
            super.dispose();
            this.upstream.dispose();
        }

        @Override // xb.r
        public void onError(Throwable r10) {
            error(r10);
        }

        @Override // xb.r
        public void onSubscribe(b r10) {
            if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
            this.upstream = r10;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // xb.r
        public void onSuccess(T r10) {
            complete(r10);
        }
    }

    public SingleToObservable(s<? extends T> r10) {
        this.f9595c = r10;
    }

    public static <T> r<T> h(o<? super T> r10) {
        return new SingleToObservableObserver(r10);
    }

    @Override // io.reactivex.Observable
    public void f(o<? super T> r10) {
        this.f9595c.a(h(r10));
    }
}
