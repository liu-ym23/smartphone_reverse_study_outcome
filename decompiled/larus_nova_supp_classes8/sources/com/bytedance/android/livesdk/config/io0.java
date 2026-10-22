package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class io0 extends SettingKey<Long> {
    public static final io0 a = null;

    static {
        a = new io0();
    }

    public io0() {
        super("live_room_end_vip_time_out_seconds", "直播间结束后会员超时", 30L, 30L, false);
    }
}
