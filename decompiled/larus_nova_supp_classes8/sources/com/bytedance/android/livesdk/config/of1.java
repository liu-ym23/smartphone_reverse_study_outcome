package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b'\u0010(R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\"\u0010!\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0019\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR\"\u0010$\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0019\u001a\u0004\b%\u0010\u001b\"\u0004\b&\u0010\u001d¨\u0006)"}, d2 = {"Lcom/bytedance/android/livesdk/config/of1;", "", "", "enable", "Z", "a", "()Z", "setEnable", "(Z)V", "", "score", "F", "b", "()F", "setScore", "(F)V", "", "rtt", "I", "getRtt", "()I", "setRtt", "(I)V", "", "fractionLost", "D", "getFractionLost", "()D", "setFractionLost", "(D)V", "deviceLoopDelay", "getDeviceLoopDelay", "setDeviceLoopDelay", "volume", "getVolume", "setVolume", "capFrameRate", "getCapFrameRate", "setCapFrameRate", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class of1 {

    @SerializedName("mock_device_cap_frame_rate")
    private double capFrameRate;

    @SerializedName("mock_device_loop_delay")
    private double deviceLoopDelay;

    @SerializedName("mock_enable")
    private boolean enable;

    @SerializedName("mock_fraction_lost")
    private double fractionLost;

    @SerializedName("mock_rtt")
    private int rtt;

    @SerializedName("mock_score")
    private float score;

    @SerializedName("mock_volume")
    private double volume;

    public of1() {
        this.rtt = 100;
    }

    public final boolean a() {
        return this.enable;
    }

    public final float b() {
        return this.score;
    }
}
