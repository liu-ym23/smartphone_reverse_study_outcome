package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class mv extends SSettingKey<Boolean> {
    public static final mv a = null;

    static {
        a = new mv();
    }

    public mv() {
        Boolean r1 = Boolean.FALSE;
        super("live_feedback_enable_room_control", "是否展示直播进房room里的反馈问卷", r1, r1);
    }
}
