package com.bytedance.retrofit2;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static int f2726a = 4;

    static {
    }

    public static void a(String r10, String r11) {
        if (r11 != null) goto L5;
        return;
    L5:
        if (f2726a > 3) goto L8;
        Log.d(r10, r11);
        return;
    }

    public static void b(int r10) {
        f2726a = r10;
    }
}
