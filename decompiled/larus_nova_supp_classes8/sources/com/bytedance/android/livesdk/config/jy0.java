package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class jy0 extends SSettingKey<Boolean> {
    public static final jy0 a = null;

    static {
        a = new jy0();
    }

    public jy0() {
        Boolean r1 = Boolean.FALSE;
        super("live_webview_debug_enable", "直播开启WebView调试", r1, r1);
    }
}
