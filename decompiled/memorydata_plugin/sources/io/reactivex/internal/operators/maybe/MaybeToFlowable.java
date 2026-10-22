package io.reactivex.internal.operators.maybe;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.m;
import io.reactivex.o;
import org.a.c;

/* JADX INFO: loaded from: classes6.dex */
public final class MaybeToFlowable<T> extends g<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final o<T> f16874b;

    static final class MaybeToFlowableSubscriber<T> extends DeferredScalarSubscription<T> implements m<T> {
        private static final long serialVersionUID = 7603343402964826922L;
        io.reactivex.disposables.b upstream;

        MaybeToFlowableSubscriber(c<? super T> r3) {
            super((c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.a.d
        public void cancel() {
            super.cancel();
            this.upstream.dispose();
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
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (DisposableHelper.validate(this.upstream, r4) == false) goto L6;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.m
        public void onSuccess(T r1) {
            complete(r1);
        }
    }

    public MaybeToFlowable(o<T> r3) {
        this.f16874b = (o) ZeusTransformUtils.wrapperContextForParams(r3, o.class, "com.obric.memorydata.plugin");
    }

    @Override // io.reactivex.g
    public void a(c<? super T> r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        this.f16874b.a(new MaybeToFlowableSubscriber(r4));
    }
}
