package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.LivePlayerSeekMsgTextConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ki0 extends SSettingKey<LivePlayerSeekMsgTextConfig> {
    public static final ki0 a = null;

    static {
        a = new ki0();
    }

    public ki0() {
        super("live_player_seek_message_text", "下掉实时回放的文案", new LivePlayerSeekMsgTextConfig(), new LivePlayerSeekMsgTextConfig());
    }
}
