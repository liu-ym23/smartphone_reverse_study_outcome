package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class m81 {

    @SerializedName("captureFps")
    public int mCaptureFps;

    @SerializedName("defaultbBitRate")
    public int mDefaultBitrate;

    @SerializedName("enable")
    public boolean mEnable;

    @SerializedName("fps")
    public int mFps;

    @SerializedName("height")
    public int mHeight;

    @SerializedName("maxBitRate")
    public int mMaxBitrate;

    @SerializedName("minBitRate")
    public int mMinBitrate;

    @SerializedName("useHardware")
    public boolean mUseHardware;

    @SerializedName("vCode")
    public String mVCodec;

    @SerializedName("with")
    public int mWidth;

    public m81() {
        this.mEnable = false;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mDefaultBitrate = -1;
        this.mMinBitrate = -1;
        this.mMaxBitrate = -1;
        this.mFps = -1;
        this.mVCodec = "";
        this.mUseHardware = true;
        this.mCaptureFps = -1;
    }
}
