package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class bo0 extends SSettingKey<Boolean> {
    public static final bo0 a = null;

    static {
        a = new bo0();
    }

    public bo0() {
        super("live_room_controller_cost_time_monitor", "进房controller耗时", Boolean.FALSE, Boolean.TRUE, true);
    }
}
