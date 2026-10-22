package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class lz0 extends SSettingKey<Boolean> {
    public static final lz0 a = null;

    static {
        a = new lz0();
    }

    public lz0() {
        Boolean r1 = Boolean.TRUE;
        super("live_xplay_anchor_crash_resume_enable", "Xplay主播断播续玩能力开关", r1, r1);
    }
}
