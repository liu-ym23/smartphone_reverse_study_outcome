package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f0 extends SSettingKey<Boolean> {
    public static final f0 a = null;

    static {
        a = new f0();
    }

    public f0() {
        Boolean r4 = Boolean.FALSE;
        super("live_component_scheduler_visibility_enable", "旧调度器组件同时显隐控制是否生效", r4, r4, false);
    }
}
