package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class qz0 extends SettingKey<Boolean> {
    public static final qz0 a = null;

    static {
        a = new qz0();
    }

    public qz0() {
        Boolean r4 = Boolean.TRUE;
        super("live_xplay_disallow_parent_intercept_touch_event", "多人场景嘉宾云游戏容器是否禁止父容器拦截TouchEvent", r4, r4, true);
    }
}
