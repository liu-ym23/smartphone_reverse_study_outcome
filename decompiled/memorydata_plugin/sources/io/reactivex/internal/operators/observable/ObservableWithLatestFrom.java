package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.s;
import io.reactivex.t;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableWithLatestFrom<T, U, R> extends io.reactivex.internal.operators.observable.a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.b.c<? super T, ? super U, ? extends R> f17025b;
    final s<? extends U> c;

    static final class WithLatestFromObserver<T, U, R> extends AtomicReference<U> implements io.reactivex.disposables.b, t<T> {
        private static final long serialVersionUID = -312246233408980075L;
        final io.reactivex.b.c<? super T, ? super U, ? extends R> combiner;
        final t<? super R> downstream;
        final AtomicReference<io.reactivex.disposables.b> other;
        final AtomicReference<io.reactivex.disposables.b> upstream;

        WithLatestFromObserver(t<? super R> r3, io.reactivex.b.c<? super T, ? super U, ? extends R> r4) {
            t<? super R> r5 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            io.reactivex.b.c<? super T, ? super U, ? extends R> r6 = (io.reactivex.b.c) ZeusTransformUtils.wrapperContextForParams(r4, io.reactivex.b.c.class, "com.obric.memorydata.plugin");
            this.upstream = new AtomicReference();
            this.other = new AtomicReference();
            this.downstream = r5;
            this.combiner = r6;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this.other);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(this.upstream.get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.t
        public void onComplete() {
            DisposableHelper.dispose(this.other);
            this.downstream.onComplete();
        }

        @Override // io.reactivex.t
        public void onError(Throwable r2) {
            DisposableHelper.dispose(this.other);
            this.downstream.onError(r2);
        }

        @Override // io.reactivex.t
        public void onNext(T r3) {
            U r0 = get();
            if (r0 == null) goto L11;
            Object r4 = io.reactivex.internal.functions.a.a(this.combiner.apply(r3, r0), "The combiner returned a null value");     // Catch: Throwable -> L6
            this.downstream.onNext(r4);
            return;
        L6:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            dispose();
            this.downstream.onError(th);
            return;
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            DisposableHelper.setOnce(this.upstream, r4);
        }

        public void otherError(Throwable r2) {
            DisposableHelper.dispose(this.upstream);
            this.downstream.onError(r2);
        }

        public boolean setOther(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            return DisposableHelper.setOnce(this.other, r4);
        }
    }

    final class a implements t<U> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ObservableWithLatestFrom f17026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final WithLatestFromObserver<T, U, R> f17027b;

        a(ObservableWithLatestFrom r1, WithLatestFromObserver<T, U, R> r2) {
            this.f17026a = r1;
            this.f17027b = r2;
        }

        @Override // io.reactivex.t
        public void onComplete() {
        }

        @Override // io.reactivex.t
        public void onError(Throwable r1) {
            this.f17027b.otherError(r1);
        }

        @Override // io.reactivex.t
        public void onNext(U r1) {
            this.f17027b.lazySet(r1);
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            this.f17027b.setOther(r4);
        }
    }

    @Override // io.reactivex.Observable
    public void a(t<? super R> r3) {
        io.reactivex.observers.b r0 = new io.reactivex.observers.b((t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin"));
        WithLatestFromObserver r4 = new WithLatestFromObserver(r0, this.f17025b);
        r0.onSubscribe(r4);
        this.c.subscribe(new a(this, r4));
        this.f17034a.subscribe(r4);
    }
}
