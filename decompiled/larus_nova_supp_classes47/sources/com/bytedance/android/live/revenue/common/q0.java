package com.bytedance.android.live.revenue.common;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class q0 {
    public static final String a(Throwable r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$errorMsg");
        String r0 = r1.getMessage();
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L12;
        return r1.toString();
    L12:
        return r1.getMessage();
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L9
    }
}
