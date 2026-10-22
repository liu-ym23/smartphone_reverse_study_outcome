package com.bytedance.android.livesdk.coupon.balancecoupon;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/coupon/balancecoupon/CouponType;", "", "", "value", "I", "getValue", "()I", "CouponType_Unknown", "CouponType_Platform", "CouponType_Shop", "CouponType_Kol", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final enum CouponType extends Enum<CouponType> {
    public static final CouponType CouponType_Kol = null;
    public static final CouponType CouponType_Platform = null;
    public static final CouponType CouponType_Shop = null;
    public static final CouponType CouponType_Unknown = null;
    public static final /* synthetic */ CouponType[] a = null;
    private final int value;

    static {
        CouponType r1 = new CouponType("CouponType_Unknown", 0, 0);
        CouponType_Unknown = r1;
        CouponType r2 = new CouponType("CouponType_Platform", 1, 1);
        CouponType_Platform = r2;
        CouponType r3 = new CouponType("CouponType_Shop", 2, 2);
        CouponType_Shop = r3;
        CouponType r4 = new CouponType("CouponType_Kol", 3, 3);
        CouponType_Kol = r4;
        a = new CouponType[]{r1, r2, r3, r4};
    }

    public static CouponType valueOf(String r1) {
        return (CouponType) a.a(CouponType.class, r1);
    }

    public static CouponType[] values() {
        return (CouponType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public CouponType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
