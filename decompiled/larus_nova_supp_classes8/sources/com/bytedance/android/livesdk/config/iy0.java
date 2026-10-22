package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class iy0 extends SSettingKey<Boolean> {
    public static final iy0 a = null;

    static {
        a = new iy0();
    }

    public iy0() {
        Boolean r1 = Boolean.FALSE;
        super("live_webview_console_js_inject", "是否向WebView注入console脚本", r1, r1);
    }
}
