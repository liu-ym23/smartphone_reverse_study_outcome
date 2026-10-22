package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class vq extends SSettingKey<Boolean> {
    public static final vq a = null;

    static {
        a = new vq();
    }

    public vq() {
        Boolean r1 = Boolean.FALSE;
        super("live_enable_appointment_calendar", "看播侧添加日历提醒开关", r1, r1);
    }
}
