package com.larus.dora.obric.device_management.setting.earbuds;

import android.os.SystemClock;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class k {
    public static boolean a(View r8) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        long r0 = SystemClock.elapsedRealtime();
        Object r3 = r8.getTag(123400002);
        if ((r3 instanceof Long) == false) goto L5;
        Long r4 = (Long) r3;
    L6:
        if (r4 == null) goto L8;
        long r5 = r4.longValue();
    L10:
        if ((r0 - r5) >= 500) goto L12;
        return true;
    L12:
        r8.setTag(123400002, Long.valueOf(r0));
        return false;
    L8:
        r5 = 0;
        goto L10
    L5:
        r4 = null;
        goto L6
    }
}
