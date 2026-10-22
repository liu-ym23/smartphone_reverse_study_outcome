package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class my0 extends SSettingKey<Boolean> {
    public static final my0 a = null;

    static {
        a = new my0();
    }

    public my0() {
        Boolean r1 = Boolean.TRUE;
        super(LiveInitSettingKeys.LIVE_WEBVIEW_USE_MONITOR, "webview使用monitr", r1, r1);
    }
}
