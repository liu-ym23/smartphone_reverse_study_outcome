package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class he0 extends SSettingKey<bd1> {
    public static final he0 a = null;

    static {
        a = new he0();
    }

    public he0() {
        bd1 r0 = new bd1();
        r0.anchorFequency = 4.0f;
        r0.anchorMaximumCount = 5;
        r0.audienceFrequency = 4.0f;
        r0.audienceMaximumCount = 5;
        r0.permitUploadSizeForAndroid = 0;
        bd1 r4 = new bd1();
        r4.anchorFequency = 4.0f;
        r4.anchorMaximumCount = 5;
        r4.audienceFrequency = 4.0f;
        r4.audienceMaximumCount = 5;
        r4.permitUploadSizeForAndroid = 0;
        super("live_openplatform_snapshot_setting", "开放平台举报配置", r0, r4);
    }
}
