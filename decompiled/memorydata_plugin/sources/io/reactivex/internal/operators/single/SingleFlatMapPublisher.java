package io.reactivex.internal.operators.single;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.h;
import io.reactivex.g;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import io.reactivex.x;
import io.reactivex.z;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.b;
import org.a.c;
import org.a.d;

/* JADX INFO: loaded from: classes6.dex */
public final class SingleFlatMapPublisher<T, R> extends g<R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final z<T> f17079b;
    final h<? super T, ? extends b<? extends R>> c;

    static final class SingleFlatMapPublisherObserver<S, T> extends AtomicLong implements j<T>, x<S>, d {
        private static final long serialVersionUID = 7759721921468635667L;
        io.reactivex.disposables.b disposable;
        final c<? super T> downstream;
        final h<? super S, ? extends b<? extends T>> mapper;
        final AtomicReference<d> parent;

        SingleFlatMapPublisherObserver(c<? super T> r3, h<? super S, ? extends b<? extends T>> r4) {
            c<? super T> r5 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
            h<? super S, ? extends b<? extends T>> r6 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            this.downstream = r5;
            this.mapper = r6;
            this.parent = new AtomicReference();
        }

        @Override // org.a.d
        public void cancel() {
            this.disposable.dispose();
            SubscriptionHelper.cancel(this.parent);
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
        public void onNext(T r1) {
            this.downstream.onNext(r1);
        }

        @Override // io.reactivex.x
        public void onSubscribe(io.reactivex.disposables.b r3) {
            this.disposable = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            this.downstream.onSubscribe(this);
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
            SubscriptionHelper.deferredSetOnce(this.parent, this, r4);
        }

        @Override // io.reactivex.x
        public void onSuccess(S r3) {
            ((b) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.mapper.apply(r3), "the mapper returned a null Publisher"), b.class, "com.obric.memorydata.plugin")).subscribe(this);
            return;
        L5:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.downstream.onError(th);
        }

        @Override // org.a.d
        public void request(long r2) {
            SubscriptionHelper.deferredRequest(this.parent, this, r2);
        }
    }

    @Override // io.reactivex.g
    public void a(c<? super R> r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        this.f17079b.a(new SingleFlatMapPublisherObserver(r4, this.c));
    }
}
