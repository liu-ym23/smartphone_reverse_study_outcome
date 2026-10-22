package io.reactivex.internal.operators.maybe;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.c;
import io.reactivex.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.k;
import io.reactivex.m;
import io.reactivex.o;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class MaybeDelayWithCompletable<T> extends k<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final o<T> f16828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final e f16829b;

    static final class OtherObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements c, io.reactivex.disposables.b {
        private static final long serialVersionUID = 703409937383992161L;
        final m<? super T> downstream;
        final o<T> source;

        OtherObserver(m<? super T> r3, o<T> r4) {
            m<? super T> r5 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
            o<T> r6 = (o) ZeusTransformUtils.wrapperContextForParams(r4, o.class, "com.obric.memorydata.plugin");
            this.downstream = r5;
            this.source = r6;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.c
        public void onComplete() {
            this.source.a(new a(this, this.downstream));
        }

        @Override // io.reactivex.c
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // io.reactivex.c
        public void onSubscribe(io.reactivex.disposables.b r3) {
            if (DisposableHelper.setOnce(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin")) == false) goto L6;
            this.downstream.onSubscribe(this);
            return;
        }
    }

    static final class a<T> implements m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AtomicReference<io.reactivex.disposables.b> f16830a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final m<? super T> f16831b;

        a(AtomicReference<io.reactivex.disposables.b> r3, m<? super T> r4) {
            m<? super T> r5 = (m) ZeusTransformUtils.wrapperContextForParams(r4, m.class, "com.obric.memorydata.plugin");
            this.f16830a = r3;
            this.f16831b = r5;
        }

        @Override // io.reactivex.m
        public void onComplete() {
            this.f16831b.onComplete();
        }

        @Override // io.reactivex.m
        public void onError(Throwable r1) {
            this.f16831b.onError(r1);
        }

        @Override // io.reactivex.m
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            DisposableHelper.replace(this.f16830a, r4);
        }

        @Override // io.reactivex.m
        public void onSuccess(T r1) {
            this.f16831b.onSuccess(r1);
        }
    }

    @Override // io.reactivex.k
    public void b(m<? super T> r3) {
        m r4 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
        this.f16829b.a(new OtherObserver(r4, this.f16828a));
    }
}
