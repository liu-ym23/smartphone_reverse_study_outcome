package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class yx extends SSettingKey<Boolean> {
    public static final yx a = null;

    static {
        a = new yx();
    }

    public yx() {
        Boolean r1 = Boolean.FALSE;
        super("live_game_interact_degrade_opt", "游戏场景交互降级", r1, r1);
    }
}
