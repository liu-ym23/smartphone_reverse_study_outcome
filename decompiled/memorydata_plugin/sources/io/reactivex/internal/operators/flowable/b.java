package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.h;
import io.reactivex.g;

/* JADX INFO: loaded from: classes6.dex */
public final class b<T, U> extends io.reactivex.internal.operators.flowable.a<T, U> {
    final h<? super T, ? extends U> c;

    static final class a<T, U> extends io.reactivex.internal.subscribers.a<T, U> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final h<? super T, ? extends U> f16813a;

        a(io.reactivex.internal.a.a<? super U> r3, h<? super T, ? extends U> r4) {
            io.reactivex.internal.a.a r5 = (io.reactivex.internal.a.a) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.internal.a.a.class, "com.obric.memorydata.plugin");
            h<? super T, ? extends U> r6 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            super(r5);
            this.f16813a = r6;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.a.c
        public void onNext(T r2) {
            if (this.e == false) goto L6;
            return;
        L6:
            if (this.f == 0) goto L15;
            Object r3 = null;
            org.a.c r1 = this.f17148b;
        L8:
            r1.onNext(r3);
            return;
        L15:
            r3 = io.reactivex.internal.functions.a.a(this.f16813a.apply(r2), "The mapper function returned a null value.");     // Catch: Throwable -> L12
            r1 = this.f17148b;
        L12:
            th = move-exception;
            a(th);
        }

        @Override // io.reactivex.internal.a.f
        public U poll() {
            T r0 = this.d.poll();
            if (r0 != null) goto L7;
            return null;
        L7:
            return (U) io.reactivex.internal.functions.a.a(this.f16813a.apply(r0), "The mapper function returned a null value.");
        }

        @Override // io.reactivex.internal.a.c
        public int requestFusion(int r1) {
            return a(r1);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.internal.a.a
        public boolean tryOnNext(T r2) {
            if (this.e == false) goto L12;
            return false;
        L12:
            Object r3 = io.reactivex.internal.functions.a.a(this.f16813a.apply(r2), "The mapper function returned a null value.");     // Catch: Throwable -> L9
            return this.f17148b.tryOnNext((Object) r3);
        L9:
            th = move-exception;
            a(th);
            return true;
        }
    }

    /* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.b$b, reason: collision with other inner class name */
    static final class C0873b<T, U> extends io.reactivex.internal.subscribers.b<T, U> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final h<? super T, ? extends U> f16814a;

        C0873b(org.a.c<? super U> r3, h<? super T, ? extends U> r4) {
            org.a.c r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            h<? super T, ? extends U> r6 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            super(r5);
            this.f16814a = r6;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v2, types: [org.a.c] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v5 */
        @Override // org.a.c
        public void onNext(T r2) {
            if (this.e == false) goto L6;
            return;
        L6:
            if (this.f == 0) goto L15;
            Object r3 = null;
            ?? r1 = this.f17149b;
        L8:
            r1.onNext(r3);
            return;
        L15:
            r3 = io.reactivex.internal.functions.a.a(this.f16814a.apply(r2), "The mapper function returned a null value.");     // Catch: Throwable -> L12
            r1 = this.f17149b;
        L12:
            th = move-exception;
            a(th);
        }

        @Override // io.reactivex.internal.a.f
        public U poll() {
            T r0 = this.d.poll();
            if (r0 != null) goto L7;
            return null;
        L7:
            return (U) io.reactivex.internal.functions.a.a(this.f16814a.apply(r0), "The mapper function returned a null value.");
        }

        @Override // io.reactivex.internal.a.c
        public int requestFusion(int r1) {
            return a(r1);
        }
    }

    public b(g<T> r3, h<? super T, ? extends U> r4) {
        h<? super T, ? extends U> r5 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
        super(r3);
        this.c = r5;
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super U> r5) {
        org.a.c r6 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r5, org.a.c.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, io.reactivex.internal.a.a.class) == false) goto L5;
        this.f16812b.a(new a((io.reactivex.internal.a.a) ZeusTransformUtils.preCheckCast(r6, io.reactivex.internal.a.a.class, "com.obric.memorydata.plugin"), this.c));
        return;
    L5:
        this.f16812b.a(new C0873b(r6, this.c));
    }
}
