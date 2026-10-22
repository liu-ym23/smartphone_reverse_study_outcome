package qa;

/* JADX INFO: loaded from: classes.dex */
public class l2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f10785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f10786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double f10787c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f10788d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f10789e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f10790f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f10791g;

    public l2() {
        this.f10785a = 0;
        this.f10786b = 0.0d;
        this.f10787c = 0.0d;
        this.f10788d = 0.0d;
        this.f10789e = 0.0f;
        this.f10790f = 0.0f;
        this.f10791g = 0.0f;
    }

    public final double a(m2 r13) {
        if (r13 == null) goto L5;
        double r8 = this.f10787c;
        double r10 = this.f10786b;
        double r11 = r13.f10787c;
        double r12 = r13.f10786b;
        double r14 = (((90.0d - r10) * 21412.0d) / 90.0d) + 6356725.0d;
        double r15 = (r11 * 0.01745329238474369d) - (r8 * 0.01745329238474369d);
        double r16 = r15 * (Math.cos((3.1415927410125732d * r10) / 180.0d) * r14);
        double r17 = ((r12 * 0.01745329238474369d) - (r10 * 0.01745329238474369d)) * r14;
        double r18 = r17 * r17;
        return Math.pow(r18 + (r16 * r16), 0.5d);
    L5:
        return 0.0d;
    }
}
