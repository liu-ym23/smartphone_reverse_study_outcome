package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class w6 extends SSettingKey<Boolean> {
    public static final w6 a = null;

    static {
        a = new w6();
    }

    public w6() {
        Boolean r1 = Boolean.FALSE;
        super("player_consume_first_sei_fix", "播放器首帧SEI消费fix", r1, r1);
    }
}
