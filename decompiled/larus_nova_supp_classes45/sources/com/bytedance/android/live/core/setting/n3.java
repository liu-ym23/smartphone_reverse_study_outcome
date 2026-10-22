package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n3 extends SSettingKey<Boolean> {
    public static final n3 a = null;

    static {
        a = new n3();
    }

    public n3() {
        Boolean r4 = Boolean.TRUE;
        super("live_opt_get_launch_task_switch_enable", "优化launch task是否延迟执行的开关获取", r4, r4, true);
    }
}
