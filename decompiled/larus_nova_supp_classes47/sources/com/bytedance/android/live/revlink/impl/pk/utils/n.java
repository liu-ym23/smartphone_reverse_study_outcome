package com.bytedance.android.live.revlink.impl.pk.utils;

import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.revenue.common.b0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n {
    public static boolean a() {
        if (e51.b.d.a() == false) goto L26;
        int r0 = com.bytedance.android.live.revlink.impl.utils.c.a;
        float r1 = ((Number) b0.d.getValue(null, b0.a[2])).floatValue();
        if (r1 <= 0) goto L8;
        d51.c r2 = d51.c.A0;
        r2.getClass();
        if (r1 >= ((Number) d51.c.g.getValue(r2, d51.c.a[5])).floatValue()) goto L8;
    L22:
        boolean r3 = false;
    L23:
        if (r3 == false) goto L27;
        return true;
    L27:
        return false;
    L8:
        d51.c r4 = d51.c.A0;
        r4.getClass();
        if (((Boolean) d51.c.i.getValue(r4, d51.c.a[7])).booleanValue() == false) goto L22;
        if (PadConfigUtils.c() == false) goto L13;
    L18:
        boolean r5 = true;
    L19:
        if (r5 == true) goto L22;
        r3 = true;
        goto L23
    L13:
        if (PadConfigUtils.c() == true) goto L18;
        if (FoldScreenUtils.f() == true) goto L18;
        r5 = false;
        goto L19
    L26:
        return false;
    }

    static {
    }
}
