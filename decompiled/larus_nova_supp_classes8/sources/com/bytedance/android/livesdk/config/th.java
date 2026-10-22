package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class th extends SSettingKey<Boolean> {
    public static final th a = null;

    static {
        a = new th();
    }

    public th() {
        Boolean r4 = Boolean.TRUE;
        super("live_broadcast_red_packet_enable", "主播群红包", r4, r4, true);
    }
}
