package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class qc extends SSettingKey<Boolean> {
    public static final qc a = null;

    static {
        a = new qc();
    }

    public qc() {
        Boolean r1 = Boolean.TRUE;
        super("live_anchor_room_dynamic_strategy_post_enable", "主播侧进房稳定模式setOnce是否post", r1, r1);
    }
}
