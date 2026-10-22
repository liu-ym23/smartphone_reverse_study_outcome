package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class mb extends SSettingKey<Boolean> {
    public static final mb a = null;

    static {
        a = new mb();
    }

    public mb() {
        Boolean r1 = Boolean.FALSE;
        super("live_anchor_enable_gesture_cache", "手势魔法缓存能力", r1, r1);
    }
}
