package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.m;
import io.reactivex.o;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableConcatWithMaybe<T> extends a<T, T> {
    final o<? extends T> c;

    static final class ConcatWithSubscriber<T> extends SinglePostCompleteSubscriber<T, T> implements m<T> {
        private static final long serialVersionUID = -7346385463600070225L;
        boolean inMaybe;
        o<? extends T> other;
        final AtomicReference<io.reactivex.disposables.b> otherDisposable;

        ConcatWithSubscriber(org.a.c<? super T> r3, o<? extends T> r4) {
            org.a.c r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            o<? extends T> r6 = (o) ZeusTransformUtils.wrapperContextForParams(r4, o.class, "com.obric.memorydata.plugin");
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
            if (this.inMaybe == false) goto L5;
            this.downstream.onComplete();
            return;
        L5:
            this.inMaybe = true;
            this.upstream = SubscriptionHelper.CANCELLED;
            o<? extends T> r0 = this.other;
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

        @Override // io.reactivex.m
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            DisposableHelper.setOnce(this.otherDisposable, r4);
        }

        @Override // io.reactivex.m
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
