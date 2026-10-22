package t;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12917b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f12918c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f12919d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f12920e;

    public g(int r10, int r11, long r12, int r13) {
        this.f12920e = 1;
        this.f12916a = r10;
        this.f12917b = r11;
        this.f12919d = r13;
        this.f12918c = r12;
    }

    public void a(long r10) {
        this.f12920e++;
        this.f12917b = (int) (((long) this.f12917b) + r10);
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof g) == false) goto L10;
        g r11 = (g) r10;
        if (r11.f12916a == this.f12916a) goto L7;
        return false;
    L7:
        if (r11.f12919d != this.f12919d) goto L13;
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return this.f12919d + "," + this.f12916a + "," + this.f12920e + "," + this.f12917b + "," + this.f12918c;
    }
}
