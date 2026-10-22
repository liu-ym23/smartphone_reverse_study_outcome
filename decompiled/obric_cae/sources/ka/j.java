package ka;

import ha.a0;
import ha.c0;
import ha.z;

/* JADX INFO: loaded from: classes.dex */
public final class j extends c0<Number> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i f9008b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a0 f9009a;

    static {
        f9008b = new i(new j(z.f8013b));
    }

    public j(z.b r8) {
        this.f9009a = r8;
    }

    @Override // ha.c0
    public final Number a(pa.a r8) {
        pa.b r10 = r8.h0();
        int r11 = r10.ordinal();
        if (r11 == 5) goto L12;
        if (r11 == 6) goto L12;
        if (r11 != 8) goto L10;
        r8.V();
        return null;
    L10:
        throw new ha.q("Expecting number, got: " + r10 + "; at path " + r8.x());
    L12:
        return this.f9009a.a(r8);
    }

    @Override // ha.c0
    public final void b(pa.c r8, Number r10) {
        r8.G(r10);
    }
}
