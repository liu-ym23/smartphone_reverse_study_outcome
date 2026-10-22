package com.bytedance.android.live.profit.lottery;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/profit/lottery/c;", "", "Lcom/bytedance/android/live/profit/lottery/b;", "ecommerceCoupon", "Lcom/bytedance/android/live/profit/lottery/b;", "a", "()Lcom/bytedance/android/live/profit/lottery/b;", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class c {

    @SerializedName("ecommerce_coupon")
    private final b ecommerceCoupon;

    public c() {
        this(null);
    }

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof c) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.ecommerceCoupon, ((c) r2).ecommerceCoupon) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        b r0 = this.ecommerceCoupon;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "ExtraInfo(ecommerceCoupon=" + this.ecommerceCoupon + ")";
    }

    public final b a() {
        return this.ecommerceCoupon;
    }

    public c(b r1) {
        this.ecommerceCoupon = r1;
    }
}
