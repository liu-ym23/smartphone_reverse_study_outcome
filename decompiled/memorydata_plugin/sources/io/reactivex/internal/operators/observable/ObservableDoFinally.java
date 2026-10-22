package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.t;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableDoFinally<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.b.a f16942b;

    static final class DoFinallyObserver<T> extends BasicIntQueueDisposable<T> implements t<T> {
        private static final long serialVersionUID = 4109457741734051389L;
        final t<? super T> downstream;
        final io.reactivex.b.a onFinally;
        io.reactivex.internal.a.b<T> qd;
        boolean syncFused;
        io.reactivex.disposables.b upstream;

        DoFinallyObserver(t<? super T> r3, io.reactivex.b.a r4) {
            t<? super T> r5 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            io.reactivex.b.a r6 = (io.reactivex.b.a) ZeusTransformUtils.wrapperContextForParams(r4, io.reactivex.b.a.class, "com.obric.memorydata.plugin");
            this.downstream = r5;
            this.onFinally = r6;
        }

        @Override // io.reactivex.internal.a.f
        public void clear() {
            this.qd.clear();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.upstream.dispose();
            runFinally();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.internal.a.f
        public boolean isEmpty() {
            return this.qd.isEmpty();
        }

        @Override // io.reactivex.t
        public void onComplete() {
            this.downstream.onComplete();
            runFinally();
        }

        @Override // io.reactivex.t
        public void onError(Throwable r2) {
            this.downstream.onError(r2);
            runFinally();
        }

        @Override // io.reactivex.t
        public void onNext(T r1) {
            this.downstream.onNext(r1);
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (DisposableHelper.validate(this.upstream, r4) == false) goto L9;
            this.upstream = r4;
            if (ZeusTransformUtils.instanceOf(r4, io.reactivex.internal.a.b.class) == false) goto L7;
            this.qd = (io.reactivex.internal.a.b) ZeusTransformUtils.preCheckCast(r4, io.reactivex.internal.a.b.class, "com.obric.memorydata.plugin");
        L7:
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.internal.a.f
        public T poll() {
            T r0 = this.qd.poll();
            if (r0 == null) goto L5;
        L7:
            return r0;
        L5:
            if (this.syncFused == false) goto L7;
            runFinally();
            goto L7
        }

        @Override // io.reactivex.internal.a.c
        public int requestFusion(int r4) {
            io.reactivex.internal.a.b<T> r0 = this.qd;
            boolean r1 = false;
            if (r0 != null) goto L5;
        L13:
            return 0;
        L5:
            if ((r4 & 4) != 0) goto L13;
            int r5 = r0.requestFusion(r4);
            if (r5 != 0) goto L9;
        L12:
            return r5;
        L9:
            if (r5 != 1) goto L11;
            r1 = true;
        L11:
            this.syncFused = r1;
            goto L12
        }

        void runFinally() {
            if (compareAndSet(0, 1) == false) goto L11;
            this.onFinally.a();     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            io.reactivex.d.a.a(th);
            return;
        }
    }

    @Override // io.reactivex.Observable
    public void a(t<? super T> r3) {
        t r4 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
        this.f17034a.subscribe(new DoFinallyObserver(r4, this.f16942b));
    }
}
