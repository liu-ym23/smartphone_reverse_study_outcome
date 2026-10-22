package d6;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f16608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f16609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f16610c;
    public final int d;
    public int e;

    public f(int r5, int r10, int r11, long r12) {
        this.e = 1;
        this.f16608a = r5;
        this.f16609b = r10;
        this.d = r11;
        this.f16610c = r12;
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof f) == false) goto L10;
        f r10 = (f) r5;
        if (r10.f16608a == this.f16608a) goto L7;
        return false;
    L7:
        if (r10.d != this.d) goto L13;
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    public final String toString() {
        return this.d + "," + this.f16608a + "," + this.e + "," + this.f16609b + "," + this.f16610c;
    }
}
