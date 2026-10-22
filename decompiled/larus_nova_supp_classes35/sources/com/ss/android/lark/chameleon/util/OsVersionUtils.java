package com.ss.android.lark.chameleon.util;

import android.os.Build;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class OsVersionUtils {
    public OsVersionUtils() {
    }

    public static boolean hasIceCreamSandwich() {
        return true;
    }

    public static boolean hasIceCreamSandwichMR1() {
        return true;
    }

    public static boolean hasJellyBean() {
        return true;
    }

    public static boolean hasJellyBeanMR1() {
        return true;
    }

    public static boolean hasJellyBeanMR2() {
        return true;
    }

    public static boolean hasKikat() {
        return true;
    }

    public static boolean hasKikatWatch() {
        return true;
    }

    public static boolean hasLollipop() {
        return true;
    }

    public static boolean hasLollipopMR1() {
        if (Build.VERSION.SDK_INT < 22) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean hasM() {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean hasN() {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean hasNMR1() {
        if (Build.VERSION.SDK_INT < 25) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean hasO() {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean hasO1() {
        if (Build.VERSION.SDK_INT < 27) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean hasPie() {
        if (Build.VERSION.SDK_INT < 28) goto L5;
        return true;
    L5:
        return false;
    }
}
