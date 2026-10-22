package com.bytedance.android.live.core.utils;

import android.util.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c1 {
    public static String a(long r14) {
        if (r14 >= 10000) goto L7;
        return String.valueOf(r14);
    L7:
        if (r14 >= 100000000) goto L14;
        long r15 = (r14 * 10) / 10000;
        if ((r15 % 10) != 0) goto L11;
        String r16 = (r15 / 10) + "";
    L13:
        return r16 + "万";
    L11:
        r16 = FormatUtils.format("%.1f", new Object[]{Float.valueOf(r15 / 10.0f)});
        goto L13
    L14:
        long r17 = (r14 * 10) / 100000000;
        if ((r17 % 10) != 0) goto L17;
        String r18 = (r17 / 10) + "";
    L19:
        return r18 + "亿";
    L17:
        r18 = FormatUtils.format("%.1f", new Object[]{Float.valueOf(r17 / 10.0f)});
        goto L19
    }

    public static Pair<String, String> b(long r14) {
        if (r14 >= 10000) goto L7;
        return new Pair(String.valueOf(r14), "");
    L7:
        if (r14 >= 100000000) goto L14;
        long r15 = (r14 * 10) / 10000;
        if ((r15 % 10) != 0) goto L11;
        String r16 = (r15 / 10) + "";
    L13:
        return new Pair(r16, "万");
    L11:
        r16 = FormatUtils.format("%.1f", new Object[]{Float.valueOf(r15 / 10.0f)});
        goto L13
    L14:
        long r17 = (r14 * 10) / 100000000;
        if ((r17 % 10) != 0) goto L17;
        String r18 = (r17 / 10) + "";
    L19:
        return new Pair(r18, "亿");
    L17:
        r18 = FormatUtils.format("%.1f", new Object[]{Float.valueOf(r17 / 10.0f)});
        goto L19
    }
}
