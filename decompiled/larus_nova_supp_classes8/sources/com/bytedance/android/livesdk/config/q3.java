package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q3 extends SSettingKey<Boolean> {
    public static final q3 a = null;

    static {
        a = new q3();
    }

    public q3() {
        Boolean r1 = Boolean.FALSE;
        super("enable_live_media_promotion", "媒体直播间是否打开快上热门", r1, r1);
    }
}
