package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class qa extends SettingKey<Boolean> {
    public static final qa a = null;

    static {
        a = new qa();
    }

    public qa() {
        Boolean r4 = Boolean.FALSE;
        super("live_anchor_accessibility_bugfix_in_hudong_enable", "主播侧无障碍模式bugfix卡关", r4, r4, true);
    }
}
