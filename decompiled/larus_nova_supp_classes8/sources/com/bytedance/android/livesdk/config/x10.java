package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class x10 extends SSettingKey<Boolean> {
    public static final x10 a = null;

    static {
        a = new x10();
    }

    public x10() {
        Boolean r4 = Boolean.FALSE;
        super("live_inner_feed_single_use_clear_opt", "直播间detroy中部分单例clear问题", r4, r4, true);
    }
}
