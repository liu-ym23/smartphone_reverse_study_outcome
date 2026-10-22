package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ot extends SettingKey<Boolean> {
    public static final ot a = null;

    static {
        a = new ot();
    }

    public ot() {
        Boolean r4 = Boolean.TRUE;
        super("live_enable_xplay_show_sei_delay", "xplay云游戏容器是否显示操作延迟", r4, r4, true);
    }
}
