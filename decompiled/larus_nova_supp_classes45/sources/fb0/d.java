package fb0;

import android.os.Build;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d {
    public static final long[] a = null;

    static {
        a = new long[256];
        String r1 = Build.TYPE;
        if (r1.equals("eng") == true) goto L5;
        r1.equals("userdebug");
    L5:
        int r2 = 0;
    L6:
        if (r2 >= 256) goto L16;
        long r3 = r2;
        int r5 = 0;
    L9:
        if (r5 >= 8) goto L15;
        if ((((int) r3) & 1) == 0) goto L13;
        long r8 = -7661587058870466123L;
    L14:
        r3 = (r3 >> 1) ^ r8;
        r5 = r5 + 1;
        goto L9
    L13:
        r8 = 0;
        goto L14
    L15:
        a[r2] = r3;
        r2 = r2 + 1;
        goto L6
    }

    public static int a(int r3) {
        if (r3 <= 0) goto L8;
        if (r3 > 1073741824) goto L8;
        int r4 = r3 - 1;
        int r5 = r4 | (r4 >> 16);
        int r6 = r5 | (r5 >> 8);
        int r7 = r6 | (r6 >> 4);
        int r8 = r7 | (r7 >> 2);
        return (r8 | (r8 >> 1)) + 1;
    L8:
        throw new IllegalArgumentException("n is invalid: " + r3);
    }
}
