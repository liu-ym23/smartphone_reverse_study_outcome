package org.apache.poi.util;

/* JADX INFO: loaded from: classes7.dex */
public class Units {
    public static int charactersToEMU(double r0) {
        return ((int) r0) * 66691;
    }

    public static int columnWidthToEMU(int r4) {
        return charactersToEMU(((double) r4) / 256.0d);
    }

    public static double masterToPoints(int r4) {
        return (((double) r4) * 72.0d) / 576.0d;
    }

    public static double pixelToPoints(double r2) {
        return (r2 * 72.0d) / 96.0d;
    }

    public static int toEMU(double r2) {
        return (int) Math.rint(r2 * 12700.0d);
    }

    public static double toPoints(long r2) {
        if (r2 != (-1)) goto L6;
        return -1.0d;
    L6:
        return r2 / 12700.0d;
    }
}
