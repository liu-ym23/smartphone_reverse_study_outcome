package com.bytedance.android.livesdk.config;

import com.bytedance.android.livehostapi.business.multitask.LiveIndependentConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g10 extends SSettingKey<LiveIndependentConfig> {
    public static final g10 a = null;

    static {
        a = new g10();
    }

    public g10() {
        super("live_inner_independent_task_config_list", "直播独立任务名单配置", new LiveIndependentConfig(), new LiveIndependentConfig(), true);
    }
}
