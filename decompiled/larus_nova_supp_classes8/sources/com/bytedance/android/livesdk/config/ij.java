package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ij extends SSettingKey<Boolean> {
    public static final ij a = null;

    static {
        a = new ij();
    }

    public ij() {
        Boolean r1 = Boolean.TRUE;
        super("live_castscreen_skip_landscape_widget_auth", "跳过横屏投屏widget二级入口校验", r1, r1);
    }
}
