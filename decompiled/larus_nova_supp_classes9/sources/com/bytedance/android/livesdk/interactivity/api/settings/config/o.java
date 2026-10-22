package com.bytedance.android.livesdk.interactivity.api.settings.config;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/settings/config/o;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "enable", "Z", "a", "()Z", "setEnable", "(Z)V", BuildConfig.FLAVOR, "introText", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setIntroText", "(Ljava/lang/String;)V", "introImageUrl", "c", "setIntroImageUrl", BuildConfig.FLAVOR, "introImageWidth", "I", "d", "()I", "setIntroImageWidth", "(I)V", "introImageHeight", "b", "setIntroImageHeight", "<init>", "()V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class o {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("intro_image_height")
    private int introImageHeight;

    @SerializedName("intro_image_url")
    private String introImageUrl;

    @SerializedName("intro_image_width")
    private int introImageWidth;

    @SerializedName("intro_text")
    private String introText;

    public o() {
        this.enable = true;
        this.introText = "开启后，当前设置的预告会展示在直播间介绍，观众可点击预约你的直播";
        this.introImageUrl = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/webcast/webcast_room_intro_appointment_preview.png";
        this.introImageWidth = 335;
        this.introImageHeight = 177;
    }

    public final boolean a() {
        return this.enable;
    }

    public final int b() {
        return this.introImageHeight;
    }

    public final String c() {
        return this.introImageUrl;
    }

    public final int d() {
        return this.introImageWidth;
    }

    public final String e() {
        return this.introText;
    }
}
