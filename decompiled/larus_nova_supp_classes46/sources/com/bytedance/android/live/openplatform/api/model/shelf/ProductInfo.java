package com.bytedance.android.live.openplatform.api.model.shelf;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("webcast.data.ProductInfo")
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u001c\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\f\u0010\nR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0014\u0010\u0012\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/model/shelf/ProductInfo;", "Landroid/os/Parcelable;", "", "productId", "Ljava/lang/String;", "title", "imgUrl", "", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ProductIntroductionInfo;", "introductionList", "Ljava/util/List;", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ProductLabelInfo;", "labelList", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ProductPriceInfo;", "price", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ProductPriceInfo;", "actionText", "", "isShow", "Z", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ProductJumpSetting;", "jumpSetting", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ProductJumpSetting;", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductInfo implements Parcelable, h {
    public static final Parcelable.Creator<ProductInfo> CREATOR = null;

    @SerializedName("action_text")
    public String actionText;

    @SerializedName("img_url")
    public String imgUrl;

    @SerializedName("introduction_list")
    public List<ProductIntroductionInfo> introductionList;

    @SerializedName("isShow")
    public boolean isShow;

    @SerializedName("jump_setting")
    public ProductJumpSetting jumpSetting;

    @SerializedName("label_list")
    public List<ProductLabelInfo> labelList;

    @SerializedName("price")
    public ProductPriceInfo price;

    @SerializedName("product_id")
    public String productId;

    @SerializedName("title")
    public String title;

    public static class a implements Parcelable.Creator<ProductInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ProductInfo createFromParcel(Parcel r12) {
            Intrinsics.checkNotNullParameter(r12, "in");
            String r2 = r12.readString();
            String r3 = r12.readString();
            String r4 = r12.readString();
            if (r12.readInt() == 0) goto L7;
            int r1 = r12.readInt();
            ArrayList r6 = new ArrayList(r1);
        L5:
            if (r1 == 0) goto L9;
            r6.add(ProductIntroductionInfo.CREATOR.createFromParcel(r12));
            r1 = r1 - 1;
        L9:
            if (r12.readInt() == 0) goto L13;
            int r5 = r12.readInt();
            ArrayList r7 = new ArrayList(r5);
        L11:
            if (r5 == 0) goto L15;
            r7.add(ProductLabelInfo.CREATOR.createFromParcel(r12));
            r5 = r5 - 1;
        L15:
            if (r12.readInt() == 0) goto L17;
            ProductPriceInfo r8 = ProductPriceInfo.CREATOR.createFromParcel(r12);
        L18:
            String r9 = r12.readString();
            if (r12.readInt() == 0) goto L21;
            boolean r10 = true;
        L23:
            if (r12.readInt() == 0) goto L25;
            ProductJumpSetting r13 = ProductJumpSetting.CREATOR.createFromParcel(r12);
        L27:
            return new ProductInfo(r2, r3, r4, r6, r7, r8, r9, r10, r13);
        L25:
            r13 = null;
            goto L27
        L21:
            r10 = false;
            goto L23
        L17:
            r8 = null;
            goto L18
        L13:
            r7 = null;
            goto L15
        L7:
            r6 = null;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final ProductInfo[] newArray(int r1) {
            return new ProductInfo[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public ProductInfo(String r1, String r2, String r3, List<ProductIntroductionInfo> r4, List<ProductLabelInfo> r5, ProductPriceInfo r6, String r7, boolean r8, ProductJumpSetting r9) {
        this.productId = r1;
        this.title = r2;
        this.imgUrl = r3;
        this.introductionList = r4;
        this.labelList = r5;
        this.price = r6;
        this.actionText = r7;
        this.isShow = r8;
        this.jumpSetting = r9;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ProductInfo) == false) goto L24;
        ProductInfo r4 = (ProductInfo) r3;
        if (Intrinsics.areEqual(this.productId, r4.productId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.title, r4.title) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.imgUrl, r4.imgUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.introductionList, r4.introductionList) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.labelList, r4.labelList) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.price, r4.price) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.actionText, r4.actionText) == true) goto L20;
        return false;
    L20:
        if (this.isShow == r4.isShow) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.jumpSetting, r4.jumpSetting) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v19, types: [int] */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v28 */
    public final int hashCode() {
        String r0 = this.productId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.title;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.imgUrl;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        List<ProductIntroductionInfo> r10 = this.introductionList;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        List<ProductLabelInfo> r13 = this.labelList;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        ProductPriceInfo r16 = this.price;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.actionText;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        boolean r22 = this.isShow;
        ?? r23 = r22;
        if (r22 == false) goto L33;
        r23 = 1;
    L33:
        int r24 = (r21 + r23) * 31;
        ProductJumpSetting r25 = this.jumpSetting;
        if (r25 == null) goto L37;
        r1 = r25.hashCode();
    L37:
        return r24 + r1;
    L29:
        r20 = 0;
        goto L30
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
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

    public final String toString() {
        return "ProductInfo(productId=" + this.productId + ", title=" + this.title + ", imgUrl=" + this.imgUrl + ", introductionList=" + this.introductionList + ", labelList=" + this.labelList + ", price=" + this.price + ", actionText=" + this.actionText + ", isShow=" + this.isShow + ", jumpSetting=" + this.jumpSetting + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parcel");
        r4.writeString(this.productId);
        r4.writeString(this.title);
        r4.writeString(this.imgUrl);
        List<ProductIntroductionInfo> r6 = this.introductionList;
        if (r6 == null) goto L8;
        r4.writeInt(1);
        r4.writeInt(r6.size());
        Iterator<ProductIntroductionInfo> r7 = r6.iterator();
    L6:
        if (r7.hasNext() == false) goto L9;
        r7.next().writeToParcel(r4, 0);
    L9:
        List<ProductLabelInfo> r8 = this.labelList;
        if (r8 == null) goto L15;
        r4.writeInt(1);
        r4.writeInt(r8.size());
        Iterator<ProductLabelInfo> r9 = r8.iterator();
    L13:
        if (r9.hasNext() == false) goto L16;
        r9.next().writeToParcel(r4, 0);
    L16:
        ProductPriceInfo r10 = this.price;
        if (r10 == null) goto L19;
        r4.writeInt(1);
        r10.writeToParcel(r4, 0);
    L20:
        r4.writeString(this.actionText);
        r4.writeInt(this.isShow ? 1 : 0);
        ProductJumpSetting r11 = this.jumpSetting;
        if (r11 == null) goto L23;
        r4.writeInt(1);
        r11.writeToParcel(r4, 0);
        return;
    L23:
        r4.writeInt(0);
        return;
    L19:
        r4.writeInt(0);
        goto L20
    L15:
        r4.writeInt(0);
        goto L16
    L8:
        r4.writeInt(0);
        goto L9
    }

    public ProductInfo() {
        this.productId = null;
        this.title = null;
        this.imgUrl = null;
        this.introductionList = null;
        this.labelList = null;
        this.price = null;
        this.actionText = null;
        this.isShow = false;
        this.jumpSetting = null;
    }

    public ProductInfo(am3.g r7) {
        this.introductionList = new ArrayList();
        this.labelList = new ArrayList();
        long r0 = r7.c();
        boolean r3 = false;
    L3:
        int r4 = r7.f();
        if (r4 == (-1)) goto L17;
        switch(r4) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            default: goto L6;
        };
    L7:
        this.jumpSetting = new ProductJumpSetting(r7);
        goto L3
    L8:
        this.isShow = am3.h.a(r7);
        r3 = r3 | true;
        goto L3
    L9:
        this.actionText = am3.h.c(r7);
        goto L3
    L10:
        this.price = new ProductPriceInfo(r7);
        goto L3
    L11:
        List r5 = this.labelList;
        h r6 = new ProductLabelInfo(r7);
    L13:
        r5.add(r6);
        goto L3
    L12:
        r5 = this.introductionList;
        r6 = new ProductIntroductionInfo(r7);
        goto L13
    L14:
        this.imgUrl = am3.h.c(r7);
        goto L3
    L15:
        this.title = am3.h.c(r7);
        goto L3
    L16:
        this.productId = am3.h.c(r7);
        goto L3
    L6:
        am3.h.e(r7);
        goto L3
    L17:
        r7.d(r0);
        if (this.productId != null) goto L21;
        this.productId = null;
    L21:
        if (this.title != null) goto L24;
        this.title = null;
    L24:
        if (this.imgUrl != null) goto L27;
        this.imgUrl = null;
    L27:
        if (this.introductionList.isEmpty() == false) goto L30;
        this.introductionList = null;
    L30:
        if (this.labelList.isEmpty() == false) goto L33;
        this.labelList = null;
    L33:
        if (this.price != null) goto L36;
        this.price = null;
    L36:
        if (this.actionText != null) goto L39;
        this.actionText = null;
    L39:
        if ((r3 & true) == true) goto L42;
        this.isShow = false;
    L42:
        if (this.jumpSetting != null) goto L66;
        this.jumpSetting = null;
        return;
    }
}
