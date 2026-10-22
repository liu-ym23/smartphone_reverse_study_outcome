package com.bytedance.android.livesdk.coupon.balancecoupon.model;

import am3.g;
import com.bytedance.android.livesdk.coupon.expandcoupon.model.e;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@ProtoMessage("webcast.api.open_user_benefit.QueryUserBenefitPopupResponse.UserBenefitPopupData")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/coupon/balancecoupon/model/c;", "", "", "canShow", "Z", "a", "()Z", "setCanShow", "(Z)V", "", "ruleDescriptionUrl", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setRuleDescriptionUrl", "(Ljava/lang/String;)V", "Lcom/bytedance/android/livesdk/coupon/expandcoupon/model/e;", "qcpxCouponInfo", "Lcom/bytedance/android/livesdk/coupon/expandcoupon/model/e;", "c", "()Lcom/bytedance/android/livesdk/coupon/expandcoupon/model/e;", "setQcpxCouponInfo", "(Lcom/bytedance/android/livesdk/coupon/expandcoupon/model/e;)V", "Lcom/bytedance/android/livesdk/coupon/refundcoupon/model/b;", "popupWindow", "Lcom/bytedance/android/livesdk/coupon/refundcoupon/model/b;", "b", "()Lcom/bytedance/android/livesdk/coupon/refundcoupon/model/b;", "setPopupWindow", "(Lcom/bytedance/android/livesdk/coupon/refundcoupon/model/b;)V", "<init>", "()V", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class c implements h {

    @SerializedName("can_show")
    protected boolean canShow;

    @SerializedName("popup_window")
    protected com.bytedance.android.livesdk.coupon.refundcoupon.model.b popupWindow;

    @SerializedName("qcpx_coupon")
    protected e qcpxCouponInfo;

    @SerializedName("rule_description_url")
    protected String ruleDescriptionUrl;

    public c() {
        this.ruleDescriptionUrl = "";
    }

    public final boolean a() {
        return this.canShow;
    }

    public final com.bytedance.android.livesdk.coupon.refundcoupon.model.b b() {
        return this.popupWindow;
    }

    public final e c() {
        return this.qcpxCouponInfo;
    }

    public final String d() {
        return this.ruleDescriptionUrl;
    }

    public c(g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L18;
        if (r2 != 1) goto L8;
        this.canShow = am3.h.a(r5);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.ruleDescriptionUrl = am3.h.c(r5);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.qcpxCouponInfo = new e(r5);
        goto L3
    L12:
        if (r2 != 5) goto L13;
        this.popupWindow = new com.bytedance.android.livesdk.coupon.refundcoupon.model.b(r5);
        goto L3
    L13:
        am3.h.e(r5);
        goto L3
    L18:
        r5.d(r0);
        if (this.ruleDescriptionUrl != null) goto L37;
        this.ruleDescriptionUrl = "";
        return;
    }
}
