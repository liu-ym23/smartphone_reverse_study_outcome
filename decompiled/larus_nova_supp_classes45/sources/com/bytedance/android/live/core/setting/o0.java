package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class o0 extends SSettingKey<Boolean> {
    public static final o0 a = null;

    static {
        a = new o0();
    }

    public o0() {
        Boolean r1 = Boolean.FALSE;
        super("live_dynamic_container_life_cycle_opt", "动态化架构优化-容器加载提前", r1, r1);
    }
}
