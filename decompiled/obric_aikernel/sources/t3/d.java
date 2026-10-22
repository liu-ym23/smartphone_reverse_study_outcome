package t3;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f12937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f12938c;

    public d(int r10, f r11, Object r12) {
        this.f12936a = r10;
        this.f12937b = r11;
        this.f12938c = r12;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof d) == true) goto L8;
        return false;
    L8:
        d r11 = (d) r10;
        if (this.f12936a == r11.f12936a) goto L12;
        return false;
    L12:
        if (this.f12937b.equals(r11.f12937b) == true) goto L14;
        return false;
    L14:
        Object r12 = this.f12938c;
        if (r12 != null) goto L17;
    L18:
        Object r13 = r11.f12938c;
        if (r13 != null) goto L21;
        return true;
    L21:
        if (r13.equals(this.f12938c) == false) goto L24;
        return true;
    L24:
        return false;
    L17:
        if (r12.equals(r11.f12938c) == false) goto L24;
        goto L18
    }

    public int hashCode() {
        return (this.f12937b.hashCode() << 31) + this.f12936a;
    }
}
