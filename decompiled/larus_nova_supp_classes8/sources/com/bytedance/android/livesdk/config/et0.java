package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class et0 extends SettingKey<Boolean> {
    public static final et0 a = null;

    static {
        a = new et0();
    }

    public et0() {
        Boolean r1 = Boolean.TRUE;
        super("live_anchor_interact_effect_opt", "开播互动特效佩戴链路优化", r1, r1);
    }
}
