package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class vp extends SettingKey<Boolean> {
    public static final vp a = null;

    static {
        a = new vp();
    }

    public vp() {
        Boolean r1 = Boolean.TRUE;
        super("live_dynamic_item_behavior_fix_red_dot", "主播关闭送礼功能后拦截玩法入口点击", r1, r1);
    }
}
