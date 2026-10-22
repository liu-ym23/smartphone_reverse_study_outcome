package irb;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public String a;
    public String b;
    public String c;
    public boolean d;
    public boolean e;
    public String f;
    public String g;
    public int h;
    public int i;

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (((((r6 + r8) * 31) + (this.d ? 1 : 0)) * 31) + (this.e ? 1 : 0)) * 31;
        String r10 = this.f;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.g;
        if (r13 == null) goto L22;
        r1 = r13.hashCode();
    L22:
        return ((((r12 + r1) * 31) + this.h) * 31) + this.i;
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public a() {
        this.d = false;
        this.e = false;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L61:
        return false;
    L8:
        if (a.class != r5.getClass()) goto L61;
        a r6 = (a) r5;
        if (this.d == r6.d) goto L14;
        return false;
    L14:
        if (this.e == r6.e) goto L17;
        return false;
    L17:
        if (this.h == r6.h) goto L20;
        return false;
    L20:
        if (this.i == r6.i) goto L22;
        return false;
    L22:
        String r2 = this.a;
        if (r2 == null) goto L28;
        if (r2.equals(r6.a) == false) goto L29;
    L30:
        String r3 = this.b;
        if (r3 == null) goto L36;
        if (r3.equals(r6.b) == false) goto L37;
    L38:
        String r4 = this.c;
        if (r4 == null) goto L44;
        if (r4.equals(r6.c) == false) goto L45;
    L46:
        String r7 = this.f;
        if (r7 == null) goto L52;
        if (r7.equals(r6.f) == false) goto L53;
    L54:
        String r8 = this.g;
        String r9 = r6.g;
        if (r8 != null) goto L62;
        if (r9 == null) goto L63;
        return false;
    L63:
        return true;
    L62:
        return r8.equals(r9);
    L53:
        return false;
    L52:
        if (r6.f == null) goto L54;
    L45:
        return false;
    L44:
        if (r6.c == null) goto L46;
    L37:
        return false;
    L36:
        if (r6.b == null) goto L38;
    L29:
        return false;
    L28:
        if (r6.a == null) goto L30;
        goto L29
    }
}
