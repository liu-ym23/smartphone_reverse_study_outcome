package com.bytedance.android.livesdk.gift.platform.core.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class z {
    static {
    }

    public static String a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "name");
        return r1.concat("_all");
    }

    public static String b(String r1) {
        Intrinsics.checkNotNullParameter(r1, "name");
        return r1.concat("_error");
    }
}
