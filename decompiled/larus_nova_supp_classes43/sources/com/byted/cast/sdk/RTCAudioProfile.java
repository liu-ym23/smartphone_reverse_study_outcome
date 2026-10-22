package com.byted.cast.sdk;

import android.media.audiofx.AcousticEchoCanceler;
import android.media.audiofx.NoiseSuppressor;
import com.byted.cast.common.CastLogger;
import com.byted.cast.common.ContextManager;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class RTCAudioProfile implements Cloneable {
    public static final String TAG = "RTCAudioProfile";

    @SerializedName("audioAecType")
    private AEC_TYPE mAECType;

    @SerializedName("audioAgcType")
    private AGC_TYPE mAGCType;

    @SerializedName("audioAncType")
    private ANC_TYPE mANCType;

    @SerializedName("audioPtsOptimizeEnable")
    private boolean mAudioPtsOptimizeEnable;

    @SerializedName("audioSource")
    private int mAudioSource;

    @SerializedName("audioStreamType")
    private int mAudioStreamType;

    @SerializedName("bitrate")
    private int mBitrate;

    @SerializedName("audioBitrateMode")
    private RTCSetting.BITRATE_MODE mBitrateMode;

    @SerializedName("bitwidth")
    private int mBitwidth;

    @SerializedName("bluetoothSCOEnabled")
    private boolean mBluetoothSCOEnabled;

    @SerializedName("samplerate")
    private int mCaptureSampleRate;

    @SerializedName("castContext")
    private ContextManager.CastContext mCastContext;

    @SerializedName("codecId")
    private RTCSetting.ACODEC_ID mCodecId;

    @SerializedName("autoPublish")
    private boolean mIsAutoPublish;

    @SerializedName("autoSubscribe")
    private boolean mIsAutoSubscribe;

    @SerializedName("isEchoDetectionEnabled")
    private boolean mIsEchoDetectionEnabled;

    @SerializedName("isEnabled")
    private boolean mIsEnabled;

    @SerializedName("isHwAecEnabled")
    private boolean mIsHwAecEnabled;

    @SerializedName("isHwNSEnabled")
    private boolean mIsHwNSEnabled;

    @SerializedName("logger")
    private CastLogger mLogger;

    @SerializedName("maxBitrate")
    private int mMaxBitrate;

    @SerializedName("channels")
    private int mNumberOfChannels;

    @SerializedName("pbsamplerate")
    private int mPlaybackSampleRate;

    @SerializedName("useMediaProjection")
    private boolean mUseMediaProjection;

    public static final enum AEC_TYPE extends Enum<AEC_TYPE> {
        private static final /* synthetic */ AEC_TYPE[] $VALUES = null;
        public static final AEC_TYPE AEC3 = null;
        public static final AEC_TYPE AECM = null;
        public static final AEC_TYPE AUTO = null;
        public static final AEC_TYPE BYTE = null;
        public static final AEC_TYPE NONE = null;

        static {
            AEC_TYPE r0 = new AEC_TYPE("NONE", 0);
            NONE = r0;
            AEC_TYPE r1 = new AEC_TYPE("AUTO", 1);
            AUTO = r1;
            AEC_TYPE r10 = new AEC_TYPE("AEC3", 2);
            AEC3 = r10;
            AEC_TYPE r11 = new AEC_TYPE("AECM", 3);
            AECM = r11;
            AEC_TYPE r12 = new AEC_TYPE("BYTE", 4);
            BYTE = r12;
            $VALUES = new AEC_TYPE[]{r0, r1, r10, r11, r12};
        }

        public static AEC_TYPE[] values() {
            return (AEC_TYPE[]) $VALUES.clone();
        }

        public static AEC_TYPE valueOf(String r1) {
            return (AEC_TYPE) a.a(AEC_TYPE.class, r1);
        }

        private AEC_TYPE(String r1, int r10) {
            super(r1, r10);
        }
    }

    public static final enum AGC_TYPE extends Enum<AGC_TYPE> {
        private static final /* synthetic */ AGC_TYPE[] $VALUES = null;
        public static final AGC_TYPE AUTO = null;
        public static final AGC_TYPE BYTE = null;
        public static final AGC_TYPE NONE = null;
        public static final AGC_TYPE WEBRTC = null;

        static {
            AGC_TYPE r0 = new AGC_TYPE("NONE", 0);
            NONE = r0;
            AGC_TYPE r1 = new AGC_TYPE("AUTO", 1);
            AUTO = r1;
            AGC_TYPE r10 = new AGC_TYPE("WEBRTC", 2);
            WEBRTC = r10;
            AGC_TYPE r11 = new AGC_TYPE("BYTE", 3);
            BYTE = r11;
            $VALUES = new AGC_TYPE[]{r0, r1, r10, r11};
        }

        public static AGC_TYPE[] values() {
            return (AGC_TYPE[]) $VALUES.clone();
        }

        public static AGC_TYPE valueOf(String r1) {
            return (AGC_TYPE) a.a(AGC_TYPE.class, r1);
        }

        private AGC_TYPE(String r1, int r10) {
            super(r1, r10);
        }
    }

    public static final enum ANC_TYPE extends Enum<ANC_TYPE> {
        private static final /* synthetic */ ANC_TYPE[] $VALUES = null;
        public static final ANC_TYPE AUTO = null;
        public static final ANC_TYPE BYTE = null;
        public static final ANC_TYPE NONE = null;
        public static final ANC_TYPE NSX = null;
        public static final ANC_TYPE RNN = null;

        static {
            ANC_TYPE r0 = new ANC_TYPE("NONE", 0);
            NONE = r0;
            ANC_TYPE r1 = new ANC_TYPE("AUTO", 1);
            AUTO = r1;
            ANC_TYPE r10 = new ANC_TYPE("NSX", 2);
            NSX = r10;
            ANC_TYPE r11 = new ANC_TYPE("BYTE", 3);
            BYTE = r11;
            ANC_TYPE r12 = new ANC_TYPE("RNN", 4);
            RNN = r12;
            $VALUES = new ANC_TYPE[]{r0, r1, r10, r11, r12};
        }

        public static ANC_TYPE[] values() {
            return (ANC_TYPE[]) $VALUES.clone();
        }

        public static ANC_TYPE valueOf(String r1) {
            return (ANC_TYPE) a.a(ANC_TYPE.class, r1);
        }

        private ANC_TYPE(String r1, int r10) {
            super(r1, r10);
        }
    }

    public static int getFrameSize(int r1) {
        if (r1 != 8000) goto L5;
        return 640;
    L5:
        if (r1 != 16000) goto L7;
        return 1280;
    L7:
        if (r1 != 32000) goto L9;
        return 2560;
    L9:
        if (r1 != 44100) goto L11;
        return 3528;
    L11:
        if (r1 == 48000) goto L13;
        return 3840;
    L13:
        return 4096;
    }

    public boolean isAutoPublish() {
        if (this.mIsEnabled == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mIsAutoPublish == false) goto L7;
        return true;
    }

    public boolean isAutoSubscribe() {
        if (this.mIsEnabled == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mIsAutoSubscribe == false) goto L7;
        return true;
    }

    public String toString() {
        return GsonProtectorUtils.toJson(new Gson(), this);
    }

    public RTCAudioProfile clone() {
        return (RTCAudioProfile) super.clone();
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public AEC_TYPE getAECType() {
        return this.mAECType;
    }

    public AGC_TYPE getAGCType() {
        return this.mAGCType;
    }

    public ANC_TYPE getANCType() {
        return this.mANCType;
    }

    public int getAudioSource() {
        return this.mAudioSource;
    }

    public int getAudioStreamType() {
        return this.mAudioStreamType;
    }

    public int getBitrate() {
        return this.mBitrate;
    }

    public RTCSetting.BITRATE_MODE getBitrateMode() {
        return this.mBitrateMode;
    }

    public int getBitwidth() {
        return this.mBitwidth;
    }

    public RTCSetting.ACODEC_ID getCodecId() {
        return this.mCodecId;
    }

    public int getMaxBitrate() {
        return this.mMaxBitrate;
    }

    public int getNumberOfChannels() {
        return this.mNumberOfChannels;
    }

    public int getPlaySampleRate() {
        return this.mPlaybackSampleRate;
    }

    public int getRecordSampleRate() {
        return this.mCaptureSampleRate;
    }

    public boolean isAudioPtsOptimizeEnabled() {
        return this.mAudioPtsOptimizeEnable;
    }

    public boolean isBluetoothSCOEnabled() {
        return this.mBluetoothSCOEnabled;
    }

    public boolean isEchoDetectionEnabled() {
        return this.mIsEchoDetectionEnabled;
    }

    public boolean isEnabled() {
        return this.mIsEnabled;
    }

    public boolean isHwAECEnabled() {
        return this.mIsHwAecEnabled;
    }

    public boolean isHwNSEnabled() {
        return this.mIsHwNSEnabled;
    }

    public boolean isUseMediaProjection() {
        return this.mUseMediaProjection;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m0clone() throws CloneNotSupportedException {
        return clone();
    }

    public RTCAudioProfile(ContextManager.CastContext r10) {
        this.mAudioSource = 8;
        this.mUseMediaProjection = false;
        this.mAudioStreamType = 3;
        this.mCaptureSampleRate = 48000;
        this.mPlaybackSampleRate = 48000;
        this.mNumberOfChannels = 2;
        this.mBitwidth = 16;
        this.mBluetoothSCOEnabled = false;
        this.mAudioPtsOptimizeEnable = true;
        this.mIsHwNSEnabled = false;
        this.mIsHwAecEnabled = false;
        this.mCodecId = RTCSetting.ACODEC_ID.AAC;
        this.mAECType = AEC_TYPE.NONE;
        this.mANCType = ANC_TYPE.NONE;
        this.mAGCType = AGC_TYPE.NONE;
        this.mBitrateMode = RTCSetting.BITRATE_MODE.BITRATE_MODE_ABR;
        this.mBitrate = 192;
        this.mMaxBitrate = 192;
        this.mIsAutoPublish = true;
        this.mIsAutoSubscribe = true;
        this.mIsEchoDetectionEnabled = false;
        this.mIsEnabled = true;
        this.mCastContext = r10;
        this.mLogger = ContextManager.getLogger(r10);
    }

    public RTCAudioProfile setAECType(AEC_TYPE r1) {
        this.mAECType = r1;
        return this;
    }

    public RTCAudioProfile setAGCType(AGC_TYPE r1) {
        this.mAGCType = r1;
        return this;
    }

    public RTCAudioProfile setANCType(ANC_TYPE r1) {
        this.mANCType = r1;
        return this;
    }

    public RTCAudioProfile setAudioFormat(int r1) {
        this.mBitwidth = r1;
        return this;
    }

    public RTCAudioProfile setAudioSource(int r1) {
        this.mAudioSource = r1;
        return this;
    }

    public RTCAudioProfile setAudioStreamType(int r1) {
        this.mAudioStreamType = r1;
        return this;
    }

    public RTCAudioProfile setBitrateMode(RTCSetting.BITRATE_MODE r1) {
        this.mBitrateMode = r1;
        return this;
    }

    public RTCAudioProfile setBluetoothSCOEnabled(boolean r1) {
        this.mBluetoothSCOEnabled = r1;
        return this;
    }

    public RTCAudioProfile setCodecId(RTCSetting.ACODEC_ID r1) {
        this.mCodecId = r1;
        return this;
    }

    public RTCAudioProfile setEnabled(boolean r1) {
        this.mIsEnabled = r1;
        if (r1 == true) goto L5;
        this.mIsAutoPublish = false;
        this.mIsAutoSubscribe = false;
    L5:
        return this;
    }

    public boolean setHwAECEnabled(boolean r10) {
        if (AcousticEchoCanceler.isAvailable() == false) goto L6;
        this.mIsHwAecEnabled = r10;
        this.mLogger.i(TAG, "setAECEnabled " + r10);
        return true;
    L6:
        this.mLogger.e(TAG, "failed to setAECEnabled, AcousticEchoCanceler not available !");
        return false;
    }

    public boolean setHwNSEnabled(boolean r10) {
        if (NoiseSuppressor.isAvailable() == false) goto L6;
        this.mIsHwNSEnabled = r10;
        this.mLogger.i(TAG, "setNSEnabled " + r10);
        return true;
    L6:
        this.mLogger.e(TAG, "failed to setNSEnabled, NoiseSuppressor not available !");
        return false;
    }

    public RTCAudioProfile setIsAutoPublish(boolean r1) {
        this.mIsAutoPublish = r1;
        return this;
    }

    public RTCAudioProfile setIsAutoSubscribe(boolean r1) {
        this.mIsAutoSubscribe = r1;
        return this;
    }

    public RTCAudioProfile setIsEchoDetectionEnabled(boolean r1) {
        this.mIsEchoDetectionEnabled = r1;
        return this;
    }

    public RTCAudioProfile setNumberOfChannels(int r1) {
        this.mNumberOfChannels = r1;
        return this;
    }

    public RTCAudioProfile setPtsOptimizeEnabled(boolean r1) {
        this.mAudioPtsOptimizeEnable = r1;
        return this;
    }

    public RTCAudioProfile setSampleRate(int r1) {
        this.mCaptureSampleRate = r1;
        return this;
    }

    public void setUseMediaProjection(boolean r1) {
        this.mUseMediaProjection = r1;
    }

    public RTCAudioProfile setBitrate(int r1, int r10) {
        this.mBitrate = r1;
        this.mMaxBitrate = r10;
        return this;
    }
}
