package com.bytedance.android.ec.common.impl.sku.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/model/SkuInstallmentItemInfo;", "Ljava/io/Serializable;", "()V", "discountInfo", "Lcom/bytedance/android/ec/common/impl/sku/model/SkuDiscountInfo;", "getDiscountInfo", "()Lcom/bytedance/android/ec/common/impl/sku/model/SkuDiscountInfo;", "termInfo", "Lcom/bytedance/android/ec/common/impl/sku/model/SkuTermInfo;", "getTermInfo", "()Lcom/bytedance/android/ec/common/impl/sku/model/SkuTermInfo;", "userInfo", "Lcom/bytedance/android/ec/common/impl/sku/model/SkuUserInfo;", "getUserInfo", "()Lcom/bytedance/android/ec/common/impl/sku/model/SkuUserInfo;", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuInstallmentItemInfo implements Serializable {

    @SerializedName("discount_info")
    private final SkuDiscountInfo discountInfo;

    @SerializedName("term_info")
    private final SkuTermInfo termInfo;

    @SerializedName("user_info")
    private final SkuUserInfo userInfo;

    public SkuInstallmentItemInfo() {
    }

    public final SkuDiscountInfo getDiscountInfo() {
        return this.discountInfo;
    }

    public final SkuTermInfo getTermInfo() {
        return this.termInfo;
    }

    public final SkuUserInfo getUserInfo() {
        return this.userInfo;
    }
}
