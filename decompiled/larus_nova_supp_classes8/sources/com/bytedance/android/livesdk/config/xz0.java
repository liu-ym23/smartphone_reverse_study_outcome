package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class xz0 extends SettingKey<Long> {
    public static final xz0 a = null;

    static {
        a = new xz0();
    }

    public xz0() {
        super("live_xplay_switch_game_interval", "云游戏玩法判断是否为切换游戏场景的时间间隔", 5000L, 5000L);
    }
}
