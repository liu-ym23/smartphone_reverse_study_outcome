package com.bytedance.android.livesdk.config.feed;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\nHÆ\u0003JV\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\r¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdk/config/feed/LiveFeedAdParams;", "", "adId", "", "creativeId", "logExtra", "liveSDKInfoExtra", "ecpm", "", "couponApiParams", "Lcom/google/gson/JsonObject;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Lcom/google/gson/JsonObject;)V", "getAdId", "()Ljava/lang/String;", "getCouponApiParams", "()Lcom/google/gson/JsonObject;", "getCreativeId", "getEcpm", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getLiveSDKInfoExtra", "getLogExtra", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Lcom/google/gson/JsonObject;)Lcom/bytedance/android/livesdk/config/feed/LiveFeedAdParams;", "equals", "", "other", "hashCode", "", "toString", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveFeedAdParams {

    @SerializedName("ad_id")
    private final String adId;

    @SerializedName("coupon_api_params")
    private final JsonObject couponApiParams;

    @SerializedName("creative_id")
    private final String creativeId;

    @SerializedName("ecpm")
    private final Double ecpm;

    @SerializedName("live_sdk_info_extra")
    private final String liveSDKInfoExtra;

    @SerializedName("log_extra")
    private final String logExtra;

    public LiveFeedAdParams() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ LiveFeedAdParams copy$default(LiveFeedAdParams r4, String r5, String r6, String r7, String r8, Double r9, JsonObject r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.adId;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.creativeId;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.logExtra;
    L11:
        String r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.liveSDKInfoExtra;
    L14:
        String r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.ecpm;
    L17:
        Double r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.couponApiParams;
    L20:
        String r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final String component1() {
        return this.adId;
    }

    public final String component2() {
        return this.creativeId;
    }

    public final String component3() {
        return this.logExtra;
    }

    public final String component4() {
        return this.liveSDKInfoExtra;
    }

    public final Double component5() {
        return this.ecpm;
    }

    public final JsonObject component6() {
        return this.couponApiParams;
    }

    public final LiveFeedAdParams copy(String r9, String r10, String r11, String r12, Double r13, JsonObject r14) {
        return new LiveFeedAdParams(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof LiveFeedAdParams) == false) goto L18;
        LiveFeedAdParams r4 = (LiveFeedAdParams) r3;
        if (Intrinsics.areEqual(this.adId, r4.adId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.creativeId, r4.creativeId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.logExtra, r4.logExtra) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.liveSDKInfoExtra, r4.liveSDKInfoExtra) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.ecpm, r4.ecpm) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.couponApiParams, r4.couponApiParams) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        String r0 = this.adId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.creativeId;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.logExtra;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.liveSDKInfoExtra;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Double r13 = this.ecpm;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        JsonObject r16 = this.couponApiParams;
        if (r16 == null) goto L26;
        r1 = r16.hashCode();
    L26:
        return r15 + r1;
    L21:
        r14 = 0;
        goto L22
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
        return "LiveFeedAdParams(adId=" + this.adId + ", creativeId=" + this.creativeId + ", logExtra=" + this.logExtra + ", liveSDKInfoExtra=" + this.liveSDKInfoExtra + ", ecpm=" + this.ecpm + ", couponApiParams=" + this.couponApiParams + ")";
    }

    public final String getAdId() {
        return this.adId;
    }

    public final JsonObject getCouponApiParams() {
        return this.couponApiParams;
    }

    public final String getCreativeId() {
        return this.creativeId;
    }

    public final Double getEcpm() {
        return this.ecpm;
    }

    public final String getLiveSDKInfoExtra() {
        return this.liveSDKInfoExtra;
    }

    public final String getLogExtra() {
        return this.logExtra;
    }

    public LiveFeedAdParams(String r1, String r2, String r3, String r4, Double r5, JsonObject r6) {
        this.adId = r1;
        this.creativeId = r2;
        this.logExtra = r3;
        this.liveSDKInfoExtra = r4;
        this.ecpm = r5;
        this.couponApiParams = r6;
    }

    public /* synthetic */ LiveFeedAdParams(String r5, String r6, String r7, String r8, Double r9, JsonObject r10, int r11, DefaultConstructorMarker r12) {
        String r0 = "";
        if ((r11 & 1) == 0) goto L5;
        String r13 = "";
    L7:
        if ((r11 & 2) == 0) goto L9;
        String r1 = "";
    L11:
        if ((r11 & 4) == 0) goto L13;
        String r2 = "";
    L15:
        if ((r11 & 8) != 0) goto L19;
        r0 = r8;
    L19:
        if ((r11 & 16) == 0) goto L21;
        Double r3 = null;
    L23:
        if ((r11 & 32) == 0) goto L25;
        JsonObject r14 = null;
    L26:
        this(r13, r1, r2, r0, r3, r14);
        return;
    L25:
        r14 = r10;
        goto L26
    L21:
        r3 = r9;
        goto L23
    L13:
        r2 = r7;
        goto L15
    L9:
        r1 = r6;
        goto L11
    L5:
        r13 = r5;
        goto L7
    }
}
