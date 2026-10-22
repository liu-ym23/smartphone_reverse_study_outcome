package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ky0 extends SSettingKey<Boolean> {
    public static final ky0 a = null;

    static {
        a = new ky0();
    }

    public ky0() {
        Boolean r1 = Boolean.FALSE;
        super("live_webview_ppe_enable", "直播webview是否使用PPE", r1, r1);
    }
}
