package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b9\u0010:R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010#\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\bR\"\u0010&\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\bR\"\u0010*\u001a\u00020)8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00100\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010\u0014\u001a\u0004\b1\u0010\u0016\"\u0004\b2\u0010\u0018R$\u00103\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010\u001e\u001a\u0004\b4\u0010 \"\u0004\b5\u0010\"R\"\u00106\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u0010\u0004\u001a\u0004\b7\u0010\u0006\"\u0004\b8\u0010\b¨\u0006;"}, d2 = {"Lcom/bytedance/android/livesdk/config/w21;", "", "", "enable", "Z", "a", "()Z", "setEnable", "(Z)V", "addBizType", "getAddBizType", "setAddBizType", "enableLog", "getEnableLog", "setEnableLog", "disableAblity", "getDisableAblity", "setDisableAblity", "", "fps", "I", "getFps", "()I", "setFps", "(I)V", "cacheMaxSiz", "getCacheMaxSiz", "setCacheMaxSiz", "", "aesKeyMap", "Ljava/lang/String;", "getAesKeyMap", "()Ljava/lang/String;", "setAesKeyMap", "(Ljava/lang/String;)V", "optML", "getOptML", "setOptML", "optVerticalLandScape", "getOptVerticalLandScape", "setOptVerticalLandScape", "", "reportFPSDelay", "J", "getReportFPSDelay", "()J", "setReportFPSDelay", "(J)V", "jitterBufferDelay", "getJitterBufferDelay", "setJitterBufferDelay", "ajbParams", "getAjbParams", "setAjbParams", "bytecastAvSync", "getBytecastAvSync", "setBytecastAvSync", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class w21 {

    @SerializedName("add_biz_type")
    private boolean addBizType;

    @SerializedName("aes_key")
    private String aesKeyMap;

    @SerializedName("ajb_params")
    private String ajbParams;

    @SerializedName("bytecast_avsync")
    private boolean bytecastAvSync;

    @SerializedName("cache_max_size")
    private int cacheMaxSiz;

    @SerializedName("disable_ablity")
    private boolean disableAblity;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("enable_log")
    private boolean enableLog;

    @SerializedName("fps")
    private int fps;

    @SerializedName("jitter_buffer_delay")
    private int jitterBufferDelay;

    @SerializedName("opt_ml")
    private boolean optML;

    @SerializedName("opt_vertical_land_scape")
    private boolean optVerticalLandScape;

    @SerializedName("report_fps_delay")
    private long reportFPSDelay;

    public w21() {
        this.enable = true;
        this.addBizType = true;
        this.fps = 30;
        this.cacheMaxSiz = 100;
        this.optML = true;
        this.optVerticalLandScape = true;
        this.reportFPSDelay = 60;
        this.jitterBufferDelay = 500;
        this.ajbParams = "{\"sleepTimeRatio\":1.0,\"delayRtpThreshold\":200000,\"maxBufferRatio\":2.0}";
        this.bytecastAvSync = true;
    }

    public final boolean a() {
        return this.enable;
    }
}
