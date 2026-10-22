package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i80 extends SSettingKey<Boolean> {
    public static final i80 a = null;

    static {
        a = new i80();
    }

    public i80() {
        Boolean r1 = Boolean.FALSE;
        super("live_merge_monitor_degrade_config", "埋点聚拢性能降级", r1, r1);
    }
}
