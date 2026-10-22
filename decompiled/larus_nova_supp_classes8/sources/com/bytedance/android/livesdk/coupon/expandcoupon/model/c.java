package com.bytedance.android.livesdk.coupon.expandcoupon.model;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@ProtoMessage("webcast.api.open_user_benefit.QueryUserBenefitPopupResponse.InteractionConfig")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/coupon/expandcoupon/model/c;", "", "", "incrCouponValue", "J", "c", "()J", "setIncrCouponValue", "(J)V", "incrCouponThreshold", "b", "setIncrCouponThreshold", "couponTaskTime", "a", "setCouponTaskTime", "<init>", "()V", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class c implements h {

    @SerializedName("task_time")
    protected long couponTaskTime;

    @SerializedName("threshold")
    protected long incrCouponThreshold;

    @SerializedName("value")
    protected long incrCouponValue;

    public c() {
    }

    public final long a() {
        return this.couponTaskTime;
    }

    public final long b() {
        return this.incrCouponThreshold;
    }

    public final long c() {
        return this.incrCouponValue;
    }

    public c(g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L15;
        if (r2 != 1) goto L8;
        this.incrCouponValue = r5.j();
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.incrCouponThreshold = r5.j();
        goto L3
    L10:
        if (r2 != 3) goto L11;
        this.couponTaskTime = r5.j();
        goto L3
    L11:
        am3.h.e(r5);
        goto L3
    L15:
        r5.d(r0);
    }
}
