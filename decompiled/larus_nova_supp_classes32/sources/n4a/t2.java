package n4a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class t2 {
    public long a;
    public double b;
    public double c;
    public double d;
    public float e;
    public float f;
    public float g;

    public t2() {
        this.a = 0;
        this.b = 0.0d;
        this.c = 0.0d;
        this.d = 0.0d;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0.0f;
    }

    public final double a(u2 r15) {
        if (r15 == null) goto L5;
        double r0 = this.c;
        double r2 = this.b;
        double r4 = r15.c;
        double r6 = r15.b;
        double r10 = (((90.0d - r2) * 21412.0d) / 90.0d) + 6356725.0d;
        double r5 = (r4 * 0.01745329238474369d) - (r0 * 0.01745329238474369d);
        double r7 = r5 * (Math.cos((3.1415927410125732d * r2) / 180.0d) * r10);
        double r8 = ((r6 * 0.01745329238474369d) - (r2 * 0.01745329238474369d)) * r10;
        return Math.pow((r7 * r7) + (r8 * r8), 0.5d);
    L5:
        return 0.0d;
    }
}
