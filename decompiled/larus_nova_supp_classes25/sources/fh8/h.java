package fh8;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h {
    public static final g a(f r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        g r0 = new g();
        r0.a = r2.a;
        r0.b = r2.b;
        r0.c = r2.c;
        r0.d = r2.d;
        r0.e = r2.e;
        r0.f = r2.f;
        r0.g = r2.g;
        r0.h = r2.h;
        r0.i = r2.i;
        r0.j = r2.j;
        r0.p = r2.k;
        r0.k = r2.l;
        r0.l = r2.m;
        r0.m = r2.n;
        r0.n = r2.o;
        r0.o = r2.p;
        r0.q = r2.q;
        r0.r = r2.r;
        r0.s = r2.s;
        r0.t = r2.t;
        r0.u = r2.u;
        r0.v = r2.v;
        r0.w = r2.w;
        r0.x = r2.x;
        r0.y = r2.y;
        r0.z = r2.z;
        r0.A = r2.A;
        r0.B = r2.B;
        r0.C = r2.C;
        return r0;
    }

    public static final f b(Map<String, ? extends Object> r2) {
        if (r2 == null) goto L5;
        Object r3 = r2.get("markdown_common_input_data");
    L7:
        if ((r3 instanceof f) == true) goto L9;
        return null;
    L9:
        return (f) r3;
    L5:
        r3 = null;
        goto L7
    }
}
