package com.lynx.tasm.utils;

import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b {
    public b() {
    }

    public static float b(float r3) {
        if (r3 < (-3.4028235E38f)) goto L8;
        if (r3 > Float.MAX_VALUE) goto L8;
        return r3;
    L8:
        if (r3 >= (-3.4028235E38f)) goto L10;
    L23:
        return -3.4028235E38f;
    L10:
        if (r3 == Float.NEGATIVE_INFINITY) goto L23;
        if (r3 <= Float.MAX_VALUE) goto L15;
    L22:
        return Float.MAX_VALUE;
    L15:
        if (r3 == Float.POSITIVE_INFINITY) goto L22;
        if (Float.isNaN(r3) == false) goto L20;
        return 0.0f;
    L20:
        LLog.w("lynx", "Invalid float property value: " + r3);
        return 0.0f;
    }

    public static boolean a(float r3, float r4) {
        if (Float.isNaN(r3) == true) goto L13;
        if (Float.isNaN(r4) == true) goto L13;
        if (Math.abs(r4 - r3) < 1.0E-5f) goto L19;
        return false;
    L19:
        return true;
    L13:
        if (Float.isNaN(r3) == true) goto L15;
    L17:
        return false;
    L15:
        if (Float.isNaN(r4) == false) goto L17;
        return true;
    }
}
