package io.reactivex.internal.operators.single;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.c;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import io.reactivex.v;
import io.reactivex.x;
import io.reactivex.z;
import java.util.concurrent.atomic.AtomicReference;
import org.a.b;
import org.a.d;

/* JADX INFO: loaded from: classes6.dex */
public final class SingleDelayWithPublisher<T, U> extends v<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final z<T> f17058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final b<U> f17059b;

    static final class OtherSubscriber<T, U> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, j<U> {
        private static final long serialVersionUID = -8565274649390031272L;
        boolean done;
        final x<? super T> downstream;
        final z<T> source;
        d upstream;

        OtherSubscriber(x<? super T> r3, z<T> r4) {
            x<? super T> r5 = (x) ZeusTransformUtils.wrapperContextForParams(r3, x.class, "com.obric.memorydata.plugin");
            z<T> r6 = (z) ZeusTransformUtils.wrapperContextForParams(r4, z.class, "com.obric.memorydata.plugin");
            this.downstream = r5;
            this.source = r6;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.upstream.cancel();
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }

        @Override // org.a.c
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            this.source.a(new c(this, this.downstream));
        }

        @Override // org.a.c
        public void onError(Throwable r2) {
            if (this.done == false) goto L6;
            io.reactivex.d.a.a(r2);
            return;
        L6:
            this.done = true;
            this.downstream.onError(r2);
        }

        @Override // org.a.c
        public void onNext(U r1) {
            this.upstream.cancel();
            onComplete();
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
            if (SubscriptionHelper.validate(this.upstream, r4) == false) goto L6;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            r4.request(Long.MAX_VALUE);
            return;
        }
    }

    @Override // io.reactivex.v
    public void b(x<? super T> r3) {
        x r4 = (x) ZeusTransformUtils.wrapperContextForParams(r3, x.class, "com.obric.memorydata.plugin");
        this.f17059b.subscribe(new OtherSubscriber(r4, this.f17058a));
    }
}
