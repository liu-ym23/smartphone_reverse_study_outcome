package com.bytedance.framwork.core.sdkmonitor;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f2018a;

    public static String a(Context r10) {
        if (f2018a != null) goto L6;
        String r11 = l3.d.a(r10).replace(r10.getPackageName(), "p").replace(":", "_");
        f2018a = r11;
        f2018a = r11.replace(".", "_");
    L6:
        return f2018a;
    }
}
