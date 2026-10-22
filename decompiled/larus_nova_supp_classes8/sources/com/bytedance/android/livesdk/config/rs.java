package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class rs extends SSettingKey<Boolean> {
    public static final rs a = null;

    static {
        a = new rs();
    }

    public rs() {
        super("live_enable_record", Boolean.FALSE, "录屏测试开关");
    }
}
