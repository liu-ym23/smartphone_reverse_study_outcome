package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d extends SettingKey<Boolean> {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
        Boolean r1 = Boolean.TRUE;
        super("anchor_game_commerce_both_existed_replace_dialog", "小手柄和购物车共存主播侧的切换弹窗逻辑开关", r1, r1);
    }
}
