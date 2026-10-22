package com.bytedance.android.live.recharge.utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class q {
    public static final String a(long r7) {
        if ((r7 % 100) == 0) goto L5;
        Object[] r0 = new Object[1];
        if (r7 > 0) goto L9;
        float r8 = 0.0f;
    L10:
        r0[0] = Float.valueOf(r8);
        return com.bytedance.android.live.revenue.common.l.a("%.1f", r0);
    L9:
        r8 = r7 / 100.0f;
        goto L10
    L5:
        return String.valueOf(r7 / 100);
    }

    public static final String b(long r7) {
        if ((r7 % 100) == 0) goto L5;
        Object[] r0 = new Object[1];
        if (r7 > 0) goto L9;
        float r8 = 0.0f;
    L10:
        r0[0] = Float.valueOf(r8);
        return com.bytedance.android.live.revenue.common.l.a("%.2f", r0);
    L9:
        r8 = r7 / 100.0f;
        goto L10
    L5:
        return String.valueOf(r7 / 100);
    }
}
