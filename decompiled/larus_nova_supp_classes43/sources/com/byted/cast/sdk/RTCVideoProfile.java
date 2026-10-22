package com.byted.cast.sdk;

import com.byted.cast.common.CastLogger;
import com.byted.cast.common.ContextManager;
import com.bytedance.android.ec.core.utils.FontWeight;
import com.google.gson.annotations.SerializedName;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class RTCVideoProfile implements Cloneable {
    public static final String TAG = "RTCVideoProfile";

    @SerializedName("bitrate")
    private int mBitrate;

    @SerializedName("bitrateBps")
    private Integer mBitrateBps;

    @SerializedName("bitrateMode")
    private RTCSetting.BITRATE_MODE mBitrateMode;

    @SerializedName("cameraFacingId")
    private CAMERA_FACING_ID mCameraFacingId;

    @SerializedName("cameraPreviewFps")
    private int mCameraPreviewFps;

    @SerializedName("cameraPreviewHeight")
    private int mCameraPreviewHeight;

    @SerializedName("cameraPreviewMode")
    private CAMERA_PREVIEW_MODE mCameraPreviewMode;

    @SerializedName("cameraPreviewWidth")
    private int mCameraPreviewWidth;

    @SerializedName("setCaptureType")
    private int mCaptureType;

    @SerializedName("castContext")
    private ContextManager.CastContext mCastContext;

    @SerializedName("codecHeight")
    private int mCodecHeight;

    @SerializedName("codecId")
    private RTCSetting.VCODEC_ID mCodecId;

    @SerializedName("codecWidth")
    private int mCodecWidth;

    @SerializedName("initialQP")
    private Integer mInitialQP;

    @SerializedName("initialQPB")
    private Integer mInitialQPB;

    @SerializedName("initialQPI")
    private Integer mInitialQPI;

    @SerializedName("initialQPP")
    private Integer mInitialQPP;

    @SerializedName("autoPublish")
    private boolean mIsAutoPublish;

    @SerializedName("isEnabled")
    private boolean mIsEnabled;

    @SerializedName("fixedResolution")
    private boolean mIsFixedResolution;

    @SerializedName("ltr")
    private boolean mIsLtrEnabled;

    @SerializedName("layers")
    private int mLayers;

    @SerializedName("logger")
    private CastLogger mLogger;

    @SerializedName("maxBitrate")
    private int mMaxBitrate;

    @SerializedName("maxQP")
    private Integer mMaxQP;

    @SerializedName("maxQPB")
    private Integer mMaxQPB;

    @SerializedName("maxQPP")
    private Integer mMaxQPP;

    @SerializedName("minQP")
    private Integer mMinQP;

    @SerializedName("minQPB")
    private Integer mMinQPB;

    @SerializedName("minQPP")
    private Integer mMinQPP;

    @SerializedName("QP")
    private Integer mQp;

    public static final enum CAMERA_FACING_ID extends Enum<CAMERA_FACING_ID> {
        private static final /* synthetic */ CAMERA_FACING_ID[] $VALUES = null;
        public static final CAMERA_FACING_ID CAMERA_FACING_BACK = null;
        public static final CAMERA_FACING_ID CAMERA_FACING_FRONT = null;

        static {
            CAMERA_FACING_ID r0 = new CAMERA_FACING_ID("CAMERA_FACING_BACK", 0);
            CAMERA_FACING_BACK = r0;
            CAMERA_FACING_ID r1 = new CAMERA_FACING_ID("CAMERA_FACING_FRONT", 1);
            CAMERA_FACING_FRONT = r1;
            $VALUES = new CAMERA_FACING_ID[]{r0, r1};
        }

        public static CAMERA_FACING_ID[] values() {
            return (CAMERA_FACING_ID[]) $VALUES.clone();
        }

        public static CAMERA_FACING_ID valueOf(String r1) {
            return (CAMERA_FACING_ID) a.a(CAMERA_FACING_ID.class, r1);
        }

        private CAMERA_FACING_ID(String r1, int r10) {
            super(r1, r10);
        }
    }

    public static final enum CAMERA_PREVIEW_MODE extends Enum<CAMERA_PREVIEW_MODE> {
        private static final /* synthetic */ CAMERA_PREVIEW_MODE[] $VALUES = null;
        public static final CAMERA_PREVIEW_MODE FIT = null;
        public static final CAMERA_PREVIEW_MODE FULL = null;

        static {
            CAMERA_PREVIEW_MODE r0 = new CAMERA_PREVIEW_MODE("FIT", 0);
            FIT = r0;
            CAMERA_PREVIEW_MODE r1 = new CAMERA_PREVIEW_MODE("FULL", 1);
            FULL = r1;
            $VALUES = new CAMERA_PREVIEW_MODE[]{r0, r1};
        }

        public static CAMERA_PREVIEW_MODE[] values() {
            return (CAMERA_PREVIEW_MODE[]) $VALUES.clone();
        }

        public static CAMERA_PREVIEW_MODE valueOf(String r1) {
            return (CAMERA_PREVIEW_MODE) a.a(CAMERA_PREVIEW_MODE.class, r1);
        }

        private CAMERA_PREVIEW_MODE(String r1, int r10) {
            super(r1, r10);
        }
    }

    public boolean isAutoPublish() {
        if (this.mIsEnabled == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mIsAutoPublish == false) goto L7;
        return true;
    }

    public boolean isSimulcastEnabled() {
        if (this.mLayers > 1) goto L7;
        return false;
    L7:
        return true;
    }

    public String toString() {
        return "RTCVideoProfile{mCameraFacingId=" + this.mCameraFacingId + ", mCameraPreviewMode=" + this.mCameraPreviewMode + ", mCodecId=" + this.mCodecId + ", mBitrateMode=" + this.mBitrateMode + ", mBitrate=" + this.mBitrate + ", mMaxBitrate=" + this.mMaxBitrate + ", mCameraPreviewWidth=" + this.mCameraPreviewWidth + ", mCameraPreviewHeight=" + this.mCameraPreviewHeight + ", mCameraPreviewFps=" + this.mCameraPreviewFps + ", mIsFixedResolution=" + this.mIsFixedResolution + ", mIsLtrEnabled=" + this.mIsLtrEnabled + ", mIsAutoPublish=" + this.mIsAutoPublish + ", mIsEnabled=" + this.mIsEnabled + ", mLayers=" + this.mLayers + ", mCodecWidth=" + this.mCodecWidth + ", mCodecHeight=" + this.mCodecHeight + ", mMinQP=" + this.mMinQP + ", mMaxQP=" + this.mMaxQP + ", mMinQPP=" + this.mMinQPP + ", mMaxQPP=" + this.mMaxQPP + ", mMinQPB=" + this.mMinQPB + ", mMaxQPB=" + this.mMaxQPB + ", mInitialQP=" + this.mInitialQP + ", mInitialQPI=" + this.mInitialQPI + ", mInitialQPP=" + this.mInitialQPP + ", initialQPB=" + this.mInitialQPB + ", mQp=" + this.mQp + ", mBitrateBps=" + this.mBitrateBps + '}';
    }

    public RTCVideoProfile clone() {
        return (RTCVideoProfile) super.clone();
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public int getBitrate() {
        return this.mBitrate;
    }

    public Integer getBitrateBps() {
        return this.mBitrateBps;
    }

    public RTCSetting.BITRATE_MODE getBitrateMode() {
        return this.mBitrateMode;
    }

    public CAMERA_FACING_ID getCameraId() {
        return this.mCameraFacingId;
    }

    public int getCameraPreviewFps() {
        return this.mCameraPreviewFps;
    }

    public int getCameraPreviewHeight() {
        return this.mCameraPreviewHeight;
    }

    public CAMERA_PREVIEW_MODE getCameraPreviewMode() {
        return this.mCameraPreviewMode;
    }

    public int getCameraPreviewWidth() {
        return this.mCameraPreviewWidth;
    }

    public int getCaptureType() {
        return this.mCaptureType;
    }

    public int getCodecHeight() {
        return this.mCodecHeight;
    }

    public RTCSetting.VCODEC_ID getCodecId() {
        return this.mCodecId;
    }

    public int getCodecWidth() {
        return this.mCodecWidth;
    }

    public Integer getInitialQP() {
        return this.mInitialQP;
    }

    public Integer getInitialQPB() {
        return this.mInitialQPB;
    }

    public Integer getInitialQPI() {
        return this.mInitialQPI;
    }

    public Integer getInitialQPP() {
        return this.mInitialQPP;
    }

    public int getLayers() {
        return this.mLayers;
    }

    public int getMaxBitrate() {
        return this.mMaxBitrate;
    }

    public Integer getMaxQP() {
        return this.mMaxQP;
    }

    public Integer getMaxQPB() {
        return this.mMaxQPB;
    }

    public Integer getMaxQPP() {
        return this.mMaxQPP;
    }

    public Integer getMinQP() {
        return this.mMinQP;
    }

    public Integer getMinQPB() {
        return this.mMinQPB;
    }

    public Integer getMinQPP() {
        return this.mMinQPP;
    }

    public Integer getQp() {
        return this.mQp;
    }

    public boolean isEnabled() {
        return this.mIsEnabled;
    }

    public boolean isFixedResolution() {
        return this.mIsFixedResolution;
    }

    public boolean isLtrEnabled() {
        return this.mIsLtrEnabled;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m2clone() throws CloneNotSupportedException {
        return clone();
    }

    public RTCVideoProfile(ContextManager.CastContext r10) {
        this.mCameraFacingId = CAMERA_FACING_ID.CAMERA_FACING_FRONT;
        this.mCameraPreviewMode = CAMERA_PREVIEW_MODE.FULL;
        this.mCodecId = RTCSetting.VCODEC_ID.H265;
        this.mBitrateMode = RTCSetting.BITRATE_MODE.BITRATE_MODE_VBR;
        this.mBitrate = 350;
        this.mMaxBitrate = FontWeight.WEIGHT_600;
        this.mCameraPreviewWidth = 848;
        this.mCameraPreviewHeight = 480;
        this.mCameraPreviewFps = 20;
        this.mIsFixedResolution = false;
        this.mIsLtrEnabled = false;
        this.mIsAutoPublish = true;
        this.mIsEnabled = true;
        this.mLayers = 1;
        this.mCodecWidth = 1280;
        this.mCodecHeight = 720;
        this.mMinQP = null;
        this.mMaxQP = null;
        this.mMinQPP = null;
        this.mMaxQPP = null;
        this.mMinQPB = null;
        this.mMaxQPB = null;
        this.mInitialQP = null;
        this.mInitialQPI = null;
        this.mInitialQPP = null;
        this.mInitialQPB = null;
        this.mQp = null;
        this.mBitrateBps = null;
        this.mCaptureType = 0;
        this.mCastContext = r10;
        this.mLogger = ContextManager.getLogger(r10);
    }

    public RTCVideoProfile setBitrateBps(Integer r1) {
        this.mBitrateBps = r1;
        return this;
    }

    public RTCVideoProfile setBitrateMode(RTCSetting.BITRATE_MODE r1) {
        this.mBitrateMode = r1;
        return this;
    }

    public RTCVideoProfile setCameraId(CAMERA_FACING_ID r1) {
        this.mCameraFacingId = r1;
        return this;
    }

    public RTCVideoProfile setCameraPreviewFps(int r1) {
        this.mCameraPreviewFps = r1;
        return this;
    }

    public RTCVideoProfile setCameraPreviewMode(CAMERA_PREVIEW_MODE r1) {
        this.mCameraPreviewMode = r1;
        return this;
    }

    public void setCaptureType(int r1) {
        this.mCaptureType = r1;
    }

    public RTCVideoProfile setCodecId(RTCSetting.VCODEC_ID r1) {
        this.mCodecId = r1;
        return this;
    }

    public RTCVideoProfile setEnabled(boolean r1) {
        this.mIsEnabled = r1;
        if (r1 == true) goto L5;
        this.mIsAutoPublish = false;
    L5:
        return this;
    }

    public RTCVideoProfile setFixedResolution(boolean r1) {
        this.mIsFixedResolution = r1;
        return this;
    }

    public RTCVideoProfile setInitialQP(Integer r1) {
        this.mInitialQP = r1;
        return this;
    }

    public RTCVideoProfile setInitialQPB(Integer r1) {
        this.mInitialQPB = r1;
        return this;
    }

    public RTCVideoProfile setInitialQPI(Integer r1) {
        this.mInitialQPI = r1;
        return this;
    }

    public RTCVideoProfile setInitialQPP(Integer r1) {
        this.mInitialQPP = r1;
        return this;
    }

    public RTCVideoProfile setIsAutoPublish(boolean r1) {
        this.mIsAutoPublish = r1;
        return this;
    }

    public RTCVideoProfile setIsLtrEnabled(boolean r1) {
        this.mIsLtrEnabled = r1;
        return this;
    }

    public RTCVideoProfile setIsSimulcastEnabled(boolean r1) {
        if (r1 == false) goto L4;
        int r10 = 2;
    L5:
        this.mLayers = r10;
        return this;
    L4:
        r10 = 1;
        goto L5
    }

    public RTCVideoProfile setMaxQP(Integer r1) {
        this.mMaxQP = r1;
        return this;
    }

    public RTCVideoProfile setMaxQPB(Integer r1) {
        this.mMaxQPB = r1;
        return this;
    }

    public RTCVideoProfile setMaxQPP(Integer r1) {
        this.mMaxQPP = r1;
        return this;
    }

    public RTCVideoProfile setMinQP(Integer r1) {
        this.mMinQP = r1;
        return this;
    }

    public RTCVideoProfile setMinQPB(Integer r1) {
        this.mMinQPB = r1;
        return this;
    }

    public RTCVideoProfile setMinQPP(Integer r1) {
        this.mMinQPP = r1;
        return this;
    }

    public RTCVideoProfile setQp(Integer r1) {
        this.mQp = r1;
        return this;
    }

    public RTCVideoProfile setBitrate(int r1, int r10) {
        this.mBitrate = r1;
        this.mMaxBitrate = r10;
        return this;
    }

    public RTCVideoProfile setCameraPreviewSize(int r1, int r10) {
        this.mCameraPreviewWidth = r1;
        this.mCameraPreviewHeight = r10;
        return this;
    }

    public void setCodecSize(int r1, int r10) {
        this.mCodecWidth = r1;
        this.mCodecHeight = r10;
    }
}
