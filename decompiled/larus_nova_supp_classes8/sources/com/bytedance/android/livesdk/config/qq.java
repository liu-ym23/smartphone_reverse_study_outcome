package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class qq extends SSettingKey<Boolean> {
    public static final qq a = null;

    static {
        a = new qq();
    }

    public qq() {
        Boolean r1 = Boolean.TRUE;
        super("live_enable_anchor_overheat_digg_degrade", "主播发热点赞降级开关", r1, r1);
    }
}
