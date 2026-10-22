package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class pg0 extends SSettingKey<Boolean> {
    public static final pg0 a = null;

    static {
        a = new pg0();
    }

    public pg0() {
        Boolean r1 = Boolean.FALSE;
        super("live_pinch_clean_enable", "直播间放大模式是否触发清屏", r1, r1);
    }
}
