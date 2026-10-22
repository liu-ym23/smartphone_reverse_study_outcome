package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class nl0 extends SettingKey<Boolean> {
    public static final nl0 a = null;

    static {
        a = new nl0();
    }

    public nl0() {
        Boolean r4 = Boolean.TRUE;
        super("live_public_screen_height_multilink_danmu_opt", "多人场景ugc弹幕玩法公屏高度优化", r4, r4, true);
    }
}
