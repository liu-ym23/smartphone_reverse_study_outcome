package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class t31 extends SSettingKey<Boolean> {
    public static final t31 a = null;

    static {
        a = new t31();
    }

    public t31() {
        Boolean r1 = Boolean.TRUE;
        super("live_gesture_touch_dispatch_opt", "直播间触摸事件down线分发给业务优化", r1, r1);
    }
}
