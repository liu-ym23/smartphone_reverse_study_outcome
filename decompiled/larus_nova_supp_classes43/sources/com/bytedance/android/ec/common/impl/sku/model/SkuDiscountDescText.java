package com.bytedance.android.ec.common.impl.sku.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/model/SkuDiscountDescText;", "Ljava/io/Serializable;", "()V", "highlightItems", "", "Lcom/bytedance/android/ec/common/impl/sku/model/SkuHighlightItem;", "getHighlightItems", "()Ljava/util/List;", "text", "", "getText", "()Ljava/lang/String;", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuDiscountDescText implements Serializable {

    @SerializedName("high_light_items")
    private final List<SkuHighlightItem> highlightItems;

    @SerializedName("text")
    private final String text;

    public SkuDiscountDescText() {
    }

    public final List<SkuHighlightItem> getHighlightItems() {
        return this.highlightItems;
    }

    public final String getText() {
        return this.text;
    }
}
