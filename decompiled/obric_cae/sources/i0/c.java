package i0;

/* JADX INFO: loaded from: classes.dex */
public final class c<F, S> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final F f8079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final S f8080b;

    public c(F r8, S r10) {
        this.f8079a = r8;
        this.f8080b = r10;
    }

    public final boolean equals(Object r8) {
        if ((r8 instanceof c) == true) goto L5;
        return false;
    L5:
        c r10 = (c) r8;
        if (b.a(r10.f8079a, this.f8079a) == true) goto L8;
        return false;
    L8:
        if (b.a(r10.f8080b, this.f8080b) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r8 = 0;
        F r10 = this.f8079a;
        if (r10 != null) goto L5;
        int r11 = 0;
    L6:
        S r12 = this.f8080b;
        if (r12 == null) goto L11;
        r8 = r12.hashCode();
    L11:
        return r11 ^ r8;
    L5:
        r11 = r10.hashCode();
        goto L6
    }

    public final String toString() {
        return "Pair{" + this.f8079a + " " + this.f8080b + "}";
    }
}
