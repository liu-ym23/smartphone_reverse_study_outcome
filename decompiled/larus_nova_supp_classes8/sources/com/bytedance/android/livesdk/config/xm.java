package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class xm extends SSettingKey<Boolean> {
    public static final xm a = null;

    static {
        a = new xm();
    }

    public xm() {
        Boolean r4 = Boolean.TRUE;
        super("live_decouple_digg_and_userinfo", "DiggWidget和主播头像组件解耦", r4, r4, true);
    }
}
