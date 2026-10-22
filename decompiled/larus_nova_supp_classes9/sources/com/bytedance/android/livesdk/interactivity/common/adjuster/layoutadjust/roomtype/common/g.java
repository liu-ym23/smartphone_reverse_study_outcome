package com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.roomtype.common;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.j;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.k;
import r52.r3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g {
    public static final int a = 0;

    static {
        a = s1.f(((Number) r3.a.getValue()).floatValue() * 1.0f);
    }

    public static k a(int r6) {
        int r0 = a;
        if (r6 >= r0) goto L7;
        j.c.a("right margin " + r6 + " too small, use min right margin");
        return new k(-1, r0, 2);
    L7:
        return new k(-1, r6, 2);
    }
}
