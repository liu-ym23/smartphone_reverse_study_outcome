package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ad extends SSettingKey<Boolean> {
    public static final ad a = null;

    static {
        a = new ad();
    }

    public ad() {
        Boolean r1 = Boolean.FALSE;
        super("live_anchor_status_center_gesture_type_opt", "新版主播状态中心的手势优化功能开关 默认关闭，打开变成上下滑", r1, r1);
    }
}
