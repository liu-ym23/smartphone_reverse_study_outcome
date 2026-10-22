package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class qf0 extends SSettingKey<Float> {
    public static final qf0 a = null;

    static {
        a = new qf0();
    }

    public qf0() {
        Float r0 = Float.valueOf(0.19f);
        super("live_pc_anchor_interact_video_margin_top", "PC伴侣主播连麦横屏流VideoView顶部占画幅比例", r0, r0);
    }
}
