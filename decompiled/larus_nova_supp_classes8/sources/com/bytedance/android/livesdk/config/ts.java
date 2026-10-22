package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ts extends SSettingKey<Boolean> {
    public static final ts a = null;

    static {
        a = new ts();
    }

    public ts() {
        Boolean r1 = Boolean.FALSE;
        super("live_enable_room_feedback_position_adjust", "是否支持房间内问卷position参数更改", r1, r1);
    }
}
