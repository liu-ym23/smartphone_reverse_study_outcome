package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class wn extends SettingKey<Boolean> {
    public static final wn a = null;

    static {
        a = new wn();
    }

    public wn() {
        Boolean r1 = Boolean.TRUE;
        super("live_disable_enter_anim_widget_landscape", "横屏不加载EnterAnimWidget", r1, r1);
    }
}
