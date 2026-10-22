package io.reactivex.internal.operators.mixed;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.Observable;
import io.reactivex.b.h;
import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.s;
import io.reactivex.t;
import io.reactivex.x;
import io.reactivex.z;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class SingleFlatMapObservable<T, R> extends Observable<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final z<T> f16916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h<? super T, ? extends s<? extends R>> f16917b;

    static final class FlatMapObserver<T, R> extends AtomicReference<b> implements b, t<R>, x<T> {
        private static final long serialVersionUID = -8948264376121066672L;
        final t<? super R> downstream;
        final h<? super T, ? extends s<? extends R>> mapper;

        FlatMapObserver(t<? super R> r3, h<? super T, ? extends s<? extends R>> r4) {
            t<? super R> r5 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            h<? super T, ? extends s<? extends R>> r6 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            this.downstream = r5;
            this.mapper = r6;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((b) ZeusTransformUtils.preCheckCast(get(), b.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.t
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.t
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // io.reactivex.t
        public void onNext(R r1) {
            this.downstream.onNext(r1);
        }

        @Override // io.reactivex.t
        public void onSubscribe(b r3) {
            DisposableHelper.replace(this, (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.x
        public void onSuccess(T r3) {
            ((s) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.mapper.apply(r3), "The mapper returned a null Publisher"), s.class, "com.obric.memorydata.plugin")).subscribe(this);
            return;
        L5:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.downstream.onError(th);
        }
    }

    @Override // io.reactivex.Observable
    public void a(t<? super R> r3) {
        t r4 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
        FlatMapObserver r0 = new FlatMapObserver(r4, this.f16917b);
        r4.onSubscribe(r0);
        this.f16916a.a(r0);
    }
}
