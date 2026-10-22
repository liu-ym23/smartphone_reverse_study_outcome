package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b,\u0010-R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR$\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010#\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u000b\u001a\u0004\b$\u0010\r\"\u0004\b%\u0010\u000fR$\u0010&\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u000b\u001a\u0004\b'\u0010\r\"\u0004\b(\u0010\u000fR$\u0010)\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u000b\u001a\u0004\b*\u0010\r\"\u0004\b+\u0010\u000f¨\u0006."}, d2 = {"Lcom/bytedance/android/livesdk/config/mh1;", "", "", "enableNewStyle", "Z", "getEnableNewStyle", "()Z", "setEnableNewStyle", "(Z)V", "", "firstTabName", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setFirstTabName", "(Ljava/lang/String;)V", "secondTabName", "i", "setSecondTabName", "firstCorner", "c", "setFirstCorner", "secondCorner", "h", "setSecondCorner", "finishTip", "a", "setFinishTip", "", "finishTipShowTs", "J", "b", "()J", "setFinishTipShowTs", "(J)V", "guideTip1", "f", "setGuideTip1", "guideTip2", "g", "setGuideTip2", "guideImg", "e", "setGuideImg", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class mh1 {

    @SerializedName("enable_solo_ktv_opt")
    private boolean enableNewStyle;

    @SerializedName("finish_tip")
    private String finishTip;

    @SerializedName("finish_tip_ts")
    private long finishTipShowTs;

    @SerializedName("first_corner")
    private String firstCorner;

    @SerializedName("first_tab")
    private String firstTabName;

    @SerializedName("guide_img")
    private String guideImg;

    @SerializedName("guide_tip1")
    private String guideTip1;

    @SerializedName("guide_tip2")
    private String guideTip2;

    @SerializedName("second_corner")
    private String secondCorner;

    @SerializedName("second_tab")
    private String secondTabName;

    public mh1() {
        this.firstTabName = "K歌";
        this.secondTabName = "KTV直播";
        this.finishTip = "发布功能上新";
    }

    public final String a() {
        return this.finishTip;
    }

    public final long b() {
        return this.finishTipShowTs;
    }

    public final String c() {
        return this.firstCorner;
    }

    public final String d() {
        return this.firstTabName;
    }

    public final String e() {
        return this.guideImg;
    }

    public final String f() {
        return this.guideTip1;
    }

    public final String g() {
        return this.guideTip2;
    }

    public final String h() {
        return this.secondCorner;
    }

    public final String i() {
        return this.secondTabName;
    }
}
