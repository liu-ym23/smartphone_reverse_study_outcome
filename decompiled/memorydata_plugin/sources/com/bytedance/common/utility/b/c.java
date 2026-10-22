package com.bytedance.common.utility.b;

import com.bytedance.common.utility.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f1976a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static b f1977b;

    static {
        f1977b = new b();
    }

    public static String a(String r3) {
        if (f1976a == false) goto L9;
        return f1977b.a(r3);
    L6:
        th = move-exception;
        Logger.e("SystemPropertiesUtils", "android.os.SystemProperties reflect fail.", th);
    L9:
        return a.a(r3);
    }
}
