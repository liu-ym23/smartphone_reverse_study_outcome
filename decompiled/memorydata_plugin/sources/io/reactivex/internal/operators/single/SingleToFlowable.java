package io.reactivex.internal.operators.single;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.disposables.b;
import io.reactivex.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.x;
import io.reactivex.z;
import org.a.c;

/* JADX INFO: loaded from: classes6.dex */
public final class SingleToFlowable<T> extends g<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final z<? extends T> f17092b;

    static final class SingleToFlowableObserver<T> extends DeferredScalarSubscription<T> implements x<T> {
        private static final long serialVersionUID = 187782011903685568L;
        b upstream;

        SingleToFlowableObserver(c<? super T> r3) {
            super((c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.a.d
        public void cancel() {
            super.cancel();
            this.upstream.dispose();
        }

        @Override // io.reactivex.x
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // io.reactivex.x
        public void onSubscribe(b r3) {
            b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
            if (DisposableHelper.validate(this.upstream, r4) == false) goto L6;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.x
        public void onSuccess(T r1) {
            complete(r1);
        }
    }

    public SingleToFlowable(z<? extends T> r3) {
        this.f17092b = (z) ZeusTransformUtils.wrapperContextForParams(r3, z.class, "com.obric.memorydata.plugin");
    }

    @Override // io.reactivex.g
    public void a(c<? super T> r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        this.f17092b.a(new SingleToFlowableObserver(r4));
    }
}
