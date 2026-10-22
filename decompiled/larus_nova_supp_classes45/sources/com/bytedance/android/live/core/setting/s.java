package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class s extends SSettingKey<String> {
    public static final s a = null;

    static {
        a = new s();
    }

    public s() {
        super("live_audio_channel_name", "播通知标题", "直播", "直播", false);
    }
}
