package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableUnsubscribeOn<T> extends a<T, T> {
    final u c;

    static final class UnsubscribeSubscriber<T> extends AtomicBoolean implements j<T>, org.a.d {
        private static final long serialVersionUID = 1015244841293359600L;
        final org.a.c<? super T> downstream;
        final u scheduler;
        org.a.d upstream;

        final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ UnsubscribeSubscriber f16802a;

            a(UnsubscribeSubscriber r1) {
                this.f16802a = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f16802a.upstream.cancel();
            }
        }

        UnsubscribeSubscriber(org.a.c<? super T> r3, u r4) {
            this.downstream = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            this.scheduler = r4;
        }

        @Override // org.a.d
        public void cancel() {
            if (compareAndSet(false, true) == false) goto L6;
            this.scheduler.a(new a(this));
            return;
        }

        @Override // org.a.c
        public void onComplete() {
            if (get() == true) goto L6;
            this.downstream.onComplete();
            return;
        }

        @Override // org.a.c
        public void onError(Throwable r2) {
            if (get() == false) goto L6;
            io.reactivex.d.a.a(r2);
            return;
        L6:
            this.downstream.onError(r2);
        }

        @Override // org.a.c
        public void onNext(T r2) {
            if (get() == true) goto L6;
            this.downstream.onNext(r2);
            return;
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
        this.f16812b.a(new UnsubscribeSubscriber(r4, this.c));
    }
}
