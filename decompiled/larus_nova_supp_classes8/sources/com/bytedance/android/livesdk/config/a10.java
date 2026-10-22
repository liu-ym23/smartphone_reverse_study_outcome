package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a10 extends SSettingKey<Boolean> {
    public static final a10 a = null;

    static {
        a = new a10();
    }

    public a10() {
        Boolean r1 = Boolean.TRUE;
        super("live_im_fetch_v2_enable", "内流切换至im/fetch/v2", r1, r1);
    }
}
