package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.Observable;
import io.reactivex.b.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.e;
import io.reactivex.s;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.t;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableRetryWhen<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h<? super Observable<Throwable>, ? extends s<?>> f16983b;

    static final class RepeatWhenObserver<T> extends AtomicInteger implements io.reactivex.disposables.b, t<T> {
        private static final long serialVersionUID = 802743776666017014L;
        volatile boolean active;
        final t<? super T> downstream;
        final AtomicThrowable error;
        final RepeatWhenObserver<T>.InnerRepeatObserver inner;
        final io.reactivex.subjects.b<Throwable> signaller;
        final s<T> source;
        final AtomicReference<io.reactivex.disposables.b> upstream;
        final AtomicInteger wip;

        final class InnerRepeatObserver extends AtomicReference<io.reactivex.disposables.b> implements t<Object> {
            private static final long serialVersionUID = 3254781284376480842L;
            final /* synthetic */ RepeatWhenObserver this$0;

            InnerRepeatObserver(RepeatWhenObserver r1) {
                this.this$0 = r1;
            }

            @Override // io.reactivex.t
            public void onComplete() {
                this.this$0.innerComplete();
            }

            @Override // io.reactivex.t
            public void onError(Throwable r1) {
                this.this$0.innerError(r1);
            }

            @Override // io.reactivex.t
            public void onNext(Object r1) {
                this.this$0.innerNext();
            }

            @Override // io.reactivex.t
            public void onSubscribe(io.reactivex.disposables.b r3) {
                DisposableHelper.setOnce(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
            }
        }

        RepeatWhenObserver(t<? super T> r3, io.reactivex.subjects.b<Throwable> r4, s<T> r5) {
            t<? super T> r6 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            s<T> r7 = (s) ZeusTransformUtils.wrapperContextForParams(r5, s.class, "com.obric.memorydata.plugin");
            this.downstream = r6;
            this.signaller = r4;
            this.source = r7;
            this.wip = new AtomicInteger();
            this.error = new AtomicThrowable();
            this.inner = new InnerRepeatObserver(this);
            this.upstream = new AtomicReference();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this.inner);
        }

        void innerComplete() {
            DisposableHelper.dispose(this.upstream);
            e.a(this.downstream, this, this.error);
        }

        void innerError(Throwable r3) {
            DisposableHelper.dispose(this.upstream);
            e.a(this.downstream, r3, this, this.error);
        }

        void innerNext() {
            subscribeNext();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(this.upstream.get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.t
        public void onComplete() {
            DisposableHelper.dispose(this.inner);
            e.a(this.downstream, this, this.error);
        }

        @Override // io.reactivex.t
        public void onError(Throwable r3) {
            DisposableHelper.replace(this.upstream, null);
            this.active = false;
            this.signaller.onNext(r3);
        }

        @Override // io.reactivex.t
        public void onNext(T r3) {
            e.a(this.downstream, r3, this, this.error);
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            DisposableHelper.replace(this.upstream, r4);
        }

        void subscribeNext() {
            if (this.wip.getAndIncrement() == 0) goto L5;
            return;
        L5:
            if (isDisposed() == true) goto L6;
            if (this.active == true) goto L11;
            this.active = true;
            this.source.subscribe(this);
        L11:
            if (this.wip.decrementAndGet() != 0) goto L5;
            return;
        }
    }

    @Override // io.reactivex.Observable
    public void a(t<? super T> r5) {
        t r6 = (t) ZeusTransformUtils.wrapperContextForParams(r5, t.class, "com.obric.memorydata.plugin");
        io.reactivex.subjects.b<T> r0 = PublishSubject.b().c();
        s r1 = (s) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.f16983b.apply(r0), "The handler returned a null ObservableSource"), s.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        RepeatWhenObserver r2 = new RepeatWhenObserver(r6, r0, this.f17034a);
        r6.onSubscribe(r2);
        r1.subscribe(r2.inner);
        r2.subscribeNext();
        return;
    L6:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        EmptyDisposable.error(th, r6);
    }
}
