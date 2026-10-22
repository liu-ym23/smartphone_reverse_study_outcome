package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class fn extends SSettingKey<Boolean> {
    public static final fn a = null;

    static {
        a = new fn();
    }

    public fn() {
        Boolean r4 = Boolean.FALSE;
        super("live_detail_surfaceview", "混滑容器支持surfaceview", r4, r4, new String[]{"true:使用surfaceview", "false:不使用surfaceview"});
    }
}
