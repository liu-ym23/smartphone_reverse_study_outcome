package com.lynx.tasm.utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class ColorUtils {
    public ColorUtils() {
    }

    private static native int nativeParse(String r0);

    private static native boolean nativeValidate(String r0);

    public static boolean a(String r1) {
        if (r1 != null) goto L4;
        return false;
    L4:
        if (r1.isEmpty() == false) goto L7;
        return false;
    L7:
        return nativeValidate(r1);
    }

    public static int b(String r1) {
        if (android.text.TextUtils.isEmpty(r1) == false) goto L7;
        return 0;
    L7:
        return nativeParse(r1);
    }
}
