package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0018\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b)\u0010*R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000fR\"\u0010\u001d\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\"\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR\"\u0010#\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\bR\"\u0010&\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u000b\u001a\u0004\b'\u0010\r\"\u0004\b(\u0010\u000f¨\u0006+"}, d2 = {"Lcom/bytedance/android/livesdk/config/a3;", "", "", "enable", "Z", "c", "()Z", "setEnable", "(Z)V", "", "downDistance", "F", "b", "()F", "setDownDistance", "(F)V", "upDistance", "i", "setUpDistance", "", "flingVelocity", "I", "f", "()I", "setFlingVelocity", "(I)V", "clickFactor", "a", "setClickFactor", "flingDistance", "e", "setFlingDistance", "enableV2", "d", "setEnableV2", "stayEnable", "g", "setStayEnable", "stayFactor", "h", "setStayFactor", "<init>", "()V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a3 {

    @SerializedName("click_factor")
    private float clickFactor;

    @SerializedName("down_distance")
    private float downDistance;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("enable_V2")
    private boolean enableV2;

    @SerializedName("fling_distance")
    private int flingDistance;

    @SerializedName("fling_velocity")
    private int flingVelocity;

    @SerializedName("stay_enable")
    private boolean stayEnable;

    @SerializedName("stay_factor")
    private float stayFactor;

    @SerializedName("up_distance")
    private float upDistance;

    public a3() {
        this.downDistance = 0.6f;
        this.upDistance = 0.4f;
        this.flingVelocity = 400;
        this.clickFactor = 1.0f;
        this.flingDistance = 25;
        this.stayEnable = true;
        this.stayFactor = 1.0f;
    }

    public final float a() {
        return this.clickFactor;
    }

    public final float b() {
        return this.downDistance;
    }

    public final boolean c() {
        return this.enable;
    }

    public final boolean d() {
        return this.enableV2;
    }

    public final int e() {
        return this.flingDistance;
    }

    public final int f() {
        return this.flingVelocity;
    }

    public final boolean g() {
        return this.stayEnable;
    }

    public final float h() {
        return this.stayFactor;
    }

    public final float i() {
        return this.upDistance;
    }
}
