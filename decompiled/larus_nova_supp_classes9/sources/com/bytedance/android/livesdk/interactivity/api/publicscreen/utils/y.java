package com.bytedance.android.livesdk.interactivity.api.publicscreen.utils;

import com.bytedance.android.live.core.utils.s1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class y {
    public static final int a = 0;
    public static final int b = 0;
    public static final int c = 0;

    static {
        a = s1.f(195.0f);
        b = s1.f(165.0f);
        c = s1.f(180.0f);
    }

    public static final int a() {
        double r0 = (s1.y() * 1.0f) / s1.w();
        if (r0 < 0.56d) goto L7;
        return b;
    L7:
        if (r0 < 0.5d) goto L10;
        return c;
    L10:
        return a;
    }
}
