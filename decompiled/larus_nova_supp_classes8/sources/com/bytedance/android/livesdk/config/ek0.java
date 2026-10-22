package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ek0 extends SSettingKey<Long> {
    public static final ek0 a = null;

    static {
        a = new ek0();
    }

    public ek0() {
        super("live_pre_danmaku_history_msg_timeout_duration", "直播预览流历史弹幕超时时间(ms)", 5000L, 5000L);
    }
}
