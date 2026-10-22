package io.reactivex.internal.operators.maybe;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.m;
import io.reactivex.o;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class MaybeFlatten<T, R> extends a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h<? super T, ? extends o<? extends R>> f16851b;

    static final class FlatMapMaybeObserver<T, R> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, m<T> {
        private static final long serialVersionUID = 4375739915521278546L;
        final m<? super R> downstream;
        final h<? super T, ? extends o<? extends R>> mapper;
        io.reactivex.disposables.b upstream;

        final class a implements m<R> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ FlatMapMaybeObserver f16852a;

            a(FlatMapMaybeObserver r1) {
                this.f16852a = r1;
            }

            @Override // io.reactivex.m
            public void onComplete() {
                this.f16852a.downstream.onComplete();
            }

            @Override // io.reactivex.m
            public void onError(Throwable r1) {
                this.f16852a.downstream.onError(r1);
            }

            @Override // io.reactivex.m
            public void onSubscribe(io.reactivex.disposables.b r3) {
                io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
                DisposableHelper.setOnce(this.f16852a, r4);
            }

            @Override // io.reactivex.m
            public void onSuccess(R r1) {
                this.f16852a.downstream.onSuccess(r1);
            }
        }

        FlatMapMaybeObserver(m<? super R> r3, h<? super T, ? extends o<? extends R>> r4) {
            m<? super R> r5 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
            h<? super T, ? extends o<? extends R>> r6 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            this.downstream = r5;
            this.mapper = r6;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
            this.upstream.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
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
        public void onSuccess(T r3) {
            o r4 = (o) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.mapper.apply(r3), "The mapper returned a null MaybeSource"), o.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L7
            if (isDisposed() == true) goto L12;
            r4.a(new a(this));
            return;
        L12:
            return;
        L7:
            e = move-exception;
            io.reactivex.exceptions.a.a(e);
            this.downstream.onError(e);
        }
    }

    @Override // io.reactivex.k
    public void b(m<? super R> r3) {
        m r4 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
        this.f16882a.a(new FlatMapMaybeObserver(r4, this.f16851b));
    }
}
