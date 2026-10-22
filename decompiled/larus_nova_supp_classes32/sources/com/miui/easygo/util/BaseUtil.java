package com.miui.easygo.util;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
class BaseUtil {
    public BaseUtil() {
    }

    public static boolean isNullOrEmpty(String[] r4) {
        if (r4 == null) goto L19;
        int r2 = 0;
    L6:
        if (r2 >= r4.length) goto L14;
        String r3 = r4[r2];
        if (r3 == null) goto L13;
        if (r3.isEmpty() == true) goto L13;
        r2 = r2 + 1;
    L13:
        return true;
    L14:
        return false;
    L19:
        return true;
    }
}
