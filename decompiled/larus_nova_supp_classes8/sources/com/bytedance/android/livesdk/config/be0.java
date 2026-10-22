package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class be0 extends SSettingKey<Boolean> {
    public static final be0 a = null;

    static {
        a = new be0();
    }

    public be0() {
        Boolean r1 = Boolean.TRUE;
        super("live_open_platform_fixed_height_window", "是否固定写死游戏面板的window高度", r1, r1);
    }
}
