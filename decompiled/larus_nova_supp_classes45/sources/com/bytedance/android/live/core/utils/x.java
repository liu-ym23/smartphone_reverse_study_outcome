package com.bytedance.android.live.core.utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class x {
    public static String a(long r5) {
        if (r5 != (-1)) goto L7;
        return "---";
    L7:
        if (r5 >= 10000) goto L11;
        return String.valueOf(r5);
    L11:
        if (r5 >= 100000000) goto L15;
        return com.bytedance.android.livesdk.utils.r1.a(Double.valueOf((r5 * 1.0d) / 10000.0d)) + "万";
    L15:
        return com.bytedance.android.livesdk.utils.r1.a(Double.valueOf((r5 * 1.0d) / 1.0E8d)) + "亿";
    }

    public static String b(long r4) {
        if (r4 >= 10000) goto L6;
        return String.valueOf(r4);
    L6:
        return com.bytedance.android.livesdk.utils.r1.b("%.1f", new Object[]{Double.valueOf((r4 * 1.0d) / 10000.0d)}) + "w";
    }

    public static String c(long r8) {
        if (r8 < 100000000) goto L7;
        return com.bytedance.android.livesdk.utils.r1.b("%.1f", new Object[]{Double.valueOf((r8 * 1.0d) / 1.0E8d)}) + "亿";
    L7:
        if (r8 < 10000) goto L11;
        return com.bytedance.android.livesdk.utils.r1.b("%.1f", new Object[]{Double.valueOf((r8 * 1.0d) / 10000.0d)}) + "万";
    L11:
        return String.valueOf(r8);
    }
}
