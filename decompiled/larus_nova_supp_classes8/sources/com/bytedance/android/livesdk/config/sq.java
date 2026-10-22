package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class sq extends SettingKey<Boolean> {
    public static final sq a = null;

    static {
        a = new sq();
    }

    public sq() {
        Boolean r1 = Boolean.TRUE;
        super("live_enable_anchor_toolbar_backup_req", "主播侧toolbar兜底逻辑", r1, r1);
    }
}
