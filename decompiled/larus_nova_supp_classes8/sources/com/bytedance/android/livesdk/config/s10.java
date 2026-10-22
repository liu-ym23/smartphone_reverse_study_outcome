package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class s10 extends SSettingKey<Boolean> {
    public static final s10 a = null;

    static {
        a = new s10();
    }

    public s10() {
        Boolean r1 = Boolean.FALSE;
        super("live_inner_feed_recommend_force_update", "直播内流强制更新配置", r1, r1);
    }
}
