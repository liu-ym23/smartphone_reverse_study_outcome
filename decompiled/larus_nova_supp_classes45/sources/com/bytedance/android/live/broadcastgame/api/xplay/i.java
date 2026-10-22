package com.bytedance.android.live.broadcastgame.api.xplay;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u001b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/xplay/i;", "", "", "width", "Ljava/lang/Integer;", "d", "()Ljava/lang/Integer;", "k", "(Ljava/lang/Integer;)V", "height", "getHeight", "h", "videoCaptureWidth", "getVideoCaptureWidth", "j", "videoCaptureHeight", "getVideoCaptureHeight", "i", "capAdaptedQuirks", "b", "f", "capAdaptedWidth", "c", "g", "capAdaptedHeight", "a", "e", "<init>", "()V", "livebroadcastgame-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i {

    @SerializedName("cap_adapted_height")
    private Integer capAdaptedHeight;

    @SerializedName("cap_adapted_quirks")
    private Integer capAdaptedQuirks;

    @SerializedName("cap_adapted_width")
    private Integer capAdaptedWidth;

    @SerializedName("height")
    private Integer height;

    @SerializedName("videoCaptureHeight")
    private Integer videoCaptureHeight;

    @SerializedName("videoCaptureWidth")
    private Integer videoCaptureWidth;

    @SerializedName("width")
    private Integer width;

    public i() {
    }

    public final String toString() {
        return GsonProtectorUtils.toJson((Gson) LiveCoreUtilsKt.a.getValue(), this);
    }

    public final Integer a() {
        return this.capAdaptedHeight;
    }

    public final Integer b() {
        return this.capAdaptedQuirks;
    }

    public final Integer c() {
        return this.capAdaptedWidth;
    }

    public final Integer d() {
        return this.width;
    }

    public final void e(Integer r1) {
        this.capAdaptedHeight = r1;
    }

    public final void f(Integer r1) {
        this.capAdaptedQuirks = r1;
    }

    public final void g(Integer r1) {
        this.capAdaptedWidth = r1;
    }

    public final void h(Integer r1) {
        this.height = r1;
    }

    public final void i(Integer r1) {
        this.videoCaptureHeight = r1;
    }

    public final void j(Integer r1) {
        this.videoCaptureWidth = r1;
    }

    public final void k(Integer r1) {
        this.width = r1;
    }
}
