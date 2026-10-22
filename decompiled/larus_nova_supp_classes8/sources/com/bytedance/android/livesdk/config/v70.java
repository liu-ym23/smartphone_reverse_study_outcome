package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.setting.LiveMainThreadScheduleConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class v70 extends SSettingKey<LiveMainThreadScheduleConfig> {
    public static final v70 a = null;

    static {
        a = new v70();
    }

    public v70() {
        super("live_main_thread_jato_schedule_opt", "直播主线程优化", new LiveMainThreadScheduleConfig(), new LiveMainThreadScheduleConfig());
    }
}
