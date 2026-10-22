package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/config/p61;", "", "", "scanTimeout", "Ljava/lang/Long;", "e", "()Ljava/lang/Long;", "", "padGuideImgFirst", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "padGuideImgSecond", "b", "pcGuideImg", "c", "pcGuideImgSecond", "d", "pcGuideSchema", "getPcGuideSchema", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p61 {

    @SerializedName("pad_guide_img_first")
    private final String padGuideImgFirst;

    @SerializedName("pad_guide_img_second")
    private final String padGuideImgSecond;

    @SerializedName("pc_guide_img")
    private final String pcGuideImg;

    @SerializedName("pc_guide_img_second")
    private final String pcGuideImgSecond;

    @SerializedName("pc_guide_schema")
    private final String pcGuideSchema;

    @SerializedName("scan_timeout")
    private final Long scanTimeout;

    public p61() {
        this.scanTimeout = 30000L;
        this.padGuideImgFirst = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/live_img_pad_play_guide_first.png";
        this.padGuideImgSecond = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/live_img_pad_play_guide_second.png";
        this.pcGuideImg = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/live_pc_play_guide_img_first.png";
        this.pcGuideImgSecond = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/live_pc_play_guide_img_second.png";
        this.pcGuideSchema = "sslocal://webcast_webview?type=popup&url=https%3A%2F%2Ftosv.byted.org%2Fobj%2Fgecko-internal%2Fwebcast%2Fmono%2Fh5%2Fcommunity_community_h5_douyin%2Ftemplate%2Fpages%2Fswitch_pc_guide.html&height=477&gravity=bottom&hide_nav_bar=1&width_percent=100";
    }

    public final String a() {
        return this.padGuideImgFirst;
    }

    public final String b() {
        return this.padGuideImgSecond;
    }

    public final String c() {
        return this.pcGuideImg;
    }

    public final String d() {
        return this.pcGuideImgSecond;
    }

    public final Long e() {
        return this.scanTimeout;
    }
}
