package com.bytedance.android.live.revenue.common;

import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(long r6) {
        if (r6 < 10000000) goto L6;
        StringBuilder r0 = new StringBuilder();
        StringCompanionObject r1 = StringCompanionObject.INSTANCE;
        r0.append(String.format(Locale.US, "%.0f", Arrays.copyOf(new Object[]{Double.valueOf((r6 * 1.0d) / ((double) 10000))}, 1)));
        r0.append("万");
        return r0.toString();
    L6:
        return String.valueOf(r6);
    }
}
