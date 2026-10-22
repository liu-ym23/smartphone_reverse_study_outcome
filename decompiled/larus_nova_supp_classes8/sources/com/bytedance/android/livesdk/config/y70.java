package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class y70 extends SSettingKey<Integer> {
    public static final y70 a = null;

    public y70() {
        super("live_mcu_fallback_protect_time", "跨房厅战MCU公共流拉流失败兜底超时时间", 3, 3);
    }

    static {
        a = new y70();
    }
}
