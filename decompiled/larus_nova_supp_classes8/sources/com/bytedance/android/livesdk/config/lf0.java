package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class lf0 extends SettingKey<Integer> {
    public static final lf0 a = null;

    public lf0() {
        super("live_panel_cover_opt_type", "面板遮盖降级优化开关.0 - 无优化, 1 - 取消动画, 2 - alpha动画硬件加速", 0, 0);
    }

    static {
        a = new lf0();
    }
}
