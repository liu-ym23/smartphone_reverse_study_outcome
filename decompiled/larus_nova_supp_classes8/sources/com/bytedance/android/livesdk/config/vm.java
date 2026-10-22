package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class vm extends SSettingKey<Boolean> {
    public static final vm a = null;

    static {
        a = new vm();
    }

    public vm() {
        Boolean r1 = Boolean.TRUE;
        super("live_decoration_safe_area_optimize_enable", "直播间贴纸安全区优化是否开启", r1, r1);
    }
}
