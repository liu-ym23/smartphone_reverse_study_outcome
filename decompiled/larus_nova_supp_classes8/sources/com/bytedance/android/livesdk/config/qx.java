package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class qx extends SettingKey<Boolean> {
    public static final qx a = null;

    static {
        a = new qx();
    }

    public qx() {
        Boolean r1 = Boolean.FALSE;
        super("live_game_cp_render_opt", "小手柄全屏渲染优化", r1, r1);
    }
}
