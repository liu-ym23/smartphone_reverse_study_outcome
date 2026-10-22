package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class zh extends SSettingKey<Boolean> {
    public static final zh a = null;

    static {
        a = new zh();
    }

    public zh() {
        Boolean r4 = Boolean.FALSE;
        super("live_broadcast_single_activity_enable", "主播activity单实例", r4, r4, true);
    }
}
