package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p9 extends SSettingKey<Boolean> {
    public static final p9 a = null;

    static {
        a = new p9();
    }

    public p9() {
        Boolean r1 = Boolean.TRUE;
        super("live_accessibility_enable", "黑名单机型不启用", r1, r1);
    }
}
