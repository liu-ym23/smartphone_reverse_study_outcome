package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class y10 extends SSettingKey<Boolean> {
    public static final y10 a = null;

    static {
        a = new y10();
    }

    public y10() {
        Boolean r1 = Boolean.TRUE;
        super("live_inner_preview_landscape_enter_clear_config", "内流预览流的横屏进房退出后重置状态", r1, r1);
    }
}
