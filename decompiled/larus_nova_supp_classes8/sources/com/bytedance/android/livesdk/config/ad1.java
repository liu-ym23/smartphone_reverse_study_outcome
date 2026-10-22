package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0013\u001a\u00020\u00128\u0006X\u0087D¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001a\u0010\u001a\u001a\u00020\u00198\u0006X\u0087D¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/config/ad1;", "", "", "refreshFrequency", "I", "c", "()I", "setRefreshFrequency", "(I)V", "collectFrequency", "getCollectFrequency", "setCollectFrequency", "overloadTipsFrequency", "getOverloadTipsFrequency", "setOverloadTipsFrequency", "encodeFpsThreshold", "b", "setEncodeFpsThreshold", "", "stutterRateThreshold", "F", "getStutterRateThreshold", "()F", "batteryTemperatureThreshold", "a", "", "batteryThermalThreshold", "Ljava/lang/String;", "getBatteryThermalThreshold", "()Ljava/lang/String;", "detectingMode", "getDetectingMode", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ad1 {

    @SerializedName("overload_temperature_threshold")
    private final int batteryTemperatureThreshold;

    @SerializedName("overload_thermal_threshold")
    private final String batteryThermalThreshold;

    @SerializedName("collect_frequency")
    private int collectFrequency;

    @SerializedName("overload_detecting_mode")
    private final int detectingMode;

    @SerializedName("overload_encode_fps_threshold")
    private int encodeFpsThreshold;

    @SerializedName("overload_tips_frequency")
    private int overloadTipsFrequency;

    @SerializedName("refresh_frequency")
    private int refreshFrequency;

    @SerializedName("overload_anr_threshold")
    private final float stutterRateThreshold;

    public final int d() {
        if (this.collectFrequency > 0) goto L6;
        this.collectFrequency = 5;
    L6:
        return this.collectFrequency;
    }

    public final float e() {
        return this.stutterRateThreshold / 100.0f;
    }

    public final int f() {
        if (this.overloadTipsFrequency > 0) goto L6;
        this.overloadTipsFrequency = 60;
    L6:
        return this.overloadTipsFrequency;
    }

    public final boolean g() {
        if (this.detectingMode == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public ad1() {
        this.refreshFrequency = 1;
        this.collectFrequency = 5;
        this.overloadTipsFrequency = 60;
        this.encodeFpsThreshold = 13;
        this.stutterRateThreshold = 233.0f;
        this.batteryTemperatureThreshold = 50;
        this.batteryThermalThreshold = "serious";
        this.detectingMode = 1;
    }

    public final int a() {
        return this.batteryTemperatureThreshold;
    }

    public final int b() {
        return this.encodeFpsThreshold;
    }

    public final int c() {
        return this.refreshFrequency;
    }
}
