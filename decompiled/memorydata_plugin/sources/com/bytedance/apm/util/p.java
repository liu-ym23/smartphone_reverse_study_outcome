package com.bytedance.apm.util;

import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f1497a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f1498b = false;
    private static final CharSequence c = null;
    private static final CharSequence d = null;
    private static final CharSequence e = null;

    static {
        c = "sony";
        d = "amigo";
        e = "funtouch";
    }

    public static boolean a() {
        if (TextUtils.isEmpty(Build.BRAND) == true) goto L9;
        if (Build.BRAND.toLowerCase().startsWith("hua") == false) goto L9;
    L12:
        return true;
    L9:
        if (TextUtils.isEmpty(Build.MANUFACTURER) == true) goto L17;
        if (Build.MANUFACTURER.toLowerCase().startsWith("hua") == true) goto L12;
        return false;
    L17:
        return false;
    L19:
        return false;
    }
}
