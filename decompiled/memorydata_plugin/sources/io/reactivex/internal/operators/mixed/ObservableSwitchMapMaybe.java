package io.reactivex.internal.operators.mixed;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.Observable;
import io.reactivex.b.h;
import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.m;
import io.reactivex.o;
import io.reactivex.t;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableSwitchMapMaybe<T, R> extends Observable<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Observable<T> f16912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h<? super T, ? extends o<? extends R>> f16913b;
    final boolean c;

    static final class SwitchMapMaybeMainObserver<T, R> extends AtomicInteger implements b, t<T> {
        static final SwitchMapMaybeObserver<Object> INNER_DISPOSED = null;
        private static final long serialVersionUID = -5402190102429853762L;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final t<? super R> downstream;
        final AtomicThrowable errors;
        final AtomicReference<SwitchMapMaybeObserver<R>> inner;
        final h<? super T, ? extends o<? extends R>> mapper;
        b upstream;

        static final class SwitchMapMaybeObserver<R> extends AtomicReference<b> implements m<R> {
            private static final long serialVersionUID = 8042919737683345351L;
            volatile R item;
            final SwitchMapMaybeMainObserver<?, R> parent;

            SwitchMapMaybeObserver(SwitchMapMaybeMainObserver<?, R> r1) {
                this.parent = r1;
            }

            void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.m
            public void onComplete() {
                this.parent.innerComplete(this);
            }

            @Override // io.reactivex.m
            public void onError(Throwable r2) {
                this.parent.innerError(this, r2);
            }

            @Override // io.reactivex.m
            public void onSubscribe(b r3) {
                DisposableHelper.setOnce(this, (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin"));
            }

            @Override // io.reactivex.m
            public void onSuccess(R r1) {
                this.item = r1;
                this.parent.drain();
            }
        }

        static {
            INNER_DISPOSED = new SwitchMapMaybeObserver(null);
        }

        SwitchMapMaybeMainObserver(t<? super R> r3, h<? super T, ? extends o<? extends R>> r4, boolean r5) {
            t<? super R> r6 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            h<? super T, ? extends o<? extends R>> r7 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            this.downstream = r6;
            this.mapper = r7;
            this.delayErrors = r5;
            this.errors = new AtomicThrowable();
            this.inner = new AtomicReference();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            disposeInner();
        }

        void disposeInner() {
            AtomicReference<SwitchMapMaybeObserver<R>> r3 = this.inner;
            SwitchMapMaybeObserver<Object> r0 = INNER_DISPOSED;
            SwitchMapMaybeObserver<Object> r4 = (SwitchMapMaybeObserver) ZeusTransformUtils.preCheckCast(r3.getAndSet((SwitchMapMaybeObserver<R>) r0), SwitchMapMaybeObserver.class, "com.obric.memorydata.plugin");
            if (r4 == null) goto L7;
            if (r4 == r0) goto L8;
            r4.dispose();
            return;
        L8:
            return;
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            t<? super R> r0 = this.downstream;
            AtomicThrowable r1 = this.errors;
            AtomicReference<SwitchMapMaybeObserver<R>> r2 = this.inner;
            int r4 = 1;
        L7:
            if (this.cancelled == true) goto L8;
            if (r1.get() != null) goto L12;
        L15:
            boolean r5 = this.done;
            SwitchMapMaybeObserver<R> r6 = (SwitchMapMaybeObserver) ZeusTransformUtils.preCheckCast(r2.get(), SwitchMapMaybeObserver.class, "com.obric.memorydata.plugin");
            if (r6 != null) goto L18;
            boolean r7 = true;
        L19:
            if (r5 == false) goto L26;
            if (r7 == false) goto L26;
            Throwable r9 = r1.terminate();
            if (r9 == null) goto L24;
            r0.onError(r9);
            return;
        L24:
            r0.onComplete();
            return;
        L26:
            if (r7 == true) goto L31;
            if (r6.item == null) goto L31;
            r2.compareAndSet(r6, null);
            r0.onNext(r6.item);
        L31:
            r4 = addAndGet(-r4);
            if (r4 != 0) goto L7;
            return;
        L18:
            r7 = false;
            goto L19
        L12:
            if (this.delayErrors == true) goto L15;
            r0.onError(r1.terminate());
            return;
        }

        void innerComplete(SwitchMapMaybeObserver<R> r3) {
            if (this.inner.compareAndSet(r3, null) == false) goto L6;
            drain();
            return;
        }

        void innerError(SwitchMapMaybeObserver<R> r3, Throwable r4) {
            if (this.inner.compareAndSet(r3, null) == true) goto L5;
        L11:
            io.reactivex.d.a.a(r4);
            return;
        L5:
            if (this.errors.addThrowable(r4) == false) goto L11;
            if (this.delayErrors == true) goto L9;
            this.upstream.dispose();
            disposeInner();
        L9:
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
            if (this.delayErrors == true) goto L7;
            disposeInner();
        L7:
            this.done = true;
            drain();
        }

        @Override // io.reactivex.t
        public void onNext(T r5) {
            SwitchMapMaybeObserver r0 = (SwitchMapMaybeObserver) ZeusTransformUtils.preCheckCast(this.inner.get(), SwitchMapMaybeObserver.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L17;
            r0.dispose();
        L17:
            o r6 = (o) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.mapper.apply(r5), "The mapper returned a null MaybeSource"), o.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
            SwitchMapMaybeObserver<R> r1 = new SwitchMapMaybeObserver(this);
        L7:
            SwitchMapMaybeObserver<R> r2 = (SwitchMapMaybeObserver) ZeusTransformUtils.preCheckCast(this.inner.get(), SwitchMapMaybeObserver.class, "com.obric.memorydata.plugin");
            if (r2 == INNER_DISPOSED) goto L22;
            if (this.inner.compareAndSet(r2, r1) == false) goto L7;
            r6.a(r1);
            return;
        L22:
            return;
        L14:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.upstream.dispose();
            this.inner.getAndSet((SwitchMapMaybeObserver<R>) INNER_DISPOSED);
            onError(th);
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
    public void a(t<? super R> r4) {
        t r5 = (t) ZeusTransformUtils.wrapperContextForParams(r4, t.class, "com.obric.memorydata.plugin");
        if (a.a(this.f16912a, this.f16913b, r5) == true) goto L6;
        this.f16912a.subscribe(new SwitchMapMaybeMainObserver(r5, this.f16913b, this.c));
        return;
    }
}
