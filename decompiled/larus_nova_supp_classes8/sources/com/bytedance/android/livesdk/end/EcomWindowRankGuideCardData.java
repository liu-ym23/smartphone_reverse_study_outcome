package com.bytedance.android.livesdk.end;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import yu1.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0011\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003J?\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0010\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/end/EcomWindowRankGuideCardData;", "Lyu1/a;", "", "component1", "", "Lcom/bytedance/android/livesdk/end/EcomWindowRankItem;", "component2", "component3", "component4", "cardText", "rankItems", "jumpTipText", "cardJumpUrl", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getCardText", "()Ljava/lang/String;", "Ljava/util/List;", "getRankItems", "()Ljava/util/List;", "getJumpTipText", "getCardJumpUrl", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class EcomWindowRankGuideCardData extends a {

    @SerializedName("card_jump_url")
    private final String cardJumpUrl;

    @SerializedName("card_text")
    private final String cardText;

    @SerializedName("jump_tip_text")
    private final String jumpTipText;

    @SerializedName("rank_items")
    private final List<EcomWindowRankItem> rankItems;

    public EcomWindowRankGuideCardData() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EcomWindowRankGuideCardData copy$default(EcomWindowRankGuideCardData r0, String r1, List r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.cardText;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.rankItems;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.jumpTipText;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.cardJumpUrl;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.cardText;
    }

    public final List<EcomWindowRankItem> component2() {
        return this.rankItems;
    }

    public final String component3() {
        return this.jumpTipText;
    }

    public final String component4() {
        return this.cardJumpUrl;
    }

    public final EcomWindowRankGuideCardData copy(String r2, List<EcomWindowRankItem> r3, String r4, String r5) {
        return new EcomWindowRankGuideCardData(r2, r3, r4, r5);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof EcomWindowRankGuideCardData) == false) goto L14;
        EcomWindowRankGuideCardData r4 = (EcomWindowRankGuideCardData) r3;
        if (Intrinsics.areEqual(this.cardText, r4.cardText) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.rankItems, r4.rankItems) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.jumpTipText, r4.jumpTipText) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.cardJumpUrl, r4.cardJumpUrl) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r0 = this.cardText;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<EcomWindowRankItem> r4 = this.rankItems;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.jumpTipText;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.cardJumpUrl;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
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
        return "EcomWindowRankGuideCardData(cardText=" + this.cardText + ", rankItems=" + this.rankItems + ", jumpTipText=" + this.jumpTipText + ", cardJumpUrl=" + this.cardJumpUrl + ")";
    }

    public final String getCardJumpUrl() {
        return this.cardJumpUrl;
    }

    public final String getCardText() {
        return this.cardText;
    }

    public final String getJumpTipText() {
        return this.jumpTipText;
    }

    public final List<EcomWindowRankItem> getRankItems() {
        return this.rankItems;
    }

    public EcomWindowRankGuideCardData(String r1, List<EcomWindowRankItem> r2, String r3, String r4) {
        this.cardText = r1;
        this.rankItems = r2;
        this.jumpTipText = r3;
        this.cardJumpUrl = r4;
    }

    public /* synthetic */ EcomWindowRankGuideCardData(String r2, List r3, String r4, String r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
