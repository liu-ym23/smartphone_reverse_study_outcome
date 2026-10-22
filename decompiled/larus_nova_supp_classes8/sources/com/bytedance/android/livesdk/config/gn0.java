package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class gn0 extends SSettingKey<Boolean> {
    public static final gn0 a = null;

    static {
        a = new gn0();
    }

    public gn0() {
        Boolean r1 = Boolean.TRUE;
        super("live_revenue_link_skip_crop_opt", "直播间跳过crop逻辑", r1, r1);
    }
}
