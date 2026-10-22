package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class mg extends SettingKey<Boolean> {
    public static final mg a = null;

    static {
        a = new mg();
    }

    public mg() {
        Boolean r1 = Boolean.TRUE;
        super("live_block_shop_entrance_landscope", "横屏下屏蔽电商入口", r1, r1);
    }
}
