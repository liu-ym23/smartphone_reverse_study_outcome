package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.h;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableMapNotification<T, R> extends a<T, R> {
    final h<? super T, ? extends R> c;
    final h<? super Throwable, ? extends R> d;
    final Callable<? extends R> e;

    static final class MapNotificationSubscriber<T, R> extends SinglePostCompleteSubscriber<T, R> {
        private static final long serialVersionUID = 2757120512858778108L;
        final Callable<? extends R> onCompleteSupplier;
        final h<? super Throwable, ? extends R> onErrorMapper;
        final h<? super T, ? extends R> onNextMapper;

        MapNotificationSubscriber(org.a.c<? super R> r3, h<? super T, ? extends R> r4, h<? super Throwable, ? extends R> r5, Callable<? extends R> r6) {
            org.a.c r7 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            h<? super T, ? extends R> r8 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            h<? super Throwable, ? extends R> r9 = (h) ZeusTransformUtils.wrapperContextForParams(r5, h.class, "com.obric.memorydata.plugin");
            Callable<? extends R> r10 = (Callable) ZeusTransformUtils.wrapperContextForParams(r6, Callable.class, "com.obric.memorydata.plugin");
            super(r7);
            this.onNextMapper = r8;
            this.onErrorMapper = r9;
            this.onCompleteSupplier = r10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.a.c
        public void onComplete() {
            complete(io.reactivex.internal.functions.a.a(this.onCompleteSupplier.call(), "The onComplete publisher returned is null"));
            return;
        L5:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.downstream.onError(th);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.a.c
        public void onError(Throwable r5) {
            complete(io.reactivex.internal.functions.a.a(this.onErrorMapper.apply(r5), "The onError publisher returned is null"));
            return;
        L5:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.downstream.onError(new CompositeException(new Throwable[]{r5, th}));
        }

        @Override // org.a.c
        public void onNext(T r5) {
            Object r6 = io.reactivex.internal.functions.a.a(this.onNextMapper.apply(r5), "The onNext publisher returned is null");     // Catch: Throwable -> L5
            this.produced++;
            this.downstream.onNext(r6);
            return;
        L5:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.downstream.onError(th);
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super R> r5) {
        org.a.c r6 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r5, org.a.c.class, "com.obric.memorydata.plugin");
        this.f16812b.a(new MapNotificationSubscriber(r6, this.c, this.d, this.e));
    }
}
