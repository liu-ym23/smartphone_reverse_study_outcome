package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.AudioRadioChatPanelConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class lf extends SSettingKey<AudioRadioChatPanelConfig> {
    public static final lf a = null;

    static {
        a = new lf();
    }

    public lf() {
        super("live_audio_radio_chat_panel_config", "电台连线面板配置", new AudioRadioChatPanelConfig(), new AudioRadioChatPanelConfig());
    }
}
