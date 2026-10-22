package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class sr0 extends SSettingKey<Boolean> {
    public static final sr0 a = null;

    static {
        a = new sr0();
    }

    public sr0() {
        Boolean r1 = Boolean.FALSE;
        super("live_share_enable_share_id", "是否添加share_id", r1, r1);
    }
}
