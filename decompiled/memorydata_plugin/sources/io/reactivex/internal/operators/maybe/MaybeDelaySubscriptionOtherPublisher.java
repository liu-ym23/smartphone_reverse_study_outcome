package io.reactivex.internal.operators.maybe;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import io.reactivex.m;
import io.reactivex.o;
import java.util.concurrent.atomic.AtomicReference;
import org.a.d;

/* JADX INFO: loaded from: classes6.dex */
public final class MaybeDelaySubscriptionOtherPublisher<T, U> extends io.reactivex.internal.operators.maybe.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final org.a.b<U> f16825b;

    static final class DelayMaybeObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements m<T> {
        private static final long serialVersionUID = 706635022205076709L;
        final m<? super T> downstream;

        DelayMaybeObserver(m<? super T> r3) {
            this.downstream = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
        }

        @Override // io.reactivex.m
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.m
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // io.reactivex.m
        public void onSubscribe(io.reactivex.disposables.b r3) {
            DisposableHelper.setOnce(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.m
        public void onSuccess(T r1) {
            this.downstream.onSuccess(r1);
        }
    }

    static final class a<T> implements io.reactivex.disposables.b, j<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final DelayMaybeObserver<T> f16826a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        o<T> f16827b;
        d c;

        a(m<? super T> r3, o<T> r4) {
            m r5 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
            o<T> r6 = (o) ZeusTransformUtils.wrapperContextForParams(r4, o.class, "com.obric.memorydata.plugin");
            this.f16826a = new DelayMaybeObserver(r5);
            this.f16827b = r6;
        }

        void a() {
            o<T> r0 = this.f16827b;
            this.f16827b = null;
            r0.a(this.f16826a);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.c.cancel();
            this.c = SubscriptionHelper.CANCELLED;
            DisposableHelper.dispose(this.f16826a);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(this.f16826a.get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }

        @Override // org.a.c
        public void onComplete() {
            if (this.c == SubscriptionHelper.CANCELLED) goto L6;
            this.c = SubscriptionHelper.CANCELLED;
            a();
            return;
        }

        @Override // org.a.c
        public void onError(Throwable r3) {
            if (this.c == SubscriptionHelper.CANCELLED) goto L5;
            this.c = SubscriptionHelper.CANCELLED;
            this.f16826a.downstream.onError(r3);
            return;
        L5:
            io.reactivex.d.a.a(r3);
        }

        @Override // org.a.c
        public void onNext(Object r2) {
            if (this.c == SubscriptionHelper.CANCELLED) goto L6;
            this.c.cancel();
            this.c = SubscriptionHelper.CANCELLED;
            a();
            return;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
            if (SubscriptionHelper.validate(this.c, r4) == false) goto L6;
            this.c = r4;
            this.f16826a.downstream.onSubscribe(this);
            r4.request(Long.MAX_VALUE);
            return;
        }
    }

    @Override // io.reactivex.k
    public void b(m<? super T> r3) {
        m r4 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
        this.f16825b.subscribe(new a(r4, this.f16882a));
    }
}
