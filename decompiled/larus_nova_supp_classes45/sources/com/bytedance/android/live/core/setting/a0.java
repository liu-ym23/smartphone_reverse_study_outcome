package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a0 extends SSettingKey<Integer> {
    public static final a0 a = null;

    static {
        a = new a0();
    }

    public a0() {
        super("live_chat_channel_audio_playback_default_volume", "频道房边看边聊聊天默认音量", 25, 25);
    }
}
