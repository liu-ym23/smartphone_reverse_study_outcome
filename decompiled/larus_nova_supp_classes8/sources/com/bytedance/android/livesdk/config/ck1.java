package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b0\u00101R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R(\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015R\"\u0010 \u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0011\u001a\u0004\b!\u0010\u0013\"\u0004\b\"\u0010\u0015R$\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010*\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010%\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R$\u0010-\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010%\u001a\u0004\b.\u0010'\"\u0004\b/\u0010)¨\u00062"}, d2 = {"Lcom/bytedance/android/livesdk/config/ck1;", "", "", "welfareToolBarAnimate", "I", "getWelfareToolBarAnimate", "()I", "setWelfareToolBarAnimate", "(I)V", "welfareMessageStyle", "getWelfareMessageStyle", "setWelfareMessageStyle", "welfareCardBottomRight", "getWelfareCardBottomRight", "setWelfareCardBottomRight", "", "welfareCardDefaultFrequency", "J", "f", "()J", "setWelfareCardDefaultFrequency", "(J)V", "", "welfareCardFrequency", "Ljava/util/List;", "g", "()Ljava/util/List;", "setWelfareCardFrequency", "(Ljava/util/List;)V", "reportInterval", "e", "setReportInterval", "animationInterval", "a", "setAnimationInterval", "", "normalToolbarAnimateUrl", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setNormalToolbarAnimateUrl", "(Ljava/lang/String;)V", "outToolbarAnimateUrl", "d", "setOutToolbarAnimateUrl", "inToolbarAnimateUrl", "b", "setInToolbarAnimateUrl", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ck1 {

    @SerializedName("welfare_toolbar_animation_interval")
    private long animationInterval;

    @SerializedName("toolbar_in_animate_url")
    private String inToolbarAnimateUrl;

    @SerializedName("toolbar_normal_animate_url")
    private String normalToolbarAnimateUrl;

    @SerializedName("toolbar_out_animate_url")
    private String outToolbarAnimateUrl;

    @SerializedName("welfare_report_interval")
    private long reportInterval;

    @SerializedName("welfare_card_opt")
    private int welfareCardBottomRight;

    @SerializedName("welfare_card_default_frequency")
    private long welfareCardDefaultFrequency;

    @SerializedName("welfare_card_frequencies")
    private List<Integer> welfareCardFrequency;

    @SerializedName("welfare_message_opt")
    private int welfareMessageStyle;

    @SerializedName("welfare_toolbar_animation")
    private int welfareToolBarAnimate;

    public final boolean h() {
        if (this.welfareToolBarAnimate == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean i() {
        if (this.welfareMessageStyle == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean j() {
        if (this.welfareCardBottomRight == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public ck1() {
        this.welfareCardDefaultFrequency = 15;
        this.welfareCardFrequency = CollectionsKt.listOf(new Integer[]{10, 15, 30});
        this.reportInterval = 30;
        this.animationInterval = 10;
        this.normalToolbarAnimateUrl = LiveCommonConstants.assembleTosObjectUrl("obj/live-android/ttlive_toolbar_welfare_normal.webp");
        this.outToolbarAnimateUrl = LiveCommonConstants.assembleTosObjectUrl("obj/live-android/ttlive_toolbar_welfare_out.webp");
        this.inToolbarAnimateUrl = LiveCommonConstants.assembleTosObjectUrl("obj/live-android/ttlive_toolbar_welfare_in.webp");
    }

    public final long a() {
        return this.animationInterval;
    }

    public final String b() {
        return this.inToolbarAnimateUrl;
    }

    public final String c() {
        return this.normalToolbarAnimateUrl;
    }

    public final String d() {
        return this.outToolbarAnimateUrl;
    }

    public final long e() {
        return this.reportInterval;
    }

    public final long f() {
        return this.welfareCardDefaultFrequency;
    }

    public final List<Integer> g() {
        return this.welfareCardFrequency;
    }
}
