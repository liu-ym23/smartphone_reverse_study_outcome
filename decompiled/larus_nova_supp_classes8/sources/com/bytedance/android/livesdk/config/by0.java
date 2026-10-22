package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class by0 extends SSettingKey<Boolean> {
    public static final by0 a = null;

    static {
        a = new by0();
    }

    public by0() {
        Boolean r1 = Boolean.FALSE;
        super("live_vs_paidLive_ban_screenRecord", "付费直播是否禁止录屏", r1, r1);
    }
}
