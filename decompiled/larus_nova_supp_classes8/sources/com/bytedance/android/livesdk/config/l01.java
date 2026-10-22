package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l01 extends SSettingKey<Boolean> {
    public static final l01 a = null;

    static {
        a = new l01();
    }

    public l01() {
        Boolean r1 = Boolean.TRUE;
        super("lynx_banner_enabled", "允许 lynx banner", r1, r1);
    }
}
