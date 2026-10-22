package com.bytedance.android.annie.lynx;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e {
    public static d8.b a;
    public static volatile boolean b;
    public static String c;

    static {
        c = "";
    }

    public static d8.b a() {
        d8.b r0 = a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("lynxConfig");
        return null;
    }
}
