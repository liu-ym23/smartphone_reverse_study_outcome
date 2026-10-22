package com.bytedance.common.utility;

import android.content.Context;
import android.util.DisplayMetrics;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f1271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f1272b;

    public static class a {
        public a() {
        }
    }

    static {
        f1271a = "";
        f1272b = -1;
        new a();
    }

    public static int a(Context r10) {
        if (f1272b != (-1)) goto L7;
        if (r10 == null) goto L7;
        f1272b = r10.getApplicationContext().getResources().getDisplayMetrics().densityDpi;
    L7:
        return f1272b;
    }

    public static int b(Context r10) {
        if (r10 != null) goto L5;
        return 0;
    L5:
        DisplayMetrics r11 = r10.getResources().getDisplayMetrics();
        if (r11 != null) goto L9;
        return 0;
    L9:
        return r11.heightPixels;
    }

    public static String c(Context r10) {
        if (g.b(f1271a) == false) goto L10;
        if (r10 == null) goto L10;
        int r11 = d(r10);
        int r12 = b(r10);
        if (r11 <= 0) goto L10;
        if (r12 <= 0) goto L10;
        f1271a = r11 + "*" + r12;
    L10:
        return f1271a;
    }

    public static int d(Context r10) {
        if (r10 != null) goto L5;
        return 0;
    L5:
        DisplayMetrics r11 = r10.getResources().getDisplayMetrics();
        if (r11 != null) goto L9;
        return 0;
    L9:
        return r11.widthPixels;
    }
}
