package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ez extends SSettingKey<Boolean> {
    public static final ez a = null;

    static {
        a = new ez();
    }

    public ez() {
        Boolean r1 = Boolean.TRUE;
        super("live_audience_receive_gift_enable", "给观众送礼开关", r1, r1);
    }
}
