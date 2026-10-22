package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class x6 extends SSettingKey<Boolean> {
    public static final x6 a = null;

    static {
        a = new x6();
    }

    public x6() {
        Boolean r1 = Boolean.TRUE;
        super("player_first_sei_fix_accurate_close", "播放器首帧SEI精准开关", r1, r1);
    }
}
