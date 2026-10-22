package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class it0 extends SSettingKey<Boolean> {
    public static final it0 a = null;

    static {
        a = new it0();
    }

    public it0() {
        Boolean r1 = Boolean.TRUE;
        super("live_status_bar_fix_config_moveplayer", "pk 直播间状态栏适配，允许移动播放器", r1, r1);
    }
}
