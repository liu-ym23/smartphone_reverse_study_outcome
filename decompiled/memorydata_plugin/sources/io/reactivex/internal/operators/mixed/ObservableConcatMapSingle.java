package io.reactivex.internal.operators.mixed;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.Observable;
import io.reactivex.b.h;
import io.reactivex.disposables.b;
import io.reactivex.internal.a.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.t;
import io.reactivex.x;
import io.reactivex.z;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableConcatMapSingle<T, R> extends Observable<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Observable<T> f16906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h<? super T, ? extends z<? extends R>> f16907b;
    final ErrorMode c;
    final int d;

    static final class ConcatMapSingleMainObserver<T, R> extends AtomicInteger implements b, t<T> {
        static final int STATE_ACTIVE = 1;
        static final int STATE_INACTIVE = 0;
        static final int STATE_RESULT_VALUE = 2;
        private static final long serialVersionUID = -9140123220065488293L;
        volatile boolean cancelled;
        volatile boolean done;
        final t<? super R> downstream;
        final ErrorMode errorMode;
        final AtomicThrowable errors;
        final ConcatMapSingleObserver<R> inner;
        R item;
        final h<? super T, ? extends z<? extends R>> mapper;
        final e<T> queue;
        volatile int state;
        b upstream;

        static final class ConcatMapSingleObserver<R> extends AtomicReference<b> implements x<R> {
            private static final long serialVersionUID = -3051469169682093892L;
            final ConcatMapSingleMainObserver<?, R> parent;

            ConcatMapSingleObserver(ConcatMapSingleMainObserver<?, R> r1) {
                this.parent = r1;
            }

            void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.x
            public void onError(Throwable r1) {
                this.parent.innerError(r1);
            }

            @Override // io.reactivex.x
            public void onSubscribe(b r3) {
                DisposableHelper.replace(this, (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin"));
            }

            @Override // io.reactivex.x
            public void onSuccess(R r1) {
                this.parent.innerSuccess(r1);
            }
        }

        ConcatMapSingleMainObserver(t<? super R> r3, h<? super T, ? extends z<? extends R>> r4, int r5, ErrorMode r6) {
            t<? super R> r7 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            h<? super T, ? extends z<? extends R>> r8 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            this.downstream = r7;
            this.mapper = r8;
            this.errorMode = r6;
            this.errors = new AtomicThrowable();
            this.inner = new ConcatMapSingleObserver(this);
            this.queue = new io.reactivex.internal.queue.a(r5);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.inner.dispose();
            if (getAndIncrement() != 0) goto L6;
            this.queue.clear();
            this.item = null;
            return;
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            t<? super R> r0 = this.downstream;
            ErrorMode r1 = this.errorMode;
            e<T> r2 = this.queue;
            AtomicThrowable r3 = this.errors;
            int r5 = 1;
        L7:
            if (this.cancelled == true) goto L8;
            int r6 = this.state;
            if (r3.get() != null) goto L12;
        L19:
            boolean r8 = false;
            if (r6 == 0) goto L21;
            if (r6 != 2) goto L40;
            R r7 = this.item;
            this.item = null;
            r0.onNext(r7);
            this.state = 0;
        L40:
            r5 = addAndGet(-r5);
            if (r5 != 0) goto L7;
            return;
        L21:
            boolean r9 = this.done;
            T r10 = r2.poll();
            if (r10 != null) goto L24;
            r8 = true;
        L24:
            if (r9 == false) goto L31;
            if (r8 == false) goto L31;
            Throwable r11 = r3.terminate();
            if (r11 != null) goto L29;
            r0.onComplete();
            return;
        L29:
            r0.onError(r11);
            return;
        L31:
            if (r8 == true) goto L40;
            z r12 = (z) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.mapper.apply(r10), "The mapper returned a null SingleSource"), z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L35
            this.state = 1;
            r12.a(this.inner);
        L35:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.upstream.dispose();
            r2.clear();
            r3.addThrowable(th);
        L17:
            r0.onError(r3.terminate());
            return;
        L12:
            if (r1 == ErrorMode.IMMEDIATE) goto L16;
            if (r1 != ErrorMode.BOUNDARY) goto L19;
            if (r6 != 0) goto L19;
        L16:
            r2.clear();
            this.item = null;
            goto L17
        L8:
            r2.clear();
            this.item = null;
            goto L40
        }

        void innerError(Throwable r2) {
            if (this.errors.addThrowable(r2) == true) goto L5;
            io.reactivex.d.a.a(r2);
            return;
        L5:
            if (this.errorMode == ErrorMode.END) goto L7;
            this.upstream.dispose();
        L7:
            this.state = 0;
            drain();
        }

        void innerSuccess(R r1) {
            this.item = r1;
            this.state = 2;
            drain();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.t
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // io.reactivex.t
        public void onError(Throwable r2) {
            if (this.errors.addThrowable(r2) == true) goto L5;
            io.reactivex.d.a.a(r2);
            return;
        L5:
            if (this.errorMode != ErrorMode.IMMEDIATE) goto L7;
            this.inner.dispose();
        L7:
            this.done = true;
            drain();
        }

        @Override // io.reactivex.t
        public void onNext(T r2) {
            this.queue.offer(r2);
            drain();
        }

        @Override // io.reactivex.t
        public void onSubscribe(b r3) {
            b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
            if (DisposableHelper.validate(this.upstream, r4) == false) goto L6;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            return;
        }
    }

    @Override // io.reactivex.Observable
    public void a(t<? super R> r5) {
        t r6 = (t) ZeusTransformUtils.wrapperContextForParams(r5, t.class, "com.obric.memorydata.plugin");
        if (a.b(this.f16906a, this.f16907b, r6) == true) goto L6;
        this.f16906a.subscribe(new ConcatMapSingleMainObserver(r6, this.f16907b, this.d, this.c));
        return;
    }
}
