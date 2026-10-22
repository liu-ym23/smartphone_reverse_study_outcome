package zc;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import he.i;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14331a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f14332b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final float[][] f14333c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final float[][] f14334d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final float[] f14335e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final float[][] f14336f = null;

    static {
        f14331a = new a();
        f14332b = 31;
        f14333c = new float[][]{new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};
        f14334d = new float[][]{new float[]{1.8620678f, -1.0112547f, 0.14918678f}, new float[]{0.38752654f, 0.62144744f, -0.00897398f}, new float[]{-0.0158415f, -0.03412294f, 1.0499644f}};
        f14335e = new float[]{95.047f, 100.0f, 108.883f};
        f14336f = new float[][]{new float[]{0.41233894f, 0.35762063f, 0.18051042f}, new float[]{0.2126f, 0.7152f, 0.0722f}, new float[]{0.01932141f, 0.11916382f, 0.9503448f}};
    }

    public static final void a(String r8, String r10) {
        i.f(r8, LocationMonitorConst.TAG);
        i.f(r10, "msg");
        f(r8, 2, r10, null, 24);
    }

    public static final void b(String r8, String r10) {
        i.f(r10, "msg");
        f(r8, 16, r10, null, 24);
    }

    public static final void c(String r8, String r10, Exception r11) {
        i.f(r8, LocationMonitorConst.TAG);
        i.f(r10, "msg");
        f(r8, 16, r10, r11, 16);
    }

    public static final void d(String r8, String r10) {
        i.f(r8, LocationMonitorConst.TAG);
        i.f(r10, "msg");
        f(r8, 4, r10, null, 24);
    }

    public static float e(int r8) {
        float r10 = r8 / 255.0f;
        if (r10 > 0.04045f) goto L7;
        float r11 = r10 / 12.92f;
    L6:
        return r11 * 100.0f;
    L7:
        r11 = (float) Math.pow((r10 + 0.055f) / 1.055f, 2.4000000953674316d);
        goto L6
    }

    public static void f(String r8, int r10, String r11, Exception r12, int r13) {
        if ((r13 & 8) == 0) goto L6;
        r12 = null;
    L6:
        if ((f14332b & r10) != 0) goto L8;
        boolean r14 = true;
    L9:
        if (r14 == true) goto L13;
        f14331a.a(r10, r8, r11, r12);
        return;
    L13:
        return;
    L8:
        r14 = false;
        goto L9
    }

    public static final void g(String r8, String r10) {
        i.f(r8, LocationMonitorConst.TAG);
        i.f(r10, "msg");
        f(r8, 1, r10, null, 24);
    }

    public static final void h(String r8, String r10) {
        i.f(r10, "msg");
        f(r8, 8, r10, null, 24);
    }

    public static float i() {
        return ((float) Math.pow((((double) 50.0f) + 16.0d) / 116.0d, 3.0d)) * 100.0f;
    }
}
