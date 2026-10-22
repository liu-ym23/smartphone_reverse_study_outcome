package com.ss.android.lark.chameleonv2.container.webcontainer.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.officesdk.utils.di.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d {
    public static final long a = 0;

    public d() {
    }

    static {
        int r0 = com.ss.android.lark.officesdk.utils.di.d.a;
        Resources r1 = com.ss.android.lark.officesdk.utils.di.d.a.a().getResources();
        DisplayMetrics r2 = WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
        a = (((long) r2.widthPixels) * ((long) r2.heightPixels)) * 4;
    }

    public static boolean a() {
        long r0 = a + ((long) 10485760);
        Runtime r2 = Runtime.getRuntime();
        long r3 = r2.freeMemory();
        long r5 = r2.totalMemory();
        long r7 = r2.maxMemory();
        long r9 = r7 - (r5 - r3);
        j.a("CML_TAG_MemoryUtils", "isAppHeapLow, free: " + r3 + ", total: " + r5 + ", max: " + r7 + ", remain: " + r9 + ", requiredBytes: " + r0);
        if (r9 >= r0) goto L5;
        return true;
    L5:
        return false;
    }
}
