package com.bytedance.awemeopen.infra.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public k() {
    }

    public static String b(long r7) {
        Intrinsics.checkNotNullParameter("万", "k10");
        Intrinsics.checkNotNullParameter("亿", "million100");
        if (r7 >= 0) goto L6;
        return "0";
    L6:
        if (r7 >= 10000) goto L9;
        return String.valueOf(r7);
    L9:
        if (r7 >= 100000000) goto L15;
        String r0 = "1.0亿";
        String r8 = a(r7, 10000, "");
        if (Intrinsics.areEqual(r8, "10000.0") == false) goto L19;
        return r0;
    L19:
        return r8 + "万";
    L15:
        return a(r7, 100000000, "亿");
    }

    public static String a(long r1, long r3, String r5) {
        return new BigDecimal(r1).divide(new BigDecimal(r3), 1, RoundingMode.HALF_UP).toString() + r5;
    }
}
