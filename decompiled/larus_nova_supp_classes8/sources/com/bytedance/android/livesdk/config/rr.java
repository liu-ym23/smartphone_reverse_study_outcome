package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class rr extends SSettingKey<Boolean> {
    public static final rr a = null;

    static {
        a = new rr();
    }

    public rr() {
        Boolean r1 = Boolean.FALSE;
        super("live_enable_float_window_show_in_im", "IM回流场景是否展示小窗入口", r1, r1);
    }
}
