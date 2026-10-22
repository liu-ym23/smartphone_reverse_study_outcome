package io.reactivex.internal.operators.mixed;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.h;
import io.reactivex.disposables.b;
import io.reactivex.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.j;
import io.reactivex.x;
import io.reactivex.z;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.c;
import org.a.d;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableSwitchMapSingle<T, R> extends g<R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final g<T> f16898b;
    final h<? super T, ? extends z<? extends R>> c;
    final boolean d;

    static final class SwitchMapSingleSubscriber<T, R> extends AtomicInteger implements j<T>, d {
        static final SwitchMapSingleObserver<Object> INNER_DISPOSED = null;
        private static final long serialVersionUID = -5402190102429853762L;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final c<? super R> downstream;
        long emitted;
        final AtomicThrowable errors;
        final AtomicReference<SwitchMapSingleObserver<R>> inner;
        final h<? super T, ? extends z<? extends R>> mapper;
        final AtomicLong requested;
        d upstream;

        static final class SwitchMapSingleObserver<R> extends AtomicReference<b> implements x<R> {
            private static final long serialVersionUID = 8042919737683345351L;
            volatile R item;
            final SwitchMapSingleSubscriber<?, R> parent;

            SwitchMapSingleObserver(SwitchMapSingleSubscriber<?, R> r1) {
                this.parent = r1;
            }

            void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.x
            public void onError(Throwable r2) {
                this.parent.innerError(this, r2);
            }

            @Override // io.reactivex.x
            public void onSubscribe(b r3) {
                DisposableHelper.setOnce(this, (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin"));
            }

            @Override // io.reactivex.x
            public void onSuccess(R r1) {
                this.item = r1;
                this.parent.drain();
            }
        }

        static {
            INNER_DISPOSED = new SwitchMapSingleObserver(null);
        }

        SwitchMapSingleSubscriber(c<? super R> r3, h<? super T, ? extends z<? extends R>> r4, boolean r5) {
            c<? super R> r6 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
            h<? super T, ? extends z<? extends R>> r7 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            this.downstream = r6;
            this.mapper = r7;
            this.delayErrors = r5;
            this.errors = new AtomicThrowable();
            this.requested = new AtomicLong();
            this.inner = new AtomicReference();
        }

        @Override // org.a.d
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            disposeInner();
        }

        void disposeInner() {
            AtomicReference<SwitchMapSingleObserver<R>> r3 = this.inner;
            SwitchMapSingleObserver<Object> r0 = INNER_DISPOSED;
            SwitchMapSingleObserver<Object> r4 = (SwitchMapSingleObserver) ZeusTransformUtils.preCheckCast(r3.getAndSet((SwitchMapSingleObserver<R>) r0), SwitchMapSingleObserver.class, "com.obric.memorydata.plugin");
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
            c<? super R> r0 = this.downstream;
            AtomicThrowable r1 = this.errors;
            AtomicReference<SwitchMapSingleObserver<R>> r2 = this.inner;
            AtomicLong r3 = this.requested;
            long r4 = this.emitted;
            int r7 = 1;
        L7:
            if (this.cancelled == true) goto L8;
            if (r1.get() != null) goto L12;
        L15:
            boolean r8 = this.done;
            SwitchMapSingleObserver<R> r9 = (SwitchMapSingleObserver) ZeusTransformUtils.preCheckCast(r2.get(), SwitchMapSingleObserver.class, "com.obric.memorydata.plugin");
            if (r9 != null) goto L18;
            boolean r10 = true;
        L19:
            if (r8 == false) goto L26;
            if (r10 == false) goto L26;
            Throwable r12 = r1.terminate();
            if (r12 == null) goto L24;
            r0.onError(r12);
            return;
        L24:
            r0.onComplete();
            return;
        L26:
            if (r10 == true) goto L33;
            if (r9.item == null) goto L33;
            if (r4 == r3.get()) goto L33;
            r2.compareAndSet(r9, null);
            r0.onNext(r9.item);
            r4 = r4 + 1;
        L33:
            this.emitted = r4;
            r7 = addAndGet(-r7);
            if (r7 != 0) goto L7;
            return;
        L18:
            r10 = false;
            goto L19
        L12:
            if (this.delayErrors == true) goto L15;
            r0.onError(r1.terminate());
            return;
        }

        void innerError(SwitchMapSingleObserver<R> r3, Throwable r4) {
            if (this.inner.compareAndSet(r3, null) == true) goto L5;
        L11:
            io.reactivex.d.a.a(r4);
            return;
        L5:
            if (this.errors.addThrowable(r4) == false) goto L11;
            if (this.delayErrors == true) goto L9;
            this.upstream.cancel();
            disposeInner();
        L9:
            drain();
        }

        @Override // org.a.c
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // org.a.c
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

        @Override // org.a.c
        public void onNext(T r5) {
            SwitchMapSingleObserver r0 = (SwitchMapSingleObserver) ZeusTransformUtils.preCheckCast(this.inner.get(), SwitchMapSingleObserver.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L17;
            r0.dispose();
        L17:
            z r6 = (z) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.mapper.apply(r5), "The mapper returned a null SingleSource"), z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
            SwitchMapSingleObserver<R> r1 = new SwitchMapSingleObserver(this);
        L7:
            SwitchMapSingleObserver<R> r2 = (SwitchMapSingleObserver) ZeusTransformUtils.preCheckCast(this.inner.get(), SwitchMapSingleObserver.class, "com.obric.memorydata.plugin");
            if (r2 == INNER_DISPOSED) goto L22;
            if (this.inner.compareAndSet(r2, r1) == false) goto L7;
            r6.a(r1);
            return;
        L22:
            return;
        L14:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.upstream.cancel();
            this.inner.getAndSet((SwitchMapSingleObserver<R>) INNER_DISPOSED);
            onError(th);
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
            if (SubscriptionHelper.validate(this.upstream, r4) == false) goto L6;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            r4.request(Long.MAX_VALUE);
            return;
        }

        @Override // org.a.d
        public void request(long r2) {
            io.reactivex.internal.util.b.a(this.requested, r2);
            drain();
        }
    }

    @Override // io.reactivex.g
    public void a(c<? super R> r4) {
        c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.memorydata.plugin");
        this.f16898b.a(new SwitchMapSingleSubscriber(r5, this.c, this.d));
    }
}
