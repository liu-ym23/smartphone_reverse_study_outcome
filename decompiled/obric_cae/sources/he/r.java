package he;

import ge.s;
import ge.t;
import ge.u;
import ge.v;
import ge.w;

/* JADX INFO: loaded from: classes2.dex */
public final class r {
    public r() {
    }

    public static void a(int r8, Object r10) {
        if (r10 == null) goto L84;
        boolean r11 = false;
        if ((r10 instanceof xd.a) == true) goto L6;
    L80:
        if (r11 == true) goto L85;
        ClassCastException r12 = new ClassCastException(defpackage.a.f(r10.getClass().getName(), " cannot be cast to ", defpackage.a.d("kotlin.jvm.functions.Function", r8)));
        i.i(r.class.getName(), r12);
        throw r12;
    L85:
        return;
    L6:
        if ((r10 instanceof f) == false) goto L9;
        int r13 = ((f) r10).getArity();
    L78:
        if (r13 != r8) goto L80;
        r11 = true;
        goto L80
    L9:
        if ((r10 instanceof ge.a) == false) goto L12;
        r13 = 0;
        goto L78
    L12:
        if ((r10 instanceof ge.l) == false) goto L15;
        r13 = 1;
        goto L78
    L15:
        if ((r10 instanceof ge.p) == false) goto L18;
        r13 = 2;
        goto L78
    L18:
        if ((r10 instanceof ge.q) == false) goto L21;
        r13 = 3;
        goto L78
    L21:
        if ((r10 instanceof ge.r) == false) goto L24;
        r13 = 4;
        goto L78
    L24:
        if ((r10 instanceof s) == false) goto L27;
        r13 = 5;
        goto L78
    L27:
        if ((r10 instanceof t) == false) goto L30;
        r13 = 6;
        goto L78
    L30:
        if ((r10 instanceof u) == false) goto L33;
        r13 = 7;
        goto L78
    L33:
        if ((r10 instanceof v) == false) goto L36;
        r13 = 8;
        goto L78
    L36:
        if ((r10 instanceof w) == false) goto L39;
        r13 = 9;
        goto L78
    L39:
        if ((r10 instanceof ge.b) == false) goto L42;
        r13 = 10;
        goto L78
    L42:
        if ((r10 instanceof ge.c) == false) goto L45;
        r13 = 11;
        goto L78
    L45:
        if ((r10 instanceof ge.d) == false) goto L48;
        r13 = 12;
        goto L78
    L48:
        if ((r10 instanceof ge.e) == false) goto L51;
        r13 = 13;
        goto L78
    L51:
        if ((r10 instanceof ge.f) == false) goto L54;
        r13 = 14;
        goto L78
    L54:
        if ((r10 instanceof ge.g) == false) goto L57;
        r13 = 15;
        goto L78
    L57:
        if ((r10 instanceof ge.h) == false) goto L60;
        r13 = 16;
        goto L78
    L60:
        if ((r10 instanceof ge.i) == false) goto L63;
        r13 = 17;
        goto L78
    L63:
        if ((r10 instanceof ge.j) == false) goto L66;
        r13 = 18;
        goto L78
    L66:
        if ((r10 instanceof ge.k) == false) goto L69;
        r13 = 19;
        goto L78
    L69:
        if ((r10 instanceof ge.m) == false) goto L72;
        r13 = 20;
        goto L78
    L72:
        if ((r10 instanceof ge.n) == false) goto L75;
        r13 = 21;
        goto L78
    L75:
        if ((r10 instanceof ge.o) == false) goto L77;
        r13 = 22;
        goto L78
    L77:
        r13 = -1;
        goto L78
    }
}
