package com.bytedance.android.livesdk.end;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import yu1.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b*\u0010+J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003JL\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0015\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0016HÖ\u0001J\u0013\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010!\u001a\u0004\b\"\u0010#R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010$\u001a\u0004\b%\u0010&R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010'\u001a\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/bytedance/android/livesdk/end/EndingPageGuideCardInfo;", "Lyu1/c;", "", "component1", "()Ljava/lang/Long;", "Lcom/bytedance/android/livesdk/end/EcomWindowRankGuideCardData;", "component2", "Lcom/bytedance/android/livesdk/end/EndingPageShopCardInfo;", "component3", "Lcom/bytedance/android/livesdk/end/SafeCardInfo;", "component4", "Lcom/bytedance/android/livesdk/end/VipLiveEndData;", "component5", "cardType", "windowRankData", "shopCardInfo", "safeCardInfo", "vipLiveEndData", "copy", "(Ljava/lang/Long;Lcom/bytedance/android/livesdk/end/EcomWindowRankGuideCardData;Lcom/bytedance/android/livesdk/end/EndingPageShopCardInfo;Lcom/bytedance/android/livesdk/end/SafeCardInfo;Lcom/bytedance/android/livesdk/end/VipLiveEndData;)Lcom/bytedance/android/livesdk/end/EndingPageGuideCardInfo;", "", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/Long;", "getCardType", "Lcom/bytedance/android/livesdk/end/EcomWindowRankGuideCardData;", "getWindowRankData", "()Lcom/bytedance/android/livesdk/end/EcomWindowRankGuideCardData;", "Lcom/bytedance/android/livesdk/end/EndingPageShopCardInfo;", "getShopCardInfo", "()Lcom/bytedance/android/livesdk/end/EndingPageShopCardInfo;", "Lcom/bytedance/android/livesdk/end/SafeCardInfo;", "getSafeCardInfo", "()Lcom/bytedance/android/livesdk/end/SafeCardInfo;", "Lcom/bytedance/android/livesdk/end/VipLiveEndData;", "getVipLiveEndData", "()Lcom/bytedance/android/livesdk/end/VipLiveEndData;", "<init>", "(Ljava/lang/Long;Lcom/bytedance/android/livesdk/end/EcomWindowRankGuideCardData;Lcom/bytedance/android/livesdk/end/EndingPageShopCardInfo;Lcom/bytedance/android/livesdk/end/SafeCardInfo;Lcom/bytedance/android/livesdk/end/VipLiveEndData;)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class EndingPageGuideCardInfo extends c {

    @SerializedName("card_type")
    private final Long cardType;

    @SerializedName("safe_card_info")
    private final SafeCardInfo safeCardInfo;

    @SerializedName("shop_card_info")
    private final EndingPageShopCardInfo shopCardInfo;

    @SerializedName("subscribe_card_info")
    private final VipLiveEndData vipLiveEndData;

    @SerializedName("ecom_window_rank_data")
    private final EcomWindowRankGuideCardData windowRankData;

    public EndingPageGuideCardInfo() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ EndingPageGuideCardInfo copy$default(EndingPageGuideCardInfo r3, Long r4, EcomWindowRankGuideCardData r5, EndingPageShopCardInfo r6, SafeCardInfo r7, VipLiveEndData r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.cardType;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.windowRankData;
    L8:
        EcomWindowRankGuideCardData r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.shopCardInfo;
    L11:
        EndingPageShopCardInfo r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.safeCardInfo;
    L14:
        SafeCardInfo r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.vipLiveEndData;
    L17:
        Long r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final Long component1() {
        return this.cardType;
    }

    public final EcomWindowRankGuideCardData component2() {
        return this.windowRankData;
    }

    public final EndingPageShopCardInfo component3() {
        return this.shopCardInfo;
    }

    public final SafeCardInfo component4() {
        return this.safeCardInfo;
    }

    public final VipLiveEndData component5() {
        return this.vipLiveEndData;
    }

    public final EndingPageGuideCardInfo copy(Long r8, EcomWindowRankGuideCardData r9, EndingPageShopCardInfo r10, SafeCardInfo r11, VipLiveEndData r12) {
        return new EndingPageGuideCardInfo(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof EndingPageGuideCardInfo) == false) goto L16;
        EndingPageGuideCardInfo r4 = (EndingPageGuideCardInfo) r3;
        if (Intrinsics.areEqual(this.cardType, r4.cardType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.windowRankData, r4.windowRankData) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.shopCardInfo, r4.shopCardInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.safeCardInfo, r4.safeCardInfo) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.vipLiveEndData, r4.vipLiveEndData) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        Long r0 = this.cardType;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        EcomWindowRankGuideCardData r4 = this.windowRankData;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        EndingPageShopCardInfo r7 = this.shopCardInfo;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        SafeCardInfo r10 = this.safeCardInfo;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        VipLiveEndData r13 = this.vipLiveEndData;
        if (r13 == null) goto L22;
        r1 = r13.hashCode();
    L22:
        return r12 + r1;
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "EndingPageGuideCardInfo(cardType=" + this.cardType + ", windowRankData=" + this.windowRankData + ", shopCardInfo=" + this.shopCardInfo + ", safeCardInfo=" + this.safeCardInfo + ", vipLiveEndData=" + this.vipLiveEndData + ")";
    }

    public final Long getCardType() {
        return this.cardType;
    }

    public final SafeCardInfo getSafeCardInfo() {
        return this.safeCardInfo;
    }

    public final EndingPageShopCardInfo getShopCardInfo() {
        return this.shopCardInfo;
    }

    public final VipLiveEndData getVipLiveEndData() {
        return this.vipLiveEndData;
    }

    public final EcomWindowRankGuideCardData getWindowRankData() {
        return this.windowRankData;
    }

    public EndingPageGuideCardInfo(Long r1, EcomWindowRankGuideCardData r2, EndingPageShopCardInfo r3, SafeCardInfo r4, VipLiveEndData r5) {
        this.cardType = r1;
        this.windowRankData = r2;
        this.shopCardInfo = r3;
        this.safeCardInfo = r4;
        this.vipLiveEndData = r5;
    }

    public /* synthetic */ EndingPageGuideCardInfo(Long r4, EcomWindowRankGuideCardData r5, EndingPageShopCardInfo r6, SafeCardInfo r7, VipLiveEndData r8, int r9, DefaultConstructorMarker r10) {
        if ((r9 & 1) == 0) goto L5;
        r4 = 0L;
    L5:
        VipLiveEndData r0 = null;
        if ((r9 & 2) == 0) goto L8;
        EcomWindowRankGuideCardData r11 = null;
    L10:
        if ((r9 & 4) == 0) goto L12;
        EndingPageShopCardInfo r1 = null;
    L14:
        if ((r9 & 8) == 0) goto L16;
        SafeCardInfo r2 = null;
    L18:
        if ((r9 & 16) != 0) goto L21;
        r0 = r8;
    L21:
        this(r4, r11, r1, r2, r0);
        return;
    L16:
        r2 = r7;
        goto L18
    L12:
        r1 = r6;
        goto L14
    L8:
        r11 = r5;
        goto L10
    }
}
