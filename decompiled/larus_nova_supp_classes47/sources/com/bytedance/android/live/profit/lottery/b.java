package com.bytedance.android.live.profit.lottery;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/profit/lottery/b;", "", "", "couponType", "I", "getCouponType", "()I", "", "couponId", "J", "getCouponId", "()J", "", "isLifeLottery", "Ljava/lang/Boolean;", "a", "()Ljava/lang/Boolean;", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class b {

    @SerializedName("coupon_id")
    private final long couponId;

    @SerializedName("coupon_type")
    private final int couponType;

    @SerializedName("is_life_lottery")
    private final Boolean isLifeLottery;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof b) == false) goto L12;
        b r7 = (b) r6;
        if (this.couponType == r7.couponType) goto L8;
        return false;
    L8:
        if (this.couponId == r7.couponId) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.isLifeLottery, r7.isLifeLottery) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r0 = this.couponType * 31;
        long r1 = this.couponId;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        Boolean r3 = this.isLifeLottery;
        if (r3 == null) goto L5;
        int r4 = r3.hashCode();
    L7:
        return r2 + r4;
    L5:
        r4 = 0;
        goto L7
    }

    public final String toString() {
        return "EcommerceCoupon(couponType=" + this.couponType + ", couponId=" + this.couponId + ", isLifeLottery=" + this.isLifeLottery + ")";
    }

    public b() {
        this.couponType = 0;
        this.couponId = 0;
        this.isLifeLottery = null;
    }

    public final Boolean a() {
        return this.isLifeLottery;
    }
}
