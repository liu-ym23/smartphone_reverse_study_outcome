package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.h;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableDebounce<T, U> extends a<T, T> {
    final h<? super T, ? extends org.a.b<U>> c;

    static final class DebounceSubscriber<T, U> extends AtomicLong implements j<T>, org.a.d {
        private static final long serialVersionUID = 6725975399620862591L;
        final h<? super T, ? extends org.a.b<U>> debounceSelector;
        final AtomicReference<io.reactivex.disposables.b> debouncer;
        boolean done;
        final org.a.c<? super T> downstream;
        volatile long index;
        org.a.d upstream;

        static final class a<T, U> extends io.reactivex.subscribers.a<U> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final DebounceSubscriber<T, U> f16769a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final long f16770b;
            final T c;
            boolean d;
            final AtomicBoolean e;

            a(DebounceSubscriber<T, U> r2, long r3, T r5) {
                this.e = new AtomicBoolean();
                this.f16769a = r2;
                this.f16770b = r3;
                this.c = r5;
            }

            void a() {
                if (this.e.compareAndSet(false, true) == false) goto L6;
                this.f16769a.emit(this.f16770b, this.c);
                return;
            }

            @Override // org.a.c
            public void onComplete() {
                if (this.d == false) goto L5;
                return;
            L5:
                this.d = true;
                a();
            }

            @Override // org.a.c
            public void onError(Throwable r2) {
                if (this.d == false) goto L6;
                io.reactivex.d.a.a(r2);
                return;
            L6:
                this.d = true;
                this.f16769a.onError(r2);
            }

            @Override // org.a.c
            public void onNext(U r1) {
                if (this.d == false) goto L5;
                return;
            L5:
                this.d = true;
                c();
                a();
            }
        }

        DebounceSubscriber(org.a.c<? super T> r3, h<? super T, ? extends org.a.b<U>> r4) {
            org.a.c<? super T> r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            h<? super T, ? extends org.a.b<U>> r6 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            this.debouncer = new AtomicReference();
            this.downstream = r5;
            this.debounceSelector = r6;
        }

        @Override // org.a.d
        public void cancel() {
            this.upstream.cancel();
            DisposableHelper.dispose(this.debouncer);
        }

        void emit(long r3, T r5) {
            if (r3 == this.index) goto L5;
            return;
        L5:
            if (get() == 0) goto L7;
            this.downstream.onNext(r5);
            io.reactivex.internal.util.b.c(this, 1);
            return;
        L7:
            cancel();
            this.downstream.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
        }

        @Override // org.a.c
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            io.reactivex.disposables.b r0 = (io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(this.debouncer.get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (DisposableHelper.isDisposed(r0) == true) goto L12;
            a r1 = (a) ZeusTransformUtils.preCheckCast(r0, a.class, "com.obric.memorydata.plugin");
            if (r1 == null) goto L10;
            r1.a();
        L10:
            DisposableHelper.dispose(this.debouncer);
            this.downstream.onComplete();
            return;
        }

        @Override // org.a.c
        public void onError(Throwable r2) {
            DisposableHelper.dispose(this.debouncer);
            this.downstream.onError(r2);
        }

        @Override // org.a.c
        public void onNext(T r7) {
            if (this.done == false) goto L5;
            return;
        L5:
            long r0 = this.index + 1;
            this.index = r0;
            io.reactivex.disposables.b r2 = (io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(this.debouncer.get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L16;
            r2.dispose();
        L16:
            org.a.b r3 = (org.a.b) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.debounceSelector.apply(r7), "The publisher supplied is null"), org.a.b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
            a r4 = new a(this, r0, r7);
            if (this.debouncer.compareAndSet(r2, r4) == false) goto L18;
            r3.subscribe(r4);
            return;
        L18:
            return;
        L13:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            cancel();
            this.downstream.onError(th);
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r3) {
            org.a.d r4 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin");
            if (SubscriptionHelper.validate(this.upstream, r4) == false) goto L6;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            r4.request(Long.MAX_VALUE);
            return;
        }

        @Override // org.a.d
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            io.reactivex.internal.util.b.a(this, r2);
            return;
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> r4) {
        org.a.c r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r4, org.a.c.class, "com.obric.memorydata.plugin");
        this.f16812b.a(new DebounceSubscriber(new io.reactivex.subscribers.b(r5), this.c));
    }
}
