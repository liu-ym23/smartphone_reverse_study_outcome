package com.bytedance.android.live.browser.utils;

import com.bytedance.android.livesdk.config.ti1;
import com.bytedance.android.livesdk.k3;
import com.bytedance.android.livesdk.u;
import com.bytedance.android.livesdk.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h {
    public static void a() {
        Integer r0 = (Integer) u.a.getValue();
        if (r0.intValue() <= 0) goto L6;
        cu2.b.a r1 = cu2.b.c;
        int r2 = r0.intValue();
        r1.getClass();
        cu2.b.a.a(r2);
        return;
    }

    public static void b() {
        if (((Boolean) v.a.getValue()).booleanValue() == false) goto L6;
        cu2.c.a(4, ((ti1) k3.a.getValue()).mTimeoutOpenAnnieContainer);
        return;
    }

    static {
    }
}
