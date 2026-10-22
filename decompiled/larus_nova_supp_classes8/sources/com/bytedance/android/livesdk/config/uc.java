package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class uc extends SSettingKey<Boolean> {
    public static final uc a = null;

    static {
        a = new uc();
    }

    public uc() {
        Boolean r1 = Boolean.TRUE;
        super("live_anchor_screenshot_enable", "是否展示录屏开播入口", r1, r1);
    }
}
