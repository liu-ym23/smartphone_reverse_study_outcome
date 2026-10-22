package io.reactivex.internal.operators.maybe;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.Observable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import io.reactivex.m;
import io.reactivex.o;
import io.reactivex.t;

/* JADX INFO: loaded from: classes6.dex */
public final class MaybeToObservable<T> extends Observable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final o<T> f16875a;

    static final class MaybeToObservableObserver<T> extends DeferredScalarDisposable<T> implements m<T> {
        private static final long serialVersionUID = 7603343402964826922L;
        io.reactivex.disposables.b upstream;

        MaybeToObservableObserver(t<? super T> r3) {
            super((t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.disposables.b
        public void dispose() {
            super.dispose();
            this.upstream.dispose();
        }

        @Override // io.reactivex.m
        public void onComplete() {
            complete();
        }

        @Override // io.reactivex.m
        public void onError(Throwable r1) {
            error(r1);
        }

        @Override // io.reactivex.m
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (DisposableHelper.validate(this.upstream, r4) == false) goto L6;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.m
        public void onSuccess(T r1) {
            complete(r1);
        }
    }

    public static <T> m<T> b(t<? super T> r2) {
        return new MaybeToObservableObserver((t) ZeusTransformUtils.wrapperContextForParams(r2, t.class, "com.obric.memorydata.plugin"));
    }

    @Override // io.reactivex.Observable
    public void a(t<? super T> r3) {
        t r4 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
        this.f16875a.a(b(r4));
    }
}
