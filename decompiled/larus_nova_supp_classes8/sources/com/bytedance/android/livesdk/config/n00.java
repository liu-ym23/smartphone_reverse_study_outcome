package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n00 extends SSettingKey<com.bytedance.android.livesdk.performance.k> {
    public static final n00 a = null;

    static {
        a = new n00();
    }

    public n00() {
        super(LiveInitSettingKeys.LIVE_HOT_ROOM_PERFORMANCE_SETTING, "特定高热直播间性能监控设置", new com.bytedance.android.livesdk.performance.k(), new com.bytedance.android.livesdk.performance.k());
    }
}
