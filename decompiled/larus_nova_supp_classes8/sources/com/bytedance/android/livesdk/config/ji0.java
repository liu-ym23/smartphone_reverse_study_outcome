package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ji0 extends SettingKey<Boolean> {
    public static final ji0 a = null;

    static {
        a = new ji0();
    }

    public ji0() {
        Boolean r1 = Boolean.FALSE;
        super("live_player_sandwich_layout_debug", "三明治布局自动适配IMDebug", r1, r1);
    }
}
