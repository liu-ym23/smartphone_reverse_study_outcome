package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class uv extends SSettingKey<Boolean> {
    public static final uv a = null;

    static {
        a = new uv();
    }

    public uv() {
        Boolean r1 = Boolean.TRUE;
        super("enable_live_filter_tandem_repeated", "过滤连续重复的直播间", r1, r1);
    }
}
