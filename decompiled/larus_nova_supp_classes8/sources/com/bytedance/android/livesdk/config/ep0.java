package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ep0 extends SSettingKey<Boolean> {
    public static final ep0 a = null;

    static {
        a = new ep0();
    }

    public ep0() {
        Boolean r4 = Boolean.TRUE;
        super("live_room_swipe_guide_configs_with_guide_tetris_fix", "直播上下滑引导和清屏组件引导冲突优化", r4, r4, true);
    }
}
