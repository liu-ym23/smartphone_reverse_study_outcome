package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m00 extends SSettingKey<Integer> {
    public static final m00 a = null;

    static {
        a = new m00();
    }

    public m00() {
        super("live_hot_reset_time_interval", "高热直播间失效时间间隔", 60, 60);
    }
}
