package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class uy extends SettingKey<Boolean> {
    public static final uy a = null;

    static {
        a = new uy();
    }

    public uy() {
        Boolean r1 = Boolean.TRUE;
        super("live_gift_close_anchor_block_switch", "主播关闭送礼功能后拦截玩法入口点击", r1, r1);
    }
}
