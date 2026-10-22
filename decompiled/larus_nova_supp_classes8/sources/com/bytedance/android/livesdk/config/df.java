package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.privacy.av.api.PrivacyConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class df extends SSettingKey<PrivacyConfig> {
    public static final df a = null;

    static {
        a = new df();
    }

    public df() {
        super(LiveInitSettingKeys.LIVE_AUDIO_AND_VIDEO_PRIVACY_CONFIG, "音视频隐私开关", new PrivacyConfig(), new PrivacyConfig());
    }
}
