package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o9 extends SettingKey<Boolean> {
    public static final o9 a = null;

    static {
        a = new o9();
    }

    public o9() {
        Boolean r1 = Boolean.TRUE;
        super("live_3d_effect_enable_safe", "手机端3D特效开播开关兜底", r1, r1);
    }
}
