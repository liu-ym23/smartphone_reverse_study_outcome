package pe;

/* JADX INFO: loaded from: classes2.dex */
public final class v {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4, types: [ae.f] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r4v0, types: [T, ae.f] */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v5, types: [ae.f] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    public static final ae.f a(z r8, ae.f r10) {
        ae.f r11 = r8.d();
        Boolean r12 = Boolean.FALSE;
        u r13 = u.f10075a;
        boolean r14 = ((Boolean) r11.B(r12, r13)).booleanValue();
        boolean r15 = ((Boolean) r10.B(r12, r13)).booleanValue();
        ?? r16 = r11;
        ?? r17 = r10;
        if (r14 == true) goto L6;
        if (r15 == true) goto L6;
    L10:
        ae.f r18 = r16.C(r17);
        ve.c r19 = n0.f10048a;
        if (r18 != r19) goto L13;
        return r18;
    L13:
        if (r18.q0(ae.e.b.f352a) == null) goto L15;
        return r18;
    L15:
        return r18.C(r19);
    L6:
        he.o r20 = new he.o();
        r20.f8064a = r10;
        ae.g r21 = ae.g.f354a;
        ae.f r22 = (ae.f) r11.B(r21, new t(r20));
        if (r15 == false) goto L9;
        r20.f8064a = ((ae.f) r20.f8064a).B(r21, s.f10059a);
    L9:
        r16 = r22;
        r17 = (ae.f) r20.f8064a;
        goto L10
    }

    public static final z1 b(ae.d r8, ae.f r10) {
        if ((r8 instanceof ce.d) == true) goto L6;
        return null;
    L6:
        if (r10.q0(a2.f9993a) == null) goto L8;
        boolean r11 = true;
    L9:
        if (r11 == true) goto L11;
        return null;
    L11:
        ce.d r12 = (ce.d) r8;
    L13:
        if ((r12 instanceof l0) == true) goto L17;
        r12 = r12.getCallerFrame();
        if (r12 == null) goto L17;
        if ((r12 instanceof z1) == false) goto L13;
        z1 r13 = (z1) r12;
    L21:
        if (r13 != null) goto L23;
        return r13;
    L23:
        r13.X();
        throw null;
    L17:
        r13 = null;
        goto L21
    L8:
        r11 = false;
        goto L9
    }
}
