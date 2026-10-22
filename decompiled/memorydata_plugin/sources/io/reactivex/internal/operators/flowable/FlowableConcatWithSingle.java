package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.x;
import io.reactivex.z;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableConcatWithSingle<T> extends a<T, T> {
    final z<? extends T> c;

    static final class ConcatWithSubscriber<T> extends SinglePostCompleteSubscriber<T, T> implements x<T> {
        private static final long serialVersionUID = -7346385463600070225L;
        z<? extends T> other;
        final AtomicReference<io.reactivex.disposables.b> otherDisposable;

        ConcatWithSubscriber(org.a.c<? super T> r3, z<? extends T> r4) {
            org.a.c r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            z<? extends T> r6 = (z) ZeusTransformUtils.wrapperContextForParams(r4, z.class, "com.obric.memorydata.plugin");
            super(r5);
            this.other = r6;
            this.otherDisposable = new AtomicReference();
        }

        @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber, org.a.d
        public void cancel() {
            super.cancel();
            DisposableHelper.dispose(this.otherDisposable);
        }

        @Override // org.a.c
        public void onComplete() {
            this.upstream = SubscriptionHelper.CANCELLED;
            z<? extends T> r0 = this.other;
            this.other = null;
            r0.a(this);
        }

        @Override // org.a.c
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // org.a.c
        public void onNext(T r5) {
            this.produced++;
            this.downstream.onNext((Object) r5);
        }

        @Override // io.reactivex.x
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            DisposableHelper.setOnce(this.otherDisposable, r4);
        }

        @Override // io.reactivex.x
        public void onSuccess(T r1) {
            complete(r1);
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> r3) {
        org.a.c r4 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
        this.f16812b.a(new ConcatWithSubscriber(r4, this.c));
    }
}
