package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class y3 extends SSettingKey<Boolean> {
    public static final y3 a = null;

    static {
        y3 r0 = new y3();
        a = r0;
        r0.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public y3() {
        Boolean r1 = Boolean.FALSE;
        super("enable_multi_player", "是否开启多播放器", r1, r1);
    }
}
