package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i50 extends SSettingKey<Boolean> {
    public static final i50 a = null;

    static {
        a = new i50();
    }

    public i50() {
        Boolean r1 = Boolean.FALSE;
        super("live_landscape_hide_right_bottom_toolbar_enable", "横屏直播间收起工具栏时隐藏右下底Toolbar", r1, r1);
    }
}
