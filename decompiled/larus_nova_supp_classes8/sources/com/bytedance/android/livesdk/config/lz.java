package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class lz extends SettingKey<Boolean> {
    public static final lz a = null;

    static {
        a = new lz();
    }

    public lz() {
        Boolean r1 = Boolean.TRUE;
        super("live_group_enable_room_change_logger", "导播合演使用换房方案", r1, r1);
    }
}
