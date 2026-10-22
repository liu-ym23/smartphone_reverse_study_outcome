package com.bytedance.android.livesdk.end;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010%\u001a\u00020\tHÆ\u0003J\t\u0010&\u001a\u00020\tHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J_\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001R&\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014¨\u0006/"}, d2 = {"Lcom/bytedance/android/livesdk/end/ProductItem;", "", "productId", "", LiveEndPageData.TAG_NAME, "imageList", "", "shortTitle", "price", "", "originalPrice", "recommendTag", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;JJLjava/lang/String;)V", "getImageList", "()Ljava/util/List;", "setImageList", "(Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getOriginalPrice", "()J", "setOriginalPrice", "(J)V", "getPrice", "setPrice", "getProductId", "setProductId", "getRecommendTag", "setRecommendTag", "getShortTitle", "setShortTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ProductItem {

    @SerializedName("img_url_list")
    private List<String> imageList;

    @SerializedName(LiveEndPageData.TAG_NAME)
    private String name;

    @SerializedName("market_price")
    private long originalPrice;

    @SerializedName("price")
    private long price;

    @SerializedName("product_id")
    private String productId;

    @SerializedName("recommend_tag")
    private String recommendTag;

    @SerializedName("short_title")
    private String shortTitle;

    public ProductItem() {
        this(null, null, null, null, 0, 0, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProductItem copy$default(ProductItem r10, String r11, String r12, List r13, String r14, long r15, long r17, String r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        String r1 = r10.productId;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r2 = r10.name;
    L11:
        if ((r20 & 4) == 0) goto L13;
        List r3 = r10.imageList;
    L15:
        if ((r20 & 8) == 0) goto L17;
        String r4 = r10.shortTitle;
    L19:
        if ((r20 & 16) == 0) goto L21;
        long r5 = r10.price;
    L23:
        if ((r20 & 32) == 0) goto L25;
        long r7 = r10.originalPrice;
    L27:
        if ((r20 & 64) == 0) goto L29;
        String r9 = r10.recommendTag;
    L31:
        return r10.copy(r1, r2, r3, r4, r5, r7, r9);
    L29:
        r9 = r19;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r5 = r15;
        goto L23
    L17:
        r4 = r14;
        goto L19
    L13:
        r3 = r13;
        goto L15
    L9:
        r2 = r12;
        goto L11
    L5:
        r1 = r11;
        goto L7
    }

    public final String component1() {
        return this.productId;
    }

    public final String component2() {
        return this.name;
    }

    public final List<String> component3() {
        return this.imageList;
    }

    public final String component4() {
        return this.shortTitle;
    }

    public final long component5() {
        return this.price;
    }

    public final long component6() {
        return this.originalPrice;
    }

    public final String component7() {
        return this.recommendTag;
    }

    public final ProductItem copy(String r12, String r13, List<String> r14, String r15, long r16, long r18, String r20) {
        return new ProductItem(r12, r13, r14, r15, r16, r18, r20);
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof ProductItem) == false) goto L20;
        ProductItem r7 = (ProductItem) r6;
        if (Intrinsics.areEqual(this.productId, r7.productId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.name, r7.name) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.imageList, r7.imageList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.shortTitle, r7.shortTitle) == true) goto L14;
        return false;
    L14:
        if (this.price == r7.price) goto L16;
        return false;
    L16:
        if (this.originalPrice == r7.originalPrice) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.recommendTag, r7.recommendTag) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        String r0 = this.productId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.name;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        List<String> r7 = this.imageList;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.shortTitle;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        long r13 = this.price;
        int r14 = (r12 + ((int) (r13 ^ (r13 >>> 32)))) * 31;
        long r15 = this.originalPrice;
        int r16 = (r14 + ((int) (r15 ^ (r15 >>> 32)))) * 31;
        String r17 = this.recommendTag;
        if (r17 == null) goto L22;
        r1 = r17.hashCode();
    L22:
        return r16 + r1;
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "ProductItem(productId=" + this.productId + ", name=" + this.name + ", imageList=" + this.imageList + ", shortTitle=" + this.shortTitle + ", price=" + this.price + ", originalPrice=" + this.originalPrice + ", recommendTag=" + this.recommendTag + ")";
    }

    public final List<String> getImageList() {
        return this.imageList;
    }

    public final String getName() {
        return this.name;
    }

    public final long getOriginalPrice() {
        return this.originalPrice;
    }

    public final long getPrice() {
        return this.price;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getRecommendTag() {
        return this.recommendTag;
    }

    public final String getShortTitle() {
        return this.shortTitle;
    }

    public final void setImageList(List<String> r1) {
        this.imageList = r1;
    }

    public final void setName(String r1) {
        this.name = r1;
    }

    public final void setOriginalPrice(long r1) {
        this.originalPrice = r1;
    }

    public final void setPrice(long r1) {
        this.price = r1;
    }

    public final void setProductId(String r1) {
        this.productId = r1;
    }

    public final void setRecommendTag(String r1) {
        this.recommendTag = r1;
    }

    public final void setShortTitle(String r1) {
        this.shortTitle = r1;
    }

    public ProductItem(String r1, String r2, List<String> r3, String r4, long r5, long r7, String r9) {
        this.productId = r1;
        this.name = r2;
        this.imageList = r3;
        this.shortTitle = r4;
        this.price = r5;
        this.originalPrice = r7;
        this.recommendTag = r9;
    }

    public /* synthetic */ ProductItem(String r11, String r12, List r13, String r14, long r15, long r17, String r19, int r20, DefaultConstructorMarker r21) {
        String r1 = null;
        if ((r20 & 1) == 0) goto L5;
        String r0 = null;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r2 = null;
    L11:
        if ((r20 & 4) == 0) goto L13;
        List r3 = null;
    L15:
        if ((r20 & 8) == 0) goto L17;
        String r4 = null;
    L18:
        long r6 = 0;
        if ((r20 & 16) == 0) goto L21;
        long r8 = 0;
    L23:
        if ((r20 & 32) != 0) goto L27;
        r6 = r17;
    L27:
        if ((r20 & 64) != 0) goto L30;
        r1 = r19;
    L30:
        this(r0, r2, r3, r4, r8, r6, r1);
        return;
    L21:
        r8 = r15;
        goto L23
    L17:
        r4 = r14;
        goto L18
    L13:
        r3 = r13;
        goto L15
    L9:
        r2 = r12;
        goto L11
    L5:
        r0 = r11;
        goto L7
    }
}
