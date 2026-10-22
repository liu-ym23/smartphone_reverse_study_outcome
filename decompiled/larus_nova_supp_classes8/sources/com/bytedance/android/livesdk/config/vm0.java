package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.setting.LiveRenderThreadScheduleConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class vm0 extends SSettingKey<LiveRenderThreadScheduleConfig> {
    public static final vm0 a = null;

    static {
        a = new vm0();
    }

    public vm0() {
        super("live_render_thread_jato_schedule_opt", "直播渲染线程优化", new LiveRenderThreadScheduleConfig(), new LiveRenderThreadScheduleConfig());
    }
}
