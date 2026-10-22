package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p60 extends SSettingKey<Boolean> {
    public static final p60 a = null;

    static {
        a = new p60();
    }

    public p60() {
        Boolean r1 = Boolean.TRUE;
        super("live_link_media_info_change_callback_enable", "是否支持分辨率切换时上报状态", r1, r1);
    }
}
