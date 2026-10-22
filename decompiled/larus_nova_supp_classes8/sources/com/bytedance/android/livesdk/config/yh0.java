package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class yh0 extends SettingKey<Boolean> {
    public static final yh0 a = null;

    static {
        a = new yh0();
    }

    public yh0() {
        Boolean r1 = Boolean.FALSE;
        super(LiveInitSettingKeys.LIVE_PLAYER_LAYOUT_OPT_V1, "播放器布局逻辑优化", r1, r1);
    }
}
