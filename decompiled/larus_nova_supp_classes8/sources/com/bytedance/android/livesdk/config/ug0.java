package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ug0 extends SSettingKey<Boolean> {
    public static final ug0 a = null;

    static {
        a = new ug0();
    }

    public ug0() {
        Boolean r4 = Boolean.FALSE;
        super("live_ping_anchor_interval_config_enable", "ping间隔配置是否生效", r4, r4, true);
    }
}
