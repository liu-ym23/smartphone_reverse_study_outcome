package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ci0 extends SSettingKey<Boolean> {
    public static final ci0 a = null;

    static {
        a = new ci0();
    }

    public ci0() {
        Boolean r1 = Boolean.FALSE;
        super("live_player_memory_leak_fix_enable", "播放器内存泄漏开关", r1, r1);
    }
}
