package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ur extends SSettingKey<Boolean> {
    public static final ur a = null;

    static {
        a = new ur();
    }

    public ur() {
        Boolean r1 = Boolean.TRUE;
        super("live_enable_gesture_more_live_fix", "处理手势容易出现更多直播抽屉", r1, r1);
    }
}
