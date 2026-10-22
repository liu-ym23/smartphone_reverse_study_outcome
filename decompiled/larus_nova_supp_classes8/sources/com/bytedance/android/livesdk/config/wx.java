package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class wx extends SSettingKey<Integer> {
    public static final wx a = null;

    static {
        a = new wx();
    }

    public wx() {
        super("live_game_guide_bubble_delay_dismiss_time", "直播小游戏引导气泡显示时长", 5000, 5000);
    }
}
