package zs1;

import com.bytedance.android.livesdk.coupon.balancecoupon.CouponSubType;
import com.bytedance.android.livesdk.coupon.balancecoupon.CouponType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f {
    public static final boolean a(com.bytedance.android.livesdk.coupon.balancecoupon.model.a r3) {
        if (r3 == null) goto L26;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.c r1 = r3.d();
        if (r1 == null) goto L26;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.d r2 = r1.b();
        if (r2 == null) goto L26;
        if (r2.c() != CouponType.CouponType_Platform.getValue()) goto L26;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.c r4 = r3.d();
        if (r4 == null) goto L17;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.d r5 = r4.b();
        if (r5 == null) goto L17;
        if (r5.b() != CouponSubType.CouponSubType_FullAmount.getValue()) goto L17;
        return true;
    L17:
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.c r6 = r3.d();
        if (r6 == null) goto L26;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.d r7 = r6.b();
        if (r7 == null) goto L26;
        if (r7.b() != CouponSubType.CouponSubType_Amount.getValue()) goto L26;
        return true;
    L26:
        return false;
    }
}
