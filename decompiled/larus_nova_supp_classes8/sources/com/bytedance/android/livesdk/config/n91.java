package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010$R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R$\u0010\u0019\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/bytedance/android/livesdk/config/n91;", "", "", "onlySupportXsg", "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", "setOnlySupportXsg", "(Ljava/lang/Integer;)V", "xsgDeviceFirst", "getXsgDeviceFirst", "setXsgDeviceFirst", "changeName", "getChangeName", "setChangeName", "", "guideImg1", "Ljava/lang/String;", "getGuideImg1", "()Ljava/lang/String;", "setGuideImg1", "(Ljava/lang/String;)V", "guideImg2", "getGuideImg2", "setGuideImg2", "guideVideoUrl", "getGuideVideoUrl", "setGuideVideoUrl", "", "ottCastLiveInfoEnable", "Ljava/lang/Boolean;", "b", "()Ljava/lang/Boolean;", "setOttCastLiveInfoEnable", "(Ljava/lang/Boolean;)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n91 {

    @SerializedName("change_name")
    private Integer changeName;

    @SerializedName("guide_picture_1_url")
    private String guideImg1;

    @SerializedName("guide_picture_2_url")
    private String guideImg2;

    @SerializedName("guide_video_url")
    private String guideVideoUrl;

    @SerializedName("only_xiguaTV")
    private Integer onlySupportXsg;

    @SerializedName("ott_cast_live_info_enable")
    private Boolean ottCastLiveInfoEnable;

    @SerializedName("xiguaTV_first")
    private Integer xsgDeviceFirst;

    public n91() {
        this.onlySupportXsg = 1;
        this.xsgDeviceFirst = 0;
        this.changeName = 0;
        this.guideImg1 = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/live_cast_screen_guide_image_first.png";
        this.guideImg2 = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/live_cast_screen_guide_image_second.png";
        this.guideVideoUrl = "https://lf3-static.bytednsdoc.com/obj/eden-cn/elwheh7uhbonulg/xsgguide/xsg-download-guide.mp4";
        this.ottCastLiveInfoEnable = Boolean.TRUE;
    }

    public final Integer a() {
        return this.onlySupportXsg;
    }

    public final Boolean b() {
        return this.ottCastLiveInfoEnable;
    }
}
