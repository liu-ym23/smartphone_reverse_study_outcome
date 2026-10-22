package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableMergeWithCompletable<T> extends a<T, T> {
    final e c;

    static final class MergeWithSubscriber<T> extends AtomicInteger implements j<T>, org.a.d {
        private static final long serialVersionUID = -4592979584110982903L;
        final org.a.c<? super T> downstream;
        final AtomicThrowable error;
        volatile boolean mainDone;
        final AtomicReference<org.a.d> mainSubscription;
        volatile boolean otherDone;
        final OtherObserver otherObserver;
        final AtomicLong requested;

        static final class OtherObserver extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.c {
            private static final long serialVersionUID = -2935427570954647017L;
            final MergeWithSubscriber<?> parent;

            OtherObserver(MergeWithSubscriber<?> r1) {
                this.parent = r1;
            }

            @Override // io.reactivex.c
            public void onComplete() {
                this.parent.otherComplete();
            }

            @Override // io.reactivex.c
            public void onError(Throwable r1) {
                this.parent.otherError(r1);
            }

            @Override // io.reactivex.c
            public void onSubscribe(io.reactivex.disposables.b r3) {
                DisposableHelper.setOnce(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
            }
        }

        MergeWithSubscriber(org.a.c<? super T> r3) {
            this.downstream = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            this.mainSubscription = new AtomicReference();
            this.otherObserver = new OtherObserver(this);
            this.error = new AtomicThrowable();
            this.requested = new AtomicLong();
        }

        @Override // org.a.d
        public void cancel() {
            SubscriptionHelper.cancel(this.mainSubscription);
            DisposableHelper.dispose(this.otherObserver);
        }

        @Override // org.a.c
        public void onComplete() {
            this.mainDone = true;
            if (this.otherDone == false) goto L6;
            io.reactivex.internal.util.e.a(this.downstream, this, this.error);
            return;
        }

        @Override // org.a.c
        public void onError(Throwable r3) {
            DisposableHelper.dispose(this.otherObserver);
            io.reactivex.internal.util.e.a(this.downstream, r3, this, this.error);
        }

        @Override // org.a.c
        public void onNext(T r3) {
            io.reactivex.internal.util.e.a(this.downstream, r3, this, this.error);
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r3) {
            org.a.d r4 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin");
            SubscriptionHelper.deferredSetOnce(this.mainSubscription, this.requested, r4);
        }

        void otherComplete() {
            this.otherDone = true;
            if (this.mainDone == false) goto L6;
            io.reactivex.internal.util.e.a(this.downstream, this, this.error);
            return;
        }

        void otherError(Throwable r3) {
            SubscriptionHelper.cancel(this.mainSubscription);
            io.reactivex.internal.util.e.a(this.downstream, r3, this, this.error);
        }

        @Override // org.a.d
        public void request(long r2) {
            SubscriptionHelper.deferredRequest(this.mainSubscription, this.requested, r2);
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> r3) {
        org.a.c r4 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
        MergeWithSubscriber r0 = new MergeWithSubscriber(r4);
        r4.onSubscribe(r0);
        this.f16812b.a(r0);
        this.c.a(r0.otherObserver);
    }
}
