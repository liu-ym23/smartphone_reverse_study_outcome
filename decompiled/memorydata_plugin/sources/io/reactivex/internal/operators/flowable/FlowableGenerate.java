package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.f;
import io.reactivex.g;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableGenerate<T, S> extends g<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Callable<S> f16776b;
    final io.reactivex.b.c<S, f<T>, S> c;
    final io.reactivex.b.g<? super S> d;

    static final class GeneratorSubscription<T, S> extends AtomicLong implements f<T>, org.a.d {
        private static final long serialVersionUID = 7565982551505011832L;
        volatile boolean cancelled;
        final io.reactivex.b.g<? super S> disposeState;
        final org.a.c<? super T> downstream;
        final io.reactivex.b.c<S, ? super f<T>, S> generator;
        boolean hasNext;
        S state;
        boolean terminate;

        GeneratorSubscription(org.a.c<? super T> r3, io.reactivex.b.c<S, ? super f<T>, S> r4, io.reactivex.b.g<? super S> r5, S r6) {
            org.a.c<? super T> r7 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            io.reactivex.b.c<S, ? super f<T>, S> r8 = (io.reactivex.b.c) ZeusTransformUtils.wrapperContextForParams(r4, io.reactivex.b.c.class, "com.obric.memorydata.plugin");
            io.reactivex.b.g<? super S> r9 = (io.reactivex.b.g) ZeusTransformUtils.wrapperContextForParams(r5, io.reactivex.b.g.class, "com.obric.memorydata.plugin");
            this.downstream = r7;
            this.generator = r8;
            this.disposeState = r9;
            this.state = r6;
        }

        private void dispose(S r1) {
            this.disposeState.accept(r1);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            io.reactivex.d.a.a(th);
        }

        @Override // org.a.d
        public void cancel() {
            if (this.cancelled == true) goto L8;
            this.cancelled = true;
            if (io.reactivex.internal.util.b.a(this, 1) != 0) goto L9;
            S r0 = this.state;
            this.state = null;
            dispose(r0);
            return;
        L9:
            return;
        }

        @Override // io.reactivex.f
        public void onComplete() {
            if (this.terminate == true) goto L6;
            this.terminate = true;
            this.downstream.onComplete();
            return;
        }

        @Override // io.reactivex.f
        public void onError(Throwable r2) {
            if (this.terminate == false) goto L5;
            io.reactivex.d.a.a(r2);
            return;
        L5:
            if (r2 != null) goto L7;
            r2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        L7:
            this.terminate = true;
            this.downstream.onError(r2);
        }

        @Override // io.reactivex.f
        public void onNext(T r2) {
            if (this.terminate == false) goto L5;
            return;
        L5:
            if (this.hasNext == false) goto L8;
            Throwable r3 = new IllegalStateException("onNext already called in this generate turn");
        L7:
            onError(r3);
            return;
        L8:
            if (r2 != null) goto L10;
            r3 = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            goto L7
        L10:
            this.hasNext = true;
            this.downstream.onNext(r2);
        }

        @Override // org.a.d
        public void request(long r10) {
            if (SubscriptionHelper.validate(r10) == true) goto L6;
            return;
        L6:
            if (io.reactivex.internal.util.b.a(this, r10) == 0) goto L8;
            return;
        L8:
            S r0 = this.state;
            io.reactivex.b.c<S, ? super f<T>, S> r1 = this.generator;
        L9:
            long r4 = 0;
        L11:
            if (r4 != r10) goto L13;
            r10 = get();
            if (r4 != r10) goto L11;
            this.state = r0;
            r10 = addAndGet(-r4);
            if (r10 != 0) goto L9;
            return;
        L13:
            if (this.cancelled == true) goto L14;
            this.hasNext = false;
            r0 = r1.apply(r0, this);     // Catch: Throwable -> L23
            if (this.terminate == true) goto L21;
            r4 = r4 + 1;
            goto L11
        L21:
            this.cancelled = true;
        L23:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.cancelled = true;
            this.state = null;
            onError(th);
        L15:
            dispose(r0);
            return;
        L14:
            this.state = null;
            goto L15
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> r4) {
        org.a.c r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r4, org.a.c.class, "com.obric.memorydata.plugin");
        S r0 = this.f16776b.call();     // Catch: Throwable -> L6
        r5.onSubscribe(new GeneratorSubscription(r5, this.c, this.d, r0));
        return;
    L6:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        EmptySubscription.error(th, r5);
    }
}
