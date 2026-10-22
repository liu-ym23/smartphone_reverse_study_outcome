package com.bytedance.android.live.revenue.common;

import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l {
    public static final String a(String r2, Object... r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$formatWithUsLocale");
        Intrinsics.checkNotNullParameter(r3, "args");
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;     // Catch: Throwable -> L5
        Locale r1 = Locale.US;     // Catch: Throwable -> L5
        Object[] r4 = Arrays.copyOf(r3, r3.length);     // Catch: Throwable -> L5
        return String.format(r1, r2, Arrays.copyOf(r4, r4.length));
    L5:
        return "";
    }
}
