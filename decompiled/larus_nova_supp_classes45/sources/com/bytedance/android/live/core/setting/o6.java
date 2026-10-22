package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class o6 extends SSettingKey<Boolean> {
    public static final o6 a = null;

    static {
        a = new o6();
    }

    public o6() {
        Boolean r1 = Boolean.TRUE;
        super("multi_link_audience_enter_room_use_preivew_player_position_opt", "多人场景观众预览流进房使用预览流布局参数提前刷新房间内播放器布局", r1, r1);
    }
}
