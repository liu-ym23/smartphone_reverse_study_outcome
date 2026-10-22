package hb;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f8025a = 0;

    static {
        new c();
    }

    public static final int a(float r8, float[] r10, int r11) {
        float r12 = 0.0f;
        if (r8 < 0.0f) goto L5;
        r12 = 1.0f;
        if (r8 > 1.0f) goto L10;
    L13:
        r10[r11] = r8;
        return !Float.isNaN(r8) ? 1 : 0;
    L10:
        if (r8 <= 1.0000008f) goto L6;
    L12:
        r8 = Float.NaN;
    L6:
        r8 = r12;
        goto L13
    L5:
        if (r8 < (-8.34465E-7f)) goto L12;
        goto L6
    }
}
