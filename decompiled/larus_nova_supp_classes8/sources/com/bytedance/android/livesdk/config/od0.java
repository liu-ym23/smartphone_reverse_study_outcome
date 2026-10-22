package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class od0 extends SSettingKey<Boolean> {
    public static final od0 a = null;

    static {
        a = new od0();
    }

    public od0() {
        Boolean r1 = Boolean.FALSE;
        super("live_offline_gecko_separate", "gecko和下载代码功能分离", r1, r1);
    }
}
