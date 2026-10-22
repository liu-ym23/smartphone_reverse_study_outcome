package io.reactivex.internal.operators.single;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.c;
import io.reactivex.disposables.b;
import io.reactivex.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.v;
import io.reactivex.x;
import io.reactivex.z;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class SingleDelayWithCompletable<T> extends v<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final z<T> f17054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final e f17055b;

    static final class OtherObserver<T> extends AtomicReference<b> implements c, b {
        private static final long serialVersionUID = -8565274649390031272L;
        final x<? super T> downstream;
        final z<T> source;

        OtherObserver(x<? super T> r3, z<T> r4) {
            x<? super T> r5 = (x) ZeusTransformUtils.wrapperContextForParams(r3, x.class, "com.obric.memorydata.plugin");
            z<T> r6 = (z) ZeusTransformUtils.wrapperContextForParams(r4, z.class, "com.obric.memorydata.plugin");
            this.downstream = r5;
            this.source = r6;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((b) ZeusTransformUtils.preCheckCast(get(), b.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.c
        public void onComplete() {
            this.source.a(new io.reactivex.internal.observers.c(this, this.downstream));
        }

        @Override // io.reactivex.c
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // io.reactivex.c
        public void onSubscribe(b r3) {
            if (DisposableHelper.setOnce(this, (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin")) == false) goto L6;
            this.downstream.onSubscribe(this);
            return;
        }
    }

    @Override // io.reactivex.v
    public void b(x<? super T> r3) {
        x r4 = (x) ZeusTransformUtils.wrapperContextForParams(r3, x.class, "com.obric.memorydata.plugin");
        this.f17055b.a(new OtherObserver(r4, this.f17054a));
    }
}
