package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class y extends SSettingKey<Boolean> {
    public static final y a = null;

    static {
        a = new y();
    }

    public y() {
        Boolean r1 = Boolean.TRUE;
        super("live_audio_subtitle_setting_reget", "语音聊天室实时字幕开关重新获取一次", r1, r1);
    }
}
