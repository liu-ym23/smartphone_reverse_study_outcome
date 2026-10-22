package com.bytedance.android.livesdk.end;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import yu1.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001f\u0010 J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0011\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003J3\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\t\u0010\f\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000e\u001a\u00020\rHÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R*\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0013\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b\u001e\u0010\u0017¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdk/end/EndingPageShopCardInfo;", "Lyu1/a;", "", "component1", "", "Lcom/bytedance/android/livesdk/end/ProductItem;", "component2", "component3", "shopSchema", "productItemList", "shopId", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getShopSchema", "()Ljava/lang/String;", "setShopSchema", "(Ljava/lang/String;)V", "Ljava/util/List;", "getProductItemList", "()Ljava/util/List;", "setProductItemList", "(Ljava/util/List;)V", "getShopId", "setShopId", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class EndingPageShopCardInfo extends a {

    @SerializedName("product_list")
    private List<ProductItem> productItemList;

    @SerializedName("shop_id")
    private String shopId;

    @SerializedName("shop_schema")
    private String shopSchema;

    public EndingPageShopCardInfo() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EndingPageShopCardInfo copy$default(EndingPageShopCardInfo r0, String r1, List r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.shopSchema;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.productItemList;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.shopId;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.shopSchema;
    }

    public final List<ProductItem> component2() {
        return this.productItemList;
    }

    public final String component3() {
        return this.shopId;
    }

    public final EndingPageShopCardInfo copy(String r2, List<ProductItem> r3, String r4) {
        return new EndingPageShopCardInfo(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof EndingPageShopCardInfo) == false) goto L12;
        EndingPageShopCardInfo r4 = (EndingPageShopCardInfo) r3;
        if (Intrinsics.areEqual(this.shopSchema, r4.shopSchema) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.productItemList, r4.productItemList) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.shopId, r4.shopId) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r0 = this.shopSchema;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<ProductItem> r4 = this.productItemList;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.shopId;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "EndingPageShopCardInfo(shopSchema=" + this.shopSchema + ", productItemList=" + this.productItemList + ", shopId=" + this.shopId + ")";
    }

    public final List<ProductItem> getProductItemList() {
        return this.productItemList;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final String getShopSchema() {
        return this.shopSchema;
    }

    public final void setProductItemList(List<ProductItem> r1) {
        this.productItemList = r1;
    }

    public final void setShopId(String r1) {
        this.shopId = r1;
    }

    public final void setShopSchema(String r1) {
        this.shopSchema = r1;
    }

    public EndingPageShopCardInfo(String r1, List<ProductItem> r2, String r3) {
        this.shopSchema = r1;
        this.productItemList = r2;
        this.shopId = r3;
    }

    public /* synthetic */ EndingPageShopCardInfo(String r2, List r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
