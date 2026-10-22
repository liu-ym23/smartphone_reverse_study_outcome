package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\"R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR*\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R*\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R*\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u001f\u0010\u0017\"\u0004\b \u0010\u0019¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/config/v1;", "", "", "enableCommentGiftGuide", "Z", "getEnableCommentGiftGuide", "()Z", "setEnableCommentGiftGuide", "(Z)V", "", "maxDisplayTimePreDay", "I", "getMaxDisplayTimePreDay", "()I", "setMaxDisplayTimePreDay", "(I)V", "maxNoTapTime", "getMaxNoTapTime", "setMaxNoTapTime", "", "giftPriceRange", "Ljava/util/List;", "getGiftPriceRange", "()Ljava/util/List;", "setGiftPriceRange", "(Ljava/util/List;)V", "", "giftGuideBgList", "getGiftGuideBgList", "setGiftGuideBgList", "giftGuideAnimList", "getGiftGuideAnimList", "setGiftGuideAnimList", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class v1 {

    @SerializedName("enable_comment_gift_guide")
    private boolean enableCommentGiftGuide;

    @SerializedName("gift_guide_anim_list")
    private List<String> giftGuideAnimList;

    @SerializedName("gift_guide_bg_list")
    private List<String> giftGuideBgList;

    @SerializedName("gift_price_range")
    private List<Integer> giftPriceRange;

    @SerializedName("max_display_time_pre_day")
    private int maxDisplayTimePreDay;

    @SerializedName("max_no_tap_time")
    private int maxNoTapTime;

    public v1() {
        this.maxDisplayTimePreDay = 5;
        this.maxNoTapTime = 100;
        this.giftPriceRange = new ArrayList(CollectionsKt.listOf(new Integer[]{0, 100, Integer.valueOf(BubbleId.PadCast)}));
        this.giftGuideBgList = new ArrayList(CollectionsKt.listOf(new String[]{"https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/comment_gift_guide_bg_level1_new.png", "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/comment_gift_guide_bg_level2_new.png", "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/comment_gift_guide_bg_level3_new.png"}));
        this.giftGuideAnimList = new ArrayList(CollectionsKt.listOf(new String[]{"", "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/comment_gift_guide_low_level_effect.webp", "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/comment_gift_guide_high_level_effect.webp"}));
    }
}
