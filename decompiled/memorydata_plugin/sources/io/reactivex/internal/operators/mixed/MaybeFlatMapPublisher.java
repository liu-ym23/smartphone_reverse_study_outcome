package io.reactivex.internal.operators.mixed;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.h;
import io.reactivex.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import io.reactivex.m;
import io.reactivex.o;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.b;
import org.a.c;
import org.a.d;

/* JADX INFO: loaded from: classes6.dex */
public final class MaybeFlatMapPublisher<T, R> extends g<R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final o<T> f16901b;
    final h<? super T, ? extends b<? extends R>> c;

    static final class FlatMapPublisherSubscriber<T, R> extends AtomicReference<d> implements j<R>, m<T>, d {
        private static final long serialVersionUID = -8948264376121066672L;
        final c<? super R> downstream;
        final h<? super T, ? extends b<? extends R>> mapper;
        final AtomicLong requested;
        io.reactivex.disposables.b upstream;

        FlatMapPublisherSubscriber(c<? super R> r3, h<? super T, ? extends b<? extends R>> r4) {
            c<? super R> r5 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
            h<? super T, ? extends b<? extends R>> r6 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            this.downstream = r5;
            this.mapper = r6;
            this.requested = new AtomicLong();
        }

        @Override // org.a.d
        public void cancel() {
            this.upstream.dispose();
            SubscriptionHelper.cancel(this);
        }

        @Override // org.a.c
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // org.a.c
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // org.a.c
        public void onNext(R r1) {
            this.downstream.onNext(r1);
        }

        @Override // io.reactivex.m
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

        @Override // io.reactivex.m
        public void onSuccess(T r3) {
            ((b) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.mapper.apply(r3), "The mapper returned a null Publisher"), b.class, "com.obric.memorydata.plugin")).subscribe(this);
            return;
        L5:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.downstream.onError(th);
        }

        @Override // org.a.d
        public void request(long r2) {
            SubscriptionHelper.deferredRequest(this, this.requested, r2);
        }
    }

    @Override // io.reactivex.g
    public void a(c<? super R> r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        this.f16901b.a(new FlatMapPublisherSubscriber(r4, this.c));
    }
}
