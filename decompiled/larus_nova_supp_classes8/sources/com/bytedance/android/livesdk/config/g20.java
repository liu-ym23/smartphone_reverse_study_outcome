package com.bytedance.android.livesdk.config;

import android.os.Build;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g20 extends SSettingKey<Boolean> {
    public static final g20 a = null;

    static {
        a = new g20();
    }

    public g20() {
        if (Build.VERSION.SDK_INT <= 29) goto L5;
        boolean r0 = true;
    L6:
        super("live_interaction_fragment_add", "在Android10及以下版本是否同步：修复Android11黑屏花屏将添加fragment的方式从show换成了add", Boolean.valueOf(r0), Boolean.TRUE);
        return;
    L5:
        r0 = false;
        goto L6
    }
}
