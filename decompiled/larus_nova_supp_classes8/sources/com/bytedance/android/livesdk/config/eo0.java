package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class eo0 extends SSettingKey<Boolean> {
    public static final eo0 a = null;

    static {
        a = new eo0();
    }

    public eo0() {
        Boolean r1 = Boolean.TRUE;
        super("live_room_enable_intercept_close_room", "是否允许拦截退房按钮点击", r1, r1);
    }
}
