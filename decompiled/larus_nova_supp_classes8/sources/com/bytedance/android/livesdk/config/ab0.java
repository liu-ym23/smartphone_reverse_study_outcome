package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ab0 extends SSettingKey<Boolean> {
    public static final ab0 a = null;

    static {
        a = new ab0();
    }

    public ab0() {
        Boolean r1 = Boolean.FALSE;
        super("live_multilink_apply_video_keep_client_intercept", "多人场景嘉宾申请开启视频保持端上拦截能力", r1, r1);
    }
}
