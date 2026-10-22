package q0;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Class f21455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Class f21456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Class f21457c;

    public g(Class r5, Class r10, Class r11) {
        this.f21455a = r5;
        this.f21456b = r10;
        this.f21457c = r11;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L20:
        return false;
    L8:
        if (g.class != r5.getClass()) goto L20;
        g r10 = (g) r5;
        if (this.f21455a.equals(r10.f21455a) == true) goto L14;
        return false;
    L14:
        if (this.f21456b.equals(r10.f21456b) == true) goto L17;
        return false;
    L17:
        if (i.a(this.f21457c, r10.f21457c) == true) goto L19;
        return false;
    L19:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f21455a.hashCode() * 31;
        int r10 = (this.f21456b.hashCode() + r5) * 31;
        Class r11 = this.f21457c;
        if (r11 == null) goto L5;
        int r12 = r11.hashCode();
    L7:
        return r10 + r12;
    L5:
        r12 = 0;
        goto L7
    }

    public final String toString() {
        return "MultiClassKey{first=" + this.f21455a + ", second=" + this.f21456b + '}';
    }
}
