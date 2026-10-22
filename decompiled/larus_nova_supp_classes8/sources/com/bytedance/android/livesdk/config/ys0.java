package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ys0 extends SSettingKey<Boolean> {
    public static final ys0 a = null;

    static {
        a = new ys0();
    }

    public ys0() {
        Boolean r1 = Boolean.FALSE;
        super("live_smooth_leave_stream_stuck_opt", "平滑退房流画面卡住几秒优化", r1, r1);
    }
}
