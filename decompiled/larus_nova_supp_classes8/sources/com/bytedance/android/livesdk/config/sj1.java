package com.bytedance.android.livesdk.config;

import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class sj1 {
    @JvmStatic
    public static final boolean b(int r2) {
        if (r2 != 1) goto L5;
        return true;
    L5:
        if (r2 != 8) goto L7;
        return true;
    L7:
        if (r2 != 12) goto L9;
        return true;
    L9:
        if (r2 == 16) goto L15;
        return false;
    L15:
        return true;
    }

    @JvmStatic
    public static final boolean c() {
        return ((Boolean) com.bytedance.android.livesdk.l4.a.getValue()).booleanValue();
    }

    static {
    }

    @JvmStatic
    public static final boolean a(int r2, boolean r3) {
        if (c() == true) goto L5;
        return false;
    L5:
        if (r3 == true) goto L7;
    L9:
        boolean r4 = false;
    L10:
        if (r4 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (b(r2) == false) goto L9;
        r4 = true;
        goto L10
    }

    @JvmStatic
    public static final int d(int r0, boolean r1) {
        if (a(r0, r1) == true) goto L5;
    L11:
        return 2;
    L5:
        if (((Boolean) com.bytedance.android.live.core.setting.b6.g.getValue()).booleanValue() == false) goto L11;
        if (((Boolean) com.bytedance.android.live.core.setting.b6.h.getValue()).booleanValue() == false) goto L11;
        if (us1.d.b(false, true) == false) goto L11;
        return 1;
    }
}
