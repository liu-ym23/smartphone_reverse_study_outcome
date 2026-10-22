package com.bytedance.android.live.revenue.common;

import kotlin.text.CharsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class t {
    public static final String a(Object r1) {
        if (r1 == null) goto L4;
        int r2 = r1.hashCode();
    L6:
        return Integer.toString(r2, CharsKt.checkRadix(16));
    L4:
        r2 = 0;
        goto L6
    }
}
