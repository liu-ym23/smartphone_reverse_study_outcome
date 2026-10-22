package com.bytedance.android.livesdk.gift.platform.core.utils;

import com.bytedance.live.kmp.core.KmpEnv;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class t {
    public static final boolean a() {
        KmpEnv r0 = KmpEnv.a;
        if (KmpEnv.a() == true) goto L6;
        return false;
    L6:
        return ((Boolean) com.bytedance.android.livesdk.gift.platform.core.h.K.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.a[35])).booleanValue();
    }

    public static final boolean b() {
        if (((com.bytedance.android.livesdk.gift.platform.business.config.n) com.bytedance.android.livesdk.gift.util.b.a().d(com.bytedance.android.livesdk.gift.platform.business.config.n.class)).f() == 1) goto L7;
        return false;
    L7:
        return true;
    }
}
