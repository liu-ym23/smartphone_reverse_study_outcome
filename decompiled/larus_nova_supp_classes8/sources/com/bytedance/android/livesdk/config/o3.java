package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o3 extends SSettingKey<Boolean> {
    public static final o3 a = null;

    static {
        a = new o3();
    }

    public o3() {
        Boolean r1 = Boolean.TRUE;
        super("enable_live_interact", "是否打开视频连麦功能", r1, r1);
    }
}
