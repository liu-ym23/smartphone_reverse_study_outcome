package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ok extends SSettingKey<Integer> {
    public static final ok a = null;

    public ok() {
        super("live_backend_chunk_sleep_time", "backend卡顿优化，数据分段返回延迟时间", 0, 0);
    }

    static {
        a = new ok();
    }
}
