package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ys extends SSettingKey<Boolean> {
    public static final ys a = null;

    static {
        a = new ys();
    }

    public ys() {
        Boolean r1 = Boolean.FALSE;
        super("live_enable_screenshot_panel", "截图分享面板", r1, r1);
    }
}
