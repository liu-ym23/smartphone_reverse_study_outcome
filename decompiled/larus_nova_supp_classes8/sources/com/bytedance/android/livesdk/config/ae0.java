package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ae0 extends SSettingKey<Boolean> {
    public static final ae0 a = null;

    static {
        a = new ae0();
    }

    public ae0() {
        Boolean r1 = Boolean.FALSE;
        super("live_miniapp_enable_fluency_monitor", "小程序流畅度监测", r1, r1);
    }
}
