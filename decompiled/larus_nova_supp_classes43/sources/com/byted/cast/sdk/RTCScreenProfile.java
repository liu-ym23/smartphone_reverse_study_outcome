package com.byted.cast.sdk;

import android.os.Build;
import com.byted.cast.common.CastLogger;
import com.byted.cast.common.ContextManager;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class RTCScreenProfile implements Cloneable {
    public static final String TAG = "RTCScreenProfile";

    @SerializedName("bitrate")
    private int mBitrate;

    @SerializedName("bitrateBps")
    private Integer mBitrateBps;

    @SerializedName("bitrateMode")
    private RTCSetting.BITRATE_MODE mBitrateMode;

    @SerializedName("castContext")
    private ContextManager.CastContext mCastContext;

    @SerializedName("codecId")
    private RTCSetting.VCODEC_ID mCodecId;

    @SerializedName("dpi")
    private int mDpi;

    @SerializedName("mFps")
    private int mFps;

    @SerializedName("height")
    private int mHeight;

    @SerializedName("initialQP")
    private Integer mInitialQP;

    @SerializedName("initialQPB")
    private Integer mInitialQPB;

    @SerializedName("initialQPI")
    private Integer mInitialQPI;

    @SerializedName("initialQPP")
    private Integer mInitialQPP;

    @SerializedName("isEnabled")
    private boolean mIsEnabled;

    @SerializedName("fixedResolution")
    private boolean mIsFixedResolution;

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

    @SerializedName("projectMode")
    private PROJECTION_MODE mProjectionMode;

    @SerializedName("QP")
    private Integer mQp;

    @SerializedName("sccType")
    private SCC_TYPE mSccType;

    @SerializedName("width")
    private int mWidth;

    @SerializedName("MediaCodecFormat")
    Map<String, Integer> mediaFormatConfig;

    @SerializedName("virtualDisplayFlag")
    private int virtualDisplayFlag;

    @SerializedName("virtualDisplayName")
    private String virtualDisplayName;

    public static final enum PROJECTION_MODE extends Enum<PROJECTION_MODE> {
        private static final /* synthetic */ PROJECTION_MODE[] $VALUES = null;
        public static final PROJECTION_MODE PHONE_MIRROR = null;
        public static final PROJECTION_MODE TNT_DESKTOP = null;

        static {
            PROJECTION_MODE r0 = new PROJECTION_MODE("TNT_DESKTOP", 0);
            TNT_DESKTOP = r0;
            PROJECTION_MODE r1 = new PROJECTION_MODE("PHONE_MIRROR", 1);
            PHONE_MIRROR = r1;
            $VALUES = new PROJECTION_MODE[]{r0, r1};
        }

        public static PROJECTION_MODE[] values() {
            return (PROJECTION_MODE[]) $VALUES.clone();
        }

        public static PROJECTION_MODE valueOf(String r1) {
            return (PROJECTION_MODE) a.a(PROJECTION_MODE.class, r1);
        }

        private PROJECTION_MODE(String r1, int r10) {
            super(r1, r10);
        }
    }

    public static final enum SCC_TYPE extends Enum<SCC_TYPE> {
        private static final /* synthetic */ SCC_TYPE[] $VALUES = null;
        public static final SCC_TYPE COMPATIBLE = null;
        public static final SCC_TYPE FULL_FEATURE = null;
        public static final SCC_TYPE NONE = null;

        static {
            SCC_TYPE r0 = new SCC_TYPE("NONE", 0);
            NONE = r0;
            SCC_TYPE r1 = new SCC_TYPE("COMPATIBLE", 1);
            COMPATIBLE = r1;
            SCC_TYPE r10 = new SCC_TYPE("FULL_FEATURE", 2);
            FULL_FEATURE = r10;
            $VALUES = new SCC_TYPE[]{r0, r1, r10};
        }

        public static SCC_TYPE[] values() {
            return (SCC_TYPE[]) $VALUES.clone();
        }

        public static SCC_TYPE valueOf(String r1) {
            return (SCC_TYPE) a.a(SCC_TYPE.class, r1);
        }

        private SCC_TYPE(String r1, int r10) {
            super(r1, r10);
        }
    }

    public String toString() {
        return GsonProtectorUtils.toJson(new Gson(), this);
    }

    public RTCScreenProfile clone() {
        return (RTCScreenProfile) super.clone();
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

    public RTCSetting.VCODEC_ID getCodecId() {
        return this.mCodecId;
    }

    public int getDpi() {
        return this.mDpi;
    }

    public int getFps() {
        return this.mFps;
    }

    public int getHeight() {
        return this.mHeight;
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

    public Map<String, Integer> getMediaFormat() {
        return this.mediaFormatConfig;
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

    public PROJECTION_MODE getProjectionMode() {
        return this.mProjectionMode;
    }

    public Integer getQp() {
        return this.mQp;
    }

    public SCC_TYPE getSccType() {
        return this.mSccType;
    }

    public int getVirtualDisplayFlag() {
        return this.virtualDisplayFlag;
    }

    public String getVirtualDisplayName() {
        return this.virtualDisplayName;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean isEnabled() {
        return this.mIsEnabled;
    }

    public boolean isFixedResolution() {
        return this.mIsFixedResolution;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1clone() throws CloneNotSupportedException {
        return clone();
    }

    public RTCScreenProfile(ContextManager.CastContext r10) {
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDpi = 480;
        this.mCodecId = RTCSetting.VCODEC_ID.H264;
        this.mBitrateMode = RTCSetting.BITRATE_MODE.BITRATE_MODE_ABR;
        this.mBitrate = 16000;
        this.mMaxBitrate = 19200;
        this.mFps = 60;
        this.mIsFixedResolution = true;
        this.mSccType = SCC_TYPE.NONE;
        this.mIsEnabled = true;
        this.mProjectionMode = PROJECTION_MODE.PHONE_MIRROR;
        this.virtualDisplayFlag = 1;
        this.virtualDisplayName = "";
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
        this.mCastContext = r10;
        this.mLogger = ContextManager.getLogger(r10);
    }

    public RTCScreenProfile setBitrateBps(Integer r1) {
        this.mBitrateBps = r1;
        return this;
    }

    public RTCScreenProfile setBitrateMode(RTCSetting.BITRATE_MODE r1) {
        this.mBitrateMode = r1;
        return this;
    }

    public RTCScreenProfile setCodecId(RTCSetting.VCODEC_ID r1) {
        this.mCodecId = r1;
        return this;
    }

    public RTCScreenProfile setDpi(int r1) {
        this.mDpi = r1;
        return this;
    }

    public RTCScreenProfile setEnabled(boolean r1) {
        this.mIsEnabled = r1;
        return this;
    }

    public RTCScreenProfile setFixedResolution(boolean r1) {
        this.mIsFixedResolution = r1;
        return this;
    }

    public RTCScreenProfile setInitialQP(Integer r1) {
        this.mInitialQP = r1;
        return this;
    }

    public RTCScreenProfile setInitialQPB(Integer r1) {
        this.mInitialQPB = r1;
        return this;
    }

    public RTCScreenProfile setInitialQPI(Integer r1) {
        this.mInitialQPI = r1;
        return this;
    }

    public RTCScreenProfile setInitialQPP(Integer r1) {
        this.mInitialQPP = r1;
        return this;
    }

    public RTCScreenProfile setMaxQP(Integer r1) {
        this.mMaxQP = r1;
        return this;
    }

    public RTCScreenProfile setMaxQPB(Integer r1) {
        this.mMaxQPB = r1;
        return this;
    }

    public RTCScreenProfile setMaxQPP(Integer r1) {
        this.mMaxQPP = r1;
        return this;
    }

    public boolean setMediaFormat(Map<String, Integer> r10) {
        this.mediaFormatConfig = r10;
        if (Build.VERSION.SDK_INT > 21) goto L7;
        return false;
    L7:
        if (r10 != null) goto L9;
    L17:
        return true;
    L9:
        if (r10.containsKey("bitrate-mode") == false) goto L17;
        int r11 = r10.get("bitrate-mode").intValue();
        if (r11 != 1) goto L13;
        this.mBitrateMode = RTCSetting.BITRATE_MODE.BITRATE_MODE_VBR;
        goto L17
    L13:
        if (r11 == 2) goto L15;
        this.mBitrateMode = RTCSetting.BITRATE_MODE.BITRATE_MODE_ABR;
        goto L17
    L15:
        this.mBitrateMode = RTCSetting.BITRATE_MODE.BITRATE_MODE_CBR;
        goto L17
    }

    public RTCScreenProfile setMinQP(Integer r1) {
        this.mMinQP = r1;
        return this;
    }

    public RTCScreenProfile setMinQPB(Integer r1) {
        this.mMinQPB = r1;
        return this;
    }

    public RTCScreenProfile setMinQPP(Integer r1) {
        this.mMinQPP = r1;
        return this;
    }

    public void setProjectionMode(PROJECTION_MODE r1) {
        this.mProjectionMode = r1;
    }

    public RTCScreenProfile setQp(Integer r1) {
        this.mQp = r1;
        return this;
    }

    public RTCScreenProfile setSccType(SCC_TYPE r1) {
        this.mSccType = r1;
        return this;
    }

    public void setVirtualDisplayFlag(int r1) {
        this.virtualDisplayFlag = r1;
    }

    public void setVirtualDisplayName(String r1) {
        this.virtualDisplayName = r1;
    }

    public void setmFps(int r1) {
        this.mFps = r1;
    }

    public RTCScreenProfile setBitrate(int r1, int r10) {
        this.mBitrate = r1;
        this.mMaxBitrate = r10;
        return this;
    }

    public RTCScreenProfile setResolution(int r1, int r10) {
        this.mWidth = r1;
        this.mHeight = r10;
        return this;
    }
}
