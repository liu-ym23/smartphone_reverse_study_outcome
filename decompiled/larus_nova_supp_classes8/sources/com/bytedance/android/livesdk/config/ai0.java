package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ai0 extends SettingKey<Boolean> {
    public static final ai0 a = null;

    static {
        a = new ai0();
    }

    public ai0() {
        Boolean r1 = Boolean.TRUE;
        super("live_player_layout_scene_opt", "播放器布局优化_使用场景", r1, r1);
    }
}
