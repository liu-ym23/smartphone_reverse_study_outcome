package com.google.common.base;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j {
    public j() {
    }

    public static j compile(String r5) {
        com.bytedance.sdk.xbridge.cn.auth.g r10 = y.f8677a;
        r5.getClass();
        y.f8677a.getClass();
        return new JdkPattern(Pattern.compile(r5));
    }

    public static boolean isPcreLike() {
        y.f8677a.getClass();
        return true;
    }

    public abstract int flags();

    public abstract i matcher(CharSequence r5);

    public abstract String pattern();
}
