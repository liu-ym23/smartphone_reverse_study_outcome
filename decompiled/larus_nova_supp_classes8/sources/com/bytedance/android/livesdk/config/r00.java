package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r00 extends SSettingKey<Boolean> {
    public static final r00 a = null;

    static {
        a = new r00();
    }

    public r00() {
        Boolean r1 = Boolean.TRUE;
        super("live_hybrid_h5_screen_shot_remove", "移除截屏权限的监听", r1, r1);
    }
}
