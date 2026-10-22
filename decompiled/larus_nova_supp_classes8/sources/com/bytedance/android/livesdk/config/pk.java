package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class pk extends SSettingKey<Integer> {
    public static final pk a = null;

    static {
        a = new pk();
    }

    public pk() {
        super("live_clean_mode_alpha_anim_duration", "清屏模式下alpha渐隐动画的时长", 200, 200);
    }
}
