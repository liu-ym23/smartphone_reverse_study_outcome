package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class po extends SSettingKey<Boolean> {
    public static final po a = null;

    static {
        a = new po();
    }

    public po() {
        Boolean r1 = Boolean.TRUE;
        super("live_dispatcher_scheme_in_long_press", "协议化调用框架在长按面板上的落地，兜底开关", r1, r1);
    }
}
