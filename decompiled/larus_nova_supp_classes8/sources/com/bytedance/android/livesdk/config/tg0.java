package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class tg0 extends SSettingKey<Long> {
    public static final tg0 a = null;

    static {
        a = new tg0();
    }

    public tg0() {
        super("live_ping_anchor_interval_config", "ping间隔配置", 15000L, 15000L, true);
    }
}
