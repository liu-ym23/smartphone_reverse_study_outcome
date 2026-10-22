package pe;

/* JADX INFO: loaded from: classes2.dex */
public class h0<T> extends a<T> implements g0<T> {
    @Override // pe.g0
    public final Object c0(ae.d<? super T> r8) {
    L2:
        Object r10 = t();
        if ((r10 instanceof z0) == false) goto L5;
        if (S(r10) < 0) goto L2;
        j1.a r11 = new j1.a(l6.a.b0(r8), this);
        r11.q();
        r11.s(new p0(i(new q1(r11))));
        Object r12 = r11.p();
        be.a r13 = be.a.f3165a;
    L12:
        be.a r14 = be.a.f3165a;
        return r12;
    L5:
        if ((r10 instanceof o) == true) goto L8;
        r12 = k1.a(r10);
        goto L12
    L8:
        throw ((o) r10).f10052a;
    }
}
