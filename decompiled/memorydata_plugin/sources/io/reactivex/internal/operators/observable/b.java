package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.h;
import io.reactivex.s;
import io.reactivex.t;

/* JADX INFO: loaded from: classes6.dex */
public final class b<T, U> extends io.reactivex.internal.operators.observable.a<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h<? super T, ? extends U> f17035b;

    static final class a<T, U> extends io.reactivex.internal.observers.a<T, U> {
        final h<? super T, ? extends U> f;

        a(t<? super U> r3, h<? super T, ? extends U> r4) {
            t r5 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            h<? super T, ? extends U> r6 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            super(r5);
            this.f = r6;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v2, types: [io.reactivex.t] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v5 */
        @Override // io.reactivex.t
        public void onNext(T r2) {
            if (this.d == false) goto L6;
            return;
        L6:
            if (this.e == 0) goto L15;
            Object r3 = null;
            ?? r1 = this.f16719a;
        L8:
            r1.onNext(r3);
            return;
        L15:
            r3 = io.reactivex.internal.functions.a.a(this.f.apply(r2), "The mapper function returned a null value.");     // Catch: Throwable -> L12
            r1 = this.f16719a;
        L12:
            th = move-exception;
            a(th);
        }

        @Override // io.reactivex.internal.a.f
        public U poll() {
            T r0 = this.c.poll();
            if (r0 != null) goto L7;
            return null;
        L7:
            return (U) io.reactivex.internal.functions.a.a(this.f.apply(r0), "The mapper function returned a null value.");
        }

        @Override // io.reactivex.internal.a.c
        public int requestFusion(int r1) {
            return a(r1);
        }
    }

    public b(s<T> r3, h<? super T, ? extends U> r4) {
        s r5 = (s) ZeusTransformUtils.wrapperContextForParams(r3, s.class, "com.obric.memorydata.plugin");
        h<? super T, ? extends U> r6 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
        super(r5);
        this.f17035b = r6;
    }

    @Override // io.reactivex.Observable
    public void a(t<? super U> r3) {
        t r4 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
        this.f17034a.subscribe(new a(r4, this.f17035b));
    }
}
