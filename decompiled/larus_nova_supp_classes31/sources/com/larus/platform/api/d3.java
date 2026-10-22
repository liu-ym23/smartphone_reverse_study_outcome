package com.larus.platform.api;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface d3 {
    public static final a a = null;

    public static final class a implements d3 {
        public static final /* synthetic */ a b = null;
        public static final Lazy<d3> c = null;

        public a() {
        }

        static {
            b = new a();
            c = LazyKt.lazy(new c3());
        }

        @Override // com.larus.platform.api.d3
        public final void d() {
            d3 r0 = (d3) c.getValue();
            if (r0 == null) goto L6;
            r0.d();
            return;
        }

        @Override // com.larus.platform.api.d3
        public final void e() {
            d3 r0 = (d3) c.getValue();
            if (r0 == null) goto L6;
            r0.e();
            return;
        }

        @Override // com.larus.platform.api.d3
        public final void a(com.larus.commercemembership.impl.component.d r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            d3 r0 = (d3) c.getValue();
            if (r0 == null) goto L6;
            r0.a(r2);
            return;
        }

        @Override // com.larus.platform.api.d3
        public final void b(com.larus.commercemembership.impl.component.d r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            d3 r0 = (d3) c.getValue();
            if (r0 == null) goto L6;
            r0.b(r2);
            return;
        }

        @Override // com.larus.platform.api.d3
        public final boolean c(hq9.n3 r2) {
            d3 r0 = (d3) c.getValue();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.c(r2);
        }
    }

    static {
        a = a.b;
    }

    void a(com.larus.commercemembership.impl.component.d r1);

    void b(com.larus.commercemembership.impl.component.d r1);

    boolean c(hq9.n3 r1);

    void d();

    void e();
}
