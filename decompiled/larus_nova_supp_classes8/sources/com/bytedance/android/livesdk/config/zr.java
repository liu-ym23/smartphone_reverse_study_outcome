package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class zr extends SettingKey<Boolean> {
    public static final zr a = null;

    static {
        a = new zr();
    }

    public zr() {
        super("live_enable_interact_aspect_ratio_layout_opt", "小玩法观众端游戏画面布局优化", Boolean.FALSE, Boolean.TRUE, true);
    }
}
