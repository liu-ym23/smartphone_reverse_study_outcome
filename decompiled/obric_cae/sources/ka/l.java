package ka;

import ha.a0;
import ha.c0;
import ha.z;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class l extends c0<Object> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final k f9011c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ha.j f9012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a0 f9013b;

    static {
        f9011c = new k(z.f8012a);
    }

    public l(ha.j r8, a0 r10) {
        this.f9012a = r8;
        this.f9013b = r10;
    }

    public static Serializable d(pa.a r8, pa.b r10) {
        int r11 = r10.ordinal();
        if (r11 != 0) goto L5;
        r8.a();
        return new ArrayList();
    L5:
        if (r11 == 2) goto L8;
        return null;
    L8:
        r8.i();
        return new ja.s();
    }

    @Override // ha.c0
    public final Object a(pa.a r8) {
        pa.b r10 = r8.h0();
        Object r11 = d(r8, r10);
        if (r11 == null) goto L5;
        ArrayDeque r12 = new ArrayDeque();
    L8:
        if (r8.B() == true) goto L10;
        if ((r11 instanceof List) == false) goto L29;
        r8.r();
    L31:
        if (r12.isEmpty() == true) goto L32;
        r11 = r12.removeLast();
        goto L8
    L32:
        return r11;
    L29:
        r8.v();
        goto L31
    L10:
        if ((r11 instanceof Map) == false) goto L12;
        String r13 = r8.J();
    L13:
        pa.b r14 = r8.h0();
        Serializable r15 = d(r8, r14);
        if (r15 == null) goto L16;
        boolean r16 = true;
    L17:
        if (r15 != null) goto L19;
        Serializable r17 = c(r8, r14);
    L21:
        if ((r11 instanceof List) == false) goto L23;
        ((List) r11).add(r17);
    L24:
        if (r16 == false) goto L8;
        r12.addLast(r11);
        r11 = r17;
        goto L8
    L23:
        ((Map) r11).put(r13, r17);
        goto L24
    L19:
        r17 = r15;
        goto L21
    L16:
        r16 = false;
        goto L17
    L12:
        r13 = null;
        goto L13
    L5:
        return c(r8, r10);
    }

    @Override // ha.c0
    public final void b(pa.c r8, Object r10) {
        if (r10 != null) goto L5;
        r8.z();
        return;
    L5:
        Class<?> r11 = r10.getClass();
        ha.j r12 = this.f9012a;
        r12.getClass();
        c0 r13 = r12.f(oa.a.get(r11));
        if ((r13 instanceof l) == false) goto L9;
        r8.k();
        r8.v();
        return;
    L9:
        r13.b(r8, r10);
    }

    public final Serializable c(pa.a r8, pa.b r10) {
        int r11 = r10.ordinal();
        if (r11 == 5) goto L19;
        if (r11 == 6) goto L17;
        if (r11 == 7) goto L15;
        if (r11 != 8) goto L13;
        r8.V();
        return null;
    L13:
        throw new IllegalStateException("Unexpected token: " + r10);
    L15:
        return Boolean.valueOf(r8.E());
    L17:
        return this.f9013b.a(r8);
    L19:
        return r8.e0();
    }
}
