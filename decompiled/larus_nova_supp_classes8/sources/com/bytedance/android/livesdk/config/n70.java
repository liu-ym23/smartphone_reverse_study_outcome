package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n70 extends SettingKey<Boolean> {
    public static final n70 a = null;

    static {
        a = new n70();
    }

    public n70() {
        Boolean r1 = Boolean.FALSE;
        super("live_long_press_panel_dou_plus_enable", "长按面板抖+入口", r1, r1);
    }
}
