package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class uw0 extends SSettingKey<Boolean> {
    public static final uw0 a = null;

    static {
        a = new uw0();
    }

    public uw0() {
        Boolean r1 = Boolean.FALSE;
        super("live_video_chorus_feature_anchor_enable", "视频合唱主播侧实验，全量开关", r1, r1);
    }
}
