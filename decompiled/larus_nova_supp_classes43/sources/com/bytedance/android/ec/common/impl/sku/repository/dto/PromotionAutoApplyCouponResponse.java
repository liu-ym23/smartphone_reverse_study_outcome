package com.bytedance.android.ec.common.impl.sku.repository.dto;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/repository/dto/PromotionAutoApplyCouponResponse;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "Ljava/io/Serializable;", "()V", "couponIds", "", "getCouponIds", "()Ljava/lang/String;", a.VALUE_SHOW_TOAST, "getToast", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PromotionAutoApplyCouponResponse extends CommerceBaseResponse {

    @SerializedName("coupon_ids")
    private final String couponIds;

    @SerializedName(a.VALUE_SHOW_TOAST)
    private final String toast;

    public PromotionAutoApplyCouponResponse() {
    }

    public final String getCouponIds() {
        return this.couponIds;
    }

    public final String getToast() {
        return this.toast;
    }
}
