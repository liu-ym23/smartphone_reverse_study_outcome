package com.bytedance.android.live.recharge.platform.business.model.diamond;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\r\u0010\u0004R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0010\u0010\u0004R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0013\u0010\u0004R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0016\u0010\u0004R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u0019\u0010\u0004R\u001a\u0010\u001d\u001a\u00020\u001c8&X§\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0006\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010 \u001a\u00020\u001c8&X§\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0006\u001a\u0004\b \u0010\u001e¨\u0006\""}, d2 = {"Lcom/bytedance/android/live/recharge/platform/business/model/diamond/d;", "Lvh7/c;", "", "getCouponId", "()Ljava/lang/String;", "getCouponId$annotations", "()V", "couponId", "", "getExpiredTime", "()Ljava/lang/Long;", "getExpiredTime$annotations", "expiredTime", "getTitle", "getTitle$annotations", "title", "getSubTitle", "getSubTitle$annotations", "subTitle", "getDiscountAmount", "getDiscountAmount$annotations", "discountAmount", "getDiscountAmountUtil", "getDiscountAmountUtil$annotations", "discountAmountUtil", "getConditionTitle", "getConditionTitle$annotations", "conditionTitle", "", "isDisable", "()Z", "isDisable$annotations", "isSelected", "isSelected$annotations", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface d extends vh7.c<d> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "condition_title")
    String getConditionTitle();

    @FieldName(name = "coupon_id")
    String getCouponId();

    @FieldName(name = "discount_amount")
    String getDiscountAmount();

    @FieldName(name = "discount_amount_util")
    String getDiscountAmountUtil();

    @FieldName(name = "expired_time")
    Long getExpiredTime();

    @FieldName(name = "sub_title")
    String getSubTitle();

    @FieldName(name = "title")
    String getTitle();

    @FieldName(name = "is_disable")
    boolean isDisable();

    @FieldName(name = "is_selected")
    boolean isSelected();
}
