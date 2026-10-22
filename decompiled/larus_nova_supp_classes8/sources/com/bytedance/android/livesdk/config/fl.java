package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class fl extends SSettingKey<Boolean> {
    public static final fl a = null;

    static {
        a = new fl();
    }

    public fl() {
        Boolean r1 = Boolean.TRUE;
        super("live_close_button_listen_clear", "退房按钮监听清屏", r1, r1);
    }
}
