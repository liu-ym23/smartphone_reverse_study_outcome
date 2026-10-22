package androidx.appcompat.app;

/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static u f696d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f699c;

    public final void a(double r16, double r18, long r20) {
        float r8 = (r20 - 946728000000L) / 8.64E7f;
        float r10 = (0.01720197f * r8) + 6.24006f;
        double r11 = r10;
        double r12 = (((Math.sin(r10 * 3.0f) * 5.236000106378924E-6d) + ((Math.sin(2.0f * r10) * 3.4906598739326E-4d) + ((Math.sin(r11) * 0.03341960161924362d) + r11))) + 1.796593063d) + 3.141592653589793d;
        double r13 = (-r18) / 360.0d;
        double r14 = (Math.sin(2.0d * r12) * (-0.0069d)) + ((Math.sin(r11) * 0.0053d) + (((double) (Math.round(((double) (r8 - 9.0E-4f)) - r13) + 9.0E-4f)) + r13));
        double r15 = Math.asin(Math.sin(0.4092797040939331d) * Math.sin(r12));
        double r17 = 0.01745329238474369d * r16;
        double r19 = (Math.sin(-0.10471975803375244d) - (Math.sin(r15) * Math.sin(r17))) / (Math.cos(r15) * Math.cos(r17));
        if (r19 < 1.0d) goto L8;
        this.f699c = 1;
    L5:
        this.f697a = -1;
        this.f698b = -1;
        return;
    L8:
        if (r19 > (-1.0d)) goto L10;
        this.f699c = 0;
        goto L5
    L10:
        double r21 = (float) (Math.acos(r19) / 6.283185307179586d);
        this.f697a = Math.round((r14 + r21) * 8.64E7d) + 946728000000L;
        long r22 = Math.round((r14 - r21) * 8.64E7d) + 946728000000L;
        this.f698b = r22;
        if (r22 < r20) goto L13;
    L15:
        this.f699c = 1;
        return;
    L13:
        if (this.f697a <= r20) goto L15;
        this.f699c = 0;
    }
}
