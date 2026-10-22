package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n9 extends SettingKey<Boolean> {
    public static final n9 a = null;

    static {
        a = new n9();
    }

    public n9() {
        Boolean r1 = Boolean.FALSE;
        super("live_3d_effect_enable", "手机端3D特效开播开关", r1, r1);
    }
}
