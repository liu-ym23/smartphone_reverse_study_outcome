package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class sk extends SSettingKey<Boolean> {
    public static final sk a = null;

    static {
        a = new sk();
    }

    public sk() {
        Boolean r1 = Boolean.FALSE;
        super("live_clean_mode_use_new_close_button", "清屏模式下是否使用的关闭按钮样式", r1, r1);
    }
}
