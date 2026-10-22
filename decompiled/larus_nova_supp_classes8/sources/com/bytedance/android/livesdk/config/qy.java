package com.bytedance.android.livesdk.config;

import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class qy extends SSettingKey<LiveGestureConfig> {
    public static final qy a = null;

    static {
        a = new qy();
    }

    public qy() {
        Lazy r0 = LiveGestureConfig.a;
        super("live_gesture_config", "直播内流操作手势配置", (LiveGestureConfig) LiveGestureConfig.a.getValue(), (LiveGestureConfig) LiveGestureConfig.b.getValue());
    }
}
