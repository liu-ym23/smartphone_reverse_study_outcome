package com.bytedance.android.live.ktv.common.util;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.ies.utility.SharedPrefHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class t {
    public static final SharedPrefHelper a = null;

    static {
        a = SharedPrefHelper.b(s1.getContext());
    }

    public static String a() {
        StringBuilder r0 = new StringBuilder("KtvRoom");
        IMiddlewareUserService r1 = jc1.k.f(IMiddlewareUserService.class);
        if (r1 == null) goto L8;
        com.bytedance.android.livesdk.user.e r2 = r1.user();
        if (r2 == null) goto L8;
        Object r3 = r2.n();
        if (r3 == null) goto L8;
    L9:
        r0.append(r3);
        return r0.toString();
    L8:
        r3 = 0L;
        goto L9
    }
}
