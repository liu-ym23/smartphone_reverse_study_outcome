package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e90 extends SSettingKey<Boolean> {
    public static final e90 a = null;

    static {
        a = new e90();
    }

    public e90() {
        Boolean r1 = Boolean.TRUE;
        super("live_mic_anchor_follow_reset_fix", "麦序房关注成功状态回写修复", r1, r1);
    }
}
