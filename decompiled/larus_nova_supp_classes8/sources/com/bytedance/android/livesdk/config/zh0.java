package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class zh0 extends SettingKey<Boolean> {
    public static final zh0 a = null;

    static {
        a = new zh0();
    }

    public zh0() {
        Boolean r1 = Boolean.FALSE;
        super("live_player_layout_orientation_opt", "播放器布局优化_传入方向", r1, r1);
    }
}
