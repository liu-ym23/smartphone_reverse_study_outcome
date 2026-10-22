package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class jr0 extends SSettingKey<Long> {
    public static final jr0 a = null;

    static {
        a = new jr0();
    }

    public jr0() {
        super("live_sei_update_interval", "sei更新时长", 500L, 500L);
    }
}
