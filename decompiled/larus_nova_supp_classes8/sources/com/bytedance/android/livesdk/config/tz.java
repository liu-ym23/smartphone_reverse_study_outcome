package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class tz extends SSettingKey<Boolean> {
    public static final tz a = null;

    static {
        a = new tz();
    }

    public tz() {
        Boolean r1 = Boolean.TRUE;
        super("live_hamlet_avatar_full_monitor_enable_tea", "hamletAvatar全链路箭筒是否上报到tea", r1, r1);
    }
}
