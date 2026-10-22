package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class lt extends SSettingKey<Boolean> {
    public static final lt a = null;

    static {
        a = new lt();
    }

    public lt() {
        super("live_enable_ve_camera2", Boolean.FALSE, "直播是否开启VE camera2 采集");
    }
}
