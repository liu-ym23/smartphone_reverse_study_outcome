package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class eg extends SSettingKey<Boolean> {
    public static final eg a = null;

    static {
        a = new eg();
    }

    public eg() {
        Boolean r1 = Boolean.FALSE;
        super("live_barrage_engine_use_frame_animator", "部分弹幕场景使用FrameAnimator", r1, r1);
    }
}
