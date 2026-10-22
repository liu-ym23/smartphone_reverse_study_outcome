package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class sl extends SSettingKey<Boolean> {
    public static final sl a = null;

    static {
        a = new sl();
    }

    public sl() {
        Boolean r1 = Boolean.TRUE;
        super("live_commerce_mini_window_transparent_fix", "兜底修复小窗路径中有透明activity的异常", r1, r1);
    }
}
