package he;

/* JADX INFO: loaded from: classes2.dex */
public class g extends b implements f, le.c {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f8060q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f8061r;

    public g(int r10, Object r11, Class r12, String r13, String r14, int r15) {
        if ((r15 & 1) != 1) goto L5;
        boolean r8 = true;
    L6:
        super(r11, r12, r13, r14, r8);
        this.f8060q = r10;
        this.f8061r = r15 >> 1;
        return;
    L5:
        r8 = false;
        goto L6
    }

    @Override // he.b
    public final le.a a() {
        p.f8065a.getClass();
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object] */
    public final boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof g) == false) goto L23;
        g r10 = (g) r8;
        String r11 = r10.f8054n;
        if (this.f8054n.equals(r11) == false) goto L21;
        if (this.f8055o.equals(r10.f8055o) == false) goto L21;
        if (this.f8061r != r10.f8061r) goto L21;
        if (this.f8060q != r10.f8060q) goto L21;
        if (i.a(this.f8052b, r10.f8052b) == false) goto L21;
        if (i.a(b(), r10.b()) == false) goto L21;
        return true;
    L21:
        return false;
    L23:
        if ((r8 instanceof le.c) == false) goto L30;
        le.a r12 = this.f8051a;
        if (r12 != null) goto L27;
        a();
        this.f8051a = this;
        ?? r13 = this;
    L29:
        return r8.equals(r13);
    L27:
        r13 = r12;
        goto L29
    L30:
        return false;
    }

    @Override // he.f
    public final int getArity() {
        return this.f8060q;
    }

    public final int hashCode() {
        if (b() != null) goto L5;
        int r8 = 0;
    L6:
        int r10 = defpackage.a.b(this.f8054n, r8, 31);
        return this.f8055o.hashCode() + r10;
    L5:
        r8 = b().hashCode() * 31;
        goto L6
    }

    public final String toString() {
        le.a r8 = this.f8051a;
        if (r8 != null) goto L5;
        a();
        this.f8051a = this;
        r8 = this;
    L5:
        if (r8 != this) goto L7;
        String r10 = this.f8054n;
        if ("<init>".equals(r10) == false) goto L12;
        return "constructor (Kotlin reflection is not available)";
    L12:
        return defpackage.b.d("function ", r10, " (Kotlin reflection is not available)");
    L7:
        return r8.toString();
    }
}
