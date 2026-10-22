package ha;

/* JADX INFO: loaded from: classes.dex */
public final class f extends c0<Number> {
    @Override // ha.c0
    public final Number a(pa.a r8) {
        if (r8.h0() != pa.b.f9974s) goto L6;
        r8.V();
        return null;
    L6:
        return Float.valueOf((float) r8.G());
    }

    @Override // ha.c0
    public final void b(pa.c r8, Number r10) {
        Number r11 = r10;
        if (r11 != null) goto L5;
        r8.z();
        return;
    L5:
        float r12 = r11.floatValue();
        j.a(r12);
        if ((r11 instanceof Float) == true) goto L9;
        r11 = Float.valueOf(r12);
    L9:
        r8.G(r11);
    }
}
