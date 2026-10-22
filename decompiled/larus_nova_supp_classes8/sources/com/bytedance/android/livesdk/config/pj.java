package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class pj extends SSettingKey<Boolean> {
    public static final pj a = null;

    static {
        a = new pj();
    }

    public pj() {
        Boolean r1 = Boolean.TRUE;
        super("live_cast_screen_use_control_bg_layout", "是否使用投屏播控背景自定义布局", r1, r1);
    }
}
