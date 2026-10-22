package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.CloudGroupLiveDeviceScoreConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class il extends SSettingKey<CloudGroupLiveDeviceScoreConfig> {
    public static final il a = null;

    static {
        a = new il();
    }

    public il() {
        super("live_cloud_collaborate_settings", "云团播主播设备机型准入", new CloudGroupLiveDeviceScoreConfig(), new CloudGroupLiveDeviceScoreConfig());
    }
}
