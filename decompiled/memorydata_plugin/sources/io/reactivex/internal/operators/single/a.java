package io.reactivex.internal.operators.single;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.h;
import io.reactivex.disposables.b;
import io.reactivex.v;
import io.reactivex.x;
import io.reactivex.z;

/* JADX INFO: loaded from: classes6.dex */
public final class a<T, R> extends v<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final z<? extends T> f17101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h<? super T, ? extends R> f17102b;

    /* JADX INFO: renamed from: io.reactivex.internal.operators.single.a$a, reason: collision with other inner class name */
    static final class C0874a<T, R> implements x<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final x<? super R> f17103a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h<? super T, ? extends R> f17104b;

        C0874a(x<? super R> r3, h<? super T, ? extends R> r4) {
            x<? super R> r5 = (x) ZeusTransformUtils.wrapperContextForParams(r3, x.class, "com.obric.memorydata.plugin");
            h<? super T, ? extends R> r6 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            this.f17103a = r5;
            this.f17104b = r6;
        }

        @Override // io.reactivex.x
        public void onError(Throwable r1) {
            this.f17103a.onError(r1);
        }

        @Override // io.reactivex.x
        public void onSubscribe(b r3) {
            b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
            this.f17103a.onSubscribe(r4);
        }

        @Override // io.reactivex.x
        public void onSuccess(T r2) {
            Object r3 = io.reactivex.internal.functions.a.a(this.f17104b.apply(r2), "The mapper function returned a null value.");     // Catch: Throwable -> L5
            this.f17103a.onSuccess(r3);
            return;
        L5:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            onError(th);
        }
    }

    @Override // io.reactivex.v
    public void b(x<? super R> r3) {
        x r4 = (x) ZeusTransformUtils.wrapperContextForParams(r3, x.class, "com.obric.memorydata.plugin");
        this.f17101a.a(new C0874a(r4, this.f17102b));
    }
}
