package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class xu extends SSettingKey<Boolean> {
    public static final xu a = null;

    static {
        a = new xu();
    }

    public xu() {
        Boolean r1 = Boolean.TRUE;
        super("live_equal_talk_tray_fix", "多人场景托盘位置调整", r1, r1);
    }
}
