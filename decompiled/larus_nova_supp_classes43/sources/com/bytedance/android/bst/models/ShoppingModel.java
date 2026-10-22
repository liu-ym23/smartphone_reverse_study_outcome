package com.bytedance.android.bst.models;

import com.bytedance.android.bst.api.a;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000e\b\u0017\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\u0006\u0010\u0018\u001a\u00020\u000f¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0001H\u0016R\"\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\"\u0010\u0018\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/bst/models/ShoppingModel;", "Lcom/bytedance/android/bst/api/a;", "Lvc/a;", "errorLogger", "", "checkValid", "", "getTag", "copy", "productId", "Ljava/lang/String;", "getProductId", "()Ljava/lang/String;", "setProductId", "(Ljava/lang/String;)V", "", "isAd", "I", "()I", "setAd", "(I)V", "bstGroupType", "getBstGroupType", "setBstGroupType", "originReport", "getOriginReport", "setOriginReport", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "models_cnRelease"}, k = 1, mv = {1, 4, 0})
public class ShoppingModel extends a {

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_BST_GROUP_TYPE)
    private String bstGroupType;

    @SerializedName("bst_is_ad")
    private int isAd;

    @SerializedName("origin_report")
    private int originReport;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_ID)
    private String productId;

    @Override // com.bytedance.android.bst.api.a
    public a copy() {
        return new ShoppingModel(this.productId, this.isAd, this.bstGroupType, this.originReport);
    }

    public final String getBstGroupType() {
        return this.bstGroupType;
    }

    public final int getOriginReport() {
        return this.originReport;
    }

    public final String getProductId() {
        return this.productId;
    }

    @Override // com.bytedance.android.bst.api.a
    public String getTag() {
        return this.productId;
    }

    public final int isAd() {
        return this.isAd;
    }

    @Override // com.bytedance.android.bst.api.a
    public boolean checkValid(vc.a r10) {
        boolean r11 = true;
        if (this.productId.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        r10.a();
        boolean r1 = false;
    L10:
        if (this.bstGroupType.length() == 0) goto L13;
        r11 = false;
    L13:
        if (r11 == false) goto L16;
        r10.a();
        return false;
    L16:
        return r1;
    L8:
        r1 = true;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    public final void setAd(int r1) {
        this.isAd = r1;
    }

    public final void setBstGroupType(String r1) {
        this.bstGroupType = r1;
    }

    public final void setOriginReport(int r1) {
        this.originReport = r1;
    }

    public final void setProductId(String r1) {
        this.productId = r1;
    }

    public ShoppingModel(String r10, int r11, String r12, int r13) {
        super("ecommerce", "shopping");
        this.productId = r10;
        this.isAd = r11;
        this.bstGroupType = r12;
        this.originReport = r13;
    }
}
