package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class vn0 extends SettingKey<Boolean> {
    public static final vn0 a = null;

    static {
        a = new vn0();
    }

    public vn0() {
        Boolean r1 = Boolean.TRUE;
        super("live_room_battle_voice_wave_mix_fix", "厅战合流说话状态修复", r1, r1);
    }
}
