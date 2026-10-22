package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class z70 extends SSettingKey<Integer> {
    public static final z70 a = null;

    public z70() {
        super("live_mcu_play_failed_retry_times", "跨房厅战MCU公共流拉流失败重试次数", 2, 2);
    }

    static {
        a = new z70();
    }
}
