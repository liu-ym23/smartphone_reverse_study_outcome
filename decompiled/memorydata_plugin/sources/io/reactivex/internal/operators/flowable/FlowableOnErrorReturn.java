package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.h;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableOnErrorReturn<T> extends a<T, T> {
    final h<? super Throwable, ? extends T> c;

    static final class OnErrorReturnSubscriber<T> extends SinglePostCompleteSubscriber<T, T> {
        private static final long serialVersionUID = -3740826063558713822L;
        final h<? super Throwable, ? extends T> valueSupplier;

        OnErrorReturnSubscriber(org.a.c<? super T> r3, h<? super Throwable, ? extends T> r4) {
            org.a.c r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            h<? super Throwable, ? extends T> r6 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            super(r5);
            this.valueSupplier = r6;
        }

        @Override // org.a.c
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // org.a.c
        public void onError(Throwable r5) {
            complete(io.reactivex.internal.functions.a.a(this.valueSupplier.apply(r5), "The valueSupplier returned a null value"));
            return;
        L5:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.downstream.onError(new CompositeException(new Throwable[]{r5, th}));
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // org.a.c
        public void onNext(T r5) {
            this.produced++;
            this.downstream.onNext((Object) r5);
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> r3) {
        org.a.c r4 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
        this.f16812b.a(new OnErrorReturnSubscriber(r4, this.c));
    }
}
