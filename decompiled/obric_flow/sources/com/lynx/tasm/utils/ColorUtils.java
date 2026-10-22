package com.lynx.tasm.utils;

/* JADX INFO: loaded from: classes2.dex */
public class ColorUtils {
    public static boolean a(String r5) {
        if (r5 != null) goto L4;
        return false;
    L4:
        if (r5.isEmpty() == false) goto L7;
        return false;
    L7:
        return nativeValidate(r5);
    }

    public static int b(String r5) {
        if (android.text.TextUtils.isEmpty(r5) == false) goto L7;
        return 0;
    L7:
        return nativeParse(r5);
    }

    private static native int nativeParse(String r5);

    private static native boolean nativeValidate(String r5);
}
