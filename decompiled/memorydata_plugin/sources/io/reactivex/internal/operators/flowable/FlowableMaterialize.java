package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.p;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableMaterialize<T> extends a<T, p<T>> {

    static final class MaterializeSubscriber<T> extends SinglePostCompleteSubscriber<T, p<T>> {
        private static final long serialVersionUID = -3740826063558713822L;

        MaterializeSubscriber(org.a.c<? super p<T>> r3) {
            super((org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin"));
        }

        @Override // org.a.c
        public void onComplete() {
            complete(p.c());
        }

        public void onDrop(p<T> r1) {
            if (r1.a() == false) goto L6;
            io.reactivex.d.a.a(r1.b());
            return;
        }

        @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber
        public /* synthetic */ void onDrop(Object r3) {
            onDrop((p) ZeusTransformUtils.preCheckCast(r3, p.class, "com.obric.memorydata.plugin"));
        }

        @Override // org.a.c
        public void onError(Throwable r1) {
            complete(p.a(r1));
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // org.a.c
        public void onNext(T r5) {
            this.produced++;
            this.downstream.onNext(p.a(r5));
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super p<T>> r3) {
        org.a.c r4 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
        this.f16812b.a(new MaterializeSubscriber(r4));
    }
}
