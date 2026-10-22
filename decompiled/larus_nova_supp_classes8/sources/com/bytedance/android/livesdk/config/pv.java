package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class pv extends SSettingKey<Boolean> {
    public static final pv a = null;

    static {
        a = new pv();
    }

    public pv() {
        Boolean r1 = Boolean.FALSE;
        super("disable_show_live_button_in_feed_drawer", "抽屉更多直播隐藏开播按钮", r1, r1);
    }
}
