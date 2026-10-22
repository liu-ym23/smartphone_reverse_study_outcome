package s8;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f12740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f12741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f12742c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f12743d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f12744e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float f12745f;

    public b(float r10, float r11, float r12, float r13, float r14, float r15) {
        this.f12740a = r10;
        this.f12741b = r11;
        this.f12742c = r12;
        this.f12743d = r13;
        this.f12744e = r14;
        this.f12745f = r15;
    }

    public final float a() {
        return this.f12744e;
    }

    public final float b() {
        return this.f12745f;
    }

    public final float c() {
        return this.f12742c;
    }

    public final float d() {
        return this.f12741b;
    }

    public final float e() {
        return this.f12740a;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof b) == false) goto L18;
        b r11 = (b) r10;
        if (Float.compare(this.f12740a, r11.f12740a) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.f12741b, r11.f12741b) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.f12742c, r11.f12742c) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f12743d, r11.f12743d) == 0) goto L14;
        return false;
    L14:
        if (Float.compare(this.f12744e, r11.f12744e) == 0) goto L16;
        return false;
    L16:
        if (Float.compare(this.f12745f, r11.f12745f) == 0) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final float f() {
        return this.f12743d;
    }

    public int hashCode() {
        return (((((((((Float.hashCode(this.f12740a) * 31) + Float.hashCode(this.f12741b)) * 31) + Float.hashCode(this.f12742c)) * 31) + Float.hashCode(this.f12743d)) * 31) + Float.hashCode(this.f12744e)) * 31) + Float.hashCode(this.f12745f);
    }

    public String toString() {
        return "ControlPoint(handleLarge=" + this.f12740a + ", distanceOuter=" + this.f12741b + ", distanceInner=" + this.f12742c + ", handleMedium=" + this.f12743d + ", curveInner=" + this.f12744e + ", curveOuter=" + this.f12745f + ")";
    }
}
