package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.Observable;
import io.reactivex.b.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.s;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.t;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservablePublishSelector<T, R> extends io.reactivex.internal.operators.observable.a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h<? super Observable<T>, ? extends s<R>> f16967b;

    static final class TargetObserver<T, R> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, t<R> {
        private static final long serialVersionUID = 854110278590336484L;
        final t<? super R> downstream;
        io.reactivex.disposables.b upstream;

        TargetObserver(t<? super R> r3) {
            this.downstream = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.upstream.dispose();
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.t
        public void onComplete() {
            DisposableHelper.dispose(this);
            this.downstream.onComplete();
        }

        @Override // io.reactivex.t
        public void onError(Throwable r1) {
            DisposableHelper.dispose(this);
            this.downstream.onError(r1);
        }

        @Override // io.reactivex.t
        public void onNext(R r1) {
            this.downstream.onNext(r1);
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (DisposableHelper.validate(this.upstream, r4) == false) goto L6;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            return;
        }
    }

    static final class a<T, R> implements t<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final PublishSubject<T> f16968a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicReference<io.reactivex.disposables.b> f16969b;

        a(PublishSubject<T> r1, AtomicReference<io.reactivex.disposables.b> r2) {
            this.f16968a = r1;
            this.f16969b = r2;
        }

        @Override // io.reactivex.t
        public void onComplete() {
            this.f16968a.onComplete();
        }

        @Override // io.reactivex.t
        public void onError(Throwable r1) {
            this.f16968a.onError(r1);
        }

        @Override // io.reactivex.t
        public void onNext(T r1) {
            this.f16968a.onNext(r1);
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            DisposableHelper.setOnce(this.f16969b, r4);
        }
    }

    @Override // io.reactivex.Observable
    public void a(t<? super R> r5) {
        t r6 = (t) ZeusTransformUtils.wrapperContextForParams(r5, t.class, "com.obric.memorydata.plugin");
        PublishSubject r0 = PublishSubject.b();
        s r1 = (s) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.f16967b.apply(r0), "The selector returned a null ObservableSource"), s.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        TargetObserver r2 = new TargetObserver(r6);
        r1.subscribe(r2);
        this.f17034a.subscribe(new a(r0, r2));
        return;
    L6:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        EmptyDisposable.error(th, r6);
    }
}
