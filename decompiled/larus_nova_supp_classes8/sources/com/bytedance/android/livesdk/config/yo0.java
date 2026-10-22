package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class yo0 extends SettingKey<Boolean> {
    public static final yo0 a = null;

    static {
        a = new yo0();
    }

    public yo0() {
        Boolean r1 = Boolean.FALSE;
        super("live_room_offline_yellow_dot_bubble", "直播间黄点气泡治理", r1, r1);
    }
}
