package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class my extends SSettingKey<Boolean> {
    public static final my a = null;

    static {
        a = new my();
    }

    public my() {
        Boolean r1 = Boolean.FALSE;
        super("live_gcp_preload_toolabr_config", "游戏小手柄预览流预加载开关", r1, r1);
    }
}
