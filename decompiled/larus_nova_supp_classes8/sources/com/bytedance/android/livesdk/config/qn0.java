package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class qn0 extends SettingKey<Boolean> {
    public static final qn0 a = null;

    static {
        a = new qn0();
    }

    public qn0() {
        Boolean r1 = Boolean.FALSE;
        super("live_room_background_optimization", "直播间背景降噪", r1, r1);
    }
}
