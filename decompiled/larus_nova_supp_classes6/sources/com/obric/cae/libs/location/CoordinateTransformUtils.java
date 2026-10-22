package com.obric.cae.libs.location;

import android.location.Location;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class CoordinateTransformUtils {

    public static final enum CoordinateSystem extends Enum<CoordinateSystem> {
        public static final CoordinateSystem BD09 = null;
        public static final CoordinateSystem GCJ02 = null;
        public static final CoordinateSystem WGS84 = null;
        public static final /* synthetic */ CoordinateSystem[] a = null;

        static {
            CoordinateSystem r0 = new CoordinateSystem("WGS84", 0);
            WGS84 = r0;
            CoordinateSystem r1 = new CoordinateSystem("GCJ02", 1);
            GCJ02 = r1;
            CoordinateSystem r3 = new CoordinateSystem("BD09", 2);
            BD09 = r3;
            a = new CoordinateSystem[]{r0, r1, r3};
        }

        public static CoordinateSystem[] values() {
            return (CoordinateSystem[]) a.clone();
        }

        public static CoordinateSystem valueOf(String r1) {
            return (CoordinateSystem) a.a(CoordinateSystem.class, r1);
        }

        public CoordinateSystem(String r1, int r2) {
            super(r1, r2);
        }
    }

    public CoordinateTransformUtils() {
    }

    public static /* synthetic */ void access$000(String r0) {
        System.loadLibrary(r0);
    }

    private static native double[] bd09ToGcj02Native(double r0, double r2);

    private static native double[] gcj02ToBd09Native(double r0, double r2);

    private static native double[] gcj02ToWgs84Native(double r0, double r2);

    private static native double[] wgs84ToGcj02Native(double r0, double r2);

    static {
        INVOKESTATIC_com_obric_cae_libs_location_CoordinateTransformUtils_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("coordinate_transform");
    }

    @JvmStatic
    public static void INVOKESTATIC_com_obric_cae_libs_location_CoordinateTransformUtils_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r4) {
        Intrinsics.checkNotNullParameter(r4, "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> " + r4);
        com.bytedance.librarian.a.c(r4);
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r4);
    }

    public static Location convertLocation(CoordinateSystem r7, CoordinateSystem r8, Location r9) {
        if (r7 == r8) goto L30;
        if (r9 == null) goto L30;
        CoordinateSystem r0 = CoordinateSystem.WGS84;
        if (r7 == r0) goto L8;
    L10:
        CoordinateSystem r3 = CoordinateSystem.GCJ02;
        if (r7 != r3) goto L14;
        if (r8 != r0) goto L14;
        double[] r10 = gcj02ToWgs84Native(r9.getLatitude(), r9.getLongitude());
        a r11 = new a(r10[0], r10[1]);
    L28:
        Location r12 = new Location(r9);
        r12.setLatitude(r11.a);
        r12.setLongitude(r11.b);
        return r12;
    L14:
        CoordinateSystem r4 = CoordinateSystem.BD09;
        if (r7 != r4) goto L18;
        if (r8 != r3) goto L18;
        double[] r13 = bd09ToGcj02Native(r9.getLatitude(), r9.getLongitude());
        r11 = new a(r13[0], r13[1]);
    L18:
        if (r7 != r3) goto L21;
        if (r8 != r4) goto L21;
        double[] r14 = gcj02ToBd09Native(r9.getLatitude(), r9.getLongitude());
        r11 = new a(r14[0], r14[1]);
    L21:
        if (r7 != r0) goto L24;
        if (r8 != r4) goto L24;
        double[] r15 = wgs84ToGcj02Native(r9.getLatitude(), r9.getLongitude());
        double[] r16 = gcj02ToBd09Native(r15[0], r15[1]);
        r11 = new a(r16[0], r16[1]);
    L24:
        if (r7 != r4) goto L27;
        if (r8 != r0) goto L27;
        double[] r17 = bd09ToGcj02Native(r9.getLatitude(), r9.getLongitude());
        double[] r18 = gcj02ToWgs84Native(r17[0], r17[1]);
        r11 = new a(r18[0], r18[1]);
    L27:
        r11 = new a(r9.getLatitude(), r9.getLongitude());
        goto L28
    L8:
        if (r8 != CoordinateSystem.GCJ02) goto L10;
        double[] r19 = wgs84ToGcj02Native(r9.getLatitude(), r9.getLongitude());
        r11 = new a(r19[0], r19[1]);
    L30:
        return r9;
    }
}
