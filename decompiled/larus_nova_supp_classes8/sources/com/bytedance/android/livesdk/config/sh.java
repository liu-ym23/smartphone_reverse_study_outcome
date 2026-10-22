package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class sh extends SSettingKey<Boolean> {
    public static final sh a = null;

    static {
        a = new sh();
    }

    public sh() {
        Boolean r4 = Boolean.TRUE;
        super("live_broadcast_red_packet_bug_fix_enable", "主播群红包", r4, r4, true);
    }
}
