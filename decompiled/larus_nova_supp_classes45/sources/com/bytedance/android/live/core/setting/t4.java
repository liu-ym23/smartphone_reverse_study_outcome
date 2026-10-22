package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class t4 extends SSettingKey<Boolean> {
    public static final t4 a = null;

    static {
        a = new t4();
    }

    public t4() {
        Boolean r1 = Boolean.FALSE;
        super("live_room_black_screenbg_fix", "直播间黑屏背景被遮挡修复", r1, r1);
    }
}
