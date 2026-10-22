package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n extends SSettingKey<Boolean> {
    public static final n a = null;

    static {
        a = new n();
    }

    public n() {
        Boolean r1 = Boolean.FALSE;
        super("anchor_start_live_time_link_calendar", "主播开播时间关联到系统日历", r1, r1);
    }
}
