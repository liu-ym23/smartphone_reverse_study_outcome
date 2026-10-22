package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class v1 extends SSettingKey<Boolean> {
    public static final v1 a = null;

    static {
        a = new v1();
    }

    public v1() {
        Boolean r1 = Boolean.TRUE;
        super("live_guest_battle_start_panel_to_lynx", "大作战开启面板打开动作迁移到Lynx", r1, r1);
    }
}
