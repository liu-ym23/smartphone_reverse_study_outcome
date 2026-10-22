package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class r6 extends SSettingKey<Boolean> {
    public static final r6 a = null;

    static {
        a = new r6();
    }

    public r6() {
        Boolean r1 = Boolean.TRUE;
        super("multi_link_fresco_cache_leak_opt", "Fresco私有缓存泄漏优化(优化,开实验)", r1, r1);
    }
}
