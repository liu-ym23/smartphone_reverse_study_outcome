package com.bytedance.android.live.recharge.platform.business.model.diamond;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/recharge/platform/business/model/diamond/b;", "", "", "coupon_id", "Ljava/lang/String;", "getCoupon_id", "()Ljava/lang/String;", "", "operate_type", "I", "getOperate_type", "()I", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class b {

    @SerializedName("coupon_id")
    private final String coupon_id;

    @SerializedName("operate_type")
    private final int operate_type;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L10;
        b r4 = (b) r3;
        if (Intrinsics.areEqual(this.coupon_id, r4.coupon_id) == true) goto L8;
        return false;
    L8:
        if (this.operate_type == r4.operate_type) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r0 = this.coupon_id;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L7:
        return (r1 * 31) + this.operate_type;
    L5:
        r1 = 0;
        goto L7
    }

    public final String toString() {
        return "CouponOperate(coupon_id=" + this.coupon_id + ", operate_type=" + this.operate_type + ")";
    }

    public b(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "coupon_id");
        this.coupon_id = r2;
        this.operate_type = r3;
    }
}
