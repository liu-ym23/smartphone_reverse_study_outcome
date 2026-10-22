package io.reactivex.internal.operators.maybe;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import io.reactivex.m;
import java.util.concurrent.atomic.AtomicReference;
import org.a.d;

/* JADX INFO: loaded from: classes6.dex */
public final class MaybeDelayOtherPublisher<T, U> extends io.reactivex.internal.operators.maybe.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final org.a.b<U> f16822b;

    static final class OtherSubscriber<T> extends AtomicReference<d> implements j<Object> {
        private static final long serialVersionUID = -1215060610805418006L;
        final m<? super T> downstream;
        Throwable error;
        T value;

        OtherSubscriber(m<? super T> r3) {
            this.downstream = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
        }

        @Override // org.a.c
        public void onComplete() {
            Throwable r0 = this.error;
            if (r0 == null) goto L5;
            this.downstream.onError(r0);
            return;
        L5:
            T r1 = this.value;
            m<? super T> r2 = this.downstream;
            if (r1 == null) goto L8;
            r2.onSuccess(r1);
            return;
        L8:
            r2.onComplete();
        }

        @Override // org.a.c
        public void onError(Throwable r5) {
            Throwable r0 = this.error;
            m<? super T> r4 = this.downstream;
            if (r0 != null) goto L5;
            r4.onError(r5);
            return;
        L5:
            r4.onError(new CompositeException(new Throwable[]{r0, r5}));
        }

        @Override // org.a.c
        public void onNext(Object r3) {
            d r4 = (d) ZeusTransformUtils.preCheckCast(get(), d.class, "com.obric.memorydata.plugin");
            if (r4 == SubscriptionHelper.CANCELLED) goto L6;
            lazySet(SubscriptionHelper.CANCELLED);
            r4.cancel();
            onComplete();
            return;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d r3) {
            SubscriptionHelper.setOnce(this, (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin"), Long.MAX_VALUE);
        }
    }

    static final class a<T, U> implements io.reactivex.disposables.b, m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final OtherSubscriber<T> f16823a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final org.a.b<U> f16824b;
        io.reactivex.disposables.b c;

        a(m<? super T> r3, org.a.b<U> r4) {
            m r5 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
            org.a.b<U> r6 = (org.a.b) ZeusTransformUtils.wrapperContextForParams(r4, org.a.b.class, "com.obric.memorydata.plugin");
            this.f16823a = new OtherSubscriber(r5);
            this.f16824b = r6;
        }

        void a() {
            this.f16824b.subscribe(this.f16823a);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.c.dispose();
            this.c = DisposableHelper.DISPOSED;
            SubscriptionHelper.cancel(this.f16823a);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            if (this.f16823a.get() != SubscriptionHelper.CANCELLED) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // io.reactivex.m
        public void onComplete() {
            this.c = DisposableHelper.DISPOSED;
            a();
        }

        @Override // io.reactivex.m
        public void onError(Throwable r2) {
            this.c = DisposableHelper.DISPOSED;
            this.f16823a.error = r2;
            a();
        }

        @Override // io.reactivex.m
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (DisposableHelper.validate(this.c, r4) == false) goto L6;
            this.c = r4;
            this.f16823a.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.m
        public void onSuccess(T r2) {
            this.c = DisposableHelper.DISPOSED;
            this.f16823a.value = r2;
            a();
        }
    }

    @Override // io.reactivex.k
    public void b(m<? super T> r3) {
        m r4 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
        this.f16882a.a(new a(r4, this.f16822b));
    }
}
