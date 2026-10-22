package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087D¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000e8\u0006X\u0087D¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/config/q61;", "", "", "enable", "I", "d", "()I", "", "startTime", "J", "f", "()J", "duration", "c", "", "content", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "qrCodeTitle", "e", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class q61 {

    @SerializedName("content")
    private final String content;

    @SerializedName("duration")
    private final long duration;

    @SerializedName("enable")
    private final int enable;

    @SerializedName("qrcode_title")
    private final String qrCodeTitle;

    @SerializedName("start_time")
    private final long startTime;

    public final boolean a() {
        if (this.enable == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public q61() {
        this.startTime = 3;
        this.duration = 5;
        this.content = "现在支持投屏Pad啦";
        this.qrCodeTitle = "请使用Pad打开抖音，扫描二维码打开此直播间";
    }

    public final String b() {
        return this.content;
    }

    public final long c() {
        return this.duration;
    }

    public final int d() {
        return this.enable;
    }

    public final String e() {
        return this.qrCodeTitle;
    }

    public final long f() {
        return this.startTime;
    }
}
