package com.bytedance.android.ec.core.opt.ab;

import com.bytedance.android.ec.sdk.ECSdk;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public static boolean a() {
        if (ECSdk.c() == false) goto L9;
        nj.d r0 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r0 == null) goto L10;
        r0.h();
        return false;
    L10:
        return false;
    L9:
        return false;
    }

    static {
    }
}
