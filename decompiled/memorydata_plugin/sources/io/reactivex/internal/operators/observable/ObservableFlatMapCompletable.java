package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.h;
import io.reactivex.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.t;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableFlatMapCompletable<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h<? super T, ? extends e> f16944b;
    final boolean c;

    static final class FlatMapCompletableMainObserver<T> extends BasicIntQueueDisposable<T> implements t<T> {
        private static final long serialVersionUID = 8443155186132538303L;
        final boolean delayErrors;
        volatile boolean disposed;
        final t<? super T> downstream;
        final AtomicThrowable errors;
        final h<? super T, ? extends e> mapper;
        final io.reactivex.disposables.a set;
        io.reactivex.disposables.b upstream;

        final class InnerObserver extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.c, io.reactivex.disposables.b {
            private static final long serialVersionUID = 8606673141535671828L;
            final /* synthetic */ FlatMapCompletableMainObserver this$0;

            InnerObserver(FlatMapCompletableMainObserver r1) {
                this.this$0 = r1;
            }

            @Override // io.reactivex.disposables.b
            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.disposables.b
            public boolean isDisposed() {
                return DisposableHelper.isDisposed((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
            }

            @Override // io.reactivex.c
            public void onComplete() {
                this.this$0.innerComplete(this);
            }

            @Override // io.reactivex.c
            public void onError(Throwable r2) {
                this.this$0.innerError(this, r2);
            }

            @Override // io.reactivex.c
            public void onSubscribe(io.reactivex.disposables.b r3) {
                DisposableHelper.setOnce(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
            }
        }

        FlatMapCompletableMainObserver(t<? super T> r3, h<? super T, ? extends e> r4, boolean r5) {
            t<? super T> r6 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            h<? super T, ? extends e> r7 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            this.downstream = r6;
            this.mapper = r7;
            this.delayErrors = r5;
            this.errors = new AtomicThrowable();
            this.set = new io.reactivex.disposables.a();
            lazySet(1);
        }

        @Override // io.reactivex.internal.a.f
        public void clear() {
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.disposed = true;
            this.upstream.dispose();
            this.set.dispose();
        }

        void innerComplete(FlatMapCompletableMainObserver<T>.InnerObserver r2) {
            this.set.delete(r2);
            onComplete();
        }

        void innerError(FlatMapCompletableMainObserver<T>.InnerObserver r2, Throwable r3) {
            this.set.delete(r2);
            onError(r3);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.internal.a.f
        public boolean isEmpty() {
            return true;
        }

        @Override // io.reactivex.t
        public void onComplete() {
            if (decrementAndGet() != 0) goto L9;
            Throwable r0 = this.errors.terminate();
            t<? super T> r1 = this.downstream;
            if (r0 == null) goto L7;
            r1.onError(r0);
            return;
        L7:
            r1.onComplete();
            return;
        }

        @Override // io.reactivex.t
        public void onError(Throwable r2) {
            if (this.errors.addThrowable(r2) == true) goto L5;
            io.reactivex.d.a.a(r2);
            return;
        L5:
            if (this.delayErrors == true) goto L7;
            dispose();
            if (getAndSet(0) <= 0) goto L15;
        L11:
            Throwable r3 = this.errors.terminate();
            this.downstream.onError(r3);
            return;
        L15:
            return;
        L7:
            if (decrementAndGet() == 0) goto L11;
        }

        @Override // io.reactivex.t
        public void onNext(T r3) {
            e r4 = (e) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.mapper.apply(r3), "The mapper returned a null CompletableSource"), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
            getAndIncrement();
            InnerObserver r0 = new InnerObserver(this);
            if (this.disposed == false) goto L6;
            return;
        L6:
            if (this.set.a(r0) == false) goto L15;
            r4.a(r0);
            return;
        L15:
            return;
        L9:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.upstream.dispose();
            onError(th);
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (DisposableHelper.validate(this.upstream, r4) == false) goto L6;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.internal.a.f
        public T poll() {
            return null;
        }

        @Override // io.reactivex.internal.a.c
        public int requestFusion(int r1) {
            return r1 & 2;
        }
    }

    @Override // io.reactivex.Observable
    public void a(t<? super T> r4) {
        t r5 = (t) ZeusTransformUtils.wrapperContextForParams(r4, t.class, "com.obric.memorydata.plugin");
        this.f17034a.subscribe(new FlatMapCompletableMainObserver(r5, this.f16944b, this.c));
    }
}
