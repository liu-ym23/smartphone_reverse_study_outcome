package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class p3 extends SSettingKey<Boolean> {
    public static final p3 a = null;

    static {
        a = new p3();
    }

    public p3() {
        super("live_pc_customize_audio_room_forbid_audio_background", Boolean.TRUE, "PC自定义语音直播间禁用语音背景");
    }
}
