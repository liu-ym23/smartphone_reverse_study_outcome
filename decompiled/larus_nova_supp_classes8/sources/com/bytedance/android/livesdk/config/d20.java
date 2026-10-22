package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d20 extends SSettingKey<Boolean> {
    public static final d20 a = null;

    static {
        a = new d20();
    }

    public d20() {
        Boolean r1 = Boolean.FALSE;
        super("live_inner_wrds_preload_enable", "直播内流wrds预加载开关", r1, r1);
    }
}
