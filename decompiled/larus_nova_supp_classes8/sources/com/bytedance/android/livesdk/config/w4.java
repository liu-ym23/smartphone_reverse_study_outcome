package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class w4 extends SSettingKey<Long> {
    public static final w4 a = null;

    static {
        a = new w4();
    }

    public w4() {
        super("feedback_show_interval_length", "反馈问卷展示间隔", 3600L, 3600L);
    }
}
