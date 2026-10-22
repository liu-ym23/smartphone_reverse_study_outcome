package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class km extends SSettingKey<Boolean> {
    public static final km a = null;

    static {
        a = new km();
    }

    public km() {
        Boolean r1 = Boolean.TRUE;
        super("live_core_single_view_mode_switch", "RTC是否开启单View模式", r1, r1);
    }
}
