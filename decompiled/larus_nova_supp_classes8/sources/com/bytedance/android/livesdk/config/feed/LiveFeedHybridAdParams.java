package com.bytedance.android.livesdk.config.feed;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/config/feed/LiveFeedHybridAdParams;", "", "adId", "", "creativeId", "logExtra", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAdId", "()Ljava/lang/String;", "getCreativeId", "getLogExtra", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveFeedHybridAdParams {

    @SerializedName("ad_id")
    private final String adId;

    @SerializedName("creative_id")
    private final String creativeId;

    @SerializedName("log_extra")
    private final String logExtra;

    public LiveFeedHybridAdParams() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ LiveFeedHybridAdParams copy$default(LiveFeedHybridAdParams r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.adId;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.creativeId;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.logExtra;
    L12:
        return r0.copy(r1, r2, r3);
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

    public final LiveFeedHybridAdParams copy(String r2, String r3, String r4) {
        return new LiveFeedHybridAdParams(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof LiveFeedHybridAdParams) == false) goto L12;
        LiveFeedHybridAdParams r4 = (LiveFeedHybridAdParams) r3;
        if (Intrinsics.areEqual(this.adId, r4.adId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.creativeId, r4.creativeId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.logExtra, r4.logExtra) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
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
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "LiveFeedHybridAdParams(adId=" + this.adId + ", creativeId=" + this.creativeId + ", logExtra=" + this.logExtra + ")";
    }

    public final String getAdId() {
        return this.adId;
    }

    public final String getCreativeId() {
        return this.creativeId;
    }

    public final String getLogExtra() {
        return this.logExtra;
    }

    public LiveFeedHybridAdParams(String r1, String r2, String r3) {
        this.adId = r1;
        this.creativeId = r2;
        this.logExtra = r3;
    }

    public /* synthetic */ LiveFeedHybridAdParams(String r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = "";
    L11:
        this(r2, r3, r4);
    }
}
