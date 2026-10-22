package n0c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public final String a;
    public final boolean b;
    public final boolean c;

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + (this.b ? 1 : 0)) * 31) + (this.c ? 1 : 0);
    }

    public final String toString() {
        return "Permission{name='" + this.a + "', granted=" + this.b + ", shouldShowRequestPermissionRationale=" + this.c + '}';
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if (r4 != null) goto L8;
    L18:
        return false;
    L8:
        if (a.class != r4.getClass()) goto L18;
        a r5 = (a) r4;
        if (this.b == r5.b) goto L14;
        return false;
    L14:
        if (this.c == r5.c) goto L17;
        return false;
    L17:
        return this.a.equals(r5.a);
    }

    public a(String r1, boolean r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
