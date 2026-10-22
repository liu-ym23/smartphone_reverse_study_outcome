package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ee extends SSettingKey<Boolean> {
    public static final ee a = null;

    static {
        a = new ee();
    }

    public ee() {
        Boolean r1 = Boolean.TRUE;
        super("live_anti_addiction_switch", "直播内流防沉迷开关", r1, r1);
    }
}
