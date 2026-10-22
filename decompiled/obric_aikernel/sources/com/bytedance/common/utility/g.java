package com.bytedance.common.utility;

/* JADX INFO: loaded from: classes.dex */
public final class g {
    public static boolean a(String r10, String r11) {
        if (b(r10) == true) goto L5;
    L6:
        if (r10 != null) goto L8;
    L10:
        return false;
    L8:
        if (r10.equals(r11) == false) goto L10;
    L9:
        return true;
    L5:
        if (b(r11) == true) goto L9;
        goto L6
    }

    public static boolean b(String r10) {
        if (r10 != null) goto L4;
        return true;
    L4:
        if (r10.length() == 0) goto L10;
        return false;
    L10:
        return true;
    }
}
