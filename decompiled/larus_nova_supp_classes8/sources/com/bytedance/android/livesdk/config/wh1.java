package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class wh1 extends SettingKey<Boolean> {
    public static final wh1 a = null;

    static {
        a = new wh1();
    }

    public wh1() {
        Boolean r1 = Boolean.TRUE;
        super("toolbar_add_msg_filter_logic", "公共槽位msg前置过滤", r1, r1);
    }
}
