package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class u6 extends SSettingKey<Boolean> {
    public static final u6 a = null;

    static {
        a = new u6();
    }

    public u6() {
        Boolean r1 = Boolean.FALSE;
        super("pk_status_bar_opt", "PK沉浸式优化", r1, r1);
    }
}
