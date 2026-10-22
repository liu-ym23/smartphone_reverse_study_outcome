package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class bi0 extends SettingKey<Boolean> {
    public static final bi0 a = null;

    static {
        a = new bi0();
    }

    public bi0() {
        Boolean r1 = Boolean.FALSE;
        super("live_player_layout_screen_size", "播放器布局优化_传入宽高", r1, r1);
    }
}
