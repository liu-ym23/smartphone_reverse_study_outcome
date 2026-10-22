package com.bytedance.android.ec.common.impl.sku.model;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0013\u0010\nR\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000fR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/model/SkuTermInfoItem;", "Ljava/io/Serializable;", "()V", "descText", "Lcom/bytedance/android/ec/common/impl/sku/model/SkuDiscountDescText;", "getDescText", "()Lcom/bytedance/android/ec/common/impl/sku/model/SkuDiscountDescText;", "highLightFlag", "", "getHighLightFlag", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "itemId", "", "getItemId", "()Ljava/lang/String;", "serviceLabel", "getServiceLabel", "showTopTag", "getShowTopTag", "termCount", "", "getTermCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "termDetail", "getTermDetail", "topTag", "getTopTag", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuTermInfoItem implements Serializable {

    @SerializedName("desc_text")
    private final SkuDiscountDescText descText;

    @SerializedName("high_light_flag")
    private final Boolean highLightFlag;

    @SerializedName(a.KEY_ITEM_ID)
    private final String itemId;

    @SerializedName("service_label")
    private final String serviceLabel;

    @SerializedName("show_top_tag")
    private final Boolean showTopTag;

    @SerializedName("term_count")
    private final Integer termCount;

    @SerializedName("term_detail")
    private final String termDetail;

    @SerializedName("top_tag")
    private final String topTag;

    public SkuTermInfoItem() {
    }

    public final SkuDiscountDescText getDescText() {
        return this.descText;
    }

    public final Boolean getHighLightFlag() {
        return this.highLightFlag;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final String getServiceLabel() {
        return this.serviceLabel;
    }

    public final Boolean getShowTopTag() {
        return this.showTopTag;
    }

    public final Integer getTermCount() {
        return this.termCount;
    }

    public final String getTermDetail() {
        return this.termDetail;
    }

    public final String getTopTag() {
        return this.topTag;
    }
}
