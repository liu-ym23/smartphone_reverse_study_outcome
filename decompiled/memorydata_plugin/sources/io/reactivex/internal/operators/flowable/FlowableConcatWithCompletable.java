package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableConcatWithCompletable<T> extends a<T, T> {
    final e c;

    static final class ConcatWithSubscriber<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.c, j<T>, org.a.d {
        private static final long serialVersionUID = -7346385463600070225L;
        final org.a.c<? super T> downstream;
        boolean inCompletable;
        e other;
        org.a.d upstream;

        ConcatWithSubscriber(org.a.c<? super T> r3, e r4) {
            org.a.c<? super T> r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            e r6 = (e) ZeusTransformUtils.wrapperContextForParams(r4, e.class, "com.obric.memorydata.plugin");
            this.downstream = r5;
            this.other = r6;
        }

        @Override // org.a.d
        public void cancel() {
            this.upstream.cancel();
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.c
        public void onComplete() {
            if (this.inCompletable == false) goto L5;
            this.downstream.onComplete();
            return;
        L5:
            this.inCompletable = true;
            this.upstream = SubscriptionHelper.CANCELLED;
            e r0 = this.other;
            this.other = null;
            r0.a(this);
        }

        @Override // io.reactivex.c
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // org.a.c
        public void onNext(T r1) {
            this.downstream.onNext(r1);
        }

        @Override // io.reactivex.c
        public void onSubscribe(io.reactivex.disposables.b r3) {
            DisposableHelper.setOnce(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r3) {
            org.a.d r4 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin");
            if (SubscriptionHelper.validate(this.upstream, r4) == false) goto L6;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // org.a.d
        public void request(long r1) {
            this.upstream.request(r1);
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> r3) {
        org.a.c r4 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
        this.f16812b.a(new ConcatWithSubscriber(r4, this.c));
    }
}
