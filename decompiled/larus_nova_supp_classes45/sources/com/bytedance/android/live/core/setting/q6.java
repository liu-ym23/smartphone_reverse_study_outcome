package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class q6 extends SSettingKey<Boolean> {
    public static final q6 a = null;

    static {
        a = new q6();
    }

    public q6() {
        Boolean r1 = Boolean.TRUE;
        super("multi_link_fresco_cache_leak_fix", "Fresco私有缓存泄漏修复(Bugfix,不开实验)", r1, r1);
    }
}
