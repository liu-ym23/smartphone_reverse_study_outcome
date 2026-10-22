package com.larksuite.framework.utils;

import android.os.Build;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class x {
    public x() {
    }

    public static boolean a() {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean b() {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean c() {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        return true;
    L5:
        return false;
    }
}
