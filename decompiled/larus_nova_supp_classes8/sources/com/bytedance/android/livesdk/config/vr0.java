package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class vr0 extends SSettingKey<Boolean> {
    public static final vr0 a = null;

    static {
        a = new vr0();
    }

    public vr0() {
        Boolean r1 = Boolean.TRUE;
        super("live_share_optimized", "是否开启分享优化", r1, r1);
    }
}
