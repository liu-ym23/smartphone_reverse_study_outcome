package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class sm extends SettingKey<Boolean> {
    public static final sm a = null;

    static {
        a = new sm();
    }

    public sm() {
        Boolean r1 = Boolean.TRUE;
        super("live_danmu_game_height_bugfix", "danmu 高度调整端上兜底开关 ", r1, r1);
    }
}
