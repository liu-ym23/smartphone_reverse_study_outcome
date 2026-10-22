package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class vu0 extends SettingKey<Boolean> {
    public static final vu0 a = null;

    static {
        a = new vu0();
    }

    public vu0() {
        Boolean r4 = Boolean.TRUE;
        super("live_toolbar_button_dynamic_enable", "toolBar button 入口PK、连线使用 Room 信息", r4, r4, true);
    }
}
