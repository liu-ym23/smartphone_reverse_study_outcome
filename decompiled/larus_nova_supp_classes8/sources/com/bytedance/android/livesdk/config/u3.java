package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class u3 extends SSettingKey<Boolean> {
    public static final u3 a = null;

    static {
        a = new u3();
    }

    public u3() {
        Boolean r1 = Boolean.FALSE;
        super("enable_lynx_qr_scan", "直播间内 lynx 扫码入口", r1, r1);
    }
}
