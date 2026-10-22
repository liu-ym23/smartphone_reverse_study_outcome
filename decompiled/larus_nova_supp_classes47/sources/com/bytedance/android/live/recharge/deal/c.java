package com.bytedance.android.live.recharge.deal;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public static final long a = 0;

    static {
        a = com.bytedance.android.live.recharge.model.g.a.e3();
    }

    public static final boolean a(a r8) {
        if (r8 != null) goto L5;
        return false;
    L5:
        com.bytedance.live.kmp.util.c r1 = com.bytedance.live.kmp.util.c.a;
        if ((System.currentTimeMillis() - r8.c) >= a) goto L8;
        boolean r2 = true;
    L10:
        if (r8.b.o() == 0) goto L12;
        boolean r3 = true;
    L14:
        if (r8.a.c > 0) goto L16;
        boolean r9 = true;
    L17:
        if (r2 == false) goto L22;
        if (r3 == false) goto L23;
        if (r9 == false) goto L24;
        return true;
    L24:
        return false;
    L23:
        return false;
    L22:
        return false;
    L16:
        r9 = false;
        goto L17
    L12:
        r3 = false;
        goto L14
    L8:
        r2 = false;
        goto L10
    }
}
