package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class kl0 extends SSettingKey<Boolean> {
    public static final kl0 a = null;

    static {
        a = new kl0();
    }

    public kl0() {
        Boolean r1 = Boolean.FALSE;
        super("live_public_screen_dirty_region_opt", "直播公屏全屏渲染优化", r1, r1);
    }
}
