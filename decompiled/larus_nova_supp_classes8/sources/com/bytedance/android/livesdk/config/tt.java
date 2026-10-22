package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class tt extends SSettingKey<Boolean> {
    public static final tt a = null;

    static {
        a = new tt();
    }

    public tt() {
        Boolean r1 = Boolean.TRUE;
        super("live_end_page_disable_screen_on", "结束页取消屏幕常亮", r1, r1);
    }
}
