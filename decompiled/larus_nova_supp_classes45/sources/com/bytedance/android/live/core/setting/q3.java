package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class q3 extends SSettingKey<Boolean> {
    public static final q3 a = null;

    static {
        a = new q3();
    }

    public q3() {
        Boolean r1 = Boolean.FALSE;
        super("live_performance_enter_room_player_optimize", "进房场景播放器优化开关", r1, r1);
    }
}
