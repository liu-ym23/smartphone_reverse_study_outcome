package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class lw extends SSettingKey<Boolean> {
    public static final lw a = null;

    static {
        a = new lw();
    }

    public lw() {
        Boolean r1 = Boolean.TRUE;
        super("live_fix_float_window_jsb_show", "修复直播小窗jsb获取展示状态不准确的问题", r1, r1);
    }
}
