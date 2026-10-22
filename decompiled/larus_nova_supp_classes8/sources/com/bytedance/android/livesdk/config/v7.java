package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class v7 extends SSettingKey<Boolean> {
    public static final v7 a = null;

    static {
        a = new v7();
    }

    public v7() {
        Boolean r1 = Boolean.TRUE;
        super("init_webcast_bid", "是否初始化直播bid", r1, r1);
    }
}
