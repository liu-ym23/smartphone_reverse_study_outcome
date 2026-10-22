package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class qq0 extends SSettingKey<Boolean> {
    public static final qq0 a = null;

    static {
        a = new qq0();
    }

    public qq0() {
        super("live_screen_record_default_clean", Boolean.TRUE, "录屏是否直接进入清屏模式");
    }
}
