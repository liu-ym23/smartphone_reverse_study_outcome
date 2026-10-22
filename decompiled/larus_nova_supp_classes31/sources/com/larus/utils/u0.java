package com.larus.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class u0 {
    public static final String a(Throwable r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        StringBuilder r0 = new StringBuilder();
        String r1 = r5.getMessage();
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0.append(r1);
        r0.append("\n");
        StackTraceElement[] r6 = r5.getStackTrace();
        int r2 = r6.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L9;
        r0.append(r6[r3].toString());
        r0.append("\n");
        r3 = r3 + 1;
        goto L6
    L9:
        return r0.toString();
    }
}
