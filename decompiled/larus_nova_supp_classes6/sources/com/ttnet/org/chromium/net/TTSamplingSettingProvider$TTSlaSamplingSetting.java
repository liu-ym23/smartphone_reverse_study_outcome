package com.ttnet.org.chromium.net;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class TTSamplingSettingProvider$TTSlaSamplingSetting {
    public TTSamplingSettingProvider$TTEventLogSamplingRule mEventLogSamplingRule;
    public int mHostAid;
    public int mSdkAid;
    public TTSamplingSettingProvider$TTSlaSamplingRule mSlaSamplingRule;

    public TTSamplingSettingProvider$TTSlaSamplingSetting() {
    }

    public TTSamplingSettingProvider$TTEventLogSamplingRule getEventLogSamplingRule() {
        return this.mEventLogSamplingRule;
    }

    public int getHostAid() {
        return this.mHostAid;
    }

    public int getSdkAid() {
        return this.mSdkAid;
    }

    public TTSamplingSettingProvider$TTSlaSamplingRule getSlaSamplingRule() {
        return this.mSlaSamplingRule;
    }
}
