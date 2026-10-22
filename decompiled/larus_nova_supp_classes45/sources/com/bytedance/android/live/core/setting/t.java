package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class t extends SSettingKey<Boolean> {
    public static final t a = null;

    static {
        a = new t();
    }

    public t() {
        Boolean r1 = Boolean.TRUE;
        super("live_audio_chat_room_zero_link_opt", "语音聊天室0连加入RTC改造", r1, r1);
    }
}
