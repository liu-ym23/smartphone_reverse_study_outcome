package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class nq0 extends SSettingKey<Boolean> {
    public static final nq0 a = null;

    static {
        a = new nq0();
    }

    public nq0() {
        Boolean r1 = Boolean.TRUE;
        super("live_screen_capture_with_timon_enable", "截图分享面板监听接入Timon", r1, r1);
    }
}
