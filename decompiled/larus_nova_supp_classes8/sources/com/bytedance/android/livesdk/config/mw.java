package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class mw extends SSettingKey<Boolean> {
    public static final mw a = null;

    static {
        a = new mw();
    }

    public mw() {
        super("live_fix_float_window_notification", "修复小窗播放通知不展示问题", Boolean.FALSE, Boolean.TRUE);
    }
}
