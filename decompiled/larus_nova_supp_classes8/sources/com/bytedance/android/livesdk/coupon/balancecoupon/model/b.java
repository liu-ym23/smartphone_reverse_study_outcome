package com.bytedance.android.livesdk.coupon.balancecoupon.model;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@ProtoMessage("webcast.api.open_user_benefit.ExchangeUserBenefitPopupResponse.ExchangeUserBenefitPopupData")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/coupon/balancecoupon/model/b;", "", "", "toast", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setToast", "(Ljava/lang/String;)V", "", "status", "I", "c", "()I", "setStatus", "(I)V", "couponId", "a", "setCouponId", "couponMetaId", "b", "setCouponMetaId", "<init>", "()V", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class b implements h {

    @SerializedName("coupon_id")
    protected String couponId;

    @SerializedName("coupon_meta_id")
    protected String couponMetaId;

    @SerializedName("status")
    protected int status;

    @SerializedName("toast")
    protected String toast;

    public b() {
        this.toast = "";
        this.couponId = "";
        this.couponMetaId = "";
    }

    public final String a() {
        return this.couponId;
    }

    public final String b() {
        return this.couponMetaId;
    }

    public final int c() {
        return this.status;
    }

    public final String d() {
        return this.toast;
    }

    public b(g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L18;
        if (r2 != 1) goto L8;
        this.toast = am3.h.c(r5);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.status = r5.i();
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.couponId = am3.h.c(r5);
        goto L3
    L12:
        if (r2 != 4) goto L13;
        this.couponMetaId = am3.h.c(r5);
        goto L3
    L13:
        am3.h.e(r5);
        goto L3
    L18:
        r5.d(r0);
        if (this.toast != null) goto L22;
        this.toast = "";
    L22:
        if (this.couponId != null) goto L25;
        this.couponId = "";
    L25:
        if (this.couponMetaId != null) goto L43;
        this.couponMetaId = "";
        return;
    }
}
