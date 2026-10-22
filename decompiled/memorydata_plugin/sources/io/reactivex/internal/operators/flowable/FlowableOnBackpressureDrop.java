package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.g;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableOnBackpressureDrop<T> extends a<T, T> implements g<T> {
    final g<? super T> c;

    static final class BackpressureDropSubscriber<T> extends AtomicLong implements j<T>, org.a.d {
        private static final long serialVersionUID = -6246093802440953054L;
        boolean done;
        final org.a.c<? super T> downstream;
        final g<? super T> onDrop;
        org.a.d upstream;

        BackpressureDropSubscriber(org.a.c<? super T> r3, g<? super T> r4) {
            org.a.c<? super T> r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            g<? super T> r6 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.memorydata.plugin");
            this.downstream = r5;
            this.onDrop = r6;
        }

        @Override // org.a.d
        public void cancel() {
            this.upstream.cancel();
        }

        @Override // org.a.c
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            this.downstream.onComplete();
        }

        @Override // org.a.c
        public void onError(Throwable r2) {
            if (this.done == false) goto L6;
            io.reactivex.d.a.a(r2);
            return;
        L6:
            this.done = true;
            this.downstream.onError(r2);
        }

        @Override // org.a.c
        public void onNext(T r5) {
            if (this.done == false) goto L6;
            return;
        L6:
            if (get() == 0) goto L13;
            this.downstream.onNext(r5);
            io.reactivex.internal.util.b.c(this, 1);
            return;
        L13:
            this.onDrop.accept(r5);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            cancel();
            onError(th);
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
    public void a(org.a.c<? super T> r3) {
        org.a.c r4 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
        this.f16812b.a(new BackpressureDropSubscriber(r4, this.c));
    }

    @Override // io.reactivex.b.g
    public void accept(T r1) {
    }
}
