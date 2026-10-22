package com.larus.uaigc.chat.markdown.helper;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class k1 {
    public static final boolean a(View r8) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        long r0 = System.currentTimeMillis();
        Object r3 = r8.getTag(123450001);
        if ((r3 instanceof Long) == false) goto L5;
        Long r4 = (Long) r3;
    L6:
        if (r4 == null) goto L8;
        long r5 = r4.longValue();
    L10:
        if ((r0 - r5) >= 500) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == true) goto L15;
        r8.setTag(123450001, Long.valueOf(r0));
    L15:
        return r6;
    L12:
        r6 = false;
        goto L13
    L8:
        r5 = 0;
        goto L10
    L5:
        r4 = null;
        goto L6
    }
}
