package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ti extends SSettingKey<Boolean> {
    public static final ti a = null;

    static {
        a = new ti();
    }

    public ti() {
        Boolean r4 = Boolean.TRUE;
        super("live_bundle_opt_switch", "直播间bundle优化开关", r4, r4, true);
    }
}
