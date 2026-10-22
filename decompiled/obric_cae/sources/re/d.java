package re;

import pe.e1;
import pe.h;
import xd.j;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [ge.a, ta.a$a] */
    /* JADX WARN: Type inference failed for: r5v3, types: [ge.a] */
    /* JADX WARN: Type inference failed for: r5v5, types: [ge.a] */
    public static final Object a(e r8, ta.a.C0163a r10, ae.d r11) {
        if ((r11 instanceof b) == false) goto L7;
        b r12 = (b) r11;
        int r13 = r12.f11807n;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.f11807n = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.f11806m;
        l6.a.M();
        be.a r15 = be.a.f3165a;
        int r16 = r12.f11807n;
        if (r16 == 0) goto L16;
        if (r16 != 1) goto L15;
        r10 = r12.f11805b;
        defpackage.c.m0(r14);     // Catch: Throwable -> L28
    L26:
        r10.f();
        return j.f13877a;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        defpackage.c.m0(r14);
        if (r12.getContext().q0(e1.b.f10008a) != r8) goto L19;
        boolean r17 = true;
    L20:
        if (r17 == false) goto L32;
        r12.f11804a = r8;     // Catch: Throwable -> L28
        r12.f11805b = r10;     // Catch: Throwable -> L28
        r12.f11807n = 1;     // Catch: Throwable -> L28
        h r18 = new h(1, l6.a.b0(r12));     // Catch: Throwable -> L28
        r18.q();     // Catch: Throwable -> L28
        new c(r18);     // Catch: Throwable -> L28
        r8.b();     // Catch: Throwable -> L28
        Object r19 = r18.p();     // Catch: Throwable -> L28
        l6.a.M();     // Catch: Throwable -> L28
        if (r19 != r15) goto L24;
        l6.a.B0(r12);     // Catch: Throwable -> L28
    L24:
        if (r19 != r15) goto L26;
        return r15;
    L32:
        throw new IllegalStateException("awaitClose() can only be invoked from the producer context".toString());
    L19:
        r17 = false;
    L28:
        th = move-exception;
        r10.f();
        throw th;
    L7:
        r12 = new b(r11);
        goto L8
    }
}
