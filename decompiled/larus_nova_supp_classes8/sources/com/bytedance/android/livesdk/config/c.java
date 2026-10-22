package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c extends SettingKey<Boolean> {
    public static final c a = null;

    static {
        a = new c();
    }

    public c() {
        Boolean r1 = Boolean.TRUE;
        super("anchor_game_commerce_both_existed", "小手柄和购物车共存主播侧开关", r1, r1);
    }
}
