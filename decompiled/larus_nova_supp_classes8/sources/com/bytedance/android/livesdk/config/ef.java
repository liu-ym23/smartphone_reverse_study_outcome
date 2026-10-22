package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.model.AudioBgDeviceConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ef extends SettingKey<AudioBgDeviceConfig> {
    public static final ef a = null;

    static {
        a = new ef();
    }

    public ef() {
        super("live_audio_bg_device_config", "语音静态背景降级机型打分", AudioBgDeviceConfig.defaultConfig(), AudioBgDeviceConfig.defaultConfig());
    }
}
