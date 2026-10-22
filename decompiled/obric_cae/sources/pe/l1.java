package pe;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l1 extends w {
    public l1() {
    }

    public abstract l1 t0();

    @Override // pe.w
    public String toString() {
        ve.c r8 = n0.f10048a;
        l1 r10 = ue.p.f12623a;
        if (this != r10) goto L15;
        String r11 = "Dispatchers.Main";
    L12:
        if (r11 == null) goto L14;
        return r11;
    L14:
        return getClass().getSimpleName() + '@' + d0.c(this);
    L15:
        l1 r12 = r10.t0();     // Catch: UnsupportedOperationException -> L8
    L9:
        if (this != r12) goto L11;
        r11 = "Dispatchers.Main.immediate";
        goto L12
    L11:
        r11 = null;
    L8:
        r12 = null;
        goto L9
    }
}
