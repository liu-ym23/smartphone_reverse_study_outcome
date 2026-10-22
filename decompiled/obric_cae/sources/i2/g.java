package i2;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f8132c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f8133d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f8134e;

    public g(int r8, int r10, int r11, long r12) {
        this.f8134e = 1;
        this.f8130a = r8;
        this.f8131b = r10;
        this.f8133d = r11;
        this.f8132c = r12;
    }

    public final boolean equals(Object r8) {
        if ((r8 instanceof g) == false) goto L10;
        g r10 = (g) r8;
        if (r10.f8130a == this.f8130a) goto L7;
        return false;
    L7:
        if (r10.f8133d != this.f8133d) goto L13;
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final String toString() {
        return this.f8133d + "," + this.f8130a + "," + this.f8134e + "," + this.f8131b + "," + this.f8132c;
    }
}
