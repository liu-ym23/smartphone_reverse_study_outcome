package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class td0 extends SSettingKey<Boolean> {
    public static final td0 a = null;

    static {
        a = new td0();
    }

    public td0() {
        Boolean r1 = Boolean.TRUE;
        super("live_open_feature_list_local_cache", "主播功能列表本地缓存开关", r1, r1);
    }
}
