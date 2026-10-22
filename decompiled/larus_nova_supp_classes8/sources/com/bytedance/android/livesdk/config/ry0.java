package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ry0 extends SSettingKey<Boolean> {
    public static final ry0 a = null;

    static {
        a = new ry0();
    }

    public ry0() {
        Boolean r1 = Boolean.TRUE;
        super("live_welfare_enable", "直播公益开关", r1, r1);
    }
}
