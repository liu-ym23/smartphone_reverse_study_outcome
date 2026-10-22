package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ai extends SSettingKey<Boolean> {
    public static final ai a = null;

    static {
        a = new ai();
    }

    public ai() {
        Boolean r1 = Boolean.FALSE;
        super("live_broadcast_single_page_from_shoot_enable", "加号场景是否支持单页面", r1, r1);
    }
}
