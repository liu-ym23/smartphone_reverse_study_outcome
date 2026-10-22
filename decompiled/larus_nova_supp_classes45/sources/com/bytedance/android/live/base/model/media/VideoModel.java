package com.bytedance.android.live.base.model.media;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class VideoModel {
    private static final CoverType DEFAULT_COVER_TYPE = null;
    public static final int GIF_TYPE = 0;
    public static final int WEBP_TYPE = 1;

    @SerializedName("allow_cache")
    private boolean allowCache;

    @SerializedName("avg_color")
    private int avgColor;

    @SerializedName("cover_medium")
    private k coverMediumModel;

    @SerializedName("cover")
    private k coverModel;

    @SerializedName("cover_thumb")
    private k coverThumbModel;

    @SerializedName("download_url")
    private List<String> downloadList;

    @SerializedName("duration")
    private double duration;

    @SerializedName(alternate = {"dynamic_cover"}, value = "cover_animated")
    private k dynamicCoverModel;

    @SerializedName("first_frame")
    private k firstFrame;

    @SerializedName("gif_type")
    private int gifType;

    @SerializedName("gif_url_list")
    private List<String> gifUrlList;

    @SerializedName("height")
    private int height;

    @SerializedName("long_duration")
    private float longDuration;

    @SerializedName("long_uri")
    private String longUri;

    @SerializedName("long_url")
    private List<String> longUrls;
    private CoverType mCoverType;

    @SerializedName("preload_size")
    private int preloadSize;

    @SerializedName("quality_info")
    private List<c> qualityInfo;

    @SerializedName("uri")
    private String uri;

    @SerializedName("url_list")
    private List<String> urlList;

    @SerializedName("videoLocalPath")
    private String videoLocalPath;

    @SerializedName("watermark")
    private boolean waterMark;

    @SerializedName("width")
    private int width;

    public static final enum CoverType extends Enum<CoverType> {
        public static final CoverType LARGE = null;
        public static final CoverType MEDIUM = null;
        public static final CoverType THUMB = null;
        public static final /* synthetic */ CoverType[] a = null;

        static {
            CoverType r0 = new CoverType("LARGE", 0);
            LARGE = r0;
            CoverType r1 = new CoverType("MEDIUM", 1);
            MEDIUM = r1;
            CoverType r3 = new CoverType("THUMB", 2);
            THUMB = r3;
            a = new CoverType[]{r0, r1, r3};
        }

        public static CoverType[] values() {
            return (CoverType[]) a.clone();
        }

        public static CoverType valueOf(String r1) {
            return (CoverType) r27.a.a(CoverType.class, r1);
        }

        public CoverType(String r1, int r2) {
            super(r1, r2);
        }
    }

    static {
        DEFAULT_COVER_TYPE = CoverType.LARGE;
    }

    public VideoModel() {
        this.preloadSize = 512000;
        this.mCoverType = DEFAULT_COVER_TYPE;
    }

    public String getUnbitratedUri() {
        if (TextUtils.isEmpty(getUri()) == false) goto L6;
        return "";
    L6:
        return getUri();
    }

    public List<c> getBitRate() {
        return this.qualityInfo;
    }

    public k getCoverMediumModel() {
        return this.coverMediumModel;
    }

    public k getCoverModel() {
        return this.coverModel;
    }

    public k getCoverThumbModel() {
        return this.coverThumbModel;
    }

    public CoverType getCoverType() {
        return this.mCoverType;
    }

    public List<String> getDownloadList() {
        return this.downloadList;
    }

    public double getDuration() {
        return this.duration;
    }

    public k getDynamicCoverModel() {
        return this.dynamicCoverModel;
    }

    public k getFirstFrame() {
        return this.firstFrame;
    }

    public int getGifType() {
        return this.gifType;
    }

    public List<String> getGifUrlList() {
        return this.gifUrlList;
    }

    public int getHeight() {
        return this.height;
    }

    public float getLongDuration() {
        return this.longDuration;
    }

    public String getLongUri() {
        return this.longUri;
    }

    public List<String> getLongUrls() {
        return this.longUrls;
    }

    public int getPreloadSize() {
        return this.preloadSize;
    }

    public List<c> getQualityInfo() {
        return this.qualityInfo;
    }

    public String getUri() {
        return this.uri;
    }

    public List<String> getUrlList() {
        return this.urlList;
    }

    public String getVideoLocalPath() {
        return this.videoLocalPath;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isAllowCache() {
        return this.allowCache;
    }

    public boolean isWaterMark() {
        return this.waterMark;
    }

    public void setAllowCache(boolean r1) {
        this.allowCache = r1;
    }

    public void setCoverMediumModel(k r1) {
        this.coverMediumModel = r1;
    }

    public void setCoverModel(k r1) {
        this.coverModel = r1;
    }

    public void setCoverThumbModel(k r1) {
        this.coverThumbModel = r1;
    }

    public void setCoverType(CoverType r1) {
        this.mCoverType = r1;
    }

    public void setDownloadList(List<String> r1) {
        this.downloadList = r1;
    }

    public void setDuration(double r1) {
        this.duration = r1;
    }

    public void setDynamicCoverModel(k r1) {
        this.dynamicCoverModel = r1;
    }

    public void setFirstFrame(k r1) {
        this.firstFrame = r1;
    }

    public void setGifType(int r1) {
        this.gifType = r1;
    }

    public void setGifUrlList(List<String> r1) {
        this.gifUrlList = r1;
    }

    public void setHeight(int r1) {
        this.height = r1;
    }

    public void setLongDuration(float r1) {
        this.longDuration = r1;
    }

    public void setLongUri(String r1) {
        this.longUri = r1;
    }

    public void setLongUrls(List<String> r1) {
        this.longUrls = r1;
    }

    public void setPreloadSize(int r1) {
        this.preloadSize = r1;
    }

    public void setQualityInfo(List<c> r1) {
        this.qualityInfo = r1;
    }

    public void setUri(String r1) {
        this.uri = r1;
    }

    public void setUrlList(List<String> r1) {
        this.urlList = r1;
    }

    public void setVideoLocalPath(String r1) {
        this.videoLocalPath = r1;
    }

    public void setWaterMark(boolean r1) {
        this.waterMark = r1;
    }

    public void setWidth(int r1) {
        this.width = r1;
    }
}
