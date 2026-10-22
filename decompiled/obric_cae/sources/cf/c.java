package cf;

import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final jf.g f3458d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final jf.g f3459e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final jf.g f3460f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final jf.g f3461g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final jf.g f3462h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final jf.g f3463i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jf.g f3464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final jf.g f3465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3466c;

    static {
        f3458d = jf.g.d(BdimCategoryConstants.SEPARATOR_COLON);
        f3459e = jf.g.d(":status");
        f3460f = jf.g.d(":method");
        f3461g = jf.g.d(":path");
        f3462h = jf.g.d(":scheme");
        f3463i = jf.g.d(":authority");
    }

    public c(String r8, String r10) {
        this(jf.g.d(r8), jf.g.d(r10));
    }

    public final boolean equals(Object r8) {
        if ((r8 instanceof c) == false) goto L10;
        c r10 = (c) r8;
        jf.g r11 = r10.f3464a;
        if (this.f3464a.equals(r11) == true) goto L7;
        return false;
    L7:
        if (this.f3465b.equals(r10.f3465b) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public final int hashCode() {
        int r8 = (this.f3464a.hashCode() + 527) * 31;
        return this.f3465b.hashCode() + r8;
    }

    public final String toString() {
        return xe.c.n("%s: %s", new Object[]{this.f3464a.p(), this.f3465b.p()});
    }

    public c(String r8, jf.g r10) {
        this(r10, jf.g.d(r8));
    }

    public c(jf.g r8, jf.g r10) {
        this.f3464a = r8;
        this.f3465b = r10;
        int r11 = r8.l() + 32;
        this.f3466c = r10.l() + r11;
    }
}
