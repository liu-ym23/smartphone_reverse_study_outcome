package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class v6 extends SSettingKey<Boolean> {
    public static final v6 a = null;

    static {
        a = new v6();
    }

    public v6() {
        Boolean r1 = Boolean.TRUE;
        super("player_consume_first_layout_sei", "播放器使用layoutSEI", r1, r1);
    }
}
