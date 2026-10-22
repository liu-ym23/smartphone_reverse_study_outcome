package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class y60 extends SSettingKey<Boolean> {
    public static final y60 a = null;

    static {
        a = new y60();
    }

    public y60() {
        Boolean r1 = Boolean.TRUE;
        super(LiveInitSettingKeys.LIVE_LITE_ENABLE_PLUGIN_ENV_LOAD, "抖音极速版是否开启插件环境加载动态库能力", r1, r1);
    }
}
