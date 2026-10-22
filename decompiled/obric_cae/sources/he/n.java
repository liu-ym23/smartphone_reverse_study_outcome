package he;

import pe.d0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class n extends b implements le.d {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f8063q;

    public n() {
        super(b.a.f8057a, null, null, null, false);
        this.f8063q = false;
    }

    public final le.a c() {
        if (this.f8063q == true) goto L10;
        le.a r8 = this.f8051a;
        if (r8 != null) goto L9;
        r8 = a();
        this.f8051a = r8;
    L9:
        return r8;
    L10:
        return this;
    }

    public final boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof n) == false) goto L19;
        n r10 = (n) r8;
        if (b().equals(r10.b()) == false) goto L17;
        if (this.f8054n.equals(r10.f8054n) == false) goto L17;
        if (this.f8055o.equals(r10.f8055o) == false) goto L17;
        if (i.a(this.f8052b, r10.f8052b) == false) goto L17;
        return true;
    L17:
        return false;
    L19:
        if ((r8 instanceof le.d) == true) goto L21;
        return false;
    L21:
        return r8.equals(c());
    }

    public final int hashCode() {
        int r8 = b().hashCode() * 31;
        int r10 = defpackage.a.b(this.f8054n, r8, 31);
        return this.f8055o.hashCode() + r10;
    }

    public final String toString() {
        le.a r8 = c();
        if (r8 == this) goto L7;
        return r8.toString();
    L7:
        return android.aimedia.a.i(new StringBuilder("property "), this.f8054n, " (Kotlin reflection is not available)");
    }

    public n(Object r8) {
        super(r8, d0.class, "classSimpleName", "getClassSimpleName(Ljava/lang/Object;)Ljava/lang/String;", true);
        this.f8063q = false;
    }
}
