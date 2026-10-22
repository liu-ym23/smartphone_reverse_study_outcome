package com.bytedance.android.livesdk.coupon.balancecoupon;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/coupon/balancecoupon/CouponSubType;", "", "", "value", "I", "getValue", "()I", "CouponSubType_Unknown", "CouponSubType_FullAmount", "CouponSubType_Amount", "CouponSubType_Discount", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final enum CouponSubType extends Enum<CouponSubType> {
    public static final CouponSubType CouponSubType_Amount = null;
    public static final CouponSubType CouponSubType_Discount = null;
    public static final CouponSubType CouponSubType_FullAmount = null;
    public static final CouponSubType CouponSubType_Unknown = null;
    public static final /* synthetic */ CouponSubType[] a = null;
    private final int value;

    static {
        CouponSubType r1 = new CouponSubType("CouponSubType_Unknown", 0, 0);
        CouponSubType_Unknown = r1;
        CouponSubType r2 = new CouponSubType("CouponSubType_FullAmount", 1, 1);
        CouponSubType_FullAmount = r2;
        CouponSubType r3 = new CouponSubType("CouponSubType_Amount", 2, 2);
        CouponSubType_Amount = r3;
        CouponSubType r4 = new CouponSubType("CouponSubType_Discount", 3, 3);
        CouponSubType_Discount = r4;
        a = new CouponSubType[]{r1, r2, r3, r4};
    }

    public static CouponSubType valueOf(String r1) {
        return (CouponSubType) a.a(CouponSubType.class, r1);
    }

    public static CouponSubType[] values() {
        return (CouponSubType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public CouponSubType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
