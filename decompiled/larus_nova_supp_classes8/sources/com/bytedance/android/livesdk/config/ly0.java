package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ly0 extends SSettingKey<Boolean> {
    public static final ly0 a = null;

    static {
        a = new ly0();
    }

    public ly0() {
        Boolean r1 = Boolean.TRUE;
        super("live_webview_offline_enable", "直播开启WebView离线化", r1, r1);
    }
}
