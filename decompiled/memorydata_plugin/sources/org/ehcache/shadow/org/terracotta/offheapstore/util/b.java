package org.ehcache.shadow.org.terracotta.offheapstore.util;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.NpthBus;
import com.tom_roush.pdfbox.pdmodel.a.d.i;

/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f18140a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f18141b = null;
    private static final long[] c = null;

    static {
        String[] r0 = {"", "k", "M", NpthBus.UUID_SUFIX_3_1_3, ExifInterface.GPS_DIRECTION_TRUE, i.m, ExifInterface.LONGITUDE_EAST};
        f18140a = r0;
        f18141b = new String[]{"", "K", "M", NpthBus.UUID_SUFIX_3_1_3, ExifInterface.GPS_DIRECTION_TRUE, i.m, ExifInterface.LONGITUDE_EAST};
        c = new long[r0.length];
        int r1 = 0;
    L4:
        if (r1 >= c.length) goto L9;
        long r2 = 1;
        int r4 = 0;
    L6:
        if (r4 >= r1) goto L8;
        r2 = r2 * 1000;
        r4 = r4 + 1;
        goto L6
    L8:
        c[r1] = r2;
        r1 = r1 + 1;
        goto L4
    }

    public static String a(long r9) {
        if (r9 > 0) goto L5;
    L9:
        int r2 = (63 - Long.numberOfLeadingZeros(r9)) / 10;
        long r3 = 1 << (r2 * 10);
        long r5 = r9 / r3;
        long r7 = r3 / 10;
        if (r7 != 0) goto L12;
        StringBuilder r10 = new StringBuilder().append(r5);
        String r11 = f18141b[r2];
    L8:
        return r10.append(r11).toString();
    L12:
        StringBuilder r0 = new StringBuilder().append(r5).append(".");
        r10 = r0.append((r9 - (r3 * r5)) / r7);
        r11 = f18141b[r2];
        goto L8
    L5:
        if (Long.bitCount(r9) != 1) goto L9;
        int r1 = Long.numberOfTrailingZeros(Math.abs(r9)) / 10;
        r10 = new StringBuilder().append(r9 >> (r1 * 10));
        r11 = f18141b[r1];
        goto L8
    }
}
