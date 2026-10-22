package io.reactivex.internal.operators.mixed;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.c;
import io.reactivex.e;
import io.reactivex.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.b;
import org.a.d;

/* JADX INFO: loaded from: classes6.dex */
public final class CompletableAndThenPublisher<R> extends g<R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final e f16888b;
    final b<? extends R> c;

    static final class AndThenPublisherSubscriber<R> extends AtomicReference<d> implements c, j<R>, d {
        private static final long serialVersionUID = -8948264376121066672L;
        final org.a.c<? super R> downstream;
        b<? extends R> other;
        final AtomicLong requested;
        io.reactivex.disposables.b upstream;

        AndThenPublisherSubscriber(org.a.c<? super R> r3, b<? extends R> r4) {
            org.a.c<? super R> r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            b<? extends R> r6 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.memorydata.plugin");
            this.downstream = r5;
            this.other = r6;
            this.requested = new AtomicLong();
        }

        @Override // org.a.d
        public void cancel() {
            this.upstream.dispose();
            SubscriptionHelper.cancel(this);
        }

        @Override // io.reactivex.c
        public void onComplete() {
            b<? extends R> r0 = this.other;
            if (r0 != null) goto L5;
            this.downstream.onComplete();
            return;
        L5:
            this.other = null;
            r0.subscribe(this);
        }

        @Override // io.reactivex.c
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // org.a.c
        public void onNext(R r1) {
            this.downstream.onNext(r1);
        }

        @Override // io.reactivex.c
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (DisposableHelper.validate(this.upstream, r4) == false) goto L6;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
            SubscriptionHelper.deferredSetOnce(this, this.requested, r4);
        }

        @Override // org.a.d
        public void request(long r2) {
            SubscriptionHelper.deferredRequest(this, this.requested, r2);
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super R> r3) {
        org.a.c r4 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
        this.f16888b.a(new AndThenPublisherSubscriber(r4, this.c));
    }
}
