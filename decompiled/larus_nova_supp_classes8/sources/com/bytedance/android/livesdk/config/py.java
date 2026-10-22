package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class py extends SSettingKey<Boolean> {
    public static final py a = null;

    static {
        a = new py();
    }

    public py() {
        Boolean r1 = Boolean.TRUE;
        super("live_gecko_enable", "是否开启直播gecko功能", r1, r1);
    }
}
