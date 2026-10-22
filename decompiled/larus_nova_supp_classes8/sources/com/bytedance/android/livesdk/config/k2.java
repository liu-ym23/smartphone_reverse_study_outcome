package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k2 extends SSettingKey<Boolean> {
    public static final k2 a = null;

    static {
        a = new k2();
    }

    public k2() {
        boolean r0 = tb1.c.a;
        super("douyin_ktv_voice_volume_adjust_enable", "抖音k歌主播端是否允许人声调节", Boolean.valueOf(r0), Boolean.valueOf(r0));
    }
}
