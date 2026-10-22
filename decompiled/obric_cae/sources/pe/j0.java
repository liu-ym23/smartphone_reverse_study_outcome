package pe;

/* JADX INFO: loaded from: classes2.dex */
public final class j0 {
    public static final Object a(ae.d r8) {
        h r10 = new h(1, l6.a.b0(r8));
        r10.q();
        b(r10.getContext()).r(r10);
        Object r11 = r10.p();
        l6.a.M();
        be.a r12 = be.a.f3165a;
        if (r11 != r12) goto L5;
        l6.a.B0(r8);
    L5:
        l6.a.M();
        if (r11 != r12) goto L9;
        return r11;
    L9:
        return xd.j.f13877a;
    }

    public static final i0 b(ae.f r8) {
        int r10 = ae.e.f351c;
        ae.f.b r11 = r8.q0(ae.e.b.f352a);
        if ((r11 instanceof i0) == false) goto L5;
        i0 r12 = (i0) r11;
    L6:
        if (r12 == null) goto L8;
        return r12;
    L8:
        return f0.f10009a;
    L5:
        r12 = null;
        goto L6
    }
}
