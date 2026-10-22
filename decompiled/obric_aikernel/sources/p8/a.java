package p8;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f12354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f12355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f12356c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f12357d;

    public a(float r10, float r11, float r12, float r13) {
        this.f12354a = r10;
        this.f12355b = r11;
        this.f12356c = r12;
        this.f12357d = r13;
        q8.a r14 = b.b(0.0f, r11, r13, 1.0f, new float[5], 0);
        Float.intBitsToFloat((int) (r14.f12486a >> 32));
        Float.intBitsToFloat((int) (r14.f12486a & 4294967295L));
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof a) == false) goto L13;
        a r11 = (a) r10;
        if (this.f12354a != r11.f12354a) goto L13;
        if (this.f12355b != r11.f12355b) goto L13;
        if (this.f12356c != r11.f12356c) goto L13;
        if (this.f12357d != r11.f12357d) goto L13;
        return true;
    L13:
        return false;
    }

    public int hashCode() {
        return (((((Float.hashCode(this.f12354a) * 31) + Float.hashCode(this.f12355b)) * 31) + Float.hashCode(this.f12356c)) * 31) + Float.hashCode(this.f12357d);
    }

    public String toString() {
        return "CubicBezierEasing(a=" + this.f12354a + ", b=" + this.f12355b + ", c=" + this.f12356c + ", d=" + this.f12357d + ')';
    }
}
