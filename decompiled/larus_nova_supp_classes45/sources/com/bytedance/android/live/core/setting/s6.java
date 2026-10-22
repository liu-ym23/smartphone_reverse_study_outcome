package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class s6 extends SSettingKey<Boolean> {
    public static final s6 a = null;

    static {
        a = new s6();
    }

    public s6() {
        Boolean r1 = Boolean.TRUE;
        super("multi_link_get_layout_config_from_gecko_opt", "获取多人场景布局配置优化开关", r1, r1);
    }
}
