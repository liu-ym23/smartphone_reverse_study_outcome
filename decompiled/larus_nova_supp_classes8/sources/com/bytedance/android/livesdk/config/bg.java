package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class bg extends SSettingKey<Long> {
    public static final bg a = null;

    static {
        a = new bg();
    }

    public bg() {
        super("live_back_record_delay_seconds", "回溯录屏时延", 0L, 0L);
    }
}
