package com.obric.cae.libs.location;

import android.location.Location;

/* JADX INFO: loaded from: classes.dex */
public class CoordinateTransformUtils {

    public static final enum CoordinateSystem extends Enum<CoordinateSystem> {
        public static final CoordinateSystem BD09 = null;
        public static final CoordinateSystem GCJ02 = null;
        public static final CoordinateSystem WGS84 = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CoordinateSystem[] f5396a = null;

        static {
            CoordinateSystem r8 = new CoordinateSystem("WGS84", 0);
            WGS84 = r8;
            CoordinateSystem r10 = new CoordinateSystem("GCJ02", 1);
            GCJ02 = r10;
            CoordinateSystem r11 = new CoordinateSystem("BD09", 2);
            BD09 = r11;
            f5396a = new CoordinateSystem[]{r8, r10, r11};
        }

        public CoordinateSystem(String r8, int r10) {
            super(r8, r10);
        }

        public static CoordinateSystem valueOf(String r8) {
            return (CoordinateSystem) Enum.valueOf(CoordinateSystem.class, r8);
        }

        public static CoordinateSystem[] values() {
            return (CoordinateSystem[]) f5396a.clone();
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final double f5397a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final double f5398b;

        public a(double r8, double r10) {
            this.f5397a = r8;
            this.f5398b = r10;
        }
    }

    static {
        System.loadLibrary("coordinate_transform");
    }

    public CoordinateTransformUtils() {
    }

    private static native double[] bd09ToGcj02Native(double r8, double r10);

    public static Location convertLocation(CoordinateSystem r8, CoordinateSystem r10, Location r11) {
        if (r8 == r10) goto L30;
        if (r11 == null) goto L30;
        CoordinateSystem r12 = CoordinateSystem.WGS84;
        if (r8 == r12) goto L8;
    L10:
        CoordinateSystem r13 = CoordinateSystem.GCJ02;
        if (r8 != r13) goto L14;
        if (r10 != r12) goto L14;
        double[] r14 = gcj02ToWgs84Native(r11.getLatitude(), r11.getLongitude());
        a r15 = new a(r14[0], r14[1]);
    L28:
        Location r16 = new Location(r11);
        r16.setLatitude(r15.f5397a);
        r16.setLongitude(r15.f5398b);
        return r16;
    L14:
        CoordinateSystem r17 = CoordinateSystem.BD09;
        if (r8 != r17) goto L18;
        if (r10 != r13) goto L18;
        double[] r18 = bd09ToGcj02Native(r11.getLatitude(), r11.getLongitude());
        r15 = new a(r18[0], r18[1]);
    L18:
        if (r8 != r13) goto L21;
        if (r10 != r17) goto L21;
        double[] r19 = gcj02ToBd09Native(r11.getLatitude(), r11.getLongitude());
        r15 = new a(r19[0], r19[1]);
    L21:
        if (r8 != r12) goto L24;
        if (r10 != r17) goto L24;
        double[] r20 = wgs84ToGcj02Native(r11.getLatitude(), r11.getLongitude());
        double[] r21 = gcj02ToBd09Native(r20[0], r20[1]);
        r15 = new a(r21[0], r21[1]);
    L24:
        if (r8 != r17) goto L27;
        if (r10 != r12) goto L27;
        double[] r22 = bd09ToGcj02Native(r11.getLatitude(), r11.getLongitude());
        double[] r23 = gcj02ToWgs84Native(r22[0], r22[1]);
        r15 = new a(r23[0], r23[1]);
    L27:
        r15 = new a(r11.getLatitude(), r11.getLongitude());
        goto L28
    L8:
        if (r10 != CoordinateSystem.GCJ02) goto L10;
        double[] r24 = wgs84ToGcj02Native(r11.getLatitude(), r11.getLongitude());
        r15 = new a(r24[0], r24[1]);
    L30:
        return r11;
    }

    private static native double[] gcj02ToBd09Native(double r8, double r10);

    private static native double[] gcj02ToWgs84Native(double r8, double r10);

    private static native double[] wgs84ToGcj02Native(double r8, double r10);
}
