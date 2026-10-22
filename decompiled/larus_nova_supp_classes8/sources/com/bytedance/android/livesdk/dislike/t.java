package com.bytedance.android.livesdk.dislike;

import com.bytedance.android.livesdk.config.k70;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class t {
    public static boolean a() {
        Integer r0 = k70.a.getValue();
        if (r0 != null) goto L6;
    L7:
        if (r0 != null) goto L10;
    L12:
        return false;
    L10:
        if (r0.intValue() != 2) goto L12;
        return true;
    L6:
        if (r0.intValue() != 1) goto L7;
        return true;
    }

    public static boolean b() {
        Integer r0 = k70.a.getValue();
        if (r0 != null) goto L6;
    L8:
        return false;
    L6:
        if (r0.intValue() != 1) goto L8;
        return true;
    }

    public static boolean c() {
        Integer r0 = k70.a.getValue();
        if (r0 != null) goto L6;
    L8:
        return false;
    L6:
        if (r0.intValue() != 2) goto L8;
        return true;
    }

    static {
    }
}
