package io.reactivex.internal.operators.single;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.h;
import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.k;
import io.reactivex.m;
import io.reactivex.o;
import io.reactivex.x;
import io.reactivex.z;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class SingleFlatMapMaybe<T, R> extends k<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final z<? extends T> f17075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h<? super T, ? extends o<? extends R>> f17076b;

    static final class FlatMapSingleObserver<T, R> extends AtomicReference<b> implements b, x<T> {
        private static final long serialVersionUID = -5843758257109742742L;
        final m<? super R> downstream;
        final h<? super T, ? extends o<? extends R>> mapper;

        FlatMapSingleObserver(m<? super R> r3, h<? super T, ? extends o<? extends R>> r4) {
            m<? super R> r5 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
            h<? super T, ? extends o<? extends R>> r6 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
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

        @Override // io.reactivex.x
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // io.reactivex.x
        public void onSubscribe(b r3) {
            if (DisposableHelper.setOnce(this, (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin")) == false) goto L6;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.x
        public void onSuccess(T r3) {
            o r4 = (o) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.mapper.apply(r3), "The mapper returned a null MaybeSource"), o.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            if (isDisposed() == true) goto L12;
            r4.a(new a(this, this.downstream));
            return;
        L12:
            return;
        L7:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            onError(th);
        }
    }

    static final class a<R> implements m<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AtomicReference<b> f17077a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final m<? super R> f17078b;

        a(AtomicReference<b> r3, m<? super R> r4) {
            m<? super R> r5 = (m) ZeusTransformUtils.wrapperContextForParams(r4, m.class, "com.obric.memorydata.plugin");
            this.f17077a = r3;
            this.f17078b = r5;
        }

        @Override // io.reactivex.m
        public void onComplete() {
            this.f17078b.onComplete();
        }

        @Override // io.reactivex.m
        public void onError(Throwable r1) {
            this.f17078b.onError(r1);
        }

        @Override // io.reactivex.m
        public void onSubscribe(b r3) {
            b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
            DisposableHelper.replace(this.f17077a, r4);
        }

        @Override // io.reactivex.m
        public void onSuccess(R r1) {
            this.f17078b.onSuccess(r1);
        }
    }

    @Override // io.reactivex.k
    public void b(m<? super R> r3) {
        m r4 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
        this.f17075a.a(new FlatMapSingleObserver(r4, this.f17076b));
    }
}
