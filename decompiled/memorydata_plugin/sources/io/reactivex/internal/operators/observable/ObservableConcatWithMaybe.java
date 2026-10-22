package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.m;
import io.reactivex.o;
import io.reactivex.t;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableConcatWithMaybe<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final o<? extends T> f16936b;

    static final class ConcatWithObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, m<T>, t<T> {
        private static final long serialVersionUID = -1953724749712440952L;
        final t<? super T> downstream;
        boolean inMaybe;
        o<? extends T> other;

        ConcatWithObserver(t<? super T> r3, o<? extends T> r4) {
            t<? super T> r5 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            o<? extends T> r6 = (o) ZeusTransformUtils.wrapperContextForParams(r4, o.class, "com.obric.memorydata.plugin");
            this.downstream = r5;
            this.other = r6;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.m
        public void onComplete() {
            if (this.inMaybe == false) goto L5;
            this.downstream.onComplete();
            return;
        L5:
            this.inMaybe = true;
            DisposableHelper.replace(this, null);
            o<? extends T> r1 = this.other;
            this.other = null;
            r1.a(this);
        }

        @Override // io.reactivex.m
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // io.reactivex.t
        public void onNext(T r1) {
            this.downstream.onNext(r1);
        }

        @Override // io.reactivex.m
        public void onSubscribe(io.reactivex.disposables.b r3) {
            if (DisposableHelper.setOnce(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin")) == true) goto L5;
            return;
        L5:
            if (this.inMaybe == true) goto L9;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.m
        public void onSuccess(T r2) {
            this.downstream.onNext(r2);
            this.downstream.onComplete();
        }
    }

    @Override // io.reactivex.Observable
    public void a(t<? super T> r3) {
        t r4 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
        this.f17034a.subscribe(new ConcatWithObserver(r4, this.f16936b));
    }
}
