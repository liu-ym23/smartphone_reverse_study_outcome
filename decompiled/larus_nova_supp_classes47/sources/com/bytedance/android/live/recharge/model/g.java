package com.bytedance.android.live.recharge.model;

import com.bytedance.android.live.recharge.utils.t;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g {
    public static final RechargePanelDynamicConfig a = null;

    static {
        a = (RechargePanelDynamicConfig) t.b.getValue(null, t.a[0]);
    }

    public static final boolean a(RechargePanelDynamicConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$isAvailable");
        if (r2.getEnable() == true) goto L5;
        return false;
    L5:
        if (r2.getScheme().length() <= 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r3 = false;
        goto L8
    }
}
