package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class pq extends SSettingKey<Boolean> {
    public static final pq a = null;

    static {
        a = new pq();
    }

    public pq() {
        Boolean r1 = Boolean.FALSE;
        super("live_enable_anchor_long_press_record", "主播侧录屏长按开关", r1, r1);
    }
}
