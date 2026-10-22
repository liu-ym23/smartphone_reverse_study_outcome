package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class y30 extends SSettingKey<Boolean> {
    public static final y30 a = null;

    static {
        a = new y30();
    }

    public y30() {
        Boolean r1 = Boolean.FALSE;
        super("live_just_audio_notification_enable", "仅在语音直播后台展示通知", r1, r1);
    }
}
