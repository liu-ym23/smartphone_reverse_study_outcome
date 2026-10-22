package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class tn0 extends SSettingKey<Boolean> {
    public static final tn0 a = null;

    static {
        a = new tn0();
    }

    public tn0() {
        Boolean r1 = Boolean.TRUE;
        super("live_room_battle_enable_rtc_mcu", "跨房厅战使用mcu方案", r1, r1);
    }
}
