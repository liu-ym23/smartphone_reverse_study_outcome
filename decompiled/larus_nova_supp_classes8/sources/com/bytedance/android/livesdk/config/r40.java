package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r40 extends SSettingKey<Boolean> {
    public static final r40 a = null;

    static {
        a = new r40();
    }

    public r40() {
        Boolean r1 = Boolean.FALSE;
        super("live_ktv_mixer_enable_fix_fallback", "K歌场景伴奏混音修复兜底开关", r1, r1);
    }
}
